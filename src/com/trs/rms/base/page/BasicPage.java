package com.trs.rms.base.page;

import java.util.ArrayList;
import java.util.List;

public abstract class BasicPage {

	/**
	 * 当前页
	 */
	private int pageNo = 1;
	/**
	 * 每页多少条
	 */
	private int pageSize = 20;
	/**
	 * 总的记录数
	 */
	private int rowCount;
	/**
	 * 总页数
	 */
	private int pageCount;
	
	/**
	 * 分页查询的HQL
	 */
	public String HQLString;
	/**
	 * 查询记录总数的HQL
	 */
	public String HQLCountString;
	/**
	 * 参数集合
	 */
	private List paramList = new ArrayList();

	/**
	 * 需要注入
	 */
	private IBasicDao publicDao;
	
	
	public abstract void addParameter();
	
	/**
	 * 计算总页数
	 * @throws Exception
	 */
	public void jsPageCount() {
		
		if( this.rowCount % this.pageSize == 0 ){
			this.pageCount = this.rowCount / this.pageSize ;
		}else{
			this.pageCount = this.rowCount / this.pageSize + 1;
		}

	}
	
	/**
	 * 分页模型，分页查询功能
	 * @return
	 */
	public List queryObjectsToPages() {
		//清空page中list的内容
		this.getParamList().clear();
		
		//1.给HQL赋值
		this.addParameter();//调用子类的功能（给HQL赋值）
		
		//2.查询记录总数
		int count = publicDao.queryForInt(this);
		this.setRowCount(count);
		
		//3.计算总页数
		this.jsPageCount();
		
		//4.分页查询
		return publicDao.queryObjectsToPages(this);
	}

	/**
	 * 给paramList加入参数
	 * @param type
	 * @param value
	 */
	public void addParams( int type,Object value ) {
		Param p1 = new Param();
		p1.setType( type );
		p1.setValue( value );
		this.getParamList().add( p1 );
	}
	
	public String getHQLString() {
		return HQLString;
	}

	public void setHQLString(String string) {
		HQLString = string;
	}

	public String getHQLCountString() {
		return HQLCountString;
	}

	public void setHQLCountString(String countString) {
		HQLCountString = countString;
	}

	public List getParamList() {
		return paramList;
	}

	public void setParamList(List paramList) {
		this.paramList = paramList;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}



	public IBasicDao getPublicDao() {
		return publicDao;
	}

	public void setPublicDao(IBasicDao publicDao) {
		this.publicDao = publicDao;
	}
    public  abstract void setMyPublicDao(IBasicDao publicDao);


	
}
