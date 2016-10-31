package com.trs.rms.risk.statrans.service;

import com.trs.rms.base.page.OffsetLimit;
import com.trs.rms.base.page.PagedArrayList;
import com.trs.rms.risk.statrans.bean.STATransModelInfo;
import com.trs.rms.risk.statrans.dao.criterion.STATransModelCriterion;



/**
 * 
 * 
 * @author clinzy 2012-3-22
 *
 */
public interface STATransModelService {
	/**
	 * 分页列出所有符合条件的任务信息
	 * 
	 * @param _staTransModelCriterion
	 * @param _offsetLimit
	 * @return
	 */
	public PagedArrayList<STATransModelInfo> pagedSTATransModelInfo(STATransModelCriterion _staTransModelCriterion, OffsetLimit _offsetLimit);
	
	/**
	 * 根据ID获取STA任务模板
	 * 
	 * @param _id
	 * @return
	 */
	public STATransModelInfo getSTATransModelInfo(Long _id);

	/**
	 * 按条件返回任务模板列表
	 * 
	 * @param _staTransModelCriterion
	 * @return
	 */
	public STATransModelInfo[] getSTATransModelInfoList(STATransModelCriterion _staTransModelCriterion);
}
