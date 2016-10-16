package com.trs.rms.company.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trs.rms.base.dao.IDao;
import com.trs.rms.base.page.Param;
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

	@Transactional(readOnly=true)
	public boolean isExist(String username,String corporateUserName) {
		List<Param>  paramList=new ArrayList<Param>();
		String  hql="  FROM  com.trs.rms.company.bean.RmsCorporateUser rcu where  rcu.rmsUser.loginName=? or rcu.corporateName=?";
		paramList.add(new Param(Types.VARCHAR, username.trim()));
		paramList.add(new Param(Types.VARCHAR, corporateUserName.trim()));
		@SuppressWarnings("unchecked")
		List<RmsCorporateUser> list = dao.query(hql, paramList);
		if(list==null||list.size()==0)
		return false;
		return  true;
	}

	@Override
	public void saveCorporateUser(RmsUser rmsUser, String corporateUserName,
			String tel, String mobile, String email, String _info) {
		
		dao.save(rmsUser);
		List<RmsUser> list = dao.query("from  com.trs.rms.usermgr.bean.RmsUser");
		String sql="insert into rms_corporate_user (USER_ID,CORPORATE_NAME, CORPORATE_TEL, CORPORATE_MOBILE, CORPORATE_EMAIL, CORPORATE_INF, CREATE_TIME, UPDATE_TIME) values (?,?, ?, ?, ?, ?, ?, ?) ";
		List list2 = new ArrayList();		
		list2.add(new Param(Types.BIGINT,list.get(list.size()-1).getUserId()));
		list2.add(new Param(Types.VARCHAR,corporateUserName));
		list2.add(new Param(Types.VARCHAR,tel));
		list2.add(new Param(Types.VARCHAR,mobile));
		list2.add(new Param(Types.VARCHAR,email));
		list2.add(new Param(Types.VARCHAR,_info));
		list2.add(new Param(Types.TIMESTAMP,new Date()));
		list2.add(new Param(Types.TIMESTAMP,new Date()));
		dao.updateSql(sql, list2);		
	}



	
}
