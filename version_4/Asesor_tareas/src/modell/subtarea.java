
package modell;

public class subtarea {

    private int subtarea_id;
    private String nombre;
    private String descripcion;
    private int Tarea_id;

    public subtarea(){
        
    }

    public subtarea(int subtarea_id, String nombre, String descripcion, int Tarea_id) {
        this.subtarea_id = subtarea_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.Tarea_id = Tarea_id;
    }

    public int getSubtarea_id() {
        return subtarea_id;
    }

    public void setSubtarea_id(int subtarea_id) {
        this.subtarea_id = subtarea_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTarea_id() {
        return Tarea_id;
    }

    public void setTarea_id(int Tarea_id) {
        this.Tarea_id = Tarea_id;
    }
    
    
    
}
