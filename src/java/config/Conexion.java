
package config;
import java.sql.*;

/**
 *
 * @author triny
 */
public class Conexion {
    
    public Connection conectar() throws ClassNotFoundException{
        // que gestor utilizamos en que servidor y que puero y el nombre de la BBDD
        String url="jdbc:postgresql://localhost:5432/contacto";
        //Credenciales de la base de datos
        String usuario="postgres";
        String contrasena="12345";
    
        try{
            try { 
                 Class.forName("org.postgresql.Driver");
                } catch (ClassNotFoundException ex) {
                    System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
                }
            
            
            //Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url,usuario,contrasena);
            System.out.print("se conecto ala base de datos ");
            return conn;
        }catch(SQLException e){
            System.out.print(e);
            return null;
        } 
    }
}
