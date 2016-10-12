package com.trs.rms.company.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trs.rms.base.dao.IDao;
import com.trs.rms.base.service.BasicServicveImpl;
import com.trs.rms.company.bean.RmsCompanyInfo;
import com.trs.rms.company.bean.RmsCorporateUser;
import com.trs.rms.company.service.RmsCorporateUserService;
import com.trs.rms.usermgr.bean.RmsUser;
@Service
@Transactional
public class RmsCorporateUserServiceImpl extends BasicServicveImpl implements RmsCorporateUserService{
	@Autowired
	public  void  setMyDao(IDao dao){
		super.setDao(dao);
	}
	
	@Override
	public List<RmsCorporateUser> list(){
		
		System.out.println("已到服务层");
		List<RmsCorporateUser> list = (List<RmsCorporateUser>) dao.query("from RmsCorporateUser");
		
		return list;
		
	}

	
	
	@Override
	public long getUserId() {		
		System.out.println("查询用户的id");
		String username = "";
		List<RmsUser> list = dao.query("from rms_user where loginName="+username);
		return list.get(0).getUserId();		
	}

	@Override
	public void updateData(List list) {
		System.out.println("我来了");
		String sql = "update rms_company_info set CUST_CFNAME=?,CUST_CSNAME=?, "+
		"CUST_INDUSTRY1=?,CUST_INDUSTRY2=? where CUST_ID=?";
	
		dao.updateSql(sql, list);
		
	}

	@Override
	public void add(Collection c) {
		dao.save(c);		
	}

}
