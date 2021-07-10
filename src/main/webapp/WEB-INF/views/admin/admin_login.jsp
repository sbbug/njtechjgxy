<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>boss登录 </title>
<link href="<%=request.getContextPath()%>/css/main.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/jQuery.js"></script>
</head>
<body>
    <div class="login">
    <div class="box png">
		<div class="logo png"></div>
		<div class="input">
			<div class="log">
				<div class="name">
					<label>用户名</label><input type="text" class="text" name="admin_num" placeholder="用户名" >
				</div>
				<div class="pwd">
					<label>密　码</label><input type="password" class="text" name="admin_password" placeholder="密码"  >
					<input type="submit" class="submit" tabindex="3" value="登录">
					<div class="check"></div>
				</div>
				<div class="tip"></div>
				<script type="text/javascript">
				  //在这里处理登录
				  //使用ajax实现用户的登录
					      //定义用户属性
					      var admin_num;
					      var admin_password;
					    	      
					      $(document).ready(function(){
							     $(":submit").click(function(){
							    	 admin_num = $("input[name='admin_num']").val();
								     admin_password=$("input[name='admin_password']").val(); 
								     
								     //输入是否为空验证
								     
								     if(admin_num=="" || admin_password==""){
								    	 alert("输入不得为空");
								    	 return false;
								     }
								     //alert(admin_num+admin_password);
								     //输入格式验证,采用正则表达式验证，后期添加
								     
								     
								     
								     
								     
								    
								     $.ajax({
								    	 url:"<%=request.getContextPath() %>/adm_login/judge",
								    	 type:"POST",
								    	 dataType:"json",
								    	 data:{
								    		 "admin_num":admin_num,
								    		 "admin_password":admin_password
								    	 },
								    	 //采用异步登录
								    	 async:true,
								    	 success:function(data){
								    		 
								    		 if(data.result=="A"){
								    			 alert("用户名或密码错误");
								    			 return false;	
								    		 }else if(data.result=="B"){
								    			 //登录成功后跳转的地址
								    			 alert("登录成功");
								    			 window.location.href="<%=request.getContextPath() %>/adm_index/index";
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
	</div>
    <div class="air-balloon ab-1 png"></div>
	<div class="air-balloon ab-2 png"></div>
    <div class="footer"></div>
</div>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/fun.base.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/script.js"></script>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
</div>
</body>
</html>