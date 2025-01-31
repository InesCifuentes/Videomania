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
import javax.swing.JPopupMenu;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JTextField;

import controlador.ControladorBuscarUsuario;
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

      	int partH = height / 3;
		int partW = width / 3;
       
      	setSize(pantalla);

      	GridBagLayout gridBagLayout = new GridBagLayout();
      	gridBagLayout.columnWidths = new int[]{partW/2, partW, partW, partW/2};
      	gridBagLayout.rowHeights = new int[]{partH/8, partH/4, partH/6, partH/2, partH-partH/12};
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
					boolean alquilado = controladorBuscarUsuario.buscarAlquiler(nombre);
					if(alquilado) {
						lblErrorNoAlquilar.setVisible(false);
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

						JLabel productosCliente = new JLabel("\nProductos a Alquilar:\n");
						productosCliente.setFont(new Font("Dialog", Font.BOLD, 20));
						productosCliente.setForeground(Color.BLACK);
						productosCliente.setVisible(true);
						GridBagConstraints gbc_productosCliente = new GridBagConstraints();
						gbc_productosCliente.anchor = GridBagConstraints.SOUTH;
						gbc_productosCliente.insets = new Insets(0, 0, 5, 5);
						gbc_productosCliente.gridx = 1;
						gbc_productosCliente.gridy = 2;
						getContentPane().add(productosCliente, gbc_productosCliente);

						ArrayList<String> productos = controladorBuscarUsuario.obtenerProductos(nombre);

						//MOSTRAR EL PEDIDO
						//LOS PRODUCTOS DEL CLIENTE QUE SE BUSCAN SON LOS DEL ARRAYlIST
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