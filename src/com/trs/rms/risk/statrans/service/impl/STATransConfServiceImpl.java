package com.trs.rms.risk.statrans.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trs.rms.base.page.OffsetLimit;
import com.trs.rms.base.page.PagedArrayList;
import com.trs.rms.risk.statrans.bean.STATransConfInfo;
import com.trs.rms.risk.statrans.dao.STATransConfDAO;
import com.trs.rms.risk.statrans.dao.criterion.STATransConfCriterion;
import com.trs.rms.risk.statrans.service.STATransConfService;



/**
 *
 *
 * @author clinzy 2012-3-28
 *
 */
@Service
@Transactional
public class STATransConfServiceImpl implements STATransConfService {
	private static final Logger LOGGER = LoggerFactory
	.getLogger(STATransConfServiceImpl.class);
	@Autowired
	private STATransConfDAO staTransConfDAO;

	/**
	 * 分页列出所有符合条件的任务配置信息
	 *
	 * @param _staTransConfCriterion
	 * @param _offsetLimit
	 * @return
	 */
	@Transactional
	public PagedArrayList<STATransConfInfo> pagedSTATransConfInfo(STATransConfCriterion _staTransConfCriterion, OffsetLimit _offsetLimit) {
		return staTransConfDAO.pagedSTATransConfInfo(_staTransConfCriterion, _offsetLimit);
	}

	/**
	 * 根据配置类型获取配置信息
	 *
	 * @param _sTransConfType
	 * @return
	 */
	@Transactional
	public STATransConfInfo[] getSTATransConfInfoList(STATransConfCriterion _staTransConfCriterion) {
		return staTransConfDAO.getSTATransConfInfoList(_staTransConfCriterion);
	}


	

	/**
	 * 根据ID获取配置信息
	 *
	 * @param _id
	 * @return
	 */
	@Transactional
	public STATransConfInfo getSTATransConfInfo(Long _id) {
		return staTransConfDAO.getSTATransConfInfo(_id);
	}


	/**
	 * 保存/修改配置信息
	 *
	 * @param value
	 */
	@Transactional
	public void saveSTATransConfInfo(STATransConfInfo value) {
		staTransConfDAO.makePersistent(value);
	}

	/**
	 * 删除配置信息
	 *
	 * @param value
	 */
	@Transactional
	public void deleteSTATransConfInfo(Long id) {
		STATransConfInfo _value = staTransConfDAO.getSTATransConfInfo(id);
		if (_value != null) {
			staTransConfDAO.makeTransient(_value);
		}
	}

	/**
	 * 删除配置信息
	 *
	 * @param value
	 */
	@Transactional
	public void deleteSTATransConfInfo(STATransConfInfo value) {
		if (value != null) {
			staTransConfDAO.makeTransient(value);
		}
	}

	@Override
	@Transactional
	public List<STATransConfInfo> listSTATransConfInfos(
			STATransConfCriterion _staTransConfCriterion) {
		return staTransConfDAO.listSTATransConfInfos(_staTransConfCriterion);
	}

	public STATransConfDAO getStaTransConfDAO() {
		return staTransConfDAO;
	}

	public void setStaTransConfDAO(STATransConfDAO value) {
		staTransConfDAO = value;
	}
}
