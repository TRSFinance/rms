package com.trs.rms.usermgr.service.impl;

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
import com.trs.rms.company.bean.RmsCompanyInfo;
import com.trs.rms.company.bean.RmsCorporateCust;
import com.trs.rms.company.bean.RmsCorporateUser;
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
	public void saveRole(String roleName, Integer isAllPerm,String description, String perms) {
		RmsRole rmsRole = new RmsRole(roleName, new Date(), new Date(), isAllPerm);
		rmsRole.setDescription(description);
		rmsRole.setPriority(2);
		RmsRolePerm rpw = new RmsRolePerm(rmsRole, perms, new Date(), new Date());
		dao.save(rmsRole);
		dao.save(rpw);
	}

	@Override
	public void delQuery() {
		try{
		RmsCompanyInfo  companyInfo=new RmsCompanyInfo("测试", "测试", "测试", "测试", "测试",
				"测试", "测试", "测试", 
				"测试", "测试", "测试", "测试", "C",
				1, new Date(), new Date(), 1, "",
				"", "");
		dao.save(companyInfo);
		List<RmsCorporateUser> list = dao.query("  FROM  com.trs.rms.company.bean.RmsCorporateUser  where userId=1");
		
		RmsCorporateUser    user=	list.get(0);
		
		RmsCorporateCust  corporateCust=new  RmsCorporateCust();
		
		corporateCust.setCorporateUser(user);
		corporateCust.setCompanyInfo(companyInfo);
		corporateCust.setCreateTime(new Date());
		dao.save(corporateCust);}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	@Override
	public void updateRole(Long id, String roleName, Integer isAllPerm,String  description,		String perms) {
		RmsRole role = (RmsRole) this.dao.getById(RmsRole.class, id);
		
		RmsRolePerm rolePerm = role.getRmsRolePerm();
		if(rolePerm!=null){
			role.setRoleName(roleName);
			role.setIsAllPerm(isAllPerm);
			role.setDescription(description);
			role.setUpdateTime(new Date());
			rolePerm.setRolePerms(perms);
			rolePerm.setUpdateTime(new Date());
            this.dao.update(role);
            this.dao.update(rolePerm);
		}
	}
	@Override
	public void delRole(long id) {
		RmsRole role = (RmsRole) this.dao.getById(RmsRole.class, id);
		if(role!=null){
			if(role.getPriority()==1)
				return;
		}
	    this.dao.delete(role);
	}
	@Transactional(readOnly=true)
	public boolean isExist(String rolename) {
		List<Param>  paramList=new ArrayList<Param>();
		String  hql="  FROM   com.trs.rms.usermgr.bean.RmsRole  where  roleName=?";
		paramList.add(new Param(Types.VARCHAR, rolename.trim()));
		@SuppressWarnings("unchecked")
		List<RmsRole> list = dao.query(hql, paramList);
		if(list==null||list.size()==0)
		return false;
		return  true;
	}
	@Transactional(readOnly=true)
	public boolean isExist(Long id, String rolename) {
		
		
		List<Param>  paramList=new ArrayList<Param>();
		String  hql="  FROM   com.trs.rms.usermgr.bean.RmsRole  where  roleName=? AND  roleId<>?";
		paramList.add(new Param(Types.VARCHAR, rolename.trim()));
		paramList.add(new Param(Types.BIGINT, id));

		@SuppressWarnings("unchecked")
		List<RmsRole> list = dao.query(hql, paramList);
		if(list==null||list.size()==0)
		return false;
		return  true;	
	}

	

	
	
    
}
