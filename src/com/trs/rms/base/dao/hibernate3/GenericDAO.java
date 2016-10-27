package com.trs.rms.base.dao.hibernate3;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

/**
 * 泛型DAO接口。
 * @author wengjing
 *
 * @param <T> 实体类型。
 * @param <ID> 实体ID的类型。
 */
public interface GenericDAO<T, ID extends Serializable> {

	T findById(ID id, boolean lock);

	List<T> findAll();

	List<T> findByExample(T exampleInstance, String[] excludeProperty);

	T makePersistent(T entity);

	void makeTransient(T entity);

	void batchSave(Collection<T> entities);

	void save(T entity) ;
		
	void update(T entity) ;

}
