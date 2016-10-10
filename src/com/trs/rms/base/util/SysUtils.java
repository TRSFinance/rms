package com.trs.rms.base.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * 获取系统参数
 * @author zxh
 * @date   2016/10/09
 *
 */
public class SysUtils {
	/**
	 * 获取登录用户
	 * @return
	 */
	public  static   String   getLoginName(){
		Subject subject = SecurityUtils.getSubject();
		if ((subject.isAuthenticated()) || (subject.isRemembered())) {
			String username = (String) subject.getPrincipal();
		      return  username;	
		}
		return  null;
	}
	
	  public static String getIpAddr(HttpServletRequest request) {
			 String ip = request.getHeader("x-forwarded-for");
			    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			        ip = request.getHeader("Proxy-Client-IP");
			    }
			    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			        ip = request.getHeader("WL-Proxy-Client-IP");
			    }
			    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			        ip = request.getRemoteAddr();
			    }
			    return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
			    }

}
