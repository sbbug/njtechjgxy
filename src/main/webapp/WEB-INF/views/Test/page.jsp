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
           <em>科研论文搜索</em>  
           <p><p>
           <p><p>
           <div class="table-responsive">
					  <table class="table">
							<tr class="success">
							    <th>材料</th>
							    <th>专业</th>
							    <th>第一作者</th>
							    <th>单位</th>
							    <th>第二作者</th>
							    <th>单位</th>
							    <th>第三作者</th>
							    <th>单位</th>
							    <th>论文标题</th>
							    <th>期刊名称</th>
							    <th>卷号</th>
							    <th>页号</th>
							    <th>计点</th>
							    <th>期刊类别</th>
							   
							</tr>
							<c:forEach items = "${pagePapers}" var = "paper">
							          <tr>
							              <td>
							              <c:choose>
								               <c:when test="${paper.paper_status == 0}">
								                                                          无
								               </c:when>
								               <c:otherwise>
								                                                         有
								               </c:otherwise>
							               </c:choose>
							              </td>
							              <td>${paper.paper_department}</td>
							              <td>${paper.paper_first_author}</td>
							              <td>${paper.paper_first_author_unit}</td>
							              <td>${paper.paper_second_author}</td>
							              <td>${paper.paper_second_author_unit}</td>
							              <td>
							                   <c:choose>
									               <c:when test="${paper.paper_third_author == '第三作者'}">
									                                                          无
									               </c:when>
									               <c:otherwise>
									                          ${paper.paper_third_author}                               
									               </c:otherwise>
							                   </c:choose>     
							              </td>
							              <td>
							                   <c:choose>
									               <c:when test="${paper.paper_third_author_unit == '第三作者单位'}">
									                                                          无
									               </c:when>
									               <c:otherwise>
									                          ${paper.paper_third_author_unit}                               
									               </c:otherwise>
							                   </c:choose>             
							              </td>
							              <td>${paper.paper_title}</td>
							              <td>${paper.paper_period}</td>
							              <td>${paper.paper_period_roll}</td>
							              <td>${paper.paper_period_page}</td>
							              <td>${paper.paper_department_kind}</td>
							              <td>${paper.paper_department_count}</td>
	
							          </tr>                                                   
                            </c:forEach>
							
					  </table>
					  
					
					
					       
					
		
					       <a href="<%=request.getContextPath() %>/tea_paper/search?which=pre">上一页</a>
					 
					       <a href="<%=request.getContextPath() %>/tea_paper/search?which=next">下一页</a>
					  
					 
					  
		   </div>					
     </div>
</body>
</html>