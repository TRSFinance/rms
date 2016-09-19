package com.trs.rms.usermgr.bean;

import java.sql.Timestamp;

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
	private Timestamp createTime;
	private Timestamp updateTime;

	// Constructors

	/** default constructor */
	public RmsRolePerm() {
	}

	/** minimal constructor */
	public RmsRolePerm(RmsRole rmsRole) {
		this.rmsRole = rmsRole;
	}

	/** full constructor */
	public RmsRolePerm(RmsRole rmsRole, String rolePerms, Timestamp createTime,
			Timestamp updateTime) {
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