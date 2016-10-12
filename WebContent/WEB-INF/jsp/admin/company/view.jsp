   <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@include file="../../common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>企业用户详情</title>
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
			<!-- left menu starts -->
			<%@include file="../../common/left/sysconfigleft.jsp"%>
			<!--/span-->
			<!-- left menu ends -->
					<div id="content" class="col-lg-10 col-sm-10">
			<div class="row">
				<div class="box col-md-12">
        <div class="box-inner">
            <div class="box-header well">
                <h2><i class="glyphicon glyphicon-eye-open"></i>企业用户详情</h2>

               
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
                            <span class="label-default label">企业用户名称</span>
                        </td>
                        <td>　${corporateUser.corporateName }
                       
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span class="label-success label label-default">联系电话</span>
                        </td>
                        <td>　${corporateUser.corporateTel } </td>
                    </tr>
                    <tr>
                        <td>
                            <span class="label-warning label label-default">手机</span>
                        </td>
                        <td>${corporateUser.corporateMobile }</td>
                    </tr>
                    <tr>
                        <td>
                            <span class="label-warning label label-default">邮箱</span>
                        </td>
                        <td>${corporateUser.corporateEmail }</td>
                    </tr>
                    <tr>
                        <td>
                            <span class="label-warning label label-default">说明</span>
                        </td>
                        <td>${corporateUser.corporateInf }</td>
                    </tr>
                     <tr>
                        <td>
                            <span class="label-default label label-danger">创建日期</span>
                        </td>
                        <td>${corporateUser.createTime }</td>
                    </tr>
                    <tr>
                        <td>
                            <span class="label-default label label-danger">修改日期</span>
                        </td>
                        <td>${corporateUser.updateTime }</td>
                    </tr>
                    
                    
					<tr> 
					<td  colspan="2" class="td-center">
	
						<input type="button"
							class="btn btn-primary " value="关闭" onclick="closeWin()"></td>										
					</tr>
                    
                    </tbody>
                </table>
            </div>
        </div>
    </div>
	</div></div></div>
		  		<hr>
		   
		    <!-- 保存浮层结束-->
		   <%@include file="../../common/foot.jsp" %>


		</div>
		

	</body>

</html>
