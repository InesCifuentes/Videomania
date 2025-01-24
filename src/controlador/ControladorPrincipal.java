package controlador;


import java.util.ArrayList;

import modelo.modeloDAO.CategoriaDAO;
import modelo.modeloDAO.ClienteDAO;
import modelo.modeloDAO.DevolucionDAO;
import modelo.modeloDAO.GeneroDAO;
import modelo.modeloDAO.GestorDAO;
import modelo.modeloDAO.MultaDAO;
import modelo.modeloDAO.ProductoDAO;
import modelo.modeloDAO.Unidad_ProductoDAO;
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

        // OBJETOS VISTA
        InterfazPrincipal interfazPrincipal = new InterfazPrincipal();
    
        //pruebaAñadirYEliminarGestor(gestorDAO);
    }
    
    public static void pruebaAñadirYEliminarGestor(GestorDAO gestorDAO) {
    	 //Añadir gestor
        boolean resultado = gestorDAO.agregarGestor("nuevoGestor", "nuevaContrasena");
        if (resultado) {
        	System.out.println("Gestor agregado con éxito");
        } else {
        	System.out.println("Hubo un error al agregar el gestor");
        }
        
        // Obtener y mostrar gestores
        ArrayList<GestorVO> gestores = gestorDAO.obtenerGestores();
        System.out.println("Número de gestores: " + gestores.size());
        for (GestorVO gestor : gestores) {
            System.out.println("Nombre: " + gestor.getNombre() + ", Password: " + gestor.getPassword());
        }
        
        //Eliminar gestor
        boolean resultado2 = gestorDAO.eliminarGestor("nuevoGestor");

        if (resultado2) {
            System.out.println("Gestor eliminado con éxito");
        } else {
            System.out.println("Hubo un error al eliminar el gestor");
        }
        
        // Obtener y mostrar gestores
        gestores = gestorDAO.obtenerGestores();
        System.out.println("Número de gestores: " + gestores.size());
        for (GestorVO gestor : gestores) {
            System.out.println("Nombre: " + gestor.getNombre() + ", Password: " + gestor.getPassword());
        }
    }

}