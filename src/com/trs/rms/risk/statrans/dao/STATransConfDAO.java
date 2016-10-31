package com.trs.rms.risk.statrans.dao;

import java.util.List;

import com.trs.rms.base.dao.hibernate3.GenericDAO;
import com.trs.rms.base.page.OffsetLimit;
import com.trs.rms.base.page.PagedArrayList;
import com.trs.rms.risk.statrans.bean.STATransConfInfo;
import com.trs.rms.risk.statrans.dao.criterion.STATransConfCriterion;



/**
 *
 * STA
 * @author clinzy 2012-3-28
 * @author zxh    2016-10-28
 *
 */
public interface STATransConfDAO extends GenericDAO<STATransConfInfo, Long> {
	/**
	 * 分页列出所有符合条件的任务配置信息
	 *
	 * @param _staTransConfCriterion
	 * @param _offsetLimit
	 * @return
	 */
	public PagedArrayList<STATransConfInfo> pagedSTATransConfInfo(STATransConfCriterion _staTransConfCriterion, OffsetLimit _offsetLimit);

	/**
	 * 根据配置类型获取配置信息
	 *
	 * @param _sTransConfType
	 * @return
	 */
	public STATransConfInfo[] getSTATransConfInfoList(STATransConfCriterion _staTransConfCriterion);

	/**
	 * 根据ID获取配置信息
	 *
	 * @param _id
	 * @return
	 */
	public STATransConfInfo getSTATransConfInfo(Long id);

	public List<STATransConfInfo> listSTATransConfInfos(
			STATransConfCriterion _staTransConfCriterion);
}
