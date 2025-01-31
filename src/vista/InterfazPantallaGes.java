package vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import modelo.modeloVO.UsuarioVO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

public class InterfazPantallaGes extends JFrame {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the frame.
	 */
	public InterfazPantallaGes(UsuarioVO usuarioVO) {
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
        
      JButton btnModificarCatalogo = new JButton("Modificar Catálogo");
      btnModificarCatalogo.setFont(new Font("Dialog", Font.BOLD, 25));
      btnModificarCatalogo.setBackground(new Color(0, 128, 128));
      btnModificarCatalogo.setForeground(Color.BLACK);
      GridBagConstraints gbc_btnModificarCatalogo = new GridBagConstraints();
      gbc_btnModificarCatalogo.fill = GridBagConstraints.BOTH;
      gbc_btnModificarCatalogo.insets = new Insets(0, 0, 5, 5);
      gbc_btnModificarCatalogo.gridx = 1;
      gbc_btnModificarCatalogo.gridy = 1;
      getContentPane().add(btnModificarCatalogo, gbc_btnModificarCatalogo);
      btnModificarCatalogo.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            InterfazModificarCatalogo interfazModificarCatalogo = new InterfazModificarCatalogo(usuarioVO);
            interfazModificarCatalogo.setVisible(true);
            dispose(); // Cierra la ventana actual
         }
      });
        
      JButton btnConsultarPedido = new JButton("Consultar Pedido");
      btnConsultarPedido.setForeground(Color.BLACK);
      btnConsultarPedido.setBackground(new Color(0, 128, 128));
      btnConsultarPedido.setFont(new Font("Dialog", Font.BOLD, 25));
      GridBagConstraints gbc_btnConsultarPedido = new GridBagConstraints();
      gbc_btnConsultarPedido.fill = GridBagConstraints.BOTH;
      gbc_btnConsultarPedido.insets = new Insets(0, 0, 5, 5);
      gbc_btnConsultarPedido.gridx = 1;
      gbc_btnConsultarPedido.gridy = 3;
      getContentPane().add(btnConsultarPedido, gbc_btnConsultarPedido);
      btnConsultarPedido.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            InterfazConsultarPedido interfazConsultarPedido = new InterfazConsultarPedido(usuarioVO);
            interfazConsultarPedido.setVisible(true);
            dispose(); // Cierra la ventana actual
         }
      });
        
     // Establecer el icono de la ventana
      ImageIcon icon = new ImageIcon(getClass().getResource("../imagenes/logo.png"));
      setIconImage(icon.getImage());

	}

}
