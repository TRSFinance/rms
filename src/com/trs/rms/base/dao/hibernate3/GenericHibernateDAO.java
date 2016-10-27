package com.trs.rms.base.dao.hibernate3;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import com.trs.rms.base.page.OffsetLimit;
import com.trs.rms.base.page.PageCriterion;
import com.trs.rms.base.page.PagedArrayList;
/**
 * 使用Hibernate ORM实现的泛型DAO接口。
 * @author wengjing
 * @author zxh
 * @param <T> 实体类型。
 * @param <ID> 实体ID的类型。
 */
public abstract class GenericHibernateDAO<T, ID extends Serializable>  implements GenericDAO<T, ID> {
	// fields ---------------------------------------------------------------------
	private Class<T> persistentClass;
	private SessionFactory sessionFactory;
	protected int batchSize=20;

	// methods ---------------------------------------------------------------------
	@SuppressWarnings("unchecked")
	public GenericHibernateDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public List<T> findAll() {
		return findByCriteria();
	}


	@SuppressWarnings("unchecked")
	public List<T> findByExample(T exampleInstance, String[] excludeProperty) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria crit = session.createCriteria(getPersistentClass());
		Example example = Example.create(exampleInstance);
		for (String exclude : excludeProperty) {
			example.excludeProperty(exclude);
		}
		crit.add(example);
		return crit.list();

	}

	@SuppressWarnings("unchecked")
	public T findById(ID id, boolean lock) {
		Session session = getSessionFactory().getCurrentSession();
		T entity;
		if (lock)
			entity = (T) session.get(getPersistentClass(), id, LockMode.UPGRADE);
		else
			entity = (T) session.get(getPersistentClass(), id);

		return entity;

	}

	
	public T makePersistent(T entity) {
		Session session = getSessionFactory().getCurrentSession();
		session.saveOrUpdate(entity);
		// session.flush();
		return entity;
	}

	public void makeTransient(T entity) {
		Session session = getSessionFactory().getCurrentSession();
		session.delete(entity);
	}

	
	public void save(T entity) {
		Session session = getSessionFactory().getCurrentSession();
		session.save(entity);
		session.flush();
	}
	
	public void update(T entity) {
		Session session = getSessionFactory().getCurrentSession();
		session.update(entity);
		session.flush();

	}


	
	
	public void SaveCompanyStat(ArrayList<T> list){
		 Session session = null;
		 if (list != null && list.size() > 0){
			 try {
				  session = getSessionFactory().getCurrentSession();
				 for(int i=0;i<list.size();i++){
					 T c=list.get(i);
					 session.save(c);
					 if (i % 100 == 0) {
				         session.flush();
				         session.clear();
				     }
				 }
			}
			catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		 }
	}
	public void patchSaveCompany(ArrayList<T> list){
		 Session session = null;
		 if (list != null && list.size() > 0){
			 try {
				  session = getSessionFactory().getCurrentSession();
				 for(int i=0;i<list.size();i++){
					 T c=list.get(i);
					 session.save(c);
					 if (i % 100 == 0) {
				         session.flush();
				         session.clear();
				     }
				 }
			}
			catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		 }
	}


	/**
	 * Use this inside subclasses as a convenience method.
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion... criterion) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria crit = session.createCriteria(getPersistentClass());
		for (Criterion c : criterion) {
			crit.add(c);
		}
		return crit.list();
	}

	protected PagedArrayList<T> findByPage(Criteria criteria,PageCriterion pageCriterion,Order... orders){
		boolean doPage=pageCriterion!=null&&pageCriterion.getPageSize()>0;
		int count=0,offset=0,pageSize=0;
		if(doPage){
			pageSize=pageCriterion.getPageSize();
			count=((Number)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
			if(0==count) return new PagedArrayList<T>();
			int totalPages=(int) ((count+pageCriterion.getPageSize()-1)/pageCriterion.getPageSize());
			int pageNumber;
			if(pageCriterion.getPageNum()<1)
				pageNumber=1;
			else if(pageCriterion.getPageNum()>totalPages)
				pageNumber=totalPages;
			else
				pageNumber=pageCriterion.getPageNum();
			offset=(pageNumber-1)*pageCriterion.getPageSize();
			criteria.setProjection(null)
				.setFirstResult(offset)
				.setMaxResults(pageCriterion.getPageSize());
		}

		if(null!=orders){
			for(Order order:orders){
				criteria.addOrder(order);
			}
		}
		List list=criteria.list();

		if(!doPage){
			count=list.size();
			offset=0;
			pageSize=count;
		}

		return new PagedArrayList<T>(list,count,offset,pageSize);
	}

	public static <T> PagedArrayList<T> findByPageEx(Criteria criteria, PageCriterion pageCriterion, Order... orders) {
		int count = ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		if (0 == count)
			return new PagedArrayList<T>();
		int totalPages = (int) ((count + pageCriterion.getPageSize() - 1) / pageCriterion.getPageSize());
		int pageNumber;
		if (pageCriterion.getPageNum() < 1)
			pageNumber = 1;
		else if (pageCriterion.getPageNum() > totalPages)
			pageNumber = totalPages;
		else
			pageNumber = pageCriterion.getPageNum();
		int offset = (pageNumber - 1) * pageCriterion.getPageSize();
		criteria.setProjection(null).setFirstResult(offset).setMaxResults(pageCriterion.getPageSize());
		if (null != orders) {
			for (Order order : orders) {
				criteria.addOrder(order);
			}
		}
		List list = criteria.list();
		return new PagedArrayList<T>(list, count, offset, pageCriterion.getPageSize());
	}

	protected PagedArrayList<T> findByPage(Criteria criteria, OffsetLimit offsetLimit, Order... orders) {
		int count = ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		if (0 == count)
			return new PagedArrayList<T>();
		criteria.setProjection(null).setFirstResult((int) offsetLimit.getOffset())
				.setMaxResults(offsetLimit.getLimit());
		if (null != orders) {
			for (Order order : orders) {
				criteria.addOrder(order);
			}
		}
		List list = criteria.list();
		return new PagedArrayList<T>(list, count, offsetLimit.getOffset(), offsetLimit.getLimit());
	}

	public static <T> PagedArrayList<T> findByPageEx(Criteria criteria, OffsetLimit offsetLimit, Order... orders) {
		int count = ((Number) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		if (0 == count)
			return new PagedArrayList<T>();
		criteria.setProjection(null).setFirstResult((int) offsetLimit.getOffset())
				.setMaxResults(offsetLimit.getLimit());
		if (null != orders) {
			for (Order order : orders) {
				criteria.addOrder(order);
			}
		}
		List list = criteria.list();
		return new PagedArrayList<T>(list, count, offsetLimit.getOffset(), offsetLimit.getLimit());
	}

	protected Order[] parseOrders(String trsStyleOrders) {
		List<Order> orderList = new ArrayList<Order>();
		String[] fields = StringUtils.split(trsStyleOrders, ",; ");
		if (null != fields && fields.length > 0) {
			for (String field : fields) {
				field = StringUtils.trimToNull(field);
				if (StringUtils.startsWith(field, "+")) {
					String name = StringUtils.substring(field, 1);
					orderList.add(Order.asc(name));
				}
				else if (StringUtils.startsWith(field, "-")) {
					String name = StringUtils.substring(field, 1);
					orderList.add(Order.desc(name));
				}
				else if (StringUtils.isNotBlank(field)) {
					orderList.add(Order.asc(field));
				}
			}
		}
		if (orderList.isEmpty())
			return null;
		else
			return orderList.toArray(new Order[orderList.size()]);
	}

	/**
	 * 批量保存实体对象.
	 *
	 * @param entities 实体对象集合
	 */
	public void batchSave(Collection<T> entities){
		if(entities==null||entities.isEmpty())
			return;
		Session session=getSessionFactory().getCurrentSession();
		int count=0;
		for(T entity:entities){
			count++;
			session.save(entity);
			if(count%batchSize==0){
				session.flush();
				session.clear();
			}
		}
	}



	// accessors ---------------------------------------------------------------------
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	//注入sessionFactory
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	/**
	 * 获取批量操作的大小.
	 *
	 * @return 批量操作的大小，默认20
	 */
	public int getBatchSize() {
		return batchSize;
	}

	/**
	 * 设置批量操作的大小.
	 *
	 * @param batchSize 批量操作的大小，默认20
	 */
	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}
}
