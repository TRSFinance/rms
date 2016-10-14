   <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@include file="../../common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>系统组织管理</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
       <%@include file="../../common/jscss.jsp" %>
       	<script src="<%=request.getContextPath() %>/plug/Validform/Validform_v5.2.1_min.js"></script>
       
      <script type="text/javascript">
       $(document).ready(function () {
         $("#pageSize").val("${page.pageSize}");
         var obj=$("#searchword");  
         obj.keyup(function(event){
         var  myEvent=event||window.event;
         var  keycode=myEvent.keyCode;		  
         if(keycode==13){
             $("#pageSize").val(1);
             query();
    	 } });
         
         
       });
    
       function  dels(obj){
       $("#delid").val(obj);
       $('#warnModal').modal('show');
       }
        function  del(){
          $('#warnModal').modal('hide');
       	 var  delid=$("#delid").val();
       	 $.ajax({
    			url:'<%=ctx%>/admin/rmsGroup/a_del.do?random='+Math.random(),
    			type:"POST",
    			cache:false,
    			dataType:"json",
    			data:{'id':delid},
    			success:function(data){
    				if(data.success){
    					$("#data").submit();
    				}else{
    					alert("删除失败！");
    				}
    			},
    			error:function(){
    			}
    		});
    	        }
        
    function  query(){
    	$("#data").submit();}
    
    function   addGroupUser(id){
    	$("#frameUser").attr("src","<%=ctx %>/admin/rmsGroup/groupUserN.do?groupId="+id);
    	$("#frameModal").modal("show");
    }
    function   hideFrame(){
    	$("#frameModal").modal("hide");
    }
    
    function   queryGroupUser(id){
    	$("#frameUser").attr("src","<%=ctx %>/admin/rmsGroup/groupUser.do?groupId="+id);
    	$("#frameModal").modal("show");
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
                     <div class="box-header well"  >
                        <a  href="<%=ctx %>/admin/rmsGroup/v_add.do" ><i class="glyphicon glyphicon-plus-sign icon-white"></i>添加组织</a>
                      </div>					
					</div>

					<div class="row">
							<br>
					
					<form action="<%=ctx %>/admin/rmsGroup/v_list.do"  style="margin-left: 20px;margin-right: 20px;"  method="post"  id="data">
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
							<label>名称:<input type="text" class="" id="searchword" name="searchword" value="${page.searchword }"><a href="#" onclick="query()"><i class="glyphicon glyphicon-search form_search" ></i></a></label>
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
												<th>组织名称</th>
												<th>创建时间</th>
												<th>操作</th>
											</tr>
											<!--  表头信息结束 -->
										</thead>
										<tbody>
										     <c:if test="${!empty data}"> 
										        <c:forEach items="${data }" var="rmsGroup" varStatus="status">
										     <tr>
												<td>${ status.index + 1}</td>
												<td>${rmsGroup.groupName }</td>
												
												<td>${rmsGroup.createTime }</td>
												<td class="center font-right">
													<a class="btn btn-success btn-sm" href="<%=ctx%>/admin/rmsGroup/view.do?id=${rmsGroup.groupId }"  target="_blank">
														<i class="glyphicon glyphicon-zoom-in icon-white"></i>查看
													</a>
													<a class="btn btn-info btn-sm " href="<%=ctx%>/admin/rmsGroup/v_edit.do?id=${rmsGroup.groupId }"  target="_self">
														<i class="glyphicon glyphicon-edit icon-white"></i>修改
													</a>
													<a class="btn btn-danger btn-sm" href="#" onclick="dels(${rmsGroup.groupId })" >
														<i class="glyphicon glyphicon-trash icon-white"></i>删除
													</a>
													<a class="btn btn-success btn-sm" href="#"  onclick="addGroupUser(${rmsGroup.groupId })">
														<i class="glyphicon glyphicon-plus-sign icon-white"></i>添加用户
													</a>
													<a class="btn btn-info btn-sm" href="#"  onclick="queryGroupUser(${rmsGroup.groupId })">
														<i class="glyphicon glyphicon-search icon-white"></i>查询用户
													</a>
													
												</td>
											</tr>
										     </c:forEach>
										     
										      </c:if>
										     
										     <c:if test="${empty data}"> 
										      <tr>
										      <td colspan="4">
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
			<!--/fluid-row-->
		
		<hr>
		
		    
		    <div class="modal fade td-center" id="frameModal" tabindex="-1" role="dialog" aria-labelledby="frameModalLabel"
		         aria-hidden="true">
	      
		                <div class="modal-body"  >
		                <iframe src=""  id="frameUser" style="width: 80%;height: 500px;text-align: center;"></iframe>
		                </div>
		                
		          
		    </div>
		    
		    
		    
		    
		    
		    
		    
		    
		    
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
		                    <p>你将要删除此组织？删除将会关联删除与之相关的数据！</p>
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
