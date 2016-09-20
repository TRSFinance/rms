<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%	
	response.setHeader("Pragma","No-Cache");
	response.setHeader("Cache-Control","No-Cache");
	response.setDateHeader("Expires", 0);
	String ctx=request.getContextPath();
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<script type="text/javascript">

</script>
</head>
<body>
<img alt="你大爷" src="<%=ctx%>/kaptcha/kaptchalogin.jpg">
<c:if test="${!success}">
   ${msg}
</c:if>
<form action="<%=ctx%>/admin/login.do"  method="post">
用户名：<input name="username"  value="admin" type="text">
密码：<input name="password" value="trsadmin" type="password">
<input type="submit"  value="提交">
</form>

<div>
<img alt="他大爷" src="<%=ctx%>/admin/login.jpg">


</div>
<div>${sessionScope.SPRING_MVC_KAPTCHA}_${sessionScope.CAPTCHA_SESSION_KEY}</div>
</body>
</html>