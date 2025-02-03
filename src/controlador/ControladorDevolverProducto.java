package controlador;

import java.time.LocalDate;

import modelo.modeloDAO.AlquilerDAO;
import modelo.modeloDAO.DevolucionDAO;
import modelo.modeloDAO.Unidad_ProductoDAO;
import modelo.modeloVO.DevolucionVO;
import modelo.modeloVO.Unidad_ProductoVO;

public class ControladorDevolverProducto {
    private AlquilerDAO alquilerDAO;
    private DevolucionDAO devolucionDAO;
    private Unidad_ProductoDAO unidadProductoDAO;

    public ControladorDevolverProducto() {
        alquilerDAO = new AlquilerDAO();
        devolucionDAO = new DevolucionDAO();
        unidadProductoDAO = new Unidad_ProductoDAO();
    }

    public void devolverProducto(int idAlquiler) {
        // Obtener la unidad de producto alquilada
        Unidad_ProductoVO unidadProducto = unidadProductoDAO.obtenerUnidadPorAlquiler(idAlquiler);
        if (unidadProducto != null) {
            // Crear la devolución
            LocalDate fecha = LocalDate.now();
            String fechaDevolucion = fecha.toString();
            DevolucionVO devolucionVO = new DevolucionVO(0, idAlquiler, fechaDevolucion);
            devolucionDAO.agregarDevolucion(devolucionVO);

            // Modificar el estado y el ID de alquiler de la unidad de producto
            unidadProductoDAO.modificarEstado(unidadProducto.getId(), "Disponible");
            unidadProductoDAO.modificarIdAlquiler(unidadProducto.getId(), null);
        }
    }
}
