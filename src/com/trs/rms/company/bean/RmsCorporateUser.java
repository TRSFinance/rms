package com.trs.rms.company.bean;

import java.sql.Timestamp;
import java.util.Date;

import com.trs.rms.usermgr.bean.RmsUser;

/**
 * RmsCorporateUser entity. @author MyEclipse Persistence Tools
 */

public class RmsCorporateUser implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4307570205985772729L;
	private Long userId;
	private RmsUser rmsUser;
	private String corporateName;
	private String corporateTel;
	private String corporateMobile;
	private String corporateEmail;
	private String corporateInf;
	private Date createTime;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public RmsCorporateUser() {
	}

	/** minimal constructor */
	public RmsCorporateUser(RmsUser rmsUser, String corporateName,
			Date createTime, Date updateTime) {
		this.rmsUser = rmsUser;
		this.corporateName = corporateName;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public RmsCorporateUser(RmsUser rmsUser, String corporateName,
			String corporateTel, String corporateMobile, String corporateEmail,
			String corporateInf, Date createTime, Date updateTime) {
		this.rmsUser = rmsUser;
		this.corporateName = corporateName;
		this.corporateTel = corporateTel;
		this.corporateMobile = corporateMobile;
		this.corporateEmail = corporateEmail;
		this.corporateInf = corporateInf;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	// Property accessors

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public RmsUser getRmsUser() {
		return this.rmsUser;
	}

	public void setRmsUser(RmsUser rmsUser) {
		this.rmsUser = rmsUser;
	}

	public String getCorporateName() {
		return this.corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	public String getCorporateTel() {
		return this.corporateTel;
	}

	public void setCorporateTel(String corporateTel) {
		this.corporateTel = corporateTel;
	}

	public String getCorporateMobile() {
		return this.corporateMobile;
	}

	public void setCorporateMobile(String corporateMobile) {
		this.corporateMobile = corporateMobile;
	}

	public String getCorporateEmail() {
		return this.corporateEmail;
	}

	public void setCorporateEmail(String corporateEmail) {
		this.corporateEmail = corporateEmail;
	}

	public String getCorporateInf() {
		return this.corporateInf;
	}

	public void setCorporateInf(String corporateInf) {
		this.corporateInf = corporateInf;
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