package com.trs.rms.usermgr.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * RmsUser entity. @author MyEclipse Persistence Tools
 */

public class RmsUser implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 9022624800176669266L;
	private Long userId;
	private String loginName;
	private String userPawd;
	private String nickName;
	private Integer userState;
	private String userInfo;
	private Timestamp createTime;
	private Timestamp updateTime;
	private String createUser;
	private String updateUser;
	private String email;
	private String mobile;
	private Integer failCount;
	private Set rmsUserRoles = new HashSet(0);
	private Set rmsGroupUsers = new HashSet(0);

	// Constructors

	/** default constructor */
	public RmsUser() {
	}

	/** minimal constructor */
	public RmsUser(String loginName, String userPawd, Integer userState,
			Timestamp createTime, Timestamp updateTime) {
		this.loginName = loginName;
		this.userPawd = userPawd;
		this.userState = userState;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public RmsUser(String loginName, String userPawd, String nickName,
			Integer userState, String userInfo, Timestamp createTime,
			Timestamp updateTime, String createUser, String updateUser,
			String email, String mobile, Integer failCount, Set rmsUserRoles,
			Set rmsGroupUsers) {
		this.loginName = loginName;
		this.userPawd = userPawd;
		this.nickName = nickName;
		this.userState = userState;
		this.userInfo = userInfo;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.createUser = createUser;
		this.updateUser = updateUser;
		this.email = email;
		this.mobile = mobile;
		this.failCount = failCount;
		this.rmsUserRoles = rmsUserRoles;
		this.rmsGroupUsers = rmsGroupUsers;
	}

	// Property accessors

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserPawd() {
		return this.userPawd;
	}

	public void setUserPawd(String userPawd) {
		this.userPawd = userPawd;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getUserState() {
		return this.userState;
	}

	public void setUserState(Integer userState) {
		this.userState = userState;
	}

	public String getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
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

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getFailCount() {
		return this.failCount;
	}

	public void setFailCount(Integer failCount) {
		this.failCount = failCount;
	}

	public Set getRmsUserRoles() {
		return this.rmsUserRoles;
	}

	public void setRmsUserRoles(Set rmsUserRoles) {
		this.rmsUserRoles = rmsUserRoles;
	}

	public Set getRmsGroupUsers() {
		return this.rmsGroupUsers;
	}

	public void setRmsGroupUsers(Set rmsGroupUsers) {
		this.rmsGroupUsers = rmsGroupUsers;
	}

}