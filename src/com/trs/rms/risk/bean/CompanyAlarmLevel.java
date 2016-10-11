package com.trs.rms.risk.bean;

/**
 * 预警级别
 *
 * @author ZhangBo
 * @time 2013-04-11
 * @see com.trs.om.bean.CkmCategory
 */
public class CompanyAlarmLevel {
	/** 记录ID */
	private Long id;
	/** 企业新闻事项类别分类对应的分类ID */
	private CkmCategory categoryId;
	/** 预警级别级别（1-一级、2-二级、3-三级） */
	private int level;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CkmCategory getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(CkmCategory categoryId) {
		this.categoryId = categoryId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
