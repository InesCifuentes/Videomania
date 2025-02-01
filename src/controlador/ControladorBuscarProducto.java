package controlador;

import java.util.ArrayList;

import modelo.modeloDAO.CategoriaDAO;
import modelo.modeloDAO.GeneroDAO;
import modelo.modeloDAO.ProductoDAO;
import modelo.modeloVO.CategoriaVO;
import modelo.modeloVO.GeneroVO;
import modelo.modeloVO.ProductoVO;

public class ControladorBuscarProducto {
    private ProductoDAO productoDAO;
    private GeneroDAO generoDAO;
    private CategoriaDAO categoriaDAO;

    public ControladorBuscarProducto() {
        productoDAO = new ProductoDAO();
        generoDAO = new GeneroDAO();
        categoriaDAO = new CategoriaDAO();
    }

    public String[] obtenerGeneros() {
        ArrayList<GeneroVO> generosArrayList = generoDAO.obtenerGeneros();
        String[] generosArray = new String[generosArrayList.size()];
        for (int i = 0; i < generosArrayList.size(); i++) {
            generosArray[i] = generosArrayList.get(i).getGenero();
        }
        return generosArray;
    }

    public String[] obtenerCategorias() {
       ArrayList<CategoriaVO> categoriasArrayList = categoriaDAO.obtenerCategorias();
         String[] categoriasArray = new String[categoriasArrayList.size()];
        for (int i = 0; i < categoriasArrayList.size(); i++) {
            categoriasArray[i] = categoriasArrayList.get(i).getCategoria();
        }
        return categoriasArray;

    }

    public ArrayList<ProductoVO> buscarProducto(String nombre) {
        ArrayList<ProductoVO> productos = new ArrayList<>();
    	for(ProductoVO producto : productoDAO.obtenerProductos()) {
        	if(nombre.equals(producto.getNombreProducto())) {
        		productos.add(producto);
            }
        }
        return productos;
        
    }

    public ArrayList<ProductoVO> buscarProductoCategoria(String categoria) {
        ArrayList<ProductoVO> productos = new ArrayList<>();
        for(ProductoVO producto : productoDAO.obtenerProductos()) {
            if(categoria.equals(producto.getCategoria())) {
                productos.add(producto);
            }
        }
        return productos;
    }

    public ArrayList<ProductoVO> buscarProductoGenero(String genero) {
        ArrayList<ProductoVO> productos = new ArrayList<>();
        for(ProductoVO producto : productoDAO.obtenerProductos()) {
            if(genero.equals(producto.getGenero())) {
                productos.add(producto);
            }
        }
        return productos;
    }

   
}
