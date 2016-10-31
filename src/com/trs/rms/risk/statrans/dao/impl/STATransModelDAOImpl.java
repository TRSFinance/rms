package com.trs.rms.risk.statrans.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.trs.rms.base.dao.hibernate3.GenericHibernateDAO;
import com.trs.rms.base.page.OffsetLimit;
import com.trs.rms.base.page.PagedArrayList;
import com.trs.rms.risk.statrans.bean.STATransModelInfo;
import com.trs.rms.risk.statrans.dao.STATransModelDAO;
import com.trs.rms.risk.statrans.dao.criterion.STATransModelCriterion;



/**
 * 
 * STA任务模板
 * @author clinzy 2012-3-22
 * @author zxh    2016-10-28
 *
 */
@Repository
public class STATransModelDAOImpl extends GenericHibernateDAO<STATransModelInfo, Long> implements STATransModelDAO {

	/**
	 * 分页列出所有符合条件的任务信息
	 * 
	 * @param _staTransModelCriterion
	 * @param _offsetLimit
	 * @return
	 */
	public PagedArrayList<STATransModelInfo> pagedSTATransModelInfo(STATransModelCriterion _staTransModelCriterion, OffsetLimit _offsetLimit) {
		// TODO Auto-generated method stub
		Criteria _criteria = super.getSessionFactory().getCurrentSession().createCriteria(STATransModelInfo.class);
		
		if(_staTransModelCriterion != null) {
			String _sTransType = _staTransModelCriterion.getTransType();
			String _sTransModelGroupName = _staTransModelCriterion.getTransModelGroupName();
			Integer _transModelTag = _staTransModelCriterion.getTransModelTag();
			if (StringUtils.isNotBlank(_sTransType)) {
				_criteria.add(Restrictions.eq("transType", _sTransType));
			}
			if (StringUtils.isNotBlank(_sTransModelGroupName)) {
				_criteria.add(Restrictions.eq("transModelGroupName", _sTransModelGroupName));
			}
			if (_transModelTag != null) {
				_criteria.add(Restrictions.eq("transModelTag", _transModelTag));
			}
		}
		
		return findByPage(_criteria, _offsetLimit, Order.asc("id"));
	}

	/**
	 * 根据任务模板记录id获取任务模板信息
	 * 
	 * @param _id
	 * @return
	 */
	public STATransModelInfo getSTATransModelInfo(Long _id) {
		// TODO Auto-generated method stub
		Criteria _criteria = super.getSessionFactory().getCurrentSession().createCriteria(STATransModelInfo.class);
		_criteria.add(Restrictions.eq("id", _id));
		List<STATransModelInfo> _list = _criteria.list();
		if(_list != null && _list.size() > 0) {
			return (STATransModelInfo)_list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 按条件返回任务模板列表
	 * 
	 * @param _staTransModelCriterion
	 * @return
	 */
	public STATransModelInfo[] getSTATransModelInfoList(STATransModelCriterion _staTransModelCriterion) {
		STATransModelInfo[] _staTransModelInfo = null;
		List<STATransModelInfo> _list = null;
		int _iSize = 0;
		Criteria _criteria = null;
		
		_criteria = super.getSessionFactory().getCurrentSession().createCriteria(STATransModelInfo.class);
		if(_staTransModelCriterion != null) { // 检索条件
			String _sTransType = _staTransModelCriterion.getTransType();
			String _sTransModelGroupName = _staTransModelCriterion.getTransModelGroupName();
			Integer _transModelTag = _staTransModelCriterion.getTransModelTag();
			if (StringUtils.isNotBlank(_sTransType)) {
				_criteria.add(Restrictions.eq("transType", _sTransType));
			}
			if (StringUtils.isNotBlank(_sTransModelGroupName)) {
				_criteria.add(Restrictions.eq("transModelGroupName", _sTransModelGroupName));
			}
			if (_transModelTag != null) {
				_criteria.add(Restrictions.eq("transModelTag", _transModelTag));
			}
		}
		_criteria.addOrder(Order.asc("id")); // 排序
		_list = _criteria.list(); // 检索
		
		_iSize = _list == null ? 0 : _list.size();
		if (_iSize > 0) {
			_staTransModelInfo = new STATransModelInfo[_iSize];
			_staTransModelInfo = _list.toArray(_staTransModelInfo);
		}
		
		return _staTransModelInfo;
	}
}
