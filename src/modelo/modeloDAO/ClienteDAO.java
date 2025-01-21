package modelo.modeloDAO;

import modelo.Conexion;
import modelo.modeloVO.ClienteVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {

    public boolean insertarCliente(ClienteVO cliente) {
        String sql = "INSERT INTO clientes (nombre, edad, password) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getNombre());
            pstmt.setInt(2, cliente.getEdad());
            pstmt.setString(3, cliente.getPassword());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarCliente(String nombre) {
        String sql = "DELETE FROM clientes WHERE nombre = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<ClienteVO> obtenerClientes() {
        ArrayList<ClienteVO> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                String password = rs.getString("password");
                clientes.add(new ClienteVO(nombre, edad, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}