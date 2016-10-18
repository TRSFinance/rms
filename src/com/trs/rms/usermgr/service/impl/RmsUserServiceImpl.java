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
import com.trs.rms.usermgr.bean.RmsRole;
import com.trs.rms.usermgr.bean.RmsUser;
import com.trs.rms.usermgr.bean.RmsUserRole;
import com.trs.rms.usermgr.service.RmsUserService;
@Service
@Transactional
public class RmsUserServiceImpl  extends  BasicServicveImpl   implements RmsUserService {
	
	@Autowired
	public  void  setMyDao(IDao dao){
		super.setDao(dao);
	}

	@Transactional(readOnly=true)
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

	@Transactional(readOnly=true)
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

	@SuppressWarnings("unchecked")
	@Override
	public List<RmsRole> queryRoleByUserIdN(Long userId, String search) {
		List<Param>  paramList=new ArrayList<Param>();
		String  hql="  select rgr.rmsRole "
				+ "from  com.trs.rms.usermgr.bean.RmsUserRole rgr where  rgr.rmsUser.userId=?   ";
		
		paramList.add(new Param(Types.BIGINT, userId));
		List<RmsRole> userRolelist = dao.query(hql, paramList);
		
		@SuppressWarnings("rawtypes")
		List       roleIds=new ArrayList();
		if(userRolelist!=null&&userRolelist.size()>0){
			for (int i = 0; i < userRolelist.size(); i++) {
				roleIds.add(userRolelist.get(i).getRoleId());
			}
		}else{
			roleIds.add(-1L);
		}
		paramList=new ArrayList<Param>();
		hql="  FROM   com.trs.rms.usermgr.bean.RmsRole  rr where   1=1  ";
		if(StringUtils.isNotBlank(search)){
			hql=hql+"  and  rr.roleName like ?   ";
		    String  value="%"+search+"%";
			paramList.add(new Param(Types.VARCHAR, value));
		}
		hql=hql+"  and  rr.roleId  not  in (:inParam0) ";
		paramList.add(new Param(Types.ARRAY, roleIds));
		List<RmsRole> list = dao.query(hql, paramList);
		return list;
	}

	@Override
	public List<RmsRole> queryRoleByUserId(Long userId, String search) {
		List<Param>  paramList=new ArrayList<Param>();
		String  hql="  select rgr.rmsRole "
				+ "from  com.trs.rms.usermgr.bean.RmsUserRole rgr where  rgr.rmsUser.userId=?   ";
		
		paramList.add(new Param(Types.BIGINT, userId));
		if(StringUtils.isNotBlank(search)){
			hql=hql+"  and rgr.rmsRole.roleName like  ?";
		    String  value="%"+search+"%";
			paramList.add(new Param(Types.VARCHAR, value));

		}
		@SuppressWarnings("unchecked")
		List<RmsRole> list = dao.query(hql, paramList);
		
		return list;
	}

	@Override
	public void delUserRoles(Long userId, String ids) {
		 String  hql="delete  com.trs.rms.usermgr.bean.RmsUserRole rur  where rur.rmsUser.userId=?  and rur.rmsRole.roleId=?";
		    if(ids==null||ids.length()==0)
	       	 return;
	       String[] roleIds=ids.split(",");
		     for (int i = 0; i < roleIds.length; i++) {
		 		List<Param>  paramList=new ArrayList<Param>();
		 		paramList.add(new Param(Types.BIGINT, userId));
		 		paramList.add(new Param(Types.BIGINT, Long.valueOf(roleIds[i])));
		 		dao.update(hql, paramList);
			}
	}

	@Override
	public void addUserRoles(Long userId, String ids) {
		RmsUser user = (RmsUser) dao.queryById(RmsUser.class, userId);
	         List<RmsUserRole>  list=new ArrayList<RmsUserRole>();
	         if(ids==null||ids.length()==0)
	        	 return;
	        String[] roleIds=ids.split(",");
		     for (int i = 0; i < roleIds.length; i++) {
		    	 RmsRole role = (RmsRole) dao.queryById(RmsRole.class, Long.valueOf(roleIds[i]));
		    	 list.add(new   RmsUserRole(user, role, new Date(),new Date()));
			}
		        dao.save(list);		
	}
	
    
}
