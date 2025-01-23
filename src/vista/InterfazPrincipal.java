package vista;

import javax.swing.*;  // Importa las clases necesarias de Swing

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ActionListener;   // Importa ActionListener para manejar eventos de botones
import java.awt.event.ActionEvent;      // Importa ActionEvent para manejar eventos de acción

public class InterfazPrincipal extends JFrame {

    public InterfazPrincipal() {
        // Configura el título de la ventana
        super("Pantalla Principal");
        setFont(new Font("Dialog", Font.BOLD, 12));

        // Configura la operación al cerrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Configura el tamaño de la ventana
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension pantalla = toolkit.getScreenSize();
        int width = (int) pantalla.getWidth();
        int height = (int) pantalla.getHeight();
        
        int part = height / 3;
        
        setSize(pantalla);

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{width/4, width/3, width/4};
        gridBagLayout.rowHeights = new int[]{0, part/2, part/6, part/2, 0};
        gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
        getContentPane().setLayout(gridBagLayout);
        
        JButton btnCliente = new JButton("Cliente");
        btnCliente.setFont(new Font("Dialog", Font.BOLD, 20));
        btnCliente.setForeground(Color.BLACK);
        btnCliente.setBackground(new Color(0, 128, 128));

        btnCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InterfazCuenta interfazCuenta = new InterfazCuenta();
                interfazCuenta.setVisible(true);
                dispose(); // Cierra la ventana actual
            }
        });

        GridBagConstraints gbc_btnCliente = new GridBagConstraints();
        gbc_btnCliente.fill = GridBagConstraints.BOTH;
        gbc_btnCliente.insets = new Insets(0, 0, 5, 5);
        gbc_btnCliente.gridx = 1;
        gbc_btnCliente.gridy = 1;
        getContentPane().add(btnCliente, gbc_btnCliente);
        
        JButton btnGestor = new JButton("Gestor");
        btnGestor.setFont(new Font("Dialog", Font.BOLD, 20));
        btnGestor.setForeground(Color.BLACK);
        btnGestor.setBackground(new Color(0, 128, 128));
        GridBagConstraints gbc_btnGestor = new GridBagConstraints();
        gbc_btnGestor.insets = new Insets(0, 0, 5, 5);
        gbc_btnGestor.fill = GridBagConstraints.BOTH;
        gbc_btnGestor.gridx = 1;
        gbc_btnGestor.gridy = 3;
        getContentPane().add(btnGestor, gbc_btnGestor);

        // Establecer la ventana visible
        setVisible(true);

         // Establecer el icono de la ventana
        ImageIcon icon = new ImageIcon(getClass().getResource("../imagenes/logo.png"));
        setIconImage(icon.getImage());
    }

}
