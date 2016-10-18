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
import org.apache.commons.lang.StringUtils;
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
import com.trs.rms.base.security.encoder.PwdEncoder;
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
	
	@Autowired
	private PwdEncoder pwdEncoder;

	//查询方法(首次查询)
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

	//查看某一条数据详细信息的方法
	@RequestMapping("/view.do")
	public  String   view(Long  id,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		RmsCorporateUser corporateUser=(RmsCorporateUser) service.queryById(RmsCorporateUser.class, id);
		model.addAttribute("corporateUser", corporateUser);
		return "company/view";
	}
	
	//编辑某一条数据的方法，之后进入编辑页
	@RequestMapping("/v_edit.do")
	public  String   editpage(Long  id,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		RmsCorporateUser corporateUser=(RmsCorporateUser) service.queryById(RmsCorporateUser.class, id);
		model.addAttribute("corporateUser", corporateUser);
		return "company/edit";
	}
	
	//编辑某一条数据的方法，提交后将修改数据库信息
	@RequestMapping(value={"/edit.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public   String   edit(
			Long  id,
			String  corporateName,
			String  corporateTel,
			String corporateMobile,
			String corporateEmail,
			String corporateInf,
			Integer userState,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		RmsCorporateUser corporateUser=(RmsCorporateUser) service.queryById(RmsCorporateUser.class, id);
				if(corporateUser!=null){
					corporateUser.setUpdateTime(new Date());
					corporateUser.setCorporateName(corporateName);
					corporateUser.setCorporateTel(corporateTel);
					corporateUser.setCorporateMobile(corporateMobile);
					corporateUser.setCorporateEmail(corporateEmail);
					corporateUser.setCorporateInf(corporateInf);
					corporateUser.getRmsUser().setUserState(userState);					
					service.update(corporateUser);
				}
		return "redirect:/admin/rmsCorporateUser/list.do";
	}
	
	//删除方法
	@RequestMapping(value={"/delete.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public void delete(HttpServletRequest request,HttpServletResponse response,Long userId) throws JSONException{

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
	
	//判断注册时是否已存在该登录名或者企业名称
	@RequestMapping(value={"/a_username.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public   void   ajaxUsername(
			String  username,
			String corporateUserName,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model) throws JSONException{

		JSONObject json = new JSONObject();
		json.put("exist", false);
	    if(!StringUtils.isBlank(username)&&!StringUtils.isBlank(corporateUserName)){
			json.put("exist", service.isExist(username,corporateUserName));
	    }
		ResponseUtils.renderJson(response,json.toString());

	}
	
	//保存企业用户到RmsUser和RmsCorporateUser表中
	@RequiresPermissions({"admin:user:add"})
	@RequestMapping(value={"/save.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public  String   save(
			String  username,
			String corporateUserName,
			String  userpassword,
			String  tel,
			String  mobile,
			String  email,
			String  _info,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		
		String  loginName=SysUtils.getLoginName();
		RmsUser rmsUser = new RmsUser();
		//设置用户表中参数
		rmsUser.setLoginName(username);
    	rmsUser.setUserPawd(pwdEncoder.encodePassword(userpassword));
    	rmsUser.setNickName("企业用户");
    	rmsUser.setUserState(1);
    	rmsUser.setUserInfo("");
    	rmsUser.setCreateTime(new Date());
    	rmsUser.setUpdateTime(new Date());
    	rmsUser.setCreateUser(loginName);
    	rmsUser.setUpdateUser(loginName);
    	rmsUser.setEmail(email);
    	rmsUser.setMobile(mobile);
    	rmsUser.setFailCount(0);
    	rmsUser.setUserType(2);
    	//调用自定义方法保存企业用户信息到表格中
    	service.saveCorporateUser(rmsUser,corporateUserName,tel,mobile,email,_info);
		return "redirect:/admin/rmsCorporateUser/list.do";
	}
	
}
