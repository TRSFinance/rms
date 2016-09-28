package com.trs.rms.base.tag;

import java.io.IOException;
import java.util.Enumeration;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.trs.rms.base.page.BasicPage;



@SuppressWarnings("serial")
public class PageTag2 extends TagSupport{
	
	private String color = "#4EA2EF";
	private String uri;
	private String pageName="";
	
	public int doStartTag( ) throws JspException{

		this.parseURI();
		
		HttpServletRequest request = (HttpServletRequest) this.pageContext.getRequest();
		
		BasicPage page = (BasicPage)request.getAttribute(pageName);
		
		int pageNo = page.getPageNo();
		int pageSize = page.getPageSize();
		int rowCount = page.getRowCount();
		int pageCount = page.getPageCount();
		
		if(  rowCount > 0 ){

			int p_start = (pageNo-1) / 10 * 10 +1;
			int p_end = pageCount<p_start+10 ?pageCount+1:p_start+10;
			
			
			StringBuffer pageInfo = new StringBuffer();

			
			pageInfo.append("<style type=\"text/css\">\n");

			pageInfo.append(".pagination {\n");
		//	pageInfo.append("	width: 630px;\n");
			pageInfo.append("	float: right;\n");
			pageInfo.append("	font-size: 12px;\n");
			pageInfo.append("	line-height: 23px;\n");
			pageInfo.append("	height: 23px;\n");
			pageInfo.append("	color:"+this.getColor()+";\n");
			pageInfo.append("	font-family: Verdana;\n");
			pageInfo.append("}\n");

			pageInfo.append(".pagination a {\n");
			pageInfo.append("	float: left;\n");
			pageInfo.append("	text-decoration: none;\n");
			pageInfo.append("	font-weight: bold;\n");
			pageInfo.append("	border: 1px solid #FFFFFF;\n");
			pageInfo.append("	background-color: "+this.getColor()+";\n");
			pageInfo.append("	color: #FFFFFF;\n");
			pageInfo.append("	margin: 1px 1px 0 0;\n");
			pageInfo.append("	padding: 0 5px 2px 5px;\n");
			pageInfo.append("	line-height: normal;\n");
			pageInfo.append("}\n");

			pageInfo.append(".pagination a:hover {\n");
			pageInfo.append("	border: 1px solid "+this.getColor()+";\n");
			pageInfo.append("	background-color: #FFFFFF;\n");
			pageInfo.append("	color: "+this.getColor()+";\n");
			pageInfo.append("}\n");

			pageInfo.append(".pagination .noncepage {\n");
			pageInfo.append("	color: "+this.getColor()+";\n");
			pageInfo.append("	background-color: #ffffff;\n");
			pageInfo.append("	border: 1px solid "+this.getColor()+";\n");
			pageInfo.append("	margin-right:3px;\n");
			pageInfo.append("}\n");

			pageInfo.append(".pagination .inputnumber {\n");
			pageInfo.append("	font-family: Verdana;\n");
			pageInfo.append("	width: 30px;\n");
			pageInfo.append("	height: 18px;text-align:center;\n");
			pageInfo.append("	border: 1px solid "+this.getColor()+";\n");
			pageInfo.append("	font-weight: bold;\n");
			pageInfo.append("	color: "+this.getColor()+";\n");
			pageInfo.append("}\n");

			pageInfo.append(".pagination .inputgo {\n");
			pageInfo.append("	font-family: Verdana;\n");
			pageInfo.append("	width: 25px;\n");
			pageInfo.append("	height: 18px;\n");
			pageInfo.append("	background-color: "+this.getColor()+";\n");
			pageInfo.append("	border: 1px solid "+this.getColor()+";\n");
			pageInfo.append("	font-size: 11px;\n");
			pageInfo.append("	font-weight: bold;\n");
			pageInfo.append("	color: #ffffff;\n");
			pageInfo.append("}\n");

			pageInfo.append("</style>\n");
			

			
			pageInfo.append("<form method=\"POST\" action=\""+request.getContextPath()+this.uri+"\">	\n");
			pageInfo.append("<div class=\"pagination\">\n");
//			pageInfo.append("<ul>\n");
			
			pageInfo.append(" <a style=\"background-color: #ffffff;color:"+this.getColor()+";font-weight: normal;\">\n");
			pageInfo.append("总数:"+rowCount);
			pageInfo.append("	"+pageSize+"/页\n");
			pageInfo.append("</a>\n");
			if( pageNo-10 < 1 ){
				pageInfo.append(" <a ><<</a>\n");
			}else{
				pageInfo.append(" <a href=\"javascript:go("+(pageNo-10)+")\" ><<</a>\n");
			}
			if( pageNo-1 < 1 ){
				pageInfo.append(" <a ><</a>\n");
			}else{
				pageInfo.append(" <a href=\"javascript:go("+(pageNo-1)+")\"><</a> \n");
			}
			for(int y=p_start;y<p_end;y++){

				pageInfo.append(" <a href=\"javascript:go("+y+")\"");
				if(y == pageNo)
					pageInfo.append(" class=\"noncepage\"");
				pageInfo.append(" >"+y+"</a> \n");
			}
			if( pageNo+1 > pageCount ){
				pageInfo.append(" <a >></a>\n");
			}else{
				pageInfo.append(" <a href=\"javascript:go("+(pageNo+1)+")\">></a>\n");
			}
			if( pageNo+10 > pageCount ){
				if(pageNo >= pageCount ){
					pageInfo.append(" <a >>></a>\n");
				}else{
					pageInfo.append(" <a href=\"javascript:go("+(pageCount)+")\">>></a>\n");
				}
				
			}else{
				pageInfo.append(" <a href=\"javascript:go("+(pageNo+10)+")\">>></a>\n");
			}
			pageInfo.append("Pages: "+pageNo+" / "+pageCount);
			
			pageInfo.append("<input name=\""+pageName+".pageNo\" id=\"pageNo\" type=\"text\" class=\"inputnumber\" value=\""+pageNo+"\"/>\n");
			pageInfo.append("<input name=\"a\" type=\"button\" value=\"GO\" onclick=\"javascript:goPage()\" class=\"inputgo\" />\n");
			pageInfo.append("</div>\n");
			pageInfo.append("</form>\n");
			pageInfo.append("<SCRIPT LANGUAGE=\"JavaScript\">\n");
		    pageInfo.append("function goPage(){\n");
		    pageInfo.append("   var pageNo = document.getElementById(\"pageNo\").value;\n");
		    pageInfo.append("   if(Number(pageNo)>Number("+pageCount+")){ alert('输入的数应该小于等于"+pageCount+"。');return;}\n");
		    pageInfo.append("   if(Number(pageNo)<=0 ){ alert('输入的数应该大于等于1。');return;}\n");
		    pageInfo.append("   eval(\"document.location.href='"+request.getContextPath()+this.uri+pageName+".pageNo='+pageNo+'"+getParamsFromCurrentURL(request, "page.pageNo")+"'\");\n");
		    pageInfo.append("}\n");
		    pageInfo.append("function go(pageNo){\n");
		    pageInfo.append("   if(Number(pageNo)>Number("+pageCount+")){ alert('输入的数应该小于等于"+pageCount+"。');return;}\n");
		    pageInfo.append("   if(Number(pageNo)<=0 ){ alert('输入的数应该大于等于1。');return;}\n");
		    pageInfo.append("   eval(\"document.location.href='"+request.getContextPath()+this.uri+pageName+".pageNo='+pageNo+'"+getParamsFromCurrentURL(request, "page.pageNo")+"'\");\n");
		    pageInfo.append("}\n");
		    
		    pageInfo.append("</SCRIPT>\n");
			
		    JspWriter out = this.pageContext.getOut();
		    try {
				out.print( pageInfo.toString() );
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	    return super.doStartTag();
	}
	private void parseURI(){
		//判断传入的uri中是否存在？   如果有就加个&号，没有就加个？号
		int p = this.uri.lastIndexOf("?");
		if( p == -1 ){
			this.uri = this.uri + "?";
		}else{
			this.uri = this.uri + "&";
		}
	}
	  /**
	   * 从URL中获取参数
	   * @param: request 客户端请求
	   * @param: exceptionParamNames 排除在外的参数
	   */
	  public String getParamsFromCurrentURL(HttpServletRequest request,String exceptionParamNames) {
		  
	    String params = "";
	    Enumeration e = request.getParameterNames();
	    outer:while (e.hasMoreElements()) {
	      String key = (String) e.nextElement();
	      StringTokenizer st = new StringTokenizer(exceptionParamNames, ",");
	      while (st.hasMoreTokens()) {
	        String exceptionName = st.nextToken();
	        if (key.equals(exceptionName)) {
	          continue outer;
	        }
	      }
	      String value = request.getParameter(key);
	      if (!key.equals("changeorderids")) //gxz add 2003-11-12
	        params += "&" + key + "=" + java.net.URLEncoder.encode(value); //为论坛翻页增加转码
	    }
	    return "";
	  }
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	
	
	

}
