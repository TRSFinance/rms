package com.trs.rms.usermgr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rmsUser")
public class RmsUserAct {
	@RequestMapping("/v_list.do")
	public  String   list(){
		return "user/list";
	}

}
