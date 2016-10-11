package com.trs.rms.risk.bean;

/**
 * CKM规则对应的实体类。
 * @author wengjing
 *
 */
public class CkmRule {
	//fields	---------------------------------------------------------------------
	/**
	 * 规则ID
	 */
	private Long id;
	/**
	 * 规则内容
	 */
	private String content;
	/**
	 * 所属分类
	 */
	private CkmCategory category;
	//accessors	---------------------------------------------------------------------
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public CkmCategory getCategory() {
		return category;
	}
	public void setCategory(CkmCategory category) {
		this.category = category;
	}
	
}
