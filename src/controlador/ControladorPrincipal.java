package controlador;

import modelo.modeloDAO.AlquilerDAO;
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

	//OBJETOS MODELO
    private AlquilerDAO alquilerDAO;
    private CategoriaDAO categoriaDAO;
    private ClienteDAO clienteDAO;
    private DevolucionDAO devolucionDAO;
    private GeneroDAO generoDAO;
    private GestorDAO gestorDAO;
    private MultaDAO multaDAO;
    private ProductoDAO productoDAO;
    private Unidad_ProductoDAO unidadProductoDAO;


	//OBJETOS VISTA
    private InterfazPrincipal interfazPrincipal;

    public static void main(String[] args) {
        System.out.println("Todo correcto!");
    }

}