<%-- 
    Document   : AltasPacientes
    Created on : 16/05/2017, 11:17:46 AM
    Author     : omar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <center> 
        <h1>Pacientes</h1>
       <form action="AltaPaciente" method="post">
        <table width="50%">
            <tbody>
                                
                <tr>
                    <td><label>Nombre</label></td>                    
                    <td><input type="text" name="nombre"></td>
                </tr>
                
                <tr>
                    <td><label>Fecha de Nacimiento</label></td>                    
                    <td><input type="date" name="fecha"></td>
                </tr>
                
                <tr>
                    <td><label>Estatura (cms)</label></td>                    
                    <td><input type="number" name="estatura"></td>
                </tr>
                
                <tr>
                    <td><label>Sexo</label></td>                    
                    <td><input type="text" name="sexo"></td>
                </tr>
                
                 <tr>
                    <td></td>                    
                    <td style="align-content: center"><input type="submit" title="Aceptar" value="Aceptar" ></td>
                </tr>
                
            </tbody>
        </table>
       </form>
      </center>
    <a href='index.html'>Volver al inicio</a>
    </body>
</html>
