package controlador;

import java.util.ArrayList;

import modelo.modeloDAO.ProductoDAO;
import modelo.modeloVO.ProductoVO;

public class ControladorEliminarProducto {
    private ProductoDAO productoDAO;

    public ControladorEliminarProducto() {
        productoDAO = new ProductoDAO();
    }

    public void eliminarProducto(ArrayList<ProductoVO> productos) {
        for(ProductoVO producto : productos) {
            productoDAO.eliminarProducto(producto.getNombreProducto());
        }
    }
}
