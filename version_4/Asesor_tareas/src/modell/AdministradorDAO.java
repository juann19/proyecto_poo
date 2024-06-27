package modell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDAO extends DAO<administrador> {

    public AdministradorDAO(Connection conn) {
        super(conn);
    }

    @Override
    public List<administrador> getAll() throws SQLException {
        List<administrador> administradores = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM Administrador");
            rs = ps.executeQuery();
            while (rs.next()) {
                administradores.add(new administrador(rs.getInt("admin_id"), rs.getInt("Id_usuario"), rs.getString("permisos"), rs.getInt("id"), rs.getString("usuario"), rs.getString("Correo"), rs.getString("Contraseña"), rs.getString("Nombre")));
            }
        } finally {
            close(ps, rs);
        }
        return administradores;
    }

    @Override
    public administrador get(int id) throws SQLException {
        administrador admin = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM administrador WHERE admin_id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                admin = new administrador(rs.getInt("admin_id"), rs.getInt("Id_usuario"), rs.getString("permisos"), rs.getInt("id"), rs.getString("usuario"), rs.getString("Correo"), rs.getString("Contraseña"), rs.getString("Nombre"));
            }
        } finally {
            close(ps, rs);
        }
        return admin;
    }

    @Override
    public void save(administrador admin) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO administrador (Id_usuario, permisos, id, usuario, Correo, Contraseña, Nombre) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, admin.getId_usuario());
            ps.setString(2, admin.getPermisos());
            ps.setInt(3, admin.getId());
            ps.setString(4, admin.getUsuario());
            ps.setString(5, admin.getCorreo());
            ps.setString(6, admin.getContraseña());
            ps.setString(7, admin.getNombre());
            ps.executeUpdate();
        } finally {
            close(ps, null);
        }
    }

    @Override
    public void update(administrador admin) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE Administrador SET Id_usuario = ?, permisos = ?, usuario = ?, Correo = ?, Contraseña = ?, Nombre = ? WHERE admin_id = ?");
            ps.setInt(1, admin.getId_usuario());
            ps.setString(2, admin.getPermisos());
            ps.setString(3, admin.getUsuario());
            ps.setString(4, admin.getCorreo());
            ps.setString(5, admin.getContraseña());
            ps.setString(6, admin.getNombre());
            ps.setInt(7, admin.getAdmin_id());
            ps.executeUpdate();
        } finally {
            close(ps, null);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM Administrador WHERE admin_id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } finally {
            close(ps, null);
        }
    }
}
