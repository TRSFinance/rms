package com.trs.rms.base.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
/**
 * 分页标签
 * @author zxh
 * @date   2016/10/08
 */
public class PageTag2 extends TagSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8778337636689730172L;
	private Integer pageNo =1;
	private Integer pageSize = 20;
	private Integer rowCount = 0;
	private Integer pageCount = 1;
	private String  targetId="data";
	
	
	public int doStartTag( ) throws JspException{
	  if(  rowCount > 0&&pageSize>0 ){
			int p_start = pageNo-2;
			int p_end = pageNo+2;
			if(p_start<=0)
				p_start=1;
			if(p_end>pageCount)
				p_end=pageCount;
			StringBuffer pageInfo = new StringBuffer();
			pageInfo.append("<div class=\"row\">");
			pageInfo.append("<div class=\"col-md-12\">");
			pageInfo.append("<div class=\"dataTables_info\" >共"+rowCount+"条 "+pageNo+"/"+pageCount+"页</div>");
			pageInfo.append("</div>");
			pageInfo.append("<div class=\"col-md-12 center-block\">");
			pageInfo.append("<div class=\" paging_bootstrap pagination\">");
			pageInfo.append("<ul class=\"pagination\">");
			if(pageNo==1){
				pageInfo.append("<li class=\"prev disabled\"><a href=\"#\">上一页</a></li>");
			}
			if(pageNo>1){
				pageInfo.append("<li class=\"prev\"><a href=\"javascript:go("+(pageNo-1)+")\">上一页</a></li>");
			}
			for (int i = p_start; i <=p_end; i++) {
				if(i==pageNo){
					pageInfo.append("<li class=\"active\"><a href=\"#\">"+i+"</a></li>");
				}else{
					pageInfo.append("<li><a href=\"javascript:go("+i+")\">"+i+"</a></li>");

				}
			}
			if(pageNo.intValue()==pageCount.intValue()){
				pageInfo.append("<li class=\"next disabled\"><a href=\"#\">下一页</a></li>");
			}
			if(pageNo.intValue()<pageCount.intValue()){
				pageInfo.append("<li class=\"next\"><a href=\"javascript:go("+(pageNo+1)+")\">下一页</a></li>");
			}			
			
			pageInfo.append("</ul></div></div></div>");
			pageInfo.append("<SCRIPT LANGUAGE=\"JavaScript\">\n");
		    pageInfo.append("function go(pageNo){\n");
		    pageInfo.append("$(\"#pageNo\").val(pageNo);\n");
		    pageInfo.append("$(\"#"+targetId+"\").submit();\n");
		    pageInfo.append("}\n");
		    pageInfo.append("</SCRIPT>\n");
		    JspWriter out = this.pageContext.getOut();
		    try {
				out.print( pageInfo.toString() );
			} catch (IOException e) {
			}
		}	
	    return super.doStartTag();
	}

	 
	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getRowCount() {
		return rowCount;
	}

	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}


	
	
	

}
