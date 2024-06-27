

package modell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TareaDAO extends DAO<tareas> {

    public TareaDAO(Connection conn) {
        super(conn);
    }

    @Override
    public List<tareas> getAll() throws SQLException {
        List<tareas> Tareas = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM Tarea");
            rs = ps.executeQuery();
            while (rs.next()) {
                Tareas.add(new tareas(rs.getInt("tarea_id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("prioridad"), rs.getString("estado"), rs.getInt("lista_id")));
            }
        } finally {
            close(ps, rs);
        }
        return Tareas;
    }

    @Override
    public tareas get(int id) throws SQLException {
        tareas tarea = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM Tarea WHERE tarea_id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                tarea = new tareas(rs.getInt("tarea_id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("prioridad"), rs.getString("estado"), rs.getInt("lista_id"));
            }
        } finally {
            close(ps, rs);
        }
        return tarea;
    }

    @Override
    public void save(tareas tarea) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO Tarea (nombre, descripcion, prioridad, estado, lista_id) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, tarea.getNombre());
            ps.setString(2, tarea.getDescripcion());
            ps.setInt(3, tarea.getPrioridad());
            ps.setString(4, tarea.getEstado());
            ps.setInt(5, tarea.getLista_id());
            ps.executeUpdate();
        } finally {
            close(ps, null);
        }
    }

    @Override
    public void update(tareas tarea) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE Tarea SET nombre = ?, descripcion = ?, prioridad = ?, estado = ?, lista_id = ? WHERE tarea_id = ?");
            ps.setString(1, tarea.getNombre());
            ps.setString(2, tarea.getDescripcion());
            ps.setInt(3, tarea.getPrioridad());
            ps.setString(4, tarea.getEstado());
            ps.setInt(5, tarea.getLista_id());
            ps.setInt(6, tarea.getTarea_id());
            ps.executeUpdate();
        } finally {
            close(ps, null);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM Tarea WHERE tarea_id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } finally {
            close(ps, null);
        }
    }
}

    
