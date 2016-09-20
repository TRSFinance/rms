package com.trs.rms.usermgr.bean;

import java.util.Date;


/**
 * RmsGroupUser entity. @author MyEclipse Persistence Tools
 */

public class RmsGroupUser implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4000566190356187692L;
	private Long groupUserId;
	private RmsUser rmsUser;
	private RmsGroup rmsGroup;
	private Date createTime;

	// Constructors

	/** default constructor */
	public RmsGroupUser() {
	}

	/** full constructor */
	public RmsGroupUser(RmsUser rmsUser, RmsGroup rmsGroup, Date createTime) {
		this.rmsUser = rmsUser;
		this.rmsGroup = rmsGroup;
		this.createTime = createTime;
	}

	// Property accessors

	public Long getGroupUserId() {
		return this.groupUserId;
	}

	public void setGroupUserId(Long groupUserId) {
		this.groupUserId = groupUserId;
	}

	public RmsUser getRmsUser() {
		return this.rmsUser;
	}

	public void setRmsUser(RmsUser rmsUser) {
		this.rmsUser = rmsUser;
	}

	public RmsGroup getRmsGroup() {
		return this.rmsGroup;
	}

	public void setRmsGroup(RmsGroup rmsGroup) {
		this.rmsGroup = rmsGroup;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}