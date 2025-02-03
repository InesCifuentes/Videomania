package vista;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import controlador.ControladorAlquilaProducto;
import controlador.ControladorBuscarUsuario;
import modelo.modeloVO.AlquilerVO;
import modelo.modeloVO.ClienteVO;
import modelo.modeloVO.ProductoVO;

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
      	gridBagLayout.rowHeights = new int[]{partH/2, partH/2, partH/6, partH/2, 6*partH-2*partH/3, partH};
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

		JLabel lblEdad = new JLabel("Edad:	");
		lblEdad.setFont(new Font("Dialog", Font.BOLD, 20));
		lblEdad.setForeground(Color.BLACK);
		lblEdad.setVisible(true);
		GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdad.gridx = 0;
		gbc_lblEdad.gridy = 3;
		getContentPane().add(lblEdad, gbc_lblEdad);

		JLabel lblNumEdad = new JLabel(String.valueOf(usuario.getEdad()));
		lblNumEdad.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNumEdad.setForeground(Color.BLACK);
		lblNumEdad.setVisible(true);
		GridBagConstraints gbc_lblNumEdad = new GridBagConstraints();
		gbc_lblNumEdad.anchor = GridBagConstraints.EAST;
		gbc_lblNumEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumEdad.gridx = 0;
		gbc_lblNumEdad.gridy = 3;
		getContentPane().add(lblNumEdad, gbc_lblNumEdad);

		JLabel lblCarrito = new JLabel("Carrito");
		lblCarrito.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCarrito.setForeground(Color.BLACK);
		lblCarrito.setVisible(true);
		GridBagConstraints gbc_lblCarrito = new GridBagConstraints();
		gbc_lblCarrito.insets = new Insets(0, 0, 5, 5);
		gbc_lblCarrito.gridx = 1;
		gbc_lblCarrito.gridy = 1;
		getContentPane().add(lblCarrito, gbc_lblCarrito);

		//MOSTRAR EL CARRITO
		// Crear un panel para los productos
		JPanel panelProductos = new JPanel();
		panelProductos.setLayout(new GridBagLayout());
		GridBagConstraints gbc_panelProductos = new GridBagConstraints();
		gbc_panelProductos.gridx = 1;
		gbc_panelProductos.gridy = 4;
		gbc_panelProductos.gridwidth = 1;
		gbc_panelProductos.fill = GridBagConstraints.BOTH;
		gbc_panelProductos.weightx = 1.0;
		gbc_panelProductos.weighty = 1.0;

		// Crear un JScrollPane y agregar el panel de productos
		JScrollPane scrollPane = new JScrollPane(panelProductos);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		gbc_scrollPane.gridwidth = 1;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		getContentPane().add(scrollPane, gbc_scrollPane);
		scrollPane.setVisible(true);

		int gridY = 0;
		ControladorBuscarUsuario controladorBuscarUsuario = new ControladorBuscarUsuario();

		JLabel alquilarProductos = new JLabel("Productos a Alquilar");
		alquilarProductos.setFont(new Font("Dialog", Font.BOLD, 20));
		alquilarProductos.setForeground(Color.BLACK);
		alquilarProductos.setVisible(true);
		GridBagConstraints gbc_alquilarProductos = new GridBagConstraints();
		gbc_alquilarProductos.anchor = GridBagConstraints.SOUTH;
		gbc_alquilarProductos.insets = new Insets(0, 0, 5, 5);
		gbc_alquilarProductos.gridx = 0;
		gbc_alquilarProductos.gridy = gridY;
		panelProductos.add(alquilarProductos, gbc_alquilarProductos);

		gridY++;

		ArrayList<ProductoVO> productos = controladorBuscarUsuario.obtenerProductos(usuario.getNombre());
		for(ProductoVO productoVO : productos) {
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
			gbc_lblProducto.gridx = 0;
			gbc_lblProducto.gridy = gridY;
			panelProductos.add(lblProducto, gbc_lblProducto);

			JLabel lblCategoria = new JLabel(productoVO.getCategoria());
			lblCategoria.setForeground(Color.BLACK);
			lblCategoria.setFont(new Font("Dialog", Font.BOLD, 17));
			lblCategoria.setPreferredSize(new Dimension(350, 50));
			lblCategoria.setMinimumSize(new Dimension(350, 50));
			lblCategoria.setMaximumSize(new Dimension(350, 50));
			lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
			lblCategoria.setVerticalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
			gbc_lblCategoria.anchor = GridBagConstraints.CENTER;
			gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
			gbc_lblCategoria.gridx = 1;
			gbc_lblCategoria.gridy = gridY;
			panelProductos.add(lblCategoria, gbc_lblCategoria);

			gridY++;
		}

		JLabel lbldevolverProductos = new JLabel("Productos a Devolver");
		lbldevolverProductos.setFont(new Font("Dialog", Font.BOLD, 20));
		lbldevolverProductos.setForeground(Color.BLACK);
		lbldevolverProductos.setVisible(true);
		GridBagConstraints gbc_lbldevolverProductos = new GridBagConstraints();
		gbc_lbldevolverProductos.anchor = GridBagConstraints.SOUTH;
		gbc_lbldevolverProductos.insets = new Insets(0, 0, 5, 5);
		gbc_lbldevolverProductos.gridx = 0;
		gbc_lbldevolverProductos.gridy = gridY;
		panelProductos.add(lbldevolverProductos, gbc_lbldevolverProductos);

		gridY++;

		ArrayList<ProductoVO> devolver = controladorBuscarUsuario.obtenerProdDevolver(usuario.getNombre());
		for(ProductoVO productoVO : devolver) {
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
			gbc_lblProducto.gridx = 0;
			gbc_lblProducto.gridy = gridY;
			panelProductos.add(lblProducto, gbc_lblProducto);

			JLabel lblCategoria = new JLabel(productoVO.getCategoria());
			lblCategoria.setForeground(Color.BLACK);
			lblCategoria.setFont(new Font("Dialog", Font.BOLD, 17));
			lblCategoria.setPreferredSize(new Dimension(350, 50));
			lblCategoria.setMinimumSize(new Dimension(350, 50));
			lblCategoria.setMaximumSize(new Dimension(350, 50));
			lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
			lblCategoria.setVerticalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
			gbc_lblCategoria.anchor = GridBagConstraints.CENTER;
			gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
			gbc_lblCategoria.gridx = 1;
			gbc_lblCategoria.gridy = gridY;
			panelProductos.add(lblCategoria, gbc_lblCategoria);

			gridY++;
		}

		JLabel lblmulta = new JLabel("Multas");
		lblmulta.setFont(new Font("Dialog", Font.BOLD, 20));
		lblmulta.setForeground(Color.BLACK);
		lblmulta.setVisible(true);
		GridBagConstraints gbc_lblmulta = new GridBagConstraints();
		gbc_lblmulta.anchor = GridBagConstraints.SOUTH;
		gbc_lblmulta.insets = new Insets(0, 0, 5, 5);
		gbc_lblmulta.gridx = 0;
		gbc_lblmulta.gridy = gridY;
		panelProductos.add(lblmulta, gbc_lblmulta);

		gridY++;

		AlquilerVO alquiler = controladorBuscarUsuario.obtenerAlquiler(usuario.getNombre());

		for(ProductoVO productoVO : productos) {
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
			gbc_lblProducto.gridx = 0;
			gbc_lblProducto.gridy = gridY;
			panelProductos.add(lblProducto, gbc_lblProducto);

			boolean multa = controladorBuscarUsuario.buscarMulta(alquiler);

			if(multa) {
				JLabel lblMulta = new JLabel("5.00 €");
				lblMulta.setForeground(Color.BLACK);
				lblMulta.setFont(new Font("Dialog", Font.BOLD, 17));
				lblMulta.setPreferredSize(new Dimension(350, 50));
				lblMulta.setMinimumSize(new Dimension(350, 50));
				lblMulta.setMaximumSize(new Dimension(350, 50));
				lblMulta.setHorizontalAlignment(SwingConstants.CENTER);
				lblMulta.setVerticalAlignment(SwingConstants.CENTER);
				GridBagConstraints gbc_lblMulta = new GridBagConstraints();
				gbc_lblMulta.anchor = GridBagConstraints.CENTER;
				gbc_lblMulta.insets = new Insets(0, 0, 5, 5);
				gbc_lblMulta.gridx = 1;
				gbc_lblMulta.gridy = gridY;
				panelProductos.add(lblMulta, gbc_lblMulta);

				gridY++;
			}
			else {
				JLabel lblNoMulta = new JLabel("No hay multa");
				lblNoMulta.setForeground(Color.BLACK);
				lblNoMulta.setFont(new Font("Dialog", Font.BOLD, 17));
				lblNoMulta.setPreferredSize(new Dimension(350, 50));
				lblNoMulta.setMinimumSize(new Dimension(350, 50));
				lblNoMulta.setMaximumSize(new Dimension(350, 50));
				lblNoMulta.setHorizontalAlignment(SwingConstants.CENTER);
				lblNoMulta.setVerticalAlignment(SwingConstants.CENTER);
				GridBagConstraints gbc_lblNoMulta = new GridBagConstraints();
				gbc_lblNoMulta.anchor = GridBagConstraints.CENTER;
				gbc_lblNoMulta.insets = new Insets(0, 0, 5, 5);
				gbc_lblNoMulta.gridx = 1;
				gbc_lblNoMulta.gridy = gridY;
				panelProductos.add(lblNoMulta, gbc_lblNoMulta);

				gridY++;
			}
		}

		gridY++;

		JLabel lblTotal = new JLabel("TOTAL:");
		lblTotal.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTotal.setForeground(Color.BLACK);
		lblTotal.setVisible(true);
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.SOUTH;
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.gridx = 0;
		gbc_lblTotal.gridy = gridY;
		panelProductos.add(lblTotal, gbc_lblTotal);

		double total = 0;
		gridY++;

		for(ProductoVO productoVO : productos){
			double precio = controladorBuscarUsuario.obtenerPrecio(productoVO);
			JLabel lblPrecio = new JLabel(String.format("%.2f", precio));
			lblPrecio.setFont(new Font("Dialog", Font.BOLD, 20));
			lblPrecio.setForeground(Color.BLACK);
			lblPrecio.setVisible(true);
			GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
			gbc_lblPrecio.anchor = GridBagConstraints.SOUTH;
			gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrecio.gridx = 1;
			gbc_lblPrecio.gridy = gridY;
			panelProductos.add(lblPrecio, gbc_lblPrecio);

			gridY++;
			total += precio;

			boolean multa = controladorBuscarUsuario.buscarMulta(alquiler);
			if(multa) {
				JLabel lblMulta = new JLabel("5.00 €");
				lblMulta.setForeground(Color.BLACK);
				lblMulta.setFont(new Font("Dialog", Font.BOLD, 17));
				lblMulta.setPreferredSize(new Dimension(350, 50));
				lblMulta.setMinimumSize(new Dimension(350, 50));
				lblMulta.setMaximumSize(new Dimension(350, 50));
				lblMulta.setHorizontalAlignment(SwingConstants.CENTER);
				lblMulta.setVerticalAlignment(SwingConstants.CENTER);
				GridBagConstraints gbc_lblMulta = new GridBagConstraints();
				gbc_lblMulta.anchor = GridBagConstraints.CENTER;
				gbc_lblMulta.insets = new Insets(0, 0, 5, 5);
				gbc_lblMulta.gridx = 1;
				gbc_lblMulta.gridy = gridY;
				panelProductos.add(lblMulta, gbc_lblMulta);

				gridY++;
			}
		}

		JLabel lblSuma = new JLabel("+ _________________________");
		lblSuma.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSuma.setForeground(Color.BLACK);
		lblSuma.setVisible(true);
		GridBagConstraints gbc_lblSuma = new GridBagConstraints();
		gbc_lblSuma.anchor = GridBagConstraints.SOUTH;
		gbc_lblSuma.insets = new Insets(0, 0, 5, 5);
		gbc_lblSuma.gridx = 0;
		gbc_lblSuma.gridy = gridY;
		panelProductos.add(lblSuma, gbc_lblSuma);

		gridY++;

		JLabel lblTotalSuma = new JLabel(String.format("%.2f", total));
		lblTotalSuma.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTotalSuma.setForeground(Color.BLACK);
		lblTotalSuma.setVisible(true);
		GridBagConstraints gbc_lblTotalSuma = new GridBagConstraints();
		gbc_lblTotalSuma.anchor = GridBagConstraints.SOUTH;
		gbc_lblTotalSuma.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalSuma.gridx = 0;
		gbc_lblTotalSuma.gridy = gridY;
		panelProductos.add(lblTotalSuma, gbc_lblTotalSuma);

		gridY++;

      	
      	JButton btnCerrarSesion = new JButton("Cerrar Sesion");
      	btnCerrarSesion.setForeground(Color.BLACK);
      	btnCerrarSesion.setBackground(new Color(0, 128, 128));
      	btnCerrarSesion.setFont(new Font("Dialog", Font.BOLD, 20));
      	GridBagConstraints gbc_btnCerrarSesion = new GridBagConstraints();
      	gbc_btnCerrarSesion.anchor = GridBagConstraints.SOUTH;
      	gbc_btnCerrarSesion.insets = new Insets(0, 0, 0, 5);
      	gbc_btnCerrarSesion.gridx = 0;
      	gbc_btnCerrarSesion.gridy = 5;
      	getContentPane().add(btnCerrarSesion, gbc_btnCerrarSesion);

		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorAlquilaProducto controlador = new ControladorAlquilaProducto();
				controlador.cancelarProcesamiento();
				InterfazPrincipal principal = new InterfazPrincipal();
				principal.setVisible(true);
				dispose();
			}
		});
      	
      	JButton btnVolver = new JButton("< Volver");
      	btnVolver.setForeground(Color.BLACK);
      	btnVolver.setFont(new Font("Dialog", Font.BOLD, 20));
      	btnVolver.setBackground(new Color(0, 128, 128));
      	GridBagConstraints gbc_btnVolver = new GridBagConstraints();
      	gbc_btnVolver.anchor = GridBagConstraints.SOUTH;
      	gbc_btnVolver.insets = new Insets(0, 0, 0, 5);
      	gbc_btnVolver.gridx = 1;
      	gbc_btnVolver.gridy = 5;
      	getContentPane().add(btnVolver, gbc_btnVolver);

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorAlquilaProducto controlador = new ControladorAlquilaProducto();
				controlador.cancelarProcesamiento();
				InterfazPantallaCli interfazPantallaCli = new InterfazPantallaCli(usuario);
				interfazPantallaCli.setVisible(true);
				dispose();
			}
		});
		
		JButton btnTerminarOperacion = new JButton("Terminar Operacion");
		btnTerminarOperacion.setForeground(Color.BLACK);
      	btnTerminarOperacion.setBackground(new Color(0, 128, 128));
      	btnTerminarOperacion.setFont(new Font("Dialog", Font.BOLD, 20));
      	btnTerminarOperacion.addActionListener(new ActionListener() {
      		public void actionPerformed(ActionEvent e) {
				ControladorAlquilaProducto controlador = new ControladorAlquilaProducto();
				controlador.crearAlquiler(usuario);
				InterfazPrincipal principal = new InterfazPrincipal();
				principal.setVisible(true);
				dispose();

      		}
      	});

      	GridBagConstraints gbc_btnTerminarOperacion = new GridBagConstraints();
      	gbc_btnTerminarOperacion.anchor = GridBagConstraints.SOUTH;
      	gbc_btnTerminarOperacion.gridx = 2;
      	gbc_btnTerminarOperacion.gridy = 5;
      	getContentPane().add(btnTerminarOperacion, gbc_btnTerminarOperacion);

		// Establecer el icono de la ventana
	     ImageIcon icon = new ImageIcon(getClass().getResource("../imagenes/logo.png"));
	     setIconImage(icon.getImage());

	}

	

}
