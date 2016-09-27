<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../common/taglib.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="../common/jscss.jsp" %>
<title>管理员</title>
</head>
<body>
hasgdjsajdlksajfkahdfjhafdjhakjfd
<div>${sessionScope.CAPTCHA_SESSION_KEY}_

<%=request.getAttribute("KAPTCHAMVC") %>

${KAPTCHAMVC }

<shiro:hasPermission name="admin:role:test1">
<a href="<%=ctx %>/admin/rmsRole/test.do">测试1</a>
</shiro:hasPermission>
<shiro:hasPermission name="admin:role:test2">
<a href="<%=ctx %>/admin/rmsRole/test2.do">测试2</a>
</shiro:hasPermission>
</div>

</body>
</html>