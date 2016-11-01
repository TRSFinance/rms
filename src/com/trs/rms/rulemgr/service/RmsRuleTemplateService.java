package com.trs.rms.rulemgr.service;

import java.util.List;

import com.trs.rms.base.service.BasicService;
import com.trs.rms.company.bean.RmsCorporateUser;
import com.trs.rms.rulemgr.bean.CkmTemplate;
import com.trs.rms.usermgr.bean.RmsUser;

public interface RmsRuleTemplateService  extends BasicService{

	List<CkmTemplate> query();
	//未完待续
	boolean isExist(String username,String corporateUserName);

	 void saveCorporateUser(RmsUser rmsUser, String corporateUserName,
			String tel, String mobile, String email, String _info);
	 
	
}
