package com.trs.rms.base.common;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.LikeExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.PostgreSQLDialect;

import com.trs.rms.base.util.StringOption;



public class EscapeLikeExpression extends LikeExpression{
	  /**
	 * 
	 */
	private static final long serialVersionUID = -6304263867955803580L;
	private final String propertyName;  
	private final String value;
	   
    protected EscapeLikeExpression(String propertyName, String value) {  
        super(propertyName, value);  
        this.propertyName = propertyName;  
        this.value = value.toString();  
    }  
    
    protected EscapeLikeExpression(String propertyName, String value, MatchMode matchMode) {  
        this( propertyName, matchMode.toMatchString(StringOption.escapeSQLLike(value.toString())));  
    }  
    public String toSqlString(Criteria criteria, CriteriaQuery criteriaQuery)  
    throws HibernateException {  
        Dialect dialect = criteriaQuery.getFactory().getDialect();  
        String[] columns = criteriaQuery.getColumnsUsingProjection(criteria, propertyName);  
        if (columns.length!=1) throw new HibernateException("like may only be used with single-column properties");  
        if ( dialect instanceof PostgreSQLDialect ) {  
        	return columns[0] + " like ? escape '/'";  
        }  
        else {  
            return dialect.getLowercaseFunction() + '(' + columns[0] + ") like ? escape '/'";  
        }  
    }

	public String getPropertyName() {
		return propertyName;
	}

	public String getValue() {
		return value;
	}  
    
    
    
    
}
