<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>成果填报搜索界面</title>
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
           <em>成果填报搜索</em>  
           
           <p><p>
           <p><p>
           <div class="table-responsive">
					  <table class="table">
							<tr class="success">
							    <th>材料</th>						   
							    <th>院系</th>
							    <th>成员一</th>							  
							    <th>成员二</th>
							    <th>成员三</th>
							    <th>竞赛名称</th>							  
							    <th>颁奖单位</th>							   
							    <th>获奖级别</th>
							    <th>获奖时间</th>
							    <th>备注信息</th>
							 						   							   
							    <th>修改</th>
							    <th>审核结果</th>
							</tr>
							<c:forEach items = "${pagePrizes}" var = "prize">
							          <tr>
							              <td>
							              <c:choose>
								               <c:when test="${prize.prize_status == 0}">
								                                                          无
								               </c:when>
								               <c:otherwise>
								                                                         有
								               </c:otherwise>
							               </c:choose>
							              </td>	
							               <td>							            
							                  
									          ${prize.prize_department}                               
									               
							              </td>							            
							              <td>${prize.prize_member_one}</td>
							              <td>
							              ${prize.prize_member_two}
							              </td>							         
							             
							              <td>${prize.prize_member_three}</td>	
							              <td>${prize.prize_name}</td>						            
							              <td>${prize.prize_give_unit}</td>
							               <td>${prize.prize_rank}</td>
							              <td>
							              <fmt:formatDate value="${prize.prize_get_time}" pattern="yyyy-MM-dd" />
							            
							              </td>
							              
							              <td>${prize.prize_remark}</td>
							             
							            						             						           
							              <td><a href='<%=request.getContextPath() %>/tea_prize/modify_prize?prize_uuid=${prize.prize_uuid}'>修改</a></td>
							              <td><a href='<%=request.getContextPath() %>/tea_prize_check_result/index?prize_uuid=${prize.prize_uuid}'>审核结果</a></td>
							          </tr>                                                   
                            </c:forEach>
							
					  </table>
					  															       			
					       <a href="<%=request.getContextPath() %>/tea_prize/search?which=pre">上一页</a>				 
					       <a href="<%=request.getContextPath() %>/tea_prize/search?which=next">下一页</a>
					  
					 
					  
		   </div>					
     </div>
</body>
</html>