package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Contacto;
import modelo.Contactos;

/**
 *
 * @author triny
 */
@WebServlet(name = "ContactosControl", urlPatterns = {"/ContactosControl"})
public class ContactosControl extends HttpServlet {

   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Contactos contacto = new Contactos();
        String accion;
        RequestDispatcher dispatcher = null;
        accion = request.getParameter("accion");
        
        if (accion ==null || accion.isEmpty()){
            dispatcher = request.getRequestDispatcher("views/index.jsp");
            List<Contacto> listaContactos = contacto.listarContactos();
            request.setAttribute("lista",listaContactos);
        }else if("agregar".equals(accion)){
            dispatcher = request.getRequestDispatcher("views/registrar.jsp");
        }else if("insertar".equals(accion)){
            
            // el id no se recupera por que es undato autoincrement
            //int id= Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String telefono = request.getParameter("telefono");
            String correo = request.getParameter("correo");
            Contacto contact = new Contacto(nombre,telefono,correo);
            contacto.InsertarContacto(contact);
            dispatcher = request.getRequestDispatcher("views/index.jsp");
            List<Contacto> listaContactos = contacto.listarContactos();
            request.setAttribute("lista",listaContactos);
            System.out.println("SE ha insertado un dato");
            
        }else if("buscar".equals(accion)){
            dispatcher = request.getRequestDispatcher("views/buscar.jsp");
            
        }else if("eliminar".equals(accion)){
            
            String nombre = request.getParameter("nombre");
            
          
            contacto.eliminarContacto(nombre);
            
            
            dispatcher = request.getRequestDispatcher("views/index.jsp");
            List<Contacto> listaContactos = contacto.listarContactos();
            request.setAttribute("lista",listaContactos);
        }else{
            dispatcher = request.getRequestDispatcher("views/index.jsp");
            List<Contacto> listaContactos = contacto.listarContactos();
            request.setAttribute("lista",listaContactos);
        }
        
        
        dispatcher.forward(request,response); 
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            doGet(request,response);
    }
   

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
