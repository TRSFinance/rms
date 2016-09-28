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

import com.google.gson.Gson;
import com.trs.rms.base.util.ResponseUtils;
import com.trs.rms.usermgr.page.RmsUserPage;
import com.trs.rms.usermgr.service.RmsUserService;

@Controller
@RequestMapping("/rmsUser")
public class RmsUserAct {
	@RequestMapping("/v_list.do")
	public  String   list(){
		page.queryObjectsToPages();
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
