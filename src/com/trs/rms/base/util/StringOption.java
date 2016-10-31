package com.trs.rms.base.util;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trs.rms.base.exception.OTMException;




public class StringOption {
	private static final Logger LOGGER =LoggerFactory.getLogger(StringOption.class);
	private static int wrapNumber=20;//默认折行的字数
	private static int subNumber=18;//默认截取长度
	/**
	 * 字符串折行显示
	 * */
	public static String stringWrap(String wrapStr,int rowLength)
	{
		String result="";
		if(wrapStr==null)
		{
			return result;
		}
		if(wrapStr.trim().equals(""))
		{
			return result;
		}
		if(rowLength<=0)
		{
			rowLength=wrapNumber;
		}
		if(wrapStr.length()<=rowLength)
		{
			return wrapStr;
		}
		//如果字串中含有<br>则将其去除
		String[] tempArray=wrapStr.split("(<br>) | (<br/>)");
		wrapStr="";
		for(int i=0;i<tempArray.length;i++)
		{
			wrapStr+=tempArray[i];
		}
		//开始折行显示
	    /*int rowNumber=wrapStr.length()/rowLength;
	    for(int j=0;j<rowNumber;j++)
	    {
	    	result+=wrapStr.substring(j*rowLength,(j+1)*rowLength)+"<br/>";
	    }
	    if(wrapStr.length()%rowLength!=0)
	    {
	    	result+=wrapStr.substring(rowNumber*rowLength,wrapStr.length());
	    }*/
		int sign=0;//判断是否凑齐二个英文字符
		int count=0;//记录当前字符串的长度
		int start=0;//记录当前字符串截取的开始长度
		int end=0;//记录当前字符串截取的结束长度
		for(int i=0;i<wrapStr.length();i++)
		{
			if(wrapStr.substring(i, i+1).matches("[\u4e00-\u9fa5]"))
			{
				count++;
				end++;
		    }
			else
			{
		         sign++;
		         end++;
		         if(sign==2)
		         {
		        	 count++;
		        	 sign=0;
		         }
		    }
			if(count==rowLength)
			{
				result+=wrapStr.substring(start,end)+"<br/>";
				start=end;
				count=0;
				sign=0;
			}
			else if(end==wrapStr.length())
			{
				result+=wrapStr.substring(start,end);
				start=end;
				count=0;
				sign=0;
			}
		}
		return result;
	}
	public static String stringWrap(String wrapStr)
	{
		return stringWrap(wrapStr,wrapNumber);
	}
	/**
	 * 字符串截取
	 * */
	public static String stringIntercept(String interceptStr,int interNumber)
	{
		String result="";
		if(interceptStr==null||interceptStr.trim().equals(""))
		{
			return result;
		}
		if(interNumber<=0)
		{
			interNumber=subNumber;
		}
		if(interceptStr.length()<=interNumber){
			return interceptStr;
		}
		int sign=0;//判断是否凑齐二个英文字符
		int count=0;//记录当前字符串的长度
		int start=0;//记录当前字符串截取的开始长度
		int end=0;//记录当前字符串截取的结束长度
		for(int i=0;i<interceptStr.length();i++)
		{
			if(interceptStr.substring(i, i+1).matches("[\u4e00-\u9fa5]"))
			{
				count++;
				end++;
		    }
			else
			{
		         sign++;
		         end++;
		         if(sign==2)
		         {
		        	 count++;
		        	 sign=0;
		         }
		    }
			if(count==interNumber)
			{
				result=interceptStr.substring(start,end)+"...";
				return result;
			}
		}
		return interceptStr;
	}
	/**
	 * 字符串截取
	 * */
	public static String stringIntercept(String interceptStr,int interNumber,String replaceSign){
		String result="";
		if(interceptStr==null||interceptStr.trim().equals("")){
			return result;
		}
		if(interNumber<=0){
			interNumber=subNumber;
		}
		if(interceptStr.length()<=interNumber){
			return interceptStr;
		}
		int sign=0;//判断是否凑齐二个英文字符
		int count=0;//记录当前字符串的长度
		int start=0;//记录当前字符串截取的开始长度
		int end=0;//记录当前字符串截取的结束长度
		for(int i=0;i<interceptStr.length();i++){
			if(interceptStr.substring(i, i+1).matches("[\u4e00-\u9fa5]")){
				count++;
				end++;
		    }else{
		      //   sign++;
		         count++;
		         end++;
//		         if(sign==2){
//		        	 count++;
//		        	 sign=0;
//		         }
		    }
			if(count==interNumber){
				result=interceptStr.substring(start,end)+replaceSign;
				break;
			}
		}
		return result;
	}
	public static String stringIntercept(String interceptStr)
	{
		return stringIntercept(interceptStr,subNumber);
	}
	public static String stringInsertBR(String insertString,int insertNumber)
	{
		String result="";
		if(insertString==null)
		{
			return result;
		}
		if(insertNumber<0)
		{
			return insertString;
		}
		if(insertString.length()<=insertNumber)
		{
			return insertString;
		}
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug(insertString);
		}
		//拆分字符串
		String[] tempStrings=insertString.split("<br>");
		if(tempStrings!=null)
		{
			for(int i=0;i<tempStrings.length;i++)
			{
				if(tempStrings[i].length()>insertNumber)
				{
					tempStrings[i]=stringWrap(tempStrings[i],insertNumber);
				}
				if(!tempStrings[i].trim().equals(""))
				{
					result+=tempStrings[i]+"<br/>";
				}
			}
		}
		return result;
	}
	public static String removeBR(String str)
	{
		String result="";
		if(str==null)
		{
			return result;
		}
		String[] tempStrings=str.split("(<br>) | (<br/>)");
		for(int i=0;i<tempStrings.length;i++)
		{
			result+=tempStrings[i];
		}
		return result;
	}
	//解析一个字串是否是数字串
	public static Boolean isDigitalString(String content)
	{
		boolean isDigital=true;
		try {
		   Integer.parseInt(content);
		} catch (Exception e) {
			isDigital=false;
		}
		return isDigital;
	}
	/**
	 * 把一个yyyy.mm.dd hh:MM:ss的字符串转成整数
	 * @param timeString
	 * @return
	 */
	public static long timeToNumber(String timeString)
	{
		long result=-1l;
		if(timeString==null || timeString.equals(""))
		{
			return result;
		}
		String timeString2=timeString.replaceAll("\\.", "");
		timeString2=timeString2.replaceAll(" ","");
		timeString2=timeString2.replaceAll(":", "");
		try
		{
			result=Long.parseLong(timeString2);
		}
		catch (Exception e)
		{
			throw new OTMException("时间转换数字异常",e);
		}
		return result;
	}
	public static void main(String[] s)
	{
		System.out.println(StringOption.timeToNumber("2009.04.05 21:32:23"));
	}

	public static String removeZeroChar(String str){
		if(str==null) return null;
		else{
			return str.replace("\0", "");
		}
	}


	/**
	 * 使用<code>'/'</code>作为转义符，将like语句中的<code>'/'</code>、
	 * <code>'_'</code>、<code>'%'</code>、<code>'?'</code>、<code>'*'</code>转义成<code>'//'</code>、
	 * <code>'/_'</code>、<code>'/%'</code>、<code>'/?'</code>、<code>'/*'</code>
	 * <p>
	 * 例如搜索<code>'?aa*bb?c_d%f'</code>将转化成<code>'/?aa/*bb/?c/_d/%f'</code>。
	 * </p>
	 *
	 * @param likeStr the like str
	 * @return the string
	 */
    public static String escapeSQLLike(String likeStr) {
        String str = StringUtils.replace(likeStr, "/", "//");
        StringUtils.replace(likeStr, "_", "/_");
        str = StringUtils.replace(str, "%",    "/%");
        str = StringUtils.replace(str, "?", "/?");
        str = StringUtils.replace(str, "*", "/*");
        return str;
    }

}
