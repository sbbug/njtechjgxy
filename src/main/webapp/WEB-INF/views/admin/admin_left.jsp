<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>后台管理主页面</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/public.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/jQuery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/public.js"></script>
</head>
<body id="bg">
	<!-- 左边节点 -->
	<div class="container">

		<div class="leftsidebar_box">
			
			<dl class="system_log">
				<dt>
					 教师信息
				</dt>
				<dd>
					<a class="cks" href="<%=request.getContextPath() %>/admin_manage/entry_teacher_info"
						target="main">信息录入</a>
				</dd>
				<dd>
					<a class="cks" href="<%=request.getContextPath() %>/admin_manage/entry_excel_teacher_info"
						target="main">信息导入</a>
				</dd>
				<dd>
					<a class="cks" href="<%=request.getContextPath() %>/admin_manage/search"
						target="main">信息查询</a>
				</dd>
			</dl>
			<dl class="system_log">
				<dt>
					         项目管理
				</dt>
				<dd>
					<a class="cks" href="<%=request.getContextPath() %>/admin_paper/show_paper"
						target="main">科研论文</a>
				</dd>
				<dd>
					<a class="cks" href="<%=request.getContextPath() %>/admin_teaching_paper/show_teaching_paper"
						target="main">教研论文</a>
				</dd>
				<dd>
					<a class="cks" href="<%=request.getContextPath() %>/admin_item/show_item"
						target="main">项目申报</a>
				</dd>
				<dd>
					<a class="cks" href="<%=request.getContextPath() %>/admin_book/show_book"
						target="main">书籍申报</a>
				</dd>
				<dd>
					<a class="cks" href="<%=request.getContextPath() %>/admin_achievement/show_achievement"
						target="main">成果申报</a>
				</dd>
				<dd>
					<a class="cks" href="<%=request.getContextPath() %>/admin_prize/show_prize"
						target="main">指导竞赛</a>
				</dd>
				<dd>
					<a class="cks" href="<%=request.getContextPath() %>/admin_patent/show_patent"
						target="main">专利申请</a>
				</dd>
				<dd>
					<a class="cks" href="<%=request.getContextPath() %>/admin_reform/show_reform"
						target="main">教学教改</a>
				</dd>
			</dl>
			<dl class="system_log">
				<dt>
					         期刊管理
				</dt>
				<dd>
					<a href="<%=request.getContextPath() %>/admin_own/show_own" target="main"
						class="cks">院期刊库</a>
				</dd>
				<dd>
					<a href="<%=request.getContextPath() %>/admin_scd/show_scd" target="main"
						class="cks">SCD</a>
				</dd>
				<dd>
					<a href="<%=request.getContextPath() %>/admin_ssci/show_ssci" target="main"
						class="cks">SSCI</a>
				</dd>
				<dd>
					<a href="<%=request.getContextPath() %>/admin_peking/show_peking" target="main"
						class="cks">北大核心期刊</a>
				</dd>
			</dl>		
		</div>
	</div>
</body>
</html>