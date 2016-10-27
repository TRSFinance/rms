package com.trs.rms.base.page;


/**
 * 分页条件。
 * @author wengjing
 * @author 邹许红
 *
 */
public class PageCriterion {
	//fields	---------------------------------------------------------------------
	/**
	 * 每页的记录数。
	 */
	private int pageSize;
	/**
	 * 页号，从1开始。
	 */
	private int pageNum;

	// methods --------------------------------------------------------------
	public PageCriterion(int pageSize, int pageNum) {
		super();
		this.pageSize = pageSize;
		this.pageNum = pageNum;
	}

	public PageCriterion() {
		super();
	}

	public OffsetLimit toOffsetLimit(){
		return new OffsetLimit((pageNum-1)*pageSize, pageSize);
	}


	//accessors	---------------------------------------------------------------------
	/**
	 * 获取每页的记录数。
	 *
	 * @return 每页的记录数
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置每页的记录数。
	 *
	 * @param pageSize 每页的记录数
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 获取页号。
	 *
	 * @return 页号
	 */
	public int getPageNum() {
		return pageNum;
	}

	/**
	 * 设置页号。
	 *
	 * @param pageNum 页号
	 */
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

}
