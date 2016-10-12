   <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@include file="../../common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>添加角色</title>
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
           $("#_saverole").Validform();
     	    ztree = $.fn.zTree.init($("#permtree"), setting1,znodes);
      	   ztree.expandAll(true);

         });
       
       function  submitData(){
    	   var  roleName=$("input[name=roleName]").val();
    	   $.ajax({
      			url:'<%=ctx%>/admin/rmsRole/a_rolename.do?random='+Math.random(),
      			type:"POST",
      			cache:false,
      			dataType:"json",
      			data:{'rolename':roleName},
      			success:function(data){
      				if(data.exist){
      					alert("已存在该名称！");
      				}else{
      					checksubmit();
      					}
      			},
      			error:function(){
      			}
      		});
       }
       

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
    		$("#_saverole").submit();
    	}

       </script>
	</head>

	<body>
	
		<!-- topbar starts -->
	    <%@include file="../../common/head.jsp"%>
		<!-- topbar ends -->
		<div class="ch-container">
			<div class="row">
				<!-- left menu starts -->
			<%@include file="../../common/left/sysconfigleft.jsp"%>
			<!--/span-->
			<!-- left menu ends -->
		<div id="content" class="col-lg-10 col-sm-10">
			<div class="row">
		<div class="box col-md-12">
        <div class="box-inner">
            <div class="box-header well">
                <h2><i class="glyphicon glyphicon-eye-open"></i>添加角色信息</h2>
            </div>
            <div class="box-content">
            <form action="<%=ctx %>/admin/rmsRole/save.do"   method="post" id="_saverole">
                <div  style="display: none">
                 <input type="text" name="id"  value="">  
                </div>
                
                <table class="table table-bordered table-striped">
               <tr>
                <td>角色名称：</td>
                <td>
                <input type="text"  name="roleName"
				value="" class="form-control"
			     datatype="s2-16" errormsg="角色名称至少2个字符,最多16个字符！">
                
                </td>
               
                <td>拥有所有权限：</td>
               
                <td>
                <input  name="isAllPerm" type="radio" value="1" >是
                <input  name="isAllPerm" type="radio"  value="2" checked="checked">否
                </td>
               
               </tr>    
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
            <tr>
              <td >简单说明：</td>
              <td colspan="3">
			   <textarea rows="2" cols=""  style="width: 80%"  name="description"></textarea>
              </td>
            </tr>
                   
                    <tr><td  colspan="4"  class="td-center">
                    
                    	<input  type="button"  class="btn btn-primary " onclick="submitData()"  value="保存">
                    
                   
                    
                    </td></tr>
                 
                </table>
                </form>
            </div>
        </div>
    </div>
</div></div></div>
				<hr>
<%@include file="../../common/foot.jsp"%>
</div>
		
	</body>

</html>