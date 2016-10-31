package com.trs.rms.risk.statrans.dao;

import com.trs.rms.base.dao.hibernate3.GenericDAO;
import com.trs.rms.base.page.OffsetLimit;
import com.trs.rms.base.page.PagedArrayList;
import com.trs.rms.risk.statrans.bean.STATransModelInfo;
import com.trs.rms.risk.statrans.dao.criterion.STATransModelCriterion;



/**
 * STA任务模板数据库访问接口
 * 
 * @author clinzy 2012-3-20
 *
 */
public interface STATransModelDAO extends GenericDAO<STATransModelInfo, Long> {
	/**
	 * 分页列出所有符合条件的任务模板信息
	 * 
	 * @param _staTransModelCriterion
	 * @param _offsetLimit
	 * @return
	 */
	public PagedArrayList<STATransModelInfo> pagedSTATransModelInfo(STATransModelCriterion _staTransModelCriterion, OffsetLimit _offsetLimit);
	
	/**
	 * 根据任务模板记录id获取任务模板信息
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
