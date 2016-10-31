package com.trs.rms.risk.statrans.service;

import com.trs.rms.base.page.OffsetLimit;
import com.trs.rms.base.page.PagedArrayList;
import com.trs.rms.risk.statrans.bean.STATransInfo;
import com.trs.rms.risk.statrans.dao.criterion.STATransCriterion;



/**
 * 
 * 
 * @author clinzy 2012-3-20
 *
 */
public interface STATransService {
	/**
	 * 分页列出所有符合条件的任务信息
	 * 
	 * @param staTransCriterion
	 * @param offsetLimit
	 * @return
	 */
	public PagedArrayList<STATransInfo> pagedSTATransInfo(STATransCriterion staTransCriterion,OffsetLimit offsetLimit);
	
	/**
	 * 按ID获取任务信息
	 * 
	 * @param id
	 * @return
	 */
	public STATransInfo getSTATransInfo(Long id);
	
	/**
	 * 保存任务信息
	 * 
	 * @param _staTransInfo
	 */
	public void saveSTATransInfo(STATransInfo _staTransInfo);
	
	/**
	 * 任务是否存在
	 * 
	 * @param _sTransDefine
	 * @return
	 */
	public boolean isTransExist(String _sTransDefine);
	
	/**
	 * 根据ID删除任务
	 * 
	 * @param id
	 */
	public void deleteSTATransInfo(Long id);
	
	/**
	 * 根据任务信息删除任务
	 * 
	 * @param _staTransInfo
	 */
	public void deleteSTATransInfo(STATransInfo _staTransInfo);
}
