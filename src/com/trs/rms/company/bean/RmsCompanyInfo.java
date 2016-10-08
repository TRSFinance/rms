package com.trs.rms.company.bean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * RmsCompanyInfo entity. @author MyEclipse Persistence Tools
 */

public class RmsCompanyInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4550312823392814679L;
	private Long custId;
	private String custOrgid;
	private String custCfname;
	private String custCsname;
	private String custEfname;
	private String custEsname;
	private String custIndustrycode;
	private String custIndustry1;
	private String custIndustry2;
	private String areaCode;
	private String districtName;
	private String provinceName;
	private String cityName;
	private String pinyin;
	private Integer state;
	private Date createTime;
	private Date changeTime;
	private Integer dataSource;
	private String icCode;
	private String taxCode;
	private String stockCode;
	private Set<RmsCorporateCust>  corporateCusts=new HashSet<RmsCorporateCust>();

	// Constructors

	/** default constructor */
	public RmsCompanyInfo() {
	}

	/** minimal constructor */
	public RmsCompanyInfo(String custOrgid, String custCfname,
			String custCsname, String custEfname, String custEsname,
			String custIndustrycode, String custIndustry1,
			String custIndustry2, String areaCode, String districtName,
			String provinceName, String cityName, String pinyin) {
		this.custOrgid = custOrgid;
		this.custCfname = custCfname;
		this.custCsname = custCsname;
		this.custEfname = custEfname;
		this.custEsname = custEsname;
		this.custIndustrycode = custIndustrycode;
		this.custIndustry1 = custIndustry1;
		this.custIndustry2 = custIndustry2;
		this.areaCode = areaCode;
		this.districtName = districtName;
		this.provinceName = provinceName;
		this.cityName = cityName;
		this.pinyin = pinyin;
	}

	/** full constructor */
	public RmsCompanyInfo(String custOrgid, String custCfname,
			String custCsname, String custEfname, String custEsname,
			String custIndustrycode, String custIndustry1,
			String custIndustry2, String areaCode, String districtName,
			String provinceName, String cityName, String pinyin, Integer state,
			Date createTime, Date changeTime, Integer dataSource,
			String icCode, String taxCode, String stockCode) {
		this.custOrgid = custOrgid;
		this.custCfname = custCfname;
		this.custCsname = custCsname;
		this.custEfname = custEfname;
		this.custEsname = custEsname;
		this.custIndustrycode = custIndustrycode;
		this.custIndustry1 = custIndustry1;
		this.custIndustry2 = custIndustry2;
		this.areaCode = areaCode;
		this.districtName = districtName;
		this.provinceName = provinceName;
		this.cityName = cityName;
		this.pinyin = pinyin;
		this.state = state;
		this.createTime = createTime;
		this.changeTime = changeTime;
		this.dataSource = dataSource;
		this.icCode = icCode;
		this.taxCode = taxCode;
		this.stockCode = stockCode;
	}

	// Property accessors

	public Long getCustId() {
		return this.custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getCustOrgid() {
		return this.custOrgid;
	}

	public void setCustOrgid(String custOrgid) {
		this.custOrgid = custOrgid;
	}

	public String getCustCfname() {
		return this.custCfname;
	}

	public void setCustCfname(String custCfname) {
		this.custCfname = custCfname;
	}

	public String getCustCsname() {
		return this.custCsname;
	}

	public void setCustCsname(String custCsname) {
		this.custCsname = custCsname;
	}

	public String getCustEfname() {
		return this.custEfname;
	}

	public void setCustEfname(String custEfname) {
		this.custEfname = custEfname;
	}

	public String getCustEsname() {
		return this.custEsname;
	}

	public void setCustEsname(String custEsname) {
		this.custEsname = custEsname;
	}

	public String getCustIndustrycode() {
		return this.custIndustrycode;
	}

	public void setCustIndustrycode(String custIndustrycode) {
		this.custIndustrycode = custIndustrycode;
	}

	public String getCustIndustry1() {
		return this.custIndustry1;
	}

	public void setCustIndustry1(String custIndustry1) {
		this.custIndustry1 = custIndustry1;
	}

	public String getCustIndustry2() {
		return this.custIndustry2;
	}

	public void setCustIndustry2(String custIndustry2) {
		this.custIndustry2 = custIndustry2;
	}

	public String getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getDistrictName() {
		return this.districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getProvinceName() {
		return this.provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getPinyin() {
		return this.pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getChangeTime() {
		return this.changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

	public Integer getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(Integer dataSource) {
		this.dataSource = dataSource;
	}

	public String getIcCode() {
		return this.icCode;
	}

	public void setIcCode(String icCode) {
		this.icCode = icCode;
	}

	public String getTaxCode() {
		return this.taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getStockCode() {
		return this.stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public Set<RmsCorporateCust> getCorporateCusts() {
		return corporateCusts;
	}

	public void setCorporateCusts(Set<RmsCorporateCust> corporateCusts) {
		this.corporateCusts = corporateCusts;
	}



}