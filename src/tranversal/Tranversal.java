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
import tranversal.controlador.CursadaData;
import tranversal.controlador.MateriaData;
import tranversal.modelo.Alumno;
import tranversal.modelo.Cursada;
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
        
        ////////////////////////////////////////////////////////////////////////ALUMNOS
        
        Alumno alumno = new Alumno("Rodrigo Dominguez",LocalDate.of(1981, Month.AUGUST, 15),true);
        Alumno alumno2 = new Alumno("Ignacio Havelka",LocalDate.now(),true);
        Alumno alumno3 = new Alumno("Pablo Poder",LocalDate.now(),true);
        Alumno alumno4 = new Alumno("Sebastian Spartano",LocalDate.of(1995, Month.OCTOBER, 14),true);
        AlumnoData ad = new AlumnoData(con);
        ad.guardarAlumno(alumno);
        ad.guardarAlumno(alumno2);
        ad.guardarAlumno(alumno3);
        ad.guardarAlumno(alumno4);
        
        ////////////////////////////////////////////////////////////////////////MATERIAS
        
        Materia materia = new Materia("Lengua");
        Materia materia2 = new Materia("Matemática");
        Materia materia3 = new Materia("Programación");
        MateriaData md = new MateriaData(con);
        md.guardarMateria(materia);
        md.guardarMateria(materia2);
        md.guardarMateria(materia3);
        
        /*List<Materia> materias = new ArrayList<Materia>();  
        
        materias = md.obtenerMaterias();
        Iterator it = materias.iterator();
        Materia materiaTemp = new Materia();
        
        while(it.hasNext())
        {
            materiaTemp = (Materia)it.next();
            System.out.println(materiaTemp.toString());
            //System.out.println("ID: "+materiaTemp.getId());
            //System.out.println("NOMBRE: "+materiaTemp.getNombre());
            //System.out.println("///////////////////////////////////////////");
        }
        
         md.borrarMateria(1);
         
         materia2.setNombre("Matemática II");
         
         md.actualizarMateria(materia2);
         
         System.out.println(md.buscarMateria(2).getNombre());*/
         
        ////////////////////////////////////////////////////////////////////////CURSADAS
         
        Cursada cursada = new Cursada(alumno,materia,8);
        Cursada cursada2 = new Cursada(alumno2,materia2,9);
        Cursada cursada3 = new Cursada(alumno3,materia3,10);
        Cursada cursada11 = new Cursada(alumno,materia2,8);
        Cursada cursada12 = new Cursada(alumno2,materia3,9);
        Cursada cursada13 = new Cursada(alumno3,materia,10);
        Cursada cursada14 = new Cursada(alumno4, materia2, 10);
        CursadaData cd = new CursadaData(con);
        cd.guardarCursada(cursada);
        cd.guardarCursada(cursada2);
        cd.guardarCursada(cursada3);
        cd.guardarCursada(cursada11);
        cd.guardarCursada(cursada12);
        cd.guardarCursada(cursada13);
        cd.guardarCursada(cursada14);
        
        //System.out.println(ad.buscarAlumno(1).getNombre());
        
        List<Cursada> cursadas = new ArrayList<Cursada>();  
        
        cursadas = cd.obtenerCursadas();
        Iterator it = cursadas.iterator();
        Cursada cursadaTemp = new Cursada();
        
        while(it.hasNext())
        {
            cursadaTemp = (Cursada)it.next();
            System.out.println(cursadaTemp.toString());
        }
        /*
         md.borrarMateria(1);
         
         materia2.setNombre("Matemática II");
         
         md.actualizarMateria(materia2);
         
         System.out.println(md.buscarMateria(2).getNombre());*/

        List<Cursada> cursadasAlumno = new ArrayList<>();
        cursadasAlumno = cd.obtenerCursadasXAlumno(alumno3.getId());
        System.out.println("Materias cursadas por alumno:");
        for(Cursada c : cursadasAlumno){
            System.out.println(c.toString());
        }

        System.out.println("Alumnos que cursan Matematica:");
        List<Cursada> cursadasMateria = new ArrayList<>();
        cursadasMateria = cd.obtenerCursadasMateria(2);
        for(Cursada c : cursadasMateria){
            System.out.println(c.toString());
        }
        
        //pruebas modificacion
        Alumno alumnoPruebas = new Alumno("hola mundo",LocalDate.of(1995, Month.OCTOBER, 14),true);
        ad.guardarAlumno(alumnoPruebas);
        
        alumnoPruebas.setNombre("aaaa");
        ad.actualizarAlumno(alumnoPruebas);
    }
    
}
