package modell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaTareasDAO extends DAO<lista_tareas> {

    public ListaTareasDAO(Connection conn) {
        super(conn);
    }

    @Override
    public List<lista_tareas> getAll() throws SQLException {
        List<lista_tareas> listaTareas = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM ListaTareas");
            rs = ps.executeQuery();
            while (rs.next()) {
                listaTareas.add(new lista_tareas(rs.getInt("lista_id"), rs.getString("nombre"), rs.getDate("fecha_creacion"), rs.getInt("Id_usuario")));
            }
        } finally {
            close(ps, rs);
        }
        return listaTareas;
    }

    @Override
    public lista_tareas get(int id) throws SQLException {
       lista_tareas listaTareas = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM ListaTareas WHERE lista_id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                listaTareas = new lista_tareas(rs.getInt("lista_id"), rs.getString("nombre"), rs.getDate("fecha_creacion"), rs.getInt("Id_usuario"));
            }
        } finally {
            close(ps, rs);
        }
        return listaTareas;
    }

    @Override
    public void save(lista_tareas listaTareas) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO ListaTareas (nombre, fecha_creacion, Id_usuario) VALUES (?, ?, ?)");
            ps.setString(1, listaTareas.getNombre());
            ps.setDate(2, new java.sql.Date(listaTareas.getFecha_creacion().getTime()));
            ps.setInt(3, listaTareas.getId_usuario());
            ps.executeUpdate();
        } finally {
            close(ps, null);
        }
    }

    @Override
    public void update(lista_tareas listaTareas) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE ListaTareas SET nombre = ?, fecha_creacion = ?, Id_usuario = ? WHERE lista_id = ?");
            ps.setString(1, listaTareas.getNombre());
            ps.setDate(2, new java.sql.Date(listaTareas.getFecha_creacion().getTime()));
            ps.setInt(3, listaTareas.getId_usuario());
            ps.setInt(4, listaTareas.getLista_id());
            ps.executeUpdate();
        } finally {
            close(ps, null);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM ListaTareas WHERE lista_id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } finally {
            close(ps, null);
        }
    }
}

