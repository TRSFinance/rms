   <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@include file="../../../common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>修改公司信息</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
       <%@include file="../../../common/jscss.jsp" %>
       <script src="<%=request.getContextPath() %>/plug/Validform/Validform_v5.2.1_min.js"></script>
       <script type="text/javascript">
       
       $(document).ready(function () {
           $("#_edituser").Validform();
           $("#userState").val("${user.userState}")
         });
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
                <h2><i class="glyphicon glyphicon-eye-open"></i>修改公司信息</h2>

               
            </div>
            <div class="box-content">
            <form action="<%=ctx %>/admin/rmsCompanyInfo/edit.do"   method="post" id="_editcomp">
                <div  style="display: none">
                 <input type="text" name="custid"  value="${compInfo.custId }">  
                </div>
                
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
                            <span class="label-default label label-default">企业全称</span>
                        </td>
                        <td>
                        	<input type="text"   name="custCfname" value="${compInfo.custCfname }" class="form-control">
                        </td>                       
                    </tr>
                    
                    
                    <tr>
                        <td>
                            <span class="label-success label label-default">企业简称及相关关键词</span>
                        </td>
                        <td>　
                        <input type="text"   name="custCsname" value="${compInfo.custCsname }" class="form-control">
                       </td>
                    </tr>
                    
                     <tr>
                        <td>
                            <span class="label-success label label-default">企业英文全称</span>
                        </td>
                        <td>　
                        <input type="text"   name="custEfname" value=" ${compInfo.custEfname }" class="form-control" datatype="s2-16" errormsg="登录名称至少2个字符,最多16个字符！">
                       </td>
                    </tr>
                    
                     <tr>
                        <td>
                            <span class="label-success label label-default">企业英文简称</span>
                        </td>
                        <td>　
                        <input type="text"   name="custEsname" value=" ${compInfo.custEsname }" class="form-control" datatype="s2-16" errormsg="登录名称至少2个字符,最多16个字符！">
                       </td>
                    </tr>
                    
                     <tr>
                        <td>
                            <span class="label-success label label-default">组织机构编号</span>
                        </td>
                        <td>　
                        <input type="text"   name="custOrgid" value=" ${compInfo.custOrgid }" class="form-control" datatype="s2-16" errormsg="登录名称至少2个字符,最多16个字符！">
                       </td>
                    </tr>
                    
                    
                      <tr>
                        <td>
                            <span class="label-success label label-default">行业代码</span>
                        </td>
                        <td>　
                        <input type="text"   name="custIndustrycode" value=" ${compInfo.custIndustrycode }" class="form-control" datatype="s2-16" errormsg="登录名称至少2个字符,最多16个字符！">
                       </td>
                    </tr>
                    
                      <tr>
                        <td>
                            <span class="label-success label label-default">一级行业</span>
                        </td>
                        <td>　
                        <input type="text"   name="custIndustry1" value=" ${compInfo.custIndustry1 }" class="form-control" datatype="s2-16" errormsg="登录名称至少2个字符,最多16个字符！">
                       </td>
                    </tr>
                    
                      <tr>
                        <td>
                            <span class="label-success label label-default">二级行业</span>
                        </td>
                        <td>　
                        <input type="text"   name="custIndustry2" value=" ${compInfo.custIndustry2 }" class="form-control" datatype="s2-16" errormsg="登录名称至少2个字符,最多16个字符！">
                       </td>
                    </tr>
                    
                     <tr>
                        <td>
                            <span class="label-success label label-default">企业所属地域编号</span>
                        </td>
                        <td>　
                        <input type="text"   name="areaCode" value=" ${compInfo.areaCode }" class="form-control" datatype="s2-16" errormsg="登录名称至少2个字符,最多16个字符！">
                       </td>
                    </tr>
                    
                      <tr>
                        <td>
                            <span class="label-success label label-default">经济区域</span>
                        </td>
                        <td>　
                        <input type="text"   name="districtName" value=" ${compInfo.districtName }" class="form-control" datatype="s2-16" errormsg="登录名称至少2个字符,最多16个字符！">
                       </td>
                    </tr>
                    
                    
                     <tr>
                        <td>
                            <span class="label-success label label-default">企业所属省市</span>
                        </td>
                        <td>　
                        <input type="text"   name="provinceName" value=" ${compInfo.provinceName }" class="form-control" datatype="s2-16" errormsg="登录名称至少2个字符,最多16个字符！">
                       </td>
                    </tr>
                    
                     <tr>
                        <td>
                            <span class="label-success label label-default">企业所属市</span>
                        </td>
                        <td>　
                        <input type="text"   name="cityName" value=" ${compInfo.cityName }" class="form-control" datatype="s2-16" errormsg="登录名称至少2个字符,最多16个字符！">
                       </td>
                    </tr>
                    
                     <tr>
                        <td>
                            <span class="label-success label label-default">数据来源</span>
                        </td>
                        <td>　
                       		<select  name="dataSource">
	                        <option value="1">手动添加</option>
	                        <option value="2">客户提供</option>
	                        <option value="3">接口获得</option>
	                        <option value="4">其它途径</option>
	                        <option value="5">初始数据</option>                        
                        </select>
                       </td>
                    </tr>
                    
                     <tr>
                        <td>
                            <span class="label-success label label-default">工商注册编码</span>
                        </td>
                       <td>　
                        <input type="text"   name="icCode" value=" ${compInfo.icCode }" class="form-control" datatype="s2-16" errormsg="登录名称至少2个字符,最多16个字符！">
                       </td>
                    </tr>
                    
                     <tr>
                        <td>
                            <span class="label-success label label-default">税务编号</span>
                        </td>
                        <td>　
                        <input type="text"   name="taxCode" value=" ${compInfo.taxCode }" class="form-control" datatype="s2-16" errormsg="登录名称至少2个字符,最多16个字符！">
                       </td>
                    </tr>
                    
                     <tr>
                        <td>
                            <span class="label-success label label-default">股票代码</span>
                        </td>
                        <td>　
                        <input type="text"   name="stockCode" value=" ${compInfo.stockCode }" class="form-control" datatype="s2-16" errormsg="登录名称至少2个字符,最多16个字符！">
                       </td>
                    </tr>
                    
                      <tr>
                        <td>
                            <span class="label-success label label-default">状态</span>
                        </td>
                        <td>                        
	                    <select  name="state">
	                        <option value="1">正常</option>
	                        <option value="-1">删除</option>
                        </select>
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
                    
                    
                    <tr><td  colspan="2">
                    
                    	<input  type="submit"  class="btn btn-primary "   value="保存">
                    
                    
                    </td></tr>
                    </tbody>
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