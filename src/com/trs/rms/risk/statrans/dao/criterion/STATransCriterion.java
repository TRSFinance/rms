package com.trs.rms.risk.statrans.dao.criterion;

/**
 * STA任务列表检索条件信息
 * 
 * @author clinzy 2012-3-20
 * @author zxh      2016-10-28
 *
 */
public class STATransCriterion {
	/**
	 * 任务名称
	 */
	private String transName;
	
	/**
	 * 任务类型
	 */
	private String transType;
	
	/**
	 * 构造函数
	 */
	public STATransCriterion() {
		
	}
	
	/**
	 * 构造函数
	 * 
	 * @param _sTransName
	 * @param _sTransType
	 */
	public STATransCriterion(String _sTransName, String _sTransType) {
		this.transName = _sTransName;
		this.transType = _sTransType;
	}
	
	/**
	 * 返回任务名称
	 * 
	 * @return
	 */
	public String getTransName() {
		return transName;
	}
	
	/**
	 * 设置任务名称
	 * 
	 * @param value
	 */
	public void setTransName(String value) {
		transName = value;
	}

	/**
	 * 返回任务类型
	 * 
	 * @return
	 */
	public String getTransType() {
		return transType;
	}
	
	/**
	 * 设置任务类型
	 * 
	 * @param value
	 */
	public void setTransType(String value) {
		transType = value;
	}
}
