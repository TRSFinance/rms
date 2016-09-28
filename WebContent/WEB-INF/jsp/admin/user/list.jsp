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
       <script type="text/javascript">
       $(document).ready(function () {
       $(".datatable").dataTable({
              "sDom": "<'row'<'col-md-6'l><'col-md-6'f>r>t<'row'<'col-md-12'i><'col-md-12 center-block'p>>",
    	      "oLanguage" : { // 汉化
    	        "sProcessing" : "正在加载数据...",
    	        "sLengthMenu" : "显示_MENU_条 ",
    	        "sZeroRecords" : "没有您要搜索的内容",
    	        "sInfo" : "从_START_ 到 _END_ 条记录——总记录数为 _TOTAL_ 条",
    	        "sInfoEmpty" : "记录数为0",
    	        "sInfoFiltered" : "(全部记录数 _MAX_  条)",
    	        "sInfoPostFix" : "",
    	        "sSearch" : "搜索",
    	        "sUrl" : "",
    	        "oPaginate" : {
    	          "sFirst" : "第一页",
    	          "sPrevious" : " 上一页 ",
    	          "sNext" : " 下一页 ",
    	          "sLast" : " 最后一页 "
    	        }
    	      },
    	      "bJQueryUI": true,
    	      "bPaginate" : true,// 分页按钮
    	      "bFilter" : true,// 搜索栏
    	      "bLengthChange" : false,// 每行显示记录数
    	      "iDisplayLength" : 20,// 每页显示行数
    	      "bSort" : false,// 排序
    	      //"aLengthMenu": [[50,100,500,1000,10000], [50,100,500,1000,10000]],//定义每页显示数据数量
    	      //"iScrollLoadGap":400,//用于指定当DataTable设置为滚动时，最多可以一屏显示多少条数据
    	      //"aaSorting": [[4, "desc"]],
    	      "bInfo" : true,// Showing 1 to 10 of 23 entries 总记录数没也显示多少等信息
    	      "bWidth":true,
    	     
    	     "bScrollCollapse": true,
    	      "sPaginationType" : "bootstrap", // 分页，一共两种样式 另一种为two_button // 是datatables默认
    	      "bProcessing" : true,
    	      "bServerSide" : true,
    	      "bDestroy": true,
    	      "bSortCellsTop": true,	
    	      "sAjaxSource": '<%=ctx%>/admin/rmsUser/o_ajax_list.do', 
    	      "sServerMethod": "POST",  
    	      "aoColumns": [  
    	                   { "mDataProp": "rmsUser.loginName"},  
    	                   { "mDataProp": "rmsUser.nickName"},  
    	                    { "mDataProp": "rmsUser.userState"},  
    	                   { "mDataProp": "rmsUser.createTime"},  
    	                   { "mDataProp": "rmsUser.updateTime"}]
    	       
    	    });
       
       });
       </script>
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
									<table class="table table-striped table-bordered  datatable ">
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
		            <p style="text-align: center;"><img src="<%=ctx %>/style/img/loading.gif" /></p>
		        </div>
		    </div>
		    <!-- 保存浮层结束-->
		   <%@include file="../../common/foot.jsp" %>


		</div>
		

	</body>

</html>
