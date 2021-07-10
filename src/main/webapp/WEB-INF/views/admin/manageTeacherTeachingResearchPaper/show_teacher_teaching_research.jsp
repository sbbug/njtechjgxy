<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/jQuery.js"></script>
<title>教研论文审核界面</title>
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
           <em>教研论文审核界面</em>  
           <div class="right">
	             <form action="<%=request.getContextPath() %>/tea_paper/search_by_title" method="post" >
	                   <input type="text" name ="paper_title"  placeholder="输入论文题目">
	                   <input type="hidden" name="which" value="search">
	                   <button type="submit" class="btn btn-info">搜索</button> 
	             </form> 
           </div>
           <p><p>
           <p><p>
           <div class="table-responsive">
					  <table class="table">
							<tr class="success">
							    <th>教师</th>
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
							    <th>材料</th>							   
							    <th>审核</th>
							</tr>
							<c:forEach items = "${pagePapers}" var = "paper">
							          <tr>
							             <td><a href='<%=request.getContextPath() %>/admin_paper/modify_teaching_paper?teacher_num=${paper.teacher_num}'>${paper.teacher_num}</a></td>
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
							              <td>
								               <c:choose>
										               <c:when test="${paper.paper_department_kind == '1'}">
										                                                          院期刊库
										               </c:when>
										               <c:when test="${paper.paper_department_kind == '2'}">
										                                                          北大核心期刊库
										               </c:when>
										               <c:when test="${paper.paper_department_kind == '3'}">
										                      SCD库
										               </c:when>
										               <c:when test="${paper.paper_department_kind == '4'}">
										                      CSSCI库
										               </c:when>
										               <c:when test="${paper.paper_department_kind == '5'}">
										                       SCI库
										               </c:when>
										               <c:otherwise>
										                       SSCI库                                 
										               </c:otherwise>
								                   </c:choose> 
							              </td>
							              <td><a href='<%=request.getContextPath() %>/admin_teaching_paper/download_data?paper_path=${paper.paper_path}'>下载</a></td>
							              <td><a href='<%=request.getContextPath() %>/admin_teaching_paper/get_paper_check?paper_title=${paper.paper_title}&teacher_num=${paper.teacher_num}'>审核</a></td>
							          </tr>                                                   
                            </c:forEach>
							
					  </table>
					  														       					
					       <a href="<%=request.getContextPath() %>/admin_teaching_paper/show_teaching_paper?which=pre">上一页</a>					 
					       <a href="<%=request.getContextPath() %>/admin_teaching_paper/show_teaching_paper?which=next">下一页</a>
					  
					 
					  
		   </div>					
     </div>
</body>
</html>