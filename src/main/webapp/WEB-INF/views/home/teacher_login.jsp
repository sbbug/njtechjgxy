<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
%>
<head>
	<title>科研论文审核系统</title>	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="<%=request.getContextPath() %>/css/login.css" rel="stylesheet" type="text/css"/>
	<link href="<%=request.getContextPath() %>/css/reset.css" rel="stylesheet" type="text/css"/>
	<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/jQuery.js"></script>	
</head>	       
<html>
<body>
    <div class="main">
				<div class="header">
					<img src="<%=request.getContextPath() %>/img/icon.jpg" width="120" height="100">
					<div class="line"></div>
					<div>
						<li class="title">科研论文审核系统</li>
						<li class="xueyuan">经济管理学院</li>
					</div>
				</div>
		<div class="login">
		    <a href="<%=request.getContextPath() %>/adm_login/index"><img src="<%=request.getContextPath() %>/img/fire.png"></a>
			<div class="login_right form-horizontal">
					  <div class="form-group">
					    <label for="exampleInputName1">   </label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" name="teacher_num" placeholder="账号" required="required">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="exampleInputName1">   </label>
					    <div class="col-sm-10">
					      <input type="password" class="form-control" name="teacher_password" placeholder="密码" required="required">
					    </div>
					  </div>
 
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <button type="submit" class="btn btn-info">登录</button>
					    </div>					    
					  </div>		  
					  <script>
					      //使用ajax实现用户的登录
					      //定义用户属性
					      var teacher_num;
					      var teacher_password;
					      var log_time;
					      var log_ip=null;
					      //将ip地址的请求放在外面
					       //调用接口获取ip地址 
					      $.getJSON("http://ip.wheff7.com/ipinfo", function(data) {
                              // console.log(data.onlineip);
                               log_ip = data.onlineip
                          });
					      $(document).ready(function(){
							     $(":submit").click(function(){
							    	 teacher_num = $("input[name='teacher_num']").val();
								     teacher_password=$("input[name='teacher_password']").val(); 
								    
								     if(log_ip==null) log_ip="1.1.1.1";
								     //获取当前时间
								     var myDate = new Date();
								     var log_time=myDate.toLocaleString();     //获取当前时间
								    
								     //输入是否为空验证
								     
								     if(teacher_num=="" || teacher_password==""){
								    	 alert("输入不得为空");
								    	 return false;
								     }
								     
								     //输入格式验证,采用正则表达式验证，后期添加
								     
								     
								     
								     
								    // alert(log_time+log_ip);
								     //alert(teacher_name+teacher_password);	
								     $.ajax({
								    	 url:"<%=request.getContextPath() %>/tea_login/judge",
								    	 type:"POST",
								    	 dataType:"json",
								    	 data:{
								    		 "teacher_num":teacher_num,
								    		 "teacher_password":teacher_password,
								    		 "log_ip":log_ip,
								    		 "log_time":log_time
								    	 },
								    	 //采用异步登录
								    	 async:true,
								    	 success:function(data){
								    		 
								    		 if(data.result=="A"){
								    			 alert("用户名或密码错误");
								    			 return false;	
								    		 }else if(data.result=="B"){
								    		     alert("对不起你已被禁用，请与管理员联系");
								    		     return false;
								    		 }else{
								    			 //登录成功后跳转的地址
								    			 window.location.href="<%=request.getContextPath() %>/tea_index/index";
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
  
</body>
</html>
