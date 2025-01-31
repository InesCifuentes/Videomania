package vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import modelo.modeloVO.ClienteVO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

public class InterfazPantallaCli extends JFrame {
      
      private static final long serialVersionUID = 1L;
	
	/**
	 * Create the frame.
	 */
	public InterfazPantallaCli(ClienteVO usuario) {
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
            gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
            getContentPane().setLayout(gridBagLayout);
            
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

            btnUsuario.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                        InterfazUsuarioCli interfazUsuarioCli = new InterfazUsuarioCli(usuario);
                        interfazUsuarioCli.setVisible(true);
                        dispose();
                  }
            });
            
            JButton btnDevolverProductos = new JButton("Devolver Productos");
            btnDevolverProductos.setFont(new Font("Dialog", Font.BOLD, 25));
            btnDevolverProductos.setBackground(new Color(0, 128, 128));
            btnDevolverProductos.setForeground(Color.BLACK);
            GridBagConstraints gbc_btnDevolverProductos = new GridBagConstraints();
            gbc_btnDevolverProductos.fill = GridBagConstraints.BOTH;
            gbc_btnDevolverProductos.insets = new Insets(0, 0, 5, 5);
            gbc_btnDevolverProductos.gridx = 1;
            gbc_btnDevolverProductos.gridy = 1;
            getContentPane().add(btnDevolverProductos, gbc_btnDevolverProductos);

            btnDevolverProductos.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                        InterfazDevolverProductos interfazDevolverProductos = new InterfazDevolverProductos(usuario);
                        interfazDevolverProductos.setVisible(true);
                        dispose();
                  }
            });
            
            JButton btnSacarProductos = new JButton("Sacar Productos");
            btnSacarProductos.setForeground(Color.BLACK);
            btnSacarProductos.setBackground(new Color(0, 128, 128));
            btnSacarProductos.setFont(new Font("Dialog", Font.BOLD, 25));
            GridBagConstraints gbc_btnSacarProductos = new GridBagConstraints();
            gbc_btnSacarProductos.fill = GridBagConstraints.BOTH;
            gbc_btnSacarProductos.insets = new Insets(0, 0, 5, 5);
            gbc_btnSacarProductos.gridx = 1;
            gbc_btnSacarProductos.gridy = 3;
            getContentPane().add(btnSacarProductos, gbc_btnSacarProductos);

            btnSacarProductos.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                        InterfazSacarProductos interfazSacarProductos = new InterfazSacarProductos(usuario);
                        interfazSacarProductos.setVisible(true);
                        dispose();
                  }
            });
            
      // Establecer el icono de la ventana
            ImageIcon icon = new ImageIcon(getClass().getResource("../imagenes/logo.png"));
            setIconImage(icon.getImage());
	}

}
