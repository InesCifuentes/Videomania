package modelo.modeloDAO;

import modelo.Conexion;
import modelo.modeloVO.ProductoVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDAO {

    public ArrayList<ProductoVO> obtenerProductos() {
        ArrayList<ProductoVO> productos = new ArrayList<>();
        String sql = "SELECT * FROM Producto";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String nombreProducto = rs.getString("Nombre_producto");
                String categoria = rs.getString("Categoria");
                String genero = rs.getString("Genero");
                int pegi = rs.getInt("PEGI");
                double precio = rs.getDouble("Precio");
                productos.add(new ProductoVO(nombreProducto, categoria, genero, pegi, precio));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    public boolean agregarProducto(ProductoVO producto) {
        String sql = "INSERT INTO Producto (Nombre_producto, Categoria, Genero, PEGI, Precio) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, producto.getNombreProducto());
            pstmt.setString(2, producto.getCategoria());
            pstmt.setString(3, producto.getGenero());
            pstmt.setInt(4, producto.getPegi());
            pstmt.setDouble(5, producto.getPrecio());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarProducto(String nombreProducto) {
        String sql = "DELETE FROM Producto WHERE Nombre_producto = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreProducto);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
