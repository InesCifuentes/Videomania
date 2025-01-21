package modelo.modeloDAO;

import modelo.Conexion;
import modelo.modeloVO.GestorVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorDAO {

    public ArrayList<GestorVO> obtenerGestores() {
        ArrayList<GestorVO> gestores = new ArrayList<>();
        String sql = "SELECT * FROM gestores";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String password = rs.getString("password");
                gestores.add(new GestorVO(nombre, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gestores;
    }
}