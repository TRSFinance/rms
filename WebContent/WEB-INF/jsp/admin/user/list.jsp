   <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@include file="../../common/taglib.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>系统管理</title>
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
					<%@include file="../../common/left/sysconfigleft.jsp" %>
				<!--/span-->
				<!-- left menu ends -->
				<div id="content" class="col-lg-10 col-sm-10">
					<!-- content starts -->
					<div>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner" id="com-list">
								<div class="com-add"><button class="btn btn-info btn-sm btn-adduser"> <i class="glyphicon glyphicon-plus-sign icon-white"></i>新增用户</button></div>
								<div class="box-content">
									<table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<thead>
											<!--  表头信息开始  -->
											<tr>
												<th>序号</th>
												<th>用户名称</th>
												<th>状态</th>
												<th>开通时间</th>
												<th>操作</th>
											</tr>
											<!--  表头信息结束 -->
										</thead>
										<tbody>
											<!--  任务循环开始  -->
											<tr>
												<td>1</td>
												<td>用户1</td>
												<td>激活</td>
												<td>2016</td>
												<td class="center font-right">
													<a class="btn btn-success btn-sm" href="#">
														<i class="glyphicon glyphicon-zoom-in icon-white"></i>查看
													</a>
													<a class="btn btn-info btn-sm btn-adduser" href="#">
														<i class="glyphicon glyphicon-edit icon-white"></i>修改
													</a>
													<a class="btn btn-danger btn-sm btn-warn" href="#">
														<i class="glyphicon glyphicon-trash icon-white"></i>删除
													</a>
												</td>
											</tr>
											<!--  任务循环结束  -->
											
											

										</tbody>
									</table>
								
									
								</div>
							</div>
						</div>
						<!--/span-->

					</div>
					<!--/row-->

					<!-- content ends -->
				</div>
				<!--/#content.col-md-0-->
			</div>
			<!--/fluid-row-->

			<hr>

			<!-- 新增用户浮层开始-->
		    <div class="modal fade" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		         aria-hidden="true">
		
		        <div class="modal-dialog">
		            <div class="modal-content">
		                <div class="modal-header">
		                    <button type="button" class="close" data-dismiss="modal">×</button>
		                    <h3>用户设置</h3>
		                </div>
		                <div class="modal-body">
		                    <div class="form-inline">
			                    <div class="form-group">
			                        <label class="control-label">用户名</label>
			                        <input type="text" class="form-control">
			                    </div>
			                </div>
			                <div class="form-inline">
			                    <div class="form-group">
			                        <label class="control-label">密码</label>
			                        <input type="text" class="form-control">
			                    </div>
			                </div>
			                <div class="form-inline">
			                    <div class="form-group">
			                        <label class="control-label">昵称</label>
			                        <input type="text" class="form-control">
			                    </div>
			                </div>
			                <div class="form-inline">
			                    <div class="form-group">
			                        <label class="control-label">邮箱</label>
			                        <input type="text" class="form-control">
			                    </div>
			                </div>
				            
		                </div>
		                <div class="modal-footer">
		                    <a href="#" class="btn btn-default" data-dismiss="modal">关闭</a>
		                    <a href="#" class="btn btn-primary btn-save">保存</a>
		                </div>
		            </div>
		        </div>
		    </div>
		    <!-- 新增用户浮层结束-->
		    
		    <!-- 提示浮层开始-->
			<div class="modal fade" id="warnModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		         aria-hidden="true">
		
		        <div class="modal-dialog">
		            <div class="modal-content">
		                <div class="modal-header">
		                    <button type="button" class="close" data-dismiss="modal">×</button>
		                    <h3>提示信息</h3>
		                </div>
		                <div class="modal-body">
		                    <p>你将要删除此用户？</p>
		                </div>
		                <div class="modal-footer">
		                    <a href="#" class="btn btn-default" data-dismiss="modal">关闭</a>
		                    <a href="#" class="btn btn-primary" data-dismiss="modal">确定</a>
		                </div>
		            </div>
		        </div>
		    </div>
		    <!-- 提示浮层结束-->
		    
		    <!-- 保存浮层开始-->
			<div class="modal fade" id="saveModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		         aria-hidden="true" style="z-index: 9999;">		         
		        <div class="modal-dialog" style="z-index: 9999;">
		            <p style="text-align: center;"><img src="img/loading.gif" /></p>
		        </div>
		    </div>
		    <!-- 保存浮层结束-->
		   <%@include file="../../common/foot.jsp" %>


		</div>
		

	</body>

</html>
