package controlador;

import modelo.modeloDAO.ProductoDAO;
import modelo.modeloVO.ClienteVO;
import modelo.modeloVO.ProductoVO;

public class ControladorNuevoProducto {
    private ProductoDAO productoDAO;

    public ControladorNuevoProducto() {
        this.productoDAO = new ProductoDAO();
    }

    public boolean existeProducto(String nombre) {
        for(ProductoVO producto : productoDAO.obtenerProductos()) {
        	if(nombre.equals(producto.getNombreProducto())) {
        		return true;
        	}
        }
        return false;
        
    }
    public void crearProducto(String nombre, String categoria, String genero, String pegi) {
        int edad = 0;

        if(pegi.equals("Si")) {
            edad = 18;
        }
        else if(pegi.equals("No")) {
            edad = 0;
        }

        ProductoVO producto = new ProductoVO(nombre, categoria, genero, edad, 3.0);
        productoDAO.agregarProducto(producto);
    }
}
