   <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@include file="../../common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>修改角色</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
       <%@include file="../../common/jscss.jsp" %>
       <link href='<%=request.getContextPath() %>/plug/ztree/css/zTreeStyle/zTreeStyle.css' rel='stylesheet'>
       <script src="<%=request.getContextPath() %>/plug/ztree/jquery.ztree.all-3.5.min.js"></script>
       <script src="<%=request.getContextPath() %>/plug/Validform/Validform_v5.2.1_min.js"></script>
             <%@include file="permtree.jsp" %>
      
       <script type="text/javascript">
      
              var setting1 = {check: {enable: true},data: {simpleData: {enable: true}}};
              var ztree = null;
       $(document).ready(function () {
           $("#_edituser").Validform();
     	    ztree = $.fn.zTree.init($("#permtree"), setting1,znodes);

         });

       function checksubmit(){
    		var nodes = ztree.getCheckedNodes(true);
    		var str = "";
    		for(var i=0;i<nodes.length;i++){
    			if(nodes[i].id!=null){
    			    str += nodes[i].id+ ",";
    			}
    		}
    		str = "<input type='hidden' name='perms' value='" +str+ "'/>";
    		$("#allperms").empty().append(str);
    		$("#_editrole").submit();
    	}

       </script>
	</head>

	<body>
	
		<!-- topbar starts -->
		<!-- topbar ends -->
		<div class="ch-container">
			<div class="row">
				<div class="box">
        <div class="box-inner">
            <div class="box-header well">
                <h2><i class="glyphicon glyphicon-eye-open"></i>修改角色信息</h2>
      
               
            </div>
            <div class="box-content">
            <form action="<%=ctx %>/admin/rmsRole/edit.do"   method="post" id="_editrole">
                <div  style="display: none">
                 <input type="text" name="id"  value="">  
                </div>
                
                <table class="table table-bordered table-striped">
                   
                   <tr>
              <td class="ftit">功能权限：</td>
              <td colspan="3">
			  <div class="l-scroll" style="height:300px;overflow-y:scroll;">
              <ul id="permtree" class="ztree">
              </ul>
              </div>
              <div style="display:none;" id="allperms"></div>
              </td>
            </tr>
                   
                    <tr><td  colspan="4">
                    
                    	<input  type="submit"  class="btn btn-primary "   value="保存">
                    
                   
                    ${perms }
                    
                    </td></tr>
                 
                </table>
                </form>
            </div>
        </div>
    </div>
		                </div>
		   
		    <!-- 保存浮层结束-->
		</div>
		
		
		
		

	</body>

</html>