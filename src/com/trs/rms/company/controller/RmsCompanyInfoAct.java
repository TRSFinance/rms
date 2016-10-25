package com.trs.rms.company.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trs.rms.company.bean.RmsCompanyInfo;
import com.trs.rms.company.bean.RmsCorporateUser;
import com.trs.rms.company.page.RmsCompanyPage;
import com.trs.rms.company.service.RmsCompanyInfoService;

@Controller
@RequestMapping("/rmsCompanyInfo")
public class RmsCompanyInfoAct {
	
	
	@Autowired
	private  RmsCompanyPage   page;
	
	@Autowired
	private RmsCompanyInfoService service;
	
	//设置一个存放当前查询userId的参数,提供给上传文件时使用
	Long publicUserId;

	
	//查询方法(首次查询)
	@RequiresPermissions({"admin:companyInfo:query"})
	@RequestMapping("/list.do")
	public  String   list(HttpServletRequest request,HttpServletResponse response,
			ModelMap model,Long userId){
		
		publicUserId = userId;
		page.setUserId(userId);	
		page.setPageNo(1);
		List list = page.queryObjectsToPages();
//		List<RmsCorporateUser> list2 = service.query();
		model.addAttribute("page", page);
		model.addAttribute("data", list);
//		model.addAttribute("data2",list2);
		return "company/companyInfo/list";
	}

	//查询方法(输入搜索词后的查询)
	@RequiresPermissions({"admin:companyInfo:query"})
	@RequestMapping("/v_list.do")
	public  String   pagelist(Integer pageSize,Integer pageNo,String username,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		if(pageSize>0)
		page.setPageSize(pageSize);
		if(pageNo>0)
		page.setPageNo(pageNo);
		page.setSearchword(username);
		List list = page.queryObjectsToPages();
//		List<RmsCorporateUser> list2 = service.query();
		model.addAttribute("page", page);
		model.addAttribute("data", list);
//		model.addAttribute("data2",list2);
		return "company/companyInfo/list";
	}

	//查看某一条数据详细信息的方法
	@RequiresPermissions({"admin:companyInfo:view"})
	@RequestMapping("/view.do")
	public  String   view(Long  id,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		RmsCompanyInfo compInfo=(RmsCompanyInfo) service.queryById(RmsCompanyInfo.class, id);
		model.addAttribute("compInfo", compInfo);
		return "company/companyInfo/view";
	}
	
	//编辑某一条数据的方法，之后进入编辑页
	@RequestMapping("/v_edit.do")
	public  String   editpage(Long  id,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		RmsCompanyInfo compInfo=(RmsCompanyInfo) service.queryById(RmsCompanyInfo.class, id);
		model.addAttribute("compInfo", compInfo);
		return "company/companyInfo/edit";
	}
	
	//编辑某一条数据的方法，提交后将修改数据库信息
	@RequiresPermissions({"admin:companyInfo:edit"})
	@RequestMapping(value={"/edit.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public   String   edit(
			Long  custid,
			String  custCfname,
			String  custCsname,
			Integer dataSource,
			Integer  state, 
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
			
		RmsCompanyInfo compInfo=(RmsCompanyInfo) service.queryById(RmsCompanyInfo.class, custid);
		if(compInfo!=null){
	    	compInfo.setChangeTime(new Date());
	    	compInfo.setCustCfname(custCfname);
	    	compInfo.setCustCsname(custCsname);
	    	compInfo.setDataSource(dataSource);
	    	compInfo.setState(state);
			service.update(compInfo);
		}
		if(publicUserId==null){
			return "redirect:/admin/rmsCompanyInfo/list.do";		
		}	
		return "redirect:/admin/rmsCompanyInfo/list.do?userId="+publicUserId;
	}
	
	//删除方法
	@RequiresPermissions({"admin:companyInfo:del"})
	@RequestMapping(value={"/delete.do"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	public String delete(HttpServletRequest request,HttpServletResponse response,Long custId){

		service.deleteRmsCorporateCust(custId,publicUserId);	
		
		return "redirect:/admin/rmsCompanyInfo/list.do";
	}
	
	//上传文件
	@RequiresPermissions({"admin:companyInfo:upload"})
	@RequestMapping(value=("/upload.do"),method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public void filetodb(HttpServletRequest request,HttpServletResponse response,Long userId){
		//System.out.println("准备上传文件");
		userId=publicUserId;
		// 判断form是否为上传表单
		if (!ServletFileUpload.isMultipartContent(request)) {
			throw new RuntimeException("该请求不是有效编码方式！");
		}
		// 创建文件项工厂
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		// 创建核心解析器
		ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
		// 处理上传文件名乱码
		fileUpload.setHeaderEncoding("utf-8");		
		String uuidname = "";
		String savepath = "";
		// 解析请求request
		try {
			@SuppressWarnings("unchecked")
			List<FileItem> fileItems = fileUpload.parseRequest(request);
			// 遍历每个FileItem
			for (FileItem fileItem : fileItems) {			
				// 判断fileItem是否为文件上传
				if (fileItem.isFormField()) {
					// 不是上传项
					//String name = fileItem.getFieldName();						
				} else {
					// 是上传项
					// 判断用户有没有上传
					String filename = fileItem.getName();
					if (filename == null || filename.trim().length() == 0) {
						throw new RuntimeException("必须要上传文件！");
					}
					// 上传文件名中是否包含 文件路径
					int index = filename.lastIndexOf("\\");
					
					if (index != -1) {
						filename = filename.substring(index + 1);								
					}
					// 控制文件名唯一
					uuidname = generateUUIDFilename(filename);
					// 生成hashcode 分散目录
					//String randomDir = UploadUtils.generateRandomDir(uuidname);				
					//lm 按当天日期动态生成目录
					String path = new SimpleDateFormat("yyyyMMdd").format(new Date());					
					// 创建随机目录
					savepath = "/WEB-INF/upload/" + path;
					System.out.println(request.getServletContext().getRealPath(savepath));
					File dirFile = new File(request.getServletContext().getRealPath(savepath));
					if(!dirFile.exists()){
						System.out.println("文件夹不存在，正在创建");
						dirFile.mkdirs();			
					}					
					// 上传文件内容
					InputStream in = new BufferedInputStream(fileItem.getInputStream());
					OutputStream out = new BufferedOutputStream(new FileOutputStream(new File(dirFile, uuidname)));
					int b;
					while ((b = in.read()) != -1) {
						out.write(b);
					}					
					in.close();
					out.close();
					// 删除临时文件，默认内存区 10K
					fileItem.delete();					
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
			throw new RuntimeException("文件上传失败！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 				
		boolean status = service.insertFiletoDb(request,savepath,uuidname,userId);		
		if(status==true){			
			// 提示用户文件上传成功
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().println("文件上传成功！");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			// 提示用户文件上传失败
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().println("文件上传失败,请选择某一个企业用户进行上传！");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	

	
	
	/**
	 * 根据真实文件名 生成uuidname
	 */
	public static String generateUUIDFilename(String filename) {
		String uuid = UUID.randomUUID().toString();
		// 不想保留源文件名 --- 保留源文件扩展名
		String ext = filename.substring(filename.lastIndexOf("."));
		return uuid + ext;
	}
	
	
	
	
}
