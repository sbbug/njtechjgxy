<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>指导竞赛提交界面</title>
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
       <h2>指导竞赛信息提交</h2>
		   <form class="form-inline" method="post" action="<%=request.getContextPath() %>/tea_prize/addPrize" enctype ="multipart/form-data">
		            <div class="table-responsive">
					  <table class="table">
					  
							<tr class="active">
							     <td><label class="radio">材料：     </label></td>
							     <td> 
							        <label class="radio">
				                       <input type="radio" name="prize_status" value="1">有
				                    </label>
								    <label class="radio">
								      <input type="radio" name="prize_status" value="0">无
								    </label>
								 </td>
								 <td></td>
								  <td></td>
							</tr>
							
							<tr class="active">
							      <td> <label class="radio">系别：     </label></td>
							       
							      
							      <td>
							            <!-- 下面的数据采用动态提取 -->
				                     <select id="static_dropdown" name="prize_department" class="form-control">
				                         <c:forEach items = "${departs}" var = "depart">
                                                    <c:if test="${depart.depart_status != 0}">
                                                          <option value="${depart.depart_item}">${depart.depart_item}</option>
                                                    </c:if>
                                                    
                                         </c:forEach>
                                     </select>
							      </td>
							      <td></td>
							      <td></td>
							</tr>
                            <tr class="active">
							      <td>
							           <label for="exampleInputName2">第一成员</label>
							      </td>
							      <td>
							           <input type="text" name = "prize_member_one" class="form-control"  placeholder="姓名">
							      </td>
							      <td>
							            <label for="exampleInputName2">第二成员</label>
							      </td>
							      <td>      
							            <input type="text" name="prize_member_two" class="form-control"  placeholder="姓名">
							      </td>
							</tr>
							<tr class="active">
							      <td>
							           <label for="exampleInputName2">第三成员</label>
							      </td>
							      <td>
							           <input type="text" name="prize_member_three" class="form-control"  placeholder="姓名">
							      </td>
							      <td>
							            
							      </td>
							      <td>      
							           
							      </td>
							</tr>
							
							
							<tr class="active">
							      <td>
							            <label for="exampleInputName2">竞赛名称</label>  
							      </td>
							      
							      <td>
							            <input type="text" name="prize_name" class="form-control"  placeholder="名称">
							      </td>
							      <td>
							             <label for="exampleInputName2">发奖单位</label>  
							      </td>
							      <td>
							             <input type="text" name="prize_give_unit" class="form-control"  placeholder="期刊名称">
							      </td>
							</tr>
							
							<tr class="active">
							     <td>
							           <label for="exampleInputName2">奖励级别</label>
							      </td>
							      <td>
							           <input type="text" name="prize_rank" class="form-control"  placeholder="奖励级别">
							      </td>
							      <td>
							            <label for="exampleInputName2">获奖时间</label>
							      </td>
							      <td>      
							            <input type="text" id = "prize_get_time" name="prize_get_time" class="form-control"  placeholder="获奖时间">
							      </td>
							</tr>
							<tr class="active">
							      <td> 
							            <label for="exampleInputName2">成果备注</label>
							      </td>
							       
							      <td colspan="3">
							           <textarea  name = "prize_remark" class="form-control" >
							           
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
		    <script type="text/javascript">  
		      $('#prize_get_time').datetimepicker({  
		        format: 'yyyy-mm-dd',//定义时间格式  
		        autoclose: true,//选择好自动关闭  
		        minView: 2,//只选择到小时  
		        language: 'zh-CN', //汉化   
		      });  
		     
		    </script>  
		   <script>
		       function confirm(form){
		    	   //数据输入是否为空进行验证
		    	   
		    	   if(form.prize_status.value==""){
		    		   alert("请勾选材料是否为空");
		    		   return false;   
		    	   }
		    	 
		    	   if(form.prize_department.value==""){
		    		   alert("请填写系别"); 
		    		   return false;
		    	   }
		    	   if(form.prize_member_one.value==""){
		    		   alert("第一成员必填");
		    		   return false;
		    	   }
		    	 
		    	   if(form.prize_name.value==""){
		    		   alert("请填写竞赛名称"); 
		    		   return false;
		    	   }
		    	   if(form.prize_give_unit.value==""){
		    		   alert("请填写颁奖单位");		    		  
		    		   return false;
		    	   }
		    	   if(form.prize_rank.value==""){
		    		   alert("请填写奖励级别");		    		 
		    		   return false;
		    	   }
		    	   if(form.prize_get_time.value==""){
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
   </div>
</body>
</html>