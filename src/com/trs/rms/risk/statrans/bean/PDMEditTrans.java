package com.trs.rms.risk.statrans.bean;

/**
 * 编辑任务界面数据模型
 *
 * @author clinzy 2012-4-11
 * @author zxh    2016-10-31
 *
 */
public class PDMEditTrans {
	/**
	 * 任务名称
	 */
	protected String transName;

	/**
	 * 来源数据库地址
	 */
	protected String sourceDBHost;

	/**
	 * 来源数据库端口
	 */
	protected String sourceDBPort;

	/**
	 * 来源数据库用户名
	 */
	protected String sourceDBUser;

	/**
	 * 来源数据库口令
	 */
	protected String sourceDBPassword;

	/**
	 * 来源数据库数据库
	 */
	protected String sourceDBService;

	/**
	 * 来源数据库表
	 */
	protected String sourceDBTable;

	/**
	 * 存储数据库地址
	 */
	protected String storageDBHost;

	/**
	 * 存储数据库口令
	 */
	protected String storageDBPort;

	/**
	 * 存储数据库用户名
	 */
	protected String storageDBUser;

	/**
	 * 存储数据库口令
	 */
	protected String storageDBPassword;

	/**
	 * 存储数据库数据库
	 */
	protected String storageDBService;

	/**
	 * 存储数据库表
	 */
	protected String storageDBTable;

	/**
	 * 数据分析抽取关键词CKM服务器地址
	 */
	private String ckmHost;

	/**
	 * 数据分析抽取关键词CKM服务器端口
	 */
	private String ckmPort;

	/**
	 * 数据分析抽取关键词CKM服务器用户名
	 */
	private String ckmUser;

	/**
	 * 数据分析抽取关键词CKM服务器口令
	 */
	private String ckmPassword;

	/**
	 * 检索表达式
	 */
	protected String searchExpression;

	/**
	 * 分析最近N天的数据(多个天数之间以英文半角分号“;”隔开)
	 */
	protected String dateInter;

	/**
	 * 任务标记
	 */
	protected String taskTag;

	/**
	 * 定时设置类型（0;1;2;3 -- 手动;执行一次;周期;星期）
	 */
	protected Integer tiType;

	/**
	 * 执行一次设置--执行时间
	 */
	protected String time;

	/**
	 * 周期执行设置--起始时刻
	 */
	protected String periodTime;

	/**
	 * 周期执行设置--周期值
	 */
	protected Integer periodValue;

	/**
	 * 周期执行设置--周期单位
	 */
	protected String periodUnit;

	/**
	 * 任务描述
	 */
	protected String transDefine;

	/**
	 * 排重服务器列表（host:port,host:port）
	 */
	protected String simServerInfoList;

	/**
	 * 排重模板名称
	 */
	protected String simModelName;

