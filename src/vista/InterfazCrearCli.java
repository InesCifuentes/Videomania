package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

import controlador.ControladorCrearCli;
import modelo.modeloVO.ClienteVO;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazCrearCli extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;
	private JTextField textField_1;
    private JLabel lblErrorUsuario, lblErrorPas, lblErrorEdad, lblErrorVacio;

	/**
	 * Create the frame.
	 */
	public InterfazCrearCli() {
		// Quita los botones de cerrar, minimizar y maximizar
        setUndecorated(true); 
        
        // Configura el tamaño de la ventana
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension pantalla = toolkit.getScreenSize();
        int width = (int) pantalla.getWidth();
        int height = (int) pantalla.getHeight();
        
        int partW = width / 4;
        int partH = height / 8;
        
        setSize(pantalla);

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{partW, width-partW, partW};
        gridBagLayout.rowHeights = new int[]{(2*partH-partH/4), partH/2, partH/2, partH/2, partH/2, partH/2, partH/2, partH/2, partH/2, partH/2, (2*partH-partH/4)};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
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
        gbc_btnVolver.anchor = GridBagConstraints.NORTHWEST;
        gbc_btnVolver.insets = new Insets(0, 0, 5, 5);
        gbc_btnVolver.gridx = 0;
        gbc_btnVolver.gridy = 0;
        getContentPane().add(btnVolver, gbc_btnVolver);
        
        JLabel lblUsuario = new JLabel("Usuario *");
        lblUsuario.setFont(new Font("Dialog", Font.BOLD, 25));
        lblUsuario.setForeground(Color.BLACK);
        GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
        gbc_lblUsuario.anchor = GridBagConstraints.WEST;
        gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
        gbc_lblUsuario.gridx = 1;
        gbc_lblUsuario.gridy = 1;
        getContentPane().add(lblUsuario, gbc_lblUsuario);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Dialog", Font.PLAIN, 20));
        textField_1.setForeground(Color.BLACK);
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.insets = new Insets(0, 0, 5, 5);
        gbc_textField_1.fill = GridBagConstraints.BOTH;
        gbc_textField_1.gridx = 1;
        gbc_textField_1.gridy = 2;
        getContentPane().add(textField_1, gbc_textField_1);
        textField_1.setColumns(10);
        
        JLabel lblEdad = new JLabel("Edad *");
        lblEdad.setForeground(Color.BLACK);
        lblEdad.setFont(new Font("Dialog", Font.BOLD, 25));
        GridBagConstraints gbc_lblEdad = new GridBagConstraints();
        gbc_lblEdad.anchor = GridBagConstraints.SOUTHWEST;
        gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
        gbc_lblEdad.gridx = 1;
        gbc_lblEdad.gridy = 3;
        getContentPane().add(lblEdad, gbc_lblEdad);
        
        textField = new JTextField();
        textField.setForeground(Color.BLACK);
        textField.setFont(new Font("Dialog", Font.PLAIN, 20));
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.BOTH;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 4;
        getContentPane().add(textField, gbc_textField);
        textField.setColumns(10);
        
        JLabel lblContrasea = new JLabel("Contraseña *");
        lblContrasea.setForeground(Color.BLACK);
        lblContrasea.setFont(new Font("Dialog", Font.BOLD, 25));
        GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
        gbc_lblContrasea.anchor = GridBagConstraints.SOUTHWEST;
        gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
        gbc_lblContrasea.gridx = 1;
        gbc_lblContrasea.gridy = 5;
        getContentPane().add(lblContrasea, gbc_lblContrasea);
        
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 20));
        passwordField.setForeground(Color.BLACK);
        GridBagConstraints gbc_passwordField = new GridBagConstraints();
        gbc_passwordField.insets = new Insets(0, 0, 5, 5);
        gbc_passwordField.fill = GridBagConstraints.BOTH;
        gbc_passwordField.gridx = 1;
        gbc_passwordField.gridy = 6;
        getContentPane().add(passwordField, gbc_passwordField);
        
        JLabel lblRepetirContrasea = new JLabel("Repetir contraseña *");
        lblRepetirContrasea.setForeground(Color.BLACK);
        lblRepetirContrasea.setFont(new Font("Dialog", Font.BOLD, 25));
        GridBagConstraints gbc_lblRepetirContrasea = new GridBagConstraints();
        gbc_lblRepetirContrasea.anchor = GridBagConstraints.SOUTHWEST;
        gbc_lblRepetirContrasea.insets = new Insets(0, 0, 5, 5);
        gbc_lblRepetirContrasea.gridx = 1;
        gbc_lblRepetirContrasea.gridy = 7;
        getContentPane().add(lblRepetirContrasea, gbc_lblRepetirContrasea);
        
        passwordField_1 = new JPasswordField();
        passwordField_1.setForeground(Color.BLACK);
        passwordField_1.setFont(new Font("Dialog", Font.PLAIN, 20));
        GridBagConstraints gbc_passwordField_1 = new GridBagConstraints();
        gbc_passwordField_1.insets = new Insets(0, 0, 5, 5);
        gbc_passwordField_1.fill = GridBagConstraints.BOTH;
        gbc_passwordField_1.gridx = 1;
        gbc_passwordField_1.gridy = 8;
        getContentPane().add(passwordField_1, gbc_passwordField_1);
        
        JButton btnCrearCuenta = new JButton("Crear Cuenta");
        btnCrearCuenta.setBackground(new Color(0, 128, 128));
        btnCrearCuenta.setFont(new Font("Dialog", Font.BOLD, 20));
        btnCrearCuenta.setForeground(Color.BLACK);
        GridBagConstraints gbc_btnCrearCuenta = new GridBagConstraints();
        gbc_btnCrearCuenta.anchor = GridBagConstraints.NORTH;
        gbc_btnCrearCuenta.insets = new Insets(0, 0, 5, 5);
        gbc_btnCrearCuenta.gridx = 1;
        gbc_btnCrearCuenta.gridy = 10;
        getContentPane().add(btnCrearCuenta, gbc_btnCrearCuenta);

        lblErrorVacio = new JLabel("No puede haber campos vacíos");
        lblErrorVacio.setFont(new Font("Dialog", Font.BOLD, 17));
        lblErrorVacio.setForeground(Color.RED);
        lblErrorVacio.setVisible(false);
        GridBagConstraints gbc_lblErrorVacio = new GridBagConstraints();
        gbc_lblErrorVacio.insets = new Insets(0, 0, 5, 5);
        gbc_lblErrorVacio.gridx = 1;
        gbc_lblErrorVacio.gridy = 9;
        getContentPane().add(lblErrorVacio, gbc_lblErrorVacio);
            
        lblErrorUsuario = new JLabel("El nombre de usuario ya existe");
        lblErrorUsuario.setFont(new Font("Dialog", Font.BOLD, 17));
        lblErrorUsuario.setForeground(Color.RED);
        lblErrorUsuario.setVisible(false);
        GridBagConstraints gbc_lblErrorUsuario = new GridBagConstraints();
        gbc_lblErrorUsuario.insets = new Insets(0, 0, 5, 5);
        gbc_lblErrorUsuario.gridx = 1;
        gbc_lblErrorUsuario.gridy = 9;
        getContentPane().add(lblErrorUsuario, gbc_lblErrorUsuario);
        
        lblErrorEdad = new JLabel("La edad debe ser un número");
        lblErrorEdad.setFont(new Font("Dialog", Font.BOLD, 17));
        lblErrorEdad.setForeground(Color.RED);
        lblErrorEdad.setVisible(false);
        GridBagConstraints gbc_lblErrorEdad = new GridBagConstraints();
        gbc_lblErrorEdad.insets = new Insets(0, 0, 5, 5);
        gbc_lblErrorEdad.gridx = 1;
        gbc_lblErrorEdad.gridy = 9;
        getContentPane().add(lblErrorEdad, gbc_lblErrorEdad);

        lblErrorPas = new JLabel("Las contraseñas no coinciden");
        lblErrorPas.setFont(new Font("Dialog", Font.BOLD, 17));
        lblErrorPas.setForeground(Color.RED);
        lblErrorPas.setVisible(false);
        GridBagConstraints gbc_lblErrorPas = new GridBagConstraints();
        gbc_lblErrorPas.insets = new Insets(0, 0, 5, 5);
        gbc_lblErrorPas.gridx = 1;
        gbc_lblErrorPas.gridy = 9;
        getContentPane().add(lblErrorPas, gbc_lblErrorPas);

        btnCrearCuenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = textField_1.getText();
                String edad = textField.getText();
                String password = new String(passwordField.getPassword());
                String password2 = new String(passwordField_1.getPassword());
                ControladorCrearCli controlador = new ControladorCrearCli();
                boolean registrado = controlador.verificarUsuario(usuario);
                if(usuario == null || usuario.equals("") || edad == null || edad.equals("") || password == null || password.equals("") || password2 == null || password2.equals("")) {
                    lblErrorVacio.setVisible(true);
                    lblErrorUsuario.setVisible(false);
                    lblErrorEdad.setVisible(false);
                    lblErrorPas.setVisible(false);
                    return;
                }
                
                if (!registrado) {
                    // Usuario no registrado, el usuario se puede registrar
                    lblErrorVacio.setVisible(false);
                    lblErrorUsuario.setVisible(false);
                    lblErrorEdad.setVisible(false);
                    lblErrorPas.setVisible(false);

                    if(edad.matches("[0-9]+")) {
                        lblErrorEdad.setVisible(false);
                        if (password.equals(password2)) {
                            // Contraseñas coinciden
                            lblErrorPas.setVisible(false);
                            controlador.crearUsuario(usuario, password, edad);
                                
                            //Se crea la siguiente ventana
                            ClienteVO usuarioVO = new ClienteVO(usuario, password, Integer.parseInt(edad));
                            InterfazPantallaCli interfazPrincipalCli = new InterfazPantallaCli(usuarioVO);
                            interfazPrincipalCli.setVisible(true);
                            dispose(); // Cierra la ventana actual

                        } else {
                            // Contraseñas no coinciden
                            lblErrorPas.setVisible(true);
                        }
                            
                    } else {
                        //La edad no es un número
                        lblErrorEdad.setVisible(true);
                        lblErrorPas.setVisible(false);
                    }
                        
                } else {
                    lblErrorPas.setVisible(false);
                    lblErrorUsuario.setVisible(true);
                }

            }

        });

        // Establecer el icono de la ventana
        ImageIcon icon = new ImageIcon(getClass().getResource("../imagenes/logo.png"));
        setIconImage(icon.getImage());
	}

}
