package com.trs.rms.risk.statrans.service;

import java.util.List;

import com.trs.rms.base.page.OffsetLimit;
import com.trs.rms.base.page.PagedArrayList;
import com.trs.rms.risk.statrans.bean.STATransConfInfo;
import com.trs.rms.risk.statrans.dao.criterion.STATransConfCriterion;



/**
 *服务器配置服务
 * @author clinzy 2012-3-28
 *
 */
public interface STATransConfService {
	/**
	 * 分页列出所有符合条件的服务器配置信息
	 *
	 * @param _staTransConfCriterion
	 * @param _offsetLimit
	 * @return
	 */
	public PagedArrayList<STATransConfInfo> pagedSTATransConfInfo(STATransConfCriterion _staTransConfCriterion, OffsetLimit _offsetLimit);
	/**
	 * 根据配置类型获取服务器配置信息
	 *
	 * @param _staTransConfCriterion
	 * @return
	 */
	public List<STATransConfInfo> listSTATransConfInfos(STATransConfCriterion _staTransConfCriterion);
	/**
	 * 根据配置类型获取服务器配置信息
	 *
	 * @param _sTransConfType
	 * @return
	 */
	public STATransConfInfo[] getSTATransConfInfoList(STATransConfCriterion _staTransConfCriterion);
	/**
	 * 根据微博总体配置选择STA服务器
	 * @param commonConfigBean 微博任务总体配置
	 * @return
	 */
	//public STATransConfInfo selectSTATransConfInfo(CommonConfigBean commonConfigBean);
	/**
	 * 根据ID获取服务器配置信息
	 *
	 * @param _id
	 * @return
	 */
	public STATransConfInfo getSTATransConfInfo(Long _id);

	/**
	 * 保存/修改服务器配置信息
	 *
	 * @param value
	 */
	public void saveSTATransConfInfo(STATransConfInfo value);

	/**
	 * 删除服务器配置信息
	 *
	 * @param value
	 */
	public void deleteSTATransConfInfo(Long id);

	/**
	 * 删除配置信息
	 *
	 * @param value
	 */
	public void deleteSTATransConfInfo(STATransConfInfo value);
}
