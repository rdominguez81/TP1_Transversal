
package tranversal.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion 
{
    private String url = "jdbc:mysql://localhost/universidad";
    private String usuario = "universidad_usr";
    private String password = "123";

    private Connection conexion;
    
    public Conexion()
    {
        try 
        {        
            Class.forName("org.mariadb.jdbc.Driver");
        } 
        catch (ClassNotFoundException ex) 
        {
            System.out.println(ex.getMessage());
        }
    }
    
    /*public Conexion(String url, String usuario, String password) throws ClassNotFoundException 
    {
        this.url = url;
        this.usuario = usuario;
        this.password = password;

        //Cargamos las clases de mariadb que implementan JDBC
        Class.forName("org.mariadb.jdbc.Driver");
    }*/
    
    public Connection getConexion() 
    {
        if(conexion == null)
        {
            try 
            {
                conexion = DriverManager.getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC"+"&user="+usuario+"&password=" + password);
            } 
            catch (SQLException ex) 
            {
                System.out.println(ex.getMessage());
            }
        }
        return conexion;
    }
    
}
