
package modell;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class DAO<T> {
    protected Connection conn;

    public DAO(Connection conn) {
        this.conn = conn;
    }
    
    protected void close(PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
   public abstract List<T> getAll() throws SQLException;
   public abstract T get(int id) throws SQLException;
   public abstract void save(T t) throws SQLException;
   public abstract void update(T t) throws SQLException;
   public abstract void delete(int id) throws SQLException;
   
    
}
