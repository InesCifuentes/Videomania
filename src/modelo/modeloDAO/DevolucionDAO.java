package modelo.modeloDAO;

import modelo.Conexion;
import modelo.modeloVO.DevolucionVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DevolucionDAO {

    public ArrayList<DevolucionVO> obtenerDevoluciones() {
        ArrayList<DevolucionVO> devoluciones = new ArrayList<>();
        String sql = "SELECT * FROM Devolucion";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int idDevolucion = rs.getInt("ID_devolucion");
                int idAlquiler = rs.getInt("ID_alquiler");
                String fechaDevolucion = rs.getString("Fecha_devolucion");
                devoluciones.add(new DevolucionVO(idDevolucion, idAlquiler, fechaDevolucion));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return devoluciones;
    }

    public boolean agregarDevolucion(DevolucionVO devolucion) {
        String sql = "INSERT INTO Devolucion (ID_alquiler, Fecha_devolucion) VALUES (?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, devolucion.getIdAlquiler());
            pstmt.setString(2, devolucion.getFechaDevolucion());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarDevolucion(int idDevolucion) {
        String sql = "DELETE FROM Devolucion WHERE ID_devolucion = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idDevolucion);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
