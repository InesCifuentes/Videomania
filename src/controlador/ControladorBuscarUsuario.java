package controlador;

import java.util.ArrayList;

import modelo.modeloDAO.AlquilerDAO;
import modelo.modeloDAO.ClienteDAO;
import modelo.modeloDAO.Unidad_ProductoDAO;
import modelo.modeloVO.AlquilerVO;
import modelo.modeloVO.ClienteVO;
import modelo.modeloVO.Unidad_ProductoVO;

public class ControladorBuscarUsuario {
    private ClienteDAO usuarioDAO;
    private AlquilerDAO alquilerDAO;
    private Unidad_ProductoDAO  unidadProductoDAO;

    public ControladorBuscarUsuario() {
        usuarioDAO = new ClienteDAO();
        alquilerDAO = new AlquilerDAO();
    }

    public boolean buscarUsuario(String nombre) {
    	for(ClienteVO cliente : usuarioDAO.obtenerClientes()) {
        	if(nombre.equals(cliente.getNombre())) {
        		return true;
        	}
        }
        return false;
        
    }

    public boolean buscarAlquiler(String nombre) {
    	for(ClienteVO cliente : usuarioDAO.obtenerClientes()) {
        	if(nombre.equals(cliente.getNombre())) {
                for(AlquilerVO alquiler : alquilerDAO.obtenerAlquileres()) {
                	if(nombre.equals(alquiler.getNombreCliente())) {
                		return true;
                	}
                }
        	}
        }
        return false;
    }

    public ArrayList<String> obtenerProductos(String nombre) {
        ArrayList<String> productos = new ArrayList<>();

    	for(ClienteVO cliente : usuarioDAO.obtenerClientes()) {
        	if(nombre.equals(cliente.getNombre())) {
                for(AlquilerVO alquiler : alquilerDAO.obtenerAlquileres()) {
                	if(nombre.equals(alquiler.getNombreCliente())) {
                        for(Unidad_ProductoVO unidadProducto : unidadProductoDAO.obtenerUnidadesProducto()) {
                        	if(alquiler.getIdAlquiler() == unidadProducto.getIdAlquiler()) {
                        		productos.add(unidadProducto.getNombreProducto());
                        	}
                        }
                	}
                }
        	}
        }
        return productos;
    }
}
