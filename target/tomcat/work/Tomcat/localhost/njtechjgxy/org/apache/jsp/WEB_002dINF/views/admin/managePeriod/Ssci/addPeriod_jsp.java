/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-05-06 15:01:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin.managePeriod.Ssci;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addPeriod_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("  \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<title>SSCI条目添加</title>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/css/bootstrap-datetimepicker.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/javascript/jQuery.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("    .main{\r\n");
      out.write("       text-align:center;\r\n");
      out.write("       border:10px;\r\n");
      out.write("       font-weight:bold;\r\n");
      out.write("       border:5px solid gray;\r\n");
      out.write("       margin-left:10%;\r\n");
      out.write("       margin-right:10%;\r\n");
      out.write("       margin-top:0%;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("   <div class=\"main\">\r\n");
      out.write("       <h2>添加期刊</h2><a href=\"");
      out.print(request.getContextPath() );
      out.write("/admin_ssci/show_excel\">批量添加</a>\r\n");
      out.write("\t\t   <form class=\"form-inline\" method=\"post\" action=\"");
      out.print(request.getContextPath() );
      out.write("/admin_ssci/add_ssci\" >\r\n");
      out.write("\t\t            <div class=\"table-responsive\">\r\n");
      out.write("\t\t\t\t\t  <table class=\"table\">\t\t\t\t\t  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("                            <tr class=\"active\">\r\n");
      out.write("\t\t\t\t\t\t\t      <td>\r\n");
      out.write("\t\t\t\t\t\t\t           <label for=\"exampleInputName2\">期刊中文名</label>\r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t      <td>\r\n");
      out.write("\t\t\t\t\t\t\t           <input type=\"text\" name = \"ssci_chinese_name\" class=\"form-control\"  placeholder=\"中文名\">\r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t      <td>\r\n");
      out.write("\t\t\t\t\t\t\t           \r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t      <td>      \r\n");
      out.write("\t\t\t\t\t\t\t           \r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr class=\"active\">\r\n");
      out.write("\t\t\t\t\t\t\t      <td>\r\n");
      out.write("\t\t\t\t\t\t\t           <label for=\"exampleInputName2\">期刊英文名</label>\r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t      <td>\r\n");
      out.write("\t\t\t\t\t\t\t           <input type=\"text\" name=\"ssci_Eglish_name\" class=\"form-control\"  placeholder=\"英文名\">\r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t      <td>\r\n");
      out.write("\t\t\t\t\t\t\t           \r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t      <td>      \r\n");
      out.write("\t\t\t\t\t\t\t            \r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr class=\"active\">\r\n");
      out.write("\t\t\t\t\t\t\t      <td>\r\n");
      out.write("\t\t\t\t\t\t\t           <label for=\"exampleInputName2\">期刊属性</label>\r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t      <td>\r\n");
      out.write("\t\t\t\t\t\t\t           <input type=\"text\"  name=\"ssci_class\" class=\"form-control\"  placeholder=\"期刊属性\">\r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t      <td>\r\n");
      out.write("\t\t\t\t\t\t\t          \r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t      <td>      \r\n");
      out.write("\t\t\t\t\t\t\t           \r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr class=\"active\">\r\n");
      out.write("\t\t\t\t\t\t\t      <td>\r\n");
      out.write("\t\t\t\t\t\t\t           <label for=\"exampleInputName2\">ISSN</label>\r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t      <td>\r\n");
      out.write("\t\t\t\t\t\t\t           <input type=\"text\"  name=\"ssci_issn\" class=\"form-control\"  placeholder=\"ISSN\">\r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t      <td>\r\n");
      out.write("\t\t\t\t\t\t\t          \r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t      <td>      \r\n");
      out.write("\t\t\t\t\t\t\t           \r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \r\n");
      out.write("                           \r\n");
      out.write("\t\t\t\t\t  </table>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("   \r\n");
      out.write("\t\t          <p>\r\n");
      out.write("\t\t          <button type=\"submit\" class=\"btn btn-info\" onClick=\"return confirm(this.form)\">添加</button>\r\n");
      out.write("\t\t   </form>\r\n");
      out.write("\t\t   \r\n");
      out.write("\t\t   ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${result}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\t\t   <script>\r\n");
      out.write("\t\t       function confirm(form){\r\n");
      out.write("\t\t    \t   //数据输入是否为空进行验证\r\n");
      out.write("\t\t    \t   \r\n");
      out.write("\t\t    \t   if(form.ssci_chinese_name.value==\"\"){\r\n");
      out.write("\t\t    \t\t   alert(\"请输入期刊中文名\");\r\n");
      out.write("\t\t    \t\t   return false;   \r\n");
      out.write("\t\t    \t   }\t\t    \t  \t\t    \t \r\n");
      out.write("\t\t    \t   if(form.ssci_Eglish_name.value==\"\"){\r\n");
      out.write("\t\t    \t\t   alert(\"请输入期刊英文名\"); \r\n");
      out.write("\t\t    \t\t   return false;\r\n");
      out.write("\t\t    \t   }\r\n");
      out.write("\t\t    \t  \r\n");
      out.write("\t\t    \t   if(form.ssci_class.value==\"\"){\r\n");
      out.write("\t\t    \t\t   alert(\"请输入期刊属性\");\r\n");
      out.write("\t\t    \t\t   return false;\r\n");
      out.write("\t\t    \t   }\r\n");
      out.write("\t\t    \t   if(form.ssci_issn.value==\"\"){\r\n");
      out.write("\t\t    \t\t   alert(\"请输入期刊ISSN\");\r\n");
      out.write("\t\t    \t\t   return false;\r\n");
      out.write("\t\t    \t   }\r\n");
      out.write("\t\t    \t \r\n");
      out.write("\t\t    \t  \r\n");
      out.write("\t\t    \t  \r\n");
      out.write("\t\t    \t   return true;\r\n");
      out.write("\t\t       }\r\n");
      out.write("\t\t   \r\n");
      out.write("\t\t   </script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t  \r\n");
      out.write("        \r\n");
      out.write("   </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
