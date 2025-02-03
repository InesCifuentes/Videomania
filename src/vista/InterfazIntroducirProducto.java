package vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import controlador.ControladorIntroducirProducto;
import modelo.modeloVO.UsuarioVO;

import javax.swing.JPopupMenu;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazIntroducirProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
    private JLabel lblErrorVacio;
	
	/**
	 * Create the frame.
	 */
	public InterfazIntroducirProducto(UsuarioVO usuarioVO) {
		// Quita los botones de cerrar, minimizar y maximizar
        setUndecorated(true); 
        
        // Configura el tamaño de la ventana
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension pantalla = toolkit.getScreenSize();
        int width = (int) pantalla.getWidth();
        int height = (int) pantalla.getHeight();
        
        int partW = width / 4;
        int partH = height / 8;
        
        setSize(pantalla);
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{partW, width-partW, partW};
        gridBagLayout.rowHeights = new int[]{(2*partH-partH/8), partH/4, partH/2, partH/2, partH/2, partH/2, partH/2, partH/2, partH/2, partH/2, (2*partH-partH/8)};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        getContentPane().setLayout(gridBagLayout);

        JButton btnVolver = new JButton("< Volver");
        btnVolver.setBackground(new Color(0, 128, 128));
        btnVolver.setForeground(Color.BLACK);
        btnVolver.setFont(new Font("Dialog", Font.BOLD, 17));
        btnVolver.setPreferredSize(new Dimension(150, 50));
        btnVolver.setMinimumSize(new Dimension(150, 50));
        btnVolver.setMaximumSize(new Dimension(150, 50));
        
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		InterfazModificarCatalogo interfazModCat = new InterfazModificarCatalogo(usuarioVO);
                interfazModCat.setVisible(true);
                dispose(); // Cierra la ventana actual
        	}
        });
        
        GridBagConstraints gbc_btnVolver = new GridBagConstraints();
        gbc_btnVolver.insets = new Insets(0, 0, 5, 5);
        gbc_btnVolver.gridx = 0;
        gbc_btnVolver.gridy = 0;
        gbc_btnVolver.anchor = GridBagConstraints.NORTHWEST;
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
        
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setForeground(Color.BLACK);
        lblNombre.setFont(new Font("Dialog", Font.BOLD, 25));
        GridBagConstraints gbc_lblNombre = new GridBagConstraints();
        gbc_lblNombre.anchor = GridBagConstraints.WEST;
        gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblNombre.gridx = 1;
        gbc_lblNombre.gridy = 1;
        getContentPane().add(lblNombre, gbc_lblNombre);
        
        textField = new JTextField();
        textField.setFont(new Font("Dialog", Font.PLAIN, 20));
        textField.setForeground(Color.BLACK);
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.BOTH;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 2;
        getContentPane().add(textField, gbc_textField);
        textField.setColumns(10);
        
        JLabel lblCategoria = new JLabel("Categoría");
        lblCategoria.setForeground(Color.BLACK);
        lblCategoria.setFont(new Font("Dialog", Font.BOLD, 25));
        GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
        gbc_lblCategoria.anchor = GridBagConstraints.WEST;
        gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
        gbc_lblCategoria.gridx = 1;
        gbc_lblCategoria.gridy = 3;
        getContentPane().add(lblCategoria, gbc_lblCategoria);

        JComboBox<String> comboBoxCategoria = new JComboBox<>();
        comboBoxCategoria.setFont(new Font("Dialog", Font.PLAIN, 20));
        comboBoxCategoria.setForeground(Color.BLACK);
        comboBoxCategoria.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                if(comboBoxCategoria.getItemCount() == 0) {
                    ControladorIntroducirProducto controlador = new ControladorIntroducirProducto();
                    String[] categorias = controlador.obtenerCategorias();
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
        gbc_comboBoxCategoria.gridx = 1;
        gbc_comboBoxCategoria.gridy = 4;
        getContentPane().add(comboBoxCategoria, gbc_comboBoxCategoria);
		
        JLabel lblGenero = new JLabel("Género");
        lblGenero.setForeground(Color.BLACK);
        lblGenero.setFont(new Font("Dialog", Font.BOLD, 25));
        GridBagConstraints gbc_lblGenero = new GridBagConstraints();
        gbc_lblGenero.anchor = GridBagConstraints.WEST;
        gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
        gbc_lblGenero.gridx = 1;
        gbc_lblGenero.gridy = 5;
        getContentPane().add(lblGenero, gbc_lblGenero);

        JComboBox<String> comboBoxGenero = new JComboBox<>();
        comboBoxGenero.setFont(new Font("Dialog", Font.PLAIN, 20));
        comboBoxGenero.setForeground(Color.BLACK);
        comboBoxGenero.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                if(comboBoxGenero.getItemCount() == 0) {
                	ControladorIntroducirProducto controlador = new ControladorIntroducirProducto();
                    String[] generos = controlador.obtenerGeneros();
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
		gbc_comboBoxGenero.gridx = 1;
		gbc_comboBoxGenero.gridy = 6;
		getContentPane().add(comboBoxGenero, gbc_comboBoxGenero); 
        
        JLabel lblPegi = new JLabel("PEGI");
        lblPegi.setForeground(Color.BLACK);
        lblPegi.setFont(new Font("Dialog", Font.BOLD, 25));
        GridBagConstraints gbc_lblPegi = new GridBagConstraints();
        gbc_lblPegi.anchor = GridBagConstraints.WEST;
        gbc_lblPegi.insets = new Insets(0, 0, 5, 5);
        gbc_lblPegi.gridx = 1;
        gbc_lblPegi.gridy = 7;
        getContentPane().add(lblPegi, gbc_lblPegi);

        JComboBox<String> comboBoxPEGI = new JComboBox<>();
        comboBoxPEGI.setFont(new Font("Dialog", Font.PLAIN, 20));
        comboBoxPEGI.setForeground(Color.BLACK);
        comboBoxPEGI.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                if(comboBoxPEGI.getItemCount() == 0) {
                    String[] mayoria = {"Sí", "No"};
                    for (String edad : mayoria) {
                        comboBoxPEGI.addItem(edad);
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
		
		GridBagConstraints gbc_comboBoxPEGI = new GridBagConstraints();
		gbc_comboBoxPEGI.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxPEGI.fill = GridBagConstraints.EAST;
		gbc_comboBoxPEGI.gridx = 1;
		gbc_comboBoxPEGI.gridy = 7;
		getContentPane().add(comboBoxPEGI, gbc_comboBoxPEGI); 

        lblErrorVacio = new JLabel("No puede haber campos vacíos");
        lblErrorVacio.setFont(new Font("Dialog", Font.BOLD, 17));
        lblErrorVacio.setForeground(Color.RED);
        lblErrorVacio.setVisible(false);
        GridBagConstraints gbc_lblErrorVacio = new GridBagConstraints();
        gbc_lblErrorVacio.insets = new Insets(0, 0, 5, 5);
        gbc_lblErrorVacio.gridx = 1;
        gbc_lblErrorVacio.gridy = 8;
        getContentPane().add(lblErrorVacio, gbc_lblErrorVacio);

        JButton btnAadir = new JButton("Añadir");
        btnAadir.setBackground(new Color(0, 128, 128));
        btnAadir.setForeground(Color.BLACK);
        btnAadir.setFont(new Font("Dialog", Font.BOLD, 20));
        GridBagConstraints gbc_btnAadir = new GridBagConstraints();
        gbc_btnAadir.anchor = GridBagConstraints.NORTH;
        gbc_btnAadir.insets = new Insets(0, 0, 0, 5);
        gbc_btnAadir.gridx = 1;
        gbc_btnAadir.gridy = 9;
        getContentPane().add(btnAadir, gbc_btnAadir);

        btnAadir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = textField.getText();
                String categoria = (String) comboBoxCategoria.getSelectedItem();
                String genero = (String) comboBoxGenero.getSelectedItem();
                String pegi = (String) comboBoxPEGI.getSelectedItem();

                if(nombre == null || nombre.equals("") || categoria == null || genero == null ||  pegi == null) {
                    lblErrorVacio.setVisible(true);
                    return;
                }
                else {
                    lblErrorVacio.setVisible(false);
                    ControladorIntroducirProducto controlador = new ControladorIntroducirProducto();
                    boolean creado = controlador.existeProducto(nombre);
                    if(!creado) {
                        controlador.crearProducto(nombre, categoria, genero, pegi);
                        controlador.crearUnidadProducto(nombre);
                        InterfazPantallaGes gestor = new InterfazPantallaGes(usuarioVO);
                        gestor.setVisible(true);
                        dispose(); // Cierra la ventana actual
                    }
                    else {
                        //lblErrorVacio.setText("El producto ya existe");
                        //lblErrorVacio.setVisible(true);
                        controlador.crearUnidadProducto(nombre);
                        InterfazPantallaGes gestor = new InterfazPantallaGes(usuarioVO);
                        gestor.setVisible(true);
                        dispose(); // Cierra la ventana actual
                    }
                    
                }
            }
        });
        
           
     // Establecer el icono de la ventana
        ImageIcon icon = new ImageIcon(getClass().getResource("../imagenes/logo.png"));
        setIconImage(icon.getImage());
        
	}

}
