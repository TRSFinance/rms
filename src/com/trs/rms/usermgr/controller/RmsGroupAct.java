package com.trs.rms.usermgr.controller;

import java.util.Date;
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
import com.trs.rms.usermgr.bean.RmsGroup;
import com.trs.rms.usermgr.bean.RmsUser;
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
	@RequiresPermissions({"admin:group:query"})
	@RequestMapping("/list.do")
	public  String   list(HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		page.setPageNo(1);
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
	@RequiresPermissions({"admin:group:save"})
	@RequestMapping(value={"/save.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public    String  save(
			    String groupName,
			    HttpServletRequest request,
			    HttpServletResponse response,
			    ModelMap model){
		   RmsGroup  group= new RmsGroup(groupName, 2, new Date(), new Date());
		   service.save(group);
	       log.debug("add Group groupName={}", groupName);
		
		return "redirect:/admin/rmsGroup/list.do";
	}
	@RequestMapping(value={"/v_edit.do"})
	public   String   vedit(Long id,HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		RmsGroup     group= (RmsGroup) service.queryById(RmsGroup.class, id);
		model.addAttribute("group", group);
		return "group/edit";
	}
	@RequiresPermissions({"admin:group:edit"})
	@RequestMapping(value={"/edit.do"})
	public   String   edit(Long id, 
			String groupName, 
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		RmsGroup     group= (RmsGroup) service.queryById(RmsGroup.class, id);
		if(group!=null){
			group.setUpdateTime(new Date());
			group.setGroupName(groupName);
			service.update(group);
		}
		return "redirect:/admin/rmsGroup/list.do";
		
	}
	@RequiresPermissions({"admin:group:del"})
	@RequestMapping("/a_del.do")
	public   void   ajaxDel(Long  id,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model) throws JSONException{
		JSONObject json = new JSONObject();
		json.put("success", true);
		try {
				service.delete(RmsGroup.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			json.put("success", false);
		}
		ResponseUtils.renderJson(response,json.toString());
	}
	@RequiresPermissions({"admin:group:view"})
	@RequestMapping("/view.do")
	public  String   view(Long  id,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		RmsGroup     group= (RmsGroup) service.queryById(RmsGroup.class, id);
		model.addAttribute("group", group);
		return "group/view";
	}
	@RequestMapping(value={"/a_groupname.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public   void   ajaxRolename(
			String  groupName,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model) throws JSONException{
		JSONObject json = new JSONObject();
		json.put("exist", false);
	    if(!StringUtils.isBlank(groupName)){
			json.put("exist", service.isExist(groupName));
	    }
		ResponseUtils.renderJson(response,json.toString());

	}
	
	@RequestMapping(value={"/e_groupname.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public   void   ajaxRolename(
			Long    id,
			String  groupName,
			HttpServletRequest request,HttpServletResponse response,
			ModelMap model) throws JSONException{
		JSONObject json = new JSONObject();
		json.put("exist", false);
	    if(!StringUtils.isBlank(groupName)){
			json.put("exist", service.isExist(groupName));
	    }
		ResponseUtils.renderJson(response,json.toString());

	}
	
	@RequestMapping("/groupUser.do")
	public   String    groupUser(Long  groupId,String search,HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		List<RmsUser> groupUsers = service.queryUserByGroupId(groupId,search);

	    model.addAttribute("groupUsers", groupUsers);
		model.addAttribute("search", search);
		model.addAttribute("groupId", groupId);

		return "group/groupuser";
	}
	
	@RequestMapping("/groupUserN.do")
	public   String    groupUserN(Long  groupId,String search,HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		List<RmsUser> groupUsers = service.queryUserByGroupIdN(groupId,search);
					model.addAttribute("groupUsers", groupUsers);
					model.addAttribute("search", search);
					model.addAttribute("groupId", groupId);

		return "group/groupusern";
	}
	@RequiresPermissions({"admin:group:adduser"})
	@RequestMapping("/addGroupUsers.do")
	public   void     addGroupUsers(Long  groupId,String userIds,HttpServletRequest request,HttpServletResponse response,
			ModelMap model) throws JSONException{
	
		JSONObject json = new JSONObject();
		try {
			service.addGroupUsers(groupId, userIds);
			json.put("success", true);
		} catch (Exception e) {
			json.put("success", false);
		}
	   
		ResponseUtils.renderJson(response,json.toString());
		
		
		
	}
	@RequiresPermissions({"admin:group:deluser"})
	@RequestMapping("/delGroupUsers.do")
	public   void     delGroupUsers(Long  groupId,String userIds,HttpServletRequest request,HttpServletResponse response,
			ModelMap model) throws JSONException{
	
		JSONObject json = new JSONObject();
		try {
			service.delGroupUsers(groupId, userIds);
			json.put("success", true);
		} catch (Exception e) {
			json.put("success", false);
		}
	   
		ResponseUtils.renderJson(response,json.toString());
		
		
		
	}
	
	
	

}
