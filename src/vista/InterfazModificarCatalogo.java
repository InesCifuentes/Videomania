package vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

public class InterfazModificarCatalogo extends JFrame {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the frame.
	 */
	public InterfazModificarCatalogo() {
		// Configura el título de la ventana
      super("Modificar Catálogo");
      setFont(new Font("Dialog", Font.BOLD, 15));

      // Configura la operación al cerrar la ventana
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
      // Configura el tamaño de la ventana
      Toolkit toolkit = Toolkit.getDefaultToolkit();
      Dimension pantalla = toolkit.getScreenSize();
      int width = (int) pantalla.getWidth();
      int height = (int) pantalla.getHeight();
        
      int part = height / 3;
       
      setSize(pantalla);

      GridBagLayout gridBagLayout = new GridBagLayout();
      gridBagLayout.columnWidths = new int[]{width/4, width/3, width/4};
      gridBagLayout.rowHeights = new int[]{part-part/5, part/2, part/6, part/2, part-part/5};
      gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
      gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
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
        
      JButton btnDevolverProductos = new JButton("Introducir Producto");
      btnDevolverProductos.setFont(new Font("Dialog", Font.BOLD, 25));
      btnDevolverProductos.setBackground(new Color(0, 128, 128));
      btnDevolverProductos.setForeground(Color.BLACK);
      GridBagConstraints gbc_btnDevolverProductos = new GridBagConstraints();
      gbc_btnDevolverProductos.fill = GridBagConstraints.BOTH;
      gbc_btnDevolverProductos.insets = new Insets(0, 0, 5, 5);
      gbc_btnDevolverProductos.gridx = 1;
      gbc_btnDevolverProductos.gridy = 1;
      getContentPane().add(btnDevolverProductos, gbc_btnDevolverProductos);
      gbc_btnDevolverProductos.gridy = 3;
      
      JButton btnEliminarProductos = new JButton("Eliminar Producto");
      btnEliminarProductos.setForeground(Color.BLACK);
      btnEliminarProductos.setBackground(new Color(0, 128, 128));
      btnEliminarProductos.setFont(new Font("Dialog", Font.BOLD, 25));
      GridBagConstraints gbc_btnEliminarProductos = new GridBagConstraints();
      gbc_btnEliminarProductos.gridy = 3;
      gbc_btnEliminarProductos.fill = GridBagConstraints.BOTH;
      gbc_btnEliminarProductos.insets = new Insets(0, 0, 5, 5);
      gbc_btnEliminarProductos.gridx = 1;
      getContentPane().add(btnEliminarProductos, gbc_btnEliminarProductos);
        
     // Establecer el icono de la ventana
      ImageIcon icon = new ImageIcon(getClass().getResource("../imagenes/logo.png"));
      setIconImage(icon.getImage());
	}

}
