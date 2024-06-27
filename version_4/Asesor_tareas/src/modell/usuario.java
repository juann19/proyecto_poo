
package modell;

public class usuario {
    
    private int id;
    private String usuario;
    private String Correo;
    private String Contraseña;
    private String Nombre;

        public usuario(){
            
        }
    public usuario(int id, String usuario, String Correo, String Contraseña, String Nombre) {
        this.id = id;
        this.usuario = usuario;
        this.Correo = Correo;
        this.Contraseña = Contraseña;
        this.Nombre = Nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
    
}
