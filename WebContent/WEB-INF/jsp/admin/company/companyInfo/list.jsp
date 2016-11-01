   <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@include file="../../../common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>企业名单管理</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
       <%@include file="../../../common/jscss.jsp" %>
       	<script src="<%=request.getContextPath() %>/plug/Validform/Validform_v5.2.1_min.js"></script>
       
		<script type="text/javascript">
	       $(document).ready(function () {
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
	       
       </script>
		
</head>
<body>
<!-- topbar starts -->
		 <%@include file="../../../common/head.jsp" %>
		<!-- topbar ends -->
		<div class="ch-container">
			<div class="row">
 			<%@include file="../../../common/left/companyconfigleft.jsp" %>
				<div id="content" class="col-lg-10 col-sm-10">
					<!-- content starts -->
					<div>
						<div class="breadcrumb">
						<button class="btn btn-info btn-sm btn-adduser"> <i class="glyphicon glyphicon-plus-sign icon-white"></i>导入企业名单</button>												
						</div>						
					</div>
					<div class="row">					
					<form action="<%=ctx %>/admin/rmsCompanyInfo/v_list.do"  style="margin-left: 20px"  method="get"  id="data">
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
							<label>搜索:<input type="text" class="" id="searchword" name="username" value="${page.searchword }"><a href="#" onclick="query()"><i class="glyphicon glyphicon-search form_search" ></i></a></label>
						</div>
					</div>
					<input  type="hidden"  name="pageNo"  value="1" id="pageNo"/>
					
					</form>
					
					
						<div class="box col-md-12">
							<div class="box-inner" id="com-list">
								<div class="box-content  right-div">
									<table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<thead>
											<!--  表头信息开始  -->
											<tr>
												<th>序号</th>
												<th>公司名称</th>
												<th>公司简称</th>
												<th>英文全称</th>
												<th>英文简称</th>
												<th>操作</th>
											</tr>
											<!--  表头信息结束 -->
										</thead>
										<tbody id="liebiao">
											<!--  任务循环开始  -->
											 <c:if test="${!empty data}"> 
										        <c:forEach items="${data}" var="RmsCompanys" varStatus="status">
											     	<tr>
											     		<td style="display:none">${ RmsCompanys.companyInfo.custId}</td>
												     	<td>${ status.index  + 1 + page.pageSize*(page.pageNo-1)} </td>
														<td>${ RmsCompanys.companyInfo.custCfname}</td>
														<td>${ RmsCompanys.companyInfo.custCsname}</td>
														<td>${ RmsCompanys.companyInfo.custEfname}</td>
														<td>${ RmsCompanys.companyInfo.custEsname}</td>
														<td class="center font-right">
															<a class="btn btn-success btn-sm" href="<%=ctx%>/admin/rmsCompanyInfo/view.do?id=${ RmsCompanys.companyInfo.custId}" target="_blank">
																<i class="glyphicon glyphicon-zoom-in icon-white"></i>查看
															</a>
															<a class="btn btn-info btn-sm btn-setting" href="<%=ctx%>/admin/rmsCompanyInfo/v_edit.do?id=${ RmsCompanys.companyInfo.custId}" target="_blank">
																<i class="glyphicon glyphicon-edit icon-white"></i>修改
															</a>
															<a class="btn btn-danger btn-sm btn-warn" onclick="dels(${ RmsCompanys.companyInfo.custId})">
																<i class="glyphicon glyphicon-trash icon-white"></i>删除
															</a>
														</td>
										     		</tr>
										     	</c:forEach>
										     </c:if>   
										     
										     <c:if test="${empty data}"> 
										      	 <tr>
												      <td colspan="6">
												                   没有查到相关数据！
												      </td>
										     	 </tr>
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
			                    <form action="/rms/admin/rmsCompanyInfo/upload.do" method="post" id="uploadFile"  enctype="multipart/form-data" target="_blank">
			                        <label class="control-label">任务名称</label>
			                        <input type="file" class="form-control" name="theFile" accept="application/vnd.ms-excel">
			                    </form>
			                    </div>
			                </div>  
		                </div>
		                <div class="modal-footer">
		                    <a href="#" class="btn btn-default" data-dismiss="modal">关闭</a>
		                    <a href="#" class="btn btn-primary"  id="insertFile">导入</a>
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
		                    <a href="#" class="btn btn-primary" data-dismiss="modal" id="toDelete">确定</a>
		                </div>
		            </div>
		        </div>
		    </div>
		    <!-- 提示浮层结束-->

		 <%@include file="../../../common/foot.jsp" %>

		</div>

<script type="text/javascript">
				
	$('.breadcrumb').click(function (e) {
	   e.preventDefault();
	   $('#comModal').modal('show');
	});

	$("#insertFile").click(function(){
		$('#comModal').modal('hide');
		location.reload();
		$("#uploadFile").submit();
	});
	
	$("#toDelete").click(function(){		
		$('#warnModal').modal('hide');
      	var  delid=$("#delid").val();
		$.get("/rms/admin/rmsCompanyInfo/delete.do",{custId:delid},function(data, status){
			location.reload();
		});	
	});
	
 	function  dels(obj){  	
       $("#delid").val(obj);
       $('#warnModal').modal('show');
    }

</script>

</body>
</html>