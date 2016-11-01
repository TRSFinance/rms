package com.trs.rms.rulemgr.bean;

import java.util.Date;

/**
 * 模板同步统计
 * @author chang
 * @since 2013-4-10 14:15:05
 */
public class TemplateSyncStat {
	private Long id;
	/**
	 * 模板id
	 */
	private Long templateId;
	/**
	 * das服务器id
	 */
	private Long dasId;
	/**
	 * 同步次数，默认值为0
	 */
	private Integer syncTimes;
	/**
	 * 成功次数，默认值为0
	 */
	private Integer successTimes;
	/**
	 * 失败次数，默认值为0
	 */
	private Integer failureTimes;
	/**
	 * 最近一次同步完成时间，该时间等于lastSuccessTime或者lastFailureTime
	 */
	private Date lastSyncTime;
	/**
	 * 最近一次同步成功时间
	 */
	private Date lastSuccessTime;
	/**
	 * 最近一次同步失败时间
	 */
	private Date lastFailureTime;
//	 /**
//	  * 最近一次同步是成功还是失败，1表示成功
//	  */
//	private Boolean lastSuccess;


	//========================================
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTemplateId() {
		return templateId;
	}
	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}
	public Long getDasId() {
		return dasId;
	}
	public void setDasId(Long dasId) {
		this.dasId = dasId;
	}
	public Integer getSyncTimes() {
		return syncTimes;
	}
	public void setSyncTimes(Integer syncTimes) {
		this.syncTimes = syncTimes;
	}
	public Integer getSuccessTimes() {
		return successTimes;
	}
	public void setSuccessTimes(Integer successTimes) {
		this.successTimes = successTimes;
	}
	public Integer getFailureTimes() {
		return failureTimes;
	}
	public void setFailureTimes(Integer failureTimes) {
		this.failureTimes = failureTimes;
	}
	public Date getLastSyncTime() {
		return lastSyncTime;
	}
	public void setLastSyncTime(Date lastSyncTime) {
		this.lastSyncTime = lastSyncTime;
	}
	public Date getLastSuccessTime() {
		return lastSuccessTime;
	}
	public void setLastSuccessTime(Date lastSuccessTime) {
		this.lastSuccessTime = lastSuccessTime;
	}
	public Date getLastFailureTime() {
		return lastFailureTime;
	}
	public void setLastFailureTime(Date lastFailureTime) {
		this.lastFailureTime = lastFailureTime;
	}
	/*public Boolean getLastSuccess() {
		return lastSuccess;
	}
	public void setLastSuccess(Boolean lastSuccess) {
		this.lastSuccess = lastSuccess;
	}*/
}
