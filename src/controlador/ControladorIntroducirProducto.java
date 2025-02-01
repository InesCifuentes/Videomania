package controlador;

import java.util.ArrayList;

import modelo.modeloDAO.CategoriaDAO;
import modelo.modeloDAO.GeneroDAO;
import modelo.modeloDAO.ProductoDAO;
import modelo.modeloVO.CategoriaVO;
import modelo.modeloVO.GeneroVO;
import modelo.modeloVO.ProductoVO;

public class ControladorIntroducirProducto {
    private ProductoDAO productoDAO;
    private GeneroDAO generoDAO;
    private CategoriaDAO categoriaDAO;

    public ControladorIntroducirProducto() {
        this.productoDAO = new ProductoDAO();
        this.generoDAO = new GeneroDAO();
        this.categoriaDAO = new CategoriaDAO();
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

        if(pegi.equals("Sí")) {
            edad = 18;
        } else if(pegi.equals("No")) {
            edad = 0;
        }

        ProductoVO producto = new ProductoVO(nombre, categoria, genero, edad, 3.0);
        productoDAO.agregarProducto(producto);
    }
}