   <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@include file="../../common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>修改用户信息</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
       <%@include file="../../common/jscss.jsp" %>
       <script src="<%=request.getContextPath() %>/plug/Validform/Validform_v5.2.1_min.js"></script>
       <script type="text/javascript">
       
       $(document).ready(function () {
           $("#_edituser").Validform();
           $("#userState").val("${user.userState}")
         });
       </script>
	</head>

	<body>
	
		<!-- topbar starts -->
		<!-- topbar ends -->
		<div class="ch-container">
			<div class="row">
				<div class="box">
        <div class="box-inner">
            <div class="box-header well">
                <h2><i class="glyphicon glyphicon-eye-open"></i>修改用户信息</h2>

               
            </div>
            <div class="box-content">
            <form action="<%=ctx %>/admin/rmsUser/edit.do"   method="post" id="_edituser">
                <div  style="display: none">
                 <input type="text" name="id"  value="${user.userId }">  
                </div>
                
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
                        <td>　${user.loginName }</td>
                    </tr>
                    <tr>
                        <td>
                            <span class="label-success label label-default">显示名称</span>
                        </td>
                        <td>　
           <input type="text"  id="nickname" name="username" value="${user.nickName } " class="form-control" datatype="s2-16" errormsg="登录名称至少2个字符,最多16个字符！">
                        
                        
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span class="label-warning label label-default">手　　机</span>
                        </td>
      <td>　
           <input type="text"  name="moblie" value="${user.mobile } " class="form-control" datatype="m" errormsg="请输入正确的手机号！" ignore="ignore">
                        
                        
                        
                        </td>                    </tr>
                    <tr>
                        <td>
                            <span class="label-default label label-danger">邮　　箱</span>
                        </td>
                         <td>　
           <input type="text"  name="email" value="${user.email } " class="form-control" datatype="e" errormsg="请输入正确的邮箱地址！" ignore="ignore">

                        </td> </tr>
                    <tr>
                        <td>
                            <span class="label-info label label-default">状　　态</span>
                        </td>
                        <td>
                        <select  name="userState"  id="userState">
	                        <option value="1">正常</option>
	                        <option value="2">删除</option>
	                        <option value="3">停用</option>
                        </select>
                        
                        

                        </td>
                    </tr>
                    <tr><td  colspan="2">
                    
                    	<input  type="submit"  class="btn btn-primary "   value="保存">
                    
                    
                    </td></tr>
                    </tbody>
                </table>
                </form>
            </div>
        </div>
    </div>
		                </div>
		   
		    <!-- 保存浮层结束-->
		</div>
		

	</body>

</html>