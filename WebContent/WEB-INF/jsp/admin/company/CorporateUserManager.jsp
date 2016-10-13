<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../../common/taglib.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>企业名单管理</title>

		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">

		<!-- The styles -->
<!-- 		<link id="bs-css" href="/rms/css/bootstrap-cerulean.min.css" rel="stylesheet"> -->
<!-- 		<link href="/rms/css/app.css" rel="stylesheet"> -->
<!--         <link href='/rms/css/responsive-tables.css' rel='stylesheet'> -->
<!-- 		<!-- jQuery --> -->
<!-- 		<script src="/rms/js/jquery-1.11.3.min.js"></script> -->

		<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
	    <script src="js/html5shiv.min.js"></script>
	    <script src="js/respond.min.js"></script>
	    <![endif]-->

		<!-- The fav icon -->
		<link rel="shortcut icon" href="/rms/img/favicon1.ico">
		
		<%@include file="../../common/jscss.jsp" %>
		<script type="text/javascript">
	       $(document).ready(function () {
	         $("#pageSize").val("${page.pageSize}");	         
	       
	       });
       </script>
		
</head>
<body>
<!-- topbar starts -->
		<div class="navbar navbar-default" role="navigation">

			<div class="navbar-inner">
				<a class="navbar-brand" href=""> <!--<img alt="Charisma Logo" src="img/logo20.png" class="hidden-xs" />-->
					<span>风险管理系统</span></a>

				<!-- user dropdown starts -->
				<div class="btn-group pull-right">
					<button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
	                    <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"> root</span>
	                    <span class="caret"></span>
                    </button>
					<ul class="dropdown-menu">
						<li>
							<a href="#">用户</a>
						</li>
						<li class="divider"></li>
						<li>
							<a href="login.html">退出</a>
						</li>
					</ul>
				</div>
				<!-- user dropdown ends -->
				
			    <div class="navbar-nav " style="width: 60%; margin-left: 4%;">
					<div class=" row">
					    <div class="col-md-4 col-sm-4 hidden-xs">
					        <a class="well top-block" href="#">
					            <i class="glyphicon glyphicon-user blue"></i>					
					            <div>企业管理</div>
					        </a>
					    </div>
					
					    <div class="col-md-4 col-sm-4 hidden-xs">
					        <a class="well top-block" href="#">
					            <i class="glyphicon glyphicon-retweet green"></i>					
					            <div>数据推送</div>
					        </a>
					    </div>
					
					    <div class="col-md-4 col-sm-4 hidden-xs">
					        <a class="well top-block" href="#">
					            <i class="glyphicon glyphicon-cog yellow"></i>					
					            <div>系统管理</div>
					        </a>
					    </div>
	
					</div>
				</div>

			</div>
		</div>
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
		                            <a href="#"><i class="glyphicon glyphicon-list"></i><span>企业名单管理</span><i class="glyphicon glyphicon-chevron-down pull-right hidden-sm"></i></a>
		                            <ul class="nav nav-pills nav-stacked" id="companyList">
		                            
		                            <c:if test="${!empty data}"> 
										<c:forEach items="${data}" var="RmsCorporateUsers" varStatus="status">
		                            		<li><a href="#" class="ajax-link">${ RmsCorporateUsers.corporateName}</a></li>	
		                            	
		                            	</c:forEach>
		                            </c:if>
<!-- 		                                <li><a href="企业名单管理.html" class="ajax-link">东亚银行</a></li> -->
<!-- 		                                <li><a href="#" class="ajax-link">农业银行</a></li>	  -->
<script type="text/javascript">


// 	$(document).ready(function(){
// 		companyList();
		
// 		 companyInfoList();

