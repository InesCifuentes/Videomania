package vista;

import javax.swing.*;  // Importa las clases necesarias de Swing
import java.awt.event.ActionListener;  // Importa ActionListener para manejar eventos de botones

public class InterfazPrincipal extends JFrame {

    public InterfazPrincipal() {
        // Configura el título de la ventana
        super("Ventana Básica en Swing");

        // Configura la operación al cerrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un botón
        JButton boton = new JButton("Haz clic aquí");

        // Agregar un ActionListener al botón (cuando se haga clic en él)
        boton.addActionListener(e -> System.out.println("¡Botón clickeado!"));

        // Agregar el botón a la ventana
        getContentPane().add(boton);

        // Configura el tamaño de la ventana
        setSize(400, 300);

        // Establecer la ventana visible
        setVisible(true);
    }
}
