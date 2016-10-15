   <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <!-- 系统配置  左侧 -->
		<!-- left menu starts -->
				<div class="col-sm-2 col-lg-2">
					<div class="sidebar-nav">
						<div class="nav-canvas">
							<div class="nav-sm nav nav-stacked">

							</div>
							<ul class="nav nav-pills nav-stacked main-menu">
		                        <li class="accordion">
		                            <a href="#"><i class="glyphicon glyphicon-tasks"></i><span>用户/组织管理</span><i class="glyphicon glyphicon-chevron-down pull-right hidden-sm" id="icondown"></i></a>
		                            <ul class="nav nav-pills nav-stacked"  id="_userGroupmgr">
		                                <li><a href="<%=request.getContextPath() %>/admin/rmsUser/list.do"  id="_usermgr">用户管理</a>
		                                </li>
		                                <li><a href="<%=request.getContextPath()%>/admin/rmsGroup/list.do" id="_groupmgr">组织管理</a></li>
		                                <li><a href="<%=request.getContextPath() %>/admin/rmsRole/list.do" id="_rolemgr">角色管理</a></li>
		                            </ul>
		                        </li>
		                        <li class="accordion">
		                            <a href="#"><i class="glyphicon glyphicon-magnet"></i><span>系统配置</span><i class="glyphicon glyphicon-chevron-down pull-right hidden-sm"></i></a>
		                            <ul class="nav nav-pills nav-stacked">
		                                <li><a href="#" class="ajax-link">系统配置1</a></li>
		                            </ul>
		                        </li>

								
							</ul>
							<label id="for-is-ajax" for="is-ajax" class="hidden"><input id="is-ajax" type="checkbox" checked></label>
						</div>
					</div>
				</div>
				<!--/span-->
    
    
    