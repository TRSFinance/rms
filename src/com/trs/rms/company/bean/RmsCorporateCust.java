package com.trs.rms.company.bean;

import java.util.Date;



/**
 * RmsCompanyInfo entity. @author MyEclipse Persistence Tools
 */

public class RmsCorporateCust implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4556271010591966354L;
    private  Long   corporateCustId;
    private Date createTime;
    private RmsCompanyInfo companyInfo;
    private RmsCorporateUser corporateUser;

    
	public RmsCompanyInfo getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(RmsCompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}

	public RmsCorporateUser getCorporateUser() {
		return corporateUser;
	}

	public void setCorporateUser(RmsCorporateUser corporateUser) {
		this.corporateUser = corporateUser;
	}

	public Long getCorporateCustId() {
		return corporateCustId;
	}

	public void setCorporateCustId(Long corporateCustId) {
		this.corporateCustId = corporateCustId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
    
    
    
    
	

}