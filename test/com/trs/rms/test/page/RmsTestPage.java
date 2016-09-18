package com.trs.rms.test.page;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.trs.rms.base.page.IBasicDao;
import com.trs.rms.base.page.BasicPage;
@Component
public class RmsTestPage   extends  BasicPage{

	@Override
	public void addParameter() {
		this.setHQLString("from  com.trs.rms.test.bean.RmsTest");
		this.setHQLCountString("select count(*) from com.trs.rms.test.bean.RmsTest");
	}

	@Override
	@Resource(name="publicDao")
	public void setMyPublicDao(IBasicDao publicDao) {
		super.setPublicDao(publicDao);
	}
	
	
	

}
