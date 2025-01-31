package vista;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import modelo.modeloVO.ClienteVO;

public class InterfazUsuarioCli extends JFrame {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the frame.
	 */
	public InterfazUsuarioCli(ClienteVO usuario) {
		// Quita los botones de cerrar, minimizar y maximizar
        setUndecorated(true); 
        
     	// Configura el tamaño de la ventana
      	Toolkit toolkit = Toolkit.getDefaultToolkit();
      	Dimension pantalla = toolkit.getScreenSize();
      	int width = (int) pantalla.getWidth();
      	int height = (int) pantalla.getHeight();

      	int partH = height / 8;
		int partW = width / 3;
		 
       
      	setSize(pantalla);

      	GridBagLayout gridBagLayout = new GridBagLayout();
      	gridBagLayout.columnWidths = new int[]{partW, partW, partW};
      	gridBagLayout.rowHeights = new int[]{partH-partH/12, partH/2, partH/6, partH/2, partH-partH/12};
      	gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
      	gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0};
      	getContentPane().setLayout(gridBagLayout);
      	
      	JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Dialog", Font.BOLD, 20));
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setVisible(true);
      	GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
      	gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
      	gbc_lblUsuario.gridx = 0;
      	gbc_lblUsuario.gridy = 1;
      	getContentPane().add(lblUsuario, gbc_lblUsuario);
		
		JLabel lblNombre = new JLabel(usuario.getNombre());
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setVisible(true);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 2;

		JLabel lblEdad = new JLabel("Edad\t" + usuario.getEdad());
		lblEdad.setFont(new Font("Dialog", Font.BOLD, 20));
		lblEdad.setForeground(Color.BLACK);
		lblEdad.setVisible(true);
		GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdad.gridx = 0;
		gbc_lblEdad.gridy = 3;
		getContentPane().add(lblEdad, gbc_lblEdad);

		JLabel lblCarrito = new JLabel("Carrito");
		lblCarrito.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCarrito.setForeground(Color.BLACK);
		lblCarrito.setVisible(true);
		GridBagConstraints gbc_lblCarrito = new GridBagConstraints();
		gbc_lblCarrito.insets = new Insets(0, 0, 5, 5);
		gbc_lblCarrito.gridx = 1;
		gbc_lblCarrito.gridy = 1;
		getContentPane().add(lblCarrito, gbc_lblCarrito);
      	
      	JButton btnCerrarSesion = new JButton("Cerrar Sesion");
      	btnCerrarSesion.setBackground(new Color(0, 128, 128));
      	btnCerrarSesion.setFont(new Font("Dialog", Font.BOLD, 20));
      	GridBagConstraints gbc_btnCerrarSesion = new GridBagConstraints();
      	gbc_btnCerrarSesion.anchor = GridBagConstraints.SOUTH;
      	gbc_btnCerrarSesion.insets = new Insets(0, 0, 0, 5);
      	gbc_btnCerrarSesion.gridx = 0;
      	gbc_btnCerrarSesion.gridy = 4;
      	getContentPane().add(btnCerrarSesion, gbc_btnCerrarSesion);
      	
      	JButton btnVolver = new JButton("< Volver");
      	btnVolver.setFont(new Font("Dialog", Font.BOLD, 20));
      	btnVolver.setBackground(new Color(0, 128, 128));
      	GridBagConstraints gbc_btnVolver = new GridBagConstraints();
      	gbc_btnVolver.anchor = GridBagConstraints.SOUTH;
      	gbc_btnVolver.insets = new Insets(0, 0, 0, 5);
      	gbc_btnVolver.gridx = 1;
      	gbc_btnVolver.gridy = 4;
      	getContentPane().add(btnVolver, gbc_btnVolver);
		
		JButton btnTerminarOperacion = new JButton("Terminar Operacion");
      	btnTerminarOperacion.setBackground(new Color(0, 128, 128));
      	btnTerminarOperacion.setFont(new Font("Dialog", Font.BOLD, 20));
      	btnTerminarOperacion.addActionListener(new ActionListener() {
      		public void actionPerformed(ActionEvent e) {
      		}
      	});
      	GridBagConstraints gbc_btnTerminarOperacion = new GridBagConstraints();
      	gbc_btnTerminarOperacion.anchor = GridBagConstraints.SOUTH;
      	gbc_btnTerminarOperacion.gridx = 2;
      	gbc_btnTerminarOperacion.gridy = 4;
      	getContentPane().add(btnTerminarOperacion, gbc_btnTerminarOperacion);

	}

}
