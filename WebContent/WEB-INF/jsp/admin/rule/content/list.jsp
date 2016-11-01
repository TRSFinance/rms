<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@include file="../../../common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<style type="text/css">


</style>

	<head>
		<meta charset="utf-8">
		<title>规则分类维护</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">

		<!-- The styles -->
		 <%@include file="../../../common/jscss.jsp" %>
		<link href="<%=request.getContextPath()%>/style/css/zTreeStyle.css" rel="stylesheet">
		<!-- The fav icon -->
		<link rel="shortcut icon" href="img/favicon1.ico">
		<!-- The js -->
		<script src="<%=request.getContextPath()%>/style/js/jquery.ztree.core.min.js"></script>
		<script type="text/javascript">
		var setting = {	};

		var zNodes =[
			{ name:"中国", open:true,
				children: [
					{ name:"江西",
						children: [
							{ name:"赣州"},
							{ name:"南昌"}
						]},
					{ name:"福建",
						children: [
							{ name:"福州"},
							{ name:"厦门"},
						]},
					{ name:"香港", isParent:true}
				]},
			{ name:"美国",
				children: [
					{ name:"纽约", open:true,
						children: [
							{ name:"纽约1"},
							{ name:"纽约2"}
						]},
					{ name:"华盛顿",
						children: [
							{ name:"华盛顿1"},
							{ name:"华盛顿2"},
							{ name:"叶子节点223"},
							{ name:"叶子节点224"}
						]},
					{ name:"夏威夷",
						children: [
							{ name:"夏威夷1"},
							{ name:"夏威夷2"}
						]}
				]}

		];

		$(document).ready(function(){
			$.fn.zTree.init($("#tree"), setting, zNodes);
		});
	</script>
	</head>

	<body>
		<!-- topbar starts -->
		<%@include file="../../../common/head.jsp" %>
		<!-- topbar ends -->
		<div class="ch-container">
			<div class="row">

				<!-- left menu starts -->
				<div class="col-sm-2 col-lg-2">
					<div class="sidebar-nav">
						<div class="nav-canvas">
							<div class="nav-sm nav nav-stacked">

							</div>
							<ul class="nav nav-pills nav-stacked main-menu">
		                        <li class="accordion">
		                            <a href="#"><i class="glyphicon glyphicon-list"></i><span>网站管理</span><i class="glyphicon glyphicon-chevron-down pull-right hidden-sm"></i></a>
		                            <ul class="nav nav-pills nav-stacked">
		                                <li><a href="企业名单管理.html" class="ajax-link">规则分类维护</a></li>
		                            </ul>
		                        </li>							
							</ul>
							<label id="for-is-ajax" for="is-ajax" class="hidden"><input id="is-ajax" type="checkbox" checked=""></label>
						</div>
					</div>
				</div>
				<!--/span-->
				<!-- left menu ends -->
				<div id="content" class="col-lg-10 col-sm-10">
					<!-- content starts -->
					<div>
					</div>
<div class="com-add"><button class="btn-comlist">添加同级类</button><button class="btn-comlist">添加子类</button><button class="btn-comlist">修改分类名称</button><button>删除分类</button><button>添加规则</button><button>批量删除规则</button><button>返回模板列表</button></div>
					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner" id="com-list">
<!-- 								<div class="com-add"><button class="btn-comlist">添加同级类</button><button class="btn-comlist">添加子类</button><button class="btn-comlist">修改分类名称</button><button>删除分类</button><button>添加规则</button><button>批量删除规则</button><button>返回模板列表</button></div> -->
								<div class="box-content" >
									<div class="col-md-3"  >
										<ul id="tree" class="ztree"></ul>
									</div>
									<div class="col-md-9 rule_con"  style="margin-top:35px">
										<table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
											<thead>
												<!--  表头信息开始  -->
												<tr>
													<th><input type="checkbox" /></th>
													<th>序号</th>
													<th>规则</th>
													<th>操作</th>
												</tr>
												<!--  表头信息结束 -->
											</thead>
											<tbody>
												<!--  任务循环开始  -->
												<tr>
													<td><input type="checkbox" /></td>
													<td>1</td>
													<td>地区分类</td>
													<td class="center font-right">
														<a class="btn btn-success btn-sm" href="#">
															<i class="glyphicon glyphicon-zoom-in icon-white"></i>查看
														</a>
														<a class="btn btn-info btn-sm btn-setting" href="#">
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
			
			<!-- 导入企业名单浮层开始-->
		    <div class="modal fade" id="comModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		         aria-hidden="true">
		
		        <div class="modal-dialog">
		            <div class="modal-content">
		                <div class="modal-body">
			                <div class="form-inline">
			                    <div class="form-group">
			                        <label class="control-label">任务名称</label>
			                        <input type="file" class="form-control">
			                    </div>
			                </div>  
		                </div>
		                <div class="modal-footer">
		                    <a href="#" class="btn btn-default" data-dismiss="modal">关闭</a>
		                    <a href="#" class="btn btn-primary">导入</a>
		                </div>
		            </div>
		        </div>
		    </div>
		    <!-- 导入企业名单浮层结束-->
		    

			<%@include file="../../../common/foot.jsp" %>
			

		</div>
		<!--/.fluid-container-->

	</body>

</html>