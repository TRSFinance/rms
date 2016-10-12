package com.trs.rms.company.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.trs.rms.base.page.Param;
import com.trs.rms.base.util.SysUtils;
import com.trs.rms.company.bean.RmsCompanyInfo;
import com.trs.rms.company.bean.RmsCorporateUser;
import com.trs.rms.company.page.RmsCompanyPage;
import com.trs.rms.company.page.RmsCorporateUserPage;
import com.trs.rms.company.service.RmsCompanyInfoService;
import com.trs.rms.usermgr.bean.RmsUser;

@Controller
@RequestMapping("/rmsCompanyInfo")
public class RmsCompanyInfoAct {
	
	
	@Autowired
	private  RmsCompanyPage   page;
	
	@Autowired
	private  RmsCorporateUserPage   page2;

	@Autowired
	private RmsCompanyInfoService service;
	

	//测试
	@RequiresPermissions({"admin:role:test2"})
	@RequestMapping(value={"/ceshi.do"})
	public  String   list(ModelAndView model){
		List<RmsCorporateUser> list = service.list();
		Map map = new HashMap();
		
		model.addObject("abc", map);
		return "../ceshi/receiveData";
	}
	
	//自定义的查询后台数据方法
	@RequiresPermissions({"admin:role:test2"})
	@RequestMapping(value={"/list2.do"})
		public  ModelAndView   list2(Model model){
			List<RmsCorporateUser> list = service.list();
			Map map = new HashMap();
			List list2 = new ArrayList();		
			for(int i=0;i<list.size();i++){
				Map map2 = new HashMap();
				map2.put("corporateName", list.get(i).getCorporateName());
				list2.add(map2);
			}	
			map.put("cool", list2);		
			return new ModelAndView(new MappingJackson2JsonView(),map);
		} 
	
	//add
	//v_edit
	//edit
	//del
	//query
	
	//通用的查询方法(首次查询)
	@RequiresPermissions({"admin:role:test2"})
	@RequestMapping("/list.do")
	public  String   list(HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		
		String  loginName=SysUtils.getLoginName();
		System.out.println("-----"+loginName);
		
		List list = page.queryObjectsToPages();
		//List list2 = page2.queryObjectsToPages();
		model.addAttribute("page", page);
		model.addAttribute("data", list);
		//model.addAttribute("data2",list2);
		return "company/companyInfo/companyManager";
	}
	
//	@RequiresPermissions({"admin:role:test2"})
//	@RequestMapping("/list2.do")
//	public  String   leftList(HttpServletRequest request,HttpServletResponse response,
//			ModelMap model){
//		List list = page2.queryObjectsToPages();
//		//model.addAttribute("page2", page2);
//		model.addAttribute("data2", list);
//		return "company/companyManager";
//	}
	
