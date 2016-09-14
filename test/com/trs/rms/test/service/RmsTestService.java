package com.trs.rms.test.service;

import com.trs.rms.test.dao.RmsTestDao;

public class RmsTestService {
	private   RmsTestDao  dao;
	public   void  test(){
		System.out.println("我是业务层！");
		dao.test();
	}
	public RmsTestDao getDao() {
		return dao;
	}
	public void setDao(RmsTestDao dao) {
		this.dao = dao;
	}
    
}
