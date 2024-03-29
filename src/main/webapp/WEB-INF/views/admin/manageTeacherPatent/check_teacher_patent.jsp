<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>专利申请审核</title>
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
       <h2>书籍申报审核</h2>
		   <form class="form-inline" method="post" action="<%=request.getContextPath() %>/admin_patent/save_result" >
		            <div class="table-responsive">
					  <table class="table">
					        <tr class="active">
							     <td>
							           <label for="exampleInputName2">总金额</label>
							      </td>
							      <td>
							           <input type="text" name="result_rewards" class="form-control" value="${patentCheckResult.result_rewards}"  placeholder="总金额">
							      </td>
							      <td>
							           
							      </td>
							      <td>      
							           
							      </td>
							</tr>
							<tr class="active">
							     <td>
							           <label for="exampleInputName2">学院奖励金额</label>
							      </td>
							      <td>
							           <input type="text" name="result_reward_from_depart" class="form-control" value="${patentCheckResult.result_reward_from_depart}"  placeholder="学院奖励金额">
							      </td>
							      <td>
							           
							      </td>
							      <td>      
							           
							      </td>
							</tr> 
					  																			
							<tr class="active">
							     <td><label class="radio">审核状态：     </label></td>
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
								               <c:when test="${patentCheckResult.result_is_ok== 1}">
								                       <script>
								                       $("input[name='result_is_ok']").get(0).checked=true;
								                       </script>
								               </c:when>
								               <c:when test="${patentCheckResult.result_is_ok== 2}">
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
								  <td>
								    
								  </td>
							</tr>							                          																	
							<tr class="active">
							      <td>
							            <label for="exampleInputName2">专利名称</label>  
							      </td>
							      
							      <td>
							            <input type="text" name="patent_title" value="${patentCheckResult.patent_title}" class="form-control"  placeholder="专利名称">
							      </td>
							      <td></td>
							      <td>
							      </td>
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
                    <input type="hidden" name="teacher_num" value="${patentCheckResult.teacher_num}" class="form-control" >
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