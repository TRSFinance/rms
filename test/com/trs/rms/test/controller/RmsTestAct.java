package com.trs.rms.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.trs.rms.test.bean.RmsTest;
import com.trs.rms.test.page.RmsTestPage;
import com.trs.rms.test.service.RmsTestService;
import com.trs.rms.test.service.RmsTestServices;
@Controller
public class RmsTestAct extends AbstractController {
	@Autowired
	private  RmsTestServices rmsTestService;
	@Autowired
	private  RmsTestPage     page;
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {

		System.out.println("我是控制层！");
		rmsTestService.test();
		HttpSession session = arg0.getSession();
		session.setAttribute("", "");
		return  new ModelAndView("index");  
	}
@RequestMapping("/test.act")	
public   String    test(){
	
	System.out.println("我是控制层！");
	//rmsTestService.test();
	RmsTest  rmsTest=new RmsTest();
	rmsTest.setName("测试");
	rmsTestService.save(rmsTest);
	rmsTest.setId(1L);
	rmsTest.setName("我是修改");
	rmsTestService.update(rmsTest);

	List list = page.queryObjectsToPages();

	return "index";
	
}





}
