package com.trs.rms.company.service;

import java.util.List;

import com.trs.rms.base.service.BasicService;
import com.trs.rms.company.bean.RmsCorporateUser;
import com.trs.rms.usermgr.bean.RmsUser;

public interface RmsCorporateUserService  extends BasicService{

	List<RmsCorporateUser> query();
	
	boolean isExist(String username,String corporateUserName);

	 void saveCorporateUser(RmsUser rmsUser, String corporateUserName,
			String tel, String mobile, String email, String _info);
	 
	
}
