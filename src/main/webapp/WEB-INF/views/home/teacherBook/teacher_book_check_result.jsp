<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/jQuery.js"></script>
<title>Insert title here</title>
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
</style>
</head>
<body>
     <div class="main">
       <h2>书籍项目审核结果</h2>
		  
					  <table class="table">
					        
					        <tr class="success">
							     <td>奖励总额</td>
							     <td>学院奖励</td>
							     <td>审核状态</td>
							     <td>项目名称</td>
							     <td>信息留言</td>							    					    
							</tr>
							<tr class="active">
							     <td>
							          ${book_check_result.result_total_reward}
							     </td>
							     <td>
							          ${book_check_result.result_reward_from_depart}
							     </td>
							     <td>
							            <c:choose>
								               <c:when test="${book_check_result.result_is_ok == 1}">
								                                                          未审核
								               </c:when>
								                <c:when test="${book_check_result.result_is_ok == 2}">
								                                                          通过
								               </c:when>
								               <c:otherwise>
								                                                         不合格
								               </c:otherwise>
							           </c:choose> 
							     </td>
							     <td>
							           ${book_check_result.book_name}
							     </td>
							     <td>
							           ${book_check_result.result_message}
							     </td>							    							     
							</tr>													
					  </table>                           		        		      		 
		    </div>
</body>
</html>