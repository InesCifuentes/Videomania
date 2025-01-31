package controlador;

import java.util.ArrayList;

import modelo.modeloDAO.ProductoDAO;
import modelo.modeloVO.ProductoVO;

public class ControladorBuscarProducto {
    private ProductoDAO productoDAO;

    public ControladorBuscarProducto() {
        productoDAO = new ProductoDAO();
    }

    public ArrayList<String> buscarProducto(String nombre) {
        ArrayList<String> productos = new ArrayList<>();
    	for(ProductoVO producto : productoDAO.obtenerProductos()) {
        	if(nombre.equals(producto.getNombreProducto())) {
        		productos.add(producto.getNombreProducto());
            }
        }
        return productos;
        
    }

    public ArrayList<String> buscarProductoCategoria(String categoria) {
        ArrayList<String> productos = new ArrayList<>();
        for(ProductoVO producto : productoDAO.obtenerProductos()) {
            if(categoria.equals(producto.getCategoria())) {
                productos.add(producto.getNombreProducto());
            }
        }
        return productos;
    }

    public ArrayList<String> buscarProductoGenero(String genero) {
        ArrayList<String> productos = new ArrayList<>();
        for(ProductoVO producto : productoDAO.obtenerProductos()) {
            if(genero.equals(producto.getGenero())) {
                productos.add(producto.getNombreProducto());
            }
        }
        return productos;
    }

   
}
