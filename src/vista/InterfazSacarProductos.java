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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import controlador.ControladorAlquilaProducto;
import controlador.ControladorBuscarProducto;
import controlador.ControladorTodosLosProductos;
import modelo.modeloVO.ClienteVO;
import modelo.modeloVO.ProductoVO;

public class InterfazSacarProductos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtBuscarProducto;
	private JLabel lblErrorNoProductos;
	
	/**
	 * Create the frame.
	 */
	public InterfazSacarProductos(ClienteVO usuarioVO) {
		// Quita los botones de cerrar, minimizar y maximizar
        setUndecorated(true); 
        
     	// Configura el tamaño de la ventana
      	Toolkit toolkit = Toolkit.getDefaultToolkit();
      	Dimension pantalla = toolkit.getScreenSize();
      	int width = (int) pantalla.getWidth();
      	int height = (int) pantalla.getHeight();

      	int partH = height / 6;
		int partW = width / 4;
       
      	setSize(pantalla);

      	GridBagLayout gridBagLayout = new GridBagLayout();
      	gridBagLayout.columnWidths = new int[]{partW/2, partW, partW, partW, partW/2};
      	gridBagLayout.rowHeights = new int[]{partH, partH/2, partH/2, 4*partH-partH/2};
      	gridBagLayout.columnWeights = new double[]{0.0, 1.0};
      	gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0};
      	getContentPane().setLayout(gridBagLayout);

		// Crear un panel para los productos
        JPanel panelProductos = new JPanel();
        panelProductos.setLayout(new GridBagLayout());
        GridBagConstraints gbc_panelProductos = new GridBagConstraints();
        gbc_panelProductos.gridx = 1;
        gbc_panelProductos.gridy = 1;
        gbc_panelProductos.gridwidth = 3;
        gbc_panelProductos.fill = GridBagConstraints.BOTH;
        gbc_panelProductos.weightx = 1.0;
        gbc_panelProductos.weighty = 1.0;

        // Crear un JScrollPane y agregar el panel de productos
		JScrollPane scrollPane = new JScrollPane(panelProductos);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		getContentPane().add(scrollPane, gbc_scrollPane);
		scrollPane.setVisible(true);

      	JButton btnVolver = new JButton("< Volver");
      	btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
         		InterfazPantallaCli interfazPantallaCli = new InterfazPantallaCli(usuarioVO);
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

		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazUsuarioCli interfazUsuarioCli = new InterfazUsuarioCli(usuarioVO);
				interfazUsuarioCli.setVisible(true);
				dispose();
			}
		});
		
		txtBuscarProducto = new JTextField();
		txtBuscarProducto.setFont(new Font("Dialog", Font.PLAIN, 25));
		txtBuscarProducto.setText("Buscar producto...");
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
        gbc_lblErrorNoProductos.gridy = 2;
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
				ArrayList<ProductoVO> productos = controladorBuscarProducto.buscarProducto(txtBuscarProducto.getText());

				if(productos.size() == 0) {
					//Mostrar mensaje de que no se ha encontrado el producto
					lblErrorNoProductos.setVisible(true);
					panelProductos.removeAll(); // Eliminar todos los componentes del panel
					panelProductos.revalidate(); // Volver a validar el panel
					panelProductos.repaint(); // Repintar el panel

					ControladorTodosLosProductos controladorTodosLosProductos = new ControladorTodosLosProductos();
					ArrayList<ProductoVO> productosVO = controladorTodosLosProductos.obtenerProductos();
					int gridY = 0;
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
								ControladorAlquilaProducto controladorAlquilaProducto = new ControladorAlquilaProducto();
								controladorAlquilaProducto.alquilarProducto(usuarioVO, productoVO);
							}
						});

						gridY++;
					}

					panelProductos.revalidate(); // Volver a validar el panel después de agregar los nuevos componentes
					panelProductos.repaint(); // Repintar el panel después de agregar los nuevos componentes

				}
				else {
					lblErrorNoProductos.setVisible(false);
					
					//MOSTRAR LOS PRODUCTOS QUE OBTIENE EL CONTROLADOR ALMACENADOS EN EL ARRAYLIST
					panelProductos.removeAll(); // Eliminar todos los componentes del panel
					panelProductos.revalidate(); // Volver a validar el panel
					panelProductos.repaint(); // Repintar el panel

					int gridY = 0;
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
								ControladorAlquilaProducto controladorAlquilaProducto = new ControladorAlquilaProducto();
								controladorAlquilaProducto.alquilarProducto(usuarioVO, productoVO);
							}
						});

						gridY++;
					}
					
					panelProductos.revalidate(); // Volver a validar el panel después de agregar los nuevos componentes
					panelProductos.repaint(); // Repintar el panel después de agregar los nuevos componentes

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
					ControladorBuscarProducto controladorBuscarProducto = new ControladorBuscarProducto();
    		        String[] categorias = controladorBuscarProducto.obtenerCategorias();
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
				lblErrorNoProductos.setVisible(false);

				String categoria = (String) comboBoxCategoria.getSelectedItem();
				ControladorBuscarProducto controladorBuscarProducto = new ControladorBuscarProducto();
				ArrayList<ProductoVO> productosCat = controladorBuscarProducto.buscarProductoCategoria(categoria);

				if(!categoria.equals("Todos")) {
					panelProductos.removeAll(); // Eliminar todos los componentes del panel
					panelProductos.revalidate(); // Volver a validar el panel
					panelProductos.repaint(); // Repintar el panel

					int gridY = 0;
					for(ProductoVO productoVO : productosCat) {
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
								ControladorAlquilaProducto controladorAlquilaProducto = new ControladorAlquilaProducto();
								controladorAlquilaProducto.alquilarProducto(usuarioVO, productoVO);
							}
						});

						gridY++;
					}
								
					panelProductos.revalidate(); // Volver a validar el panel después de agregar los nuevos componentes
					panelProductos.repaint(); // Repintar el panel después de agregar los nuevos componentes

					JComboBox<String> comboBoxGenero = new JComboBox<>();
					comboBoxGenero.addItem("Todos");
					comboBoxGenero.setFont(new Font("Dialog", Font.PLAIN, 20));
					comboBoxGenero.setForeground(Color.BLACK);
					comboBoxGenero.addPopupMenuListener(new PopupMenuListener() {
						@Override
						public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
							if(comboBoxGenero.getItemCount() == 1) {
								String[] generos = controladorBuscarProducto.obtenerGeneros();
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
					// Eliminar el comboBoxCategoria del contentPane
					getContentPane().remove(comboBoxCategoria);
					btnBuscar.setVisible(false);
					txtBuscarProducto.setVisible(false);

					// Volver a validar y repintar el contentPane para reflejar los cambios
					getContentPane().revalidate();
					getContentPane().repaint();
					gbc_comboBoxCategoria.gridx = 1;
					gbc_comboBoxCategoria.gridy = 1;
					getContentPane().add(comboBoxCategoria, gbc_comboBoxCategoria);
					comboBoxCategoria.setVisible(true);
							
					GridBagConstraints gbc_comboBoxGenero = new GridBagConstraints();
					gbc_comboBoxGenero.insets = new Insets(0, 0, 5, 5);
					gbc_comboBoxGenero.fill = GridBagConstraints.BOTH;
					gbc_comboBoxGenero.gridx = 3;
					gbc_comboBoxGenero.gridy = 1;
					getContentPane().add(comboBoxGenero, gbc_comboBoxGenero);
					comboBoxGenero.setVisible(true);

					comboBoxGenero.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String genero = (String) comboBoxGenero.getSelectedItem();
							if(genero.equals("Todos")) {
								lblErrorNoProductos.setVisible(false);
								//MOSTRAR LOS PRODUCTOS DE VIDEOJUEGO SE ENCUENTRA EN EL ARRAYLIST productosCat
								panelProductos.removeAll(); // Eliminar todos los componentes del panel
								panelProductos.revalidate(); // Volver a validar el panel
								panelProductos.repaint(); // Repintar el panel

								int gridY = 0;
								for(ProductoVO productoVO : productosCat) {
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
											ControladorAlquilaProducto controladorAlquilaProducto = new ControladorAlquilaProducto();
											controladorAlquilaProducto.alquilarProducto(usuarioVO, productoVO);
										}
									});

									gridY++;
								}
								
								panelProductos.revalidate(); // Volver a validar el panel después de agregar los nuevos componentes
								panelProductos.repaint(); // Repintar el panel después de agregar los nuevos componentes
							}
							else {
								ArrayList<ProductoVO> productosGen = controladorBuscarProducto.buscarProductoGenero(genero);
								ArrayList<ProductoVO> prodGenyCat = new ArrayList<>();
								for(ProductoVO productoGen : productosGen) {
									for(ProductoVO productoCat : productosCat) {
										if(productoCat.getNombreProducto().equals(productoGen.getNombreProducto())) {
											prodGenyCat.add(productoGen);
										}
									}
								}
								
								panelProductos.removeAll(); // Eliminar todos los componentes del panel
								panelProductos.revalidate(); // Volver a validar el panel
								panelProductos.repaint(); // Repintar el panel

								if(prodGenyCat.size() == 0) {
									lblErrorNoProductos.setVisible(true);
								}
								else {
									lblErrorNoProductos.setVisible(false);
									//MOSTRAR LOS PRODUCTOS QUE SE ENCUENTRAN EN EL ARRAYLIST prodGenyCat
									int gridY = 0;
									for(ProductoVO productoVO : prodGenyCat) {
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
												ControladorAlquilaProducto controladorAlquilaProducto = new ControladorAlquilaProducto();
												controladorAlquilaProducto.alquilarProducto(usuarioVO, productoVO);
											}
										});

										gridY++;
									}
									
									panelProductos.revalidate(); // Volver a validar el panel después de agregar los nuevos componentes
									panelProductos.repaint(); // Repintar el panel después de agregar los nuevos componentes
								
								}
							}
						}
					});
					
				}
			}
		});

		//SE MUESTRAN SIEMPRE TODOS LOS PRODUCTOS
		panelProductos.removeAll(); // Eliminar todos los componentes del panel
		panelProductos.revalidate(); // Volver a validar el panel
		panelProductos.repaint(); // Repintar el panel

		ControladorTodosLosProductos controladorTodosLosProductos = new ControladorTodosLosProductos();
		ArrayList<ProductoVO> productosVO = controladorTodosLosProductos.obtenerProductos();
		int gridY = 0;
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
					ControladorAlquilaProducto controladorAlquilaProducto = new ControladorAlquilaProducto();
					controladorAlquilaProducto.alquilarProducto(usuarioVO, productoVO);
				}
			});

			gridY++;
		}

		panelProductos.revalidate(); // Volver a validar el panel después de agregar los nuevos componentes
		panelProductos.repaint(); // Repintar el panel después de agregar los nuevos componentes

		// Establecer el icono de la ventana
	      ImageIcon icon = new ImageIcon(getClass().getResource("../imagenes/logo.png"));
	      setIconImage(icon.getImage());
	}

}
