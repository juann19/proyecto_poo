package modell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubtareaDAO extends DAO<subtarea> {

    public SubtareaDAO(Connection conn) {
        super(conn);
    }

    @Override
    public List<subtarea> getAll() throws SQLException {
        List<subtarea> subtareas = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM Subtarea");
            rs = ps.executeQuery();
            while (rs.next()) {
                subtareas.add(new subtarea(rs.getInt("subtarea_id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("tarea_id")));
            }
        } finally {
            close(ps, rs);
        }
        return subtareas;
    }

    @Override
    public subtarea get(int id) throws SQLException {
        subtarea subtarea = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM Subtarea WHERE subtarea_id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                subtarea = new subtarea(rs.getInt("subtarea_id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("tarea_id"));
            }
        } finally {
            close(ps, rs);
        }
        return subtarea;
    }

    @Override
    public void save(subtarea subt) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO Subtarea (nombre, descripcion, tarea_id) VALUES (?, ?, ?)");
            ps.setString(1, subt.getNombre());
            ps.setString(2, subt.getDescripcion());
            ps.setInt(3, subt.getTarea_id());
            ps.executeUpdate();
        } finally {
            close(ps, null);
        }
    }

    @Override
    public void update(subtarea subt) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE Subtarea SET nombre = ?, descripcion = ?, tarea_id = ? WHERE subtarea_id = ?");
            ps.setString(1, subt.getNombre());
            ps.setString(2, subt.getDescripcion());
            ps.setInt(3, subt.getTarea_id());
            ps.setInt(4, subt.getSubtarea_id());
            ps.executeUpdate();
        } finally {
            close(ps, null);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM Subtarea WHERE subtarea_id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } finally {
            close(ps, null);
        }
    }
}
