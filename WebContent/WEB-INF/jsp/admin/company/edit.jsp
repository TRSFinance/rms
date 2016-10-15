
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改企业用户信息</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<%@include file="../../common/jscss.jsp"%>
<script
	src="<%=request.getContextPath() %>/plug/Validform/Validform_v5.2.1_min.js"></script>
<script type="text/javascript">
       
       $(document).ready(function () {
           $("#_edituser").Validform();
           $("#userState").val("${user.userState}")
         });
       
       function winback() {
    	   history.go(-1);	}
       </script>
</head>

<body>

	<!-- topbar starts -->
	<%@include file="../../common/head.jsp"%>
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
							<h2>
								<i class="glyphicon glyphicon-eye-open"></i>修改企业用户信息
							</h2>


						</div>
						<div class="box-content">
							<form action="<%=ctx %>/admin/rmsCorporateUser/edit.do" method="post"
								id="_edituser">
								<div style="display: none">
									<input type="text" name="id" value="${corporateUser.userId }">
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
											<td><span class="label-default label">企业用户名称</span></td>
											<td><input type="text"  name="corporateName"
												value="${corporateUser.corporateName }" class="form-control"
												datatype="s2-16" errormsg="登录名称至少2个字符,最多16个字符！"></td>
										</tr>
										<tr>
											<td><span class="label-success label label-default">联系电话</span>
											</td>
											<td><input type="text"  name="corporateTel"
												value="${corporateUser.corporateTel }" class="form-control"
												datatype="s2-16" errormsg="请输入正确的联系电话！"></td>
										</tr>
										<tr>
											<td><span class="label-warning label label-default">手
													机</span></td>
											<td><input type="text" name="corporateMobile"
												value="${corporateUser.corporateMobile }" class="form-control" datatype="m"
												errormsg="请输入正确的手机号！" ignore="ignore"></td>
										</tr>
										<tr>
											<td><span class="label-default label label-danger">邮
													箱</span></td>
											<td><input type="text" name="corporateEmail"
												value="${corporateUser.corporateEmail }" class="form-control" datatype="e"
												errormsg="请输入正确的邮箱地址！" ignore="ignore"></td>
										</tr>
										<tr>
											<td><span class="label-success label label-default">企业客户说明</span>
											</td>
											<td><input type="text" name="corporateInf"
												value="${corporateUser.corporateInf }" class="form-control"
												datatype="s2-16" errormsg="登录名称至少2个字符,最多16个字符！"></td>
										</tr>
										
										<tr>
											<td><span class="label-success label label-default">用户状态</span>
											</td>
											<td>
												<select  name="userState" >
												
													<c:choose>
														<c:when test="${corporateUser.rmsUser.userState==1 }">
															<option value="1" selected="selected">正常</option>
														</c:when>
														<c:otherwise>
															<option value="1">正常</option>
														</c:otherwise>
													</c:choose>
													<c:choose>
														<c:when test="${corporateUser.rmsUser.userState==2 }">
															<option value="2" selected="selected">删除</option>
														</c:when>
														<c:otherwise>
															<option value="2">删除</option>
														</c:otherwise>
													</c:choose>		
													<c:choose>
														<c:when test="${corporateUser.rmsUser.userState==3 }">
															<option value="3" selected="selected">停用</option>
														</c:when>
														<c:otherwise>
															<option value="3">停用</option>
														</c:otherwise>
													</c:choose>												    	
					
						                       	</select>
											</td>
										</tr>
										
		
										
										
										
										<tr>
											<td><span class="label-success label label-default">创建时间</span>
											</td>
											<td>${corporateUser.createTime}</td>
										</tr>
										<tr>
											<td><span class="label-success label label-default">修改时间</span>
											</td>
											<td>${corporateUser.updateTime}</td>
										</tr>
										<tr>
											<td colspan="2" class="td-center">
											
											<input type="button"
												class="btn btn-primary " value="返回" onclick="winback()">									
							
											<input type="submit"
												class="btn btn-primary " value="保存"></td>
										</tr>
									</tbody>
								</table>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		<hr>

		<%@include file="../../common/foot.jsp"%>

	</div>


</body>

</html>