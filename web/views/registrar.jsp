<%-- 
    Document   : registrar
    Created on : 23/03/2022, 05:14:35 PM
    Author     : triny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
     
        <title>Registrar contacto</title>
    </head>
    <body>
        <header>
            <h1 style="text-align: center;">Registrar </h1>
        </header>
        
        <form action="ContactosControl?accion=insertar" method="POST" autocomplete="on">
        
        <label>Nombre:</label>  
        <input type="text" name="nombre" id="nombre">
        <br>
        <br>
        <label>Telefono:</label>
        <input type="text" name="telefono" id="telefono">
        <br>
        <br>
        <label>Correo: </label> 
        <input type="text" name="correo" id="correo">
        <br>
        <br>
        <button id="insertar" name="insertar" type="submit">Agregar</button> 
    </form>
        
    </body>
</html>
