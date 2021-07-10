<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教师基本信息显示</title>
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
           <em>教师基本信息显示</em>  
           
           <p><p>
           <p><p>
           <div class="table-responsive">
					  <table class="table">
							<tr class="success">
							    <th>账号</th>						   
							    <th>姓名</th>
							    <th>状态</th>							  
							    <th>院系</th>
							    <th>职称</th>
							    <th>身份证号</th>
							    <th>修改</th>							  
							    <th>重置密码</th>							   
							    <th>删除</th>
							    
							</tr>
							<c:forEach items = "${pageTeachers}" var = "teacher">
							          <tr>
							              <td>${teacher.teacher_num}</td>
							              <td>${teacher.teacher_name}</td>
							              <td>
							              <c:choose>
								               <c:when test="${teacher.teacher_status == 0}">
								                                                          禁用
								               </c:when>
								               <c:otherwise>
								                                                         启用
								               </c:otherwise>
							               </c:choose>
							              </td>	
							               <td>${teacher.teacher_department}</td>							            
							               <td>${teacher.teacher_title}</td>
							               <td>
							                ${teacher.teacher_ID_Card}
							               </td>							         							             							            							             							            							            						             						           
							              <td><a href='<%=request.getContextPath() %>/admin_manage/modify_teacher?teacher_num=${teacher.teacher_num}'>修改</a></td>
							              <td><a href='<%=request.getContextPath() %>/admin_manage/reset_password?teacher_num=${teacher.teacher_num}&teacher_ID_Card=${teacher.teacher_ID_Card}'  onClick="return checkYes()">重置密码</a></td>
							              <td><a href='<%=request.getContextPath() %>/admin_manage/delete_teacher?teacher_num=${teacher.teacher_num}'>删除</a></td>
							          </tr>                                                   
                            </c:forEach>
							
					  </table>
					  															       			
					       <a href="<%=request.getContextPath() %>/admin_manage/search?which=pre">上一页</a>				 
					       <a href="<%=request.getContextPath() %>/admin_manage/search?which=next">下一页</a>
					  
					 
					  
		   </div>	
		   <script>
		             function checkYes(){
		            	 
		                 flag = confirm("你确认重置密码吗");
		            	
		                 if(flag) return true; 
		            	 return false;
		             }
		   </script>
		   ${result}				
     </div>
</body>
</html>