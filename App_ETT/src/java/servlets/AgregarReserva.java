package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dto.ReservaDto;
import dao.ReservaDaoImplementado;
import dao.ClienteDaoImplementado;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgregarReserva extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Integer codReserva = Integer.parseInt(
                    request.getParameter(
                            "txtCodigoReserva".trim()));
            String rutCliente = request.getParameter(
                    "txtClienteRut".trim());

            if (new ClienteDaoImplementado().
                    existeCliente(rutCliente) == false) {
                request.setAttribute("problemaCliente",
                        "No existe cliente asociado a dicho rut");
            } else if (new ReservaDaoImplementado().
                    buscarPorID(codReserva) != null) {
                request.setAttribute("problemaReserva",
                        "Ya existe una reserva con dicho codigo");
            } else {
                SimpleDateFormat formatoDelTexto
                        = new SimpleDateFormat("dd/MM/yyyy");
                String strFecha = request.getParameter("ccalFechaInicio");
                String strFecha2 = request.getParameter("ccalFechaEntrega");
                Date fecha1 = formatoDelTexto.parse(strFecha);
                Date fecha2 = formatoDelTexto.parse(strFecha2);
                ReservaDto dto = new ReservaDto();
                dto.setCodReserva(codReserva);
                dto.setClienteRut(rutCliente);
                dto.setFechaInicio(fecha1);
                dto.setFechaEntrega(fecha2);
                dto.setLitrosBencina(Integer.parseInt(request.getParameter("txtLitrosBencina".trim())));
                if(new ReservaDaoImplementado().agregar(dto))
                    request.setAttribute("mensaje","Se almaceno correctamente");
                else
                    request.setAttribute("mensaje","No se pudo almacenar");
            }            
            request.getRequestDispatcher(
                    "paginas/agregarReserva.jsp").
                    forward(request, response);
            

        } catch (ParseException ex) {
            Logger.getLogger(AgregarReserva.class.getName()).log(Level.SEVERE, null, ex);
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
