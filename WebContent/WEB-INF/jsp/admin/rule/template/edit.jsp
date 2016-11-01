
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../../../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改规则模板信息</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<%@include file="../../../common/jscss.jsp"%>
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
	<%@include file="../../../common/head.jsp"%>
	<!-- topbar ends -->
	<div class="ch-container">
		<div class="row">
			<!-- left menu starts -->
			<%@include file="../../../common/left/sysconfigleft.jsp"%>
			<!--/span-->
			<!-- left menu ends -->
		<div id="content" class="col-lg-10 col-sm-10">
			<div class="row">
				<div class="box col-md-12">
					<div class="box-inner">
						<div class="box-header well">
							<h2>
								<i class="glyphicon glyphicon-eye-open"></i>修改规则模板信息
							</h2>


						</div>
						<div class="box-content">
							<form action="<%=ctx %>/admin/ruleTemplate/edit.do" method="post"
								id="_edituser">
								<div style="display: none">
									<input type="text" name="id" value="${ckmTemplate.id }">
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
											<td><span class="label-default label">模板名称</span></td>
											<td><input type="text"  name="name"
												value="${ckmTemplate.name }" class="form-control"
												datatype="s2-16" errormsg="模板名称至少2个字符,最多16个字符！"></td>
										</tr>
										<tr>
											<td><span class="label-default label">分类字段</span></td>
											<td><input type="text"  name="fieldName"
												value="${ckmTemplate.fieldName }" class="form-control"></td>
										</tr>

										<tr>
											<td><span class="label-success label label-default">最后修改时间</span>
											</td>
											<td>${ckmTemplate.lastModified}</td>
										</tr>

										<tr>
											<td><span class="label-default label">同步状态</span></td>
											<td><input type="text"  name="syncStatus"
												value="${ckmTemplate.syncStatus }" class="form-control"></td>
										</tr>
		
										<tr>
											<td><span class="label-success label label-default">最后同步时间</span>
											</td>
											<td>${ckmTemplate.lastSyncTime}</td>
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

		<%@include file="../../../common/foot.jsp"%>

	</div>


</body>

</html>