package controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import modelo.modeloDAO.AlquilerDAO;
import modelo.modeloDAO.ClienteDAO;
import modelo.modeloDAO.ProductoDAO;
import modelo.modeloDAO.Unidad_ProductoDAO;
import modelo.modeloVO.AlquilerVO;
import modelo.modeloVO.ClienteVO;
import modelo.modeloVO.ProductoVO;
import modelo.modeloVO.Unidad_ProductoVO;

public class ControladorAlquilaProducto {
    private ClienteDAO  clienteDAO;
    private ProductoDAO productoDAO;
    private AlquilerDAO alquilerDAO;
    private Unidad_ProductoDAO unidadProductoDAO;

    public ControladorAlquilaProducto() {
        clienteDAO = new ClienteDAO();
        productoDAO = new ProductoDAO();
        alquilerDAO = new AlquilerDAO();
        unidadProductoDAO = new Unidad_ProductoDAO();
    }

    public void modificaEstadoProducto(ClienteVO nombreCliente, ProductoVO nombreProducto, String estado) {
        for (ClienteVO cliente : clienteDAO.obtenerClientes()) {
            if (cliente.getNombre().equals(nombreCliente.getNombre())) {
                Unidad_ProductoVO unidadProducto = obtenerPrimeraUnidadDisponible(nombreProducto.getNombreProducto());
                if (unidadProducto != null) {
                    // Modificar el estado de la unidad de producto
                    unidadProductoDAO.modificarEstado(unidadProducto.getId(), estado);

                }
            }
        }
    }

    public void crearAlquiler(ClienteVO nombreCliente) {
        for (ClienteVO cliente : clienteDAO.obtenerClientes()) {
            if (cliente.getNombre().equals(nombreCliente.getNombre())) {
                ArrayList<Unidad_ProductoVO> unidadesProcesando = unidadProductoDAO.obtenerUnidadesProcesando();
                if (!unidadesProcesando.isEmpty()) {
                    // Crear el alquiler
                    LocalDate fecha = LocalDate.now();
                    String fechaActual = fecha.toString();
                    // El id del alquiler se genera de forma aleatoria por la base de datos por lo que hay que obtenerlo
                    AlquilerVO alquilerVO = new AlquilerVO(0, nombreCliente.getNombre(), fechaActual);
                    alquilerDAO.agregarAlquiler(alquilerVO);
                    
                    // Obtener la ID del alquiler
                    int id_alquiler = alquilerDAO.obtenerUltimoIdAlquiler();
                    System.out.println("Alquiler creado"+id_alquiler);
                    // Modificar el estado y el ID de alquiler de las unidades de producto
                    for (Unidad_ProductoVO unidadProducto : unidadesProcesando) {
                        unidadProductoDAO.modificarEstado(unidadProducto.getId(), "Alquilado");
                        unidadProductoDAO.modificarIdAlquiler(unidadProducto.getId(), id_alquiler);
                    }
                }
            }
        }
    }

    public void cancelarProcesamiento() {
        ArrayList<Unidad_ProductoVO> unidadesProcesando = unidadProductoDAO.obtenerUnidadesProcesando();
        for (Unidad_ProductoVO unidadProducto : unidadesProcesando) {
            unidadProductoDAO.modificarEstado(unidadProducto.getId(), "Disponible");
        }
    }

    private Unidad_ProductoVO obtenerPrimeraUnidadDisponible(String nombreProducto) {
        for (Unidad_ProductoVO unidadProducto : unidadProductoDAO.obtenerUnidadesProducto()) {
            if (unidadProducto.getNombreProducto().equals(nombreProducto) && unidadProducto.getEstado().equals("Disponible")) {
                return unidadProducto;
            }
        }
        return null;
    }
}
