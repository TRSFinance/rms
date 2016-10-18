package com.trs.rms.usermgr.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trs.rms.base.security.encoder.PwdEncoder;
import com.trs.rms.base.util.ResponseUtils;
import com.trs.rms.base.util.SysUtils;
import com.trs.rms.usermgr.bean.RmsRole;
import com.trs.rms.usermgr.bean.RmsUser;
import com.trs.rms.usermgr.page.RmsUserPage;
import com.trs.rms.usermgr.service.RmsUserService;
@Controller
@RequestMapping("/rmsUser")
public class RmsUserAct {
	
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
		return "user/list";
	}
	@RequiresPermissions({"admin:user:query"})
	@RequestMapping("/list.do")
	public  String   list(HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		List list = page.queryObjectsToPages();
		model.addAttribute("page", page);
		model.addAttribute("data", list);
		return "user/list";
	}
	@RequiresPermissions({"admin:user:view"})
	@RequestMapping("/view.do")
	public  String   view(Long  id,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		RmsUser user=(RmsUser) service.queryById(RmsUser.class, id);
		model.addAttribute("user", user);
		return "user/view";
	}
	
	@RequiresPermissions({"admin:user:add"})
	@RequestMapping(value={"/save.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public  String   save(
			String  username,
			String  userpassword,
			String  userpassword2,
			String  moblie,
			String  email,
			String  nickname,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
				String  loginName=SysUtils.getLoginName();
		        RmsUser  rmsUser=new RmsUser();
		    	rmsUser.setLoginName(username);;
		    	rmsUser.setUserPawd(pwdEncoder.encodePassword(userpassword));;
		    	rmsUser.setNickName(nickname);;
		    	rmsUser.setUserState(1);;
		    	rmsUser.setUserInfo("");;
		    	rmsUser.setCreateTime(new Date());;
		    	rmsUser.setUpdateTime(new Date());;
		    	rmsUser.setCreateUser(loginName);;
		    	rmsUser.setUpdateUser(loginName);;
		    	rmsUser.setEmail(email);;
		    	rmsUser.setMobile(moblie);;
		    	rmsUser.setFailCount(0);
		    	rmsUser.setUserType(1);;
				if(!service.isExist(username))
				service.save(rmsUser);
		
		return "redirect:/admin/rmsUser/list.do";
	}
	@RequestMapping("/v_edit.do")
	public  String   editpage(Long  id,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		RmsUser user=(RmsUser) service.queryById(RmsUser.class, id);
		model.addAttribute("user", user);
		return "user/edit";
	}
	
	@RequiresPermissions({"admin:user:edit"})
	@RequestMapping(value={"/edit.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public   String   edit(
			Long  id,
			String  moblie,
			String  email,
			String  nickname,
			Integer  userState, 
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		RmsUser rmsUser=(RmsUser) service.queryById(RmsUser.class, id);
		String  loginName=SysUtils.getLoginName();
				if(rmsUser!=null){
		    	rmsUser.setUpdateTime(new Date());;
		    	rmsUser.setUpdateUser(loginName);;
		    	rmsUser.setEmail(email);;
		    	rmsUser.setNickName(nickname);
		    	rmsUser.setMobile(moblie);;
		    	rmsUser.setUserState(userState);
				service.save(rmsUser);
				}
		return "redirect:/admin/rmsUser/list.do";
	}
	
	@RequiresPermissions({"admin:user:del"})
	@RequestMapping("/a_del.do")
	public   void   ajaxDel(Long  userId,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model) throws JSONException{
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
	@RequestMapping("/a_stop.do")
	public   void   ajaxStop(Long  userId,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model) throws JSONException{
		JSONObject json = new JSONObject();
		json.put("success", true);
		String  loginName=SysUtils.getLoginName();
		RmsUser user=(RmsUser) service.queryById(RmsUser.class, userId);
		if(user!=null){
			user.setUpdateTime(new Date());
			user.setUserState(3);;
			user.setUpdateUser(loginName);
			service.update(user);
		}
		ResponseUtils.renderJson(response,json.toString());
	}
	
	
	
	
	
	@RequestMapping(value={"/a_username.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public   void   ajaxUsername(
			String  username,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model) throws JSONException{

		JSONObject json = new JSONObject();
		json.put("exist", false);
	    if(!StringUtils.isBlank(username)){
			json.put("exist", service.isExist(username));
	    }
		ResponseUtils.renderJson(response,json.toString());

	}
	
	@RequestMapping("/userRole.do")
	public   String    userRole(Long  userId,String search,HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		List<RmsRole> rmsRoles = service.queryRoleByUserId(userId,search);

	    model.addAttribute("rmsRoles", rmsRoles);
		model.addAttribute("search", search);
		model.addAttribute("userId", userId);

		return "user/userrole";
	}
	
	@RequestMapping("/userRoleN.do")
	public   String    userRoleN(Long  userId,String search,HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		List<RmsRole> rmsRoles = service.queryRoleByUserIdN(userId,search);
					model.addAttribute("rmsRoles", rmsRoles);
					model.addAttribute("search", search);
					model.addAttribute("userId", userId);

		return "user/userrolen";
	}
	
	@RequiresPermissions({"admin:user:addrole"})
	@RequestMapping("/addUserRoles.do")
	public   void     addUserRoles(Long  userId,String ids,HttpServletRequest request,HttpServletResponse response,
			ModelMap model) throws JSONException{
	
		JSONObject json = new JSONObject();
		try {
			service.addUserRoles(userId, ids);
			json.put("success", true);
		} catch (Exception e) {
			json.put("success", false);
		}
	   
		ResponseUtils.renderJson(response,json.toString());
		
		
		
	}
	@RequiresPermissions({"admin:user:delrole"})
	@RequestMapping("/delUserRoles.do")
	public   void     delUserRoles(Long  userId,String ids,HttpServletRequest request,HttpServletResponse response,
			ModelMap model) throws JSONException{
	
		JSONObject json = new JSONObject();
		try {
			service.delUserRoles(userId, ids);
			json.put("success", true);
		} catch (Exception e) {
			json.put("success", false);
		}
	   
		ResponseUtils.renderJson(response,json.toString());
		
		
		
	}
	
	

	@Autowired
	private  RmsUserPage     page;
	@Autowired
	private  RmsUserService service;
	@Autowired
	private PwdEncoder pwdEncoder;

}
