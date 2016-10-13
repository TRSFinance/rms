   <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@include file="../../common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>系统用户管理</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
       <%@include file="../../common/jscss.jsp" %>
       	<script src="<%=request.getContextPath() %>/plug/Validform/Validform_v5.2.1_min.js"></script>
       
      <script type="text/javascript">
       $(document).ready(function () {
         $("#pageSize").val("${page.pageSize}");
         $("#_adduser").Validform();
       });
       function save() {
    	   var  userName=$("#username").val();
    	   $.ajax({
   			url:'<%=ctx%>/admin/rmsUser/a_username.do?random='+Math.random(),
   			type:"POST",
   			cache:false,
   			dataType:"json",
   			data:{'username':userName},
   			success:function(data){
   				if(data.exist){
   					alert("已存在该用户！");
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
    			url:'<%=ctx%>/admin/rmsUser/a_del.do?random='+Math.random(),
    			type:"POST",
    			cache:false,
    			dataType:"json",
    			data:{'userId':delid},
    			success:function(data){
    				if(data.success){
    					window.location.href="<%=ctx%>/admin/rmsUser/list.do";
    				}
    			},
    			error:function(){
    			}
    		});
    	        }
       
       
       </script>
	</head>

	<body>
		
		<div class="ch-container">
			<div class="row">
			
				<!-- left menu ends -->
				   <div id="content" class="col-lg-10 col-sm-10">
					<!-- content starts -->
					<div>
					<div class="box-header well">
					<button class="btn btn-info btn-sm btn-adduser"> <i class="glyphicon glyphicon-plus-sign icon-white"></i>添加用户</button>
					</div>
					</div>
					<div class="row">
					<form action="<%=ctx %>/admin/rmsUser/v_list.do"  style="margin-left: 20px;margin-right: 20px;"  method="post"  id="data">
					<div class="col-md-6">
						<div class="dataTables_length">
							<label><select name="pageSize" class="" id="pageSize">
							        <option value="10">10</option>
									<option value="20">20</option>
									<option value="50">50</option>
									<option value="100">100</option></select>条每页</label>
						</div>
					</div>
					<div class="col-md-6 td-right" >
						<div  class="dataTables_filter">
							<label>搜索:<input type="text" class="" name="username" value="${page.searchword }"></label>
						</div>
					</div>
					<input  type="hidden"  name="pageNo"  value="1" id="pageNo"/>
					</form>
					<div class="box col-md-12">
							<div class="box-inner" >
								<div class="box-content">
									<table class="table table-striped table-bordered   ">
										<thead>
											<!--  表头信息开始  -->
											<tr>
												<th>序号</th>
												<th>用户名称</th>
												<th>登录用户名</th>
												<th>创建时间</th>
												<th>操作</th>
											</tr>
											<!--  表头信息结束 -->
										</thead>
										<tbody>
										     <c:if test="${!empty data}"> 
										        <c:forEach items="${data }" var="rmsUser" varStatus="status">
										     <tr>
												<td>${ status.index + 1}</td>
												<td>${rmsUser.nickName }</td>
												<td>${rmsUser.loginName }</td>
												<td>${rmsUser.createTime }</td>
												<td class="center font-right">
													<a class="btn btn-success btn-sm" href="<%=ctx%>/admin/rmsUser/view.do?id=${rmsUser.userId }"  target="_blank">
														<i class="glyphicon glyphicon-zoom-in icon-white"></i>查看
													</a>
													<a class="btn btn-info btn-sm " href="<%=ctx%>/admin/rmsUser/v_edit.do?id=${rmsUser.userId }"  target="_self">
														<i class="glyphicon glyphicon-edit icon-white"></i>修改
													</a>
													<a class="btn btn-danger btn-sm" href="#" onclick="dels(${rmsUser.userId })" >
														<i class="glyphicon glyphicon-trash icon-white"></i>删除
													</a>
												</td>
											</tr>
										     </c:forEach>
										     
										      </c:if>
										     <c:if test="${empty data}"> 
										      <tr>
											      <td colspan="5">
											                   没有查到相关数据！
											      </td>
										      </tr>
										      </c:if>
											
											

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
	
			

		</div>
		

	</body>

</html>
