package com.trs.rms.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.trs.rms.test.service.RmsTestService;

public class RmsTestAct extends AbstractController {
	private  RmsTestService rmsTestService;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {

		System.out.println("我是控制层！");
		rmsTestService.test();
		return  new ModelAndView("index");  
	}
	
public   String    test(){
	
	System.out.println("我是控制层！");
	rmsTestService.test();
	return "index";
	
}
public RmsTestService getRmsTestService() {
	return rmsTestService;
}
public void setRmsTestService(RmsTestService rmsTestService) {
	this.rmsTestService = rmsTestService;
}




}
