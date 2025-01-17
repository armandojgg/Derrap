package derrap.MECANICO;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import derrap.conector;
import derrap.eleccionlogin;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class stockMecanico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelOpcionesMenu_1, panelOpcionesMenu_2, panelOpcionesMenu;
	private JButton btnHome, btnClientes, btnVehiculos, btnOrdenes, btnPrecio, btnStock,
			btnConsultarPedidos, btnCrearStock, btnConsultarStock;
	private JLabel lblMecanico, lblIcono, lblLogOut, lblImagenLogOut, lblPoweredDerrap;
	private JLabel lblSegundoIcono, lblPedidos;

	conector conexion = new conector();
	Connection cn = null;
	Statement stm = null;
	ResultSet resultado = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stockMecanico frame = new stockMecanico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public stockMecanico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Stock - MECÁNICO"); // Título de la ventana en cuestión
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconoderrap.jpg")).getImage());
		setBounds(100, 100, 946, 712);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// J P A N E L
		panelOpcionesMenu = new JPanel();
		panelOpcionesMenu.setBounds(0, 74, 181, 231);
		contentPane.add(panelOpcionesMenu);
		panelOpcionesMenu.setBackground(new Color(128, 0, 0)); // Color del fondo del botón azul oscuro.
		panelOpcionesMenu.setLayout(null);

		// B O T O N  H O M E
		btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menumecanico frame = new menumecanico();
				frame.setVisible(true);
				dispose();
			}
		});
		btnHome.setForeground(new Color(255, 255, 255));
		btnHome.setBackground(new Color(128, 0, 0));
		btnHome.setBounds(0, 0, 181, 39);
		panelOpcionesMenu.add(btnHome);

		// B O T O N  C L I E N T E S
		btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientesMecanico frame = new clientesMecanico();
				frame.setVisible(true);
				dispose();
			}
		});
		btnClientes.setBackground(new Color(128, 0, 0));
		btnClientes.setForeground(Color.WHITE);
		btnClientes.setBounds(0, 39, 181, 39);
		panelOpcionesMenu.add(btnClientes);

		// B O T O N  V E H I C U L O S
		btnVehiculos = new JButton("Vehículos");
		btnVehiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vehiculosMecanico frame = new vehiculosMecanico();
				frame.setVisible(true);
				dispose();
			}
		});
		btnVehiculos.setForeground(Color.WHITE);
		btnVehiculos.setBackground(new Color(128, 0, 0));
		btnVehiculos.setBounds(0, 77, 181, 39);
		panelOpcionesMenu.add(btnVehiculos);
		
		// B O T O N  O R D E N E S
		btnOrdenes = new JButton("Ordenes");
		btnOrdenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ordenesMecanico frame = new ordenesMecanico();
				frame.setVisible(true);
				dispose();
			}
		});
		btnOrdenes.setForeground(Color.WHITE);
		btnOrdenes.setBackground(new Color(128, 0, 0));
		btnOrdenes.setBounds(0, 115, 181, 39);
		panelOpcionesMenu.add(btnOrdenes);

		// B O T O N  P R E C I O
		btnPrecio = new JButton("Precio");
		btnPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				precioMecanico frame = new precioMecanico();
				frame.setVisible(true);
				dispose();
			}
		});
		btnPrecio.setForeground(Color.WHITE);
		btnPrecio.setBackground(new Color(128, 0, 0));
		btnPrecio.setBounds(0, 153, 181, 39);
		panelOpcionesMenu.add(btnPrecio);

		// B O T O N  S T O C K
		btnStock = new JButton("Stock");
		btnStock.setForeground(Color.WHITE);
		btnStock.setBackground(new Color(128, 0, 0));
		btnStock.setBounds(0, 192, 181, 39);
		panelOpcionesMenu.add(btnStock);

		// B O T O N  C O N S U L T A R  P E D I D O S
		btnConsultarPedidos = new JButton("Consultar pedidos");
		btnConsultarPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarStockMecanico frame = new consultarStockMecanico();
				frame.setVisible(true);
				dispose();
			}
		});
		btnConsultarPedidos.setForeground(new Color(255, 255, 255));
		btnConsultarPedidos.setBackground(new Color(0, 128, 0));
		btnConsultarPedidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultarPedidos.setBounds(404, 231, 200, 62);
		contentPane.add(btnConsultarPedidos);

		// B O T O N  C R E A R  S T O C K
		btnCrearStock = new JButton("Crear");
		btnCrearStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearStockMecanico frame = new crearStockMecanico();
				frame.setVisible(true);
				dispose();
			}
		});
		btnCrearStock.setForeground(new Color(255, 255, 255));
		btnCrearStock.setBackground(new Color(0, 128, 0));
		btnCrearStock.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCrearStock.setBounds(404, 304, 200, 62);
		contentPane.add(btnCrearStock);

		// B O T O N  C O N S U L T A R  S T O C K
		btnConsultarStock = new JButton("Consultar STOCK");
		btnConsultarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarPedidosMecanico frame = new consultarPedidosMecanico();
				frame.setVisible(true);
				dispose();
			}
		});
		btnConsultarStock.setForeground(new Color(255, 255, 255));
		btnConsultarStock.setBackground(new Color(0, 0, 255));
		btnConsultarStock.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnConsultarStock.setBounds(370, 377, 264, 129);
		contentPane.add(btnConsultarStock);
		
		// P A N E L E S
		
		panelOpcionesMenu_1 = new JPanel();
		panelOpcionesMenu_1.setLayout(null);
		panelOpcionesMenu_1.setBackground(new Color(255, 0, 0));
		panelOpcionesMenu_1.setBounds(0, 0, 930, 74);
		contentPane.add(panelOpcionesMenu_1);

		panelOpcionesMenu_2 = new JPanel();
		panelOpcionesMenu_2.setLayout(null);
		panelOpcionesMenu_2.setBackground(Color.RED);
		panelOpcionesMenu_2.setBounds(0, 304, 181, 369);
		contentPane.add(panelOpcionesMenu_2);

		// J L A B E L S
		lblMecanico = new JLabel("Mecánico");
		lblMecanico.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMecanico.setHorizontalAlignment(SwingConstants.CENTER);
		lblMecanico.setBounds(22, 25, 129, 26);
		panelOpcionesMenu_1.add(lblMecanico);

		ImageIcon imagen2 = new ImageIcon(this.getClass().getResource("/imagenes/iconoderrap.jpg")); // Revisa la ruta
		Image imagenoriginal2 = imagen2.getImage();
		Image imagenreescalada2 = imagenoriginal2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado2 = new ImageIcon(imagenreescalada2);
		lblIcono = new JLabel(iconoRedimensionado2);
		lblIcono.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcono.setBounds(665, 0, 102, 74);
		panelOpcionesMenu_1.add(lblIcono);

		lblLogOut = new JLabel("Log Out");
		lblLogOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogOut.setForeground(new Color(255, 255, 255));
		lblLogOut.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLogOut.setBounds(777, 28, 68, 25);
		panelOpcionesMenu_1.add(lblLogOut);

		ImageIcon imagen3 = new ImageIcon(this.getClass().getResource("/imagenes/logout_imagen.png")); // Revisa la ruta
		Image imagenoriginal3 = imagen3.getImage();
		Image imagenreescalada3 = imagenoriginal3.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado3 = new ImageIcon(imagenreescalada3);
		lblImagenLogOut = new JLabel(iconoRedimensionado3);
		lblImagenLogOut.setBounds(855, 15, 50, 48);
		panelOpcionesMenu_1.add(lblImagenLogOut);

		lblImagenLogOut.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				eleccionlogin eleccionlogin = new eleccionlogin();
				eleccionlogin.setVisible(true);
				dispose(); // Cerrar el JFrame actual si es necesario
			}
		});

		lblPoweredDerrap = new JLabel("Powered by DERRAP");
		lblPoweredDerrap.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPoweredDerrap.setForeground(new Color(255, 255, 255));
		lblPoweredDerrap.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoweredDerrap.setBounds(22, 319, 149, 39);
		panelOpcionesMenu_2.add(lblPoweredDerrap);

		lblPedidos = new JLabel("Pedidos");
		lblPedidos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPedidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPedidos.setBounds(437, 121, 120, 30);
		contentPane.add(lblPedidos);

		ImageIcon imagen4 = new ImageIcon(this.getClass().getResource("/imagenes/iconoderrap.jpg")); // Revisa la ruta
		Image imagenoriginal4 = imagen4.getImage();
		Image imagenreescalada4 = imagenoriginal4.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado4 = new ImageIcon(imagenreescalada4);
		lblSegundoIcono = new JLabel(iconoRedimensionado4);
		lblSegundoIcono.setHorizontalAlignment(SwingConstants.CENTER);
		lblSegundoIcono.setBounds(200, 85, 145, 100);
		contentPane.add(lblSegundoIcono);

		// F O C U S A B L E

		lblSegundoIcono.setFocusable(true);

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent e) {
				lblSegundoIcono.requestFocus();
			}
		});
		
		// Cambiar el estado del botón actual
		btnStock.setEnabled(false); // Deshabilitar
		btnStock.setBackground(Color.WHITE); // Cambiar fondo a blanco
		setLocationRelativeTo(null); // Se centra la ventana en la pantalla

	}

}
