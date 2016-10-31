package com.trs.rms.base.common;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;

public class RestrictionsUtils{  
    public RestrictionsUtils(){  
    }  
//    /** 
//     *  
//     * @description:处理字符串中含转义字符问题 
//     * @return 
//     */  
//    public static Criterion ilike(final String propertyName, String value, MatchMode matchMode) {  
//        return new IlikeExpressionEx(propertyName, value, matchMode);  
//    }  
    /** 
     *  
     * @description:处理字符串中含转义字符问题 
     * @return 
     */  
    public static Criterion like(final String propertyName, String value, MatchMode matchMode) {  
        return new EscapeLikeExpression(propertyName, value, matchMode);  
    }  
}  

