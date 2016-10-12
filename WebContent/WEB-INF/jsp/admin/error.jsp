<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>自定义的错误页</title>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />  
</head>  
<body marginwidth="0" leftmargin="0" bgcolor="ffffff">  
<table width="90%">  
  <tbody>  
    <tr>  
      <td width="98%">  
      这是自定义的错误页  
      <hr>      </td>  
    </tr>  
   
    <tr>  
      <td>  
      <% Enumeration<String> ls=request.getAttributeNames();
         Exception  e=(Exception)request.getAttribute("exception");
	     String message=e.getMessage();
      %>
       <%=message %>
    </TD>  
    </TR>  
      
  </TBODY>  
</TABLE>  
</body>  
</html> 