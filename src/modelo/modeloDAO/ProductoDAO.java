package modelo.modeloDAO;

import modelo.Conexion;
import modelo.modeloVO.ProductoVO;
import modelo.modeloVO.Unidad_ProductoVO;

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

    public ArrayList<ProductoVO> obtenerProductosDisponibles() {
        ArrayList<ProductoVO> productosDisponibles = new ArrayList<>();
        ArrayList<ProductoVO> productos = obtenerProductos();
        for (ProductoVO producto : productos) {
            if (estaDisponible(producto.getNombreProducto())) {
                productosDisponibles.add(producto);
            }
        }
        return productosDisponibles;
    }

    public boolean agregarProducto(ProductoVO producto) {
        String sqlProducto = "INSERT INTO Producto (Nombre_producto, Categoria, Genero, PEGI, Precio) VALUES (?, ?, ?, ?, ?)";
        String sqlUnidadProducto = "INSERT INTO Unidad_Producto (Nombre_producto, ID_alquiler, Estado) VALUES (?, NULL, 'Disponible')";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmtProducto = conn.prepareStatement(sqlProducto);
             PreparedStatement pstmtUnidadProducto = conn.prepareStatement(sqlUnidadProducto)) {

            // Verificar si el producto ya existe
            if (!existeProducto(producto)) {
                // Agregar el producto
                pstmtProducto.setString(1, producto.getNombreProducto());
                pstmtProducto.setString(2, producto.getCategoria());
                pstmtProducto.setString(3, producto.getGenero());
                pstmtProducto.setInt(4, producto.getPegi());
                pstmtProducto.setDouble(5, producto.getPrecio());
                pstmtProducto.executeUpdate();
            }

            // Agregar una unidad de producto
            pstmtUnidadProducto.setString(1, producto.getNombreProducto());
            pstmtUnidadProducto.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarProducto(String nombreProducto) {
        String sqlProducto = "DELETE FROM Producto WHERE Nombre_producto = ?";
        String sqlUnidadProducto = "DELETE FROM Unidad_Producto WHERE Nombre_producto = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmtProducto = conn.prepareStatement(sqlProducto);
             PreparedStatement pstmtUnidadProducto = conn.prepareStatement(sqlUnidadProducto)) {

            // Eliminar todas las unidades de producto
            pstmtUnidadProducto.setString(1, nombreProducto);
            pstmtUnidadProducto.executeUpdate();

            // Eliminar el producto
            pstmtProducto.setString(1, nombreProducto);
            pstmtProducto.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean existeProducto(ProductoVO producto) {
        String sql = "SELECT COUNT(*) FROM Producto WHERE Nombre_producto = ? AND Categoria = ? AND Genero = ? AND PEGI = ? AND Precio = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, producto.getNombreProducto());
            pstmt.setString(2, producto.getCategoria());
            pstmt.setString(3, producto.getGenero());
            pstmt.setInt(4, producto.getPegi());
            pstmt.setDouble(5, producto.getPrecio());
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean estaDisponible(String nombreProducto) {
        String sql = "SELECT COUNT(*) FROM Unidad_Producto WHERE Nombre_producto = ? AND Estado = 'Disponible'";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreProducto);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
