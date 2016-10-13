   <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   
	<div class="navbar navbar-default" role="navigation">

			<div class="navbar-inner">
				<a class="navbar-brand" href="<%=request.getContextPath() %>/"> <!--<img alt="Charisma Logo" src="img/logo20.png" class="hidden-xs" />-->
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
			
				
				
				
				  <ul class="collapse navbar-collapse nav navbar-nav top-menu"  id="head_nav">
	                <li><a href="#"><i class="glyphicon glyphicon-user"></i> 企业管理</a></li>
	                <li><a href="#"><i class="glyphicon glyphicon-retweet"></i> 数据推送</a></li>
			<li><a href="#"><i class="glyphicon glyphicon-globe"></i> 网站管理</a></li>
	                <li><a href="#"><i class="glyphicon glyphicon-cog"></i> 系统管理</a></li>
	            </ul>	

			</div>
		</div>

    
    
    