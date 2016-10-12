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
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.trs.rms.base.page.Param;
import com.trs.rms.base.util.ResponseUtils;
import com.trs.rms.base.util.SysUtils;
import com.trs.rms.company.bean.RmsCompanyInfo;
import com.trs.rms.company.bean.RmsCorporateUser;
import com.trs.rms.company.page.RmsCorporateUserPage;
import com.trs.rms.company.service.RmsCorporateUserService;
import com.trs.rms.usermgr.bean.RmsUser;


@Controller
@RequestMapping("/rmsCorporateUser")
public class RmsCorporateUserAct {
	
	
	@Autowired
	private  RmsCorporateUserPage   page;

	@Autowired
	private RmsCorporateUserService service;
	

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
			for(int i=0;i<5;i++){
				Map map2 = new HashMap();
//				map2.put("CustCfname", list.get(i).getCustCfname());
//				map2.put("CustCsname", list.get(i).getCustCsname());
//				map2.put("CustIndustry1", list.get(i).getCustIndustry1());
//				map2.put("CustIndustry2", list.get(i).getCustIndustry2());
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
		List list = page.queryObjectsToPages();
		model.addAttribute("page", page);
		model.addAttribute("data", list);
		return "company/list";
	}
	
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
		return "company/list";
	}
	
	//通用的删除方法(输入搜索词查询)
	@RequestMapping(value={"/delete.do"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	public void delete(HttpServletRequest request,HttpServletResponse response,String cust_id){
//		request.getAttribute("deletecomp");
//		System.out.println(request.getAttribute("deletecomp"));
		
		System.out.println(cust_id);
		
		Long[] ids = {Long.parseLong(cust_id)};
		
		service.delete(RmsCorporateUser.class, ids);
		
	
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
		RmsCorporateUser corporateUser=(RmsCorporateUser) service.queryById(RmsCorporateUser.class, id);
		model.addAttribute("corporateUser", corporateUser);
		return "company/view";
	}
	
	@RequestMapping("/v_edit.do")
	public  String   editpage(Long  id,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		RmsCorporateUser corporateUser=(RmsCorporateUser) service.queryById(RmsCorporateUser.class, id);
		model.addAttribute("corporateUser", corporateUser);
		return "company/edit";
	}
	
	@RequestMapping(value={"/edit.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public   String   edit(
			Long  id,
			String  corporateName,
			String  corporateTel,
			String corporateMobile,
			String corporateEmail,
			String corporateInf,			
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		RmsCorporateUser corporateUser=(RmsCorporateUser) service.queryById(RmsCorporateUser.class, id);
		//String  loginName=SysUtils.getLoginName();
				if(corporateUser!=null){
					corporateUser.setUpdateTime(new Date());
					corporateUser.setCorporateName(corporateName);
					corporateUser.setCorporateTel(corporateTel);
					corporateUser.setCorporateMobile(corporateMobile);
					corporateUser.setCorporateEmail(corporateEmail);
					corporateUser.setCorporateInf(corporateInf);
					service.save(corporateUser);
				}
		return "redirect:/admin/rmsCorporateUser/list.do";
	}
	
	
	@RequestMapping(value={"/delete.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public void delete(HttpServletRequest request,HttpServletResponse response,Long userId) throws JSONException{

		
//		Long[] ids = {Long.parseLong(cust_id)};
//		
//		service.delete(RmsCompanyInfo.class, ids);
		JSONObject json = new JSONObject();
		json.put("success", true);
		String  loginName=SysUtils.getLoginName();
		RmsUser user=(RmsUser) service.queryById(RmsUser.class, userId);
		if(user!=null){
			if("admin".equals(user.getLoginName())||"root".equals(user.getLoginName())){
			json.put("success", false);
			}else{
			user.setUpdateTime(new Date());
			user.setUserState(2);;
			user.setUpdateUser(loginName);
			service.update(user);
			}
		
		}
		ResponseUtils.renderJson(response,json.toString());
		
	
	}
	
	
	
	
	
}
