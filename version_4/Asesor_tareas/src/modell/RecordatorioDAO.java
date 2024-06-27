package modell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecordatorioDAO extends DAO<recordatorio> {

    public RecordatorioDAO(Connection conn) {
        super(conn);
    }

    @Override
    public List<recordatorio> getAll() throws SQLException {
        List<recordatorio> recordatorios = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM Recordatorio");
            rs = ps.executeQuery();
            while (rs.next()) {
                recordatorios.add(new recordatorio(rs.getInt("recordatorio_id"), rs.getDate("fecha_hora"), rs.getInt("tarea_id")));
            }
        } finally {
            close(ps, rs);
        }
        return recordatorios;
    }

    @Override
    public recordatorio get(int id) throws SQLException {
        recordatorio recorda = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM Recordatorio WHERE recordatorio_id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                recorda= new recordatorio(rs.getInt("recordatorio_id"), rs.getDate("fecha_hora"), rs.getInt("tarea_id"));
            }
        } finally {
            close(ps, rs);
        }
        return recorda;
    }

    @Override
    public void save(recordatorio recorda) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO Recordatorio (fecha_hora, tarea_id) VALUES (?, ?)");
            ps.setDate(1, new java.sql.Date(recorda.getFecha_hora().getTime()));
            ps.setInt(2, recorda.getTarea_id());
            ps.executeUpdate();
        } finally {
            close(ps, null);
        }
    }

    @Override
    public void update(recordatorio recorda) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE Recordatorio SET fecha_hora = ?, tarea_id = ? WHERE recordatorio_id = ?");
            ps.setDate(1, new java.sql.Date(recorda.getFecha_hora().getTime()));
            ps.setInt(2, recorda.getTarea_id());
            ps.setInt(3, recorda.getRecordatorio_id());
            ps.executeUpdate();
        } finally {
            close(ps, null);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM recordatorio WHERE recordatorio_id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } finally {
            close(ps, null);
        }
    }
}
