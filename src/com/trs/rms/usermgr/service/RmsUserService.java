package com.trs.rms.usermgr.service;

import java.util.List;

import com.trs.rms.base.service.BasicService;
import com.trs.rms.usermgr.bean.RmsRole;
import com.trs.rms.usermgr.bean.RmsUser;

public interface RmsUserService  extends   BasicService {
	/**
	 * 通过用户名查询用户
	 * @param username
	 * @return
	 */
	RmsUser findByUsername(String username);
	boolean isExist(String username);
	List<RmsRole> queryRoleByUserIdN(Long userId, String search);
	List<RmsRole> queryRoleByUserId(Long userId, String search);
	void delUserRoles(Long userId, String ids);
	void addUserRoles(Long userId, String ids);
}
