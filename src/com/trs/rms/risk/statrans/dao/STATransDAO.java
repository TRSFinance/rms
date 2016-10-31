package com.trs.rms.risk.statrans.dao;

import com.trs.rms.base.dao.hibernate3.GenericDAO;
import com.trs.rms.base.page.OffsetLimit;
import com.trs.rms.base.page.PagedArrayList;
import com.trs.rms.risk.statrans.bean.STATransInfo;
import com.trs.rms.risk.statrans.dao.criterion.STATransCriterion;



/**
 * STA任务列表数据库访问接口
 * 
 * @author clinzy 2012-3-20
 *
 */
public interface STATransDAO  extends GenericDAO<STATransInfo, Long> {
	/**
	 * 分页列出所有符合条件的任务信息
	 * 
	 * @param _staTransCriterion
	 * @param _offsetLimit
	 * @return
	 */
	public PagedArrayList<STATransInfo> pagedSTATransInfo(STATransCriterion _staTransCriterion, OffsetLimit _offsetLimit);
	
	/**
	 * 根据ID获取任务
	 * 
	 * @param _id
	 * @return
	 */
	public STATransInfo getSTATransInfo(Long _id);
	
	/**
	 * 任务是否存在
	 * 
	 * @param _sTransDefine
	 * @return
	 */
	public boolean isTransExist(String _sTransDefine);
}
