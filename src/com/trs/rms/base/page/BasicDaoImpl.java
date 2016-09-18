package com.trs.rms.base.page;

import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 基本Dao
 * @date   2016-09-18
 * @author zxh
 */
public class BasicDaoImpl  extends HibernateDaoSupport  implements   IBasicDao{
      
	/**
	    * 分页查询数据库表中记录 
	    * @author 邹许红
	    * @return List
	    */
		@SuppressWarnings("unchecked")
		public List queryObjectsToPages( final BasicPage page ){
			HibernateTemplate hibernateTemplate = new HibernateTemplate( this.getSessionFactory() );
			return (List) hibernateTemplate.execute( new HibernateCallback(){
				public Object doInHibernate(Session session) throws HibernateException,SQLException {
					Query query = session.createQuery(   page.getHQLString()  );
					
					List list = page.getParamList();
		
					for (int i = 0; i < list.size(); i++) {
						Param p = (Param) list.get( i );
						
						switch( p.getType() ){
						case Types.VARCHAR:
							query.setString(i, String.valueOf( p.getValue() )   );
							
							break;
						case Types.INTEGER:
							query.setInteger(i, (java.lang.Integer) p.getValue()   );
							break;
						case Types.FLOAT:
							query.setFloat(i, (java.lang.Float) p.getValue()   );
							break;
						case Types.DOUBLE:
							query.setDouble(i, (java.lang.Double) p.getValue()   );
							break;
						case Types.BOOLEAN:
							query.setBoolean(i, ((Boolean) p.getValue()).booleanValue());
							break;
						case Types.CHAR:
							query.setCharacter(i, ((Character) p.getValue()).charValue());
							break;
						case Types.DATE:
							query.setTimestamp(i, (java.util.Date) p.getValue());
							break;
						case Types.BIGINT:
							query.setLong(i, (Long)p.getValue());
							break;
						case Types.ARRAY:
							query.setParameterList("inParam0", (List) p.getValue() );
							break;
						}
		
						
					}
					
					
					
					query.setFirstResult(  (page.getPageNo()-1)*page.getPageSize()  );
					query.setMaxResults(  page.getPageSize() );
					
					return query.list();
				}
				
			});
		}
		
		/**
		 * 取记录总数
		 * @author 邹许红
		 * @return int
		 */
		@SuppressWarnings("unchecked")
		public int queryForInt( final BasicPage page ){
			
			HibernateTemplate hibernateTemplate = new HibernateTemplate( this.getSessionFactory() );
			
			return (Integer) hibernateTemplate.execute( new HibernateCallback(){

		
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(   page.getHQLCountString()  );
					
					List list = page.getParamList();

					for (int i = 0; i < list.size(); i++) {
						Param p = (Param) list.get( i );
						
						switch( p.getType() ){
						case Types.VARCHAR:
							query.setString(i, String.valueOf( p.getValue() )   );
							break;
						case Types.INTEGER:
							query.setInteger(i, (java.lang.Integer) p.getValue()   );
							break;
						case Types.FLOAT:
							query.setFloat(i, (java.lang.Float) p.getValue()   );
							break;
						case Types.DOUBLE:
							query.setDouble(i, (java.lang.Double) p.getValue()   );
							break;
						case Types.BOOLEAN:
							query.setBoolean(i, ((Boolean) p.getValue()).booleanValue());
							break;
						case Types.CHAR:
							query.setCharacter(i, ((Character) p.getValue()).charValue());
							break;
						case Types.DATE:
							query.setTimestamp(i, (java.util.Date) p.getValue());
							break;
						case Types.BIGINT:
							query.setLong(i, (Long)p.getValue());
							break;
						case Types.ARRAY:
							query.setParameterList("inParam0", (List) p.getValue() );
							break;
						}
						
					}
					String  num=((Long) query.list().get(0)).toString();

					return Integer.valueOf(num);
				}
				
			});

		}
		
	
}
