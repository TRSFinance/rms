package com.trs.rms.usermgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trs.rms.usermgr.service.RmsRoleService;

@Controller
@RequestMapping("/rmsRole")
public class RmsRoleAct {
	@Autowired
	private  RmsRoleService service;
	@RequestMapping(value={"/test.do"})
	public  void  test(){
		service.delQuery();
	}
	
	
	
	
}
