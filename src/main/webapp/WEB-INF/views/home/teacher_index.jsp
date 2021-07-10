<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <title>高校智能信息管理系统</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <link href="<%=request.getContextPath() %>/css/teacher/dpl-min.css" rel="stylesheet" type="text/css" />
   <link href="<%=request.getContextPath() %>/css/teacher/bui-min.css" rel="stylesheet" type="text/css" />
   <link href="<%=request.getContextPath() %>/css/teacher/main-min.css" rel="stylesheet" type="text/css" />
 </head>
 <body>

  <div class="header">
    
      <div class="dl-title">
       <!--<img src="/chinapost/Public/assets/img/top.png">-->
      </div>

    <div class="dl-log">
               欢迎您，<span class="dl-log-user">${sessionScope.teacher_num}</span>
               <a href="<%=request.getContextPath() %>/tea_login/quit" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
  </div>
   <div class="content">
    <div class="dl-main-nav">
      <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
      <ul id="J_Nav"  class="nav-list ks-clear">
        		<li class="nav-item dl-selected"><div class="nav-item-inner nav-home">个人信息</div></li>		
      </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
   </div>
  <script type="text/javascript" src="<%=request.getContextPath() %>/javascript/jQuery.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath() %>/javascript/teacher/bui-min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath() %>/javascript/teacher/main-min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath() %>/javascript/config-min.js"></script>
  <script>

    //下面的json字符串从数据库动态提取
    BUI.use('common/main',function(){
      var config = [
                      {
                        id:'1',
                        menu:[
                                  {
                                      text:'信息提交',
                                      items:[
                                                {id:'12',text:'科研论文',href:'<%=request.getContextPath() %>/tea_paper/index'},
                                                {id:'3',text:'教研论文',href:'<%=request.getContextPath() %>/teaching_paper/index'},
                                                {id:'4',text:'项目申报',href:'<%=request.getContextPath() %>/tea_item/index'},
                                                {id:'6',text:'书籍申报',href:'<%=request.getContextPath() %>/tea_book/index'},
                                                {id:'6',text:'成果申报',href:'<%=request.getContextPath() %>/tea_achievement/index'},
                                                {id:'6',text:'指导竞赛',href:'<%=request.getContextPath() %>/tea_prize/index'},
                                                {id:'6',text:'专利申请',href:'<%=request.getContextPath() %>/tea_patent/index'},
                                                {id:'6',text:'教学教改',href:'<%=request.getContextPath() %>/tea_reform/index'},
                                                {id:'6',text:'测试界面',href:'<%=request.getContextPath() %>/test/index'}
                                            ]
                                  },
                                  {
                                      text:'信息查询',
                                      items:[
                                                {id:'12',text:'科研论文',href:'<%=request.getContextPath() %>/tea_paper/search'},
                                                {id:'3',text:'教研论文',href:'<%=request.getContextPath() %>/teaching_paper/search'},
                                                {id:'4',text:'项目申报',href:'<%=request.getContextPath() %>/tea_item/search'},
                                                {id:'6',text:'书籍申报',href:'<%=request.getContextPath() %>/tea_book/search'},
                                                {id:'6',text:'成果申报',href:'<%=request.getContextPath() %>/tea_achievement/search'},
                                                {id:'6',text:'指导竞赛',href:'<%=request.getContextPath() %>/tea_prize/search'},
                                                {id:'6',text:'专利申请',href:'<%=request.getContextPath() %>/tea_patent/search'},
                                                {id:'6',text:'教学教改',href:'<%=request.getContextPath() %>/tea_reform/search'},
                                                {id:'6',text:'个人信息',href:'Menu/index.html'}
                                            ]
                                  },
                                  {
                                      text:'信息修改',
                                      items:[
                                                {id:'12',text:'密码修改',href:'<%=request.getContextPath() %>/tea_password/index'},
                                                {id:'6',text:'登录信息',href:'<%=request.getContextPath() %>/tea_login/show_login_log'}
                                            ]
                                  }
                              
                              ]
                      }
                  ];
      new PageUtil.MainPage({
        modulesConfig : config
      });
    });
  </script>
 </body>
</html>