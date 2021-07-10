<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>成果信息修改</title>
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
       border:5px solid gray;
       margin-left:10%;
       margin-right:10%;
       margin-top:0%;
    }
</style>

</head>
<body>
   <div class="main">
       <h2>成果信息修改</h2>
		   <form class="form-inline" method="post" action="<%=request.getContextPath() %>/tea_achievement/modify_save_achieve" enctype ="multipart/form-data">
		            <div class="table-responsive">
					  <table class="table">
					  
							<tr class="active">
							     <td><label class="radio">材料：     </label></td>
							     <td> 
							        <label class="radio">
				                       <input type="radio" name="achieve_status" value="1">有
				                    </label>
								    <label class="radio">
								      <input type="radio" name="achieve_status" value="0">无
								    </label>
								     <c:choose>
								               <c:when test="${achieve.achieve_status == 1}">
								                       <script>
								                       $("input[name='achieve_status']").get(0).checked=true
								                       </script>
								               </c:when>
								               <c:otherwise>
								                       <script>
								                       $("input[name='achieve_status']").get(1).checked=true
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
				                     <select id="static_dropdown_1" name="achieve_department" class="form-control">
				                         <c:forEach items = "${departs}" var = "depart">
                                                    <c:if test="${depart.depart_status != 0}">
                                                          <option value="${depart.depart_item}">${depart.depart_item}</option>
                                                    </c:if>
                                                    
                                         </c:forEach>
                                     </select>
                                       <script>
                                        $("#static_dropdown_1").val('${achieve.achieve_department}');
                                       </script>
							      </td>
							      <td></td>
							      <td></td>
							</tr>
							
                            <tr class="active">
							      <td>
							           <label for="exampleInputName2">教师名字</label>
							      </td>
							      <td>
							           <input type="text"  value="${achieve.achieve_teacher_name}" name = "achieve_teacher_name" class="form-control"  placeholder="姓名">
							      </td>
							      <td>
							           
							      </td>
							      <td>      
							           
							      </td>
							</tr>
							<tr class="active">
							      <td>
							           <label for="exampleInputName2">论文竞赛名称</label>
							      </td>
							      <td>
							           <input type="text" name="achieve_title" value="${achieve.achieve_title}" class="form-control"  placeholder="名称">
							      </td>
							      <td>
							           <label for="exampleInputName2">项目所属类别</label>
							      </td>
							      <td>      
							             <input type="text"  name="achieve_class" value="${achieve.achieve_class}" class="form-control"  placeholder="类别">
							      </td>
							</tr>						
							<fmt:formatDate value="${achieve.achieve_get_time}" pattern="yyyy-MM-dd" var="date" />
							<tr class="active">
							      <td>
							            <label for="exampleInputName2">发奖单位</label>  
							      </td>
							      
							      <td>
							            <input type="text" name="achieve_unit_awards" value="${achieve.achieve_unit_awards}" class="form-control"  placeholder="单位">
							      </td>
							      <td>
							              <label for="exampleInputName2">获奖时间</label>  
							      </td>
							      <td>
							               
							              <input type="text"  name="achieve_get_time" value="${date}" class="form-control"  placeholder="时间">
							              
							      </td>
							</tr>
							
							<tr class="active">
							     <td>
							           <label for="exampleInputName2">获奖级别</label>
							      </td>
							      <td>
							                 <!-- 下面的数据采用动态提取 -->
				                     <select id="static_dropdown_2" name="achieve_rank" class="form-control">
									    <option value="国家级">国家级</option>
									    <option value="省级">省级</option>	
									   	<option value="校级">校级</option>								   														   
                                     </select>
                                     <script>
                                        $("#static_dropdown_2").val('${achieve.achieve_rank}');
                                       </script>
							      </td>
							      <td>
							           <label for="exampleInputName2">成果属性</label>
							      </td>
							      <td>      
							           <select id="static_dropdown_3" name="achieve_which" class="form-control">
									    <option value="教学">教学</option>
									    <option value="科研">科研</option>	
									   								   														   
                                     </select>
                                      <script>
                                        $("#static_dropdown_3").val('${achieve.achieve_which}');
                                       </script>
							      </td>
							</tr>
							<tr class="active">
							      <td> 
							            <label for="exampleInputName2">成果备注</label>
							      </td>
							       
							      <td colspan="3">
							           <textarea   id="achieve_remark" name = "achieve_remark"  class="form-control" >
							              
							           </textarea>
							          
							          <script>
							               document.getElementById("achieve_remark").value=${achieve.achieve_remark};
                                      </script>
							      </td>
							     
							      
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
                         <input type="hidden" name="achieve_id" value="${achieve.achieve_id}">
		          <p>
		          <button type="submit" class="btn btn-info" onClick="return confirm(this.form)">确认提交</button>
		   </form>
		   ${result}
		   <script>
		       function confirm(form){
		    	   //数据输入是否为空进行验证
		    	   
		    	   if(form.achieve_status.value==""){
		    		   alert("请勾选材料是否为空");
		    		   return false;   
		    	   }		    	  		    	 
		    	     	  
		    	   if(form.achieve_teacher_name.value==""){
		    		   alert("请填写教师姓名");
		    		   return false;
		    	   }
		    	   if(form.achieve_title.value==""){
		    		   alert("请填写项目名称");	    		  
		    		   return false;
		    	   }
		    	  
		    	   if(form.achieve_class.value==""){
		    		   alert("请填写项目所属类别"); 
		    		   return false;
		    	   }	
		    	 
		    	   if(form.achieve_unit_awards.value==""){
		    		   alert("请填写发奖单位");	    		  
		    		   return false;
		    	   }		    	  
		    	   if(form.achieve_get_time.value==""){
		    		   alert("请填写获奖时间");	    		  
		    		   return false;
		    	   }
		    	  
		    	   if(form.upfile.value==""){
		    		   alert("请上传审核资料");    		  
		    		   return false;
		    	   }     	   
		    	   return true;
		       }
		   
		   </script>
		
		    <script type="text/javascript">  
		      $('#achieve_get_time').datetimepicker({  
		        format: 'yyyy-mm-dd',//定义时间格式  
		        autoclose: true,//选择好自动关闭  
		        minView: 2,//只选择到小时  
		        language: 'zh-CN', //汉化   
		      });  
		     
		    </script>  
		  
        
   </div>
</body>
</html>