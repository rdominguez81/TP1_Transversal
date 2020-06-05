
package cine.controlador;

import cine.modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteData {
    
    private Connection con;
    
    public ClienteData(Conexion conexion){
        
        con = conexion.getConexion();
        
    }

    public ClienteData() {
    }
    
    public void altaCliente(Cliente cliente){
        
        try {
            String sql = "INSERT INTO CLIENTE (nombre, apellido, dni) VALUES (?, ?, ?);";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setLong(3, cliente.getDni());
            
            ps.executeUpdate();
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al dar de alta al cliente. " + ex.getMessage());
        }
    }
    
    public void bajaCliente(int id){
        
        try {
            String sql = "DELETE FROM ALUMNO WHERE ID = ?;";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ps.executeUpdate();
            ps.close();
            
            
        } catch (SQLException ex) {
            System.out.println("Error al dar de baja al cliente. " + ex.getMessage());
        }
    }
    
    
}
