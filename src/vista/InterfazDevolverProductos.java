package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InterfazDevolverProductos extends JFrame {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the frame.
	 */
	public InterfazDevolverProductos() {
		// Quita los botones de cerrar, minimizar y maximizar
        setUndecorated(true); 
        
     	// Configura el tamaño de la ventana
      	Toolkit toolkit = Toolkit.getDefaultToolkit();
      	Dimension pantalla = toolkit.getScreenSize();
      	int width = (int) pantalla.getWidth();
      	int height = (int) pantalla.getHeight();

      	int partH = height / 3;
		int partW = width / 3;
		 
       
      	setSize(pantalla);

      	GridBagLayout gridBagLayout = new GridBagLayout();
      	gridBagLayout.columnWidths = new int[]{partW/2, partW, partW, partW/2};
      	gridBagLayout.rowHeights = new int[]{partH-partH/12, partH/2, partH/6, partH/2, partH-partH/12};
      	gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
      	gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0};
      	getContentPane().setLayout(gridBagLayout);

      	JButton btnVolver = new JButton("< Volver");
      	btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
         		InterfazPantallaCli interfazPantallaCli = new InterfazPantallaCli();
            	interfazPantallaCli.setVisible(true);
            	dispose(); // Cierra la ventana actual
        	}
      	});

      	btnVolver.setBackground(new Color(0, 128, 128));
      	btnVolver.setForeground(Color.BLACK);
      	btnVolver.setFont(new Font("Dialog", Font.BOLD, 17));
      	btnVolver.setPreferredSize(new Dimension(150, 50));
      	btnVolver.setMinimumSize(new Dimension(150, 50));
      	btnVolver.setMaximumSize(new Dimension(150, 50));
      	GridBagConstraints gbc_btnVolver = new GridBagConstraints();
      	gbc_btnVolver.anchor = GridBagConstraints.NORTHWEST;
      	gbc_btnVolver.insets = new Insets(0, 0, 5, 5);
		gbc_btnVolver.gridx = 0;
		gbc_btnVolver.gridy = 0;
		getContentPane().add(btnVolver, gbc_btnVolver);

		JButton btnUsuario = new JButton("Usuario");
		btnUsuario.setBackground(new Color(0, 128, 128));
		btnUsuario.setForeground(Color.BLACK);
		btnUsuario.setFont(new Font("Dialog", Font.BOLD, 17));
		btnUsuario.setPreferredSize(new Dimension(150, 50));
		btnUsuario.setMinimumSize(new Dimension(150, 50));
		btnUsuario.setMaximumSize(new Dimension(150, 50));
		GridBagConstraints gbc_btnUsuario = new GridBagConstraints();
		gbc_btnUsuario.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_btnUsuario.gridx = 3;
		gbc_btnUsuario.gridy = 0;
		getContentPane().add(btnUsuario, gbc_btnUsuario);

		JLabel lblVideojuegosDevolver = new JLabel("Videojuegos a Devolver:\n");
		lblVideojuegosDevolver.setFont(new Font("Dialog", Font.BOLD, 20));
		lblVideojuegosDevolver.setForeground(Color.BLACK);
		lblVideojuegosDevolver.setVisible(true);
		GridBagConstraints gbc_lblVideojuegosDevolver= new GridBagConstraints();
		gbc_lblVideojuegosDevolver.anchor = GridBagConstraints.WEST;
		gbc_lblVideojuegosDevolver.insets = new Insets(0, 0, 5, 5);
		gbc_lblVideojuegosDevolver.gridx = 1;
		gbc_lblVideojuegosDevolver.gridy = 1;
		getContentPane().add(lblVideojuegosDevolver, gbc_lblVideojuegosDevolver);

		//VIDEOJUEGOS A DEVOLVER

		JLabel lblPeliculasDevolver = new JLabel("Peliculas a Devolver:\n");
		lblPeliculasDevolver.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPeliculasDevolver.setForeground(Color.BLACK);
		lblPeliculasDevolver.setVisible(true);
		GridBagConstraints gbc_lblPeliculasDevolver= new GridBagConstraints();
		gbc_lblPeliculasDevolver.anchor = GridBagConstraints.WEST;
		gbc_lblPeliculasDevolver.insets = new Insets(0, 0, 5, 5);
		gbc_lblPeliculasDevolver.gridx = 1;
		gbc_lblPeliculasDevolver.gridy = 3;
		getContentPane().add(lblPeliculasDevolver, gbc_lblPeliculasDevolver);

		//PELICULAS A DEVOLVER
		
		// Establecer el icono de la ventana
	      ImageIcon icon = new ImageIcon(getClass().getResource("../imagenes/logo.png"));
	      setIconImage(icon.getImage());
	}

}
