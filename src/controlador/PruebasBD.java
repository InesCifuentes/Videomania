package controlador;

import java.util.ArrayList;

import modelo.modeloDAO.*;
import modelo.modeloVO.*;

public class PruebasBD {

    public static void probarGestor(GestorDAO gestorDAO) {
        // Añadir gestor
        boolean resultado = gestorDAO.agregarGestor("Juan", "1234");
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

        // Eliminar gestor
        boolean resultado2 = gestorDAO.eliminarGestor("Juan");
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

    public static void probarCategoria(CategoriaDAO categoriaDAO) {
        // Añadir categorías
        CategoriaVO categoria1 = new CategoriaVO("Película");
        CategoriaVO categoria2 = new CategoriaVO("Videojuego");
        boolean resultado1 = categoriaDAO.agregarCategoria(categoria1);
        boolean resultado2 = categoriaDAO.agregarCategoria(categoria2);
        if (resultado1 && resultado2) {
            System.out.println("Categorías agregadas con éxito");
        } else {
            System.out.println("Hubo un error al agregar las categorías");
        }

        // Obtener y mostrar categorías
        ArrayList<CategoriaVO> categorias = categoriaDAO.obtenerCategorias();
        System.out.println("Número de categorías: " + categorias.size());
        for (CategoriaVO categoria : categorias) {
            System.out.println("Categoría: " + categoria.getCategoria());
        }

        // Eliminar categorías
        boolean resultado3 = categoriaDAO.eliminarCategoria("Película");
        boolean resultado4 = categoriaDAO.eliminarCategoria("Videojuego");
        if (resultado3 && resultado4) {
            System.out.println("Categorías eliminadas con éxito");
        } else {
            System.out.println("Hubo un error al eliminar las categorías");
        }

        // Obtener y mostrar categorías
        categorias = categoriaDAO.obtenerCategorias();
        System.out.println("Número de categorías: " + categorias.size());
        for (CategoriaVO categoria : categorias) {
            System.out.println("Categoría: " + categoria.getCategoria());
        }
    }

    public static void probarGenero(GeneroDAO generoDAO) {
        // Añadir géneros
        GeneroVO genero1 = new GeneroVO("Comedia");
        GeneroVO genero2 = new GeneroVO("Acción");
        GeneroVO genero3 = new GeneroVO("Drama");
        boolean resultado1 = generoDAO.agregarGenero(genero1);
        boolean resultado2 = generoDAO.agregarGenero(genero2);
        boolean resultado3 = generoDAO.agregarGenero(genero3);
        if (resultado1 && resultado2 && resultado3) {
            System.out.println("Géneros agregados con éxito");
        } else {
            System.out.println("Hubo un error al agregar los géneros");
        }

        // Obtener y mostrar géneros
        ArrayList<GeneroVO> generos = generoDAO.obtenerGeneros();
        System.out.println("Número de géneros: " + generos.size());
        for (GeneroVO genero : generos) {
            System.out.println("Género: " + genero.getGenero());
        }

        // Eliminar géneros
        boolean resultado4 = generoDAO.eliminarGenero("Comedia");
        boolean resultado5 = generoDAO.eliminarGenero("Acción");
        boolean resultado6 = generoDAO.eliminarGenero("Drama");
        if (resultado4 && resultado5 && resultado6) {
            System.out.println("Géneros eliminados con éxito");
        } else {
            System.out.println("Hubo un error al eliminar los géneros");
        }

        // Obtener y mostrar géneros
        generos = generoDAO.obtenerGeneros();
        System.out.println("Número de géneros: " + generos.size());
        for (GeneroVO genero : generos) {
            System.out.println("Género: " + genero.getGenero());
        }
    }

    public static void probarCliente(ClienteDAO clienteDAO) {
        // Añadir cliente
        boolean resultado = clienteDAO.agregarCliente("María", "4321", 20);
        if (resultado) {
            System.out.println("Cliente agregado con éxito");
        } else {
            System.out.println("Hubo un error al agregar el cliente");
        }

        // Obtener y mostrar clientes
        ArrayList<ClienteVO> clientes = clienteDAO.obtenerClientes();
        System.out.println("Número de clientes: " + clientes.size());
        for (ClienteVO cliente : clientes) {
            System.out.println("Nombre: " + cliente.getNombre() + ", Password: " + cliente.getPassword()+ ", Edad: " + cliente.getEdad());
        }

        // Eliminar cliente
        boolean resultado2 = clienteDAO.eliminarCliente("María");
        if (resultado2) {
            System.out.println("Cliente eliminado con éxito");
        } else {
            System.out.println("Hubo un error al eliminar el cliente");
        }

        // Obtener y mostrar clientes
        clientes = clienteDAO.obtenerClientes();
        System.out.println("Número de clientes: " + clientes.size());
        for (ClienteVO cliente : clientes) {
            System.out.println("Nombre: " + cliente.getNombre() + ", Password: " + cliente.getPassword()+ ", Edad: " + cliente.getEdad());
        }
    }

    public static void agregarCategoriasIniciales(CategoriaDAO categoriaDAO) {
        ArrayList<CategoriaVO> categorias = categoriaDAO.obtenerCategorias();
        if (categorias.stream().noneMatch(c -> c.getCategoria().equals("Película"))) {
            CategoriaVO categoria1 = new CategoriaVO("Película");
            categoriaDAO.agregarCategoria(categoria1);
        }
        if (categorias.stream().noneMatch(c -> c.getCategoria().equals("Videojuego"))) {
            CategoriaVO categoria2 = new CategoriaVO("Videojuego");
            categoriaDAO.agregarCategoria(categoria2);
        }
    }

    public static void agregarGenerosIniciales(GeneroDAO generoDAO) {
        ArrayList<GeneroVO> generos = generoDAO.obtenerGeneros();
        if (generos.stream().noneMatch(g -> g.getGenero().equals("Comedia"))) {
            GeneroVO genero1 = new GeneroVO("Comedia");
            generoDAO.agregarGenero(genero1);
        }
        if (generos.stream().noneMatch(g -> g.getGenero().equals("Acción"))) {
            GeneroVO genero2 = new GeneroVO("Acción");
            generoDAO.agregarGenero(genero2);
        }
        if (generos.stream().noneMatch(g -> g.getGenero().equals("Drama"))) {
            GeneroVO genero3 = new GeneroVO("Drama");
            generoDAO.agregarGenero(genero3);
        }
        if (generos.stream().noneMatch(g -> g.getGenero().equals("Terror"))) {
            GeneroVO genero4 = new GeneroVO("Terror");
            generoDAO.agregarGenero(genero4);
        }
        if (generos.stream().noneMatch(g -> g.getGenero().equals("Ciencia Ficción"))) {
            GeneroVO genero5 = new GeneroVO("Ciencia Ficción");
            generoDAO.agregarGenero(genero5);
        }
    }
    public static void agregarDatosIniciales(GestorDAO gestorDAO, ClienteDAO clienteDAO, CategoriaDAO categoriaDAO, GeneroDAO generoDAO, ProductoDAO productoDAO, AlquilerDAO alquilerDAO, Unidad_ProductoDAO unidadProductoDAO, MultaDAO multaDAO, DevolucionDAO devolucionDAO) {
    	// Añadir gestor
        gestorDAO.agregarGestor("Juan", "1234");
    	
    	// Añadir cliente
        clienteDAO.agregarCliente("Carlos", "5678", 25);

        // Añadir categoría
        CategoriaVO categoria = new CategoriaVO("Documental");
        categoriaDAO.agregarCategoria(categoria);

        // Añadir género
        GeneroVO genero = new GeneroVO("Documental");
        generoDAO.agregarGenero(genero);

        // Añadir producto
        ProductoVO producto = new ProductoVO("Documental1", "Documental", "Documental", 12, 9.99);
        productoDAO.agregarProducto(producto);

        // Añadir alquiler
        AlquilerVO alquiler = new AlquilerVO(5, "Carlos", "2023-10-11");
        alquilerDAO.agregarAlquiler(alquiler);

        // Recuperar alquiler y guardar su id
        ArrayList<AlquilerVO> alquileres = alquilerDAO.obtenerAlquileres();
        int idAlquiler = -1;
        for (AlquilerVO a : alquileres) {
            if (a.getNombreCliente().equals("Carlos") && a.getFechaAlquiler().equals("2023-10-11")) {
            idAlquiler = a.getIdAlquiler();
            break;
            }
        }

        // Añadir unidad de producto
        Unidad_ProductoVO unidadProducto = new Unidad_ProductoVO(1, "Documental1", idAlquiler, "Disponible");
        unidadProductoDAO.agregarUnidadProducto(unidadProducto);

        // Añadir multa
        MultaVO multa = new MultaVO(2, idAlquiler, 15.0);
        multaDAO.agregarMulta(multa);

        // Añadir devolución
        DevolucionVO devolucion = new DevolucionVO(4, idAlquiler, "2023-10-12");
        devolucionDAO.agregarDevolucion(devolucion);

        System.out.println("Datos iniciales agregados con éxito");
    }
}
