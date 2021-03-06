package com.trs.rms.base.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.trs.rms.base.page.Param;

@Repository
public class DaoImpl extends HibernateDaoSupport implements IDao {

	/**
	 * 查询列表（不分页）
	 * @param hql语句
	 * @return list
	 */
	public List query(String hql) {
		
		return super.getHibernateTemplate().find( hql );
	}
	
	@SuppressWarnings("unchecked")
	public List query(final String  hql,final List  paramList){
		return (List) super.getHibernateTemplate().execute(new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				
				Query query = session.createQuery(hql );
				for (int i = 0; i <paramList.size(); i++) {
					Param p = (Param)paramList.get(i);					
					switch( p.getType() ){
					case Types.VARCHAR:
						query.setString( i , (String)p.getValue() );
						break;
					case Types.INTEGER:
						query.setInteger( i , (Integer)p.getValue() );
						break;
					case Types.FLOAT:
						query.setFloat( i , (Float)p.getValue() );
						break;
					case Types.DOUBLE:
						query.setDouble( i , (Double)p.getValue() );
						break;
					case Types.BIGINT:
						query.setLong(i, (Long)p.getValue());
						break;
					case Types.DATE:
						query.setDate( i , (Date)p.getValue() );
						break;
					case Types.ARRAY:
						query.setParameterList("inParam0", (List) p.getValue() );
						break;
					default:
						query.setString( i , (String)p.getValue() );
						break;
					}
				}
				return query.list();
			}
		});
	}
	
    
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List query(final String hql, final List paramList, final int firstResult,
			final int maxResults) {
		return (List) super.getHibernateTemplate().execute(new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				
				Query query = session.createQuery(hql );
				if(paramList!=null&&paramList.size()>0){
				for (int i = 0; i <paramList.size(); i++) {
					Param p = (Param)paramList.get(i);					
					switch( p.getType() ){
					case Types.VARCHAR:
						query.setString( i , (String)p.getValue() );
						break;
					case Types.INTEGER:
						query.setInteger( i , (Integer)p.getValue() );
						break;
					case Types.FLOAT:
						query.setFloat( i , (Float)p.getValue() );
						break;
					case Types.DOUBLE:
						query.setDouble( i , (Double)p.getValue() );
						break;
					case Types.BIGINT:
						query.setLong(i, (Long)p.getValue());
						break;
					case Types.DATE:
						query.setDate( i , (Date)p.getValue() );
						break;
					case Types.ARRAY:
						query.setParameterList("inParam0", (List) p.getValue() );
						break;	
					default:
						query.setString( i , (String)p.getValue() );
						
						break;
					}
				}}
				query.setFirstResult(firstResult);
				query.setMaxResults(maxResults);
				return query.list();
			}
		});
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	public Object queryById(Class cla, Serializable id) {
		
		return this.getHibernateTemplate().load( cla, id);
	}

	public void save(Object obj) {
		super.getHibernateTemplate().save( obj );
	}

	public void update(Object obj) {
		super.getHibernateTemplate().update( obj );
	}
	
	@SuppressWarnings("unchecked")
	public void update(final String hql,final List  paramList){
		
		super.getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				
				Query query = session.createQuery(hql );
				for (int i = 0; i <paramList.size(); i++) {
					Param p = (Param)paramList.get(i);					
					switch( p.getType() ){
					case Types.VARCHAR:
						query.setString( i , (String)p.getValue() );
						break;
					case Types.INTEGER:
						query.setInteger( i , (Integer)p.getValue() );
						break;
					case Types.FLOAT:
						query.setFloat( i , (Float)p.getValue() );
						break;
					case Types.DOUBLE:
						query.setDouble( i , (Double)p.getValue() );
						break;
					case Types.DATE:
						query.setDate( i , (Date)p.getValue() );
						break;
					case Types.BIGINT:
						query.setLong(i, (Long)p.getValue());
						break;
					case Types.TIMESTAMP:
						query.setTimestamp(i, new Timestamp(System.currentTimeMillis()));
						break;
					default:
						query.setString( i , (String)p.getValue() );
						break;
					}
				}
				

				
				
				
				return query.executeUpdate();
			}
		});
		
	}
	
@SuppressWarnings("unchecked")
public void updateSql(final String Sql,final List  paramList){
		
		super.getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				
				Query query = session.createSQLQuery(Sql );
				for (int i = 0; i <paramList.size(); i++) {
					Param p = (Param)paramList.get(i);					
					switch( p.getType() ){
					case Types.VARCHAR:
						query.setString( i , (String)p.getValue() );
						break;
					case Types.INTEGER:
						query.setInteger( i , (Integer)p.getValue() );
						break;
					case Types.FLOAT:
						query.setFloat( i , (Float)p.getValue() );
						break;
					case Types.DOUBLE:
						query.setDouble( i , (Double)p.getValue() );
						break;
					case Types.DATE:
						query.setDate( i , (Date)p.getValue() );
						break;
					case Types.BIGINT:
						query.setLong(i, (Long)p.getValue());
						break;
					case Types.TIMESTAMP:
						query.setTimestamp(i, new Timestamp(System.currentTimeMillis()));
						break;
					default:
						query.setString( i , (String)p.getValue() );
						break;
					}
				}
				return query.executeUpdate();
			}
		});
		
	}
	

	public void delete(Object obj) {
		super.getHibernateTemplate().delete(obj);
	}

	public void delete(Collection c) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().deleteAll(c);
	}

	
	public void clear(Object obj) {
		super.getHibernateTemplate().evict(obj);
		
	}
	
	public void merge(Object obj){
		super.getHibernateTemplate().merge(obj);
		
	}
	public Object getById(Class cla, Serializable id) {

		return super.getHibernateTemplate().get(cla, id);
	}

	@Override
	public void save(Collection c) {
		for (Iterator iterator = c.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			super.getHibernateTemplate().save( object );
		}
	}

	@Resource(name="sessionFactory") 
	public void setMySessionFactory(SessionFactory sessionFactory){  
	    super.setSessionFactory(sessionFactory);  
	} 
	
}
