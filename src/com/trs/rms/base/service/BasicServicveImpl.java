package com.trs.rms.base.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.trs.rms.base.dao.IDao;
/**
 * 
 * @author zxh
 *
 */
public class BasicServicveImpl implements BasicService {
	
	
	protected IDao dao;
	
	public void delete(Class cla, Serializable[] ids) {
		List list=new ArrayList();
		for (int i = 0; i < ids.length; i++) {
			Object obj = this.queryById(cla, ids[i] );
			list.add(obj);
			//dao.delete(obj);
		}
		dao.delete(list);
	}

	public Object queryById(Class cla, Serializable id) {
	
		return dao.queryById(cla, id);
	}

	public void save(Object object) {
		dao.save(object);
	}

	public void update(Object object) {
		dao.update(object);
	}

	public IDao getDao() {
		return dao;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}
	

}