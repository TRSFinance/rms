package com.trs.rms.company.service;

import java.util.Collection;
import java.util.List;

import com.trs.rms.base.service.BasicService;
import com.trs.rms.company.bean.RmsCompanyInfo;
import com.trs.rms.company.bean.RmsCorporateUser;

public interface RmsCorporateUserService  extends BasicService{
	
public List<RmsCorporateUser> list();
	
	public long getUserId();
	
	public void updateData(List list);
	
	public void add(Collection c);

	
}
