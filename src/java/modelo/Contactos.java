
package modelo;

import config.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author triny
 */
public class Contactos {
    
    Connection conexion;
    
    //hacemos un constructor para conectarnos a la bbdd
    public Contactos(){
        try {
            // de la clase conexion creamos el objeto conn
            Conexion conn = new Conexion();
            // y accedemos al metodo conectar
            conexion = conn.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Contactos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Contacto> listarContactos(){
        //este metodo lista todos los contactos en nuestar base d edatos
        //cre una variable de tipo para prepara 
        PreparedStatement pst;
        ResultSet rs;
        List<Contacto> lista = new ArrayList<>();
        try{
            pst= conexion.prepareStatement("select nombre,telefono,correo from datos;");
            rs = pst.executeQuery();
            
            while(rs.next()){
                
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                Contacto contacto = new Contacto(nombre,telefono,correo);
                lista.add(contacto);
            }
            return lista;
        }catch(SQLException e){
            System.out.println(e.toString());
            return null;
        }
    }
    
    public Contacto mostrarContacto(String _nombre){
        PreparedStatement pst;
        ResultSet rs;
        Contacto contacto = null;
        try{
            pst=conexion.prepareStatement("select nombre, telefono, correo from datos where id=?;");
            pst.setString(1,_nombre);
            rs=pst.executeQuery();
            
            while(rs.next()){
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                contacto = new Contacto(nombre,telefono,correo);
            }
            return contacto;
        }catch(SQLException e){
            System.out.println(e.toString());
            return null;
        }
    }
    
    
    
    //al parecer no esta el error aqui 
    public boolean InsertarContacto(Contacto contacto){
        //se conecta a l a base de datos e inserta una lista de tipo contaco
        PreparedStatement pst;      
        try{
            pst=conexion.prepareStatement("insert into datos(nombre, telefono, correo)values(?,?,?);");
            pst.setString(1,contacto.getNombre());
            pst.setString(2,contacto.getTelefono());
            pst.setString(3,contacto.getCorreo());
            pst.execute();
            System.out.println("se pudo realizar la insercion");
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            System.out.println("no se puede realizar la consulta");
            return false;
        }
    }
    
    
    public boolean eliminarContacto(String _nombre){
        PreparedStatement pst;      
        try{
            pst = conexion.prepareStatement("delete from datos where nombre=?;");
            pst.setString(1,_nombre);
            pst.execute();
            //pst.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
}
