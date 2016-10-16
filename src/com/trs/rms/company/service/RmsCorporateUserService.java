package com.trs.rms.company.service;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.trs.rms.base.service.BasicService;
import com.trs.rms.company.bean.RmsCompanyInfo;
import com.trs.rms.company.bean.RmsCorporateUser;
import com.trs.rms.usermgr.bean.RmsUser;

public interface RmsCorporateUserService  extends BasicService{
	
public List<RmsCorporateUser> list();
	
	public long getUserId();
	
	public void updateData(List list);
	
	public void add(Collection c);

	boolean isExist(String username,String corporateUserName);

	 void saveCorporateUser(RmsUser rmsUser, String corporateUserName,
			String tel, String mobile, String email, String _info);
	 
	
}
