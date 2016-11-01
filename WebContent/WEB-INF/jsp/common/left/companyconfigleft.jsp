<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>

       <!-- 企业管理  左侧 -->
		<div class="col-sm-2 col-lg-2">
					<div class="sidebar-nav">
						<div class="nav-canvas">
							<div class="nav-sm nav nav-stacked">

							</div>
							<ul class="nav nav-pills nav-stacked main-menu">
							
		            			 <li class="accordion">
		                            <a href="#"><i class="glyphicon glyphicon-list"></i><span>企业管理</span><i class="glyphicon glyphicon-chevron-down pull-right hidden-sm" id="icondown"></i></a>
		                            <ul class="nav nav-pills nav-stacked" id="_usermgr">
		                            <shiro:hasPermission name="admin:corporateUser:query">
		                           	 	<li><a href="<%=request.getContextPath()%>/admin/rmsCorporateUser/list.do">企业用户管理</a></li>
									</shiro:hasPermission>	
									<shiro:hasPermission name="admin:companyInfo:query">
										<li class="accordion"><a href="#"><span>企业名单管理</span><i class="glyphicon glyphicon-chevron-down pull-right hidden-sm" id="icondown2"></i></a>
				                            <ul  class="nav nav-pills nav-stacked" id="userList">
											</ul>
										</li>
									</shiro:hasPermission>
		                            </ul>
		                        </li>											
							</ul>
							<label id="for-is-ajax" for="is-ajax" class="hidden"><input id="is-ajax" type="checkbox" checked=""></label>
						</div>
					</div>
				</div>
				<!--/span-->
   <!-- left menu ends --> 
   
   <script type="text/javascript">
   
//    $("#icondown").removeClass("glyphicon-chevron-down").addClass("glyphicon-chevron-up");     
//    $("#_usermgr").css("display","block");
//    $("#icondown2").removeClass("glyphicon-chevron-down").addClass("glyphicon-chevron-up");
//    $("#userList").css("display","block");
   
   $(document).ready(function(){
   		$.ajax({
   			url:'/rms/admin/rmsCorporateUser/leftUserList.do?random='+Math.random(),
   			type:"GET",
   			cache:false,
   			dataType:"json",
   			data:{},
   			success:function(data){ 
				for(var i=0;i<data.cool.length;i++){
					var html = "";
					html += "<li><a href="+"<%=request.getContextPath()%>"+"/admin/rmsCompanyInfo/list.do?userId="+data.cool[i].userId+">"+data.cool[i].corporateName+"</a></li>";					
					$("#userList").append(html);
				}
   			},
   			error:function(){
   				alert('获取企业用户数据失败');
   			}
   		}); 
   	});	
   
  
   </script>
   
    