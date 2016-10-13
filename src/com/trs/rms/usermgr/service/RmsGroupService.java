package com.trs.rms.usermgr.service;

import java.util.List;

import com.trs.rms.base.service.BasicService;
import com.trs.rms.usermgr.bean.RmsUser;

public interface RmsGroupService  extends   BasicService {
	
	
	
	boolean isExist(String rolename);
	boolean isExist(Long id,String rolename);
	/**
	 * 通过组织ID查询当前组织下系统用户
	 * @param groupId
	 * @return
	 */
	List<RmsUser>  queryUserByGroupId(Long groupId);
	/**
	 * 通过组织ID查询不在当前组织下系统用户
	 * @param groupId
	 * @return
	 */
	List<RmsUser>  queryUserByGroupIdN(Long groupId);


}
