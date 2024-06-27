
package modell;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class ConexionDB {
    private static Connection conn;
   private static final String driver="database.properties";
   
   /* metodo para conectar a la base de datos*/
 public ConexionDB(){
   conn = null;
 
  try{
     Class.forName(driver);
     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/asesor_tareas","root","");
     if(conn != null){
         System.out.println("Conexion Establecida..");
     }
     
   } catch (ClassNotFoundException | SQLException e){
       System.out.println("Error al conectar"+e);
   }
 }
 /*Metodo que retorna la coneccion*/
  public static Connection getConnection() {
        if (conn == null) {
            try (InputStream input = ConexionDB.class.getClassLoader().getResourceAsStream(driver)) {
                Properties props = new Properties();
                if (input == null) {
                    System.out.println("no funciona " + driver);
                    return null;
                }
                // Load properties file
                props.load(input);
                String driver = props.getProperty("db.driver");
                String url = props.getProperty("db.url");
                String user = props.getProperty("db.user");
                String password = props.getProperty("db.password");

                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Conexion Establecida..");
            } catch (ClassNotFoundException | SQLException | IOException e) {
                e.printStackTrace();
                System.out.println("Error al conectar: " + e.getMessage());
            }
        }
        return conn;
    }
  /*Metodo para desconectarnos de la base de datos*/
public void desconectar(){
  conn = null;
  if(conn==null){
      System.out.println("Conexion Terminada");
  }
}
}
