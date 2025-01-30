package modelo.modeloDAO;

import modelo.Conexion;
import modelo.modeloVO.CategoriaVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDAO {

    public ArrayList<CategoriaVO> obtenerCategorias() {
        ArrayList<CategoriaVO> categorias = new ArrayList<>();
        String sql = "SELECT * FROM Categoria";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String categoria = rs.getString("Categoria");
                categorias.add(new CategoriaVO(categoria));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categorias;
    }

    public boolean agregarCategoria(CategoriaVO categoria) {
        String sql = "INSERT INTO Categoria (Categoria) VALUES (?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, categoria.getCategoria());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarCategoria(String categoria) {
        String sql = "DELETE FROM Categoria WHERE Categoria = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, categoria);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
