<%-- 
    Document   : listaContactos
    Created on : 23/03/2022, 08:30:31 PM
    Author     : triny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
     
        <title>Lista de contactos</title>
        
    </head>
    <body>
        <header>
            <h1 style="text-align: center;">Lista de contactos </h1>
        </header>
    <nav class="navbar navbar-light bg-light">
        <form class="form-inline">
            <a href='ContactosControl?accion=agregar' class="btn btn-outline-success" type="button">Agregar contacto</a>
             <a href ='ContactosControl?accion=buscar' class="btn btn-outline-success" type="button">Buscar</a>
        </form>
    </nav>
        
        
        <div class="">
            <table class="table">
                <thead>
                    <tr>
                        
                        <th>Nombre</th>
                        <th>Telefono</th>
                        <th>Correo Electronico</th>
                        <th>Accion</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="contacto" items="${lista}"> 
                    
                        <tr>
                            
                            
                            <td><c:out value="${contacto.nombre}"/></td>
                            <td><c:out value="${contacto.telefono}"/></td>
                            <td><c:out value="${contacto.correo}"/></td>
                            <td><a href="ContactosControl?accion=eliminar&id=<c:out value="${contacto.nombre}"/>">eliminar</a></td>
                            
                           
                        </tr>  
                     </c:forEach>
                </tbody>
            </table>
        </div>   
    </body>
</html>
