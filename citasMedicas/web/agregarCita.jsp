<%-- 
    Document   : agregarCita
    Created on : 22/05/2017, 09:56:00 AM
    Author     : omar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Citas Médicas</title>
    </head>
    <body>
        <h1>Agregar cita:</h1>
        <form action="AgregarCita" method="post">
        <table width="50%">
            <tbody>
                                
                <tr>
                    <td><label>Buscar:</label></td>                    
                    <td><input type="text" name="nombre"></td>
                </tr>
                <tr>
                    <td></td>                    
                    <td style="align-content: center"><input type="submit" title="Buscar" value="Buscar" ></td>
                </tr>
            </tbody>
        </table>
       </form>
        
            <table>    
                <tbody>
                <tr>
                    <td><label>Paciente:</label></td>                    
                    <td><p name="nombrePaciente">Aqui va el nombre</p></td>
                </tr>
                <tr>
                    <td><label>Fecha de cita</label></td>                    
                    <td><input type="date" name="fecha"></td>
                </tr>
                </tbody>
            </table>
        
    </body>
</html>
