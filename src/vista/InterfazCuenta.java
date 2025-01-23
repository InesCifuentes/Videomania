package vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

public class InterfazCuenta extends JFrame {

	private static final long serialVersionUID = 1L;
	//private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public InterfazCuenta() {
		// Configura el título de la ventana
        super();
        
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
        
        JButton btnTengoCuenta = new JButton("Tengo Cuenta");
        btnTengoCuenta.setBackground(new Color(0, 128, 128));
        btnTengoCuenta.setFont(new Font("Dialog", Font.BOLD, 20));
        btnTengoCuenta.setForeground(Color.BLACK);
        
        btnTengoCuenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InterfazInicioCli interfazInicio = new InterfazInicioCli();
                interfazInicio.setVisible(true);
                dispose(); // Cierra la ventana actual
            }
        });

        GridBagConstraints gbc_btnTengoCuenta = new GridBagConstraints();
        gbc_btnTengoCuenta.fill = GridBagConstraints.BOTH;
        gbc_btnTengoCuenta.insets = new Insets(0, 0, 5, 5);
        gbc_btnTengoCuenta.gridx = 1;
        gbc_btnTengoCuenta.gridy = 1;
        getContentPane().add(btnTengoCuenta, gbc_btnTengoCuenta);
        
        JButton btnCrearCuenta = new JButton("Crear Cuenta");
        btnCrearCuenta.setForeground(Color.BLACK);
        btnCrearCuenta.setBackground(new Color(0, 128, 128));
        btnCrearCuenta.setFont(new Font("Dialog", Font.BOLD, 20));
        GridBagConstraints gbc_btnCrearCuenta = new GridBagConstraints();
        gbc_btnCrearCuenta.fill = GridBagConstraints.BOTH;
        gbc_btnCrearCuenta.insets = new Insets(0, 0, 5, 5);
        gbc_btnCrearCuenta.gridx = 1;
        gbc_btnCrearCuenta.gridy = 3;
        getContentPane().add(btnCrearCuenta, gbc_btnCrearCuenta);
        
        // Establecer el icono de la ventana
        ImageIcon icon = new ImageIcon(getClass().getResource("../imagenes/logo.png"));
        setIconImage(icon.getImage());
	}

}
