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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import controlador.ControladorBuscarProducto;

public class InterfazSacarProductos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtBuscarProducto;
	private JLabel lblErrorNoProductos;
	
	/**
	 * Create the frame.
	 */
	public InterfazSacarProductos() {
		// Quita los botones de cerrar, minimizar y maximizar
        setUndecorated(true); 
        
     	// Configura el tamaño de la ventana
      	Toolkit toolkit = Toolkit.getDefaultToolkit();
      	Dimension pantalla = toolkit.getScreenSize();
      	int width = (int) pantalla.getWidth();
      	int height = (int) pantalla.getHeight();

      	int partH = height / 3;
		int partW = width / 4;
       
      	setSize(pantalla);

      	GridBagLayout gridBagLayout = new GridBagLayout();
      	gridBagLayout.columnWidths = new int[]{partW/2, partW, partW, partW, partW/2};
      	gridBagLayout.rowHeights = new int[]{partH/8, partH/4, partH/6, partH/2, partH-partH/12};
      	gridBagLayout.columnWeights = new double[]{0.0, 1.0};
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
		gbc_btnUsuario.gridx = 4;
		gbc_btnUsuario.gridy = 0;
		getContentPane().add(btnUsuario, gbc_btnUsuario);
		
		txtBuscarProducto = new JTextField();
		txtBuscarProducto.setFont(new Font("Dialog", Font.PLAIN, 25));
		txtBuscarProducto.setText("Buscar producto...");
		//txtBuscarProducto.setSize(pantalla.width/2, 50);
		txtBuscarProducto.setPreferredSize(new Dimension(partW, 50));
		txtBuscarProducto.setMinimumSize(new Dimension(partW, 50));
		txtBuscarProducto.setMaximumSize(new Dimension(partW, 50));
		GridBagConstraints gbc_txtBuscarProducto = new GridBagConstraints();
		gbc_txtBuscarProducto.insets = new Insets(0, 0, 5, 5);
		gbc_txtBuscarProducto.fill = GridBagConstraints.BOTH;
		gbc_txtBuscarProducto.gridx = 1;
		gbc_txtBuscarProducto.gridy = 1;
		getContentPane().add(txtBuscarProducto, gbc_txtBuscarProducto);
		txtBuscarProducto.setColumns(10);

		lblErrorNoProductos = new JLabel("No se han encontrado productos con ese nombre");
        lblErrorNoProductos.setFont(new Font("Dialog", Font.BOLD, 17));
        lblErrorNoProductos.setForeground(Color.RED);
        lblErrorNoProductos.setVisible(false);
        GridBagConstraints gbc_lblErrorNoProductos = new GridBagConstraints();
        gbc_lblErrorNoProductos.anchor = GridBagConstraints.SOUTH;
        gbc_lblErrorNoProductos.insets = new Insets(0, 0, 5, 5);
        gbc_lblErrorNoProductos.gridx = 2;
        gbc_lblErrorNoProductos.gridy = 3;
        getContentPane().add(lblErrorNoProductos, gbc_lblErrorNoProductos);
         
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
				ControladorBuscarProducto controladorBuscarProducto = new ControladorBuscarProducto();
				ArrayList<String> productos = controladorBuscarProducto.buscarProducto(txtBuscarProducto.getText());
				if(productos.size() == 0) {
					//Mostrar mensaje de que no se ha encontrado el producto
					lblErrorNoProductos.setVisible(true);
				}
				else {
					lblErrorNoProductos.setVisible(false);
					//MOSTRAR LOS PRODUCTOS QUE OBTIENE EL CONTROLADOR ALMACENADOS EN EL ARRAYLIST

				}
			}
		});
        
        JComboBox<String> comboBoxCategoria = new JComboBox<>();
		comboBoxCategoria.addItem("Todos");
        comboBoxCategoria.setFont(new Font("Dialog", Font.PLAIN, 20));
		comboBoxCategoria.setForeground(Color.BLACK);
        comboBoxCategoria.addPopupMenuListener(new PopupMenuListener() {
		    @Override
        	public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
    	        if(comboBoxCategoria.getItemCount() == 1) {
    		        String[] categorias = {"Videojuego", "Película"};
        		    for (String categoria : categorias) {
        	            comboBoxCategoria.addItem(categoria);
    	            }
    		    }
        		        
            }

        	@Override
    	    public void popupMenuCanceled(PopupMenuEvent e) {
        		        
    		}

    	    @Override
    		public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
        		        
    	    }

        		    
    	});
        		
        GridBagConstraints gbc_comboBoxCategoria = new GridBagConstraints();
        gbc_comboBoxCategoria.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxCategoria.fill = GridBagConstraints.BOTH;
        gbc_comboBoxCategoria.gridx = 3;
        gbc_comboBoxCategoria.gridy = 1;
        getContentPane().add(comboBoxCategoria, gbc_comboBoxCategoria);
		
		comboBoxCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String categoria = (String) comboBoxCategoria.getSelectedItem();
				ControladorBuscarProducto controladorBuscarProducto = new ControladorBuscarProducto();
				ArrayList<String> productosCat = controladorBuscarProducto.buscarProductoCategoria(categoria);
				
				if(categoria.equals("Todos")) {
					
					//MOSTRAR TODOS LOS PRODUCTOS SE ENCUENTRA EN EL ARRAYLIST productosCat
				}
				else {
					JComboBox<String> comboBoxGenero = new JComboBox<>();
					comboBoxGenero.addItem("Todos");
					comboBoxGenero.setFont(new Font("Dialog", Font.PLAIN, 20));
					comboBoxGenero.setForeground(Color.BLACK);
					comboBoxGenero.addPopupMenuListener(new PopupMenuListener() {
						@Override
						public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
							if(comboBoxGenero.getItemCount() == 1) {
								String[] generos = {"Drama", "Terror", "Comedia", "Accion", "Ciencia Ficcion", "Biografico"};
								for (String genero : generos) {
									comboBoxGenero.addItem(genero);
								}
							}
							
						}

						@Override
						public void popupMenuCanceled(PopupMenuEvent e) {
							
						}

						@Override
						public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
							
						}

						
					});
							
					GridBagConstraints gbc_comboBoxGenero = new GridBagConstraints();
					gbc_comboBoxGenero.insets = new Insets(0, 0, 5, 5);
					gbc_comboBoxGenero.fill = GridBagConstraints.BOTH;
					gbc_comboBoxGenero.gridx = 3;
					gbc_comboBoxGenero.gridy = 1;
					getContentPane().add(comboBoxGenero, gbc_comboBoxGenero);

					comboBoxGenero.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String genero = (String) comboBoxGenero.getSelectedItem();
							ArrayList<String> productosGen = controladorBuscarProducto.buscarProductoGenero(genero);
							if(genero.equals("Todos")) {
								if(categoria.equals("Videojuego")) {

					
									//MOSTRAR LOS PRODUCTOS DE VIDEOJUEGO SE ENCUENTRA EN EL ARRAYLIST productosCat
								}
								else {
									
									//MOSTRAR LOS PRODUCTOS DE PELICULA SE ENCUENTRA EN EL ARRAYLIST productosCat
								}
								
								
							}
							else {
								ArrayList<String> prodGenyCat = new ArrayList<>();
								for(String producto : productosGen) {
									if(productosCat.contains(producto)) {
										prodGenyCat.add(producto);
									}
								}

								//MOSTRAR LOS PRODUCTOS QUE SE ENCUENTRAN EN EL ARRAYLIST prodGenyCat
							}
						}
					});
					
				}
			}
		});

		//SE MUESTRAN SIEMPRE TODOS LOS PRODUCTOS

		

		// Establecer el icono de la ventana
	      ImageIcon icon = new ImageIcon(getClass().getResource("../imagenes/logo.png"));
	      setIconImage(icon.getImage());
	}

}
