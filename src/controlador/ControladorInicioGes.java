package controlador;

import modelo.modeloDAO.UsuarioDAO;

public class ControladorInicioGes {
    
    private UsuarioDAO usuarioDAO;
    private static final String tipoUsuario = "Gestor";

    public ControladorInicioGes() {
        usuarioDAO = new UsuarioDAO();
    }

    public boolean verificarUsuario(String usuario) {
        
        return this.usuarioDAO.estaRegistrado(usuario, tipoUsuario);
    }

    public boolean verificarPas(String usuario, String password) {
        
        return this.usuarioDAO.estaRegistrado(usuario, password, tipoUsuario);
    }
}
