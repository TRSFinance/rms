package com.trs.rms.risk.statrans.dao.criterion;

import java.util.Collection;

/**
 *
 * 服务器配置信息检索条件封装
 * @author clinzy 2012-3-28
 * @author zxh    2016-10-28
 *
 */
public class STATransConfCriterion {
	/**
	 * 配置名称
	 */
	private String transConfName;

	/**
	 * 配置类型
	 */
	private String transConfType;

	/**
	 * 配置标记
	 */
	private Integer transConfTag;
	/**
	 * 排除的id
	 */
	private Collection<Long> excludeIds;

	/**
	 * 包含的id
	 */
	private Collection<Long> inIds;

	public String getTransConfName() {
		return transConfName;
	}

	public void setTransConfName(String value) {
		transConfName = value;
	}

	public String getTransConfType() {
		return transConfType;
	}

	public void setTransConfType(String value) {
		transConfType = value;
	}

	public Integer getTransConfTag() {
		return transConfTag;
	}

	public void setTransConfTag(Integer value) {
		transConfTag = value;
	}

	public Collection<Long> getExcludeIds() {
		return excludeIds;
	}

	public void setExcludeIds(Collection<Long> excludeIds) {
		this.excludeIds = excludeIds;
	}

	public Collection<Long> getInIds() {
		return inIds;
	}

	public void setInIds(Collection<Long> inIds) {
		this.inIds = inIds;
	}
}
