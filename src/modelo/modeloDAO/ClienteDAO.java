package modelo.modeloDAO;

import modelo.Conexion;
import modelo.modeloVO.ClienteVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {

    public ArrayList<ClienteVO> obtenerClientes() {
        ArrayList<ClienteVO> clientes = new ArrayList<>();
        String sql = "SELECT Nombre, Contrasena, Edad FROM Cliente";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String password = rs.getString("Contrasena");
                int edad = rs.getInt("Edad");
                clientes.add(new ClienteVO(nombre, password, edad));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    // Método para añadir un nuevo cliente
    public boolean agregarCliente(String nombre, String contrasena, int edad) {
        String sqlCliente = "INSERT INTO Cliente (Nombre, Contrasena, Edad) VALUES (?, ?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlCliente)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, contrasena);
            pstmt.setInt(3, edad);
            pstmt.executeUpdate();
            return true; // Si todo va bien, devuelve verdadero
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Si ocurre un error, devuelve falso
        }
    }

    // Método para eliminar un cliente
    public boolean eliminarCliente(String nombre) {
        String sqlCliente = "DELETE FROM Cliente WHERE Nombre = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlCliente)) {
            pstmt.setString(1, nombre);
            pstmt.executeUpdate();
            return true; // Si todo va bien, devuelve verdadero
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Si ocurre un error, devuelve falso
        }
    }
}