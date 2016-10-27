package com.trs.rms.risk.statrans.bean;

import java.util.Date;

/**
 * STA任务信息
 *
 * @author clinzy 2012-3-15
 * @author 邹许红       2016/10/27
 *
 */
public class STATransInfo {
	/**
	 * 任务在MySQL中的记录ID
	 */
	private Long id;

	/**
	 * 任务ID
	 */
	private Integer transId;

	/**
	 * 任务CheckCode
	 */
	private String transCheckCode;

	/**
	 * 任务名称
	 */
	private String transName;

	/**
	 * 任务描述
	 */
	private String transDefine;

	/**
	 * 任务类型
	 */
	private String transType;

	/**
	 * radar往base库导数据任务和基本分析任务，数据分析类型列表（transDataAnalysisType）
	 */
	private String transDAType;

	/**
	 * 任务创建者
	 */
	private String transCreator;

	/**
	 * 任务创建时间
	 */
	private Date transCreationTime;

	/**
	 * 任务最近修改时间
	 */
	private Date transLatestModifyTime;

	/**
	 * 任务提交状态
	 */
	private Integer transSubTag;

	/**
	 * 任务是否可被删除
	 */
	private Integer transDelable;

	/**
	 * 任务组标记
	 */
	private Integer transGroupTag;

	/**
	 * 任务模板ID
	 */
	private Integer transModelId;

	/**
	 * 任务数据来源标记
	 */
	private Integer transSourceDBTag;

	/**
	 * 任务数据存储标记
	 */
	private Integer transStorageDBTag;

	/**
	 * 任务对应的记录主键
	 */
	private String transPkey;

	/**
	 * 任务提交的STA服务器信息
	 */
	private String transSTAServerInfo;

	/**
	 * 任务的运行状态
	 */
	private Integer transState;

	/**
	 * 任务的运行状态描述
	 */
	private String transStateDesc;

	/**
	 * 任务下一次执行时间
	 */
	private String transExecTime;

	/** 任务配置参数. */
	private String transConfig;

	/**
	 * 构造函数
	 */
	public STATransInfo() {
		super();
	}

	/**
	 * 返回任务在MySQL中的记录ID
	 *
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置任务在MySQL中的记录ID
	 *
	 * @param value
	 */
	public void setId(Long value) {
		id = value;
	}

	/**
	 * 返回任务ID
	 *
	 * @return
	 */
	public Integer getTransId() {
		return transId;
	}

	/**
	 * 设置任务ID
	 *
	 * @param value
	 */
	public void setTransId(Integer value) {
		transId = value;
	}

	/**
	 * 返回任务CheckCode
	 *
	 * @return
	 */
	public String getTransCheckCode() {
		return transCheckCode;
	}

	/**
	 * 设置任务CheckCode
	 *
	 * @param value
	 */
	public void setTransCheckCode(String value) {
		transCheckCode = value;
	}

	/**
	 * 返回任务名称
	 *
	 * @return
	 */
	public String getTransName() {
		return transName;
	}

	/**
	 * 设置任务名称
	 *
	 * @param value
	 */
	public void setTransName(String value) {
		transName = value;
	}

	/**
	 * 返回任务描述
	 *
	 * @return
	 */
	public String getTransDefine() {
		return transDefine;
	}

