package controlador;

import java.util.ArrayList;

import modelo.modeloDAO.ProductoDAO;
import modelo.modeloVO.ProductoVO;

public class ControladorTodosLosProductos {
    private ProductoDAO productoDAO;

    public ControladorTodosLosProductos() {
        productoDAO = new ProductoDAO();
    }

    public ArrayList<ProductoVO> obtenerTodosProductos() {
        return productoDAO.obtenerProductos();
    }

    public ArrayList<ProductoVO> obtenerProductosDisponibles() {
        return productoDAO.obtenerProductosDisponibles();
    }

    public ArrayList<ProductoVO> obtenerProductosMenorEdad() {
        ArrayList<ProductoVO> sol = new ArrayList<>();

        for(ProductoVO productoVO : productoDAO.obtenerProductos()) {
            if(productoVO.getPegi() < 18) {
                sol.add(productoVO);
            }
        }

        return sol;
    }
}
