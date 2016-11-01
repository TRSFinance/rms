<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>我是测试的！</title>
<script type="text/javascript" src="./style/js/jquery-1.11.3.min.js"></script>
</head>

<body>


	<input type="button" class="ajax-link" value="点我有惊喜">
	
	<input type="button" class="surprise" value="还有惊喜">

<script type="text/javascript">

		$(".ajax-link").click(function() { 
			alert("骗你的");
		});

		
		
		$.get("/rms/admin/rmsCompanyInfo/list.do",{},function(data){
			
			alert(data);
		});	

 
// 	   	$(".ajax-link").click(function() {     
// 	        $.ajax({     
// 	            //要用post方式      
// 	            type: "Post",     
// 	            //方法所在页面和方法名      
// 	            url: "/rms/admin/rmsCompanyInfo/list.do",     
// 	            contentType: "application/json; charset=utf-8",     
// 	            dataType: "json",     
// 	            success: function(data) {     
// 	                //返回的数据用data.d获取内容      
// 	                alert("回来啦");     
// 	            },     
// 	            error: function(err) {     
// 	                alert("oh my god");     
// 	            }     
// 	        });     	
// // 	        //禁用按钮的提交      
// // 	        return false;     
// 	    });     


</script>





</body>
</html>