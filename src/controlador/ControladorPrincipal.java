package controlador;


import modelo.modeloDAO.CategoriaDAO;
import modelo.modeloDAO.ClienteDAO;
import modelo.modeloDAO.DevolucionDAO;
import modelo.modeloDAO.GeneroDAO;
import modelo.modeloDAO.GestorDAO;
import modelo.modeloDAO.MultaDAO;
import modelo.modeloDAO.ProductoDAO;
import modelo.modeloDAO.Unidad_ProductoDAO;
import vista.InterfazPrincipal;

public class ControladorPrincipal {

    public static void main(String[] args) {
        System.out.println("Hola, mundo!");

        // OBJETOS MODELO
       
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        DevolucionDAO devolucionDAO = new DevolucionDAO();
        GeneroDAO generoDAO = new GeneroDAO();
        GestorDAO gestorDAO = new GestorDAO();
        MultaDAO multaDAO = new MultaDAO();
        ProductoDAO productoDAO = new ProductoDAO();
        Unidad_ProductoDAO unidadProductoDAO = new Unidad_ProductoDAO();

        // OBJETOS VISTA
        InterfazPrincipal interfazPrincipal = new InterfazPrincipal();
    }

}