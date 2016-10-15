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
	List<RmsUser>  queryUserByGroupId(Long groupId,String userName);
	/**
	 * 通过组织ID查询不在当前组织下系统用户
	 * @param groupId
	 * @return
	 */
	List<RmsUser>  queryUserByGroupIdN(Long groupId,String userName);
	/**
	 * 批量添加用户到组织
	 * @param groupId
	 *        组织ID
	 * @param userIds
	 *        用户ID列表
	 */
	void      addGroupUsers(Long groupId,String userIds);
	/**
	 * 添加用户到组织
	 * @param groupId
	 *        组织ID
	 * @param userId
	 *        用户ID
	 */
	void      addGroupUser(Long groupId,Long userId);
	/**
	 * 删除组织用户
	 * @param groupId
	 *        组织ID
	 * @param userId
	 *        用户ID
	 */
	void delGroupUsers(Long groupId, String userIds);


}
