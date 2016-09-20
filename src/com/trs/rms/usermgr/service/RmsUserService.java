package com.trs.rms.usermgr.service;

import com.trs.rms.base.service.BasicService;
import com.trs.rms.usermgr.bean.RmsUser;

public interface RmsUserService  extends   BasicService {
	/**
	 * 通过用户名查询用户
	 * @param username
	 * @return
	 */
	RmsUser findByUsername(String username);
}
