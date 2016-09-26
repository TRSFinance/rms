package com.trs.rms.usermgr.bean;

import java.sql.Timestamp;

/**
 * RmsUserLog entity. @author MyEclipse Persistence Tools
 */

public class RmsUserLog implements java.io.Serializable {

	// Fields

	private Long loginId;
	private String loginName;
	private String nickName;
	private String loginIp;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public RmsUserLog() {
	}

	/** minimal constructor */
	public RmsUserLog(Timestamp createTime) {
		this.createTime = createTime;
	}

	/** full constructor */
	public RmsUserLog(String loginName, String nickName, String loginIp,
			Timestamp createTime) {
		this.loginName = loginName;
		this.nickName = nickName;
		this.loginIp = loginIp;
		this.createTime = createTime;
	}

	// Property accessors

	public Long getLoginId() {
		return this.loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getLoginIp() {
		return this.loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}