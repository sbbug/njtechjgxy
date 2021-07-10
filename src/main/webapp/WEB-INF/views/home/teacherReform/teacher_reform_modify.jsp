<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教学教改信息修改界面</title>
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
       <h2>教学教改信息修改提交</h2>
		   <form class="form-inline" method="post" action="<%=request.getContextPath() %>/tea_reform/modify_save_reform" enctype ="multipart/form-data">
		            <div class="table-responsive">
					  <table class="table">
					  
							<tr class="active">
							     <td><label class="radio">材料：     </label></td>
							     <td> 
							        <label class="radio">
				                       <input type="radio" name="reform_status" value="1">有
				                    </label>
								    <label class="radio">
								      <input type="radio" name="reform_status" value="0">无
								    </label>
								     <c:choose>
								               <c:when test="${reform.reform_status == 1}">
								                       <script>
								                       $("input[name='reform_status']").get(0).checked=true
								                       </script>
								               </c:when>
								               <c:otherwise>
								                       <script>
								                       $("input[name='reform_status']").get(1).checked=true
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
				                     <select id="static_dropdown_1" name="reform_department" class="form-control">
				                         <c:forEach items = "${departs}" var = "depart">
                                                    <c:if test="${depart.depart_status != 0}">
                                                          <option value="${depart.depart_item}">${depart.depart_item}</option>
                                                    </c:if>
                                                    
                                         </c:forEach>
                                     </select>
                                     <script>
                                        $("#static_dropdown_1").val('${reform.reform_department}');
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
							           <input type="text" name = "reform_first_author" value="${reform.reform_first_author}" class="form-control"  placeholder="姓名">
							      </td>
							      <td>
							            <label for="exampleInputName2">第二作者</label>
							      </td>
							      <td>      
							            <input type="text" name="reform_second_author" value="${reform.reform_second_author}" class="form-control"  placeholder="姓名">
							      </td>
							</tr>
							<tr class="active">
							      <td>
							           <label for="exampleInputName2">第三作者</label>
							      </td>
							      <td>
							           <input type="text" name="reform_third_author" value="${reform.reform_third_author}" class="form-control"  placeholder="姓名">
							      </td>
							      <td>
							            <label for="exampleInputName2">其他作者</label>
							      </td>
							      <td>      
							            <input type="text" name="reform_other_author" value="${reform.reform_other_author}" class="form-control"  placeholder="单位">
							      </td>
							</tr>
							
							
							<tr class="active">
							      <td>
							            <label for="exampleInputName2">项目名称</label>  
							      </td>
							      
							      <td>
							            <input type="text" name="reform_title" value="${reform.reform_title}" class="form-control"  placeholder="项目名称">
							      </td>
							      <td>
							            <label for="exampleInputName2">发奖单位</label> 
							      </td>
							      <td>
							             <input type="text" name="reform_give_reward_unit" value="${reform.reform_give_reward_unit}" class="form-control"  placeholder="期刊名称">
							      </td>
							</tr>
							
							<tr class="active">
							     <td>
							           <label for="exampleInputName2">级别</label>
							      </td>
							      <td>
							                   <!-- 下面的数据采用动态提取 -->
				                     <select id="static_dropdown_2" name="reform_rank" class="form-control">
									    <option value="国家级">国家级</option>
									    <option value="省级">省级</option>	
									   	<option value="校级">校级</option>								   														   
                                     </select>
                                      <script>
                                        $("#static_dropdown_2").val('${reform.reform_rank}');
                                       </script>
							      </td>
							      <td>
							            <label for="exampleInputName2">金额</label>
							      </td>
							      <td>      
							            <input type="text" name="reform_money" value="${reform.reform_money}" class="form-control"  placeholder="金额">
							      </td>
							</tr>
							<fmt:formatDate value="${reform.reform_start_date}" pattern="yyyy-MM-dd" var="start_date" />
							<fmt:formatDate value="${reform.reform_end_date}" pattern="yyyy-MM-dd" var="end_date" />
							<tr class="active">
							      <td> 
							         <label class="radio">开始时间 </label>
							      </td>
							       
	                              <td>						     
							          <input id="datetimepicker_start" type="text" name="reform_start_date" value="${start_date}" class="form-control" class="form_datetime" placeholder="开始时间"> 
							      </td>
							    
							      <td>
							           <label class="radio">结束时间 </label>
							      </td>
							      <td>
							          <input id="datetimepicker_end" type="text" name="reform_end_date" value="${end_date}"class="form-control" class="form_datetime" placeholder="结束时间"> 
							      </td>
							</tr>
							<tr class="active">
							      <td> 
							            <label for="exampleInputName2">成果备注</label>
							      </td>
							       
							      <td colspan="3">
							           <textarea  name = "reform_remark" value="${reform.reform_remark}" class="form-control" >
							           
							           </textarea>
							           
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
   
		          <p>
		          <button type="submit" class="btn btn-info" onClick="return confirm(this.form)">确认提交</button>
		   </form>
		   ${result}
		   <script>
		       function confirm(form){
		    	   //数据输入是否为空进行验证
		    	   
		    	   if(form.reform_status.value==""){
		    		   alert("请勾选材料是否为空");
		    		   return false;   
		    	   }
		    	   		    	 		    	 
		    	   if(form.reform_first_author.value==""){
		    		   alert("第一作者信息必填");
		    		   return false;
		    	   }
		    	  
		    	   if(form.reform_title.value==""){
		    		   alert("请填写项目题目"); 
		    		   return false;
		    	   }
		    	   if(form.reform_give_reward_unit.value==""){
		    		   alert("请填写发奖单位");		    		  
		    		   return false;
		    	   }
		    	   if(form.reform_money.value==""){
		    		   alert("请填写金额");		    		  
		    		   return false;
		    	   }
		    	   if(form.reform_start_date.value==""){
		    		   alert("请填写开始时间");		    		 
		    		   return false;
		    	   }
		    	   if(form.reform_end_date.value==""){
		    		   alert("请填写结束时间");	    		  
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
		      $('#datetimepicker_start').datetimepicker({  
		        format: 'yyyy-mm-dd',//定义时间格式  
		        autoclose: true,//选择好自动关闭  
		        minView: 2,//只选择到小时  
		        language: 'zh-CN', //汉化   
		      });  
		      $('#datetimepicker_end').datetimepicker({  
			        format: 'yyyy-mm-dd',//定义时间格式  
			        autoclose: true,//选择好自动关闭  
			        minView: 2,//只选择到小时  
			        language: 'zh-CN', //汉化   
			      });  
		    </script>  
   </div>
</body>
</html>