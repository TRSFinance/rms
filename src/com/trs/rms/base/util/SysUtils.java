//package com.trs.rms.base.util;
//
//import java.util.Map;
//import java.util.UUID;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.web.context.ContextLoader;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//
//
//public class SysUtils {
//	private  String path;
//
//	
//	
//	/**
//	 * 获取登录用户
//	 * @return
//	 */
//	public static  SysUser  getLoginUser(){
//		Map session = ActionContext.getContext().getSession();	
//		SysUser user=null;
//		if(session!=null)
//		user= (SysUser) session.get("user");
//		return  user;
//	}
//	/**
//	 * 获取登录用户名
//	 * @return
//	 */
//	public static  String  getLoginUserName(){
//		String  username="anonymous"; 
//		Map session = ActionContext.getContext().getSession();		
//		SysUser user=null;
//		if(session!=null)
//		user= (SysUser) session.get("user");
//		if(user!=null)
//			username=user.getLoginName();
//		
//		return  username;
//	}
//	
//	/**
//	 * 获取登录用户
//	 * @return
//	 */
//	/*public static  SysUser  getLoginUser(){
//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//		HttpSession session = request.getSession();
//		SysUser user=null;
//		if(session!=null)
//		user= (SysUser) session.getAttribute("user");
//		return  user;
//	}*/
//	/**
//	 * 获取登录用户名
//	 * @return
//	 */
//	/*public static  String  getLoginUserName(){
//		String  username="anonymous"; 
//		//HttpServletRequest request = RequestFilter.threadLocal.get();
//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//		HttpSession session = request.getSession();
//		SysUser user=null;
//		if(session!=null)
//		user= (SysUser) session.getAttribute("user");
//		if(user!=null)
//			username=user.getLoginName();
//		
//		return  username;
//	}*/
//	
//	
//	
//	/**
//	 * 获取Session中  SFTP连接通道
//	 * @return
//	 */
//	public  static  ChannelSftp   getChannelSftp(String  key){
//		
//		WebApplicationContext webContext = ContextLoader.getCurrentWebApplicationContext();
//		ChannelSftp sftp=null;
//		if(webContext!=null)
//			sftp= (ChannelSftp) webContext.getServletContext().getAttribute(key);
//		return sftp;
//	}
//	
//	
//	/**
//	 * 
//	 * @param key
//	 * @param sftp
//	 */
//	public  static  void  setChannelSftp(String  key,ChannelSftp sftp){
//		WebApplicationContext webContext = ContextLoader.getCurrentWebApplicationContext();
//		webContext.getServletContext().setAttribute(key, sftp);
//		
//	}
//
//	/**
//	 * 向session中保存一个对象
//	 * @param name
//	 * @param object
//	 */
//	public static  void  setSession(String name,Object object){
//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//		HttpSession session = request.getSession();
//		session.setAttribute(name, object);
//	}	
//	/**
//	 * 
//	 * @param name
//	 */
//	public static  void  removeSession(String name){
//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//		HttpSession session = request.getSession();
//		session.removeAttribute(name);
//	}	
//	/**
//	 * 获取进度条参数
//	 * @param name
//	 * @return
//	 */
//	public static  JDT  getJDT(String name){
//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//		HttpSession session = request.getSession();
//		JDT jdt=null;
//		if(session!=null)
//			jdt= (JDT) session.getAttribute(name);
//		
//		return jdt;
//		
//	}	
//	
//	
//	/**
//	 * 取config.properties文件中的配置参数值
//	 *
//	 * @param name
//	 *            String 要取的参数名
//	 * @return String
//	 */
//	public static String getPropertiesValue(String name) {
//		WebApplicationContext webContext = ContextLoader.getCurrentWebApplicationContext();
//	
//		SystemPropertyManager systemPropertyManager=(SystemPropertyManager) webContext.getBean("systemPropertyManager");
//		return systemPropertyManager.getPropertiesValue(name);
//	}
//	
//	/**
//	 * 获取WS-CODE   
//	 * @return
//	 */
//	public static String  getUserCode(){
//		String uid=UUID.randomUUID().toString();
//    	String   patternStr="[^0-9A-Z]?";
//    	uid=uid.toUpperCase();
//    	Pattern pattern = Pattern.compile(patternStr,Pattern.CASE_INSENSITIVE);
//		Matcher matcher = pattern.matcher(uid);
//		uid=matcher.replaceAll("");
//		return uid;
//	}
//	
//	
//	
//	
//	
//	public String getPath() {
//		
//		return path;
//	}
//
//	public void setPath(String path) {
//		this.path = path;
//	}
//	
//	
//	
//	
//	
//
//}
