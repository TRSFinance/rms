package com.trs.rms.usermgr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.trs.rms.base.util.ResponseUtils;
import com.trs.rms.usermgr.page.RmsUserPage;
import com.trs.rms.usermgr.service.RmsUserService;

@Controller
@RequestMapping("/rmsUser")
public class RmsUserAct {
	
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
		return "user/list";
	}
	@RequestMapping("/list.do")
	public  String   list(HttpServletRequest request,HttpServletResponse response,
			ModelMap model){
		List list = page.queryObjectsToPages();
		model.addAttribute("page", page);
		model.addAttribute("data", list);
		return "user/list";
	}
	
	
	
	
	
	@RequestMapping("/o_ajax_list.do")
	public  void   ajaxPageList(Integer sEcho, Integer iDisplayLength,HttpServletRequest request,HttpServletResponse response,
			ModelMap model) throws JSONException{
		JSONObject json = new JSONObject();
		List list = page.queryObjectsToPages();
		json.put("iTotalRecords", page.getRowCount());
		json.put("sEcho",sEcho);
		json.put("iTotalDisplayRecords", (page.getPageNo()-1)*(page.getPageSize()));
		json.put("aaData",list);
		ResponseUtils.renderJson(response,json.toString());

	}
	@Autowired
	private  RmsUserPage     page;
	@Autowired
	private  RmsUserService service;

}
