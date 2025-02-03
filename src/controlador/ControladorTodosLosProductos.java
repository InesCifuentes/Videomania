package controlador;

import java.util.ArrayList;

import modelo.modeloDAO.ProductoDAO;
import modelo.modeloVO.ProductoVO;

public class ControladorTodosLosProductos {
    private ProductoDAO productoDAO;

    public ControladorTodosLosProductos() {
        productoDAO = new ProductoDAO();
    }

    public ArrayList<ProductoVO> obtenerProductos() {
        return productoDAO.obtenerProductos();
    }

    public ArrayList<ProductoVO> obtenerProductosDisponibles() {
        return productoDAO.obtenerProductosDisponibles();
    }
}
