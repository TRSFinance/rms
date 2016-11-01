package com.trs.rms.rulemgr.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trs.rms.base.util.ResponseUtils;
import com.trs.rms.rulemgr.bean.CkmTemplate;
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
			CkmTemplate ckmTemplate=(CkmTemplate) service.queryById(CkmTemplate.class, id);
			model.addAttribute("ckmTemplate", ckmTemplate);
			return "rule/template/view";
		}
	
		//编辑某一条数据的方法，之后进入编辑页
		@RequestMapping("/v_edit.do")
		public  String   editpage(Long  id,
				HttpServletRequest request,HttpServletResponse response,
				ModelMap model){
			CkmTemplate ckmTemplate=(CkmTemplate) service.queryById(CkmTemplate.class, id);
			model.addAttribute("ckmTemplate", ckmTemplate);
			return "rule/template/edit";
		}
		
		//编辑某一条数据的方法，提交后将修改数据库信息
		@RequiresPermissions({"admin:corporateUser:edit"})
		@RequestMapping(value={"/edit.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
		public   String   edit(
				Long  id,
				String  name,
				String  fieldName,
				String syncStatus,
				HttpServletRequest request,HttpServletResponse response,
				ModelMap model){
			CkmTemplate ckmTemplate=(CkmTemplate) service.queryById(CkmTemplate.class, id);
					if(ckmTemplate!=null){
						ckmTemplate.setName(name);
						ckmTemplate.setFieldName(fieldName);
						ckmTemplate.setSyncStatus(syncStatus);																
						service.update(ckmTemplate);
					}
			return "redirect:/admin/ruleTemplate/list.do";
		}
		
		//删除方法
		@RequestMapping(value={"/delete.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
		public void delete(HttpServletRequest request,HttpServletResponse response,Long id) throws JSONException{

			JSONObject json = new JSONObject();
			json.put("success", true);
			CkmTemplate ckmTemplate=(CkmTemplate) service.queryById(CkmTemplate.class, id);
			if(ckmTemplate!=null){
				service.delete(CkmTemplate.class,id);
			}

			ResponseUtils.renderJson(response,json.toString());
		}	
}
