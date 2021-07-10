<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>SSCI搜索界面</title>
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
           <em>SSCI搜索</em>  
           
           <p><p>
           <p><p>
           <div class="table-responsive">
					  <table class="table">
							<tr class="success">
							    <th>期刊中文名</th>
							    <th>期刊英文名</th>
							    <th>期刊属性</th>
							    <th>期刊编号</th>
							    <th>添加</th>
							    <th>修改</th>
							</tr>
							<c:forEach items = "${pageSscis}" var = "ssci">
							          <tr>							             						            
							              <td>${ssci.ssci_chinese_name}</td>
							              <td>${ssci.ssci_English_name}</td>							         
							              <td>${ssci.ssci_class}</td>	
							              <td>${ssci.ssci_issn}</td>					            							             							           							              						           
							              <td><a href='<%=request.getContextPath() %>/admin_ssci/show_add'>添加</a></td>
							              <td><a href='<%=request.getContextPath() %>/admin_ssci/modify_ssci?ssci_chinese_name=${ssci.ssci_chinese_name}'>修改</a></td>
							          </tr>                                                   
                            </c:forEach>
							
					  </table>
					  															       			
					       <a href="<%=request.getContextPath() %>/admin_ssci/show_ssci?which=pre">上一页</a>
					 
					       <a href="<%=request.getContextPath() %>/admin_ssci/show_ssci?which=next">下一页</a>
					  
					 
					  
		   </div>					
     </div>
</body>
</html>