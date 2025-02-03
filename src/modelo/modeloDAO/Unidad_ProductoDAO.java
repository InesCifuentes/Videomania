package modelo.modeloDAO;

import modelo.Conexion;
import modelo.modeloVO.Unidad_ProductoVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Unidad_ProductoDAO {

    public ArrayList<Unidad_ProductoVO> obtenerUnidadesProducto() {
        ArrayList<Unidad_ProductoVO> unidadesProducto = new ArrayList<>();
        String sql = "SELECT * FROM Unidad_Producto";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("ID_unidad_producto");
                String nombreProducto = rs.getString("Nombre_producto");
                int idAlquiler = rs.getInt("ID_alquiler");
                String estado = rs.getString("Estado");
                unidadesProducto.add(new Unidad_ProductoVO(id, nombreProducto, idAlquiler, estado));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return unidadesProducto;
    }

    public boolean agregarUnidadProducto(Unidad_ProductoVO unidadProducto) {
        String sql = "INSERT INTO Unidad_Producto (Nombre_producto, ID_alquiler, Estado) VALUES (?, NULL, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, unidadProducto.getNombreProducto());
            pstmt.setString(2, unidadProducto.getEstado());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarUnidadProducto(int id) {
        String sql = "DELETE FROM Unidad_Producto WHERE ID_unidad_producto = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modificarEstado(int id, String nuevoEstado) {
        String sql = "UPDATE Unidad_Producto SET Estado = ? WHERE ID_unidad_producto = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nuevoEstado);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Unidad_ProductoVO obtenerUnidadPorAlquiler(int idAlquiler) {
        String sql = "SELECT * FROM Unidad_Producto WHERE ID_alquiler = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idAlquiler);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("ID_unidad_producto");
                    String nombreProducto = rs.getString("Nombre_producto");
                    String estado = rs.getString("Estado");
                    return new Unidad_ProductoVO(id, nombreProducto, idAlquiler, estado);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean modificarIdAlquiler(int id, Integer nuevoIdAlquiler) {
        String sql = "UPDATE Unidad_Producto SET ID_alquiler = ? WHERE ID_unidad_producto = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            if (nuevoIdAlquiler != null) {
                pstmt.setInt(1, nuevoIdAlquiler);
            } else {
                pstmt.setNull(1, java.sql.Types.INTEGER);
            }
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Unidad_ProductoVO> obtenerUnidadesProcesando() {
        ArrayList<Unidad_ProductoVO> unidadesProcesando = new ArrayList<>();
        String sql = "SELECT * FROM Unidad_Producto WHERE Estado = 'Procesando'";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("ID_unidad_producto");
                String nombreProducto = rs.getString("Nombre_producto");
                int idAlquiler = rs.getInt("ID_alquiler");
                String estado = rs.getString("Estado");
                unidadesProcesando.add(new Unidad_ProductoVO(id, nombreProducto, idAlquiler, estado));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return unidadesProcesando;
    }
}
