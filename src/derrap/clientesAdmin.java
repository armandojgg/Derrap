package derrap;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;

public class clientesAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelOpcionesMenu_1, panelOpcionesMenu_2, panelOpcionesMenu;
	private JButton btnHome, btnClientes, btnVehiculos, btnOrdenes, btnPrecio, btnStock, btnEmpleados, btnNuevoCliente,
			btnAtras, btnAgregarCliente, btnCancelar;
	private JLabel lblAdmin, lblIconoCasa, lblIcono, lblLogOut, lblImagenLogOut, lblPoweredDerrap, lblClientes,
			lblAgregarClientes;
	private JTextField textFieldBuscador, textFieldNombreCliente, textFieldPrimerApellidoCliente,
			textFieldSegundoApellido, textFieldDNI, textFieldTelefono, textFieldFechaAlta, textFieldEmail,
			textFieldDireccion;
	private JLabel lblSegundoIcono, lblNombre, lblPrimerApellido, lblSegundoApellido, lblDNI, lblTelefono,
			lblFechaRegistro, lblEmail, lblDireccion;
	private JTable tabla;
	private JScrollPane scrollPane;
	conector conexion = new conector();
	Connection cn = null;
	Statement stm = null;
	ResultSet resultado = null;

	/**
	 * Create the frame.
	 */
	public clientesAdmin() {
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

		// J P A N E L
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

		// B O T O N  H O M E
		btnHome = new JButton("Home");
		btnHome.setForeground(new Color(255, 255, 255));
		btnHome.setBackground(new Color(128, 0, 0));
		btnHome.setBounds(0, 0, 181, 39);
		panelOpcionesMenu.add(btnHome);

		btnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				homeAdmin frame = new homeAdmin();
				frame.setVisible(true);
				dispose();
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

		// B O T O N  N U E V O  C L I E N T E
		btnNuevoCliente = new JButton("Nuevo cliente");
		btnNuevoCliente.setForeground(new Color(255, 255, 255));
		btnNuevoCliente.setBackground(new Color(0, 255, 0));
		btnNuevoCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNuevoCliente.setBounds(506, 605, 120, 45);
		contentPane.add(btnNuevoCliente);

		btnNuevoCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				scrollPane.setVisible(false);
			}
		});

		btnNuevoCliente.setVisible(false);

		// B O T O N  A T R A S
		btnAtras = new JButton("Atrás");
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAtras.setBackground(new Color(128, 0, 0));
		btnAtras.setBounds(647, 605, 120, 45);
		contentPane.add(btnAtras);

		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				scrollPane.setVisible(false);
				homeAdmin frame = new homeAdmin();
				frame.setVisible(true);
				dispose();
			}
		});

		btnAtras.setVisible(false);

		// B O T O N E S  S E C U N D A R I O S
		btnAgregarCliente = new JButton("Agregar");
		btnAgregarCliente.setForeground(new Color(255, 255, 255));
		btnAgregarCliente.setBackground(new Color(0, 255, 0));
		btnAgregarCliente.setBounds(331, 588, 152, 50);
		contentPane.add(btnAgregarCliente);

		btnAgregarCliente.setVisible(false);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(new Color(128, 0, 0));
		btnCancelar.setBounds(536, 588, 152, 50);
		contentPane.add(btnCancelar);

		btnCancelar.setVisible(false);

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

		lblPoweredDerrap = new JLabel("Powered by DERRAP");
		lblPoweredDerrap.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPoweredDerrap.setForeground(new Color(255, 255, 255));
		lblPoweredDerrap.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoweredDerrap.setBounds(22, 291, 149, 39);
		panelOpcionesMenu_2.add(lblPoweredDerrap);

		lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setBounds(506, 121, 98, 45);
		contentPane.add(lblClientes);

		lblClientes.setVisible(false);

		lblAgregarClientes = new JLabel("Agregar clientes");
		lblAgregarClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarClientes.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAgregarClientes.setBounds(419, 95, 202, 26);
		contentPane.add(lblAgregarClientes);

		lblAgregarClientes.setVisible(false);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(191, 170, 100, 43);
		contentPane.add(lblNombre);

		lblNombre.setVisible(false);

		lblPrimerApellido = new JLabel("Primer apellido:");
		lblPrimerApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrimerApellido.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrimerApellido.setBounds(191, 242, 120, 43);
		contentPane.add(lblPrimerApellido);

		lblPrimerApellido.setVisible(false);

		lblSegundoApellido = new JLabel("Segundo apellido:");
		lblSegundoApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblSegundoApellido.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSegundoApellido.setBounds(188, 302, 133, 43);
		contentPane.add(lblSegundoApellido);

		lblSegundoApellido.setVisible(false);

		lblDNI = new JLabel("DNI:");
		lblDNI.setHorizontalAlignment(SwingConstants.CENTER);
		lblDNI.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDNI.setBounds(471, 170, 100, 43);
		contentPane.add(lblDNI);

		lblDNI.setVisible(false);

		lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTelefono.setBounds(471, 241, 100, 43);
		contentPane.add(lblTelefono);

		lblTelefono.setVisible(false);

		lblFechaRegistro = new JLabel("Fecha alta:");
		lblFechaRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaRegistro.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFechaRegistro.setBounds(471, 301, 100, 43);
		contentPane.add(lblFechaRegistro);

		lblFechaRegistro.setVisible(false);

		lblEmail = new JLabel("EMAIL:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEmail.setBounds(720, 170, 100, 43);
		contentPane.add(lblEmail);

		lblEmail.setVisible(false);

		lblDireccion = new JLabel("Dirección:");
		lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDireccion.setBounds(720, 241, 100, 43);
		contentPane.add(lblDireccion);

		lblDireccion.setVisible(false);

		// J T E X T F I E L D S
		textFieldBuscador = new JTextField();
		textFieldBuscador.setBounds(672, 128, 213, 36);
		contentPane.add(textFieldBuscador);
		textFieldBuscador.setColumns(10);

//		// F O C U S  L I S T E N E R  B U S C A D O R
		textFieldBuscador.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Si tiene un mensaje, cuando se hace clic se elimina.
				if (textFieldBuscador.getText().equals("🔍 Buscar")) {
					textFieldBuscador.setText("");
					textFieldBuscador.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Se restaura el mensaje, si no hay nada escrito en el despues de hacer clic.
				if (textFieldBuscador.getText().isEmpty()) {
					textFieldBuscador.setText("🔍 Buscar");
					textFieldBuscador.setForeground(Color.GRAY);
				}
			}
		});

		textFieldBuscador.setVisible(false);

		textFieldNombreCliente = new JTextField();
		textFieldNombreCliente.setBounds(325, 174, 136, 40);
		contentPane.add(textFieldNombreCliente);
		textFieldNombreCliente.setColumns(10);

		textFieldNombreCliente.setVisible(false);

		textFieldPrimerApellidoCliente = new JTextField();
		textFieldPrimerApellidoCliente.setColumns(10);
		textFieldPrimerApellidoCliente.setBounds(325, 245, 136, 40);
		contentPane.add(textFieldPrimerApellidoCliente);

		textFieldPrimerApellidoCliente.setVisible(false);

		textFieldSegundoApellido = new JTextField();
		textFieldSegundoApellido.setColumns(10);
		textFieldSegundoApellido.setBounds(325, 305, 136, 40);
		contentPane.add(textFieldSegundoApellido);

		textFieldSegundoApellido.setVisible(false);

		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);
		textFieldDNI.setBounds(574, 174, 136, 40);
		contentPane.add(textFieldDNI);

		textFieldDNI.setVisible(false);

		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(574, 245, 136, 40);
		contentPane.add(textFieldTelefono);

		textFieldTelefono.setVisible(false);
		textFieldTelefono.setToolTipText("Solo se debe ingresar valores númericos");

		textFieldFechaAlta = new JTextField("YYYY/MM/DD");
		textFieldFechaAlta.setForeground(Color.GRAY);
		textFieldFechaAlta.setColumns(10);
		textFieldFechaAlta.setBounds(574, 304, 136, 40);
		contentPane.add(textFieldFechaAlta);

		textFieldFechaAlta.setVisible(false);

		// F O C U S  L I S T E N E R  F E C H A  A L T A
		textFieldFechaAlta.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Si tiene un mensaje, cuando se hace clic se elimina.
				if (textFieldFechaAlta.getText().equals("YYYY/MM/DD")) {
					textFieldFechaAlta.setText("");
					textFieldFechaAlta.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Se restaura el mensaje, si no hay nada escrito en el despues de hacer clic.
				if (textFieldFechaAlta.getText().isEmpty()) {
					textFieldFechaAlta.setText("YYYY/MM/DD");
					textFieldFechaAlta.setForeground(Color.GRAY);
				}
			}
		});

		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(822, 242, 136, 40);
		contentPane.add(textFieldDireccion);

		textFieldDireccion.setVisible(false);

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(822, 170, 136, 40);
		contentPane.add(textFieldEmail);

		textFieldEmail.setVisible(false);

		// Cambiar el estado del botón actual
		btnClientes.setEnabled(false); // Deshabilitar
		btnClientes.setBackground(Color.WHITE); // Cambiar fondo a blanco
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
		Image imagenreescalada4 = imagenoriginal4.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado4 = new ImageIcon(imagenreescalada4);
		lblSegundoIcono = new JLabel(iconoRedimensionado4);
		lblSegundoIcono.setHorizontalAlignment(SwingConstants.CENTER);
		lblSegundoIcono.setBounds(200, 85, 145, 100);
		contentPane.add(lblSegundoIcono);
		lblSegundoIcono.setVisible(false);

		// E L E M E N T O S Y S U V I S I B I L I D A D

		// B O T O N E S
		// -----------------------------------------------------
		btnNuevoCliente.setVisible(true);
		btnAgregarCliente.setVisible(false);
		btnCancelar.setVisible(false);
		btnAtras.setVisible(true);
		lblSegundoIcono.setVisible(true);
		lblClientes.setVisible(true);
		lblAgregarClientes.setVisible(false);
		lblNombre.setVisible(false);
		lblPrimerApellido.setVisible(false);
		lblSegundoApellido.setVisible(false);
		lblDNI.setVisible(false);
		lblTelefono.setVisible(false);
		lblFechaRegistro.setVisible(false);
		lblEmail.setVisible(false);
		lblDireccion.setVisible(false);
		
		// J T E X T F I E L D
		// ---------------------------------------------------------------
		textFieldBuscador.setVisible(true);
		textFieldNombreCliente.setVisible(false);
		textFieldPrimerApellidoCliente.setVisible(false);
		textFieldSegundoApellido.setVisible(false);
		textFieldDNI.setVisible(false);
		textFieldTelefono.setVisible(false);
		textFieldFechaAlta.setVisible(false);
		textFieldEmail.setVisible(false);
		textFieldDireccion.setVisible(false);
		
		// T A B L A
		// ------------------------
		
		mostrartablaclientes();
		
		// ---------------------------------------------------------------

		// B O T O N  N U E V O  C L I E N T E - A C T I O N  L I S T E N E R
		btnNuevoCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// B O T O N E S
				// ----------------------------------------------
				btnNuevoCliente.setVisible(false);
				btnAtras.setVisible(false);
				btnAgregarCliente.setVisible(true);

				// B O T O N  A G R E G A R  C L I E N T E - A C T I O N  L I S T E N E R

				btnAgregarCliente.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String dni = textFieldDNI.getText();
						String nombre = textFieldNombreCliente.getText();
						String apellido1 = textFieldPrimerApellidoCliente.getText();
						String apellido2 = textFieldSegundoApellido.getText();
						String telefono = textFieldTelefono.getText();
						String direccion = textFieldDireccion.getText();
						String email = textFieldEmail.getText();
						String fecha_registro = textFieldFechaAlta.getText();
						conexion.insertarDatosClientes(dni, nombre, apellido1, apellido2, telefono, direccion, email,
								fecha_registro);
					}
				});

				// L A B E L S
				// ----------------------------------------
				lblSegundoIcono.setVisible(false);
				lblClientes.setVisible(false);
				lblAgregarClientes.setVisible(true);
				lblNombre.setVisible(true);
				lblPrimerApellido.setVisible(true);
				lblSegundoApellido.setVisible(true);
				lblDNI.setVisible(true);
				lblTelefono.setVisible(true);
				lblFechaRegistro.setVisible(true);
				lblEmail.setVisible(true);
				lblDireccion.setVisible(true);

				// T E X T F I E L D
				// -----------------------------------------------
				textFieldBuscador.setVisible(false);
				textFieldNombreCliente.setVisible(true);
				textFieldPrimerApellidoCliente.setVisible(true);
				textFieldSegundoApellido.setVisible(true);
				textFieldDNI.setVisible(true);
				textFieldTelefono.setVisible(true);
				textFieldFechaAlta.setVisible(true);
				textFieldEmail.setVisible(true);
				textFieldDireccion.setVisible(true);

				btnCancelar.setVisible(true);

				// B O T O N  C A N C E L A R -  A C T I O N  L I S T E N E R
				btnCancelar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						scrollPane.setVisible(true);
						// B O T O N E S
						// ------------------------------------------------
						btnNuevoCliente.setVisible(true);
						btnAgregarCliente.setVisible(false);
						btnCancelar.setVisible(false);
						btnAtras.setVisible(true);

						btnAtras.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								homeAdmin frame = new homeAdmin();
								frame.setVisible(true);
								dispose();
							}
						});

						// L A B E L S
						// -------------------------------------------

						lblSegundoIcono.setVisible(true);
						lblClientes.setVisible(true);
						lblAgregarClientes.setVisible(false);
						lblNombre.setVisible(false);
						lblPrimerApellido.setVisible(false);
						lblSegundoApellido.setVisible(false);
						lblDNI.setVisible(false);
						lblTelefono.setVisible(false);
						lblFechaRegistro.setVisible(false);
						lblEmail.setVisible(false);
						lblDireccion.setVisible(false);

						// T E X T F I E L D S
						// ------------------------------------
						textFieldBuscador.setVisible(true);
						textFieldNombreCliente.setVisible(false);
						textFieldPrimerApellidoCliente.setVisible(false);
						textFieldSegundoApellido.setVisible(false);
						textFieldDNI.setVisible(false);
						textFieldTelefono.setVisible(false);
						textFieldFechaAlta.setVisible(false);
						textFieldEmail.setVisible(false);
						textFieldDireccion.setVisible(false);
					}
				});
			}
		});

		// F O C U S A B L E

		lblSegundoIcono.setFocusable(true);

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent e) {
				lblSegundoIcono.requestFocus();
			}
		});
	}

	// M E T O D O S

	private void mostrartablaclientes() {
		// Columnas del JTable
		String[] nombreColumnas = { "ID Cliente", "Nombre Cliente", "Fecha de Registro", "Matrícula Asociada",
				"Estado de la Orden" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(nombreColumnas);
		tabla = new JTable(model);
		scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(218, 196, 742, 402);
		contentPane.add(scrollPane);
		// Conexión a la base de datos y ejecución de la consulta
		try {
			stm = cn.createStatement();
			String selectClientes = "SELECT c.dni AS 'ID Cliente', c.nombre AS 'Nombre Cliente', c.fecha_registro AS 'Fecha de Registro', "
					+ "v.matricula AS 'Matrícula Asociada', o.estado_orden AS 'Estado de la Orden'"
					+ " FROM derrapdb.cliente c" + " JOIN derrapdb.vehiculo v ON c.dni = v.cliente_dni"
					+ " JOIN derrapdb.orden_reparacion o ON v.matricula = o.vehiculo_matricula;";
			resultado = stm.executeQuery(selectClientes);
			while (resultado.next()) {
				String idCliente = resultado.getString("ID Cliente");
				String nombreCliente = resultado.getString("Nombre Cliente");
				String fechaRegistro = resultado.getString("Fecha de Registro");
				String matriculaAsociada = resultado.getString("Matrícula Asociada");
				String estadoOrden = resultado.getString("Estado de la Orden");
				model.addRow(new Object[] { idCliente, nombreCliente, fechaRegistro, matriculaAsociada, estadoOrden });
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultado != null)
					resultado.close();
				if (stm != null)
					stm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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
