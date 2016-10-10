package com.trs.rms.usermgr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trs.rms.usermgr.bean.RmsRole;
import com.trs.rms.usermgr.bean.RmsRolePerm;
import com.trs.rms.usermgr.service.RmsRoleService;

@Controller
@RequestMapping("/rmsRole")
public class RmsRoleAct {
	@Autowired
	private  RmsRoleService service;
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
	@RequestMapping(value={"/v_edit.do"})
	public   String   vedit(Long id,HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		RmsRole role=(RmsRole) service.queryById(RmsRole.class, id);
		RmsRolePerm perms=role.getRmsRolePerm();
		model.addAttribute("perms", "");
	   if(role!=null&&perms!=null&&perms.getRolePerms()!=null)
	   model.addAttribute("perms", perms.getRolePerms());
		return "role/edit";
		
	}
	@RequestMapping(value={"/edit.do"})
	public   void   edit(HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		
	}
	
	
	
	
	
	
}
