   <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   
	<div class="navbar navbar-default" role="navigation">

			<div class="navbar-inner">
				<a class="navbar-brand" href=""> <!--<img alt="Charisma Logo" src="img/logo20.png" class="hidden-xs" />-->
					<span>风险管理系统</span></a>

				<!-- user dropdown starts -->
				<div class="btn-group pull-right">
					<button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
	                    <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs">${rmsuser.nickName }</span>
	                    <span class="caret"></span>
                    </button>
					<ul class="dropdown-menu">
						<li>
							<a href="<%=request.getContextPath()%>/admin/login.do">用户</a>
						</li>
						<li class="divider"></li>
						<li>
							<a href="<%=request.getContextPath()%>/admin/logout.do">退出</a>
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

    
    
    