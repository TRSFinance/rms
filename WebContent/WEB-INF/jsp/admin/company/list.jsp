   <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@include file="../../common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>企业用户管理</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
       <%@include file="../../common/jscss.jsp" %>
       	<script src="<%=request.getContextPath() %>/plug/Validform/Validform_v5.2.1_min.js"></script>
       
      <script type="text/javascript">
       $(document).ready(function () {
         $("#pageSize").val("${page.pageSize}");
         $("#_adduser").Validform();
         
         var obj=$("#searchword");  
         obj.keyup(function(event){
         var  myEvent=event||window.event;
         var  keycode=myEvent.keyCode;		  
         if(keycode==13){
             query();
    	 } });
         
       });
       function save() {
    	   var  userName=$("#username").val();
    	   var  corporateUserName=$("#corporateUserName").val();
    	   $.ajax({
   			url:'<%=ctx%>/admin/rmsCorporateUser/a_username.do?random='+Math.random(),
   			type:"POST",
   			cache:false,
   			dataType:"json",
   			data:{'username':userName,'corporateUserName':corporateUserName},
   			success:function(data){  				
   				if(data.exist){
   					alert("已存在该登录名称或企业名称！");
   				}else{   					
    		    	$("#_adduser").submit();
   				}
   			},
   			error:function(){
   			}
   		});   
    	   
	}
       function  dels(obj){
    	
       $("#delid").val(obj);
        $('#warnModal').modal('show');

       }
        function  del(){
          $('#warnModal').modal('hide');
       	 var  delid=$("#delid").val();
       	 $.ajax({
    			url:'<%=ctx%>/admin/rmsCorporateUser/delete.do?random='+Math.random(),
    			type:"POST",
    			cache:false,
    			dataType:"json",
    			data:{'userId':delid},
    			success:function(data){
    				if(data.success){
    					window.location.href="<%=ctx%>/admin/rmsCorporateUser/list.do";
    				}
    			},
    			error:function(){
    			}
    		});
    	 }
       
        function  query(){
           $("#pageNo").val(1);
       	   $("#data").submit();
	    }
       
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
					<div class="breadcrumb">
					<button class="btn btn-info btn-sm btn-adduser"> <i class="glyphicon glyphicon-plus-sign icon-white"></i>添加企业用户</button>
<!-- 					<div class="com-add"><button class="btn-comlist">新建企业用户</button></div>					 -->
					</div>
					
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
												<th>序号</th>
												<th>企业用户名称</th>
												<th>企业用户说明</th>
												<th>联系电话</th>	
												<th>用户状态</th>																						
												<th>操作</th>
											</tr>
											<!--  表头信息结束 -->
										</thead>
										<tbody id="liebiao">
											<!--  任务循环开始  -->
											 <c:if test="${!empty data}"> 
										        <c:forEach items="${data}" var="RmsCorporateUsers" varStatus="status">
											     	<tr>											 
												     	<td>${ status.index  + 1 + page.pageSize*(page.pageNo-1)} </td>
														<td>${ RmsCorporateUsers.corporateName}</td>
														<td>${ RmsCorporateUsers.corporateInf}</td>
														<td>${ RmsCorporateUsers.corporateTel}</td>
														<td>
															<c:if test="${ RmsCorporateUsers.rmsUser.userState==1}">正常</c:if>
															<c:if test="${ RmsCorporateUsers.rmsUser.userState==2}">删除</c:if>
															<c:if test="${ RmsCorporateUsers.rmsUser.userState==3}">停用</c:if>
														<td>
														<td class="center font-right">
															<a class="btn btn-success btn-sm" href="<%=ctx%>/admin/rmsCorporateUser/view.do?id=${ RmsCorporateUsers.userId}" target="_blank">
																<i class="glyphicon glyphicon-zoom-in icon-white"></i>查看
															</a>
															<a class="btn btn-info btn-sm btn-setting" href="<%=ctx%>/admin/rmsCorporateUser/v_edit.do?id=${ RmsCorporateUsers.userId}" target="_blank">
																<i class="glyphicon glyphicon-edit icon-white"></i>修改
															</a>
															<a class="btn btn-danger btn-sm btn-warn" onclick="dels(${ RmsCorporateUsers.userId})">
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
						<!--/span-->

					</div>
					<!--/row-->

					<!-- content ends -->
				</div>
				<!--/#content.col-md-0-->
			</div>
			<!--/fluid-row-->
		
		<hr>

			<!-- 新增企业用户浮层开始-->
		    <div class="modal fade" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		         aria-hidden="true">
		      
		        <div class="modal-dialog">
		            <div class="modal-content">
		                <div class="modal-header">
		                    <button type="button" class="close" data-dismiss="modal">×</button>
		                    <h3>添加企业用户</h3>
		                </div>
		                 <form action="<%=ctx%>/admin/rmsCorporateUser/save.do"  id="_adduser"  method="post">
		                <div class="modal-body">
		                 <div class="form-inline">
			                    <div class="form-group">
			                        <label class="control-label">登录名称</label>
			                        <input type="text"  id="username" name="username" class="form-control" datatype="s5-16" errormsg="登录名称至少5个字符,最多16个字符！">
			                    </div>
			                </div>
		                    <div class="form-inline">
			                    <div class="form-group">
			                        <label class="control-label">企业名称</label>
			                        <input type="text" id="corporateUserName"  name="corporateUserName" class="form-control" >
			                    </div>
			                </div>
			                 <div class="form-inline">
			                    <div class="form-group">
			                        <label class="control-label">设置密码</label>
			                        <input type="password" class="form-control" name="userpassword" datatype="*6-15" errormsg="密码范围在6~15位之间！" >
			                    </div>
			                </div>
			                <div class="form-inline">
			                    <div class="form-group">
			                        <label class="control-label">确认密码</label>
			                        <input type="password" class="form-control" name="userpassword2" datatype="*" recheck="userpassword" errormsg="您两次输入的账号密码不一致！">
			                    </div>
			                </div>
			                 <div class="form-inline">
			                    <div class="form-group">
			                        <label class="control-label">联系电话</label>
			                        <input type="text"  name="tel" class="form-control" datatype="m" errormsg="请输入正确的手机号！" ignore="ignore">
			                    </div>
			                </div>
			                 <div class="form-inline">
			                    <div class="form-group">
			                        <label class="control-label">手　　机</label>
			                        <input type="text"  name="mobile" class="form-control" datatype="m" errormsg="请输入正确的手机号！" ignore="ignore">
			                    </div>
			                </div>
			                <div class="form-inline">
			                    <div class="form-group">
			                        <label class="control-label">邮　　箱</label>
			                        <input type="text" name="email" class="form-control" datatype="e" errormsg="请输入正确的邮箱地址！" ignore="ignore">
			                    </div>
			                </div>
			         
			                 <div class="form-inline">
			                    <div class="form-group">
			                        <label class="control-label">客户说明</label>
			                        <textarea class="form-control" style="width:315px" name="_info"></textarea>
			                    </div>
			                </div>
			               
				            
		                </div>
		                
		                <div class="modal-footer">
		                    <a href="#" class="btn btn-default" data-dismiss="modal">关闭</a>
		                    <input  type="button"  class="btn btn-primary "  onclick="save()" value="保存">
		                </div>
		                </form>
		            </div>
		        </div>
		    </div>
		    <!-- 新增企业用户浮层结束-->
		    
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
		   
		    <!-- 保存浮层结束-->
		   <%@include file="../../common/foot.jsp" %>


		</div>
		

	</body>

</html>
