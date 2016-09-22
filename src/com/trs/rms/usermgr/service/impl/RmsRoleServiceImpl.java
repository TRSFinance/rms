package com.trs.rms.usermgr.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trs.rms.base.dao.IDao;
import com.trs.rms.base.service.BasicServicveImpl;
import com.trs.rms.usermgr.bean.RmsRole;
import com.trs.rms.usermgr.bean.RmsRolePerm;
import com.trs.rms.usermgr.bean.RmsUser;
import com.trs.rms.usermgr.service.RmsRoleService;
@Service
@Transactional
public class RmsRoleServiceImpl  extends  BasicServicveImpl   implements RmsRoleService {
	
	@Autowired
	public  void  setMyDao(IDao dao){
		super.setDao(dao);
	}

	@Override
	public void delQuery() {
		try{
			RmsRole rmsRole = (RmsRole) dao.queryById(RmsRole.class, 1L);
			System.out.println(rmsRole.getRoleName());
			RmsRolePerm rp = rmsRole.getRmsRolePerm();
			System.out.println(rp.getUpdateTime());
			RmsUser rmsUser = (RmsUser) dao.queryById(RmsUser.class, 1L);
			
			RmsUser rmsUser2 = (RmsUser) dao.queryById(RmsUser.class, 2L);
			
			RmsUser rmsUser3 = (RmsUser) dao.queryById(RmsUser.class, 3L);

			Set perms = rmsUser.getRolePerms();

			System.out.println(perms.size());
			//RmsRole rmsRole2 = new RmsRole("超级管理员", new Date(), new Date(), 1);
			//RmsRolePerm rpw = new RmsRolePerm(rmsRole2, "", new Date(), new Date());
			//dao.save(rmsRole2);
			//dao.save(rpw);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
	
    
}
