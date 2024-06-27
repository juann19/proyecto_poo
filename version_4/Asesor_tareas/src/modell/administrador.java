
package modell;


public class administrador extends usuario {
   
    private int admin_id;
    private int Id_usuario;
    private String permisos;

        public administrador(){
            
        }

    public administrador(int admin_id, int Id_usuario, String permisos, int id, String usuario, String Correo, String Contraseña, String Nombre) {
        super(id, usuario, Correo, Contraseña, Nombre);
        this.admin_id = admin_id;
        this.Id_usuario = Id_usuario;
        this.permisos = permisos;
    }
        
    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public int getId_usuario() {
        return Id_usuario;
    }

    public void setId_usuario(int Id_usuario) {
        this.Id_usuario = Id_usuario;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }
        
    
    
}
