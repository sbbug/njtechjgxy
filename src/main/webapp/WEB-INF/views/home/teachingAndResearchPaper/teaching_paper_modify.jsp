<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教研论文修改界面</title>
<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/jQuery.js"></script>
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
       <h2>科研论文修改</h2>
		   <form class="form-inline" method="post" action="<%=request.getContextPath() %>/teaching_paper/modify_save_paper" enctype ="multipart/form-data">
		            <div class="table-responsive">
					  <table class="table">
					  
							<tr class="active">
							     <td><label class="radio">材料：     </label></td>
							     <td> 
							        <label class="radio">
				                       <input type="radio" name="paper_status" value="1" >有
				                    </label>
								    <label class="radio">
								      <input type="radio" name="paper_status" value="0">无
								    </label>
								     <c:choose>
								               <c:when test="${teachingPaper.paper_status == 1}">
								                       <script>
								                       $("input[name='paper_status']").get(0).checked=true
								                       </script>
								               </c:when>
								               <c:otherwise>
								                       <script>
								                       $("input[name='paper_status']").get(1).checked=true
								                       </script>                              
								               </c:otherwise>
							         </c:choose>
								 </td>
								 <td></td>
								  <td></td>
							</tr>
							
							<tr class="active">
							      <td> <label class="radio">系别：     </label></td>
							       
							      
							      <td>
							            <!-- 下面的数据采用动态提取 -->
				                     <select id="static_dropdown_1" name="paper_department" class="form-control">
				                         <c:forEach items = "${departs}" var = "depart">
                                                    <c:if test="${depart.depart_status != 0}">
                                                          <option value="${depart.depart_item}">${depart.depart_item}</option>
                                                    </c:if>
                                                    
                                         </c:forEach>
                                     </select>
                                     <script>
                                     $("#static_dropdown_1").val('${teachingPaper.paper_department}');
                                     </script>
							      </td>
							      <td></td>
							      <td></td>
							</tr>
                            <tr class="active">
							      <td>
							           <label for="exampleInputName2">第一作者</label>
							      </td>
							      <td>
							           <input type="text" name = "paper_first_author" value="${teachingPaper.paper_first_author}" class="form-control"  placeholder="姓名">
							      </td>
							      <td>
							            <label for="exampleInputName2">第一作者单位</label>
							      </td>
							      <td>      
							            <input type="text" name="paper_first_author_unit" value="${teachingPaper.paper_first_author_unit}" class="form-control"  placeholder="单位">
							      </td>
							</tr>
							<tr class="active">
							      <td>
							           <label for="exampleInputName2">第二作者</label>
							      </td>
							      <td>
							           <input type="text" name="paper_second_author" value="${teachingPaper.paper_second_author}" class="form-control"  placeholder="姓名">
							      </td>
							      <td>
							            <label for="exampleInputName2">第二作者单位</label>
							      </td>
							      <td>      
							            <input type="text" name="paper_second_author_unit" value="${teachingPaper.paper_second_author_unit}" class="form-control"  placeholder="单位">
							      </td>
							</tr>
							<tr class="active">
							      <td>
							           <label for="exampleInputName2">第三作者</label>
							      </td>
							      <td>
							           <input type="text" value="第三作者" name="paper_third_author" value="${teachingPaper.paper_third_author}" class="form-control"  placeholder="姓名">
							      </td>
							      <td>
							            <label for="exampleInputName2">第三作者单位</label>
							      </td>
							      <td>      
							            <input type="text" value="第三作者单位" name="paper_third_author_unit" value="${teachingPaper.paper_third_author_unit}" class="form-control"  placeholder="单位">
							      </td>
							</tr>
							<tr class="active">
							      <td>
							          
							      </td>
							      <td>
							           
							      </td>
							      <td>
							            
							      </td>
							      <td>      
							            <label for="exampleInputName2">更多作者</label>
							      </td>
							</tr>
							<tr class="active">
							      <td>
							            <label for="exampleInputName2">论文题目</label>  
							      </td>
							      
							      <td>
							            <input type="text" name="paper_title" value="${teachingPaper.paper_title}" class="form-control"  placeholder="论文名称">
							      </td>
							      <td></td>
							      <td>
							      </td>
							</tr>
							<tr class="active">
							      <td>
							            <label for="exampleInputName2">期刊名称</label>  
							      </td>
							      
							      <td>
							            <input type="text" name="paper_period" value="${teachingPaper.paper_period}" class="form-control"  placeholder="期刊名称">
							      </td>
							      <td></td>
							      <td>
							      </td>
							</tr>
							<tr class="active">
							     <td>
							           <label for="exampleInputName2">期刊卷号</label>
							      </td>
							      <td>
							           <input type="text" name="paper_period_roll" value="${teachingPaper.paper_period_roll}" class="form-control"  placeholder="期刊卷号">
							      </td>
							      <td>
							            <label for="exampleInputName2">期刊页号</label>
							      </td>
							      <td>      
							            <input type="text" name="paper_period_page" value="${teachingPaper.paper_period_page}" class="form-control"  placeholder="期刊页号">
							      </td>
							</tr>
							<tr class="active">
							   <td> <label class="radio">学校计点类别：     </label></td>
							       
							      <td>
							            <!-- 下面的数据采用动态提取 -->
				                     <select id="static_dropdown_2" name="paper_department_kind" class="form-control">
									    <option value="1">院期刊库</option>
									    <option value="2">北大核心期刊库</option>
									    <option value="3">SCD库</option>
									    <option value="4">CSSCI库</option>
									    <option value="5">SCI库</option>
									    <option value="6">SSCI库</option>
									    
						   
                                     </select>
                                      <script>
                                     $("#static_dropdown_2").val('${teachingPaper.paper_department_kind}');
                                     </script>
							      </td>
							      <td></td>
							      <td></td>
							</tr>
							
                            <tr class="active">
							      <td> 
							         <label class="radio">材料上传(请以.zip格式上传): </label>
							      </td>
							       
							      <td>  
				                     <input type="file" name="upfile">
							      </td>
							      <td></td>
							      <td></td>
							</tr> 
							
					  </table>
					</div>
                                  <!-- 表单隐藏域 -->
							     <input type="hidden" name="paper_id" value="${teachingPaper.paper_id}">
		          <p>
		          <button type="submit" class="btn btn-info" onclick="return CheckFile(this.form)">确认修改</button>
		   </form>
		   ${result}
		   <script type="text/javascript">
		    
		       function CheckFile(form){
		    	   
		    	   //alert(form.paper_id.value);
		    	   
		    	   if(form.upfile.value==""){
		    		   alert("请上传审核资料");    		  
		    		   return false;
		    	   }     	   
    	           return true;
		       }			  
		   </script>
		   
   </div>
</body>
</html>