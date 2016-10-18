package com.trs.rms.company.service;

import com.trs.rms.base.service.BasicService;
import com.trs.rms.usermgr.bean.RmsUser;

public interface RmsCorporateUserService  extends BasicService{

	boolean isExist(String username,String corporateUserName);

	 void saveCorporateUser(RmsUser rmsUser, String corporateUserName,
			String tel, String mobile, String email, String _info);
	 
	
}
