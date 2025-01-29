package controlador;

import modelo.modeloDAO.UsuarioDAO;

public class ControladorBuscarUsuario {
    private UsuarioDAO usuarioDAO;

    public ControladorBuscarUsuario() {
        usuarioDAO = new UsuarioDAO();
    }

    public boolean buscarUsuario(String nombre) {
        return usuarioDAO.estaRegistrado(nombre, "clientes");
    }
}
