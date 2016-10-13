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
         <script src="<%=request.getContextPath() %>/plug/Validform/Validform_v5.2.1_min.js"></script>
      
       <script type="text/javascript">
      
       $(document).ready(function () {
           $("#_saveGroup").Validform();
         });
       
       function  submitData(){
    	   var  groupName=$("input[name=groupName]").val();
    	   $.ajax({
      			url:'<%=ctx%>/admin/rmsGroup/a_groupname.do?random='+Math.random(),
      			type:"POST",
      			cache:false,
      			dataType:"json",
      			data:{'groupName':groupName},
      			success:function(data){
      				if(data.exist){
      					alert("已存在该名称！");
      				}else{
      		           $("#_saveGroup").submit();
      					}
      			},
      			error:function(){
      			}
      		});
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
                <h2><i class="glyphicon glyphicon-eye-open"></i>添加组织信息</h2>
            </div>
            <div class="box-content">
            <form action="<%=ctx %>/admin/rmsGroup/save.do"   method="post" id="_saveGroup">
             
                
                <table class="table table-bordered table-striped">
               <tr>
                <td><span>组织名称：</span></td>
                <td>
                <input type="text"  name="groupName"
				value="" class="form-control"
			     datatype="s2-16" errormsg="组织名称至少2个字符,最多16个字符！">
                
                </td>
               
              
               </tr>    
             
           
                   
                    <tr><td  colspan="2"  class="td-center">
                    
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