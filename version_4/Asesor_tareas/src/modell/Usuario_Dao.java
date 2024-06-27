package modell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Usuario_Dao extends DAO<usuario> {

    public Usuario_Dao(Connection conn) {
        super(conn);
    }

    @Override
    public List<usuario> getAll() throws SQLException {
        List<usuario> usuarios = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM Usuario");
            rs = ps.executeQuery();
            while (rs.next()) {
                usuarios.add(new usuario(rs.getInt("id"), rs.getString("usuario"), rs.getString("correo"), rs.getString("contraseña"), rs.getString("nombre")));
            }
        } finally {
            close(ps, rs);
        }
        return usuarios;
    }

    @Override
    public usuario get(int id) throws SQLException {
        usuario usua = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM Usuario WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                usua = new usuario(rs.getInt("id"), rs.getString("usuario"), rs.getString("correo"), rs.getString("contraseña"), rs.getString("nombre"));
            }
        } finally {
            close(ps, rs);
        }
        return usua;
    }

    @Override
    public void save(usuario usua) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO Usuario (usuario, correo, contraseña, nombre) VALUES (?, ?, ?, ?)");
            ps.setString(1, usua.getUsuario());
            ps.setString(2, usua.getCorreo());
            ps.setString(3, usua.getContraseña());
            ps.setString(4, usua.getNombre());
            ps.executeUpdate();
        } finally {
            close(ps, null);
        }
    }

    @Override
    public void update(usuario usua) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE Usuario SET usuario = ?, correo = ?, contraseña = ?, nombre = ? WHERE id = ?");
            ps.setString(1, usua.getUsuario());
            ps.setString(2, usua.getCorreo());
            ps.setString(3, usua.getContraseña());
            ps.setString(4, usua.getNombre());
            ps.setInt(5, usua.getId());
            ps.executeUpdate();
        } finally {
            close(ps, null);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM Usuario WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } finally {
            close(ps, null);
        }
    }
}
