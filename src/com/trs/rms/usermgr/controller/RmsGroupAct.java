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
import com.trs.rms.usermgr.page.RmsGroupPage;
import com.trs.rms.usermgr.service.RmsGroupService;
@Controller
@RequestMapping("/rmsGroup")
public class RmsGroupAct {
   private static final Logger log = LoggerFactory.getLogger(RmsGroupAct.class);
	@Autowired
	private  RmsGroupService service;
	@Autowired
	private  RmsGroupPage     page;


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
		return "group/list";
	}
	@RequiresPermissions({"admin:role:query"})
	@RequestMapping("/list.do")
	public  String   list(HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		List list = page.queryObjectsToPages();
		model.addAttribute("page", page);
		model.addAttribute("data", list);
		return "group/list";
	}
	@RequestMapping(value={"/v_add.do"})
	public    String  vadd(HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		return "group/add";
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
		
	       log.debug("add Role roleName={}", roleName);
		
		return "redirect:/admin/rmsGroup/list.do";
	}
	@RequestMapping(value={"/v_edit.do"})
	public   String   vedit(Long id,HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
	
		return "group/edit";
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
	
		return "group/view";
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
	
	
}
