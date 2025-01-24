package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Esta línea es para conectarse a SQLServer mediante autenticación de Windows(está puesta con el "nombre de usuario de Inés)
    private static final String URL = "jdbc:sqlserver://DESKTOP-U52F6BQ\\SQLEXPRESS:1433;databaseName=Videomania;encrypt=false;trustServerCertificate=true;integratedSecurity=true;";
  
    // Deja el usuario y la contraseña vacíos porque usas autenticación de Windows
    private static final String USUARIO = ""; 
    private static final String PASSWORD = ""; 

    public static Connection getConnection() throws SQLException {
        // Crea la conexión utilizando el driver JDBC de SQL Server
        return DriverManager.getConnection(URL);
    }
}
