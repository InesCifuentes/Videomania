package controlador;

import modelo.modeloDAO.UsuarioDAO;
import modelo.modeloVO.ClienteVO;

public class ControladorCrearCli {

    private UsuarioDAO usuarioDAO;
    private static final String tipoUsuario = "Cliente";

    public ControladorCrearCli() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public boolean verificarUsuario(String usuario) {
        
        return this.usuarioDAO.estaRegistrado(usuario, tipoUsuario);
    }

    public void crearUsuario(String usuario, String password, String edad) {
        ClienteVO nuevoUsuario = new ClienteVO(usuario, Integer.parseInt(edad),  password);
        this.usuarioDAO.agregarUsuario(nuevoUsuario, tipoUsuario);
    }
    
}
