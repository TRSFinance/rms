//package com.trs.rms.usermgr.interceptor;
//
//import java.io.IOException;
//import java.util.List;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.apache.commons.lang.StringUtils;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.subject.Subject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//import org.springframework.web.util.UrlPathHelper;
//
///**
// * 
// * 此拦截器主要作用是：存储站点、和用户信息到request作用域中和防止xss攻击和权限验证
// * 
// */
//public class AdminInterceptor extends HandlerInterceptorAdapter {
//
//	private UserService userService;
//
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		
//		UrlPathHelper helper = new UrlPathHelper();
//		String queryString = helper.getOriginatingQueryString(request);
//		// 防止xss攻击
//		if ((!StringUtils.isBlank(queryString)) && (StringBeanUtils.hasHtml(queryString))) {
//			try {
//				response.setContentType("text/html;charset=UTF-8");
//				response.sendError(404);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//		/**
//		 * 权限验证
//		 */
//		Subject subject = SecurityUtils.getSubject();
//		if ((subject.isAuthenticated()) || (subject.isRemembered())) {
//			String username = (String) subject.getPrincipal();
//			User user = this.userService.findByUsername(username);
//			ContextTools.setUser(request, user);
//		}
//		return true;
//	}
//
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav) throws Exception {
//	}
//
//	
//	@Autowired
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
//}
