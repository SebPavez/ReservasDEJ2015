package servlets;

import dao.ReservaDaoImplementado;
import dto.ReservaDto;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class buscarEntreFechas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
            String strFechaDesde = request.getParameter("ccalFechaInicio");
            String strFechaHasta = request.getParameter("ccalFechaEntrega");
            Date fechaDesde = formatoDelTexto.parse(strFechaDesde);
            Date fechaHasta = formatoDelTexto.parse(strFechaHasta);
            
            List<ReservaDto> listaReservas = new ReservaDaoImplementado().buscarEntreFechas(fechaDesde, fechaHasta);
            if(listaReservas.size()>0){
                request.setAttribute("cantidad", listaReservas.size());
            }
            else
                request.setAttribute("mensaje", "no se han encontrado elementos en el rango");
            
            request.getRequestDispatcher("paginas/buscarReservas.jsp").forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(buscarEntreFechas.class.getName()).log(Level.SEVERE, null, ex);
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
