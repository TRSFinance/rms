package com.trs.rms.usermgr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.code.kaptcha.Constants;
import com.trs.rms.base.security.encoder.PwdEncoder;
import com.trs.rms.usermgr.bean.RmsUser;
import com.trs.rms.usermgr.service.RmsUserService;

@Controller
public class LoginAct {
	  @Autowired
	   private PwdEncoder pwdEncoder;
	 
	   @Autowired
	   private RmsUserService userService;
	   @RequestMapping(value={"/login.do"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	   public String input(HttpServletRequest request, HttpServletResponse response, ModelMap model)
	   {
		
		   model.addAttribute("msg", "请输入用户名密码！");
		   model.addAttribute("success", false);
		   
	     return "login";
	   }
	   
	   @RequestMapping(value={"/index.do"})
	   public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model)
	   {
		   model.addAttribute("KAPTCHAMVC", request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY));
		   return "index";
	   }
	   @RequestMapping(value={"/login.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	   public String submit(String username, String password, String captcha, String nextUrl, String message, HttpServletRequest request, HttpServletResponse response, ModelMap model, RedirectAttributes ra)
	   {
	     Subject currentUser = SecurityUtils.getSubject();
	     UsernamePasswordToken token = new UsernamePasswordToken(username, 
	       this.pwdEncoder.encodePassword(password));
	     token.setRememberMe(true);
	      model.addAttribute("success", true);

	     try {
	       currentUser.login(token);
	     } catch (UnknownAccountException localUnknownAccountException) {
	    	  model.addAttribute("msg", "账户不存在,登录失败!");
		      model.addAttribute("success", false);
			 return "login";
	    } catch (IncorrectCredentialsException localIncorrectCredentialsException) {
	          model.addAttribute("msg", "密码不正确,登录失败!");
			  model.addAttribute("success", false);
			return "login";
	     } catch (LockedAccountException localLockedAccountException) {
	           model.addAttribute("msg", "账户被禁了!");
			   model.addAttribute("success", false);
		   return "login";
	     }
	      RmsUser user = this.userService.findByUsername(username);
	      if(user==null){
	    	    model.addAttribute("msg", "用户名或密码错误,登录失败!");
		        model.addAttribute("success", false);
			       return "login";
	      }
	       if (user.getUserState()!=1) {
	            model.addAttribute("msg", "该账号已经被停用禁止登录");
	            model.addAttribute("success", false);
	           return "login";
	       }
	       if (!currentUser.isAuthenticated()) {
		        model.addAttribute("msg", "用户名或密码错误,登录失败!");
	            model.addAttribute("success", false);
		       return "login";
		     }
	      if (!StringUtils.isBlank(nextUrl)) {
	         return "redirect:" + nextUrl;
	       }
	      request.getSession().setAttribute("rmsuser", user);
	       return "redirect:index.do";
	   }
	 
	   @RequestMapping({"/logout.do"})
	   public String logout(HttpServletRequest request, HttpServletResponse response)
	   {
	     Subject currentUser = SecurityUtils.getSubject();
	     currentUser.logout();
	     request.getSession().removeAttribute("rmsuser");
	     return "login";
	   }
}
