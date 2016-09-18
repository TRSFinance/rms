package com.trs.rms.base.util;
import java.io.IOException;
import java.net.SocketTimeoutException;




import java.net.URL;

import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;
public class UrlTool {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(UrlTool.class);
	
	/**
	 * 判断URL地址是否能够正常连接
	 * @param url
	 * @return
	 */
	public static boolean  isConnect(String url){
		   final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_24);

		try {
			
			 WebRequest webRequest = new WebRequest(new URL(url));  
			    webRequest.setHttpMethod(HttpMethod.GET);
			   final  Page page = webClient.getPage(webRequest);
			    WebResponse webResponse = page.getWebResponse();  
			    int status = webResponse.getStatusCode();  
			if(status==200){
				  return  true;
			}else{
				 return false;}
		} catch (Exception e) {
			return false;
		} 
	}
	
	
	/**
	 * 截取url字段  用于判断url是否有效
	 * @param url
	 * @return
	 */
	public static  String  splitUr(String url){
		
		try {
		
		if(url!=null){
			if(url.indexOf("http://")==-1){
				url="http://"+url;
			}
			String[]  urls=url.split("$[");
			if(urls.length>1){
				String  url_1=urls[0];
				String  url_2=urls[1];
				String[]  urls_2s=url_2.split("-");
				if(urls_2s.length<2)
					return url;
				url=url_1+urls_2s[0];
				return  url;
				
			}else{
				return url;
			}
		}else{
			return  url;
		}	
			
			
			
			
		} catch (Exception e) {
			return url;
		} 
		
		
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(isConnect("http://www.cnblogs.com/linjiqin/archive/2011/07/17/2108896.html"));
	}

}


