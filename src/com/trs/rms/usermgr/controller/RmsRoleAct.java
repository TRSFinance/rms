package com.trs.rms.usermgr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.trs.rms.base.util.ResponseUtils;
import com.trs.rms.usermgr.bean.RmsRole;
import com.trs.rms.usermgr.bean.RmsRolePerm;
import com.trs.rms.usermgr.page.RmsRolePage;
import com.trs.rms.usermgr.service.RmsRoleService;
@Controller
@RequestMapping("/rmsRole")
public class RmsRoleAct {
   private static final Logger log = LoggerFactory.getLogger(RmsRoleAct.class);
	@Autowired
	private  RmsRoleService service;
	@Autowired
	private  RmsRolePage     page;
	@RequiresPermissions({"admin:role:test1"})
	@RequestMapping(value={"/test.do"})
	public  String  test(){
		service.delQuery();
		return "role/test2";

	}
	
	@RequiresPermissions({"admin:role:test2"})
	@RequestMapping(value={"/test2.do"})
	public String  test2(){
		service.delQuery();
		return "role/test2";
	}

	@RequestMapping("/v_list.do")
	public  String   pagelist(Integer pageSize,Integer pageNo,String searchword,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		if(pageSize>0)
		page.setPageSize(pageSize);
		if(pageNo>0)
		page.setPageNo(pageNo);
		page.setSearchword(searchword);
		List list = page.queryObjectsToPages();
		model.addAttribute("page", page);
		model.addAttribute("data", list);
		return "role/list";
	}
	@RequiresPermissions({"admin:role:query"})
	@RequestMapping("/list.do")
	public  String   list(HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		List list = page.queryObjectsToPages();
		model.addAttribute("page", page);
		model.addAttribute("data", list);
		return "role/list";
	}
	@RequestMapping(value={"/v_add.do"})
	public    String  vadd(HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		model.addAttribute("perms", "");
		return "role/add";
	}
	@RequiresPermissions({"admin:role:save"})
	@RequestMapping(value={"/save.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public    String  save(
			    String roleName,
				Integer     isAllPerm,
				String      perms,
				String description,
			    HttpServletRequest request,
			    HttpServletResponse response,
			    ModelMap model){
		
		service.saveRole(roleName, isAllPerm, description, perms);
	       log.debug("add Role roleName={}", roleName);
		
		return "redirect:/admin/rmsRole/list.do";
	}
	@RequestMapping(value={"/v_edit.do"})
	public   String   vedit(Long id,HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		RmsRole role=(RmsRole) service.queryById(RmsRole.class, id);
		RmsRolePerm perms=role.getRmsRolePerm();
		model.addAttribute("perms", "");
	   if(role!=null&&perms!=null&&perms.getRolePerms()!=null)
	      model.addAttribute("perms", perms.getRolePerms());
	   model.addAttribute("role", role);
		return "role/edit";
	}
	@RequiresPermissions({"admin:role:edit"})
	@RequestMapping(value={"/edit.do"})
	public   String   edit(Long id, 
			String roleName, 
			Integer isAllPerm,
			String  description,
			String perms,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		try{
          service.updateRole(id, roleName, isAllPerm, description, perms);
	      log.debug("update Role id={}", id);
          }catch(Exception e){
    	  log.error("update Role id={} fail", id);
          }
		return "redirect:/admin/rmsRole/list.do";
		
	}
	@RequiresPermissions({"admin:role:del"})
	@RequestMapping("/a_del.do")
	public   void   ajaxDel(Long  id,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model) throws JSONException{
		JSONObject json = new JSONObject();
		json.put("success", true);
		try {
			service.delRole(id);
		} catch (Exception e) {
			json.put("success", false);
		}
		ResponseUtils.renderJson(response,json.toString());
	}
	@RequiresPermissions({"admin:role:view"})
	@RequestMapping("/view.do")
	public  String   view(Long  id,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		RmsRole role=(RmsRole) service.queryById(RmsRole.class, id);
		RmsRolePerm perms=role.getRmsRolePerm();
		model.addAttribute("perms", "");
	   if(role!=null&&perms!=null&&perms.getRolePerms()!=null)
	      model.addAttribute("perms", perms.getRolePerms());
	   model.addAttribute("role", role);
		return "role/view";
	}
	@RequestMapping(value={"/a_rolename.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public   void   ajaxRolename(
			String  rolename,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model) throws JSONException{
		JSONObject json = new JSONObject();
		json.put("exist", false);
	    if(!StringUtils.isBlank(rolename)){
			json.put("exist", service.isExist(rolename));
	    }
		ResponseUtils.renderJson(response,json.toString());

	}
	@RequestMapping(value={"/e_rolename.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public   void   ajaxRolename(
			Long   id,
			String  rolename,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model) throws JSONException{
		JSONObject json = new JSONObject();
		json.put("exist", false);
	    if(!StringUtils.isBlank(rolename)){
			json.put("exist", service.isExist(id,rolename));
	    }
		ResponseUtils.renderJson(response,json.toString());

	}
	
	
}
