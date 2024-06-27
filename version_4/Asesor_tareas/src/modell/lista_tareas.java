
package modell;

import java.util.Date;

public class lista_tareas {
 private int lista_id;
 private String nombre;
 private Date fecha_creacion;
 private int Id_usuario;
 
 public lista_tareas(){
     
 }

    public lista_tareas(int lista_id, String nombre, Date fecha_creacion, int Id_usuario) {
        this.lista_id = lista_id;
        this.nombre = nombre;
        this.fecha_creacion = fecha_creacion;
        this.Id_usuario = Id_usuario;
    }

    public int getLista_id() {
        return lista_id;
    }

    public void setLista_id(int lista_id) {
        this.lista_id = lista_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int getId_usuario() {
        return Id_usuario;
    }

    public void setId_usuario(int Id_usuario) {
        this.Id_usuario = Id_usuario;
    }
 
 
 
}
