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

    public static void probarDevolucion(DevolucionDAO devolucionDAO) {
        // Añadir devolución
        DevolucionVO nuevaDevolucion = new DevolucionVO(1, 1, "2023-10-10");
        boolean resultado = devolucionDAO.agregarDevolucion(nuevaDevolucion);
        if (resultado) {
            System.out.println("Devolución agregada con éxito");
        } else {
            System.out.println("Hubo un error al agregar la devolución");
        }

        // Obtener y mostrar devoluciones
        ArrayList<DevolucionVO> devoluciones = devolucionDAO.obtenerDevoluciones();
        System.out.println("Número de devoluciones: " + devoluciones.size());
        for (DevolucionVO devolucion : devoluciones) {
            System.out.println("ID Devolución: " + devolucion.getIdDevolucion() + ", ID Alquiler: " + devolucion.getIdAlquiler() + ", Fecha Devolución: " + devolucion.getFechaDevolucion());
        }

        // Eliminar devolución
        boolean resultado2 = devolucionDAO.eliminarDevolucion(1);
        if (resultado2) {
            System.out.println("Devolución eliminada con éxito");
        } else {
            System.out.println("Hubo un error al eliminar la devolución");
        }

        // Obtener y mostrar devoluciones
        devoluciones = devolucionDAO.obtenerDevoluciones();
        System.out.println("Número de devoluciones: " + devoluciones.size());
        for (DevolucionVO devolucion : devoluciones) {
            System.out.println("ID Devolución: " + devolucion.getIdDevolucion() + ", ID Alquiler: " + devolucion.getIdAlquiler() + ", Fecha Devolución: " + devolucion.getFechaDevolucion());
        }
    }

    public static void probarMulta(MultaDAO multaDAO) {
        // Añadir multa
        MultaVO nuevaMulta = new MultaVO(1, 1);
        boolean resultado = multaDAO.agregarMulta(nuevaMulta);
        if (resultado) {
            System.out.println("Multa agregada con éxito");
        } else {
            System.out.println("Hubo un error al agregar la multa");
        }

        // Obtener y mostrar multas
        ArrayList<MultaVO> multas = multaDAO.obtenerMultas();
        System.out.println("Número de multas: " + multas.size());
        for (MultaVO multa : multas) {
            System.out.println("ID Multa: " + multa.getIdMulta() + ", ID Alquiler: " + multa.getIdAlquiler());
        }

        // Eliminar multa
        boolean resultado2 = multaDAO.eliminarMulta(1);
        if (resultado2) {
            System.out.println("Multa eliminada con éxito");
        } else {
            System.out.println("Hubo un error al eliminar la multa");
        }

        // Obtener y mostrar multas
        multas = multaDAO.obtenerMultas();
        System.out.println("Número de multas: " + multas.size());
        for (MultaVO multa : multas) {
            System.out.println("ID Multa: " + multa.getIdMulta() + ", ID Alquiler: " + multa.getIdAlquiler());
        }
    }

    public static void probarProducto(ProductoDAO productoDAO) {
        // Añadir producto
        ProductoVO nuevoProducto = new ProductoVO("Producto1", "Acción", "Comedia", 18, 19.99);
        boolean resultado = productoDAO.agregarProducto(nuevoProducto);
        if (resultado) {
            System.out.println("Producto agregado con éxito");
        } else {
            System.out.println("Hubo un error al agregar el producto");
        }

        // Obtener y mostrar productos
        ArrayList<ProductoVO> productos = productoDAO.obtenerProductos();
        System.out.println("Número de productos: " + productos.size());
        for (ProductoVO producto : productos) {
            System.out.println("Nombre Producto: " + producto.getNombreProducto() + ", Categoría: " + producto.getCategoria() + ", Género: " + producto.getGenero() + ", PEGI: " + producto.getPegi() + ", Precio: " + producto.getPrecio());
        }

        // Eliminar producto
        boolean resultado2 = productoDAO.eliminarProducto("Producto1");
        if (resultado2) {
            System.out.println("Producto eliminado con éxito");
        } else {
            System.out.println("Hubo un error al eliminar el producto");
        }

        // Obtener y mostrar productos
        productos = productoDAO.obtenerProductos();
        System.out.println("Número de productos: " + productos.size());
        for (ProductoVO producto : productos) {
            System.out.println("Nombre Producto: " + producto.getNombreProducto() + ", Categoría: " + producto.getCategoria() + ", Género: " + producto.getGenero() + ", PEGI: " + producto.getPegi() + ", Precio: " + producto.getPrecio());
        }
    }

    public static void probarUnidadProducto(Unidad_ProductoDAO unidadProductoDAO) {
        // Añadir unidad de producto
        Unidad_ProductoVO nuevaUnidadProducto = new Unidad_ProductoVO(1, "Producto1", 1, "Disponible");
        boolean resultado = unidadProductoDAO.agregarUnidadProducto(nuevaUnidadProducto);
        if (resultado) {
            System.out.println("Unidad de producto agregada con éxito");
        } else {
            System.out.println("Hubo un error al agregar la unidad de producto");
        }

        // Obtener y mostrar unidades de producto
        ArrayList<Unidad_ProductoVO> unidadesProducto = unidadProductoDAO.obtenerUnidadesProducto();
        System.out.println("Número de unidades de producto: " + unidadesProducto.size());
        for (Unidad_ProductoVO unidadProducto : unidadesProducto) {
            System.out.println("ID Unidad Producto: " + unidadProducto.getId() + ", Nombre Producto: " + unidadProducto.getNombreProducto() + ", ID Alquiler: " + unidadProducto.getIdAlquiler() + ", Estado: " + unidadProducto.getEstado());
        }

        // Eliminar unidad de producto
        boolean resultado2 = unidadProductoDAO.eliminarUnidadProducto(1);
        if (resultado2) {
            System.out.println("Unidad de producto eliminada con éxito");
        } else {
            System.out.println("Hubo un error al eliminar la unidad de producto");
        }

        // Obtener y mostrar unidades de producto
        unidadesProducto = unidadProductoDAO.obtenerUnidadesProducto();
        System.out.println("Número de unidades de producto: " + unidadesProducto.size());
        for (Unidad_ProductoVO unidadProducto : unidadesProducto) {
            System.out.println("ID Unidad Producto: " + unidadProducto.getId() + ", Nombre Producto: " + unidadProducto.getNombreProducto() + ", ID Alquiler: " + unidadProducto.getIdAlquiler() + ", Estado: " + unidadProducto.getEstado());
        }
    }

    public static void probarAlquiler(AlquilerDAO alquilerDAO) {
        // Añadir alquiler
        AlquilerVO nuevoAlquiler = new AlquilerVO(1, "Juan", "2023-10-10");
        boolean resultado = alquilerDAO.agregarAlquiler(nuevoAlquiler);
        if (resultado) {
            System.out.println("Alquiler agregado con éxito");
        } else {
            System.out.println("Hubo un error al agregar el alquiler");
        }

        // Obtener y mostrar alquileres
        ArrayList<AlquilerVO> alquileres = alquilerDAO.obtenerAlquileres();
        System.out.println("Número de alquileres: " + alquileres.size());
        for (AlquilerVO alquiler : alquileres) {
            System.out.println("ID Alquiler: " + alquiler.getIdAlquiler() + ", Nombre Cliente: " + alquiler.getNombreCliente() + ", Fecha Alquiler: " + alquiler.getFechaAlquiler());
        }

        // Eliminar alquiler
        boolean resultado2 = alquilerDAO.eliminarAlquiler(1);
        if (resultado2) {
            System.out.println("Alquiler eliminado con éxito");
        } else {
            System.out.println("Hubo un error al eliminar el alquiler");
        }

        // Obtener y mostrar alquileres
        alquileres = alquilerDAO.obtenerAlquileres();
        System.out.println("Número de alquileres: " + alquileres.size());
        for (AlquilerVO alquiler : alquileres) {
            System.out.println("ID Alquiler: " + alquiler.getIdAlquiler() + ", Nombre Cliente: " + alquiler.getNombreCliente() + ", Fecha Alquiler: " + alquiler.getFechaAlquiler());
        }
    }
}