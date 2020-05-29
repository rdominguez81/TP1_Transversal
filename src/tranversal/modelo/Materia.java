
package tranversal.modelo;

public class Materia {
    int id;
    String nombre;

    public Materia(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Materia(String nombre) {
        this.nombre = nombre;
    }

    public Materia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Materia" + "id:" + id + " nombre: " + nombre;
    }
}