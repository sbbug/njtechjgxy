<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>专利申报审核界面</title>
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
           <em>专利填报审核</em>  
           
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
							    <th>其他成员</th>
							    <th>专利类别</th>
							    <th>专利名称</th>
							    <th>专利号</th>							  							   
							    <th>备注信息</th>						 						   							   
							    <th>下载</th>
							    <th>审核</th>
							</tr>
							<c:forEach items = "${pagePatents}" var = "patent">
							          <tr>
							              <td>
							              <c:choose>
								               <c:when test="${patent.patent_status == 0}">
								                                                          无
								               </c:when>
								               <c:otherwise>
								                                                         有
								               </c:otherwise>
							               </c:choose>
							              </td>	
							               <td>							            
							                  
									          ${patent.patent_department}                               
									               
							              </td>							            
							              <td>${patent.patent_first_author}</td>
							              <td>
							              ${patent.patent_second_author}
							              </td>							         
							             
							              <td>${patent.patent_third_author}</td>	
							              <td>${patent.patent_other_author}</td>						            
							              <td>${patent.patent_class}</td>
							               <td>${patent.patent_title}</td>
							             
							              
							              <td>${patent.patent_num}</td>
							               <td>${patent.patent_remark}</td>
							            						             						           
							              <td><a href='<%=request.getContextPath() %>/admin_patent/download_data?patent_path=${patent.patent_path}'>下载</a></td>
							              <td><a href='<%=request.getContextPath() %>/admin_patent/get_patent_check?patent_title=${patent.patent_title}&teacher_num=${patent.teacher_num}'>审核结果</a></td>
							          </tr>                                                   
                            </c:forEach>
							
					  </table>
					  															       			
					       <a href="<%=request.getContextPath() %>/admin_patent/show_patent?which=pre">上一页</a>				 
					       <a href="<%=request.getContextPath() %>/admin_patent/show_patent?which=next">下一页</a>
					  
					 
					  
		   </div>					
     </div>
</body>
</html>