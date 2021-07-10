<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教师基本信息批量导入</title>
<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/jQuery.js"></script>

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
       <h2>教师基本信息批量导入</h2>
		   <form class="form-inline" method="post" action="<%=request.getContextPath() %>/admin_manage/add_excel_teacher" enctype ="multipart/form-data">
		            <div class="table-responsive">
					  <table class="table">
					  
							 <tr class="active">
							      <td> 
							         <label class="radio">请导入Excel数据 </label>
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
		          <button type="submit" class="btn btn-info" onClick="return confirm(this.form)">确认导入</button>
		   </form>
		   ${result}
		   <script>
		       function confirm(form){
		    	   //数据输入是否为空进行验证
		    	   
		    	   if(form.upfile.value==""){
		    		   alert("请选择Excel导入");
		    		   return false;   
		    	   }		    	   		    	 		    	 		    	 		    	      	   
		    	   return true;
		       }
		   
		   </script>
		  
		  
   </div>
</body>
</html>