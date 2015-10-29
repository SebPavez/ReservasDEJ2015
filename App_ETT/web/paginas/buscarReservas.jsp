<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Búsqueda de reservars</title>
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
        <h3>Ingrese rango de fechas</h3>
        <form action="/App_ETT/buscarEntreFechas" method="POST">
            <table>
                <thead>
                    <tr>
                        <th>Desde</th>
                        <th>Hasta</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="text" id="datepicker" name="FechaInicio"></td></td>
                        <td><input type="text" id="datepicker2" name="Fechafinal"></td></td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
