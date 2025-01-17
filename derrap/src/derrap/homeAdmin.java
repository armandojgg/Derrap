package derrap;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import derrap.ADMIN.clientesAdmin;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class homeAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelOpcionesMenu_1, panelOpcionesMenu_2, paneNumClientes, panelOpcionesMenu;
	private JButton btnHome, btnClientes, btnVehiculos, btnOrdenes, btnPrecio, btnStock, btnEmpleados;
	private JLabel lblAdmin, lblIconoCasa, lblIcono, lblLogOut, lblImagenLogOut, lblBienvenida, lblPoweredDerrap,
			lblNumClientes, lblContadorClientes;
	private JLabel lblSegundoIcono, lblNombre;
	conector conexion = new conector();
	Connection cn = null;
	Statement stm = null;
	ResultSet resultado = null;

	/**
	 * Create the frame.
	 */
	public homeAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Menú - ADMIN"); // Título de la ventana en cuestión
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconoderrap.jpg")).getImage());
		setBounds(100, 100, 1020, 723);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		conectarBaseDatos();

		// J P A N E L S
		panelOpcionesMenu = new JPanel();
		panelOpcionesMenu.setBounds(0, 74, 181, 271);
		contentPane.add(panelOpcionesMenu);
		panelOpcionesMenu.setBackground(new Color(128, 0, 0)); // Color del fondo del botón azul oscuro.
		panelOpcionesMenu.setLayout(null);
		
		panelOpcionesMenu_1 = new JPanel();
		panelOpcionesMenu_1.setLayout(null);
		panelOpcionesMenu_1.setBackground(new Color(255, 0, 0));
		panelOpcionesMenu_1.setBounds(0, 0, 1004, 74);
		contentPane.add(panelOpcionesMenu_1);

		panelOpcionesMenu_2 = new JPanel();
		panelOpcionesMenu_2.setLayout(null);
		panelOpcionesMenu_2.setBackground(Color.RED);
		panelOpcionesMenu_2.setBounds(0, 343, 181, 341);
		contentPane.add(panelOpcionesMenu_2);

		paneNumClientes = new JPanel();
		paneNumClientes.setBackground(new Color(64, 0, 128));
		paneNumClientes.setBounds(204, 97, 200, 123);
		contentPane.add(paneNumClientes);
		paneNumClientes.setLayout(null);
		
		// B O T O N E S
		
		// B O T O N  H O M E
		btnHome = new JButton("Home");
		btnHome.setBackground(Color.WHITE); // Fondo blanco al iniciar
		btnHome.setBounds(0, 0, 181, 39);
		btnHome.setEnabled(false); // Desactivado al iniciar
		panelOpcionesMenu.add(btnHome);

		btnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Si se puede clickear, lo deshabilitamos.
				if (btnHome.isEnabled()) {
					paneNumClientes.setVisible(true);
					btnHome.setEnabled(false);
					btnHome.setBackground(Color.WHITE);
					
					// L A B E L S
					
					lblBienvenida.setVisible(true);
					lblSegundoIcono.setVisible(false);
					
				}
			}
		});

		// B O T O N  C L I E N T E S
		btnClientes = new JButton("Clientes");
		btnClientes.setBackground(new Color(128, 0, 0));
		btnClientes.setForeground(Color.WHITE);
		btnClientes.setBounds(0, 39, 181, 39);
		panelOpcionesMenu.add(btnClientes);

		btnClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientesAdmin frame = new clientesAdmin();
				frame.setVisible(true);
				dispose();
			}
		});

		// B O T O N  V E H I C U L O S
		btnVehiculos = new JButton("Vehículos");
		btnVehiculos.setForeground(Color.WHITE);
		btnVehiculos.setBackground(new Color(128, 0, 0));
		btnVehiculos.setBounds(0, 77, 181, 39);
		panelOpcionesMenu.add(btnVehiculos);

		btnVehiculos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vehiculosAdmin frame = new vehiculosAdmin();
				frame.setVisible(true);
				dispose();

			}
		});

		// B O T O N  O R D E N E S
		btnOrdenes = new JButton("Ordenes");
		btnOrdenes.setForeground(Color.WHITE);
		btnOrdenes.setBackground(new Color(128, 0, 0));
		btnOrdenes.setBounds(0, 115, 181, 39);
		panelOpcionesMenu.add(btnOrdenes);

		btnOrdenes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ordenesAdmin frame = new ordenesAdmin();
				frame.setVisible(true);
				dispose();
			}

		});

		// B O T O N  P R E C I O
		btnPrecio = new JButton("Precio");
		btnPrecio.setForeground(Color.WHITE);
		btnPrecio.setBackground(new Color(128, 0, 0));
		btnPrecio.setBounds(0, 153, 181, 39);
		panelOpcionesMenu.add(btnPrecio);

		btnPrecio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				precioAdmin frame = new precioAdmin();
				frame.setVisible(true);
				dispose();
			}
		});

		// B O T O N  S T O C K
		btnStock = new JButton("Stock");
		btnStock.setForeground(Color.WHITE);
		btnStock.setBackground(new Color(128, 0, 0));
		btnStock.setBounds(0, 192, 181, 39);
		panelOpcionesMenu.add(btnStock);

		btnStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				stockAdmin frame = new stockAdmin();
				frame.setVisible(true);
				dispose();
			}
		});

		// B O T O N  E M P L E A D O S
		btnEmpleados = new JButton("Empleados");
		btnEmpleados.setForeground(Color.WHITE);
		btnEmpleados.setBackground(new Color(128, 0, 0));
		btnEmpleados.setBounds(0, 231, 181, 39);
		panelOpcionesMenu.add(btnEmpleados);

		btnEmpleados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				empleadosAdmin frame = new empleadosAdmin();
				frame.setVisible(true);
				dispose();
			}
		});

		// J L A B E L S

		lblAdmin = new JLabel("ADMIN");
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setBounds(22, 25, 79, 26);
		panelOpcionesMenu_1.add(lblAdmin);

		lblLogOut = new JLabel("Log Out");
		lblLogOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogOut.setForeground(new Color(255, 255, 255));
		lblLogOut.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLogOut.setBounds(848, 28, 68, 25);
		panelOpcionesMenu_1.add(lblLogOut);

		lblBienvenida = new JLabel("¡Bienvenido de nuevo!");
		lblBienvenida.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setBounds(519, 74, 234, 36);
		contentPane.add(lblBienvenida);

		lblPoweredDerrap = new JLabel("Powered by DERRAP");
		lblPoweredDerrap.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPoweredDerrap.setForeground(new Color(255, 255, 255));
		lblPoweredDerrap.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoweredDerrap.setBounds(22, 291, 149, 39);
		panelOpcionesMenu_2.add(lblPoweredDerrap);

		lblNumClientes = new JLabel("Nº de clientes");
		lblNumClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumClientes.setForeground(new Color(255, 255, 255));
		lblNumClientes.setBounds(0, 0, 200, 36);
		paneNumClientes.add(lblNumClientes);

		lblContadorClientes = new JLabel("0");
		lblContadorClientes.setFont(new Font("Tahoma", Font.BOLD, 55));
		lblContadorClientes.setForeground(new Color(255, 255, 255));
		lblContadorClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblContadorClientes.setBounds(0, 11, 200, 125);
		paneNumClientes.add(lblContadorClientes);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(191, 170, 100, 43);
		contentPane.add(lblNombre);

		lblNombre.setVisible(false);

		setLocationRelativeTo(null); // Se centra la ventana en la pantalla
		
		// I M A G E N E S
		
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/imagenes/home_imagen.png")); // Revisa la ruta
		Image imagenoriginal = imagen.getImage();
		Image imagenreescalada = imagenoriginal.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado = new ImageIcon(imagenreescalada);
		lblIconoCasa = new JLabel(iconoRedimensionado);
		lblIconoCasa.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoCasa.setBounds(119, 15, 62, 48);
		panelOpcionesMenu_1.add(lblIconoCasa);

		ImageIcon imagen2 = new ImageIcon(this.getClass().getResource("/imagenes/iconoderrap.jpg")); // Revisa la ruta
		Image imagenoriginal2 = imagen2.getImage();
		Image imagenreescalada2 = imagenoriginal2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado2 = new ImageIcon(imagenreescalada2);
		lblIcono = new JLabel(iconoRedimensionado2);
		lblIcono.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcono.setBounds(750, 0, 102, 74);
		panelOpcionesMenu_1.add(lblIcono);
		
		ImageIcon imagen3 = new ImageIcon(this.getClass().getResource("/imagenes/logout_imagen.png")); // Revisa la ruta
		Image imagenoriginal3 = imagen3.getImage();
		Image imagenreescalada3 = imagenoriginal3.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado3 = new ImageIcon(imagenreescalada3);
		lblImagenLogOut = new JLabel(iconoRedimensionado3);
		lblImagenLogOut.setBounds(926, 15, 50, 48);
		panelOpcionesMenu_1.add(lblImagenLogOut);
		
		lblImagenLogOut.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				eleccionlogin eleccionlogin = new eleccionlogin();
				eleccionlogin.setVisible(true);
				dispose(); // Cerrar el JFrame actual si es necesario
			}
		});
		
		ImageIcon imagen4 = new ImageIcon(this.getClass().getResource("/imagenes/iconoderrap.jpg")); // Revisa la ruta
		Image imagenoriginal4 = imagen4.getImage();
		Image imagenreescalada4 = imagenoriginal4.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado4 = new ImageIcon(imagenreescalada4);
		lblSegundoIcono = new JLabel(iconoRedimensionado4);
		lblSegundoIcono.setHorizontalAlignment(SwingConstants.CENTER);
		lblSegundoIcono.setBounds(423, 121, 429, 289);
		contentPane.add(lblSegundoIcono);
		lblSegundoIcono.setVisible(true);

		// F O C U S A B L E

		lblSegundoIcono.setFocusable(true);

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent e) {
				lblSegundoIcono.requestFocus();
			}
		});
	}

	private void conectarBaseDatos() {
		try {
			cn = conexion.conexion_correcta();
			stm = cn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
