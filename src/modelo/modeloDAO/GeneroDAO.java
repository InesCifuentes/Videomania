package modelo.modeloDAO;

import modelo.Conexion;
import modelo.modeloVO.GeneroVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GeneroDAO {

    public ArrayList<GeneroVO> obtenerGeneros() {
        ArrayList<GeneroVO> generos = new ArrayList<>();
        String sql = "SELECT * FROM Genero";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String genero = rs.getString("Genero");
                generos.add(new GeneroVO(genero));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return generos;
    }

    public boolean agregarGenero(GeneroVO genero) {
        String sql = "INSERT INTO Genero (Genero) VALUES (?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, genero.getGenero());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarGenero(String genero) {
        String sql = "DELETE FROM Genero WHERE Genero = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, genero);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
