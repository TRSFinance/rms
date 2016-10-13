package com.trs.rms.usermgr.service;

import com.trs.rms.base.service.BasicService;

public interface RmsRoleService  extends   BasicService {
	
	void   delQuery();
	
	void  saveRole(String roleName,Integer isAllPerm,String description,String perms);
	void  updateRole(Long id,String roleName,Integer isAllPerm,String description,String perms);
	void  delRole(long id);
	boolean isExist(String rolename);
	
	boolean isExist(Long id,String rolename);

}