	//通用的查询方法(输入搜索词查询)
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
		model.addAttribute("page", page);
		model.addAttribute("data", list);
		return "company/companyInfo/companyManager";
	}
	
	

	
	//修改一条记录
	@RequestMapping(value=("/update.do"),method={org.springframework.web.bind.annotation.RequestMethod.GET})
	public void update(HttpServletRequest request,HttpServletResponse response,String cust_id,String param1,String param2,String param3,String param4){
		System.out.println(cust_id);
		System.out.println(param1);
		System.out.println(param2);
		System.out.println(param3);
		System.out.println(param4);
		List list = new ArrayList();		
		list.add(new Param(Types.VARCHAR,param1));
		list.add(new Param(Types.VARCHAR,param2));
		list.add(new Param(Types.VARCHAR,param3));
		list.add(new Param(Types.VARCHAR,param4));
		list.add(new Param(Types.BIGINT,Long.parseLong(cust_id)));		
		service.updateData(list);
		
	}
	
	@RequestMapping("/view.do")
	public  String   view(Long  id,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		RmsCompanyInfo compInfo=(RmsCompanyInfo) service.queryById(RmsCompanyInfo.class, id);
		model.addAttribute("compInfo", compInfo);
		return "company/companyInfo/view";
	}
	
	@RequestMapping("/v_edit.do")
	public  String   editpage(Long  id,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		RmsCompanyInfo compInfo=(RmsCompanyInfo) service.queryById(RmsCompanyInfo.class, id);
		model.addAttribute("compInfo", compInfo);
		return "company/companyInfo/edit";
	}
	
	@RequestMapping(value={"/edit.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public   String   edit(
			Long  custid,
			String  custIndustry1,
			String  custIndustry2,
			Integer dataSource,
			Integer  state, 
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		RmsCompanyInfo compInfo=(RmsCompanyInfo) service.queryById(RmsCompanyInfo.class, custid);
		//String  loginName=SysUtils.getLoginName();
				if(compInfo!=null){
		    	compInfo.setChangeTime(new Date());;
		    	compInfo.setCustIndustry1(custIndustry1);;
		    	compInfo.setCustIndustry2(custIndustry2);;
		    	compInfo.setDataSource(dataSource);;
		    	compInfo.setState(state);
				service.save(compInfo);
				}
		return "redirect:/admin/rmsCompanyInfo/list.do";
	}
	
	//通用的删除方法(输入搜索词查询)
		@RequestMapping(value={"/delete.do"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
		public String delete(HttpServletRequest request,HttpServletResponse response,Long custid){

			System.out.println(custid);
			
//			Long[] ids = {Long.parseLong(cust_id)};
//			
//			service.delete(RmsCompanyInfo.class, ids);
			
			RmsCompanyInfo compInfo=(RmsCompanyInfo) service.queryById(RmsCompanyInfo.class, custid);
			//String  loginName=SysUtils.getLoginName();
					if(compInfo!=null){
			    	compInfo.setChangeTime(new Date());;			    	
			    	compInfo.setState(-1);
					service.save(compInfo);
					}
			return "redirect:/admin/rmsCompanyInfo/list.do";
			
		
		}
	
	
	
	//上传文件
	@RequestMapping(value=("/filetodb.do"),method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public void filetodb(HttpServletRequest request,HttpServletResponse response){
		System.out.println("上传文件");
		// 判断form是否为上传表单
		if (!ServletFileUpload.isMultipartContent(request)) {
			throw new RuntimeException("该请求不是有效编码方式！");
		}
		
		
		// 创建文件项工厂
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		// 创建核心解析器
		ServletFileUpload fileUpload = new ServletFileUpload(
				diskFileItemFactory);
		// 处理上传文件名乱码
		fileUpload.setHeaderEncoding("utf-8");
		
		String uuidname = "";
		String savepath = "";
		// 解析请求request
		try {
			List<FileItem> fileItems = fileUpload.parseRequest(request);
			// 遍历每个FileItem
			for (FileItem fileItem : fileItems) {
			
				// 判断fileItem是否为文件上传
				if (fileItem.isFormField()) {
					// 不是上传项
					String name = fileItem.getFieldName();
					
					
					
					
				} else {
					// 是上传项
					// 判断用户有没有上传
					String filename = fileItem.getName();
					
					//lm
					System.out.println("----------"+filename);
					
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
					
					System.out.println("request.getContextPath()---"+request.getContextPath());
					
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
		
		insertFiletoDb(request,savepath,uuidname);
		// 提示用户文件上传成功
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().println("文件上传成功！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	
	public void insertFiletoDb(HttpServletRequest request,String savepath,String uuidname){
		
		List list = new ArrayList();
		

		for(int i=0;i<2;i++){
	
			RmsCompanyInfo rci = new RmsCompanyInfo();
			rci.setCustCfname("test");
			rci.setCustCsname("test");
			rci.setCustOrgid("123");
			rci.setCustEfname("111");
			rci.setCustEsname("123");
			rci.setCustIndustry1("222");
			rci.setCustIndustry2("1112");
			rci.setAreaCode("122");
			rci.setDistrictName("2222");
			rci.setProvinceName("122");
			rci.setCityName("122");
			rci.setCustIndustrycode("122");
			rci.setPinyin("a");
	//		rci.setState(1);
			rci.setCreateTime(new Date());
			rci.setChangeTime(new Date());
			list.add(rci);
		}
	
		service.add(list);
		
		
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(request.getServletContext().getRealPath(savepath)+"\\"+uuidname);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(inputStream);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet(0);
		//行数
		int rows=sheet.getRows();
		//列数
		int cols=sheet.getColumns();
		
		//int  location =Integer.parseInt(getContent());
		
		for (int i = 0; i < rows; i++) {
			Cell cell = sheet.getCell(0, i);
			if(cell!=null){
				String value = cell.getContents();
				if(value!=null&&!"".equals(value)){
					System.out.println(value.trim());
				}
				
			}
			
		}
		
		try {
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