// 	});
	//暂时没用上
	function companyList(){
		  $.ajax( {  
		       type : "GET",  
		        url : "/rms/admin/rmsCompanyInfo/list2.do",  
		        data : {}, 
		        dataType: "json",  
		        success : function(data) {  					
			       	for(var i=0;i<data.cool.length;i++){
			       		//alert("返回数据成功");
			       		
			       		$("#companyList").append("<li><a href='#' class='ajax-link'>"+data.cool[i].CustCfname+"</a></li>");
			       		 
			       		//alert(data.cool[i].CustCfname);                		
			       	}                    
		        },
		        error: function(err) {     
       			alert("oh my god");     
		        }  
		    });
	} 

	
	function companyInfoList(){
		  $.ajax( {  
		       type : "GET",  
		        url : "/rms/admin/rmsCompanyInfo/list2.do",  
		        data : {}, 
		        dataType: "json",  
		        success : function(data) {  					
			       	for(var i=0;i<data.cool.length;i++){
			       		//alert("返回数据成功");
			       		
			       		$("#liebiao").append("<tr><td>"+(i+2)+"</td>"+
			       		"<td>"+data.cool[i].CustCfname+"</td>"+
			       		"<td>"+data.cool[i].CustCsname+"</td>"+
			       		"<td>"+data.cool[i].CustIndustry1+"</td>"+
			       		"<td>"+data.cool[i].CustIndustry2+"</td>"+
			       		
			       		"<td class=\"center font-right\">"+
						"<a class=\"btn btn-success btn-sm\" href=\"#\">"+
							"<i class=\"glyphicon glyphicon-zoom-in icon-white\"></i>查看"+
						"</a> "+
						"<a class=\"btn btn-info btn-sm btn-setting\" href=\"#\">"+
							"<i class=\"glyphicon glyphicon-edit icon-white\"></i>修改"+
						"</a> "+
						"<a class=\"btn btn-danger btn-sm btn-warn\" href=\"#\">"+
							"<i class=\"glyphicon glyphicon-trash icon-white\"></i>删除"+
						"</a> "+
					"</td>"+
						"</tr>");
			       		//alert(data.cool[i].CustCfname);                		
			       	}                    
		        },
		        error: function(err) {     
     			alert("oh my god");     
		        }  
		    });
	} 


