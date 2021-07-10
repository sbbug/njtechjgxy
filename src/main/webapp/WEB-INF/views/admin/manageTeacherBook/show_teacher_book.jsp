<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>书籍填报搜索界面</title>
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
           <em>书籍填报搜索</em>  
           
           <p><p>
           <p><p>
           <div class="table-responsive">
					  <table class="table">
							<tr class="success">
							    <th>材料</th>						   
							    <th>著作类别</th>
							    <th>版权类别</th>							  
							    <th>院系</th>
							    <th>第一作者</th>
							    <th>第二作者</th>							  
							    <th>第三作者</th>							   
							    <th>书籍名称</th>
							    <th>出版社名字</th>
							    <th>出版时间</th>
							    <th>字数</th>
							    <th>书籍类型</th>
							    <th>备注</th>							   
							    <th>下载</th>
							    <th>审核</th>
							</tr>
							<c:forEach items = "${pageBooks}" var = "book">
							          <tr>
							              <td>
							              <c:choose>
								               <c:when test="${book.book_status == 0}">
								                                                          无
								               </c:when>
								               <c:otherwise>
								                                                         有
								               </c:otherwise>
							               </c:choose>
							              </td>							            
							              <td>${book.book_category_class}</td>
							              <td>${book.book_copyright_type}</td>							         
							              <td>							            
							                  
									          ${book.book_department}                               
									               
							              </td>	
							              <td>${book.book_first_author}</td>	
							              <td>${book.book_second_author}</td>						            
							              <td>
							                   <c:choose>
									               <c:when test="${book.book_third_author == '第三作者'}">
									                                                          无
									               </c:when>
									               <c:otherwise>
									                          ${book.book_third_author}                               
									               </c:otherwise>
							                   </c:choose>     
							              </td>
							            
							              <td>${book.book_name}</td>
							              <td>${book.book_press_name}</td>
							              <td>${book.book_publish_date}</td>
							              <td>${book.book_words}</td>
							              <td>${book.book_which}</td>
							              <td>${book.book_remark}</td>							           
							              <td><a href='<%=request.getContextPath() %>/admin_book/download_data?book_path=${book.book_path}'>下载</a></td>
							              <td><a href='<%=request.getContextPath() %>/admin_book/get_book_check?book_name=${book.book_name}&teacher_num=${book.teacher_num}'>审核</a></td>
							          </tr>                                                   
                            </c:forEach>
							
					  </table>
					  															       			
					       <a href="<%=request.getContextPath() %>/admin_book/show_book?which=pre">上一页</a>
					 
					       <a href="<%=request.getContextPath() %>/admin_book/show_book?which=next">下一页</a>
					  
					 
					  
		   </div>					
     </div>
</body>
</html>