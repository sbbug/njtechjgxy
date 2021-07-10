<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教师密码修改</title>
<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/jQuery.js"></script>
<style type="text/css">
    .main{
       text-align:center;
       border:10px;
       font-weight:bold;
       border:5px solid gray;
       margin-left:30%;
       margin-right:30%;
       margin-top:0%;
    }

</style>
</head>
<body>
      <div class="main">
          <h2>密码修改</h2>
           <div class="table-responsive">
					  <table class="table">
							<tr class="active">
							    <td>
							        <label for="exampleInputName2">新密码</label>  
							    </td>
							    <td>
							        <input type="password" name = "new_password" class="form-control"  placeholder="新密码">
							    </td>
							</tr>
							<tr class="active">
							    <td>
							        <label for="exampleInputName2">确认密码</label>
							    </td>
							    <td>
							        <input type="password" name="confirm_password" class="form-control"  placeholder="确认密码">
							    </td>
							</tr>
					 </table>
					 <button type="submit" class="btn btn-info">确认修改</button>
					 <script>
					 //使用ajax实现用户密码修改
					      //定义用户属性
					      var new_password;
					      var confirm_password;
					     
					      $(document).ready(function(){
							     $(":submit").click(function(){
							    	 new_password = $("input[name='new_password']").val();
								     confirm_password = $("input[name='confirm_password']").val(); 
								    
								     if(new_password=="" || confirm_password==""){
								    	 alert("sorry,输入不得为空");
								    	 return false;
								     }
								     if(new_password!=confirm_password){
								    	 alert("密码前后输入不一致");
								    	 return false;
								     }
								     //输入格式验证,采用正则表达式验证，后期添加
								     
								     	
								     $.ajax({
								    	 url:"<%=request.getContextPath() %>/tea_password/edit",
								    	 type:"POST",
								    	 dataType:"json",
								    	 data:{
								    		 "new_password":confirm_password
								    	 },
								    	 //采用异步登录
								    	 async:true,
								    	 success:function(data){
								    		 
								    		 if(data.result=="yes"){
								    			 alert("密码修改成功");
								    			 window.parent.location.href="<%=request.getContextPath() %>/tea_login/index";
								    		 }else{
								    			 alert("修改失败");
								    			 return false;
								    		 }   	 
								    	 },
								    	 //在这里json返回时，总会执行error函数，无论错误还是对，注释掉dataType就会执行success
								    	 error:function(){
								    		 alert("error");
								    		 return false;
								    	 }
								    	 
								     })								    	  
								      });  
					      })
					        
					  </script>
		   </div>					
     </div>
</body>
</html>