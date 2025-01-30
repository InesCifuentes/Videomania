package controlador;

import modelo.modeloDAO.ClienteDAO;
import modelo.modeloVO.ClienteVO;

public class ControladorInicioCli {

    private ClienteDAO usuarioDAO;
    
    public ControladorInicioCli() {
        usuarioDAO = new ClienteDAO();
    }

    public boolean verificarUsuario(String usuario) {
    	for(ClienteVO cliente : usuarioDAO.obtenerClientes()) {
        	if(usuario.equals(cliente.getNombre())) {
        		return true;
        	}
        }
        return false;
    }

    public boolean verificarPas(String usuario, String password) {
    	for(ClienteVO cliente : usuarioDAO.obtenerClientes()) {
        	if(usuario.equals(cliente.getNombre())) {
        		if(password.equals(cliente.getPassword())) {
        			return true;
        		}
        		
        	}
        }
        return false;
    }
    
}
