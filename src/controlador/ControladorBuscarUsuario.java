package controlador;

import java.util.ArrayList;

import modelo.modeloDAO.AlquilerDAO;
import modelo.modeloDAO.ClienteDAO;
import modelo.modeloDAO.MultaDAO;
import modelo.modeloDAO.ProductoDAO;
import modelo.modeloDAO.Unidad_ProductoDAO;
import modelo.modeloVO.AlquilerVO;
import modelo.modeloVO.ClienteVO;
import modelo.modeloVO.MultaVO;
import modelo.modeloVO.ProductoVO;
import modelo.modeloVO.Unidad_ProductoVO;

public class ControladorBuscarUsuario {
    private ClienteDAO usuarioDAO;
    private AlquilerDAO alquilerDAO;
    private Unidad_ProductoDAO  unidadProductoDAO;
    private ProductoDAO productoDAO;
    private MultaDAO multaDAO;

    public ControladorBuscarUsuario() {
        usuarioDAO = new ClienteDAO();
        alquilerDAO = new AlquilerDAO();
        unidadProductoDAO = new Unidad_ProductoDAO();
        productoDAO = new ProductoDAO();
        multaDAO = new MultaDAO();
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

    public AlquilerVO obtenerAlquiler(String nombre) {
        for(ClienteVO cliente : usuarioDAO.obtenerClientes()) {
        	if(nombre.equals(cliente.getNombre())) {
                for(AlquilerVO alquiler : alquilerDAO.obtenerAlquileres()) {
                	if(nombre.equals(alquiler.getNombreCliente())) {
                		return alquiler;
                	}
                }
        	}
        }
        return null;
        
    }

    public ArrayList<ProductoVO> obtenerProductos(String nombre) {
        ArrayList<ProductoVO> productos = new ArrayList<>();

    	for(ClienteVO cliente : usuarioDAO.obtenerClientes()) {
        	if(nombre.equals(cliente.getNombre())) {
                for(AlquilerVO alquiler : alquilerDAO.obtenerAlquileres()) {
                	if(nombre.equals(alquiler.getNombreCliente())) {
                        for(Unidad_ProductoVO unidadProducto : unidadProductoDAO.obtenerUnidadesProducto()) {
                        	if(alquiler.getIdAlquiler() == unidadProducto.getIdAlquiler()) {
                                for(ProductoVO productoVO : productoDAO.obtenerProductos()){
                                    productos.add(productoVO);
                                }
                        		
                        	}
                        }
                	}
                }
        	}
        }
        return productos;
    }

    public boolean buscarMulta(AlquilerVO alquiler) {
        for(AlquilerVO alquilerVO : alquilerDAO.obtenerAlquileres()) {
            if(alquilerVO.getIdAlquiler() == alquiler.getIdAlquiler()) {
                for(MultaVO multaVO : multaDAO.obtenerMultas()) {
                    if(multaVO.getIdAlquiler() == alquiler.getIdAlquiler()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public double obtenerPrecio(ProductoVO productoVO) {
        
        return productoVO.getPrecio();
    }
}
