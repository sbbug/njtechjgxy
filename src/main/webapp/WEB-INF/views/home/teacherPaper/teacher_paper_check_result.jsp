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
       <h2>论文审核结果</h2>
		  
					  <table class="table">
					        
					        <tr class="success">
							     <td>院期刊库</td>
							     <td>北大核心期刊</td>
							     <td>SCD期刊</td>
							     <td>SSCI期刊</td>
							     <td>审核结果</td>
							     <td>审核信息</td>
							     <td>审核等级</td>
							     <td>论文名称</td>
							     <td>管理员留言</td>						    
							</tr>
							<tr class="active">
							     <td>
							           <c:choose>
								               <c:when test="${paperCheckResult.is_in_own == 0}">
								                                                          不存在
								               </c:when>
								               <c:otherwise>
								                                                         存在
								               </c:otherwise>
							           </c:choose>
							     </td>
							     <td>
							            <c:choose>
								               <c:when test="${paperCheckResult.is_in_peking == 0}">
								                                                          不存在
								               </c:when>
								               <c:otherwise>
								                                                         存在
								               </c:otherwise>
							           </c:choose> 
							     </td>
							     <td>
							            <c:choose>
								               <c:when test="${paperCheckResult.is_in_scd == 0}">
								                                                          不存在
								               </c:when>
								               <c:otherwise>
								                                                         存在
								               </c:otherwise>
							           </c:choose>
							     </td>
							     <td>
							            <c:choose>
								               <c:when test="${paperCheckResult.is_in_ssci == 0}">
								                                                          不存在
								               </c:when>
								               <c:otherwise>
								                                                         存在
								               </c:otherwise>
							           </c:choose>
							     </td>
							     <td> 
							            <c:choose>
								               <c:when test="${paperCheckResult.result_is_ok == 1}">
								                                                          未审核呢
								               </c:when>
								                <c:when test="${paperCheckResult.result_is_ok == 2}">
								                                                          通过
								               </c:when>
								               <c:otherwise>
								                                                        未通过
								               </c:otherwise>
							           </c:choose> 
							     </td>
							     <td>
							            ${paperCheckResult.result_info} 
							     </td>
							     <td>
							            
							            ${paperCheckResult.result_level}
							     </td>
							     <td>
							            ${paperCheckResult.paper_title} 
							           
							     </td>
							     <td>
							             ${paperCheckResult.result_message}
							     </td> 
							</tr>
							
							
					  </table>
				
                               
		        
		         
		
		 
		    </div>
</body>
</html>