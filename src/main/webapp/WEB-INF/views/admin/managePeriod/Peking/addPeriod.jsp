<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>北大核心条目添加</title>
<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
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
       <h2>添加期刊</h2><a href="<%=request.getContextPath() %>/admin_peking/show_excel">批量添加</a>
		   <form class="form-inline" method="post" action="<%=request.getContextPath() %>/admin_peking/add_peking" >
		            <div class="table-responsive">
					  <table class="table">					  																										
                            <tr class="active">
							      <td>
							           <label for="exampleInputName2">期刊区号</label>
							      </td>
							      <td>
							           <input type="text" name = "peking_area" class="form-control"  placeholder="区号">
							      </td>
							      <td>
							           
							      </td>
							      <td>      
							           
							      </td>
							</tr>
							<tr class="active">
							      <td>
							           <label for="exampleInputName2">期刊编号</label>
							      </td>
							      <td>
							           <input type="text" name="peking_series" class="form-control"  placeholder="期刊编号">
							      </td>
							      <td>
							           
							      </td>
							      <td>      
							            
							      </td>
							</tr>
							<tr class="active">
							      <td>
							           <label for="exampleInputName2">期刊名字</label>
							      </td>
							      <td>
							           <input type="text"  name="peking_name" class="form-control"  placeholder="期刊名字">
							      </td>
							      <td>
							          
							      </td>
							      <td>      
							           
							      </td>
							</tr>
																														   
                           
					  </table>
					</div>
   
		          <p>
		          <button type="submit" class="btn btn-info" onClick="return confirm(this.form)">添加</button>
		   </form>
		   
		   ${result}
		   <script>
		       function confirm(form){
		    	   //数据输入是否为空进行验证
		    	   
		    	   if(form.peking_area.value==""){
		    		   alert("请输入区号");
		    		   return false;   
		    	   }		    	  		    	 
		    	   if(form.peking_series.value==""){
		    		   alert("请输入编号"); 
		    		   return false;
		    	   }
		    	  
		    	   if(form.peking_name.value==""){
		    		   alert("请输入期刊名字");
		    		   return false;
		    	   }
		    	 
		    	  
		    	  
		    	   return true;
		       }
		   
		   </script>
		
			  
        
   </div>
</body>
</html>