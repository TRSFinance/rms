package com.trs.rms.risk.statrans.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.trs.rms.base.common.RestrictionsUtils;
import com.trs.rms.base.dao.hibernate3.GenericHibernateDAO;
import com.trs.rms.base.page.OffsetLimit;
import com.trs.rms.base.page.PagedArrayList;
import com.trs.rms.risk.statrans.bean.STATransConfInfo;
import com.trs.rms.risk.statrans.dao.STATransConfDAO;
import com.trs.rms.risk.statrans.dao.criterion.STATransConfCriterion;



/**
 *
 * STA配置DAO
 * @author clinzy 2012-3-28
 * @author zxh    2016-10-28
 *
 */
@Repository
public class STATransConfDAOImpl extends GenericHibernateDAO<STATransConfInfo, Long> implements STATransConfDAO {

	/**
	 * 根据检索条件封装构造Criteria
	 * @param criterion
	 * @return
	 */
	private Criteria buildCriteria(STATransConfCriterion criterion){
		Criteria _criteria = super.getSessionFactory().getCurrentSession().createCriteria(STATransConfInfo.class);

		if(criterion != null) {
			String _sTransConfName = criterion.getTransConfName();
			String _sTransConfType = criterion.getTransConfType();
			Integer _iTransConfTag = criterion.getTransConfTag();
			if (StringUtils.isNotBlank(_sTransConfName)) {
				//_criteria.add(RestrictionsUtils.like("transConfName", _sTransConfName,MatchMode.ANYWHERE));
				_criteria.add(RestrictionsUtils.like("transConfName", _sTransConfName,MatchMode.ANYWHERE));
			}
			if (StringUtils.isNotBlank(_sTransConfType)) {
				_criteria.add(Restrictions.eq("transConfType", _sTransConfType));
			}
			if (_iTransConfTag != null) {
				_criteria.add(Restrictions.eq("transConfTag", _iTransConfTag));
			}
			if(criterion.getExcludeIds()!=null&&!criterion.getExcludeIds().isEmpty()){
				_criteria.add(Restrictions.not(Restrictions.in("id", criterion.getExcludeIds())));
			}
			if(criterion.getInIds()!=null&&!criterion.getInIds().isEmpty()){
				_criteria.add(Restrictions.in("id", criterion.getInIds()));
			}
		}
		return _criteria;
	}
	/**
	 * 分页列出所有符合条件的任务配置信息
	 *
	 * @param _staTransConfCriterion
	 * @param _offsetLimit
	 * @return
	 */
	public PagedArrayList<STATransConfInfo> pagedSTATransConfInfo(STATransConfCriterion _staTransConfCriterion, OffsetLimit _offsetLimit) {
		return findByPage(this.buildCriteria(_staTransConfCriterion), _offsetLimit, Order.desc("id"));
	}

	/**
	 * 根据配置类型获取配置信息
	 *
	 * @param _sTransConfType
	 * @return
	 */
	public STATransConfInfo[] getSTATransConfInfoList(STATransConfCriterion _staTransConfCriterion) {
		STATransConfInfo[] _retValue = null;
		List<STATransConfInfo> _list = this.buildCriteria(_staTransConfCriterion).list();
		int _iSize = 0;
		_iSize = _list == null ? 0 : _list.size();
		if(_iSize > 0) {
			_retValue = new STATransConfInfo[_iSize];
			_retValue = _list.toArray(_retValue);
		}
		return _retValue;
	}

	/**
	 * 根据ID获取配置信息
	 *
	 * @param _id
	 * @return
	 */
	public STATransConfInfo getSTATransConfInfo(Long id) {
		STATransConfInfo _retValue = null;
		Criteria _criteria = null;
		List<STATransConfInfo> _list = null;
		int _iSize = 0;

		_criteria = super.getSessionFactory().getCurrentSession().createCriteria(STATransConfInfo.class);
		_criteria.add(Restrictions.eq("id", id));
		_list = _criteria.list();
		_iSize = _list == null ? 0 : _list.size();
		if(_iSize > 0) {
			_retValue = _list.get(0);
		}

		return _retValue;
	}

	@Override
	public List<STATransConfInfo> listSTATransConfInfos(
			STATransConfCriterion _staTransConfCriterion) {
		return this.buildCriteria(_staTransConfCriterion).list();
	}
}