	/**
	 * 设置任务描述
	 *
	 * @param value
	 */
	public void setTransDefine(String value) {
		transDefine = value;
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
	 * 返回radar往base库导数据任务和基本分析任务，数据分析类型列表（transDataAnalysisType）
	 *
	 * @return
	 */
	public String getTransDAType() {
		return transDAType;
	}

	/**
	 * 设置radar往base库导数据任务和基本分析任务，数据分析类型列表（transDataAnalysisType）
	 *
	 * @param value
	 */
	public void setTransDAType(String value) {
		transDAType = value;
	}

	/**
	 * 返回任务创建者
	 *
	 * @return
	 */
	public String getTransCreator() {
		return transCreator;
	}

	/**
	 * 设置任务创建者
	 *
	 * @param value
	 */
	public void setTransCreator(String value) {
		transCreator = value;
	}

	/**
	 * 返回任务创建时间
	 *
	 * @return
	 */
	public Date getTransCreationTime() {
		return transCreationTime;
	}

	/**
	 * 设置任务创建时间
	 *
	 * @param value
	 */
	public void setTransCreationTime(Date value) {
		transCreationTime = value;
	}

	/**
	 * 返回任务最近修改时间
	 *
	 * @return
	 */
	public Date getTransLatestModifyTime() {
		return transLatestModifyTime;
	}

	/**
	 * 设置任务最近修改时间
	 *
	 * @param value
	 */
	public void setTransLatestModifyTime(Date value) {
		transLatestModifyTime = value;
	}

	/**
	 * 返回任务提交状态
	 *
	 * @return
	 */
	public Integer getTransSubTag() {
		return transSubTag;
	}

	/**
	 * 设置任务提交状态
	 *
	 * @param value
	 */
	public void setTransSubTag(Integer value) {
		transSubTag = value;
	}

	/**
	 * 返回任务是否可被删除
	 *
	 * @return
	 */
	public Integer getTransDelable() {
		return transDelable;
	}

	/**
	 * 设置任务是否可被删除
	 *
	 * @param value
	 */
	public void setTransDelable(Integer value) {
		transDelable = value;
	}

	/**
	 * 返回任务组标记
	 *
	 * @return
	 */
	public Integer getTransGroupTag() {
		return transGroupTag;
	}

	/**
	 * 设置任务组标记
	 *
	 * @param value
	 */
	public void setTransGroupTag(Integer value) {
		transGroupTag = value;
	}

	/**
	 * 返回任务模型ID
	 *
	 * @return
	 */
	public Integer getTransModelId() {
		return transModelId;
	}

	/**
	 * 设置任务模型ID
	 *
	 * @param value
	 */
	public void setTransModelId(Integer value) {
		transModelId = value;
	}

	/**
	 * 返回任务数据来源标记
	 *
	 * @return
	 */
	public Integer getTransSourceDBTag() {
		return transSourceDBTag;
	}

	/**
	 * 设置任务数据来源标记
	 *
	 * @param value
	 */
	public void setTransSourceDBTag(Integer value) {
		transSourceDBTag = value;
	}

	/**
	 * 返回任务数据存储标记
	 *
	 * @return
	 */
	public Integer getTransStorageDBTag() {
		return transStorageDBTag;
	}

	/**
	 * 设置任务数据存储标记
	 *
	 * @param value
	 */
	public void setTransStorageDBTag(Integer value) {
		transStorageDBTag = value;
	}

	/**
	 * 返回任务对应的记录主键
	 *
	 * @return
	 */
	public String getTransPkey() {
		return transPkey;
	}

	/**
	 * 设置任务对应的记录主键
	 *
	 * @param value
	 */
	public void setTransPkey(String value) {
		transPkey = value;
	}

	/**
	 * 返回任务提交的STA服务器信息
	 *
	 * @return
	 */
	public String getTransSTAServerInfo() {
		return transSTAServerInfo;
	}

	/**
	 * 设置任务提交的STA服务器信息
	 *
	 * @param value
	 */
	public void setTransSTAServerInfo(String value) {
		transSTAServerInfo = value;
	}

	/**
	 * 返回任务的运行状态
	 *
	 * @return
	 */
	public Integer getTransState() {
		return transState;
	}

	/**
	 * 设置任务的运行状态
	 *
	 * @param value
	 */
	public void setTransState(Integer value) {
		transState = value;
	}

	/**
	 * 返回任务的运行状态描述
	 *
	 * @return
	 */
	public String getTransStateDesc() {
		return transStateDesc;
	}

	/**
	 * 设置任务的运行状态描述
	 *
	 * @param value
	 */
	public void setTransStateDesc(String value) {
		transStateDesc = value;
	}

	/**
	 * 返回任务下一次执行时间
	 *
	 * @return
	 */
	public String getTransExecTime() {
		return transExecTime;
	}

	/**
	 * 设置任务下一次执行时间
	 *
	 * @param value
	 */
	public void setTransExecTime(String value) {
		transExecTime = value;
	}

	public String getTransConfig() {
		return transConfig;
	}

	public void setTransConfig(String transConfig) {
		this.transConfig = transConfig;
	}
}
