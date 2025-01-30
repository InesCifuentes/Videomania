package controlador;

import modelo.modeloDAO.ProductoDAO;

public class ControladorNuevoProducto {
    private ProductoDAO productoDAO;

    public ControladorNuevoProducto() {
        this.productoDAO = new ProductoDAO();
    }

    public void crearProducto(String nombre, String categoria, String genero, String pegi) {
        this.productoDAO.agregarProducto(nombre, categoria, genero, pegi);
    }
}
