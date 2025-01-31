package vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import modelo.modeloVO.UsuarioVO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

public class InterfazEliminarProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the frame.
	 */
	public InterfazEliminarProducto(UsuarioVO usuarioVO) {
		// Quita los botones de cerrar, minimizar y maximizar
        setUndecorated(true); 

     	// Configura el tamaño de la ventana
      	Toolkit toolkit = Toolkit.getDefaultToolkit();
      	Dimension pantalla = toolkit.getScreenSize();
      	int width = (int) pantalla.getWidth();
      	int height = (int) pantalla.getHeight();

      	int part = height / 3;
       
      	setSize(pantalla);

      	GridBagLayout gridBagLayout = new GridBagLayout();
      	gridBagLayout.columnWidths = new int[]{width/4, width/3, width/4};
      	gridBagLayout.rowHeights = new int[]{part-part/12, part/2, part/6, part/2, part-part/12};
      	gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
      	gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0};
      	getContentPane().setLayout(gridBagLayout);

      	JButton btnVolver = new JButton("< Volver");
      	btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
         		InterfazModificarCatalogo interfazModificarCatalogo = new InterfazModificarCatalogo(usuarioVO);
            	interfazModificarCatalogo.setVisible(true);
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
		gbc_btnUsuario.gridx = 2;
		gbc_btnUsuario.gridy = 0;
		getContentPane().add(btnUsuario, gbc_btnUsuario);

		JPopupMenu menuUsuario = new JPopupMenu();
		JMenuItem itemNombre = new JMenuItem(usuarioVO.getNombre());
		itemNombre.setFont(new Font("Dialog", Font.BOLD, 15));
		menuUsuario.add(itemNombre);

		// Boton de cerrar sesion dentro del desplejable
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setFont(new Font("Dialog", Font.BOLD, 15));
		btnCerrarSesion.setBackground(new Color(0, 128, 128));
		btnCerrarSesion.setForeground(Color.BLACK);
		btnCerrarSesion.setPreferredSize(new Dimension(150, 50));
		btnCerrarSesion.setMinimumSize(new Dimension(150, 50));
		btnCerrarSesion.setMaximumSize(new Dimension(150, 50));
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazPrincipal interfazPrincipal = new InterfazPrincipal();
				interfazPrincipal.setVisible(true);
				dispose(); // Cierra la ventana actual
			}
		});

		menuUsuario.add(btnCerrarSesion);
		menuUsuario.setPreferredSize(new Dimension(150, 100));
		menuUsuario.setMinimumSize(new Dimension(150, 100));
		menuUsuario.setMaximumSize(new Dimension(1500, 100));

		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuUsuario.show(btnUsuario, btnUsuario.getWidth(), btnUsuario.getHeight());
			}
		});

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setBackground(new Color(0, 128, 128));
		btnEliminar.setFont(new Font("Dialog", Font.BOLD, 17));
		btnEliminar.setPreferredSize(new Dimension(250, 100));
		btnEliminar.setMinimumSize(new Dimension(250, 100));
		btnEliminar.setMaximumSize(new Dimension(250, 100));
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnEliminar.gridx = 2;
		gbc_btnEliminar.gridy = 4;
		getContentPane().add(btnEliminar, gbc_btnEliminar);
     
     // Establecer el icono de la ventana
		ImageIcon icon = new ImageIcon(getClass().getResource("../imagenes/logo.png"));
		setIconImage(icon.getImage());
	}

}