</script>		                                
		                                


		                                
		                            </ul>
		                        </li>
		                        <li class="accordion">
		                            <a href="#"><i class="glyphicon glyphicon-globe"></i><span>企业风险规则管理</span><i class="glyphicon glyphicon-chevron-down pull-right hidden-sm"></i></a>
		                            <ul class="nav nav-pills nav-stacked">
		                                <li><a href="#" class="ajax-link">行业风险体系</a></li>
		                                <li><a href="#" class="ajax-link">区域风险体系</a></li>
		                                <li><a href="#" class="ajax-link">金融市场体系</a></li>
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
					<form action="<%=ctx %>/admin/rmsCorporateUser/v_list.do"  style="margin-left: 20px"  method="post"  id="data">
					<div class="col-md-6">
						<div class="dataTables_length">
							<label><select name="pageSize" class="" id="pageSize">
							        <option value="10">10</option>
									<option value="20">20</option>
									<option value="50">50</option>
									<option value="100">100</option></select>条每页</label>
						</div>
					</div>
					<div class="col-md-6" >
						<div  class="dataTables_filter">
							<label>搜索:<input type="text" class="" name="username" value="${page.searchword }"></label>
						</div>
					</div>
					<input  type="hidden"  name="pageNo"  value="1" id="pageNo"/>
					
					</form>
					
					
						<div class="box col-md-12">
							<div class="box-inner" id="com-list">
								<div class="com-add"><button class="btn-comlist">新建企业用户</button></div>
								<div class="box-content">
									<table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<thead>
											<!--  表头信息开始  -->
											<tr>
												<th>序号</th>
												<th>企业用户名称</th>
												<th>企业用户说明</th>
												<th>联系电话</th>	
												<th>客户邮箱</th>																						
												<th>操作</th>
											</tr>
											<!--  表头信息结束 -->
										</thead>
										<tbody id="liebiao">
											<!--  任务循环开始  -->
											 <c:if test="${!empty data}"> 
										        <c:forEach items="${data}" var="RmsCorporateUsers" varStatus="status">
											     	<tr>
											     		<td style="display:none">${ RmsCorporateUsers.userId}</td>
												     	<td>${ status.index  + 1 + page.pageSize*(page.pageNo-1)} </td>
														<td>${ RmsCorporateUsers.corporateName}</td>
														<td>${ RmsCorporateUsers.corporateInf}</td>
														<td>${ RmsCorporateUsers.corporateTel}</td>
														<td>${ RmsCorporateUsers.corporateEmail}</td>
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
										     	</c:forEach>
										     </c:if>   
										     
										     <c:if test="${empty data}"> 
										            没有相关数据！
										      </c:if>
											
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
			                    <form action="/rms/admin/rmsCompanyInfo/filetodb.do" method="post" id="fileUpload"  enctype="multipart/form-data" target="_blank">
			                        <label class="control-label">任务名称</label>
			                        <input type="file" class="form-control" name="filetodb2">
			                    </form>
			                    </div>
			                </div>  
		                </div>
		                <div class="modal-footer">
		                    <a href="#" class="btn btn-default" data-dismiss="modal">关闭</a>
		                    <a href="#" class="btn btn-primary"  id="filetodb">导入</a>
		                </div>
		            </div>
		        </div>
		    </div>
		    <!-- 导入企业名单浮层结束-->
		    
		    <!-- 新增用户浮层开始-->
		    <div class="modal fade" id="setCompanyModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		         aria-hidden="true">
		
		        <div class="modal-dialog">
		            <div class="modal-content">
		                <div class="modal-header">
		                    <button type="button" class="close" data-dismiss="modal">×</button>
		                    <h3>企业设置</h3>
		                </div>
		                <div class="modal-body">
		                    <div class="form-inline">
			                    <div class="form-group">
			                        <label class="control-label">企业全称</label>
			                        <input type="text" class="form-control" id="param1">
			                    </div>
			                </div>
			                <div class="form-inline">
			                    <div class="form-group">
			                        <label class="control-label">企业简称</label>
			                        <input type="text" class="form-control" id="param2">
			                    </div>
			                </div>
			                <div class="form-inline">
			                    <div class="form-group">
			                        <label class="control-label">一级行业</label>
			                        <input type="text" class="form-control" id="param3">
			                    </div>
			                </div>
			                <div class="form-inline">
			                    <div class="form-group">
			                        <label class="control-label">二级行业</label>
			                        <input type="text" class="form-control" id="param4">
			                    </div>
			                </div>
				            
		                </div>
		                <div class="modal-footer">
		                    <a href="#" class="btn btn-default" data-dismiss="modal">关闭</a>
		                    <a href="#" class="btn btn-primary btn-save" id="updateCompanyInfo">保存</a>
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
		                    <a href="#" class="btn btn-primary" data-dismiss="modal" id="toDelete">确定</a>
		                </div>
		            </div>
		        </div>
		    </div>
		    <!-- 提示浮层结束-->
		    

		 <%@include file="../../common/foot.jsp" %>

		</div>


<script type="text/javascript">
	
	var cust_id = "";
	
	$("#toDelete").click(function(){
		
		//alert(cust_id);
		$.get("/rms/admin/rmsCompanyInfo/delete.do",{cust_id:cust_id},function(data, status){
			alert("删除成功");			
		});
	
	});
	
	$("#updateCompanyInfo").click(function(){
		
		//alert(cust_id);
		$.get("/rms/admin/rmsCompanyInfo/update.do",{cust_id:cust_id,param1:$("#param1").val(),param2:$("#param2").val(),param3:$("#param3").val(),param4:$("#param4").val()},function(data, status){
			alert("修改成功");	
			location.reload();
		});
	
	});
	
		
	$("#filetodb").click(function(){
		
		
		//alert($(".form-control").val());
		
// 		$.post("/rms/admin/rmsCompanyInfo/filetodb.do",{},function(data, status){
// 			alert(status);	
// 			//location.reload();
// 		});

		$("#fileUpload").submit();

	});
	
	
</script>



</body>
</html>