
package modell;

public class tareas {
   
    private int tarea_id;
    private String nombre;
    private String descripcion;
    private int prioridad;
    private String estado;
    private int lista_id;
    
    public tareas(){
        
    }

    public tareas(int tarea_id, String nombre, String descripcion, int prioridad, String estado, int lista_id) {
        this.tarea_id = tarea_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = estado;
        this.lista_id = lista_id;
    }

    public int getTarea_id() {
        return tarea_id;
    }

    public void setTarea_id(int tarea_id) {
        this.tarea_id = tarea_id;
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

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getLista_id() {
        return lista_id;
    }

    public void setLista_id(int lista_id) {
        this.lista_id = lista_id;
    }
    
    
    
    
}
