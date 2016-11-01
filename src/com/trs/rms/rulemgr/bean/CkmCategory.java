package com.trs.rms.rulemgr.bean;

/**
 * CKM模板分类对应的实体类。
 * @author wengjing
 *
 */
public class CkmCategory implements Comparable<CkmCategory> {
	//fields	---------------------------------------------------------------------
	/**
	 * 分类ID
	 */
	private Long id;
	/**
	 * 分类名称
	 */
	private String name;
	/**
	 * 所属模板
	 */
	private CkmTemplate template;
	/**
	 * 父类
	 */
	private CkmCategory parentCategory;

	/**
	 * 企业风险预警级别
	 */
	private CompanyAlarmLevel companyAlarmLevel;

	/** 分类号. */
	private String tag;

	/** 包含所有上级分类名的完整类名. */
	private transient String fullName;

	public int compareTo(CkmCategory o) {
		int result=this.name.compareTo(o.name);
		if(result==0) result=this.id.compareTo(o.id);
		return result;
	}

	//accessors	---------------------------------------------------------------------
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CkmTemplate getTemplate() {
		return template;
	}
	public void setTemplate(CkmTemplate template) {
		this.template = template;
	}
	public CkmCategory getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(CkmCategory parentCategory) {
		this.parentCategory = parentCategory;
	}
	public CompanyAlarmLevel getCompanyAlarmLevel() {
		return companyAlarmLevel;
	}

	public void setCompanyAlarmLevel(CompanyAlarmLevel companyAlarmLevel) {
		this.companyAlarmLevel = companyAlarmLevel;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getFullName() {
		if(fullName!=null) return fullName;
		StringBuilder builder=new StringBuilder();
		builder.append(name);
		CkmCategory parent=getParentCategory();
		while(parent!=null){
			builder.insert(0, '\\');
			builder.insert(0, parent.name);
			parent=parent.getParentCategory();
		}
		fullName=builder.toString();
		return fullName;
	}
}
