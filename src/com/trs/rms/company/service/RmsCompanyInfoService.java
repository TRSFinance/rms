package com.trs.rms.company.service;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.trs.rms.base.service.BasicService;
import com.trs.rms.company.bean.RmsCompanyInfo;
import com.trs.rms.company.bean.RmsCorporateUser;

public interface RmsCompanyInfoService extends BasicService {
		
	public List<RmsCorporateUser> list();
	
	public long getUserId();
	
	public void updateData(List list);
	
	public void add(Collection c);
	
	boolean insertFiletoDb(HttpServletRequest request,String savepath,String uuidname,Long userId);

	void deleteRmsCorporateCust(Long custId, Long publicUserId);
	
}
