package com.trs.rms.base.page;

import java.util.List;

/**
 * 分页参数
 * @author zxh
 * @date   2016-09-28
 */
public class PageParam {
  private   BasicPage  page;
  private   List      list;
  
  
  public  PageParam(){
	  
  }
  public PageParam(BasicPage page) {
		this.page = page;
		this.list = page.queryObjectsToPages();
	}
  
public PageParam(BasicPage page, List list) {
	super();
	this.page = page;
	this.list = list;
}
public BasicPage getPage() {
	return page;
}
public void setPage(BasicPage page) {
	this.page = page;
}
public List getList() {
	return list;
}
public void setList(List list) {
	this.list = list;
}
  
  
  
  
  
  
}
