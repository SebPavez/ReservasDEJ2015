<%-- 
    Document   : buscarCliente
    Created on : 15-10-2015, 12:45:48
    Author     : cetecom
--%>

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
                    = (String) request.getAttribute("problemaCliente");
            if (mensaje != null) {
        %>
        <script>
            alert("<%= mensaje%>");
        </script>
        <% }%>
        <h1>Busqueda de Cliente</h1>
        <form action="/App_ETT/BuscarCliente" method="POST">
            <table border="0">                
                <tbody>
                    <tr>
                        <td>Rut Cliente</td>
                        <td><input type="text" name="txtRutCliente" value="" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="BUSCAR" name="btnBuscar" />
        </form>

        <% ClienteDto dto
                    = (ClienteDto) request.getAttribute(
                            "cliente");

            if (dto != null) {
        %>
        
        <form action="/App_ETT/ModificarCliente" method="POST">
       
        
        <table border="1">            
            <tbody>
                <tr>
                    <td>Rut</td>
                    <td><input type="text" name="txtRut" value="<%= dto.getRut()%>" readonly="readonly" /></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="txtNombre" value="<%= dto.getNombre()%>" /></td>
                </tr>
                <tr>
                    <td>Direccion</td>
                    <td><input type="text" name="txtDireccion" value="<%= dto.getDireccion()%>" /></td>
                </tr>
                <tr>
                    <td>Telefono</td>
                    <td><input type="text" name="txtTelefono" value="<%= dto.getTelefono()%>" /></td>
                </tr>
            </tbody>
        </table>
        <input type="submit" value="MODIFICAR" name="btnModificar" />  
         </form>
        <% }%>
    </body>

</html>
