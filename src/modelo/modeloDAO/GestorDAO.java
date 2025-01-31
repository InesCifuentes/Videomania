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
        String sql = "SELECT Nombre, Contrasena FROM Gestor";
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
        String sqlGestor = "INSERT INTO Gestor (Nombre, Contrasena) VALUES (?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlGestor)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, contrasena);
            pstmt.executeUpdate();
            return true; // Si todo va bien, devuelve verdadero
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Si ocurre un error, devuelve falso
        }
    }

    // Método para eliminar un gestor
    public boolean eliminarGestor(String nombre) {
        String sqlGestor = "DELETE FROM Gestor WHERE Nombre = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlGestor)) {
            pstmt.setString(1, nombre);
            pstmt.executeUpdate();
            return true; // Si todo va bien, devuelve verdadero
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Si ocurre un error, devuelve falso
        }
    }
}