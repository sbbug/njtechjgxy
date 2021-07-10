<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>项目成果审核界面</title>
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
           <em>项目成果审核界面</em>  
           
           <p><p>
           <p><p>
           <div class="table-responsive">
					  <table class="table">
							<tr class="success">
							    <th>材料</th>						   
							    <th>成果名称</th>
							    <th>教师名称</th>							  
							    <th>院系</th>
							    <th>所属类别</th>
							    <th>发奖单位</th>							  
							    <th>发奖时间</th>							   
							    <th>获奖级别</th>
							    <th>备注信息</th>
							    <th>项目属性</th>
							 						   							   
							    <th>下载</th>
							    <th>审核</th>
							</tr>
							<c:forEach items = "${pageAchievements}" var = "achieve">
							          <tr>
							              <td>
							              <c:choose>
								               <c:when test="${achieve.achieve_status == 0}">
								                                                          无
								               </c:when>
								               <c:otherwise>
								                                                         有
								               </c:otherwise>
							               </c:choose>
							              </td>							            
							              <td>${achieve.achieve_title}</td>
							              <td>
							              ${achieve.achieve_teacher_name}
							              </td>							         
							              <td>							            
							                  
									          ${achieve.achieve_department}                               
									               
							              </td>	
							              <td>${achieve.achieve_class}</td>	
							              <td>${achieve.achieve_unit_awards}</td>						            
							             
							            
							              <td>
							              <fmt:formatDate value="${achieve.achieve_get_time}" pattern="yyyy-MM-dd" />
							            
							              </td>
							              <td>${achieve.achieve_rank}</td>
							              <td>${achieve.achieve_remark}</td>
							              <td>${achieve.achieve_which}</td>
							            						             						           
							              <td><a href='<%=request.getContextPath() %>/admin_achievement/download_data?achieve_path=${achieve.achieve_path}'>下载</a></td>
							              <td><a href='<%=request.getContextPath() %>/admin_achievement/get_achievement_check?achieve_title=${achieve.achieve_title}&teacher_num=${achieve.teacher_num}'>审核结果</a></td>
							          </tr>                                                   
                            </c:forEach>
							
					  </table>
					  															       			
					       <a href="<%=request.getContextPath() %>/admin_achievement/show_achievement?which=pre">上一页</a>
					 
					       <a href="<%=request.getContextPath() %>/admin_achievement/show_achievement?which=next">下一页</a>
					  
					 
					  
		   </div>					
     </div>
</body>
</html>