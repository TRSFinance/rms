package com.trs.rms.rulemgr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ruleContent")
public class ruleContentMgr {

	
	@RequestMapping(value="list.do")
	public String list(){
		
		return "rule/content/list";
	}
	
}
