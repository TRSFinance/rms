package com.trs.rms.usermgr.bean;

import java.util.Date;

/**
 * RmsRolePerm entity. @author MyEclipse Persistence Tools
 */

public class RmsRolePerm implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 202385329362918615L;
	private Long rolePermId;
	private RmsRole rmsRole;
	private String rolePerms;
	private Date createTime;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public RmsRolePerm() {
	}

	/** minimal constructor */
	public RmsRolePerm(RmsRole rmsRole) {
		this.rmsRole = rmsRole;
	}

	/** full constructor */
	public RmsRolePerm(RmsRole rmsRole, String rolePerms, Date createTime,
			Date updateTime) {
		this.rmsRole = rmsRole;
		this.rolePerms = rolePerms;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	// Property accessors

	public Long getRolePermId() {
		return this.rolePermId;
	}

	public void setRolePermId(Long rolePermId) {
		this.rolePermId = rolePermId;
	}

	public RmsRole getRmsRole() {
		return this.rmsRole;
	}

	public void setRmsRole(RmsRole rmsRole) {
		this.rmsRole = rmsRole;
	}

	public String getRolePerms() {
		return this.rolePerms;
	}

	public void setRolePerms(String rolePerms) {
		this.rolePerms = rolePerms;
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