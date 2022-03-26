<%-- 
    Document   : buscar
    Created on : 23/03/2022, 05:15:20 PM
    Author     : triny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
     
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-light bg-light">
            <form class="form-inline">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
            </form>
        </nav>
        
            </form>
    </nav>
        
        
        <div class="">
            <table class="table">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>Nombre</th>
                        <th>Telefono</th>
                        <th>Correo Electronico</th>
                        <th>Accion</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="contacto" items="${lista}"> 
                    
                        <tr>
                            
                            <td><c:out value="${contacto.id}"/></td>
                            <td><c:out value="${contacto.nombre}"/></td>
                            <td><c:out value="${contacto.telefono}"/></td>
                            <td><c:out value="${contacto.correo}"/></td>
                            <td><a href="">eliminar</a></td>
                            
                           
                        </tr>  
                     </c:forEach>
                </tbody>
            </table>
        
    </body>
</html>
