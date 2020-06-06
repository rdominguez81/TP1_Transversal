/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tranversal.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import tranversal.modelo.Alumno;
import tranversal.modelo.Cursada;
import tranversal.modelo.Materia;

/**
 *
 * @author Usuario
 */
public class CursadaData
{
    private Connection con = null;

    public CursadaData(Conexion conexion)
    {
        con = conexion.getConexion();
    }

    public void guardarCursada(Cursada cursada)
    {
        try
        {
            String query = "INSERT INTO cursada (idAlumno, idMateria, nota) VALUES ( ? , ? , ? )";

            PreparedStatement statement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,cursada.getAlumno().getId());
            statement.setInt(2,cursada.getMateria().getId());
            statement.setInt(3,cursada.getNota());

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next())
            {
                cursada.setId(rs.getInt(1));

                Alumno a = cursada.getAlumno();
                Materia m = cursada.getMateria();

                System.out.println("Se insertó la Cursada del alumno "+a.getNombre()+" sobre la Materia "+m.getNombre()+" de forma correcta!");
            }
            else
            {
                System.out.println("No se pudo obtener el id luego de insertar la cursada");
            }
            statement.close();

        }
        catch (SQLException ex)
        {
            System.out.println("ERROR: Inserción Cursada " + ex.getMessage());
        }
    }

    public List<Cursada> obtenerCursadas()
    {
        List<Cursada> cursadas = new ArrayList<Cursada>();

        try
        {
            String query = "SELECT * FROM cursada";
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            Cursada cursada;
            AlumnoData ad = new AlumnoData(con);
            MateriaData md = new MateriaData(con);
            //Alumno a2 = new Alumno("Rodri", LocalDate.now(), true);
            //Materia m2 = new Materia("Mate");
            while(resultSet.next())
            {
                cursada = new Cursada();
                cursada.setId(resultSet.getInt("id"));

                Alumno a = ad.buscarAlumno(resultSet.getInt("idAlumno"));
                //Alumno a = a2;
                cursada.setAlumno(a);

                Materia m = md.buscarMateria(resultSet.getInt("idMateria"));
                //Materia m = m2;
                cursada.setMateria(m);

                cursada.setNota(resultSet.getInt("nota"));

                cursadas.add(cursada);
            }
            statement.close();
        }
        catch (SQLException ex)
        {
            System.out.println("ERROR: Obtención Cursadas" + ex.getMessage());
        }

        return cursadas;
    }

    public List<Cursada> obtenerCursadasXAlumno(int idAlumno)
    {
        List<Cursada> cursadas = new ArrayList<Cursada>();

        try
        {
            String sql = "SELECT * FROM cursada WHERE idAlumno = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1,idAlumno);
            ResultSet resultSet = statement.executeQuery();

            AlumnoData ad = new AlumnoData(con);
            MateriaData md = new MateriaData(con);
            Cursada cursada;
            while(resultSet.next())
            {
                cursada = new Cursada();
                cursada.setId(resultSet.getInt("id"));

                Alumno a = ad.buscarAlumno(resultSet.getInt("idAlumno"));
                cursada.setAlumno(a);

                Materia m = md.buscarMateria(resultSet.getInt("idMateria"));
                cursada.setMateria(m);

                cursada.setNota(resultSet.getInt("nota"));

                cursadas.add(cursada);
            }
            statement.close();
        }
        catch (SQLException ex)
        {
            System.out.println("ERROR: Obtención Cursada x Alumno" + ex.getMessage());
        }

        return cursadas;
    }

    public List<Materia> obtenerMateriasCursadas(int idMateria)
    {
        List<Materia> materias = new ArrayList<Materia>();

        try
        {
            String query = "SELECT * FROM cursada WHERE idMateria = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1,idMateria);
            ResultSet resultSet = statement.executeQuery();
            Materia materia;
            while(resultSet.next())
            {
                materia = new Materia();

                materia.setId(resultSet.getInt("idMateria"));
                materia.setNombre(resultSet.getString("nombre"));

                materias.add(materia);
            }
            statement.close();
        }
        catch (SQLException ex)
        {
            System.out.println("ERROR: Obtención Materias Cursadas" + ex.getMessage());
        }

        return materias;
    }

    public List<Cursada> obtenerCursadasMateria(int idMateria){
        List<Cursada> cursadas = new ArrayList<>();
        AlumnoData ad = new AlumnoData(con);
        MateriaData md = new MateriaData(con);

        try{
            String query ="SELECT * FROM cursada WHERE idMateria = "+idMateria;
            PreparedStatement s = con.prepareStatement(query);
            ResultSet resultSet = s.executeQuery();
            Cursada cursada;

            while(resultSet.next()){
                cursada = new Cursada(ad.buscarAlumno(resultSet.getInt("idAlumno")),md.buscarMateria(resultSet.getInt("idMateria")),resultSet.getInt("nota"));
                cursadas.add(cursada);
            }
        }catch (SQLException e){
            System.out.println("ERROR: " + e.getMessage());
        }
        return cursadas;
    }

    public List<Materia> obtenerMateriasNOCursadas(int idAlumno)
    {
        List<Materia> materias = new ArrayList<Materia>();

        try
        {
            String query = "SELECT * FROM materia WHERE id NOT IN (SELECT idMateria FROM cursada WHERE idAlumno = ?)";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1,idAlumno);
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
            System.out.println("ERROR: Obtención de Materias NO Cursadas por un Alumno" + ex.getMessage());
        }

        return materias;
    }

    public void borrarCursadaDeUnaMateriaDeunAlumno(int idAlumno,int idMateria)
    {
        try
        {
            String query = "DELETE FROM cursada WHERE (idAlumno = ?) and (idMateria = ?)";

            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1,idAlumno);
            statement.setInt(2,idMateria);

            if(statement.executeUpdate() == 1)
            {
                System.out.println("Se eliminó la Cursada de forma correcta");
            }
            else
            {
                System.out.println("La Cursada a eliminar no se encontró en la BD!");
            }

            statement.close();

        }
        catch (SQLException ex)
        {
            System.out.println("ERROR: Eliminación Cursada" + ex.getMessage());
        }
    }

    public void actualizarNotaCursada(int idAlumno,int idMateria, int nota)
    {
        try
        {
            String query = "UPDATE cursada SET nota = ? WHERE (idAlumno = ?) and (idMateria = ?)";

            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1,nota);
            statement.setInt(2,idAlumno);
            statement.setInt(3,idMateria);

            if(statement.executeUpdate() == 1)
            {
                System.out.println("Se actualizó la nota de forma correcta");
            }
            else
            {
                System.out.println("La Cursada a actualizar no se encontró en la BD!");
            }

            statement.close();

        }
        catch (SQLException ex)
        {
            System.out.println("ERROR: Actualización Nota " + ex.getMessage());
        }
    }
}
