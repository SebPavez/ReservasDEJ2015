<%-- 
    Document   : buscarClienteDinamico
    Created on : 15-10-2015, 13:53:46
    Author     : cetecom
--%>

<%@page import="dao.ClienteDaoImplementado"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Buscar Cliente</h1>
        <% ArrayList<String> lista
                    = (ArrayList<String>)
                new ClienteDaoImplementado().rutClientes();%>

        <form action="BuscarCliente" method="POST">
            <table border="0">               
                <tbody>
                    <tr>
                        <td>Rut</td>
                        <td><select name="cmbRut">
                                <% for (String c : lista) {%> 
                                <option><%= c%></option>
                                <% }%>                                
                            </select></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="BUSCAR" name="btnBuscar" />         
        </form>
    </body>
</html>
