package servlets;

import dto.ClienteDto;
import dao.ClienteDaoImplementado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModificarCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            ClienteDto dto = new ClienteDto();
            dto.setRut(request.getParameter("txtRut".trim()));
            dto.setNombre(request.getParameter("txtNombre".trim()));
            dto.setDireccion(request.getParameter("txtDireccion".trim()));
            dto.setTelefono(request.getParameter("txtTelefono".trim()));

            if (new ClienteDaoImplementado().modificar(dto)) {
                request.setAttribute("mensaje",
                        "Registro modificado exitosamente");
            } else {
                request.setAttribute("mensaje",
                        "NO se pudo modificar el registro");
            }
            request.getRequestDispatcher(
                    "paginas/buscarCliente.jsp").
                    forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
