   <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@include file="../../../common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>公司信息详情</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
       <%@include file="../../../common/jscss.jsp" %>
	</head>

	<body>
		<!-- topbar starts -->
		 <%@include file="../../../common/head.jsp" %>
		<!-- topbar ends -->
		<div class="ch-container">
			<div class="row">
				<div class="box">
        <div class="box-inner">
            <div class="box-header well">
                <h2><i class="glyphicon glyphicon-eye-open"></i>公司信息详情</h2>

               
            </div>
            <div class="box-content">
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th width="40%">参数</th>
                        <th width="60%">值</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>
                            <span class="label-default label">企业全称</span>
                        </td>
                        <td>　${compInfo.custCfname }
                       
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span class="label-success label label-default">企业简称及相关关键词</span>
                        </td>
                        <td>　${compInfo.custCsname } </td>
                    </tr>
                    
                     <tr>
                        <td>
                            <span class="label-success label label-default">企业英文全称</span>
                        </td>
                        <td>　${compInfo.custEfname } </td>
                    </tr>
                    
                     <tr>
                        <td>
                            <span class="label-success label label-default">企业英文简称</span>
                        </td>
                        <td>　${compInfo.custEsname } </td>
                    </tr>
                    
                     <tr>
                        <td>
                            <span class="label-success label label-default">组织机构编号</span>
                        </td>
                        <td>　${compInfo.custOrgid } </td>
                    </tr>
                    
                    
                      <tr>
                        <td>
                            <span class="label-success label label-default">行业代码</span>
                        </td>
                        <td>　${compInfo.custIndustrycode } </td>
                    </tr>
                    
                      <tr>
                        <td>
                            <span class="label-success label label-default">一级行业</span>
                        </td>
                        <td>　${compInfo.custIndustry1 } </td>
                    </tr>
                    
                      <tr>
                        <td>
                            <span class="label-success label label-default">二级行业</span>
                        </td>
                        <td>　${compInfo.custIndustry2 } </td>
                    </tr>
                    
                     <tr>
                        <td>
                            <span class="label-success label label-default">企业所属地域编号</span>
                        </td>
                        <td>　${compInfo.areaCode } </td>
                    </tr>
                    
                      <tr>
                        <td>
                            <span class="label-success label label-default">经济区域</span>
                        </td>
                        <td>　${compInfo.districtName } </td>
                    </tr>
                    
                    
                     <tr>
                        <td>
                            <span class="label-success label label-default">企业所属省市</span>
                        </td>
                        <td>　${compInfo.provinceName } </td>
                    </tr>
                    
                     <tr>
                        <td>
                            <span class="label-success label label-default">企业所属市</span>
                        </td>
                        <td>　${compInfo.cityName } </td>
                    </tr>
                    
                     <tr>
                        <td>
                            <span class="label-success label label-default">数据来源</span>
                        </td>
                        <td>　${compInfo.dataSource } </td>
                    </tr>
                    
                     <tr>
                        <td>
                            <span class="label-success label label-default">工商注册编码</span>
                        </td>
                        <td>　${compInfo.icCode } </td>
                    </tr>
                    
                     <tr>
                        <td>
                            <span class="label-success label label-default">税务编号</span>
                        </td>
                        <td>　${compInfo.taxCode } </td>
                    </tr>
                    
                     <tr>
                        <td>
                            <span class="label-success label label-default">股票代码</span>
                        </td>
                        <td>　${compInfo.stockCode } </td>
                    </tr>
                    
                      <tr>
                        <td>
                            <span class="label-success label label-default">状态</span>
                        </td>
                        <td>                        
	                        <c:if test="${compInfo.state  eq 1 }">正常</c:if>
	　　　　　　　　　　　　　　　　<c:if test="${compInfo.state  eq -1 }">删除</c:if>
						</td>              
                    </tr>
                    
                    <tr>
                        <td>
                            <span class="label-warning label label-default">创建日期</span>
                        </td>
                        <td>${compInfo.createTime }</td>
                    </tr>
                    <tr>
                        <td>
                            <span class="label-default label label-danger">修改日期</span>
                        </td>
                        <td>${compInfo.changeTime }</td>
                    </tr>
                    
                    
    
                    </tbody>
                </table>
            </div>
        </div>
    </div>
		                </div>
		   
		    <!-- 保存浮层结束-->
		   <%@include file="../../../common/foot.jsp" %>


		</div>
		

	</body>

</html>
