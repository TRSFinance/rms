package com.trs.rms.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trs.rms.test.bean.RmsTest;
import com.trs.rms.test.dao.CKMDao;

@Service
@Transactional
public class RMSTestONEServiceImpl implements   RMSTestONEService{
	@Autowired
    private  CKMDao  ckm;
	@Override
	public void test() {
		try {
			RmsTest  rmsTest=new  RmsTest();
				rmsTest.setName("檀春晖");
				ckm.save(rmsTest);
				ckm.save(rmsTest);
			List<RmsTest> list = ckm.findAll();
			System.out.println(list.size());
		} catch (Exception e) {
          
			e.printStackTrace();		}
		
		
		
		
		
		
	}

}
