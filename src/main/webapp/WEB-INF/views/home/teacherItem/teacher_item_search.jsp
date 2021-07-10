<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>科研项目搜索界面</title>
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
           <em>项目申报搜索</em>  
           
           <p><p>
           <p><p>
           <div class="table-responsive">
					  <table class="table">
							<tr class="success">
							    <th>材料</th>						   
							    <th>专业</th>
							    <th>第一主持人</th>							  
							    <th>第二作者</th>							  
							    <th>第三作者</th>							   
							    <th>项目课题</th>
							    <th>基金号</th>
							    <th>课题来源</th>
							    <th>项目等级</th>
							    <th>项目性质</th>
							    <th>项目经费</th>
							    <th>开始时间</th>
							    <th>结束时间</th>
							    <th>项目备注</th>
							    <th>修改</th>
							    <th>审核结果</th>
							</tr>
							<c:forEach items = "${pageItems}" var = "item">
							          <tr>
							              <td>
							              <c:choose>
								               <c:when test="${item.item_status == 0}">
								                                                          无
								               </c:when>
								               <c:otherwise>
								                                                         有
								               </c:otherwise>
							               </c:choose>
							              </td>							            
							              <td>${item.item_department}</td>
							              <td>${item.item_first_author}</td>							         
							              <td>							            
							                  
									          ${item.item_second_author}                               
									               
							              </td>							            
							              <td>
							                   <c:choose>
									               <c:when test="${item.item_third_author == '第三作者'}">
									                                                          无
									               </c:when>
									               <c:otherwise>
									                          ${item.item_third_author}                               
									               </c:otherwise>
							                   </c:choose>     
							              </td>
							            
							              <td>${item.item_title}</td>
							              <td>${item.item_fund_num}</td>
							              <td>${item.item_from}</td>
							              <td>${item.item_rank}</td>
							              <td>${item.item_state}</td>
							              <td>${item.item_funds}</td>
							              <td>${item.item_start_date}</td>
							              <td>${item.item_end_date}</td>
							              <td>${item.item_remark}</td>
							              <td><a href='<%=request.getContextPath() %>/tea_item/modify?item_title=${item.item_title}'>修改</a></td>
							              <td><a href='<%=request.getContextPath() %>/tea_item_check_result/index?item_title=${item.item_title}'>审核结果</a></td>
							          </tr>                                                   
                            </c:forEach>
							
					  </table>
					  
					
					
					       
					
		
					       <a href="<%=request.getContextPath() %>/tea_item/search?which=pre">上一页</a>
					 
					       <a href="<%=request.getContextPath() %>/tea_item/search?which=next">下一页</a>
					  
					 
					  
		   </div>					
     </div>
</body>
</html>