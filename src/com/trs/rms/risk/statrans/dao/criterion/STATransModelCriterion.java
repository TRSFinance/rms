package com.trs.rms.risk.statrans.dao.criterion;

/**
 * STA任务模板检索条件信息
 * 
 * @author clinzy 2012-3-20
 * @author zxh    2016-10-28
 */
public class STATransModelCriterion {
	/**
	 * 任务类型
	 */
	private String transType;
	
	/**
	 * 任务模板分组名称
	 */
	private String transModelGroupName;
	
	/**
	 * 任务模板Tag标记（0--该模板不可用；1--该模板可用）
	 */
	private Integer transModelTag;
	
	/**
	 * 构造函数
	 */
	public STATransModelCriterion() {
		
	}
	
	/**
	 * 返回任务类型
	 * 
	 * @return
	 */
	public String getTransType() {
		return transType;
	}
	
	/**
	 * 设置任务类型
	 * 
	 * @param value
	 */
	public void setTransType(String value) {
		transType = value;
	}

	/**
	 * 返回任务模板分组名称
	 * 
	 * @return
	 */
	public String getTransModelGroupName() {
		return transModelGroupName;
	}

	/**
	 * 设置任务模板分组名称
	 * 
	 * @param value
	 */
	public void setTransModelGroupName(String value) {
		transModelGroupName = value;
	}
	
	/**
	 * 返回任务模板Tag标记（0--该模板不可用；1--该模板可用）
	 * 
	 * @return
	 */
	public Integer getTransModelTag() {
		return transModelTag;
	}
	
	/**
	 * 设置任务模板Tag标记（0--该模板不可用；1--该模板可用）
	 * 
	 * @param value
	 */
	public void setTransModelTag(Integer value) {
		transModelTag = value;
	}
}
