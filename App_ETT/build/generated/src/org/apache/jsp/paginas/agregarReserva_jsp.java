package org.apache.jsp.paginas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class agregarReserva_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>jQuery UI Datepicker - Default functionality</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css\">\n");
      out.write("        <script src=\"//code.jquery.com/jquery-1.10.2.js\"></script>\n");
      out.write("        <script src=\"//code.jquery.com/ui/1.11.4/jquery-ui.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"/resources/demos/style.css\">\n");
      out.write("        <script>\n");
      out.write("            $(function () {\n");
      out.write("                $(\"#datepicker\").datepicker();\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        <script>\n");
      out.write("            $(function () {\n");
      out.write("                $(\"#datepicker2\").datepicker();\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>        \n");
      out.write("        ");
 String mensaje
                    = (String) request.getAttribute("problemaCliente");
            if (mensaje != null) {
        
      out.write("\n");
      out.write("        <script>\n");
      out.write("            alert(\"");
      out.print( mensaje);
      out.write("\");\n");
      out.write("        </script>\n");
      out.write("        ");
 }
      out.write("\n");
      out.write("         ");
 String mensaje2
                    = (String) request.getAttribute("problemaReserva");
            if (mensaje2 != null) {
        
      out.write("\n");
      out.write("        <script>\n");
      out.write("            alert(\"");
      out.print( mensaje2 );
      out.write("\");\n");
      out.write("        </script>\n");
      out.write("        ");
 }
      out.write("\n");
      out.write("        <form action=\"/App_ETT/AgregarReserva\" method=\"POST\">\n");
      out.write("            <table border=\"0\">                \n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Cod Reserva</td>\n");
      out.write("                        <td><input type=\"text\" name=\"txtCodigoReserva\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>F. Inicio</td>\n");
      out.write("                        <td><input type=\"text\" id=\"datepicker\" name=\"ccalFechaInicio\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>F. Entrega</td>\n");
      out.write("                        <td><input type=\"text\" id=\"datepicker2\" name=\"ccalFechaEntrega\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>L.Bencina</td>\n");
      out.write("                        <td><input type=\"text\" name=\"txtLitrosBencina\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Rut Cliente</td>\n");
      out.write("                        <td><input type=\"text\" name=\"txtClienteRut\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"submit\" value=\"GRABAR\" name=\"btnGrabar\" />\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
