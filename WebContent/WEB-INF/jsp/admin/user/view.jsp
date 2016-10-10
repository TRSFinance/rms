   <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@include file="../../common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>查看用户信息</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
       <%@include file="../../common/jscss.jsp" %>
	</head>

	<body>
		<!-- topbar starts -->
		 <%@include file="../../common/head.jsp" %>
		<!-- topbar ends -->
		<div class="ch-container">
			<div class="row">
				<div class="box">
        <div class="box-inner">
            <div class="box-header well">
                <h2><i class="glyphicon glyphicon-eye-open"></i>用户信息详情</h2>

               
            </div>
            <div class="box-content">
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th width="40%">参数</th>
                        <th width="60%">值</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>
                            <span class="label-default label">登录名称</span>
                        </td>
                        <td>　${user.loginName }
                       
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span class="label-success label label-default">显示名称</span>
                        </td>
                        <td>　${user.nickName } </td>
                    </tr>
                    <tr>
                        <td>
                            <span class="label-warning label label-default">创建日期</span>
                        </td>
                        <td>${user.createTime }</td>
                    </tr>
                    <tr>
                        <td>
                            <span class="label-default label label-danger">修改日期</span>
                        </td>
                        <td>${user.updateTime }</td>
                    </tr>
                    <tr>
                        <td>
                            <span class="label-info label label-default">状　　态</span>
                        </td>
                        <td>
                        
                             <c:if test="${user.userState  eq 1 }">正常</c:if>
　　　　　　　　　　　　　　　　　　　<c:if test="${user.userState  eq 2 }">删除</c:if>
                             <c:if test="${user.userState  eq 3 }">停用</c:if>

                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
		                </div>
		   
		    <!-- 保存浮层结束-->
		   <%@include file="../../common/foot.jsp" %>


		</div>
		

	</body>

</html>
