package modelo.modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Conexion;

public class UsuarioDAO {

    public boolean estaRegistrado(String nombreUsuario, String tipoUsuario) {
        
        String sql = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND tipo_usuario = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreUsuario);
            pstmt.setString(2, tipoUsuario);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean estaRegistrado(String nombreUsuario, String password, String tipoUsuario) {
        
        String sql = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND password = ? AND tipo_usuario = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreUsuario);
            pstmt.setString(2, password);
            pstmt.setString(3, tipoUsuario);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}
