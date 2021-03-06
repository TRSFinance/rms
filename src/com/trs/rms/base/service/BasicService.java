package com.trs.rms.base.service;

import java.io.Serializable;

/**
 *
 * @author zxh
 *
 */
public interface BasicService {
	
	/**
	 * 查询一条对象
	 * @return
	 */
	public Object queryById( Class cla ,  Serializable id );
	/**
	 * 保存一个对象
	 * @return
	 */
	public void save( Object object );
	/**
	 * 修改一个对象
	 * @return
	 */
	public void update( Object object );
	/**
	 * 删除多个对象
	 * @return
	 */
	public void delete( Class cla ,  Serializable[] ids );
	
	/**
	 * 删除单个
	 * @return
	 */
	public void delete( Class cla ,  Serializable id);
	
	
	
}
