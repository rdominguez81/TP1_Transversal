/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tranversal.controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tranversal.modelo.Materia;

/**
 *
 * @author Usuario
 */
public class MateriaData 
{
    private Connection con = null;

    public MateriaData(Conexion conexion) 
    {
        con = conexion.getConexion();
    }    
    
    public void guardarMateria(Materia materia)
    {
        try 
        {   
            String query = "INSERT INTO materia (nombre) VALUES ( ? )";

            PreparedStatement statement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, materia.getNombre());

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) 
            {
                materia.setId(rs.getInt(1));
                materia.setId(rs.getInt(1));
                System.out.println("Se insertó la Materia "+materia.getNombre()+" de forma correcta!");                    
            } 
            else 
            {
                System.out.println("ERROR: Obtención de ID luego de inserción de Materia");
            }
            statement.close();    
        } 
        catch (SQLException ex) 
        {
            System.out.println("ERROR: Inserción Materia: " + ex.getMessage());
        }
    }
    
    public List<Materia> obtenerMaterias()
    {
        List<Materia> materias = new ArrayList<Materia>();
    
        try 
        {
            String query = "SELECT * FROM materia";
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            Materia materia;
            while(resultSet.next())
            {
                materia = new Materia();
                materia.setId(resultSet.getInt("id"));
                materia.setNombre(resultSet.getString("nombre"));              

                materias.add(materia);
            }      
            statement.close();
        } 
        catch (SQLException ex) 
        {
            System.out.println("ERROR: Obtención de alumnos: " + ex.getMessage());
        }
        
        return materias;
    }
    
    public Materia buscarMateria(int id)
    {
        Materia materia = null;
        
        try 
        {
            String query = "SELECT * FROM materia WHERE id = ?";

            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1,id);           
            
            ResultSet resultSet=statement.executeQuery();
            
            materia = new Materia();
            
            while(resultSet.next())
            {
                materia.setId(resultSet.getInt("id"));
                materia.setNombre(resultSet.getString("nombre"));               
            }      
            statement.close();   
        } 
        catch (SQLException ex) 
        {
            System.out.println("ERROR: Inserción de Materia: " + ex.getMessage());
        }
        
        return materia;
    }
    
    public void borrarMateria (int id)
    {
        try
        {
            String query = "DELETE FROM materia WHERE id = ?";

            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1,id);      
            
            if(statement.executeUpdate() == 1)
            {
                 System.out.println("Se eliminó la Materia de forma correcta");
            }
            else
            {
                System.out.println("La materia a eliminar no existía en la BD!");
            }          
            
            statement.close();
    
        } 
        catch (SQLException ex) 
        {
            System.out.println("ERROR: Eliminación de materia: " + ex.getMessage());
        }   
    }
    
    public void actualizarMateria(Materia materia)
    {
        try 
        {
            String query = "UPDATE materia SET nombre = ? WHERE id = ?";

            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1,materia.getNombre());
            statement.setInt(2,materia.getId());
            
            if(statement.executeUpdate() == 1)
            {
                System.out.println("Se actualizó la materia de forma correcta");
            }
            else
            {
                System.out.println("La materia a actualizar no existía en la BD!");
            }        
          
            statement.close();
    
        } 
        catch (SQLException ex) 
        {
            System.out.println("ERROR: Inserción de Materia: " + ex.getMessage());
        }   
    }
}
    

