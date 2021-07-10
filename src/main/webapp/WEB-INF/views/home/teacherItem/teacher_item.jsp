<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>项目申报界面</title>
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
       <h2>项目信息提交</h2>
		   <form class="form-inline" method="post" action="<%=request.getContextPath() %>/tea_item/addItem" enctype ="multipart/form-data">
		            <div class="table-responsive">
					  <table class="table">
					  
							<tr class="active">
							     <td><label class="radio">材料：     </label></td>
							     <td> 
							        <label class="radio">
				                       <input type="radio" name="item_status" value="1">有
				                    </label>
								    <label class="radio">
								      <input type="radio" name="item_status" value="0">无
								    </label>
								 </td>
								 <td></td>
								  <td></td>
							</tr>
							
							<tr class="active">
							      <td> <label class="radio">系别：     </label></td>
							       
							      
							      <td>
							            <!-- 下面的数据采用动态提取 -->
				                     <select id="static_dropdown" name="item_department" class="form-control">
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
							           <label for="exampleInputName2">第一主持人</label>
							      </td>
							      <td>
							           <input type="text" name = "item_first_author" class="form-control"  placeholder="姓名">
							      </td>
							      <td>
							           
							      </td>
							      <td>      
							           
							      </td>
							</tr>
							<tr class="active">
							      <td>
							           <label for="exampleInputName2">第二作者</label>
							      </td>
							      <td>
							           <input type="text" name="item_second_author" class="form-control"  placeholder="姓名">
							      </td>
							      <td>
							           
							      </td>
							      <td>      
							            
							      </td>
							</tr>
							<tr class="active">
							      <td>
							           <label for="exampleInputName2">第三作者</label>
							      </td>
							      <td>
							           <input type="text" value="第三作者" name="item_third_author" class="form-control"  placeholder="姓名">
							      </td>
							      <td>
							          
							      </td>
							      <td>      
							           
							      </td>
							</tr>
							
							<tr class="active">
							      <td>
							            <label for="exampleInputName2">课题名称</label>  
							      </td>
							      
							      <td>
							            <input type="text" name="item_title" class="form-control"  placeholder="课题名称">
							      </td>
							      <td>
							              <label for="exampleInputName2">基金号</label>  
							      </td>
							      <td>
							              <input type="text" name="item_fund_num" class="form-control"  placeholder="基金号">
							      </td>
							</tr>
							
							<tr class="active">
							     <td>
							           <label for="exampleInputName2">课题来源</label>
							      </td>
							      <td>
							           <input type="text" name="item_from" class="form-control"  placeholder="课题来源">
							      </td>
							      <td>
							            <label for="exampleInputName2">项目等级</label>
							      </td>
							      <td>      
							           <input type="text" name="item_rank" class="form-control"  placeholder="项目等级">
							      </td>
							</tr>
							<tr class="active">
							   <td> <label class="radio">项目性质：     </label></td>
							       
							      <td>
							            <!-- 下面的数据采用动态提取 -->
				                     <select id="static_dropdown" name="item_state" class="form-control">
									    <option value="新增">新增</option>
									    <option value="在研">在研</option>									   														   
                                     </select>
							      </td>
							      <td>
							           <label for="exampleInputName2">项目经费</label>
							      </td>
							      <td>
							           <input type="text" name="item_funds" class="form-control"  placeholder="项目经费">
							      </td>
							</tr>
							<tr class="active">
							      <td> 
							         <label class="radio">开始时间 </label>
							      </td>
							       
	                              <td>						     
							          <input id="datetimepicker_start" type="text" name="item_start_date" class="form-control" class="form_datetime" placeholder="开始时间"> 
							      </td>
							    
							      <td>
							           <label class="radio">结束时间 </label>
							      </td>
							      <td>
							          <input id="datetimepicker_end" type="text" name="item_end_date" class="form-control" class="form_datetime" placeholder="结束时间"> 
							      </td>
							</tr>
							<tr class="active">
							      <td> 
							         <label class="radio">项目备注</label>
							      </td>
							       
	                              <td>						     
							          <input type="text" name="item_remark" class="form-control"  placeholder="填写备注"> 
							      </td>
							      <td>
							           
							      </td>
							      <td>
							         
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
		    	   
		    	   if(form.item_status.value==""){
		    		   alert("请勾选材料是否为空");
		    		   return false;   
		    	   }
		    	   
		    	 
		    	   if(form.item_department.value==""){
		    		   alert("请填写系别"); 
		    		   return false;
		    	   }
		    	   if(form.item_first_author.value==""){
		    		   alert("第一主持人必填");
		    		   return false;
		    	   }
		    	  
		    	   if(form.item_title.value==""){
		    		   alert("请填写论文题目"); 
		    		   return false;
		    	   }
		    	   if(form.item_fund_num.value==""){
		    		   alert("请填写基金号");		    		  
		    		   return false;
		    	   }
		    	   if(form.item_from.value==""){
		    		   alert("请填写课题来源");		    		 
		    		   return false;
		    	   }
		    	   if(form.item_rank.value==""){
		    		   alert("请填写项目等级");	    		  
		    		   return false;
		    	   }
		    	   if(form.item_funds.value==""){
		    		   alert("请填写项目经费");	    		  
		    		   return false;
		    	   }
		    	   if(form.item_start_date.value=="" || form.item_end_date.value==""){
		    		   alert("请填写项目时间");	    		  
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