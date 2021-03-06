package com.trs.rms.usermgr.bean;

import java.util.Date;

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
	private Date createTime;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public RmsUserRole() {
	}

	/** full constructor */
	public RmsUserRole(RmsUser rmsUser, RmsRole rmsRole, Date createTime,
			Date updateTime) {
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

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}