package controlador;

import java.util.ArrayList;

import modelo.modeloDAO.GeneroDAO;
import modelo.modeloDAO.ProductoDAO;
import modelo.modeloVO.ClienteVO;
import modelo.modeloVO.GeneroVO;
import modelo.modeloVO.ProductoVO;

public class ControladorIntroducirProducto {
    private ProductoDAO productoDAO;
    private GeneroDAO generoDAO;

    public ControladorIntroducirProducto() {
        this.productoDAO = new ProductoDAO();
        this.generoDAO = new GeneroDAO();
    }

    public String[] obtenerGeneros() {
        ArrayList<GeneroVO> generosArrayList = generoDAO.obtenerGeneros();
        String[] generosArray = new String[generosArrayList.size()];
        for (int i = 0; i < generosArrayList.size(); i++) {
            generosArray[i] = generosArrayList.get(i).getGenero();
        }
        return generosArray;
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
        } else if(pegi.equals("No")) {
            edad = 0;
        }

        ProductoVO producto = new ProductoVO(nombre, categoria, genero, edad, 3.0);
        productoDAO.agregarProducto(producto);
    }
}