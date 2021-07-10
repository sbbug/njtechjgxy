<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>北大核心期刊搜索界面</title>
<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/jQuery.js"></script>
<style type="text/css">
 .main{
       text-align:center;
       font-weight:bold;
       border:5px solid gray;
       
       margin-top:0%;
    }
    .right{
     
      float:right;
      display:inline;
    }
    em{
      font-size:25px;
    }
    .table tr:hover
    {
     background-color:lightblue;
    }

</style>
</head>
<body>
      <div class="main">
           <em>北大核心期刊搜索</em>  
           
           <p><p>
           <p><p>
           <div class="table-responsive">
					  <table class="table">
							<tr class="success">
							    <th>期刊所属区</th>
							    <th>期刊所属编</th>
							    <th>期刊名字</th>
							    <th>修改</th>
							    <th>添加</th>
							    
							</tr>
							<c:forEach items = "${pagePekings}" var = "peking">
							          <tr>							             						            
							              <td>${peking.peking_area}</td>
							              <td>${peking.peking_series}</td>							         
							              <td>${peking.peking_name}</td>	
							             					            							             							           							              						           
							              <td><a href='<%=request.getContextPath() %>/admin_peking/show_add'>添加</a></td>
							              <td><a href='<%=request.getContextPath() %>/admin_peking/modify_peking?peking_name=${peking.peking_name}'>修改</a></td>
							          </tr>                                                   
                            </c:forEach>
							
					  </table>
					  															       			
					       <a href="<%=request.getContextPath() %>/admin_peking/show_peking?which=pre">上一页</a>
					 
					       <a href="<%=request.getContextPath() %>/admin_peking/show_peking?which=next">下一页</a>
					  
					 
					  
		   </div>					
     </div>
</body>
</html>