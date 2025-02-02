package controlador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import modelo.modeloDAO.AlquilerDAO;
import modelo.modeloDAO.ClienteDAO;
import modelo.modeloDAO.DevolucionDAO;
import modelo.modeloDAO.MultaDAO;
import modelo.modeloDAO.ProductoDAO;
import modelo.modeloDAO.Unidad_ProductoDAO;
import modelo.modeloVO.AlquilerVO;
import modelo.modeloVO.ClienteVO;
import modelo.modeloVO.DevolucionVO;
import modelo.modeloVO.MultaVO;
import modelo.modeloVO.ProductoVO;
import modelo.modeloVO.Unidad_ProductoVO;
import modelo.modeloVO.UsuarioVO;

public class ControladorBuscarUsuario {
    private ClienteDAO usuarioDAO;
    private AlquilerDAO alquilerDAO;
    private Unidad_ProductoDAO  unidadProductoDAO;
    private ProductoDAO productoDAO;
    private MultaDAO multaDAO;
    private DevolucionDAO devolucionDAO;

    public ControladorBuscarUsuario() {
        usuarioDAO = new ClienteDAO();
        alquilerDAO = new AlquilerDAO();
        unidadProductoDAO = new Unidad_ProductoDAO();
        productoDAO = new ProductoDAO();
        multaDAO = new MultaDAO();
        devolucionDAO = new DevolucionDAO();
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    	for(ClienteVO cliente : usuarioDAO.obtenerClientes()) {
        	if(nombre.equals(cliente.getNombre())) {
                for(AlquilerVO alquilerVO : alquilerDAO.obtenerAlquileres()) {
                	if(nombre.equals(alquilerVO.getNombreCliente())) {
                        LocalDate fechaAlquiler = LocalDate.parse(alquilerVO.getFechaAlquiler(), formatter);
                        LocalDate fechaActual = LocalDate.now();
                        if(fechaAlquiler.isEqual(fechaActual)) {
                            // La fecha de alquiler es el mismo día que la fecha actual
                            for(Unidad_ProductoVO unidadProducto : unidadProductoDAO.obtenerUnidadesProducto()) {
                                if(alquilerVO.getIdAlquiler() == unidadProducto.getIdAlquiler()) {
                                    if(unidadProducto.getEstado().equals("Procesando")) {
                                        for(ProductoVO productoVO : productoDAO.obtenerProductos()){
                                            if(productoVO.getNombreProducto() == unidadProducto.getNombreProducto()) {
                                                productos.add(productoVO);
                                            }
                                       
                                        }
                                    }
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

    public ArrayList<ProductoVO> obtenerProdDevolver(String usuario) {
        ArrayList<ProductoVO> devolver = new ArrayList<>();

        for(ClienteVO cliente : usuarioDAO.obtenerClientes()) {
        	if(usuario.equals(cliente.getNombre())) {
                for(AlquilerVO alquiler : alquilerDAO.obtenerAlquileres()) {
                	if(usuario.equals(alquiler.getNombreCliente())) {
                        for(DevolucionVO devolucionVO : devolucionDAO.obtenerDevoluciones()) {
                            if(alquiler.getIdAlquiler() == devolucionVO.getIdAlquiler()) {
                                for(Unidad_ProductoVO unidadProducto : unidadProductoDAO.obtenerUnidadesProducto()) {
                                    if(alquiler.getIdAlquiler() == unidadProducto.getIdAlquiler()) {
                                        if(unidadProducto.getEstado().equals("Alquilado")) {
                                            for(ProductoVO productoVO : productoDAO.obtenerProductos()){
                                                if(productoVO.getNombreProducto() == unidadProducto.getNombreProducto()){
                                                    devolver.add(productoVO);
                                                }
                                            }
                                        }
                                        
                                        
                                    }
                                }
                            }
                        
                        }
                	}
                }
        	}
        }
        
        return devolver;
    }

    public void eliminarAlquiler(String usuario) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for(UsuarioVO usuarioVO : usuarioDAO.obtenerClientes()) {
            if(usuario.equals(usuarioVO.getNombre())) {
                for(AlquilerVO alquilerVO : alquilerDAO.obtenerAlquileres()) {
                    if(usuario.equals(alquilerVO.getNombreCliente())) {
                        LocalDate fechaAlquiler = LocalDate.parse(alquilerVO.getFechaAlquiler(), formatter);
                        LocalDate fechaActual = LocalDate.now();
                        if(fechaAlquiler.isEqual(fechaActual)) {
                            // La fecha de alquiler es el mismo día que la fecha actual
                            int idAlquiler = alquilerVO.getIdAlquiler();
                            alquilerDAO.eliminarAlquiler(idAlquiler);
                        }
                        
                    }
                }
            }
        }
    }
}
