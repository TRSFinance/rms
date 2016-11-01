<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@include file="../../../common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

	<head>
		<meta charset="utf-8">
		<title>网站管理</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">

		<!-- The styles -->
		 <%@include file="../../../common/jscss.jsp" %>
		<!-- The fav icon -->
		<link rel="shortcut icon" href="img/favicon1.ico">

<style type="text/css">
	.breadcrumb button{ margin-right: 7px;}
</style>

<script type="text/javascript">

	$(document).ready(function(){
		$("#pageSize").val("${page.pageSize}");
		
		 var obj=$("#searchword");  
         obj.keyup(function(event){
         var  myEvent=event||window.event;
         var  keycode=myEvent.keyCode;		  
         if(keycode==13){
             query();
    	 } });
		
		
	});


function  query(){
    $("#pageNo").val(1);
	   $("#data").submit();
 }

	function  dels(obj){
	
		$("#delid").val(obj);
		$('#warnModal').modal('show');

    }

	 function  del(){
         $('#warnModal').modal('hide');
      	 var  delid=$("#delid").val();
      	 $.ajax({
   			url:'<%=ctx%>/admin/ruleTemplate/delete.do?random='+Math.random(),
   			type:"POST",
   			cache:false,
   			dataType:"json",
   			data:{'id':delid},
   			success:function(data){
   				if(data.success){
   					window.location.href="<%=ctx%>/admin/ruleTemplate/list.do";
   				}
   			},
   			error:function(){
   				alert("ssssss");
   			}
   		});
   	 }

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

					<div class="row">
	<div class="breadcrumb"><button class="btn-comlist">新建模板</button><button class="btn-comlist">上传模板</button><button class="btn-comlist">批量删除模板</button>
								</div>				
						<form action="<%=ctx %>/admin/ruleTemplate/v_list.do"  style="margin-left: 20px"  method="post"  id="data">
							<div class="col-md-6">
								<div class="dataTables_length">
									<label><select name="pageSize" class="" id="pageSize">
							        <option value="10">10</option>
									<option value="20">20</option>
									<option value="50">50</option>
									<option value="100">100</option></select>条每页</label>
								</div>
							</div>
								
								<div class="col-md-6">
									<div  class="dataTables_filter">
										<label>搜索:<input type="text" class="" id="searchword" name="username" value="${page.searchword }"><a href="#" onclick="query()"><i class="glyphicon glyphicon-search form_search" ></i></a></label>
									</div>
								</div>						
								<input  type="hidden"  name="pageNo"  value="1" id="pageNo"/>
							</form>
								
						<div class="box col-md-12">
							<div class="box-inner" id="com-list">
								
								<div class="box-content">
									<table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<thead>
											<!--  表头信息开始  -->
											<tr>
												<th><input type="checkbox" /></th>
												<th>序号</th>
												<th>模板名称</th>
												<th>分类字段</th>
												<th>最后修改时间</th>
												<th>同步状态</th>
												<th>最后同步时间</th>
												<th>操作</th>
											</tr>
											<!--  表头信息结束 -->
										</thead>
										<tbody>
										
										 <c:if test="${!empty data}"> 
										        <c:forEach items="${data}" var="ruleTempalate" varStatus="status">
											     	<tr>	
											     		<td><input type="checkbox" /></td>										 
												     	<td>${ status.index  + 1 + page.pageSize*(page.pageNo-1)} </td>
														<td>${ ruleTempalate.name}</td>
														<td>${ ruleTempalate.fieldName}</td>
														<td>${ ruleTempalate.lastModified}</td>
														<td>${ ruleTempalate.syncStatus}</td>
														<td>${ ruleTempalate.lastSyncTime}</td>														
														<td class="center font-right">
															<a class="btn btn-success btn-sm" href="<%=ctx%>/admin/ruleTemplate/view.do?id=${ ruleTempalate.id}" target="_blank">
																<i class="glyphicon glyphicon-zoom-in icon-white"></i>查看
															</a>
															<a class="btn btn-info btn-sm btn-setting" href="<%=ctx%>/admin/ruleTemplate/v_edit.do?id=${ruleTempalate.id}" target="_blank">
																<i class="glyphicon glyphicon-edit icon-white"></i>修改
															</a>
															<a class="btn btn-danger btn-sm btn-warn" onclick="dels(${ ruleTempalate.id})">
																<i class="glyphicon glyphicon-trash icon-white"></i>删除
															</a>
														</td>
										     		</tr>
										     	</c:forEach>
										     </c:if>   
										     
										     <c:if test="${empty data}"> 
										          <tr>
										          	<td colspan="8">没有相关数据！</td>
										          </tr>
										      </c:if>
											
											<!--  任务循环结束  -->	
											<!--  任务循环开始  -->
<!-- 											<tr> -->
<!-- 												<td><input type="checkbox" /></td> -->
<!-- 												<td>1</td> -->
<!-- 												<td>地区分类</td> -->
<!-- 												<td>XXX</td> -->
<!-- 												<td>2016.10.12 17:27:50</td> -->
<!-- 												<td>未配置</td> -->
<!-- 												<td>2016.10.12 17:27:50</td> -->
<!-- 												<td class="center font-right"> -->
<!-- 													<a class="btn btn-success btn-sm" href="#"> -->
<!-- 														<i class="glyphicon glyphicon-zoom-in icon-white"></i>查看 -->
<!-- 													</a> -->
<!-- 													<a class="btn btn-info btn-sm btn-setting" href="#"> -->
<!-- 														<i class="glyphicon glyphicon-edit icon-white"></i>修改 -->
<!-- 													</a> -->
<!-- 													<a class="btn btn-danger btn-sm btn-warn" href="#"> -->
<!-- 														<i class="glyphicon glyphicon-trash icon-white"></i>删除 -->
<!-- 													</a> -->
<!-- 												</td> -->
<!-- 											</tr> -->
											<!--  任务循环结束  -->	

										</tbody>
									</table>
					<hr>
				<page:page2 pageSize="${page.pageSize }" pageNo="${page.pageNo }" rowCount="${page.rowCount }" targetId="data" pageCount="${page.pageCount }"></page:page2>
								
									
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
		                <input  type="hidden"  id="delid"  value="">
		                    <p>你将要删除此用户？</p>
		                </div>
		                <div class="modal-footer">
		                    <a href="#" class="btn btn-default" data-dismiss="modal">关闭</a>
		                    <a href="#" class="btn btn-primary"  onclick="del()">确定</a>
		                </div>
		            </div>
		        </div>
		    </div>
		    <!-- 提示浮层结束-->    
		    
		    
		    
		    
		    
		    
			<%@include file="../../../common/foot.jsp" %>

		</div>
		<!--/.fluid-container-->


	</body>

</html>