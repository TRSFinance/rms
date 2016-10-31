package com.trs.rms.risk.statrans.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trs.rms.base.page.OffsetLimit;
import com.trs.rms.base.page.PagedArrayList;
import com.trs.rms.risk.statrans.bean.STATransInfo;
import com.trs.rms.risk.statrans.dao.STATransDAO;
import com.trs.rms.risk.statrans.dao.criterion.STATransCriterion;
import com.trs.rms.risk.statrans.service.STATransService;



/**
 *
 *
 * @author clinzy 2012-3-20
 * @author zxh    2016-10-28
 *
 */
@Service
@Transactional
public class STATransServiceImpl implements STATransService {
	/**
	 * STA任务列表数据库访问对象
	 */
	@Autowired
	private STATransDAO staTransDAO;

	/**
	 * 返回STA任务列表数据库访问对象
	 *
	 * @return
	 */
	public STATransDAO getStaTransDAO() {
		return staTransDAO;
	}

	/**
	 * 设置STA任务列表数据库访问对象
	 *
	 * @param value
	 */
	public void setStaTransDAO(STATransDAO value) {
		staTransDAO = value;
	}

	/**
	 * 分页列出所有符合条件的任务信息
	 *
	 * @param staTransCriterion
	 * @param offsetLimit
	 * @return
	 */
	@Transactional
	public PagedArrayList<STATransInfo> pagedSTATransInfo(
			STATransCriterion staTransCriterion, OffsetLimit offsetLimit) {
		return staTransDAO.pagedSTATransInfo(staTransCriterion, offsetLimit);
	}

	/**
	 * 按ID获取任务信息
	 *
	 * @param id
	 * @return
	 */
	@Transactional
	public STATransInfo getSTATransInfo(Long id) {
		return staTransDAO.getSTATransInfo(id);
	}

	/**
	 * 保存任务信息
	 *
	 * @param _staTransInfo
	 */
	@Transactional
	public void saveSTATransInfo(STATransInfo _staTransInfo) {
		staTransDAO.makePersistent(_staTransInfo);
	}

	/**
	 * 任务是否存在
	 *
	 * @param _sTransDefine
	 */
	@Transactional
	public boolean isTransExist(String _sTransDefine) {
		return staTransDAO.isTransExist(_sTransDefine);
	}

	/**
	 * 根据ID删除任务
	 *
	 * @param id
	 */
	@Transactional
	public void deleteSTATransInfo(Long id) {
		STATransInfo _staTransInfo = staTransDAO.getSTATransInfo(id);
		if (_staTransInfo != null) {
			staTransDAO.makeTransient(_staTransInfo);
		}
	}

	/**
	 * 根据任务信息删除任务
	 *
	 * @param _staTransInfo
	 */
	@Transactional
	public void deleteSTATransInfo(STATransInfo _staTransInfo) {
		if (_staTransInfo != null) {
			staTransDAO.makeTransient(_staTransInfo);
		}
	}
}
