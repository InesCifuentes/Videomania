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
        // Paso 1: Insertar en la tabla Usuario
        String sqlUsuario = "INSERT INTO Usuario (Nombre, Contrasena) VALUES (?, ?)";
        // Paso 2: Insertar en la tabla Cliente
        String sqlCliente = "INSERT INTO Cliente (Nombre, Edad) VALUES (?, ?)";
        try (Connection conn = Conexion.getConnection()) {
            conn.setAutoCommit(false); // Iniciar transacción

            // Insertar en la tabla Usuario
            try (PreparedStatement pstmtUsuario = conn.prepareStatement(sqlUsuario)) {
                pstmtUsuario.setString(1, cliente.getNombre());
                pstmtUsuario.setString(2, cliente.getPassword());
                pstmtUsuario.executeUpdate();
            }

            // Insertar en la tabla Cliente
            try (PreparedStatement pstmtCliente = conn.prepareStatement(sqlCliente)) {
                pstmtCliente.setString(1, cliente.getNombre());
                pstmtCliente.setInt(2, cliente.getEdad());
                pstmtCliente.executeUpdate();
            }

            conn.commit(); // Confirmar transacción
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
           
            try {
                if (Conexion.getConnection() != null) {
                    Conexion.getConnection().rollback(); // Deshacer transacción
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }
    }

    public boolean eliminarCliente(String nombre) {
        String sql = "DELETE FROM Cliente WHERE Nombre = ?";
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
        String sql = "SELECT c.Nombre, c.Edad, u.Contrasena FROM Cliente c JOIN Usuario u ON c.Nombre = u.Nombre";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                int edad = rs.getInt("Edad");
                String password = rs.getString("Contrasena");
                clientes.add(new ClienteVO(nombre, edad, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}