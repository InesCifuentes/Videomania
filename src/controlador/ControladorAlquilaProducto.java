package controlador;

import java.time.LocalDate;
import java.util.Random;

import modelo.modeloDAO.AlquilerDAO;
import modelo.modeloDAO.ClienteDAO;
import modelo.modeloDAO.ProductoDAO;
import modelo.modeloVO.AlquilerVO;
import modelo.modeloVO.ClienteVO;
import modelo.modeloVO.ProductoVO;

public class ControladorAlquilaProducto {
    private ClienteDAO  clienteDAO;
    private ProductoDAO productoDAO;
    private AlquilerDAO alquilerDAO;

    public ControladorAlquilaProducto() {
        clienteDAO = new ClienteDAO();
        productoDAO = new ProductoDAO();
        alquilerDAO = new AlquilerDAO();
    }

    public void alquilarProducto(ClienteVO nombreCliente, ProductoVO nombreProducto) {
        for(ClienteVO cliente : clienteDAO.obtenerClientes()) {
            if(cliente.getNombre().equals(nombreCliente.getNombre())) {
                for(ProductoVO producto : productoDAO.obtenerProductos()) {
                    if(producto.getNombreProducto().equals(nombreProducto.getNombreProducto())) {
                        //ALQUILAR EL PRODUCTO
                        Random random = new Random();
                        int id_alquiler = random.nextInt();
                        LocalDate fecha = LocalDate.now();
                        String fechaActual = fecha.toString();
                        AlquilerVO alquilerVO = new AlquilerVO(id_alquiler, nombreCliente.getNombre(), fechaActual);
                        alquilerDAO.agregarAlquiler(alquilerVO);
                    }
                }
            }
        }
    }

	
}
