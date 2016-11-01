package com.trs.rms.rulemgr.service.impl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trs.rms.base.dao.IDao;
import com.trs.rms.base.page.Param;
import com.trs.rms.base.service.BasicServicveImpl;
import com.trs.rms.company.bean.RmsCorporateUser;
import com.trs.rms.company.service.RmsCorporateUserService;
import com.trs.rms.rulemgr.bean.CkmTemplate;
import com.trs.rms.rulemgr.service.RmsRuleTemplateService;
import com.trs.rms.usermgr.bean.RmsUser;

@Service
@Transactional
public class RmsRuleTemplateServiceImpl extends BasicServicveImpl implements RmsRuleTemplateService{
	
	@Autowired
	public  void  setMyDao(IDao dao){
		super.setDao(dao);
	}

	@Override
	public List<CkmTemplate> query(){
		@SuppressWarnings("unchecked")
		List<CkmTemplate> list = (List<CkmTemplate>) dao.query("from com.trs.rulemgr.bean.CkmTemplate");		
		return list;		
	}
	
	//未完待续
//	@Transactional(readOnly=true)
//	public boolean isExist(String username,String corporateUserName) {
//		List<Param>  paramList=new ArrayList<Param>();
//		String  hql="  FROM  com.trs.rms.company.bean.RmsCorporateUser rcu where  rcu.rmsUser.loginName=? or rcu.corporateName=?";
//		paramList.add(new Param(Types.VARCHAR, username.trim()));
//		paramList.add(new Param(Types.VARCHAR, corporateUserName.trim()));
//		@SuppressWarnings("unchecked")
//		List<RmsCorporateUser> list = dao.query(hql, paramList);
//		if(list==null||list.size()==0)
//		return false;
//		return  true;
//	}
//
//	@Override
//	public void saveCorporateUser(RmsUser rmsUser, String corporateUserName,
//			String tel, String mobile, String email, String _info) {		
//		dao.save(rmsUser);		
//		RmsCorporateUser rmsCorporateUser = new RmsCorporateUser(rmsUser,corporateUserName,tel,mobile,email,_info,new Date(),new Date());
//		dao.save(rmsCorporateUser);	
//	}




	
}
