package com.trs.rms.usermgr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trs.rms.base.dao.IDao;
import com.trs.rms.base.service.BasicServicveImpl;
import com.trs.rms.usermgr.bean.RmsRole;
import com.trs.rms.usermgr.bean.RmsRolePerm;
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
			RmsRole rmsRole2 = (RmsRole) dao.queryById(RmsRole.class, 2L);
			RmsRolePerm rp2 = rmsRole2.getRmsRolePerm();
			System.out.println(rp2.getUpdateTime());
			
			dao.delete(rmsRole2);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
	
    
}
