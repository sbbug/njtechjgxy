<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教学教改审核界面</title>
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
           <em>教学教改审核搜索</em>  
           
           <p><p>
           <p><p>
           <div class="table-responsive">
					  <table class="table">
							<tr class="success">
							    <th>材料</th>						   
							    <th>院系</th>
							    <th>第一作者</th>							  
							    <th>第二作者</th>
							    <th>第三作者</th>
							    <th>其他作者</th>							  
							    <th>项目名称</th>							   
							    <th>发奖单位</th>
							    <th>项目级别</th>
							    <th>金额</th>
							    <th>开始日期</th>
							    <th>结束日期</th>
							    <th>备注</th>						   							   
							    <th>下载</th>
							    <th>审核</th>
							</tr>
							<c:forEach items = "${pageReforms}" var = "reform">
							          <tr>
							              <td>
							              <c:choose>
								               <c:when test="${reform.reform_status == 0}">
								                                                          无
								               </c:when>
								               <c:otherwise>
								                                                         有
								               </c:otherwise>
							               </c:choose>
							              </td>							            
							              <td>${reform.reform_department}</td>
							              <td>
							              ${reform.reform_first_author}
							              </td>							         
							              <td>							            
							                  
									          ${reform.reform_second_author}                               
									               
							              </td>	
							              <td>${reform.reform_third_author}</td>	
							              <td>${reform.reform_other_author}</td>						            							             							            							             							             							          							              
							              <td>${reform.reform_title}</td>
							              <td>${reform.reform_give_reward_unit}</td>
							              <td>${reform.reform_rank}</td>
							              <td>${reform.reform_money}</td>	
							              <td> <fmt:formatDate value="${reform.reform_start_date}" pattern="yyyy-MM-dd" /></td>
							              <td><fmt:formatDate value="${reform.reform_end_date}" pattern="yyyy-MM-dd" /></td>	
							              <td>${reform_remark}</td>				             						           
							              <td><a href='<%=request.getContextPath() %>/admin_reform/download_data?reform_path=${reform.reform_path}'>下载</a></td>
							              <td><a href='<%=request.getContextPath() %>/admin_reform/get_reform_check?reform_title=${reform.reform_title}&teacher_num=${reform.teacher_num}'>审核结果</a></td>
							          </tr>                                                   
                            </c:forEach>
							
					  </table>
					  															       			
					       <a href="<%=request.getContextPath() %>/admin_reform/show_reform?which=pre">上一页</a>
					 
					       <a href="<%=request.getContextPath() %>/admin_reform/show_reform?which=next">下一页</a>
					  
					 
					  
		   </div>					
     </div>
</body>
</html>