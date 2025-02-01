package controlador;


import java.util.ArrayList;

import modelo.modeloDAO.*;
import vista.InterfazPrincipal;
import modelo.modeloVO.GestorVO;

public class ControladorPrincipal {

    public static void main(String[] args) {
    	
        // OBJETOS MODELO
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        DevolucionDAO devolucionDAO = new DevolucionDAO();
        GeneroDAO generoDAO = new GeneroDAO();
        GestorDAO gestorDAO = new GestorDAO();
        MultaDAO multaDAO = new MultaDAO();
        ProductoDAO productoDAO = new ProductoDAO();
        Unidad_ProductoDAO unidadProductoDAO = new Unidad_ProductoDAO();
        AlquilerDAO alquilerDAO = new AlquilerDAO();

        // OBJETOS VISTA
        InterfazPrincipal interfazPrincipal = new InterfazPrincipal();
    
        //Agrego un gestor, géneros, categorías y productos
        //PruebasBD.agregarDatosIniciales(gestorDAO, clienteDAO, categoriaDAO, generoDAO, productoDAO);
    }
}