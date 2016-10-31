package com.trs.rms.risk.statrans.bean;


/**
 * STA或DAS服务器配置信息
 *
 * @author clinzy 2012-3-28
 * @author 邹许红      2016-10-28
 *
 */
public class STATransConfInfo {
	private final int prime = 31;
	/**
	 * 记录ID
	 */
	private Long id;

	/**
	 * 配置类型，可选值包括“DAS服务器信息”，“STA服务器信息”，“排重服务器信息”
	 */
	private String transConfType;

	/**
	 * 配置名称
	 */
	private String transConfName;

	/**
	 * 配置内容
	 */
	private String transConfContent;

	/**
	 * 配置说明
	 */
	private String transConfComment;

	/**
	 * 配置标记
	 */
	private Integer transConfTag;
	@Override
	public int hashCode() {
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		STATransConfInfo other = (STATransConfInfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	/**
	 * 构造函数
	 */
	public STATransConfInfo() {

	}

	/**
	 * 返回记录ID
	 *
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置记录ID
	 *
	 * @param value
	 */
	public void setId(Long value) {
		id = value;
	}

	/**
	 * 返回配置类型
	 *
	 * @return
	 */
	public String getTransConfType() {
		return transConfType;
	}

	/**
	 * 设置配置类型
	 *
	 * @param value
	 */
	public void setTransConfType(String value) {
		transConfType = value;
	}

	/**
	 * 返回配置名称
	 *
	 * @return
	 */
	public String getTransConfName() {
		return transConfName;
	}

	/**
	 * 设置配置名称
	 *
	 * @param value
	 */
	public void setTransConfName(String value) {
		transConfName = value;
	}

	/**
	 * 返回配置内容
	 *
	 * @return
	 */
	public String getTransConfContent() {
		return transConfContent;
	}

	/**
	 * 设置配置内容
	 *
	 * @param value
	 */
	public void setTransConfContent(String value) {
		transConfContent = value;
	}

	/**
	 * 返回配置说明
	 *
	 * @return
	 */
	public String getTransConfComment() {
		return transConfComment;
	}

	/**
	 * 设置配置说明
	 *
	 * @param value
	 */
	public void setTransConfComment(String value) {
		transConfComment = value;
	}

	/**
	 * 返回配置标记
	 *
	 * @return
	 */
	public Integer getTransConfTag() {
		return transConfTag;
	}

	/**
	 * 设置配置标记
	 *
	 * @param value
	 */
	public void setTransConfTag(Integer value) {
		transConfTag = value;
	}
}
