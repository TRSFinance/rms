   <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="perms" value="${perms }"></c:set>
   <script language="javascript">
var znodes = [{id:"admin:workspace:index,admin:workspace:right",name:"所有权限",open:true
	         <c:if test="${fn:contains(perms,'admin:workspace:index')}">,	      
			  checked:true
			  </c:if>
		      },
		      {id:"admin:workspace:mgr",name:"我的工作台",pId:"admin:workspace:index,admin:workspace:right"
			  <c:if test="${fn:contains(perms,'admin:workspace:mgr')}">	,      
			  checked:true
			  </c:if>
		      },
		      {id:"admin:workspace:infoopt",name:"个人资料",pId:"admin:workspace:mgr"
			  <c:if test="${fn:contains(perms,'admin:workspace:infoopt')}">	,      
			  checked:true
			  </c:if>
		      },
		      {id:"admin:system:mgr",name:"系统管理",pId:"admin:workspace:index,admin:workspace:right"
				  <c:if test="${fn:contains(perms,'admin:system:mgr')}">	,      
				  checked:true
				  </c:if>
			      },
			      {id:"admin:user:mgr",name:"用户管理",pId:"admin:system:mgr"
				  <c:if test="${fn:contains(perms,'admin:user:mgr')}">,	      
				  checked:true
				  </c:if>
			      },
			      {id:"admin:user:add",name:"添加",pId:"admin:user:mgr"
					  <c:if test="${fn:contains(perms,'admin:user:add')}">,	      
					  checked:true
					  </c:if>
				      },
			      {id:"admin:user:view",name:"查看",pId:"admin:user:mgr"
					  <c:if test="${fn:contains(perms,'admin:user:view')}">,	      
					  checked:true
					  </c:if>
				      },
			      {id:"admin:user:edit",name:"修改",pId:"admin:user:mgr"
					  <c:if test="${fn:contains(perms,'admin:user:edit')}">,	      
					  checked:true
					  </c:if>
				      },
			      {id:"admin:user:del",name:"删除",pId:"admin:user:mgr"
					  <c:if test="${fn:contains(perms,'admin:user:del')}">,	      
					  checked:true
					  </c:if>
				      }
		      
		      ];
</script>