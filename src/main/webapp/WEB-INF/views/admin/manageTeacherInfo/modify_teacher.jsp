<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教师基本信息修改</title>
<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/jQuery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/bootstrap-datetimepicker.zh-CN.js"></script>
<style type="text/css">
    .main{
       text-align:center;
       border:10px;
       font-weight:bold;
     
       margin-left:20%;
       margin-right:20%;
       margin-top:0%;
    }
</style>
</head>
<body>
   <div class="main">
       <h2>教师基本信息修改</h2>
		   <form class="form-inline" method="post" action="<%=request.getContextPath() %>/admin_manage/save_teacher">
		            <div class="table-responsive">
					  <table class="table">
					  
							<tr class="active">
							      <td>
							           <label for="exampleInputName2">教师账号</label>
							      </td>
							      <td>
							           <input type="text" name = "teacher_num" value = "${teacher.teacher_num}" class="form-control"  placeholder="教师账号">
							      </td>
							      
							</tr>
							<tr class="active">
							     
							      <td> <label class="radio">系别：     </label></td>
							       
							      
							      <td>
							            <!-- 下面的数据采用动态提取 -->
				                     <select id="static_dropdown_1" name="teacher_department" class="form-control">
				                         <c:forEach items = "${departs}" var = "depart">
                                                    <c:if test="${depart.depart_status != 0}">
                                                          <option value="${depart.depart_item}">${depart.depart_item}</option>
                                                    </c:if>
                                                    
                                         </c:forEach>
                                     </select>
                                      <script>
                                        $("#static_dropdown_1").val('${teacher.teacher_department}');
                                       </script>
							      </td>
							     
							</tr>
							<tr class="active">
							      <td>
							           <label for="exampleInputName2">姓名</label>
							      </td>
							      <td>
							           <input type="text" name = "teacher_name" value="${teacher.teacher_name}" class="form-control"  placeholder="姓名">
							      </td>
							      
							</tr>
							<tr class="active">
							    
							     <td><label class="radio">性别：     </label></td>
							     <td> 
							        <label class="radio">
				                       <input type="radio" name="teacher_sex" value="男" checked>男
				                    </label>
								    <label class="radio">
								      <input type="radio" name="teacher_sex" value="女">女
								    </label>
								     <c:choose>
								               <c:when test="${teacher.teacher_sex == '男'}">
								                       <script>
								                       $("input[name='teacher_sex']").get(0).checked=true
								                       </script>
								               </c:when>
								               <c:otherwise>
								                       <script>
								                       $("input[name='teacher_sex']").get(1).checked=true
								                       </script>                              
								               </c:otherwise>
							         </c:choose>
								 </td>
								 
							</tr>
							
                            
							<tr class="active">
							      <td>
							           <label for="exampleInputName2">籍贯</label>
							      </td>
							      <td>
							           <input type="text" name="teacher_address" value = "${teacher.teacher_address} "class="form-control"  placeholder="籍贯">
							      </td>
							     
							</tr>
							<tr class="active">
							      <td>
							           <label for="exampleInputName2">身份证号</label>
							      </td>
							      <td>
							           <input type="text"  name="teacher_ID_Card" value="${teacher.teacher_ID_Card}" class="form-control"  placeholder="ID">
							      </td>
							     
							</tr>
							
							<tr class="active">
							      <td>
							            <label for="exampleInputName2">出生日期</label>  
							      </td>
							      
							      <td>
							            <input type="text" id = "teacher_birthday" name="teacher_birthday" value="${teacher.teacher_birthday}" class="form-control"  placeholder="出生日期">
							      </td>
							      
							</tr>
							<tr class="active">
							      <td>
							            <label for="exampleInputName2">最后学历</label>  
							      </td>
							      
							      <td>
							            <input type="text" name="teacher_education" value="${teacher.teacher_education}" class="form-control"  placeholder="最后学历">
							      </td>
							    
							</tr>
							<tr class="active">
							     <td>
							           <label for="exampleInputName2">现在职称</label>
							      </td>
							      <td>
							           <input type="text" name="teacher_title" value="${teacher.teacher_title}" class="form-control"  placeholder="现在职称">
							      </td>
							    
							</tr>
							<tr class="active">
							    
							     <td><label class="radio">账号状态：     </label></td>
							     <td> 
							        <label class="radio">
				                       <input type="radio" name="teacher_status" value="1" checked>启用
				                    </label>
								    <label class="radio">
								      <input type="radio" name="teacher_status" value="0">禁用
								    </label>
								     <c:choose>
								               <c:when test="${teacher.teacher_status == 1}">
								                       <script>
								                       $("input[name='teacher_status']").get(0).checked=true
								                       </script>
								               </c:when>
								               <c:otherwise>
								                       <script>
								                       $("input[name='teacher_status']").get(1).checked=true
								                       </script>                              
								               </c:otherwise>
							         </c:choose>
								 </td>
								 
							</tr>
							<tr class="active">
							      <td> 
							            <label for="exampleInputName2">备注</label>
							      </td>
							       
							      <td colspan="3">
							           <textarea  id = "textarea" name = "teacher_remark" class="form-control" >
							              ${teacher.teacher_remark}
							           </textarea>
							           <script>
                                            document.getElementById("textarea").value='';
                                       </script>
							      </td>
							     
							      
							</tr>
							
                           
							     
					  </table>
					</div>
   
		          <p>
		          <button type="submit" class="btn btn-info" onClick="return confirm()">确认提交</button>
		   </form>
		   ${result}
		   <script>
		       
		      
		       function confirm(){
		    	   //数据输入是否为空进行验证
		    	   var flag = 0; 
		    	  $("input[type=text]").each(function(i){
		    		   
					    var text = $(this).val();
					    if(text == ""){
					        alert("信息填写不完整");
					        flag=1;
					    }					  					    
					});
		    	   
		    	   if(flag==1) return false;
		    	   
		    	   return true;
		       }
		   
		   </script>
		   <script type="text/javascript">  
		      $('#teacher_birthday').datetimepicker({  
		        format: 'yyyy-mm-dd',//定义时间格式  
		        autoclose: true,//选择好自动关闭  
		        minView: 2,//只选择到小时  
		        language: 'zh-CN', //汉化   
		      });  
		     
		    </script>  
		  
   </div>
</body>
</html>