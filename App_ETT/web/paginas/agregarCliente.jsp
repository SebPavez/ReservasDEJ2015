<%-- 
    Document   : agregarCliente
    Created on : 06-10-2015, 12:35:31
    Author     : cetecom
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dto.ClienteDto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String mensaje
                    = (String) request.getAttribute("msn");
            if (mensaje != null) {
        %>
        <script>
            alert("<%= mensaje%>");
        </script>
        <% }%>
        <h3><i>Ingreso de Cliente</i></h3>
        <form name="frmAgregarCliente" action="/App_ETT/AgregarCliente" method="POST">
            <table border="0">               
                <tbody>
                    <tr>
                        <td>Rut</td>
                        <td><input type="text" name="txtRut" value="" /></td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="txtNombre" value="" /></td>
                    </tr>
                    <tr>
                        <td>Direccion</td>
                        <td><input type="text" name="txtDireccion" value="" /></td>
                    </tr>
                    <tr>
                        <td>Telefono</td>
                        <td><input type="text" name="txtTelefono" value="" /></td>
                    </tr>
                </tbody>
            </table>
            <br>
            <input type="submit" value="GRABAR" name="btnGrabar" />
        </form>
        <% ArrayList<ClienteDto> lista
                    = (ArrayList<ClienteDto>) request.
                    getAttribute("listaClientes");
            if (lista != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Rut</th>
                    <th>Nombre</th>
                    <th>Direccion</th>
                    <th>Telefono</th>
                </tr>
            </thead>
            <tbody>
                <% for (ClienteDto dto : lista) {%>
                <tr>
                    <td><%= dto.getRut()%></td>
                    <td><%= dto.getNombre()%></td>
                    <td><%= dto.getDireccion()%></td>
                    <td><%= dto.getTelefono()%></td>
                </tr>

                <% } %>     

            </tbody>
        </table>

        <% }%>
    </body>
</html>
