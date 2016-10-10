package com.trs.rms.base.util;

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

}
