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
			      {id:"admin:user:query",name:"查询",pId:"admin:user:mgr"
					  <c:if test="${fn:contains(perms,'admin:user:query')}">,	      
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
				      ,
				      {id:"admin:role:mgr",name:"角色管理",pId:"admin:system:mgr"
					  <c:if test="${fn:contains(perms,'admin:role:mgr')}">,	      
					  checked:true
					  </c:if>
				      },
				      {id:"admin:role:query",name:"查询",pId:"admin:role:mgr"
						  <c:if test="${fn:contains(perms,'admin:role:query')}">,	      
						  checked:true
						  </c:if>
					      },
				      {id:"admin:role:add",name:"添加",pId:"admin:role:mgr"
						  <c:if test="${fn:contains(perms,'admin:role:add')}">,	      
						  checked:true
						  </c:if>
					      },
				      {id:"admin:role:view",name:"查看",pId:"admin:role:mgr"
						  <c:if test="${fn:contains(perms,'admin:role:view')}">,	      
						  checked:true
						  </c:if>
					      },
				      {id:"admin:role:edit",name:"修改",pId:"admin:role:mgr"
						  <c:if test="${fn:contains(perms,'admin:role:edit')}">,	      
						  checked:true
						  </c:if>
					      },
				      {id:"admin:role:del",name:"删除",pId:"admin:role:mgr"
						  <c:if test="${fn:contains(perms,'admin:role:del')}">,	      
						  checked:true
						  </c:if>
					      },
					      {id:"admin:group:mgr",name:"组织管理",pId:"admin:system:mgr"
							  <c:if test="${fn:contains(perms,'admin:group:mgr')}">,	      
							  checked:true
							  </c:if>
						      },
						      {id:"admin:group:query",name:"查询",pId:"admin:group:mgr"
								  <c:if test="${fn:contains(perms,'admin:group:query')}">,	      
								  checked:true
								  </c:if>
							      },
						      {id:"admin:group:add",name:"添加",pId:"admin:group:mgr"
								  <c:if test="${fn:contains(perms,'admin:group:add')}">,	      
								  checked:true
								  </c:if>
							      },
						      {id:"admin:group:view",name:"查看",pId:"admin:group:mgr"
								  <c:if test="${fn:contains(perms,'admin:group:view')}">,	      
								  checked:true
								  </c:if>
							      },
						      {id:"admin:group:edit",name:"修改",pId:"admin:group:mgr"
								  <c:if test="${fn:contains(perms,'admin:group:edit')}">,	      
								  checked:true
								  </c:if>
							      },
						      {id:"admin:group:del",name:"删除",pId:"admin:group:mgr"
								  <c:if test="${fn:contains(perms,'admin:group:del')}">,	      
								  checked:true
								  </c:if>
							      }
							      ,
							      {id:"admin:group:adduser",name:"添加用户",pId:"admin:group:mgr"
									  <c:if test="${fn:contains(perms,'admin:group:adduser')}">,	      
									  checked:true
									  </c:if>
								      },
							      {id:"admin:group:deluser",name:"用户删除",pId:"admin:group:mgr"
									  <c:if test="${fn:contains(perms,'admin:group:deluser')}">,	      
									  checked:true
									  </c:if>
								      }
		      
		      ];
</script>