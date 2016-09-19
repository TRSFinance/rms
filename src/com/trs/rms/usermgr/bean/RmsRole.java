package com.trs.rms.usermgr.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * RmsRole entity. @author MyEclipse Persistence Tools
 */

public class RmsRole implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -471571840409868355L;
	private Long roleId;
	private String roleName;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Integer isAllPerm;
	private String description;
	private Integer priority;
	private Set rmsRolePerms = new HashSet(0);
	private Set rmsUserRoles = new HashSet(0);

	// Constructors

	/** default constructor */
	public RmsRole() {
	}

	/** minimal constructor */
	public RmsRole(String roleName, Timestamp createTime, Timestamp updateTime,
			Integer isAllPerm) {
		this.roleName = roleName;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isAllPerm = isAllPerm;
	}

	/** full constructor */
	public RmsRole(String roleName, Timestamp createTime, Timestamp updateTime,
			Integer isAllPerm, String description, Integer priority,
			Set rmsRolePerms, Set rmsUserRoles) {
		this.roleName = roleName;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isAllPerm = isAllPerm;
		this.description = description;
		this.priority = priority;
		this.rmsRolePerms = rmsRolePerms;
		this.rmsUserRoles = rmsUserRoles;
	}

	// Property accessors

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	public Integer getIsAllPerm() {
		return this.isAllPerm;
	}

	public void setIsAllPerm(Integer isAllPerm) {
		this.isAllPerm = isAllPerm;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPriority() {
		return this.priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Set getRmsRolePerms() {
		return this.rmsRolePerms;
	}

	public void setRmsRolePerms(Set rmsRolePerms) {
		this.rmsRolePerms = rmsRolePerms;
	}

	public Set getRmsUserRoles() {
		return this.rmsUserRoles;
	}

	public void setRmsUserRoles(Set rmsUserRoles) {
		this.rmsUserRoles = rmsUserRoles;
	}

}