	/**
	 * 构造函数
	 */
	public PDMEditTrans() {

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
	 * 返回来源数据库地址
	 *
	 * @return
	 */
	public String getSourceDBHost() {
		return sourceDBHost;
	}

	/**
	 * 设置来源数据库地址
	 *
	 * @param value
	 */
	public void setSourceDBHost(String value) {
		sourceDBHost = value;
	}

	/**
	 * 返回来源数据库端口
	 *
	 * @return
	 */
	public String getSourceDBPort() {
		return sourceDBPort;
	}

	/**
	 * 设置来源数据库端口
	 *
	 * @param value
	 */
	public void setSourceDBPort(String value) {
		sourceDBPort = value;
	}

	/**
	 * 返回来源数据库用户名
	 *
	 * @return
	 */
	public String getSourceDBUser() {
		return sourceDBUser;
	}

	/**
	 * 设置来源数据库用户名
	 *
	 * @param value
	 */
	public void setSourceDBUser(String value) {
		sourceDBUser = value;
	}

	/**
	 * 返回来源数据库口令
	 *
	 * @return
	 */
	public String getSourceDBPassword() {
		return sourceDBPassword;
	}

	/**
	 * 设置来源数据库口令
	 *
	 * @param value
	 */
	public void setSourceDBPassword(String value) {
		sourceDBPassword = value;
	}

	/**
	 * 返回来源数据库数据库
	 *
	 * @return
	 */
	public String getSourceDBService() {
		return sourceDBService;
	}

	/**
	 * 设置来源数据库数据库
	 *
	 * @param value
	 */
	public void setSourceDBService(String value) {
		sourceDBService = value;
	}

	/**
	 * 返回来源数据库表
	 *
	 * @return
	 */
	public String getSourceDBTable() {
		return sourceDBTable;
	}

	/**
	 * 设置来源数据库表
	 *
	 * @param value
	 */
	public void setSourceDBTable(String value) {
		sourceDBTable = value;
	}

	/**
	 * 返回存储数据库地址
	 *
	 * @return
	 */
	public String getStorageDBHost() {
		return storageDBHost;
	}

	/**
	 * 设置存储数据库地址
	 *
	 * @param value
	 */
	public void setStorageDBHost(String value) {
		storageDBHost = value;
	}

	/**
	 * 返回存储数据库端口
	 *
	 * @return
	 */
	public String getStorageDBPort() {
		return storageDBPort;
	}

	/**
	 * 设置存储数据库端口
	 *
	 * @param value
	 */
	public void setStorageDBPort(String value) {
		storageDBPort = value;
	}

	/**
	 * 返回存储数据库用户名
	 *
	 * @return
	 */
	public String getStorageDBUser() {
		return storageDBUser;
	}

	/**
	 * 设置存储数据库用户名
	 *
	 * @param value
	 */
	public void setStorageDBUser(String value) {
		storageDBUser = value;
	}

	/**
	 * 返回存储数据库口令
	 *
	 * @return
	 */
	public String getStorageDBPassword() {
		return storageDBPassword;
	}

	/**
	 * 设置存储数据库口令
	 *
	 * @param value
	 */
	public void setStorageDBPassword(String value) {
		storageDBPassword = value;
	}

	/**
	 * 返回存储数据库数据库
	 *
	 * @return
	 */
	public String getStorageDBService() {
		return storageDBService;
	}

	/**
	 * 设置存储数据库数据库
	 *
	 * @param value
	 */
	public void setStorageDBService(String value) {
		storageDBService = value;
	}

	/**
	 * 返回存储数据库表
	 *
	 * @return
	 */
	public String getStorageDBTable() {
		return storageDBTable;
	}

	/**
	 * 设置存储数据库表
	 *
	 * @param value
	 */
	public void setStorageDBTable(String value) {
		storageDBTable = value;
	}

	/**
	 * 返回数据分析抽取关键词CKM服务器地址
	 *
	 * @return
	 */
	public String getCkmHost() {
		return ckmHost;
	}

	/**
	 * 设置数据分析抽取关键词CKM服务器地址
	 *
	 * @param value
	 */
	public void setCkmHost(String value) {
		ckmHost = value;
	}

	/**
	 * 返回数据分析抽取关键词CKM服务器端口
	 *
	 * @return
	 */
	public String getCkmPort() {
		return ckmPort;
	}

	/**
	 * 设置数据分析抽取关键词CKM服务器端口
	 *
	 * @param value
	 */
	public void setCkmPort(String value) {
		ckmPort = value;
	}

	/**
	 * 返回数据分析抽取关键词CKM服务器用户名
	 *
	 * @return
	 */
	public String getCkmUser() {
		return ckmUser;
	}

	/**
	 * 设置数据分析抽取关键词CKM服务器用户名
	 *
	 * @param value
	 */
	public void setCkmUser(String value) {
		ckmUser = value;
	}

	/**
	 * 返回数据分析抽取关键词CKM服务器口令
	 *
	 * @return
	 */
	public String getCkmPassword() {
		return ckmPassword;
	}

	/**
	 * 设置数据分析抽取关键词CKM服务器口令
	 *
	 * @param value
	 */
	public void setCkmPassword(String value) {
		ckmPassword = value;
	}

	/**
	 * 返回检索表达式
	 *
	 * @return
	 */
	public String getSearchExpression() {
		return searchExpression;
	}

	/**
	 * 设置检索表达式
	 *
	 * @param value
	 */
	public void setSearchExpression(String value) {
		searchExpression = value;
	}

	/**
	 * 返回分析最近N添加的数据(多个天数之间以英文半角分号“;”隔开)
	 *
	 * @return
	 */
	public String getDateInter() {
		return dateInter;
	}

	/**
	 * 设置分析最近N添加的数据(多个天数之间以英文半角分号“;”隔开)
	 *
	 * @param value
	 */
	public void setDateInter(String value) {
		dateInter = value;
	}

	/**
	 * 返回任务标记
	 *
	 * @return
	 */
	public String getTaskTag() {
		return taskTag;
	}

	/**
	 * 设置任务标记
	 *
	 * @param value
	 */
	public void setTaskTag(String value) {
		taskTag = value;
	}

	/**
	 * 返回定时设置类型（0;1;2;3 -- 手动;执行一次;周期;星期）
	 *
	 * @return
	 */
	public Integer getTiType() {
		return tiType;
	}

	/**
	 * 设置定时设置类型（0;1;2;3 -- 手动;执行一次;周期;星期）
	 *
	 * @param value
	 */
	public void setTiType(Integer value) {
		tiType = value;
	}

	/**
	 * 返回执行一次设置--执行时间
	 *
	 * @return
	 */
	public String getTime() {
		return time;
	}

	/**
	 * 设置执行一次设置--执行时间
	 *
	 * @param value
	 */
	public void setTime(String value) {
		time =  value;
	}

	/**
	 * 返回周期执行设置--起始时刻
	 *
	 * @return
	 */
	public String getPeriodTime() {
		return periodTime;
	}

	/**
	 * 设置周期执行设置--起始时刻
	 *
	 * @param value
	 */
	public void setPeriodTime(String value) {
		periodTime = value;
	}

	/**
	 * 返回周期执行设置--周期值
	 *
	 * @return
	 */
	public Integer getPeriodValue() {
		return periodValue;
	}

	/**
	 * 设置周期执行设置--周期值
	 *
	 * @param value
	 */
	public void setPeriodValue(Integer value) {
		periodValue = value;
	}

	/**
	 * 返回周期执行设置--周期单位
	 *
	 * @return
	 */
	public String getPeriodUnit() {
		return periodUnit;
	}

	/**
	 * 设置周期执行设置--周期单位
	 *
	 * @param value
	 */
	public void setPeriodUnit(String value) {
		periodUnit = value;
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
	 * 返回排重服务器列表（host:port,host:port）
	 *
	 * @return
	 */
	public String getSimServerInfoList() {
		return simServerInfoList;
	}

	/**
	 * 设置排重服务器列表（host:port,host:port）
	 *
	 * @param value
	 */
	public void setSimServerInfoList(String value) {
		simServerInfoList = value;
	}

	/**
	 * 返回排重模板名称
	 *
	 * @return
	 */
	public String getSimModelName() {
		return simModelName;
	}

	/**
	 * 设置排重模板名称
	 *
	 * @param value
	 */
	public void setSimModelName(String value) {
		simModelName = value;
	}
}
