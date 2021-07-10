<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/public.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/jQuery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/public.js"></script>
<style>
	.title {
    color: #333;
    font-size: 40px;
    font-family: "Microsoft YaHei";
}
</style>

</head>
<body>
      <!-- 头部 -->
	<div class="head">
		<div class="headL">
			<li class="title" >科研论文后台管理系统</li>
		</div>
		<div class="headR">
			<span style="color:#FFF">欢迎：${sessionScope.admin_num}</span> <a href="<%=request.getContextPath()%>/adm_login/quit" target="_top" rel="external">【退出】</a>
		</div>
	</div>
</body>
</html>