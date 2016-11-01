package com.trs.rms.rulemgr.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.trs.rms.risk.statrans.bean.STATransConfInfo;

/**
 * CKM模板对应的实体类。
 * @author wengjing
 *
 */
public class CkmTemplate {
	//fields	---------------------------------------------------------------------
	/**
	 * 分类方式：按句分类。
	 */
	public static final int CLASSIFY_BY_SEN=1;
	/**
	 * 分类方式：按句分类（返回权值）。
	 */
	public static final int CLASSIFY_BY_SEN_WEIGHT=2;
	/**
	 * 分类方式：按句分类（返回规则数）。
	 */
	public static final int CLASSIFY_BY_SEN_RULE=3;
	/**
	 * 分类方式：按篇分类（返回规则数）。
	 */
	public static final int CLASSIFY_BY_DOC_RULE=4;
	/**
	 * 分类方式：按篇分类（默认）。
	 */
	public static final int CLASSIFY_BY_DOC=5;
	/**
	 * 模板ID
	 */
	private Long id;
	/**
	 * 模板名称
	 */
	private String name;
	/**
	 * 模板使用的分类方式
	 */
	private Integer classify=5;
	/**
	 * 匹配规则最大返回长度
	 */
	private Integer maxRules=8192;
	/**
	 * 模板最后修改的时间
	 */
	private Date lastModified;
	/**
	 * 舆情分析库中用于保存该模板分类的字段名
	 */
	private String fieldName;
	/**
	 * 模板对应的规则频次配置。
	 */
	private List<CkmRuleFrequency> ruleFrequencys=new ArrayList<CkmRuleFrequency>();
	/**
	 * 模板对应的DAS服务器列表
	 */
	private Set<STATransConfInfo> servers;
	/**
	 * 模板同步状态
	 */
	private String syncStatus;
	/**
	 * 模板最近一次同步时间
	 */
	private Date lastSyncTime;

	/** 父模板. */
	private CkmTemplate parentTemplate;

	/**
	 * 命中点给出方式（1：规则方式；2：其它方式）
	 */
	private Integer tipType;
	//methods	---------------------------------------------------------------------

	//accessors	---------------------------------------------------------------------
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getClassify() {
		return classify;
	}
	public void setClassify(Integer classify) {
		this.classify = classify;
	}
	public Integer getMaxRules() {
		return maxRules;
	}
	public void setMaxRules(Integer maxRules) {
		this.maxRules = maxRules;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public List<CkmRuleFrequency> getRuleFrequencys() {
		return ruleFrequencys;
	}
	public void setRuleFrequencys(List<CkmRuleFrequency> ruleFrequencys) {
		this.ruleFrequencys = ruleFrequencys;
	}
	public Set<STATransConfInfo> getServers() {
		return servers;
	}
	public void setServers(Set<STATransConfInfo> servers) {
		this.servers = servers;
	}
	public String getSyncStatus() {
		return syncStatus;
	}
	public void setSyncStatus(String syncStatus) {
		this.syncStatus = syncStatus;
	}
	public Date getLastSyncTime() {
		return lastSyncTime;
	}
	public void setLastSyncTime(Date lastSyncTime) {
		this.lastSyncTime = lastSyncTime;
	}
	public CkmTemplate getParentTemplate() {
		return parentTemplate;
	}

	public void setParentTemplate(CkmTemplate parentTemplate) {
		this.parentTemplate = parentTemplate;
	}

	public void setTipType(Integer tipType) {
		this.tipType = tipType;
	}

	public Integer getTipType() {
		return tipType;
	}
}
