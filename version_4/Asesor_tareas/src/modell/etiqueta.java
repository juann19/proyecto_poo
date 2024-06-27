
package modell;

public class etiqueta {
    private int etiqueta_id;
    private String nombre;
    private int tarea_id;
    
    public etiqueta(){
        
    }

    public etiqueta(int etiqueta_id, String nombre, int tarea_id) {
        this.etiqueta_id = etiqueta_id;
        this.nombre = nombre;
        this.tarea_id = tarea_id;
    }

    public int getEtiqueta_id() {
        return etiqueta_id;
    }

    public void setEtiqueta_id(int etiqueta_id) {
        this.etiqueta_id = etiqueta_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTarea_id() {
        return tarea_id;
    }

    public void setTarea_id(int tarea_id) {
        this.tarea_id = tarea_id;
    }
    
    
    
}
