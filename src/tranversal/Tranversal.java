/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tranversal;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tranversal.controlador.AlumnoData;
import tranversal.controlador.Conexion;
import tranversal.controlador.MateriaData;
import tranversal.modelo.Alumno;
import tranversal.modelo.Materia;

/**
 *
 * @author nacho
 */
public class Tranversal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Conexion con = new Conexion();
        con.getConexion();
        
        Materia materia = new Materia("Lengua");
        Materia materia2 = new Materia("Matemática");
        Materia materia3 = new Materia("Programación");
        MateriaData md = new MateriaData(con);
        //md.guardarMateria(materia);
        //md.guardarMateria(materia2);
        //md.guardarMateria(materia3);
        
        List<Materia> materias = new ArrayList<Materia>();  
        
        materias = md.obtenerMaterias();
        Iterator it = materias.iterator();
        Materia materiaList = new Materia();
        
        while(it.hasNext())
        {
            materiaList = (Materia)it.next();
            System.out.println(materiaList.toString());
            /*System.out.println("ID: "+materiaList.getId());
            System.out.println("NOMBRE: "+materiaList.getNombre());
            System.out.println("/////////////////////////////////////////////////");*/
        }
        
         md.borrarMateria(1);
         
         materia2.setNombre("Matemática II");
         
         md.actualizarMateria(materia2);
         
         System.out.println(md.buscarMateria(2).getNombre());
    }
    
}
