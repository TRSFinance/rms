package com.trs.rms.risk.statrans.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trs.rms.base.page.OffsetLimit;
import com.trs.rms.base.page.PagedArrayList;
import com.trs.rms.risk.statrans.bean.STATransModelInfo;
import com.trs.rms.risk.statrans.dao.STATransModelDAO;
import com.trs.rms.risk.statrans.dao.criterion.STATransModelCriterion;
import com.trs.rms.risk.statrans.service.STATransModelService;



/**
 *
 *
 * @author clinzy 2012-3-22
 * @author zxh    2016-10-28
 */
@Service
@Transactional
public class STATransModelServiceImpl implements STATransModelService {
	/**
	 *
	 */
	@Autowired
	private STATransModelDAO staTransModelDAO;

	/**
	 * 返回
	 *
	 * @return
	 */
	public STATransModelDAO getStaTransModelDAO() {
		return staTransModelDAO;
	}

	/**
	 * 设置
	 *
	 * @param value
	 */
	public void setStaTransModelDAO(STATransModelDAO value) {
		staTransModelDAO = value;
	}

	@Override
	@Transactional
	public PagedArrayList<STATransModelInfo> pagedSTATransModelInfo(
			STATransModelCriterion _staTransModelCriterion, OffsetLimit _offsetLimit) {
		return staTransModelDAO.pagedSTATransModelInfo(_staTransModelCriterion, _offsetLimit);
	}

	@Override
	@Transactional
	public STATransModelInfo getSTATransModelInfo(Long _id) {
		return staTransModelDAO.getSTATransModelInfo(_id);
	}

	@Override
	@Transactional
	public STATransModelInfo[] getSTATransModelInfoList(STATransModelCriterion _staTransModelCriterion) {
		return staTransModelDAO.getSTATransModelInfoList(_staTransModelCriterion);
	}
}
