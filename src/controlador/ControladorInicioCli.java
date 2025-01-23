package controlador;

import modelo.modeloDAO.UsuarioDAO;

public class ControladorInicioCli {

    private UsuarioDAO usuarioDAO;
    private static final String tipoUsuario = "cliente";

    public ControladorInicioCli() {
        usuarioDAO = new UsuarioDAO();
    }

    public boolean verificarUsuario(String usuario) {
        
        return this.usuarioDAO.estaRegistrado(usuario, tipoUsuario);
    }

    public boolean verificarPas(String usuario, String password) {
        
        return this.usuarioDAO.estaRegistrado(usuario, password, tipoUsuario);
    }
    
}
