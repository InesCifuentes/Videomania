package modelo.modeloDAO;

import modelo.Conexion;
import modelo.modeloVO.MultaVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MultaDAO {

    public ArrayList<MultaVO> obtenerMultas() {
        ArrayList<MultaVO> multas = new ArrayList<>();
        String sql = "SELECT * FROM Multa";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int idMulta = rs.getInt("ID_multa");
                int idAlquiler = rs.getInt("ID_alquiler");
                double cantidad = rs.getDouble("Cantidad");
                multas.add(new MultaVO(idMulta, idAlquiler, cantidad));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return multas;
    }

    public boolean agregarMulta(MultaVO multa) {
        String sql = "INSERT INTO Multa (ID_alquiler, Cantidad) VALUES (?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, multa.getIdAlquiler());
            pstmt.setDouble(2, multa.getCantidad());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarMulta(int idMulta) {
        String sql = "DELETE FROM Multa WHERE ID_multa = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idMulta);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}