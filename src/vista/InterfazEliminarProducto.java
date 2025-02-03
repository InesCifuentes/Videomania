package vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import controlador.ControladorEliminarProducto;
import controlador.ControladorTodosLosProductos;
import modelo.modeloVO.ProductoVO;
import modelo.modeloVO.UsuarioVO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

public class InterfazEliminarProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private ArrayList<ProductoVO> productosEliminarVO;;
	
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

      	int partH = height / 6;
		int partW = width / 3;
       
      	setSize(pantalla);

      	GridBagLayout gridBagLayout = new GridBagLayout();
      	gridBagLayout.columnWidths = new int[]{partW/2, partW, partW, partW/2};
      	gridBagLayout.rowHeights = new int[]{partH, 4*partH, partH};
      	gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
      	gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0};
      	getContentPane().setLayout(gridBagLayout);

		productosEliminarVO = new ArrayList<ProductoVO>();

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
		gbc_btnUsuario.gridx = 3;
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
		menuUsuario.setMaximumSize(new Dimension(150, 100));
		
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuUsuario.show(btnUsuario, btnUsuario.getWidth(), btnUsuario.getHeight());
			}
		});

		// Crear un panel para los productos
        JPanel panelProductos = new JPanel();
        panelProductos.setLayout(new GridBagLayout());
        GridBagConstraints gbc_panelProductos = new GridBagConstraints();
        gbc_panelProductos.gridx = 0;
        gbc_panelProductos.gridy = 1;
        gbc_panelProductos.gridwidth = 4;
        gbc_panelProductos.fill = GridBagConstraints.BOTH;
        gbc_panelProductos.weightx = 1.0;
        gbc_panelProductos.weighty = 1.0;

        // Crear un JScrollPane y agregar el panel de productos
		JScrollPane scrollPane = new JScrollPane(panelProductos);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		getContentPane().add(scrollPane, gbc_scrollPane);
		scrollPane.setVisible(true);

		ControladorTodosLosProductos controladorTodosLosProductos = new ControladorTodosLosProductos();
		ArrayList<ProductoVO> productosVO = controladorTodosLosProductos.obtenerTodosProductos();
		int gridY = 1;
		for(ProductoVO productoVO : productosVO) {
			JLabel lblProducto = new JLabel(productoVO.getNombreProducto());
			lblProducto.setOpaque(true);
			lblProducto.setBackground(new Color(147, 112, 219));
			lblProducto.setForeground(Color.BLACK);
			lblProducto.setFont(new Font("Dialog", Font.BOLD, 17));
			lblProducto.setPreferredSize(new Dimension(350, 50));
			lblProducto.setMinimumSize(new Dimension(350, 50));
			lblProducto.setMaximumSize(new Dimension(350, 50));
			lblProducto.setHorizontalAlignment(SwingConstants.CENTER);
			lblProducto.setVerticalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblProducto = new GridBagConstraints();
			gbc_lblProducto.anchor = GridBagConstraints.CENTER;
			gbc_lblProducto.insets = new Insets(0, 0, 5, 5);
			gbc_lblProducto.gridx = 1;
			gbc_lblProducto.gridy = gridY;
			panelProductos.add(lblProducto, gbc_lblProducto);

			JButton btnSeleccionar = new JButton("Seleccionar");
			btnSeleccionar.setBackground(new Color(0, 191, 255));
			btnSeleccionar.setForeground(Color.BLACK);
			btnSeleccionar.setFont(new Font("Dialog", Font.BOLD, 17));
			btnSeleccionar.setPreferredSize(new Dimension(150, 50));
			btnSeleccionar.setMinimumSize(new Dimension(150, 50));
			btnSeleccionar.setMaximumSize(new Dimension(150, 50));
			GridBagConstraints gbc_btnSeleccionar = new GridBagConstraints();
			gbc_btnSeleccionar.anchor = GridBagConstraints.EAST;
			gbc_btnSeleccionar.insets = new Insets(0, 0, 5, 5);
			gbc_btnSeleccionar.gridx = 2;
			gbc_btnSeleccionar.gridy = gridY;
			panelProductos.add(btnSeleccionar, gbc_btnSeleccionar);

			btnSeleccionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnSeleccionar.setText("Seleccionado");
					btnSeleccionar.setBackground(new Color(0, 0, 205));
					btnSeleccionar.setForeground(Color.WHITE);
					productosEliminarVO.add(productoVO);

				}
			});

			gridY++;
		}
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setBackground(new Color(0, 128, 128));
		btnEliminar.setFont(new Font("Dialog", Font.BOLD, 17));
		btnEliminar.setPreferredSize(new Dimension(150, 50));
		btnEliminar.setMinimumSize(new Dimension(150, 50));
		btnEliminar.setMaximumSize(new Dimension(150, 50));
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnEliminar.gridx = 3;
		gbc_btnEliminar.gridy = 2;
		getContentPane().add(btnEliminar, gbc_btnEliminar);

		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorEliminarProducto controladorEliminarProducto = new ControladorEliminarProducto();
				controladorEliminarProducto.eliminarProducto(productosEliminarVO);
				InterfazModificarCatalogo interfazModificarCatalogo = new InterfazModificarCatalogo(usuarioVO);
				interfazModificarCatalogo.setVisible(true);
				dispose(); // Cierra la ventana actual
			}
		});
     
     // Establecer el icono de la ventana
		ImageIcon icon = new ImageIcon(getClass().getResource("../imagenes/logo.png"));
		setIconImage(icon.getImage());
	}

}
