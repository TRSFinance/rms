package com.trs.rms.usermgr.bean;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * RmsGroup entity. @author MyEclipse Persistence Tools
 */

public class RmsGroup implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7317695173791050550L;
	private Long groupId;
	private String groupName;
	private Integer isAllPerm;
	private Date createTime;
	private Date updateTime;
	private Set rmsGroupUsers = new HashSet(0);
	// Constructors
	/** default constructor */
	public RmsGroup() {
	}
	/** full constructor */
	public RmsGroup(String groupName, Integer isAllPerm, Date createTime,
			Date updateTime, Set rmsGroupUsers) {
		this.groupName = groupName;
		this.isAllPerm = isAllPerm;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.rmsGroupUsers = rmsGroupUsers;
	}
	// Property accessors
	public Long getGroupId() {
		return this.groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return this.groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Integer getIsAllPerm() {
		return this.isAllPerm;
	}
	public void setIsAllPerm(Integer isAllPerm) {
		this.isAllPerm = isAllPerm;
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

	public Set getRmsGroupUsers() {
		return this.rmsGroupUsers;
	}

	public void setRmsGroupUsers(Set rmsGroupUsers) {
		this.rmsGroupUsers = rmsGroupUsers;
	}

}