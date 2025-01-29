package vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import controlador.ControladorInicioCli;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazInicioCli extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
    private JLabel lblErrorUsuario, lblErrorPas, lblErrorVacio;
	
	/**
	 * Create the frame.
	 */
	public InterfazInicioCli() {
		
		// Configura el título de la ventana
        super("Iniciar Sesión");
        setFont(new Font("Dialog", Font.BOLD, 15));
        
        // Configura la operación al cerrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Configura el tamaño de la ventana
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension pantalla = toolkit.getScreenSize();
        int width = (int) pantalla.getWidth();
        int height = (int) pantalla.getHeight();
        
        Insets bordes = getInsets();
        int top = bordes.top;
        int bottom = bordes.bottom;
        int left = bordes.left;
        int right = bordes.right;

        height = height - top - bottom;
        width = width - left - right;
        
        int partW = width / 4;
        int partH = height / 8;
        
        setSize(pantalla);
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{partW, width-partW, partW};
        gridBagLayout.rowHeights = new int[]{(5/2*partH), partH/2, partH/2, partH, partH/2, partH/2, 0, (5/2*partH)};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        getContentPane().setLayout(gridBagLayout);

        JButton btnVolver = new JButton("< Volver");
        btnVolver.setBackground(new Color(0, 128, 128));
        btnVolver.setForeground(Color.BLACK);
        btnVolver.setFont(new Font("Dialog", Font.BOLD, 17));
        btnVolver.setPreferredSize(new Dimension(150, 50));
        btnVolver.setMinimumSize(new Dimension(150, 50));
        btnVolver.setMaximumSize(new Dimension(150, 50));
        
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		InterfazCuenta interfazCuenta = new InterfazCuenta();
                interfazCuenta.setVisible(true);
                dispose(); // Cierra la ventana actual
        	}
        });
        
        GridBagConstraints gbc_btnVolver = new GridBagConstraints();
        gbc_btnVolver.insets = new Insets(0, 0, 5, 5);
        gbc_btnVolver.gridx = 0;
        gbc_btnVolver.gridy = 0;
        gbc_btnVolver.anchor = GridBagConstraints.NORTHWEST;
        getContentPane().add(btnVolver, gbc_btnVolver);
        
        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setForeground(Color.BLACK);
        lblUsuario.setFont(new Font("Dialog", Font.BOLD, 25));
        GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
        gbc_lblUsuario.anchor = GridBagConstraints.SOUTHWEST;
        gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
        gbc_lblUsuario.gridx = 1;
        gbc_lblUsuario.gridy = 1;
        getContentPane().add(lblUsuario, gbc_lblUsuario);
        
        textField = new JTextField();
        textField.setFont(new Font("Dialog", Font.PLAIN, 20));
        textField.setForeground(Color.BLACK);
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.BOTH;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 2;
        getContentPane().add(textField, gbc_textField);
        textField.setColumns(10);
        
        JLabel lblContrasea = new JLabel("Contraseña");
        lblContrasea.setFont(new Font("Dialog", Font.BOLD, 25));
        lblContrasea.setForeground(Color.BLACK);
        GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
        gbc_lblContrasea.anchor = GridBagConstraints.SOUTHWEST;
        gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
        gbc_lblContrasea.gridx = 1;
        gbc_lblContrasea.gridy = 3;
        getContentPane().add(lblContrasea, gbc_lblContrasea);
        
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 20));
        passwordField.setForeground(Color.BLACK);
        GridBagConstraints gbc_passwordField = new GridBagConstraints();
        gbc_passwordField.insets = new Insets(0, 0, 5, 5);
        gbc_passwordField.fill = GridBagConstraints.BOTH;
        gbc_passwordField.gridx = 1;
        gbc_passwordField.gridy = 4;
        getContentPane().add(passwordField, gbc_passwordField);

        lblErrorVacio = new JLabel("No puede estar ningún campo vacío");
        lblErrorVacio.setFont(new Font("Dialog", Font.BOLD, 17));
        lblErrorVacio.setForeground(Color.RED);
        lblErrorVacio.setVisible(false);
        GridBagConstraints gbc_lblErrorVacio = new GridBagConstraints();
        gbc_lblErrorVacio.insets = new Insets(0, 0, 5, 5);
        gbc_lblErrorVacio.gridx = 1;
        gbc_lblErrorVacio.gridy = 5;
        getContentPane().add(lblErrorVacio, gbc_lblErrorVacio);

        lblErrorUsuario = new JLabel("No existe el nombre de usuario");
        lblErrorUsuario.setFont(new Font("Dialog", Font.BOLD, 17));
        lblErrorUsuario.setForeground(Color.RED);
        lblErrorUsuario.setVisible(false);
        GridBagConstraints gbc_lblErrorUsuario = new GridBagConstraints();
        gbc_lblErrorUsuario.insets = new Insets(0, 0, 5, 5);
        gbc_lblErrorUsuario.gridx = 1;
        gbc_lblErrorUsuario.gridy = 5;
        getContentPane().add(lblErrorUsuario, gbc_lblErrorUsuario);

        lblErrorPas = new JLabel("Contraseña incorrecta");
        lblErrorPas.setFont(new Font("Dialog", Font.BOLD, 17));
        lblErrorPas.setForeground(Color.RED);
        lblErrorPas.setVisible(false);
        GridBagConstraints gbc_lblErrorPas = new GridBagConstraints();
        gbc_lblErrorPas.insets = new Insets(0, 0, 5, 5);
        gbc_lblErrorPas.gridx = 1;
        gbc_lblErrorPas.gridy = 5;
        getContentPane().add(lblErrorPas, gbc_lblErrorPas);

        JButton btnIniciarSesion = new JButton("Iniciar Sesión");
        btnIniciarSesion.setBackground(new Color(0, 128, 128));
        btnIniciarSesion.setForeground(Color.BLACK);
        btnIniciarSesion.setFont(new Font("Dialog", Font.BOLD, 20));

        btnIniciarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = textField.getText();
                String password = new String(passwordField.getPassword());
                ControladorInicioCli controlador = new ControladorInicioCli();
                boolean registrado = controlador.verificarUsuario(usuario);

                if(usuario.equals("") || password.equals("")) {
                    // Campos vacíos
                    lblErrorVacio.setVisible(true);
                    lblErrorUsuario.setVisible(false);
                    lblErrorPas.setVisible(false);
                    return;
                } 

                if (!registrado) {
                    // Usuario no registrado
                    lblErrorVacio.setVisible(false);
                    lblErrorUsuario.setVisible(true);
                    lblErrorPas.setVisible(false);
                } else {
                    boolean correcto = controlador.verificarPas(usuario, password);
                    if (correcto) {
                        // Usuario registrado
                        lblErrorUsuario.setVisible(false);
                        lblErrorPas.setVisible(false);
                                
                        //Se crea la siguiente ventana
                        InterfazPantallaCli interfazPrincipalCli = new InterfazPantallaCli();
                        interfazPrincipalCli.setVisible(true);
                        dispose(); // Cierra la ventana actual

                    } else {
                        // Contraseña incorrecta
                        lblErrorPas.setVisible(true);
                                
                    }
                }
            }
        });
        
        GridBagConstraints gbc_btnIniciarSesion = new GridBagConstraints();
        gbc_btnIniciarSesion.insets = new Insets(0, 0, 0, 5);
        gbc_btnIniciarSesion.gridx = 1;
        gbc_btnIniciarSesion.gridy = 6;
        getContentPane().add(btnIniciarSesion, gbc_btnIniciarSesion);
           
     // Establecer el icono de la ventana
        ImageIcon icon = new ImageIcon(getClass().getResource("../imagenes/logo.png"));
        setIconImage(icon.getImage());
        
	}

}
