/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-03-23 04:38:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<head>\n");
      out.write("\t<title>科研论文审核系统</title>\t\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/css/login.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/css/reset.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/javascript/jQuery.js\"></script>\t\n");
      out.write("</head>\t       \n");
      out.write("<html>\n");
      out.write("<body>\n");
      out.write("    <div class=\"main\">\n");
      out.write("\t\t\t\t<div class=\"header\">\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/img/icon.jpg\" width=\"120\" height=\"100\">\n");
      out.write("\t\t\t\t\t<div class=\"line\"></div>\n");
      out.write("\t\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t\t<li class=\"title\">科研论文审核系统</li>\n");
      out.write("\t\t\t\t\t\t<li class=\"xueyuan\">经济管理学院</li>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t<div class=\"login\">\n");
      out.write("\t\t    <a href=\"");
      out.print(request.getContextPath() );
      out.write("/admin/index\">后台管理</a>\n");
      out.write("\t\t\t<div class=\"login_right form-horizontal\">\n");
      out.write("\t\t\t\t\t  <div class=\"form-group\">\n");
      out.write("\t\t\t\t\t    <label for=\"exampleInputName1\">   </label>\n");
      out.write("\t\t\t\t\t    <div class=\"col-sm-10\">\n");
      out.write("\t\t\t\t\t      <input type=\"text\" class=\"form-control\" name=\"teacher_num\" placeholder=\"账号\" required=\"required\">\n");
      out.write("\t\t\t\t\t    </div>\n");
      out.write("\t\t\t\t\t  </div>\n");
      out.write("\t\t\t\t\t  <div class=\"form-group\">\n");
      out.write("\t\t\t\t\t    <label for=\"exampleInputName1\">   </label>\n");
      out.write("\t\t\t\t\t    <div class=\"col-sm-10\">\n");
      out.write("\t\t\t\t\t      <input type=\"password\" class=\"form-control\" name=\"teacher_password\" placeholder=\"密码\" required=\"required\">\n");
      out.write("\t\t\t\t\t    </div>\n");
      out.write("\t\t\t\t\t  </div>\n");
      out.write(" \n");
      out.write("\t\t\t\t\t  <div class=\"form-group\">\n");
      out.write("\t\t\t\t\t    <div class=\"col-sm-offset-2 col-sm-10\">\n");
      out.write("\t\t\t\t\t      <button type=\"submit\" class=\"btn btn-info\">登录</button>\n");
      out.write("\t\t\t\t\t    </div>\t\t\t\t\t    \n");
      out.write("\t\t\t\t\t  </div>\t\t  \n");
      out.write("\t\t\t\t\t  <script>\n");
      out.write("\t\t\t\t\t      //使用ajax实现用户的登录\n");
      out.write("\t\t\t\t\t      //定义用户属性\n");
      out.write("\t\t\t\t\t      var teacher_num;\n");
      out.write("\t\t\t\t\t      var teacher_password;\n");
      out.write("\t\t\t\t\t    \t      \n");
      out.write("\t\t\t\t\t      $(document).ready(function(){\n");
      out.write("\t\t\t\t\t\t\t     $(\":submit\").click(function(){\n");
      out.write("\t\t\t\t\t\t\t    \t teacher_name = $(\"input[name='teacher_num']\").val();\n");
      out.write("\t\t\t\t\t\t\t\t     teacher_password=$(\"input[name='teacher_password']\").val(); \n");
      out.write("\t\t\t\t\t\t\t\t     \n");
      out.write("\t\t\t\t\t\t\t\t     //输入是否为空验证\n");
      out.write("\t\t\t\t\t\t\t\t     \n");
      out.write("\t\t\t\t\t\t\t\t     if(teacher_name==\"\" || teacher_password==\"\"){\n");
      out.write("\t\t\t\t\t\t\t\t    \t alert(\"输入不得为空\");\n");
      out.write("\t\t\t\t\t\t\t\t    \t return false;\n");
      out.write("\t\t\t\t\t\t\t\t     }\n");
      out.write("\t\t\t\t\t\t\t\t     \n");
      out.write("\t\t\t\t\t\t\t\t     //输入格式验证\n");
      out.write("\t\t\t\t\t\t\t\t     \n");
      out.write("\t\t\t\t\t\t\t\t     \n");
      out.write("\t\t\t\t\t\t\t\t     \n");
      out.write("\t\t\t\t\t\t\t\t     \n");
      out.write("\t\t\t\t\t\t\t\t     \n");
      out.write("\t\t\t\t\t\t\t\t     //alert(teacher_name+teacher_password);\t\n");
      out.write("\t\t\t\t\t\t\t\t     $.ajax({\n");
      out.write("\t\t\t\t\t\t\t\t    \t url:\"http://127.0.0.1:8080/njtechjgxy/teacher/login\",\n");
      out.write("\t\t\t\t\t\t\t\t    \t type:\"POST\",\n");
      out.write("\t\t\t\t\t\t\t\t    \t dataType:\"json\",\n");
      out.write("\t\t\t\t\t\t\t\t    \t data:{\n");
      out.write("\t\t\t\t\t\t\t\t    \t\t \"teacher_num\":teacher_num,\n");
      out.write("\t\t\t\t\t\t\t\t    \t\t \"teacher_password\":teacher_password\n");
      out.write("\t\t\t\t\t\t\t\t    \t },\n");
      out.write("\t\t\t\t\t\t\t\t    \t async:true,\n");
      out.write("\t\t\t\t\t\t\t\t    \t success:function(data){\n");
      out.write("\t\t\t\t\t\t\t\t    \t\t alert(\"success\");\n");
      out.write("\t\t\t\t\t\t\t\t    \t\t if(data.res==\"yes\"){\n");
      out.write("\t\t\t\t\t\t\t\t    \t\t\t //登录成功后跳转的地址\n");
      out.write("\t\t\t\t\t\t\t\t    \t\t\t window.location.href=\"\";\n");
      out.write("\t\t\t\t\t\t\t\t    \t\t }else{\n");
      out.write("\t\t\t\t\t\t\t\t    \t\t     alert(\"用户名或密码错误\");\n");
      out.write("\t\t\t\t\t\t\t\t    \t\t     return false;\n");
      out.write("\t\t\t\t\t\t\t\t    \t\t }   \t\t \n");
      out.write("\t\t\t\t\t\t\t\t    \t },\n");
      out.write("\t\t\t\t\t\t\t\t    \t error:function(){\n");
      out.write("\t\t\t\t\t\t\t\t    \t\t alert(\"error\");\n");
      out.write("\t\t\t\t\t\t\t\t    \t\t return false;\n");
      out.write("\t\t\t\t\t\t\t\t    \t }\n");
      out.write("\t\t\t\t\t\t\t\t    \t \n");
      out.write("\t\t\t\t\t\t\t\t     })\t\t\t\t\t\t\t\t    \t  \n");
      out.write("\t\t\t\t\t\t\t\t      });  \n");
      out.write("\t\t\t\t\t      })\n");
      out.write("\t\t\t\t\t        \n");
      out.write("\t\t\t\t\t  </script>\n");
      out.write("\t\t\t\t\t \t\t          \n");
      out.write("            </div>       \n");
      out.write("      </div>\n");
      out.write("   </div>\n");
      out.write("  \n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
