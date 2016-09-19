package com.trs.rms.usermgr.bean;

import java.sql.Timestamp;

/**
 * RmsUserRole entity. @author MyEclipse Persistence Tools
 */

public class RmsUserRole implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3695188796109398230L;
	private Long userRoleId;
	private RmsUser rmsUser;
	private RmsRole rmsRole;
	private Timestamp createTime;
	private Timestamp updateTime;

	// Constructors

	/** default constructor */
	public RmsUserRole() {
	}

	/** full constructor */
	public RmsUserRole(RmsUser rmsUser, RmsRole rmsRole, Timestamp createTime,
			Timestamp updateTime) {
		this.rmsUser = rmsUser;
		this.rmsRole = rmsRole;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	// Property accessors

	public Long getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public RmsUser getRmsUser() {
		return this.rmsUser;
	}

	public void setRmsUser(RmsUser rmsUser) {
		this.rmsUser = rmsUser;
	}

	public RmsRole getRmsRole() {
		return this.rmsRole;
	}

	public void setRmsRole(RmsRole rmsRole) {
		this.rmsRole = rmsRole;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}