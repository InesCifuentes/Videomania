package controlador;

import java.util.ArrayList;

import modelo.modeloDAO.*;
import modelo.modeloVO.*;

public class PruebasBD {

    public static void probarGestor(GestorDAO gestorDAO) {
//        // Añadir gestor
//        boolean resultado = gestorDAO.agregarGestor("nuevoGestor", "nuevaContrasena");
//        if (resultado) {
//            System.out.println("Gestor agregado con éxito");
//        } else {
//            System.out.println("Hubo un error al agregar el gestor");
//        }

        // Obtener y mostrar gestores
        ArrayList<GestorVO> gestores = gestorDAO.obtenerGestores();
        System.out.println("Número de gestores: " + gestores.size());
        for (GestorVO gestor : gestores) {
            System.out.println("Nombre: " + gestor.getNombre() + ", Password: " + gestor.getPassword());
        }

//        // Eliminar gestor
//        boolean resultado2 = gestorDAO.eliminarGestor("nuevoGestor");
//        if (resultado2) {
//            System.out.println("Gestor eliminado con éxito");
//        } else {
//            System.out.println("Hubo un error al eliminar el gestor");
//        }
//
//        // Obtener y mostrar gestores
//        gestores = gestorDAO.obtenerGestores();
//        System.out.println("Número de gestores: " + gestores.size());
//        for (GestorVO gestor : gestores) {
//            System.out.println("Nombre: " + gestor.getNombre() + ", Password: " + gestor.getPassword());
//        }
    }

    public static void probarCategoria(CategoriaDAO categoriaDAO) {
        // Añadir categoría
        CategoriaVO nuevaCategoria = new CategoriaVO("Acción");
        boolean resultado = categoriaDAO.agregarCategoria(nuevaCategoria);
        if (resultado) {
            System.out.println("Categoría agregada con éxito");
        } else {
            System.out.println("Hubo un error al agregar la categoría");
        }

        // Obtener y mostrar categorías
        ArrayList<CategoriaVO> categorias = categoriaDAO.obtenerCategorias();
        System.out.println("Número de categorías: " + categorias.size());
        for (CategoriaVO categoria : categorias) {
            System.out.println("Categoría: " + categoria.getCategoria());
        }

        // Eliminar categoría
        boolean resultado2 = categoriaDAO.eliminarCategoria("Acción");
        if (resultado2) {
            System.out.println("Categoría eliminada con éxito");
        } else {
            System.out.println("Hubo un error al eliminar la categoría");
        }

        // Obtener y mostrar categorías
        categorias = categoriaDAO.obtenerCategorias();
        System.out.println("Número de categorías: " + categorias.size());
        for (CategoriaVO categoria : categorias) {
            System.out.println("Categoría: " + categoria.getCategoria());
        }
    }

    public static void probarGenero(GeneroDAO generoDAO) {
        // Añadir género
        GeneroVO nuevoGenero = new GeneroVO("Comedia");
        boolean resultado = generoDAO.agregarGenero(nuevoGenero);
        if (resultado) {
            System.out.println("Género agregado con éxito");
        } else {
            System.out.println("Hubo un error al agregar el género");
        }

        // Obtener y mostrar géneros
        ArrayList<GeneroVO> generos = generoDAO.obtenerGeneros();
        System.out.println("Número de géneros: " + generos.size());
        for (GeneroVO genero : generos) {
            System.out.println("Género: " + genero.getGenero());
        }

        // Eliminar género
        boolean resultado2 = generoDAO.eliminarGenero("Comedia");
        if (resultado2) {
            System.out.println("Género eliminado con éxito");
        } else {
            System.out.println("Hubo un error al eliminar el género");
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
        ClienteVO nuevoCliente = new ClienteVO("Juan", 25, "1234");
        boolean resultado = clienteDAO.insertarCliente(nuevoCliente);
        if (resultado) {
            System.out.println("Cliente agregado con éxito");
        } else {
            System.out.println("Hubo un error al agregar el cliente");
        }

        // Obtener y mostrar clientes
        ArrayList<ClienteVO> clientes = clienteDAO.obtenerClientes();
        System.out.println("Número de clientes: " + clientes.size());
        for (ClienteVO cliente : clientes) {
            System.out.println("Nombre: " + cliente.getNombre() + ", Edad: " + cliente.getEdad() + ", Password: " + cliente.getPassword());
        }

        // Eliminar cliente
        boolean resultado2 = clienteDAO.eliminarCliente("Juan");
        if (resultado2) {
            System.out.println("Cliente eliminado con éxito");
        } else {
            System.out.println("Hubo un error al eliminar el cliente");
        }

        // Obtener y mostrar clientes
        clientes = clienteDAO.obtenerClientes();
        System.out.println("Número de clientes: " + clientes.size());
        for (ClienteVO cliente : clientes) {
            System.out.println("Nombre: " + cliente.getNombre() + ", Edad: " + cliente.getEdad() + ", Password: " + cliente.getPassword());
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