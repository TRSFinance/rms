   <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@include file="../../common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>用户角色</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
       <%@include file="../../common/jscss.jsp" %>
       	<script src="<%=request.getContextPath() %>/plug/Validform/Validform_v5.2.1_min.js"></script>
       
      <script type="text/javascript">
      function  query(){
      	$("#data").submit();}
      
      function  closeModal(){
	    	  window.parent.hideFrame();
  
      }
      
      function  delUserRoles(){
    	 
    	  var ids ="";   
    	  var  i=0;
    	  $('input[name=ids]:checked').each(function(){  
    		  if(i>0)
    		  ids=ids+",";  
    		  ids=ids+$(this).val()
    		  i++;
    	  }); 
    	  if(i==0){
    		  alert("请至少选择一个！");
    	  }
    	  var  userId=$("input[name=userId]").val();
    	  $.ajax({
  			url:'<%=ctx%>/admin/rmsUser/delUserRoles.do?random='+Math.random(),
  			type:"POST",
  			cache:false,
  			dataType:"json",
  			data:{'ids':ids,"userId":userId},
  			success:function(data){
  				if(data.success){
  					$("#data").submit();
  					}else{
  	  				alert("删除失败！");}
  			},
  			error:function(){
  				alert("删除失败！");
  			}
  		});
    	  
    	  
      }
      
      
       </script>
	</head>

	<body>
				<!-- left menu ends -->
				   <div id="content" class="col-lg-10">
					<br>
					<br>
					<div class="row">
					<form action="<%=ctx %>/admin/rmsUser/userRole.do"  style="margin-left: 20px;margin-right: 20px;"  method="post"  id="data">
				
					<div class="col-md-6 td-left" >
						<div  class="dataTables_filter">
							<label>搜索:<input type="text" class="" name="search" value="${search }"><a href="#" onclick="query()"><i class="glyphicon glyphicon-search form_search" ></i></a></label>
						</div>
					</div>
					<div class="col-md-6 td-right">
						<div class="dataTables_length">
							<input type="button"  class="btn " value="关闭" onclick="closeModal()">
					        <input type="button"  class="btn" value="删除" onclick="delUserRoles()">
							
						</div>
					</div>
					<input  type="hidden"  name="userId"  value="${userId }" />
					</form>
					<div class="box col-md-12">
							<div class="box-inner" >
								<div >
									<table class="table table-striped table-bordered   ">
										<thead>
											<!--  表头信息开始  -->
											<tr>
												<th><input type="checkbox" value="-1">全选</th>
												<th>角色名称</th>
												<th>创建时间</th>
											</tr>
											<!--  表头信息结束 -->
										</thead>
										<tbody>
										     <c:if test="${!empty rmsRoles}"> 
										        <c:forEach items="${rmsRoles }" var="role" varStatus="status">
										     <tr>
												<td><input  type="checkbox"  name="ids" value="${role.roleId }">${ status.index + 1}</td>
												<td>${role.roleName }</td>
												<td>${role.createTime }</td>
												
											</tr>
										     </c:forEach>
										     
										      </c:if>
										     <c:if test="${empty rmsRoles}"> 
										      <tr>
											      <td colspan="3">
											                   没有查到相关数据！
											      </td>
										      </tr>
										      </c:if>
											
											

										</tbody>
									</table>
								
		
		</div>
							</div>
						</div>
					</div>
					
				</div>
	</body>

</html>
