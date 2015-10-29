package org.apache.jsp.paginas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import dto.ClienteDto;

public final class agregarCliente_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 String mensaje
                    = (String) request.getAttribute("msn");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <h3><i>Ingreso de Cliente</i></h3>\n");
      out.write("        <form name=\"frmAgregarCliente\" action=\"/App_ETT/AgregarCliente\" method=\"POST\">\n");
      out.write("            <table border=\"0\">               \n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Rut</td>\n");
      out.write("                        <td><input type=\"text\" name=\"txtRut\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Nombre</td>\n");
      out.write("                        <td><input type=\"text\" name=\"txtNombre\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Direccion</td>\n");
      out.write("                        <td><input type=\"text\" name=\"txtDireccion\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Telefono</td>\n");
      out.write("                        <td><input type=\"text\" name=\"txtTelefono\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"submit\" value=\"GRABAR\" name=\"btnGrabar\" />\n");
      out.write("        </form>\n");
      out.write("        ");
 ArrayList<ClienteDto> lista
                    = (ArrayList<ClienteDto>) request.
                    getAttribute("listaClientes");
            if (lista != null) {
        
      out.write("\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Rut</th>\n");
      out.write("                    <th>Nombre</th>\n");
      out.write("                    <th>Direccion</th>\n");
      out.write("                    <th>Telefono</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");
 for (ClienteDto dto : lista) {
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( dto.getRut());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( dto.getNombre());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( dto.getDireccion());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( dto.getTelefono());
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                ");
 } 
      out.write("     \n");
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        ");
 }
      out.write("\n");
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
