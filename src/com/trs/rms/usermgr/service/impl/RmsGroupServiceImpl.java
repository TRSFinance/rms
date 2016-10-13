package com.trs.rms.usermgr.service.impl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trs.rms.base.dao.IDao;
import com.trs.rms.base.page.Param;
import com.trs.rms.base.service.BasicServicveImpl;
import com.trs.rms.usermgr.bean.RmsGroup;
import com.trs.rms.usermgr.bean.RmsUser;
import com.trs.rms.usermgr.service.RmsGroupService;
@Service
@Transactional
public class RmsGroupServiceImpl  extends  BasicServicveImpl   implements RmsGroupService {
	
	@Autowired
	public  void  setMyDao(IDao dao){
		super.setDao(dao);
	}
	
	@Override
	public boolean isExist(String rolename) {
		List<Param>  paramList=new ArrayList<Param>();
		String  hql="  FROM   com.trs.rms.usermgr.bean.RmsGroup  where  groupName=?";
		paramList.add(new Param(Types.VARCHAR, rolename.trim()));
		@SuppressWarnings("unchecked")
		List<RmsGroup> list = dao.query(hql, paramList);
		if(list==null||list.size()==0)
		return false;
		return  true;
	}

	@Override
	public boolean isExist(Long id, String rolename) {
		List<Param>  paramList=new ArrayList<Param>();
		String  hql="  FROM   com.trs.rms.usermgr.bean.RmsGroup  where  groupName=?  AND groupId<>?";
		paramList.add(new Param(Types.VARCHAR, rolename.trim()));
		paramList.add(new Param(Types.BIGINT, id));

		@SuppressWarnings("unchecked")
		List<RmsGroup> list = dao.query(hql, paramList);
		if(list==null||list.size()==0)
		return false;
		return  true;
	}
   
	@Override
	public List<RmsUser> queryUserByGroupIdN(Long groupId) {
		List<Param>  paramList=new ArrayList<Param>();
		String  hql="  select rgu.rmsUser "
				+ "from  com.trs.rms.usermgr.bean.RmsGroupUser  rgu where  rgu.rmsGroup.groupId=?  ) ";
		
		paramList.add(new Param(Types.BIGINT, groupId));
		@SuppressWarnings("unchecked")
		List<RmsUser> groupuserlist = dao.query(hql, paramList);
		
		String   userids="";
		if(groupuserlist!=null&&groupuserlist.size()>0){
			
		}
		
		
		paramList=new ArrayList<Param>();
		hql="  FROM   com.trs.rms.usermgr.bean.RmsUser  ru.userType=?   ";
		hql= hql+"  and ru.userState<>?  and ru.userId  = some  ( select rgu.rmsUser.userId  "
				+ "from  com.trs.rms.usermgr.bean.RmsGroupUser  rgu where  rgu.rmsGroup.groupId=?  ) ";
		paramList.add(new Param(Types.INTEGER, 1));
		paramList.add(new Param(Types.INTEGER, 2));
		paramList.add(new Param(Types.BIGINT, groupId));
		
		@SuppressWarnings("unchecked")
		List<RmsUser> list = dao.query(hql, paramList);
		
		return list;
	}

	@Override
	public List<RmsUser> queryUserByGroupId(Long groupId) {
		List<Param>  paramList=new ArrayList<Param>();
		String  hql="  select rgu.rmsUser "
				+ "from  com.trs.rms.usermgr.bean.RmsGroupUser  rgu where  rgu.rmsGroup.groupId=?  ) ";
		
		paramList.add(new Param(Types.BIGINT, groupId));
		@SuppressWarnings("unchecked")
		List<RmsUser> list = dao.query(hql, paramList);
		
		return list;
	}

	

	
	
    
}
