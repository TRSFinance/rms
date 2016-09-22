package com.trs.rms.usermgr.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
	
	
}
