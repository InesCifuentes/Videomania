package vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JTextField;

import controlador.ControladorBuscarUsuario;

public class InterfazConsultarPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtBuscarNombre;
	private JLabel lblErrorNoExiste;
	
	/**
	 * Create the frame.
	 */
	public InterfazConsultarPedido() {
		// Configura el título de la ventana
		super("Consultar Pedido");
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
			
		int part = height / 3;
		
		setSize(pantalla);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{width/4, width/3, width/4};
		gridBagLayout.rowHeights = new int[]{part,part/4, part/4, part/2, part};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0};
		getContentPane().setLayout(gridBagLayout);

		JButton btnVolver = new JButton("< Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazPantallaGes interfazPantallaGes = new InterfazPantallaGes();
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
		JMenuItem itemNombre = new JMenuItem(getName()); //Como obtiene el nombre de usuario??
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
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Dialog", Font.BOLD, 20));
		btnBuscar.setBackground(new Color(0, 128, 128));
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.setPreferredSize(new Dimension(150, 50));
		btnBuscar.setMinimumSize(new Dimension(150, 50));
      	btnBuscar.setMaximumSize(new Dimension(150, 50));
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 3;
		getContentPane().add(btnBuscar, gbc_btnBuscar);

		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtBuscarNombre.getText();
				ControladorBuscarUsuario controladorBuscarUsuario = new ControladorBuscarUsuario();
				boolean existe = controladorBuscarUsuario.buscarUsuario(nombre);

				if(existe) {
					//MOSTRAR EL PEDIDO
					lblErrorNoExiste.setVisible(existe);
					
				}
				else {
					//Mostrar mensaje de error
					lblErrorNoExiste.setVisible(true);

				}
			}
		});

		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuUsuario.show(btnUsuario, btnUsuario.getWidth(), btnUsuario.getHeight());
			}
		});
	}
	
}