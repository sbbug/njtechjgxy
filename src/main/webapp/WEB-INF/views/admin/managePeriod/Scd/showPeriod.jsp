<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>SCD搜索界面</title>
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
           <em>SCD搜索</em>  
           
           <p><p>
           <p><p>
           <div class="table-responsive">
					  <table class="table">
							<tr class="success">
							    <th>期刊名</th>
							    <th>ISSN</th>
							    <th>CN名字</th>
							    <th>修改</th>
							    <th>添加</th>
							    
							</tr>
							<c:forEach items = "${pageScds}" var = "scd">
							          <tr>							             						            
							              <td>${scd.scd_name}</td>
							              <td>${scd.scd_issn}</td>							         
							              <td>${scd.scd_cn}</td>	
							             					            							             							           							              						           
							              <td><a href='<%=request.getContextPath() %>/admin_scd/show_add'>添加</a></td>
							              <td><a href='<%=request.getContextPath() %>/admin_scd/modify_scd?scd_name=${scd.scd_name}'>修改</a></td>
							          </tr>                                                   
                            </c:forEach>
							
					  </table>
					  															       			
					       <a href="<%=request.getContextPath() %>/admin_scd/show_scd?which=pre">上一页</a>
					 
					       <a href="<%=request.getContextPath() %>/admin_scd/show_scd?which=next">下一页</a>
					  
					 
					  
		   </div>					
     </div>
</body>
</html>