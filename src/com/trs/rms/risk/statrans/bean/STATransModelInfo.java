package com.trs.rms.risk.statrans.bean;

/**
 * STA任务模板信息
 *
 * @author clinzy 2012-3-20
 * @author 邹许红      2016-10-27
 *
 */
public class STATransModelInfo {
	/**
	 * 任务模板在MySQL中的记录ID
	 */
	private Long id;

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

	/** 任务的Velocity模板名. */
	private String vmTemplate;

	/** 初始的任务参数配置. */
	private String initConfig;

	/**
	 * 构造函数
	 */
	public STATransModelInfo() {

	}

	/**
	 * 返回任务模板在MySQL中的记录ID
	 *
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置任务模板在MySQL中的记录ID
	 *
	 * @param value
	 */
	public void setId(Long value) {
		id = value;
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

	public String getVmTemplate() {
		return vmTemplate;
	}

	public void setVmTemplate(String vmTemplate) {
		this.vmTemplate = vmTemplate;
	}

	public String getInitConfig() {
		return initConfig;
	}

	public void setInitConfig(String initConfig) {
		this.initConfig = initConfig;
	}
}
