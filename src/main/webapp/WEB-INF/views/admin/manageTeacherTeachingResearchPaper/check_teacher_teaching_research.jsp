<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教研论文审核</title>
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
       <h2>教研论文审核</h2>
		   <form class="form-inline" method="post" action="<%=request.getContextPath() %>/admin_teaching_paper/save_result" >
		            <div class="table-responsive">
					  <table class="table">
					  
							<tr class="active">
							     <td><label class="radio">北大核心${paperCheckResult.is_in_peking}：     </label></td>
							     <td> 
							        <label class="radio">
				                       <input type="radio" name="is_in_peking" value="1">有
				                    </label>
								    <label class="radio">
								      <input type="radio" name="is_in_peking" value="0">无
								    </label>
								     <c:choose>
								               <c:when test="${teachingPaperCheckResult.is_in_peking == 1}">
								                       <script>
								                       $("input[name='is_in_peking']").get(0).checked=true;
								                       </script>
								               </c:when>
								               <c:otherwise>
								                       <script>
								                       $("input[name='is_in_peking']").get(1).checked=true;
								                       </script>                              
								               </c:otherwise>
							         </c:choose>
								 </td>
								 <td>
								     <label class="radio">SCD：     </label>
								 </td>
								  <td>
								     <label class="radio">
				                       <input type="radio" name="is_in_scd" value="1">有
				                    </label>
								    <label class="radio">
								      <input type="radio" name="is_in_scd" value="0">无
								    </label>
								     <c:choose>
								               <c:when test="${teachingPaperCheckResult.is_in_scd== 1}">
								                       <script>
								                       $("input[name='is_in_scd']").get(0).checked=true;
								                       </script>
								               </c:when>
								               <c:otherwise>
								                       <script>
								                       $("input[name='is_in_scd']").get(1).checked=true;
								                       </script>                              
								               </c:otherwise>
							         </c:choose>
								  </td>
							</tr>
							<tr class="active">
							     <td><label class="radio">SSCI：     </label></td>
							     <td> 
							        <label class="radio">
				                       <input type="radio" name="is_in_ssci" value="1">有
				                    </label>
								    <label class="radio">
								      <input type="radio" name="is_in_ssci" value="0">无
								    </label>
								    <c:choose>
								               <c:when test="${teachingPaperCheckResult.is_in_ssci== 1}">
								                       <script>
								                       $("input[name='is_in_ssci']").get(0).checked=true;
								                       </script>
								               </c:when>
								               <c:otherwise>
								                       <script>
								                       $("input[name='is_in_ssci']").get(1).checked=true;
								                       </script>                              
								               </c:otherwise>
							         </c:choose>
								 </td>
								 <td>
								   <label class="radio">院期刊库：     </label>
								 </td>
								  <td>
								    <label class="radio">
				                       <input type="radio" name="is_in_own" value="1">有
				                    </label>
								    <label class="radio">
								      <input type="radio" name="is_in_own" value="0">无
								    </label>
								     <c:choose>
								               <c:when test="${teachingPaperCheckResult.is_in_own== 1}">
								                       <script>
								                       $("input[name='is_in_own']").get(0).checked=true;
								                       </script>
								               </c:when>
								               <c:otherwise>
								                       <script>
								                       $("input[name='is_in_own']").get(1).checked=true;
								                       </script>                              
								               </c:otherwise>
							         </c:choose>
								  </td>
							</tr>
							<tr class="active">
							     <td></td>
							     <td> 
							       <label class="radio">审核状态：     </label>
								 </td>
								 <td>
								    <label class="radio">
				                       <input type="radio" name="result_is_ok" value="1">未审核
				                    </label>
								    <label class="radio">
								      <input type="radio" name="result_is_ok" value="2">通过
								    </label>
								     <label class="radio">
								      <input type="radio" name="result_is_ok" value="3">不合格
								    </label>
								     <c:choose>
								               <c:when test="${teachingPaperCheckResult.result_is_ok== 1}">
								                       <script>
								                       $("input[name='result_is_ok']").get(0).checked=true;
								                       </script>
								               </c:when>
								               <c:when test="${teachingPaperCheckResult.result_is_ok== 2}">
								                       <script>
								                       $("input[name='result_is_ok']").get(1).checked=true;
								                       </script>
								               </c:when>
								               <c:otherwise>
								                       <script>
								                       $("input[name='result_is_ok']").get(2).checked=true;
								                       </script>                              
								               </c:otherwise>
							         </c:choose>
								 </td>
								  <td>
								    
								  </td>
							</tr>
							                          																	
							<tr class="active">
							      <td>
							            <label for="exampleInputName2">论文题目</label>  
							      </td>
							      
							      <td>
							            <input type="text" name="paper_title" value="${teachingPaperCheckResult.paper_title}" class="form-control"  placeholder="论文名称">
							      </td>
							      <td></td>
							      <td>
							      </td>
							</tr>
							
							
							
							<tr class="active">
							   <td> <label class="radio">学院期刊类别: </label></td>
							       
							      <td>
							            <!-- 下面的数据采用动态提取 -->
				                     <select id="static_dropdown" name="result_level" class="form-control">
									    <option value="A+">A+</option>
									    <option value="A">A</option>
									    <option value="B">B</option>
						                <option value="C">C</option>
						                <option value="D">D</option>
                                     </select>
                                      <script>
                                      
                                     $("#static_dropdown").val('${teachingPaperCheckResult.result_level}');
                                     </script>
							      </td>
							      <td></td>
							      <td></td>
							</tr>
                           <tr class="active">
							      <td> 
							            <label for="exampleInputName2">审核留言</label>
							      </td>
							       
							      <td colspan="3">
							           <textarea  name = "result_message" class="form-control" >
							           
							           </textarea>
							           
							      </td>
							     
							      
							</tr>	
							     
					  </table>
					</div>
                    <input type="hidden" name="teacher_num" value="${teachingPaperCheckResult.teacher_num}" class="form-control" >
		          <p>
		          <button type="submit" class="btn btn-info" onClick="return check()">确认提交</button>
		   </form>
		   ${result}
		   <script>
		       function check(){
		    	   
		    	   var flag = confirm("确认提交吗");
		    	   
		    	   if(flag) return true;
                   return false; 		    	   
		       }      
		    
		   </script> 		  
		   
   </div>
</body>
</html>