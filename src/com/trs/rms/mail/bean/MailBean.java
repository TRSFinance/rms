package com.trs.rms.mail.bean;

import java.util.Date;

/**
 * 邮件对象.
 */
public class MailBean {

	/** 邮件状态，等待发送. */
	public static final Integer STATUS_WAIT=0;

	/** 邮件状态，正在发送. */
	public static final Integer STATUS_SENDING=1;

	/** 邮件状态，发送成功. */
	public static final Integer STATUS_SUCCESS=3;

	/** 邮件状态，发送失败. */
	public static final Integer STATUS_FAIL=2;

	/** 邮件ID. */
	private Long id;

	/** 来源模块. */
	private String module;

	/** 邮件标题. */
	private String title;

	/** 邮件对应的eml文件. */
	private String fileName;

	/** 邮件的创建时间. */
	private Date creationDate;

	/** 发送次数，未发送为0，每次发送失败后加1. */
	private Integer sendTimes;

	/** 邮件状态，0-等待发送，1-正在发送，2-发送成功，3-发送失败 */
	private Integer status;

	/** 乐观锁. */
	private Integer version;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getSendTimes() {
		return sendTimes;
	}

	public void setSendTimes(Integer sendTimes) {
		this.sendTimes = sendTimes;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	/**
	 * 获取邮件状态.
	 *
	 * @return 0-等待发送，1-正在发送，2-发送成功，3-发送失败
	 */
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}
}
