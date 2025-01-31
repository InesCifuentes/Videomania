package controlador;

import modelo.modeloDAO.ClienteDAO;
import modelo.modeloVO.ClienteVO;

public class ControladorCrearCli {

    private ClienteDAO usuarioDAO;
    
    public ControladorCrearCli() {
        this.usuarioDAO = new ClienteDAO();
    }

    public boolean verificarUsuario(String usuario) {
        for(ClienteVO cliente : usuarioDAO.obtenerClientes()) {
        	if(usuario.equals(cliente.getNombre())) {
        		return true;
        	}
        }
        return false;
        
    }

    public void crearUsuario(String usuario, String password, String edad) {
        usuarioDAO.agregarCliente(usuario, password, Integer.parseInt(edad));
    }
    
}
