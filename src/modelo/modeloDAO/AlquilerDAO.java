package modelo.modeloDAO;

import modelo.Conexion;
import modelo.modeloVO.AlquilerVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlquilerDAO {

    public ArrayList<AlquilerVO> obtenerAlquileres() {
        ArrayList<AlquilerVO> alquileres = new ArrayList<>();
        String sql = "SELECT * FROM Alquiler";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int idAlquiler = rs.getInt("ID_alquiler");
                String nombreCliente = rs.getString("Nombre_cliente");
                String fechaAlquiler = rs.getString("Fecha_alquiler");
                alquileres.add(new AlquilerVO(idAlquiler, nombreCliente, fechaAlquiler));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alquileres;
    }

    public boolean agregarAlquiler(AlquilerVO alquiler) {
        String sql = "INSERT INTO Alquiler (Nombre_cliente, Fecha_alquiler) VALUES (?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, alquiler.getNombreCliente());
            pstmt.setString(2, alquiler.getFechaAlquiler());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarAlquiler(int idAlquiler) {
        String sql = "DELETE FROM Alquiler WHERE ID_alquiler = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idAlquiler);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int obtenerIdAlquiler(String nombreCliente, String fechaAlquiler) {
        String sql = "SELECT ID_alquiler FROM Alquiler WHERE Nombre_cliente = ? AND Fecha_alquiler = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreCliente);
            pstmt.setString(2, fechaAlquiler);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("ID_alquiler");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Return -1 if not found
    }

    public int obtenerUltimoIdAlquiler() {
        String sql = "SELECT MAX(ID_alquiler) AS ultimo_id FROM Alquiler";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("ultimo_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Return -1 if not found
    }
}
