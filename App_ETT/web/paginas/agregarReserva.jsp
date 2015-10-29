<%-- 
    Document   : agregarReserva
    Created on : 29-09-2015, 12:52:32
    Author     : cetecom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>jQuery UI Datepicker - Default functionality</title>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script>
            $(function () {
                $("#datepicker").datepicker();
            });
        </script>
        <script>
            $(function () {
                $("#datepicker2").datepicker();
            });
        </script>
    </head>
    <body>        
        <% String mensaje
                    = (String) request.getAttribute("problemaCliente");
            if (mensaje != null) {
        %>
        <script>
            alert("<%= mensaje%>");
        </script>
        <% }%>
         <% String mensaje2
                    = (String) request.getAttribute("problemaReserva");
            if (mensaje2 != null) {
        %>
        <script>
            alert("<%= mensaje2 %>");
        </script>
        <% }%>
        <form action="/App_ETT/AgregarReserva" method="POST">
            <table border="0">                
                <tbody>
                    <tr>
                        <td>Cod Reserva</td>
                        <td><input type="text" name="txtCodigoReserva" value="" /></td>
                    </tr>
                    <tr>
                        <td>F. Inicio</td>
                        <td><input type="text" id="datepicker" name="ccalFechaInicio"></td>
                    </tr>
                    <tr>
                        <td>F. Entrega</td>
                        <td><input type="text" id="datepicker2" name="ccalFechaEntrega"></td>
                    </tr>
                    <tr>
                        <td>L.Bencina</td>
                        <td><input type="text" name="txtLitrosBencina" value="" /></td>
                    </tr>
                    <tr>
                        <td>Rut Cliente</td>
                        <td><input type="text" name="txtClienteRut" value="" /></td>
                    </tr>
                </tbody>
            </table>
            <br>
            <input type="submit" value="GRABAR" name="btnGrabar" />
        </form>
    </body>
</html>
