package controlador;

import modelo.modeloDAO.GestorDAO;
import modelo.modeloVO.GestorVO;

public class ControladorInicioGes {
    
    private GestorDAO usuarioDAO;
    
    public ControladorInicioGes() {
        usuarioDAO = new GestorDAO();
    }

    public boolean verificarUsuario(String usuario) {
    	for(GestorVO gestor : this.usuarioDAO.obtenerGestores()) {
    		if(usuario.equals(gestor.getNombre())) {
    			return true;
    		}
    	}
    	return false;
         
     }

    public boolean verificarPas(String usuario, String password) {
    	for(GestorVO gestor : this.usuarioDAO.obtenerGestores()) {
    		if(usuario.equals(gestor.getNombre())) {
    			if(password.equals(gestor.getPassword())){
    				return true;
    			}
    			
    		}
    	}
    	return false;
        
    }
}
