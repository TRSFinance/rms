package com.trs.rms.usermgr.service.impl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trs.rms.base.dao.IDao;
import com.trs.rms.base.page.Param;
import com.trs.rms.base.service.BasicServicveImpl;
import com.trs.rms.usermgr.bean.RmsUser;
import com.trs.rms.usermgr.service.RmsUserService;
@Service
@Transactional
public class RmsUserServiceImpl  extends  BasicServicveImpl   implements RmsUserService {
	
	@Autowired
	public  void  setMyDao(IDao dao){
		super.setDao(dao);
	}

	@Override
	public RmsUser findByUsername(String username) {
		List<Param>  paramList=new ArrayList<Param>();
		String  hql="  FROM  com.trs.rms.usermgr.bean.RmsUser  where  loginName=?";
		paramList.add(new Param(Types.VARCHAR, username));
		@SuppressWarnings("unchecked")
		List<RmsUser> list = dao.query(hql, paramList);
		if(list==null||list.size()==0)
		return null;
		return  list.get(0);
	}

	@Override
	public boolean isExist(String username) {
		List<Param>  paramList=new ArrayList<Param>();
		String  hql="  FROM  com.trs.rms.usermgr.bean.RmsUser  where  loginName=?";
		paramList.add(new Param(Types.VARCHAR, username.trim()));
		@SuppressWarnings("unchecked")
		List<RmsUser> list = dao.query(hql, paramList);
		if(list==null||list.size()==0)
		return false;
		return  true;
	}
	
    
}
