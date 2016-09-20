package com.trs.rms.usermgr.bean;

import java.util.Date;
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
	private Date createTime;
	private Date updateTime;
	private Integer isAllPerm;
	private String description;
	private Integer priority;
	private RmsRolePerm rmsRolePerm;
	private Set rmsUserRoles = new HashSet(0);

	// Constructors

	/** default constructor */
	public RmsRole() {
	}

	/** minimal constructor */
	public RmsRole(String roleName, Date createTime, Date updateTime,
			Integer isAllPerm) {
		this.roleName = roleName;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isAllPerm = isAllPerm;
	}

	/** full constructor */
	public RmsRole(String roleName, Date createTime, Date updateTime,
			Integer isAllPerm, String description, Integer priority,
			RmsRolePerm rmsRolePerm, Set rmsUserRoles) {
		this.roleName = roleName;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isAllPerm = isAllPerm;
		this.description = description;
		this.priority = priority;
		this.rmsRolePerm = rmsRolePerm;
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

	

	public RmsRolePerm getRmsRolePerm() {
		return rmsRolePerm;
	}

	public void setRmsRolePerm(RmsRolePerm rmsRolePerm) {
		this.rmsRolePerm = rmsRolePerm;
	}

	public Set getRmsUserRoles() {
		return this.rmsUserRoles;
	}

	public void setRmsUserRoles(Set rmsUserRoles) {
		this.rmsUserRoles = rmsUserRoles;
	}

}