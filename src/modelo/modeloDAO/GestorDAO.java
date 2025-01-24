package modelo.modeloDAO;

import modelo.Conexion;
import modelo.modeloVO.GestorVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorDAO {

    public ArrayList<GestorVO> obtenerGestores() {
        ArrayList<GestorVO> gestores = new ArrayList<>();
        String sql = "SELECT g.Nombre, u.Contrasena " +
                "FROM Gestor g " +
                "JOIN Usuario u ON g.Nombre = u.Nombre";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String password = rs.getString("Contrasena");
                gestores.add(new GestorVO(nombre, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gestores;
    }

    // Método para añadir un nuevo gestor
    public boolean agregarGestor(String nombre, String contrasena) {
        // Paso 1: Insertar en la tabla Usuario
        String sqlUsuario = "INSERT INTO Usuario (Nombre, Contrasena) VALUES (?, ?)";
        // Paso 2: Insertar en la tabla Gestor
        String sqlGestor = "INSERT INTO Gestor (Nombre) VALUES (?)";

        try (Connection conn = Conexion.getConnection()) {
            // Insertar en la tabla Usuario
            try (PreparedStatement pstmtUsuario = conn.prepareStatement(sqlUsuario)) {
                pstmtUsuario.setString(1, nombre);
                pstmtUsuario.setString(2, contrasena);
                pstmtUsuario.executeUpdate();
            }

            // Insertar en la tabla Gestor
            try (PreparedStatement pstmtGestor = conn.prepareStatement(sqlGestor)) {
                pstmtGestor.setString(1, nombre);
                pstmtGestor.executeUpdate();
            }

            return true; // Si todo va bien, devuelve verdadero
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Si ocurre un error, devuelve falso
        }
    }
    
    // Método para eliminar un gestor
    public boolean eliminarGestor(String nombre) {
        // Paso 1: Eliminar de la tabla Gestor
        String sqlGestor = "DELETE FROM Gestor WHERE Nombre = ?";

        // Paso 2: Eliminar de la tabla Usuario (si también deseas eliminar al usuario)
        String sqlUsuario = "DELETE FROM Usuario WHERE Nombre = ?";

        try (Connection conn = Conexion.getConnection()) {
            // Eliminar de la tabla Gestor
            try (PreparedStatement pstmtGestor = conn.prepareStatement(sqlGestor)) {
                pstmtGestor.setString(1, nombre);
                pstmtGestor.executeUpdate();
            }

            // Eliminar de la tabla Usuario (solo si quieres eliminar al usuario también)
            try (PreparedStatement pstmtUsuario = conn.prepareStatement(sqlUsuario)) {
                pstmtUsuario.setString(1, nombre);
                pstmtUsuario.executeUpdate();
            }

            return true; // Si todo va bien, devuelve verdadero
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Si ocurre un error, devuelve falso
        }
    }
}