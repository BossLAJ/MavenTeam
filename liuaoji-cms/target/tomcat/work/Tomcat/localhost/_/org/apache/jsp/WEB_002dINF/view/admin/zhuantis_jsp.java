/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-08-14 03:22:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class zhuantis_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("  <head>\n");
      out.write("\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"howsun\">\n");
      out.write("\n");
      out.write("    <title>CMS后台管理系统</title>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap core CSS-->\n");
      out.write("    <link href=\"/libs/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Custom fonts for this template-->\n");
      out.write("    <link href=\"/libs/fontawesome-free/css/all.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("\n");
      out.write("    <!-- Custom styles for this template-->\n");
      out.write("    <link href=\"/libs/sb-admin/sb-admin.css\" rel=\"stylesheet\">\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("    function audit(id){\n");
      out.write("    \t$.ajax({\n");
      out.write("            url :'/admin/auditArticle?id=' + id,\n");
      out.write("            dataType : 'json',\n");
      out.write("            type : 'post',\n");
      out.write("            success : function(data){\n");
      out.write("                if(data){\n");
      out.write("                \talert(\"审核成功\");\n");
      out.write("                \twindow.location.reload();\n");
      out.write("                } else {\n");
      out.write("                \talert(\"审核失败\");\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        }); \n");
      out.write("    }\n");
      out.write("    </script>\n");
      out.write("  </head>\n");
      out.write("\n");
      out.write("  <body id=\"page-top\">\n");
      out.write("\n");
      out.write("\t<!-- 后台管理系统顶部 -->\n");
      out.write(" \t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "_inc_top.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("    <div id=\"wrapper\">\n");
      out.write("\n");
      out.write(" \t\t<!-- 后台管理系统左部菜单 -->\n");
      out.write(" \t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "_inc_left.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("      <div id=\"content-wrapper\">\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("\n");
      out.write("          <!-- Breadcrumbs-->\n");
      out.write("          <ol class=\"breadcrumb\">\n");
      out.write("            <li class=\"breadcrumb-item\">\n");
      out.write("              <a href=\"/admin/\">后台管理</a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"breadcrumb-item active\">文章列表</li>\n");
      out.write("          </ol>\n");
      out.write("\n");
      out.write("          <!-- Icon Cards-->\n");
      out.write("          <br/>\n");
      out.write("          <a href=\"/admin/zhuantis/add\">添加</a>\n");
      out.write("          <br/>\n");
      out.write("                    <!-- 主体内容区 -->\n");
      out.write("\t\t\t    <div class=\"container\">\n");
      out.write("\t\t\t        <div class=\"row\">\n");
      out.write("\t\t\t            <div class=\"col-md-9\">\n");
      out.write("\t\t\t                <div class=\"panel panel-default\">\n");
      out.write("\t\t\t                  <div class=\"panel-body\">\n");
      out.write("\t\t\t                        <table class=\"table table-striped table-bordered table-hover\">\n");
      out.write("\t\t\t                            <thead>\n");
      out.write("\t\t\t                                <tr class=\"info\">\n");
      out.write("\t\t\t                              \t\t<th>编号</th>\n");
      out.write("\t\t\t                                    <th>名称</th>\n");
      out.write("\t\t\t                                    <th>操作</th>\n");
      out.write("\t\t\t                                </tr>\n");
      out.write("\t\t\t                            </thead>\n");
      out.write("\t\t\t                            <tbody class=\"\">\n");
      out.write("\t\t\t                            ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t                            </tbody>\n");
      out.write("\t\t\t                        </table>\n");
      out.write("\t\t\t                        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("\t\t\t                  </div>\n");
      out.write("\t\t\t                </div>\n");
      out.write("\t\t\t                \n");
      out.write("\t\t\t            </div>\n");
      out.write("\t\t\t        </div>\n");
      out.write("\t\t\t    </div>\n");
      out.write("\t\t\t     <!-- 主体内容区 -->\n");
      out.write("        </div>\n");
      out.write("        <!-- /.container-fluid -->\n");
      out.write("\n");
      out.write("        <!-- Sticky Footer -->\n");
      out.write("        <footer class=\"sticky-footer\">\n");
      out.write("          <div class=\"container my-auto\">\n");
      out.write("            <div class=\"copyright text-center my-auto\">\n");
      out.write("              <span>Copyright Â© Your Website 2019</span>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("      </div>\n");
      out.write("      <!-- /.content-wrapper -->\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <!-- /#wrapper -->\n");
      out.write("\n");
      out.write("    <!-- Scroll to Top Button-->\n");
      out.write("    <a class=\"scroll-to-top rounded\" href=\"#page-top\">\n");
      out.write("      <i class=\"fas fa-angle-up\"></i>\n");
      out.write("    </a>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap core JavaScript-->\n");
      out.write("    <script src=\"/libs/jquery/jquery.min.js\"></script>\n");
      out.write("    <script src=\"/libs/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Custom scripts for all pages-->\n");
      out.write("    <script src=\"/libs/sb-admin/sb-admin.min.js\"></script>\n");
      out.write("  </body>\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/view/admin/zhuantis.jsp(85,31) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/view/admin/zhuantis.jsp(85,31) '${list}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${list}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/view/admin/zhuantis.jsp(85,31) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("zhuanti");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t                                <tr>\n");
          out.write("\t\t\t                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${zhuanti.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("\t\t\t                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${zhuanti.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("\t\t\t                                    <td>\n");
          out.write("\t\t\t                                    \t<a href=\"/admin/zhauntis/edit?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${zhuanti.id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\"><span class=\"glyphicon glyphicon-edit\">修改</span></a>&nbsp;&nbsp;\n");
          out.write("\t\t\t                                    \t<a href=\"/admin/zhauntis/del?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${zhuanti.id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\"><span class=\"glyphicon glyphicon-edit\">删除</span></a>&nbsp;&nbsp;\n");
          out.write("\t\t\t                                    \t<a href=\"/admin/zhuantis/addZhuantiArticle?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${zhuanti.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\"><span class=\"glyphicon glyphicon-edit\">添加文章</span></a>&nbsp;&nbsp;\n");
          out.write("\t\t\t                                    </td>\n");
          out.write("\t\t\t                                </tr>\n");
          out.write("\t\t\t                            ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}