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
import com.trs.rms.risk.statrans.bean.STATransInfo;
import com.trs.rms.risk.statrans.dao.STATransDAO;
import com.trs.rms.risk.statrans.dao.criterion.STATransCriterion;


/**
 * STA任务列表数据库访问接口实现
 * @author clinzy 2012-3-20
 * @author zxh    2016/10/28
 */
@Repository
public class STATransDAOImpl extends GenericHibernateDAO<STATransInfo, Long> implements STATransDAO {

	/**
	 * 分页列出所有符合条件的任务信息
	 *
	 * @param _staTranCriterion
	 * @param offsetLimit
	 * @return
	 */
	public PagedArrayList<STATransInfo> pagedSTATransInfo(STATransCriterion _staTransCriterion, OffsetLimit _offsetLimit) {
		// TODO Auto-generated method stub
		Criteria _criteria = super.getSessionFactory().getCurrentSession().createCriteria(STATransInfo.class);

		if(_staTransCriterion != null) {
			String _sTransName = _staTransCriterion.getTransName();
			String _sTransType = _staTransCriterion.getTransType();
			if (StringUtils.isNotBlank(_sTransName)) {
				_criteria.add(RestrictionsUtils.like("transName", _sTransName,MatchMode.ANYWHERE));
			}
			if (StringUtils.isNotBlank(_sTransType)) {
				_criteria.add(Restrictions.eq("transType", _sTransType));
			}
		}

		return findByPage(_criteria, _offsetLimit, Order.desc("transCreationTime"));
	}

	/**
	 * 按ID返回任务信息
	 *
	 * @param _id
	 */
	public STATransInfo getSTATransInfo(Long _id) {
		Criteria _criteria = super.getSessionFactory().getCurrentSession().createCriteria(STATransInfo.class);
		_criteria.add(Restrictions.eq("id", _id));
		List<STATransInfo> _list = _criteria.list();
		if(_list != null && _list.size() > 0) {
			return (STATransInfo)_list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 任务是否存在
	 *
	 * @param _sTransDefine
	 * @return
	 */
	public boolean isTransExist(String _sTransDefine) {
		Criteria _criteria = super.getSessionFactory().getCurrentSession().createCriteria(STATransInfo.class);
		_criteria.add(Restrictions.eq("transDefine", _sTransDefine));
		List<STATransInfo> _list = _criteria.list();
		if(_list != null && _list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
}
