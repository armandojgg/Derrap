package derrap.MECANICO;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import derrap.conector;
import derrap.eleccionlogin;

public class crearStockMecanico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelOpcionesMenu_1, panelOpcionesMenu_2, panelOpcionesMenu, panelCrearPedido;
	private JButton btnHome, btnClientes, btnVehiculos, btnOrdenes, btnPrecio, btnStock,
			btnConsultarPedidos, btnCrearStock, btnConsultarStock, btnCrearPedido, btnCancelarCrearPedido;
	private JLabel lblMecanico, lblIcono, lblLogOut, lblImagenLogOut, lblPoweredDerrap;
	private JTextField textFieldIDPedido, textFieldPieza, textFieldIDProveedor, textFieldFecha,
			textFieldEstado, textFieldNPiezas, textFieldPrecioTotal;
	private JLabel lblNuevoPedido, lblIDPedido, lblPieza, lblIdProveedor,
			lblFecha, lblEstado, lblNPiezas, lblPrecioTotal;

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
					crearStockMecanico frame = new crearStockMecanico();
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
	public crearStockMecanico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Crear Stock - MECÁNICO"); // Título de la ventana en cuestión
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

		panelCrearPedido = new JPanel();
		panelCrearPedido.setBackground(new Color(192, 192, 192));
		panelCrearPedido.setBounds(264, 156, 589, 413);
		contentPane.add(panelCrearPedido);
		panelCrearPedido.setLayout(null);

		// B O T O N  H O M E
		btnHome = new JButton("Home");
		btnHome.setForeground(new Color(255, 255, 255));
		btnHome.setBackground(new Color(128, 0, 0));
		btnHome.setBounds(0, 0, 181, 39);
		panelOpcionesMenu.add(btnHome);

		// B O T O N  C L I E N T E S
		btnClientes = new JButton("Clientes");
		btnClientes.setBackground(new Color(128, 0, 0));
		btnClientes.setForeground(Color.WHITE);
		btnClientes.setBounds(0, 39, 181, 39);
		panelOpcionesMenu.add(btnClientes);

		// B O T O N  V E H I C U L O S
		btnVehiculos = new JButton("Vehículos");
		btnVehiculos.setForeground(Color.WHITE);
		btnVehiculos.setBackground(new Color(128, 0, 0));
		btnVehiculos.setBounds(0, 77, 181, 39);
		panelOpcionesMenu.add(btnVehiculos);

		// B O T O N  O R D E N E S
		btnOrdenes = new JButton("Ordenes");
		btnOrdenes.setForeground(Color.WHITE);
		btnOrdenes.setBackground(new Color(128, 0, 0));
		btnOrdenes.setBounds(0, 115, 181, 39);
		panelOpcionesMenu.add(btnOrdenes);

		// B O T O N  P R E C I O
		btnPrecio = new JButton("Precio");
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
		btnConsultarPedidos.setForeground(new Color(255, 255, 255));
		btnConsultarPedidos.setBackground(new Color(0, 128, 0));
		btnConsultarPedidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultarPedidos.setBounds(404, 231, 200, 62);
		contentPane.add(btnConsultarPedidos);

		btnConsultarPedidos.setVisible(false);

		// B O T O N  C R E A R  S T O C K
		btnCrearStock = new JButton("Crear");
		btnCrearStock.setForeground(new Color(255, 255, 255));
		btnCrearStock.setBackground(new Color(0, 128, 0));
		btnCrearStock.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCrearStock.setBounds(404, 304, 200, 62);
		contentPane.add(btnCrearStock);

		btnCrearStock.setVisible(false);

		// B O T O N  C O N S U L T A R  S T O C K
		btnConsultarStock = new JButton("Consultar STOCK");
		btnConsultarStock.setForeground(new Color(255, 255, 255));
		btnConsultarStock.setBackground(new Color(0, 0, 255));
		btnConsultarStock.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnConsultarStock.setBounds(370, 377, 264, 129);
		contentPane.add(btnConsultarStock);

		btnConsultarStock.setVisible(false);
		
		// B O T O N  C R E A R  P E D I D O
		btnCrearPedido = new JButton("Crear");
		btnCrearPedido.setForeground(new Color(255, 255, 255));
		btnCrearPedido.setBackground(new Color(0, 255, 0));
		btnCrearPedido.setBounds(116, 362, 169, 40);
		panelCrearPedido.add(btnCrearPedido);
		
		// B O T O N  C A N C E L A R
		btnCancelarCrearPedido = new JButton("Cancelar");
		btnCancelarCrearPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockMecanico frame = new stockMecanico();
				frame.setVisible(true);
				dispose();
			}
		});
		
		btnCancelarCrearPedido.setForeground(Color.WHITE);
		btnCancelarCrearPedido.setBackground(new Color(128, 0, 0));
		btnCancelarCrearPedido.setBounds(318, 362, 169, 40);
		panelCrearPedido.add(btnCancelarCrearPedido);
		
		// Cambiar el estado del botón actual
		btnStock.setEnabled(false); // Deshabilitar
		btnStock.setBackground(Color.WHITE); // Cambiar fondo a blanco
		
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

		lblNuevoPedido = new JLabel("Nuevo pedido");
		lblNuevoPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoPedido.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNuevoPedido.setBounds(204, 85, 172, 45);
		contentPane.add(lblNuevoPedido);

		lblIDPedido = new JLabel("ID Pedido");
		lblIDPedido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIDPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblIDPedido.setBounds(39, 35, 110, 40);
		panelCrearPedido.add(lblIDPedido);
		
		lblPieza = new JLabel("Pieza");
		lblPieza.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPieza.setHorizontalAlignment(SwingConstants.CENTER);
		lblPieza.setBounds(28, 113, 110, 40);
		panelCrearPedido.add(lblPieza);

		lblIdProveedor = new JLabel("ID Proveedor");
		lblIdProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdProveedor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdProveedor.setBounds(39, 191, 130, 40);
		panelCrearPedido.add(lblIdProveedor);

		lblFecha = new JLabel("Fecha");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFecha.setBounds(52, 268, 66, 40);
		panelCrearPedido.add(lblFecha);

		lblEstado = new JLabel("Estado");
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstado.setBounds(295, 35, 66, 40);
		panelCrearPedido.add(lblEstado);

		lblNPiezas = new JLabel("Nº Piezas");
		lblNPiezas.setHorizontalAlignment(SwingConstants.CENTER);
		lblNPiezas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNPiezas.setBounds(295, 113, 79, 40);
		panelCrearPedido.add(lblNPiezas);

		lblPrecioTotal = new JLabel("Precio total");
		lblPrecioTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrecioTotal.setBounds(295, 191, 92, 40);
		panelCrearPedido.add(lblPrecioTotal);
		
		// J T E X T F I E L D S

		textFieldIDPedido = new JTextField();
		textFieldIDPedido.setBounds(63, 73, 169, 29);
		panelCrearPedido.add(textFieldIDPedido);
		textFieldIDPedido.setColumns(10);

		textFieldPieza = new JTextField();
		textFieldPieza.setBounds(63, 151, 169, 29);
		panelCrearPedido.add(textFieldPieza);
		textFieldPieza.setColumns(10);

		textFieldIDProveedor = new JTextField();
		textFieldIDProveedor.setColumns(10);
		textFieldIDProveedor.setBounds(63, 228, 169, 29);
		panelCrearPedido.add(textFieldIDProveedor);

		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(63, 302, 169, 29);
		panelCrearPedido.add(textFieldFecha);

		textFieldEstado = new JTextField();
		textFieldEstado.setColumns(10);
		textFieldEstado.setBounds(305, 73, 169, 29);
		panelCrearPedido.add(textFieldEstado);

		textFieldNPiezas = new JTextField();
		textFieldNPiezas.setColumns(10);
		textFieldNPiezas.setBounds(305, 151, 169, 29);
		panelCrearPedido.add(textFieldNPiezas);

		textFieldPrecioTotal = new JTextField();
		textFieldPrecioTotal.setColumns(10);
		textFieldPrecioTotal.setBounds(305, 228, 169, 29);
		panelCrearPedido.add(textFieldPrecioTotal);
		
		setLocationRelativeTo(null); // Se centra la ventana en la pantalla

	}

}
