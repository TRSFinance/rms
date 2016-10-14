package com.trs.rms.usermgr.service.impl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trs.rms.base.dao.IDao;
import com.trs.rms.base.page.Param;
import com.trs.rms.base.service.BasicServicveImpl;
import com.trs.rms.usermgr.bean.RmsGroup;
import com.trs.rms.usermgr.bean.RmsGroupUser;
import com.trs.rms.usermgr.bean.RmsUser;
import com.trs.rms.usermgr.service.RmsGroupService;
@Service
@Transactional
public class RmsGroupServiceImpl  extends  BasicServicveImpl   implements RmsGroupService {
	
	@Autowired
	public  void  setMyDao(IDao dao){
		super.setDao(dao);
	}
	
	@Transactional(readOnly=true)
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

	@Transactional(readOnly=true)
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
   
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<RmsUser> queryUserByGroupIdN(Long groupId,String userName) {
		List<Param>  paramList=new ArrayList<Param>();
		String  hql="  select rgu.rmsUser "
				+ "from  com.trs.rms.usermgr.bean.RmsGroupUser  rgu where  rgu.rmsGroup.groupId=?  ";
		paramList.add(new Param(Types.BIGINT, groupId));
		List<RmsUser> groupuserlist = dao.query(hql, paramList);
		
		@SuppressWarnings("rawtypes")
		List       userIds=new ArrayList();
		if(groupuserlist!=null&&groupuserlist.size()>0){
			for (int i = 0; i < groupuserlist.size(); i++) {
				userIds.add(groupuserlist.get(i).getUserId());
			}
		}else{
			userIds.add(-1L);
		}
		paramList=new ArrayList<Param>();
		hql="  FROM   com.trs.rms.usermgr.bean.RmsUser  ru where   ru.userType = ?   ";
		hql= hql+"    and   ru.userState <> ?    ";
		
		paramList.add(new Param(Types.INTEGER, 1));
		paramList.add(new Param(Types.INTEGER, 2));
		if(StringUtils.isNotBlank(userName)){
			hql=hql+"  and ( ru.loginName like ?  or ru.nickName  like  ?) ";
		    String  value="%"+userName+"%";
			paramList.add(new Param(Types.VARCHAR, value));
			paramList.add(new Param(Types.VARCHAR, value));

		}
		hql=hql+"  and  ru.userId  not  in (:inParam0) ";
		paramList.add(new Param(Types.ARRAY, userIds));
		
		List<RmsUser> list = dao.query(hql, paramList);
		return list;
	}
	@Transactional(readOnly=true)
	public List<RmsUser> queryUserByGroupId(Long groupId,String userName) {
		List<Param>  paramList=new ArrayList<Param>();
		String  hql="  select rgu.rmsUser "
				+ "from  com.trs.rms.usermgr.bean.RmsGroupUser  rgu where  rgu.rmsGroup.groupId=?   ";
		
		paramList.add(new Param(Types.BIGINT, groupId));
		if(StringUtils.isNotBlank(userName)){
			hql=hql+"  and ( rgu.rmsUser.loginName like ?  or rgu.rmsUser.nickName  like  ?) ";
		    String  value="%"+userName+"%";
			paramList.add(new Param(Types.VARCHAR, value));
			paramList.add(new Param(Types.VARCHAR, value));

		}
		@SuppressWarnings("unchecked")
		List<RmsUser> list = dao.query(hql, paramList);
		
		return list;
	}
	@Override
	public void addGroupUsers(Long groupId, String userIds) {
	         RmsGroup group = (RmsGroup) dao.queryById(RmsGroup.class, groupId);
	         List<RmsGroupUser>  list=new ArrayList<RmsGroupUser>();
	         if(userIds==null||userIds.length()==0)
	        	 return;
	        String[] userIdList=userIds.split(",");
		     for (int i = 0; i < userIdList.length; i++) {
		    	 RmsUser user = (RmsUser) dao.queryById(RmsUser.class, Long.valueOf(userIdList[i]));
		    	 list.add(new   RmsGroupUser(user, group, new Date()));
			}
		        dao.save(list);
		
	}
	@Override
	public void addGroupUser(Long groupId, Long userId) {
        RmsGroup group = (RmsGroup) dao.queryById(RmsGroup.class, groupId);
   	    RmsUser user = (RmsUser) dao.queryById(RmsUser.class, userId);
        dao.save(new   RmsGroupUser(user, group, new Date()));
	}

	@Override
	public void delGroupUsers(Long groupId, String userIds) {
	    String  hql="delete  RmsGroupUser rgu  where rgu.rmsGroup.groupId=?  and rgu.rmsUser.userId=?";
	    if(userIds==null||userIds.length()==0)
       	 return;
       String[] userIdList=userIds.split(",");
	     for (int i = 0; i < userIdList.length; i++) {
	 		List<Param>  paramList=new ArrayList<Param>();
	 		paramList.add(new Param(Types.BIGINT, groupId));
	 		paramList.add(new Param(Types.BIGINT, Long.valueOf(userIdList[i])));
	 		dao.update(hql, paramList);
		}
	
	
	}


    
}
