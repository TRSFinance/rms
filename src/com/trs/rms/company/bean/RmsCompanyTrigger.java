package com.trs.rms.company.bean;

/**
 * RmsCompanyTrigger entity. @author MyEclipse Persistence Tools
 */

public class RmsCompanyTrigger implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6559464545831297409L;
	private Long id;
	private Long custId;
	private Integer state;

	// Constructors

	/** default constructor */
	public RmsCompanyTrigger() {
	}

	/** full constructor */
	public RmsCompanyTrigger(Long custId, Integer state) {
		this.custId = custId;
		this.state = state;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustId() {
		return this.custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}