package modell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EtiquetaDAO extends DAO<etiqueta> {

    public EtiquetaDAO(Connection conn) {
        super(conn);
    }

    @Override
    public List<etiqueta> getAll() throws SQLException {
        List<etiqueta> etiquetas = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM Etiqueta");
            rs = ps.executeQuery();
            while (rs.next()) {
                etiquetas.add(new etiqueta(rs.getInt("etiqueta_id"), rs.getString("nombre"), rs.getInt("tarea_id")));
            }
        } finally {
            close(ps, rs);
        }
        return etiquetas;
    }

    @Override
    public etiqueta get(int id) throws SQLException {
        etiqueta etiqueta = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM etiqueta WHERE etiqueta_id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                etiqueta = new etiqueta(rs.getInt("etiqueta_id"), rs.getString("nombre"), rs.getInt("tarea_id"));
            }
        } finally {
            close(ps, rs);
        }
        return etiqueta;
    }

    @Override
    public void save(etiqueta eti) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO etiqueta (nombre, tarea_id) VALUES (?, ?)");
            ps.setString(1, eti.getNombre());
            ps.setInt(2, eti.getTarea_id());
            ps.executeUpdate();
        } finally {
            close(ps, null);
        }
    }

    @Override
    public void update(etiqueta eti) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE Etiqueta SET nombre = ?, tarea_id = ? WHERE etiqueta_id = ?");
            ps.setString(1, eti.getNombre());
            ps.setInt(2, eti.getTarea_id());
            ps.setInt(3, eti.getEtiqueta_id());
            ps.executeUpdate();
        } finally {
            close(ps, null);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM etiqueta WHERE etiqueta_id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } finally {
            close(ps, null);
        }
    }
}
