package com.trs.rms.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trs.rms.base.dao.IDao;
import com.trs.rms.base.service.BasicServicveImpl;
@Service
@Transactional
public class RmsTestService  extends  BasicServicveImpl   implements RmsTestServices {
	public   void  test(){
		System.out.println("我是业务层！");
	}
	@Autowired
	public  void  setMyDao(IDao dao){
		super.setDao(dao);
	}
	
    
}
