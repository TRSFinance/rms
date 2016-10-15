   <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@include file="../../common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>修改组织</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
       <%@include file="../../common/jscss.jsp" %>
       <script src="<%=request.getContextPath() %>/plug/Validform/Validform_v5.2.1_min.js"></script>
       <script type="text/javascript">
       $(document).ready(function () {
           $("#_editGroup").Validform();
     	    });

       function  submitData(){
    	   var  groupName=$("input[name=groupName]").val();
    	   var  id=$("input[name=id]").val();

    	   $.ajax({
      			url:'<%=ctx%>/admin/rmsGroup/e_groupname.do?random='+Math.random(),
      			type:"POST",
      			cache:false,
      			dataType:"json",
      			data:{'id':id,'groupName':groupName},
      			success:function(data){
      				if(data.exist){
      					alert("已存在该名称！");
      				}else{
      		           $("#_editGroup").submit();
      					}
      			},
      			error:function(){
      			}
      		});
       }
       function winback(){
    	   history.go(-1);	
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
                <h2><i class="glyphicon glyphicon-eye-open"></i>查看组织信息</h2>
            </div>
            <div class="box-content">
                
               <div style="display: none"> 
               <input  type="text"  value="${group.groupId }"  name="id">
                </div> 
                
                <table class="table table-bordered table-striped">
                <tr>
                <td>组织名称：</td>
                <td>
                ${group.groupName }
              
               </tr> 
                <tr>
                <td>创建时间：</td>
                <td>
                ${group.createTime }
              
               </tr>   
                <tr>
                <td>修改时间：</td>
                <td>
                ${group.updateTime }
               </tr> 
               <tr><td  colspan="2" class="td-center">
                    	<input type="button" class="btn btn-primary " value="关闭" onclick="closeWin()">									
                    </td>
                </tr>
                </table>
            </div>
        </div>
    </div>
</div></div></div>
				<hr>

		    
		<%@include file="../../common/foot.jsp"%>
		    
		    
		</div>
		
		
		
		

	</body>

</html>