package com.trs.rms.rulemgr.bean;

import java.util.Date;

/**
 * 模板同步日志
 * @author chang
 * @since 2013-4-10 14:15:05
 */
public class TemplateSyncLog {

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
	 * 同步操作用户id
	 */
	private Long userId;
	/**
	 * 开始同步时间，该时间一定小于successTime或failureTime中不为null的那个。
	 */
	private Date syncTime;
	/**
	 * 得知同步成功完成的时间，与failureTime二者有且仅有一个为空
	 */
	private Date successTime;

	/**
	 * 得知同步失败的时间，与successTime二者有且仅有一个为空
	 */
	private Date failureTime;
	/**
	 * 失败原因
	 */
	private String failure;
	/**
	 * 同步IP信息
	 */
	private String ip;

	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Date getSyncTime() {
		return syncTime;
	}
	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}
	public Date getSuccessTime() {
		return successTime;
	}
	public void setSuccessTime(Date successTime) {
		this.successTime = successTime;
	}
	public Date getFailureTime() {
		return failureTime;
	}
	public void setFailureTime(Date failureTime) {
		this.failureTime = failureTime;
	}
	public String getFailure() {
		return failure;
	}
	public void setFailure(String failure) {
		this.failure = failure;
	}

}
