/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-05-04 14:03:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin.manageTeacherPatent;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class check_005fteacher_005fpatent_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
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
      out.write("<title>专利申请审核</title>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/javascript/jQuery.js\"></script>\r\n");
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
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("   <div class=\"main\">\r\n");
      out.write("       <h2>书籍申报审核</h2>\r\n");
      out.write("\t\t   <form class=\"form-inline\" method=\"post\" action=\"");
      out.print(request.getContextPath() );
      out.write("/admin_patent/save_result\" >\r\n");
      out.write("\t\t            <div class=\"table-responsive\">\r\n");
      out.write("\t\t\t\t\t  <table class=\"table\">\r\n");
      out.write("\t\t\t\t\t        <tr class=\"active\">\r\n");
      out.write("\t\t\t\t\t\t\t     <td>\r\n");
      out.write("\t\t\t\t\t\t\t           <label for=\"exampleInputName2\">总金额</label>\r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t      <td>\r\n");
      out.write("\t\t\t\t\t\t\t           <input type=\"text\" name=\"result_rewards\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${patentCheckResult.result_rewards}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  placeholder=\"总金额\">\r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t      <td>\r\n");
      out.write("\t\t\t\t\t\t\t           \r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t      <td>      \r\n");
      out.write("\t\t\t\t\t\t\t           \r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr class=\"active\">\r\n");
      out.write("\t\t\t\t\t\t\t     <td>\r\n");
      out.write("\t\t\t\t\t\t\t           <label for=\"exampleInputName2\">学院奖励金额</label>\r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t      <td>\r\n");
      out.write("\t\t\t\t\t\t\t           <input type=\"text\" name=\"result_reward_from_depart\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${patentCheckResult.result_reward_from_depart}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  placeholder=\"学院奖励金额\">\r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t      <td>\r\n");
      out.write("\t\t\t\t\t\t\t           \r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t      <td>      \r\n");
      out.write("\t\t\t\t\t\t\t           \r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr> \r\n");
      out.write("\t\t\t\t\t  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<tr class=\"active\">\r\n");
      out.write("\t\t\t\t\t\t\t     <td><label class=\"radio\">审核状态：     </label></td>\r\n");
      out.write("\t\t\t\t\t\t\t     <td> \r\n");
      out.write("\t\t\t\t\t\t\t        <label class=\"radio\">\r\n");
      out.write("\t\t\t\t                       <input type=\"radio\" name=\"result_is_ok\" value=\"1\">未审核\r\n");
      out.write("\t\t\t\t                    </label>\r\n");
      out.write("\t\t\t\t\t\t\t\t    <label class=\"radio\">\r\n");
      out.write("\t\t\t\t\t\t\t\t      <input type=\"radio\" name=\"result_is_ok\" value=\"2\">通过\r\n");
      out.write("\t\t\t\t\t\t\t\t    </label>\r\n");
      out.write("\t\t\t\t\t\t\t\t     <label class=\"radio\">\r\n");
      out.write("\t\t\t\t\t\t\t\t      <input type=\"radio\" name=\"result_is_ok\" value=\"3\">不合格\r\n");
      out.write("\t\t\t\t\t\t\t\t    </label>\r\n");
      out.write("\t\t\t\t\t\t\t\t     ");
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t </td>\r\n");
      out.write("\t\t\t\t\t\t\t\t <td>\r\n");
      out.write("\t\t\t\t\t\t\t\t   \r\n");
      out.write("\t\t\t\t\t\t\t\t </td>\r\n");
      out.write("\t\t\t\t\t\t\t\t  <td>\r\n");
      out.write("\t\t\t\t\t\t\t\t    \r\n");
      out.write("\t\t\t\t\t\t\t\t  </td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\t\t\t\t\t\t\t                          \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<tr class=\"active\">\r\n");
      out.write("\t\t\t\t\t\t\t      <td>\r\n");
      out.write("\t\t\t\t\t\t\t            <label for=\"exampleInputName2\">专利名称</label>  \r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t      \r\n");
      out.write("\t\t\t\t\t\t\t      <td>\r\n");
      out.write("\t\t\t\t\t\t\t            <input type=\"text\" name=\"patent_title\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${patentCheckResult.patent_title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"form-control\"  placeholder=\"专利名称\">\r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t      <td></td>\r\n");
      out.write("\t\t\t\t\t\t\t      <td>\r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("                           <tr class=\"active\">\r\n");
      out.write("\t\t\t\t\t\t\t      <td> \r\n");
      out.write("\t\t\t\t\t\t\t            <label for=\"exampleInputName2\">审核留言</label>\r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t       \r\n");
      out.write("\t\t\t\t\t\t\t      <td colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t\t\t           <textarea  name = \"result_message\" class=\"form-control\" >\r\n");
      out.write("\t\t\t\t\t\t\t           \r\n");
      out.write("\t\t\t\t\t\t\t           </textarea>\r\n");
      out.write("\t\t\t\t\t\t\t           \r\n");
      out.write("\t\t\t\t\t\t\t      </td>\r\n");
      out.write("\t\t\t\t\t\t\t     \r\n");
      out.write("\t\t\t\t\t\t\t      \r\n");
      out.write("\t\t\t\t\t\t\t</tr>\t\r\n");
      out.write("\t\t\t\t\t\t\t     \r\n");
      out.write("\t\t\t\t\t  </table>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("                    <input type=\"hidden\" name=\"teacher_num\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${patentCheckResult.teacher_num}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"form-control\" >\r\n");
      out.write("\t\t          <p>\r\n");
      out.write("\t\t          <button type=\"submit\" class=\"btn btn-info\" onClick=\"return check()\">确认提交</button>\r\n");
      out.write("\t\t   </form>\r\n");
      out.write("\t\t   ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${result}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\t\t   <script>\r\n");
      out.write("\t\t       function check(){\r\n");
      out.write("\t\t    \t   \r\n");
      out.write("\t\t    \t   var flag = confirm(\"确认提交吗\");\r\n");
      out.write("\t\t    \t   \r\n");
      out.write("\t\t    \t   if(flag) return true;\r\n");
      out.write("                   return false; \t\t    \t   \r\n");
      out.write("\t\t       }      \r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t   </script> \t\t  \r\n");
      out.write("\t\t   \r\n");
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

  private boolean _jspx_meth_c_005fchoose_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f0.setParent(null);
    int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
    if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t               ");
        if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t               ");
        if (_jspx_meth_c_005fwhen_005f1(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t               ");
        if (_jspx_meth_c_005fotherwise_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t         ");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    // /WEB-INF/views/admin/manageTeacherPatent/check_teacher_patent.jsp(71,23) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${patentCheckResult.result_is_ok== 1}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
    if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t                       <script>\r\n");
        out.write("\t\t\t\t\t\t\t\t                       $(\"input[name='result_is_ok']\").get(0).checked=true;\r\n");
        out.write("\t\t\t\t\t\t\t\t                       </script>\r\n");
        out.write("\t\t\t\t\t\t\t\t               ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    // /WEB-INF/views/admin/manageTeacherPatent/check_teacher_patent.jsp(76,23) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${patentCheckResult.result_is_ok== 2}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f1 = _jspx_th_c_005fwhen_005f1.doStartTag();
    if (_jspx_eval_c_005fwhen_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t                       <script>\r\n");
        out.write("\t\t\t\t\t\t\t\t                       $(\"input[name='result_is_ok']\").get(1).checked=true;\r\n");
        out.write("\t\t\t\t\t\t\t\t                       </script>\r\n");
        out.write("\t\t\t\t\t\t\t\t               ");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_005fotherwise_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fotherwise_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    int _jspx_eval_c_005fotherwise_005f0 = _jspx_th_c_005fotherwise_005f0.doStartTag();
    if (_jspx_eval_c_005fotherwise_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t                       <script>\r\n");
        out.write("\t\t\t\t\t\t\t\t                       $(\"input[name='result_is_ok']\").get(2).checked=true;\r\n");
        out.write("\t\t\t\t\t\t\t\t                       </script>                              \r\n");
        out.write("\t\t\t\t\t\t\t\t               ");
        int evalDoAfterBody = _jspx_th_c_005fotherwise_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fotherwise_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
    return false;
  }
}
