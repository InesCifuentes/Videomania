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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlador.ControladorBuscarUsuario;
import modelo.modeloVO.AlquilerVO;
import modelo.modeloVO.ProductoVO;
import modelo.modeloVO.UsuarioVO;

public class InterfazConsultarPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtBuscarNombre;
	private JLabel lblErrorNoExiste, lblErrorNoAlquilar;
	
	/**
	 * Create the frame.
	 */
	public InterfazConsultarPedido(UsuarioVO usuarioVO) {
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
      	gridBagLayout.rowHeights = new int[]{partH, partH/2, partH/4, 5*partH-3*partH/4};
      	gridBagLayout.columnWeights = new double[]{0.0, 1.0};
      	gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0};
      	getContentPane().setLayout(gridBagLayout);

		JButton btnVolver = new JButton("< Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazPantallaGes interfazPantallaGes = new InterfazPantallaGes(usuarioVO);
				interfazPantallaGes.setVisible(true);
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
		
		JButton btnUsuario = new JButton("Usuario");
		btnUsuario.setBackground(new Color(0, 128, 128));
		btnUsuario.setForeground(Color.BLACK);
		btnUsuario.setFont(new Font("Dialog", Font.BOLD, 17));
		btnUsuario.setPreferredSize(new Dimension(150, 50));
		btnUsuario.setMinimumSize(new Dimension(150, 50));
		btnUsuario.setMaximumSize(new Dimension(150, 50));
		GridBagConstraints gbc_btnUsuario = new GridBagConstraints();
		gbc_btnUsuario.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_btnUsuario.gridx = 3;
		gbc_btnUsuario.gridy = 0;
		getContentPane().add(btnUsuario, gbc_btnUsuario);
		
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuUsuario.show(btnUsuario, btnUsuario.getWidth(), btnUsuario.getHeight());
			}
		});

		txtBuscarNombre = new JTextField();
		txtBuscarNombre.setFont(new Font("Dialog", Font.PLAIN, 25));
		txtBuscarNombre.setText("Buscar nombre...");
		GridBagConstraints gbc_txtBuscarNombre = new GridBagConstraints();
		gbc_txtBuscarNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtBuscarNombre.fill = GridBagConstraints.BOTH;
		gbc_txtBuscarNombre.gridx = 1;
		gbc_txtBuscarNombre.gridy = 1;
		getContentPane().add(txtBuscarNombre, gbc_txtBuscarNombre);
		txtBuscarNombre.setColumns(10);

		lblErrorNoExiste = new JLabel("No coincide el nombre de usuario con ninguna cuenta");
		lblErrorNoExiste.setFont(new Font("Dialog", Font.BOLD, 17));
		lblErrorNoExiste.setForeground(Color.RED);
		lblErrorNoExiste.setVisible(false);
		GridBagConstraints gbc_lblErrorNoExiste = new GridBagConstraints();
		gbc_lblErrorNoExiste.anchor = GridBagConstraints.SOUTH;
		gbc_lblErrorNoExiste.insets = new Insets(0, 0, 5, 5);
		gbc_lblErrorNoExiste.gridx = 1;
		gbc_lblErrorNoExiste.gridy = 2;
		getContentPane().add(lblErrorNoExiste, gbc_lblErrorNoExiste);
		
		lblErrorNoAlquilar = new JLabel("El cliente no tiene productos a alquilar");
        lblErrorNoAlquilar.setFont(new Font("Dialog", Font.BOLD, 17));
        lblErrorNoAlquilar.setForeground(Color.RED);
        lblErrorNoAlquilar.setVisible(false);
        GridBagConstraints gbc_lblErrorNoAlquilar = new GridBagConstraints();
        gbc_lblErrorNoAlquilar.anchor = GridBagConstraints.SOUTH;
        gbc_lblErrorNoAlquilar.insets = new Insets(0, 0, 5, 5);
        gbc_lblErrorNoAlquilar.gridx = 1;
        gbc_lblErrorNoAlquilar.gridy = 2;
        getContentPane().add(lblErrorNoAlquilar, gbc_lblErrorNoAlquilar);
        
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Dialog", Font.BOLD, 20));
		btnBuscar.setBackground(new Color(0, 128, 128));
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.setPreferredSize(new Dimension(150, 50));
		btnBuscar.setMinimumSize(new Dimension(150, 50));
      	btnBuscar.setMaximumSize(new Dimension(150, 50));
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 2;
		gbc_btnBuscar.gridy = 1;
		getContentPane().add(btnBuscar, gbc_btnBuscar);

		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtBuscarNombre.getText();
				ControladorBuscarUsuario controladorBuscarUsuario = new ControladorBuscarUsuario();
				boolean existe = controladorBuscarUsuario.buscarUsuario(nombre);

				if(existe) {
					//MOSTRAR EL PEDIDO
					lblErrorNoExiste.setVisible(false);
					lblErrorNoAlquilar.setVisible(false);
					boolean alquilado = controladorBuscarUsuario.buscarAlquiler(nombre);
					if(alquilado) {
						txtBuscarNombre.setVisible(false);
						btnBuscar.setVisible(false);
						
						JLabel lblnombreCliente = new JLabel("Usuario: " + nombre);
						lblnombreCliente.setFont(new Font("Dialog", Font.BOLD, 20));
						lblnombreCliente.setForeground(Color.BLACK);
						lblnombreCliente.setVisible(true);
						GridBagConstraints gbc_lblnombreCliente= new GridBagConstraints();
						gbc_lblnombreCliente.anchor = GridBagConstraints.SOUTH;
						gbc_lblnombreCliente.insets = new Insets(0, 0, 5, 5);
						gbc_lblnombreCliente.gridx = 1;
						gbc_lblnombreCliente.gridy = 1;
						getContentPane().add(lblnombreCliente, gbc_lblnombreCliente);

						//MOSTRAR EL PEDIDO
						//LOS PRODUCTOS DEL CLIENTE QUE SE BUSCAN SON LOS DEL ARRAYlIST

						// Crear un panel para los productos
						JPanel panelProductos = new JPanel();
						panelProductos.setLayout(new GridBagLayout());
						GridBagConstraints gbc_panelProductos = new GridBagConstraints();
						gbc_panelProductos.gridx = 0;
						gbc_panelProductos.gridy = 3;
						gbc_panelProductos.gridwidth = 4;
						gbc_panelProductos.fill = GridBagConstraints.BOTH;
						gbc_panelProductos.weightx = 1.0;
						gbc_panelProductos.weighty = 1.0;

						// Crear un JScrollPane y agregar el panel de productos
						JScrollPane scrollPane = new JScrollPane(panelProductos);
						scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						GridBagConstraints gbc_scrollPane = new GridBagConstraints();
						gbc_scrollPane.gridx = 0;
						gbc_scrollPane.gridy = 3;
						gbc_scrollPane.gridwidth = 4;
						gbc_scrollPane.fill = GridBagConstraints.BOTH;
						getContentPane().add(scrollPane, gbc_scrollPane);
						scrollPane.setVisible(true);

						int gridY = 3;

						JLabel productosCliente = new JLabel("Productos a Alquilar:");
						productosCliente.setFont(new Font("Dialog", Font.BOLD, 20));
						productosCliente.setForeground(Color.BLACK);
						productosCliente.setVisible(true);
						GridBagConstraints gbc_productosCliente = new GridBagConstraints();
						gbc_productosCliente.anchor = GridBagConstraints.SOUTH;
						gbc_productosCliente.insets = new Insets(0, 0, 5, 5);
						gbc_productosCliente.gridx = 1;
						gbc_productosCliente.gridy = gridY;
						panelProductos.add(productosCliente, gbc_productosCliente);

						gridY++;

						ArrayList<ProductoVO> productos = controladorBuscarUsuario.obtenerProductos(nombre);
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
							gbc_lblProducto.gridx = 1;
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
							gbc_lblCategoria.gridx = 2;
							gbc_lblCategoria.gridy = gridY;
							panelProductos.add(lblCategoria, gbc_lblCategoria);

							gridY++;
						}

						gridY++;
						JLabel multasCliente = new JLabel("Multas");
						multasCliente.setFont(new Font("Dialog", Font.BOLD, 20));
						multasCliente.setForeground(Color.BLACK);
						multasCliente.setVisible(true);
						GridBagConstraints gbc_multasCliente = new GridBagConstraints();
						gbc_multasCliente.anchor = GridBagConstraints.SOUTH;
						gbc_multasCliente.insets = new Insets(0, 0, 5, 5);
						gbc_multasCliente.gridx = 1;
						gbc_multasCliente.gridy = gridY;
						panelProductos.add(multasCliente, gbc_multasCliente);

						gridY++;

						AlquilerVO alquiler = controladorBuscarUsuario.obtenerAlquiler(nombre);

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
							gbc_lblProducto.gridx = 1;
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
								gbc_lblMulta.gridx = 2;
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
								gbc_lblNoMulta.gridx = 2;
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
						gbc_lblTotal.gridx = 1;
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
						}
						JLabel lblSuma = new JLabel("+ _________________________");
						lblSuma.setFont(new Font("Dialog", Font.BOLD, 20));
						lblSuma.setForeground(Color.BLACK);
						lblSuma.setVisible(true);
						GridBagConstraints gbc_lblSuma = new GridBagConstraints();
						gbc_lblSuma.anchor = GridBagConstraints.SOUTH;
						gbc_lblSuma.insets = new Insets(0, 0, 5, 5);
						gbc_lblSuma.gridx = 1;
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
						gbc_lblTotalSuma.gridx = 1;
						gbc_lblTotalSuma.gridy = gridY;
						panelProductos.add(lblTotalSuma, gbc_lblTotalSuma);

						gridY++;




					}
					else {
						//Mostrar mensaje de error
						lblErrorNoAlquilar.setVisible(true);
					}
					
				}
				else {
					//Mostrar mensaje de error
					lblErrorNoExiste.setVisible(true);

				}
			}
		});
		
		// Establecer el icono de la ventana
	     ImageIcon icon = new ImageIcon(getClass().getResource("../imagenes/logo.png"));
	     setIconImage(icon.getImage());
	}
	
}