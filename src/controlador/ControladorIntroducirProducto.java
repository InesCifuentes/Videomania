package controlador;

import java.util.ArrayList;

import modelo.modeloDAO.CategoriaDAO;
import modelo.modeloDAO.GeneroDAO;
import modelo.modeloDAO.ProductoDAO;
import modelo.modeloDAO.Unidad_ProductoDAO;
import modelo.modeloVO.CategoriaVO;
import modelo.modeloVO.GeneroVO;
import modelo.modeloVO.ProductoVO;
import modelo.modeloVO.Unidad_ProductoVO;

public class ControladorIntroducirProducto {
    private ProductoDAO productoDAO;
    private GeneroDAO generoDAO;
    private CategoriaDAO categoriaDAO;
    private Unidad_ProductoDAO unidad_ProductoDAO;

    public ControladorIntroducirProducto() {
        this.productoDAO = new ProductoDAO();
        this.generoDAO = new GeneroDAO();
        this.categoriaDAO = new CategoriaDAO();
        this.unidad_ProductoDAO = new Unidad_ProductoDAO();
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

    public void crearUnidadProducto(String nombre) {
        Unidad_ProductoVO unidad_ProductoVO = new Unidad_ProductoVO(0, nombre, null, "Disponible");
        unidad_ProductoDAO.agregarUnidadProducto(unidad_ProductoVO);
        
    }
}