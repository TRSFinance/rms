package com.trs.rms.rulemgr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trs.rms.company.bean.RmsCorporateUser;
import com.trs.rms.rulemgr.page.RuleTemplatePage;
import com.trs.rms.rulemgr.service.RmsRuleTemplateService;

@Controller
@RequestMapping("/ruleTemplate")
public class ruleTemplateMgr {

	@Autowired
	private RuleTemplatePage page;
	
	@Autowired
	private RmsRuleTemplateService service;
	
	@RequestMapping(value="/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		page.setPageNo(1);
		List list = page.queryObjectsToPages();
		model.addAttribute("page", page);
		model.addAttribute("data", list);
		return "rule/template/list";
	}
	
	//通用的查询方法(输入搜索词查询)
		@RequestMapping("/v_list.do")
		public  String   pagelist(Integer pageSize,Integer pageNo,String username,
				HttpServletRequest request,HttpServletResponse response,
				ModelMap model){
			if(pageSize>0)
			page.setPageSize(pageSize);
			if(pageNo>0)
			page.setPageNo(pageNo);
			page.setSearchword(username);
			List list = page.queryObjectsToPages();
			model.addAttribute("page", page);
			model.addAttribute("data", list);
			return "rule/template/list";
		}
	
		@RequestMapping("/view.do")
		public  String   view(Long  id,
				HttpServletRequest request,HttpServletResponse response,
				ModelMap model){
			RmsCorporateUser corporateUser=(RmsCorporateUser) service.queryById(RmsCorporateUser.class, id);
			model.addAttribute("corporateUser", corporateUser);
			return "company/view";
		}
	
}
