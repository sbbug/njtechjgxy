<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/jQuery.js"></script>
<title>教师登录信息显示</title>
<style type="text/css">
    .main{
       text-align:center;
       border:10px;
       font-weight:bold;
       border:5px solid gray;
       margin-left:10%;
       margin-right:10%;
       margin-top:0%;
    }
    .table tr:hover
    {
     background-color:lightblue;
    }
</style>
</head>
<body>
     <div class="main">
       <h2>教师登录信息显示</h2>
		  
					  <table class="table">
					        
					        <tr class="success">
							     <td>登录时间</td>							    				    
							</tr>
							<c:forEach items = "${PageLoginLogs}" var = "log">
							          <tr>
							              <td>
							                ${log.teacher_login_time}
							              </td>							              							               
							          </tr>                                                   
                            </c:forEach>
							
					  </table>		
		               <a href="<%=request.getContextPath() %>/tea_login/show_login_log?which=pre">上一页</a>
					 
					   <a href="<%=request.getContextPath() %>/tea_login/show_login_log?which=next">下一页</a>
		         
		
		 
		    </div>
</body>
</html>