package derrap.ADMIN;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import derrap.conector;
import derrap.eleccionlogin;

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

public class ordenesAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelOpcionesMenu_1, panelOpcionesMenu_2, panelOpcionesMenu;
	private JButton btnHome, btnClientes, btnVehiculos, btnOrdenes, btnPrecio, btnStock, btnEmpleados,
			btnCrearOrden, btnEliminar;
	private JLabel lblAdmin, lblIconoCasa, lblIcono, lblLogOut, lblImagenLogOut, lblPoweredDerrap, lblOrdenes,
			lblEliminar, lblIdOrden;
	private JTextField textFieldBuscador, textFieldEliminarOrden;
	private JLabel lblSegundoIcono;
	private JTable tabla2;
	private JScrollPane scrollPane2;
	
	conector conexion = new conector();
	Connection cn = null;
	Statement stm = null;
	ResultSet resultado = null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ordenesAdmin frame = new ordenesAdmin();
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
	public ordenesAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Órdenes - ADMIN"); // Título de la ventana en cuestión
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
		
		// B O T O N E S
		btnCrearOrden = new JButton("Crear orden");
		btnCrearOrden.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCrearOrden.setForeground(new Color(255, 255, 255));
		btnCrearOrden.setBackground(new Color(0, 255, 0));
		btnCrearOrden.setBounds(777, 598, 120, 45);
		contentPane.add(btnCrearOrden);

		btnCrearOrden.setVisible(true);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEliminar.setBackground(new Color(255, 0, 0));
		btnEliminar.setBounds(482, 598, 120, 45);
		contentPane.add(btnEliminar);

		btnEliminar.setVisible(true);

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

		lblOrdenes = new JLabel("Órdenes");
		lblOrdenes.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOrdenes.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdenes.setBounds(449, 78, 107, 45);
		contentPane.add(lblOrdenes);

		lblOrdenes.setVisible(true);

		lblEliminar = new JLabel("Eliminar");
		lblEliminar.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setBounds(279, 537, 85, 25);
		contentPane.add(lblEliminar);

		lblEliminar.setVisible(true);

		lblIdOrden = new JLabel("ID Orden:");
		lblIdOrden.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdOrden.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblIdOrden.setBounds(191, 605, 98, 25);
		contentPane.add(lblIdOrden);

		lblIdOrden.setVisible(true);

		// J T E X T F I E L D
		textFieldBuscador = new JTextField();
		textFieldBuscador.setBounds(696, 85, 213, 36);
		contentPane.add(textFieldBuscador);
		textFieldBuscador.setColumns(10);
		
		textFieldBuscador.setVisible(true);

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

		if (textFieldBuscador.getText().isEmpty()) {
			textFieldBuscador.setText("🔍 Buscar");
			textFieldBuscador.setForeground(Color.GRAY);
		}

		textFieldEliminarOrden = new JTextField();
		textFieldEliminarOrden.setBounds(299, 598, 173, 45);
		contentPane.add(textFieldEliminarOrden);
		textFieldEliminarOrden.setColumns(10);

		textFieldEliminarOrden.setVisible(true);

		setLocationRelativeTo(null);

		// Cambiar el estado del botón actual
		btnOrdenes.setEnabled(false); // Deshabilitar
		btnOrdenes.setBackground(Color.WHITE); // Cambiar fondo a blanco
		
		// I M A G E N E S
		
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/imagenes/home_imagen.png")); // Revisa la ruta
		Image imagenoriginal = imagen.getImage();
		Image imagenreescalada = imagenoriginal.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado = new ImageIcon(imagenreescalada);
		lblIconoCasa = new JLabel(iconoRedimensionado);
		lblIconoCasa.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoCasa.setBounds(119, 15, 62, 48);
		panelOpcionesMenu_1.add(lblIconoCasa);
		lblIconoCasa.setVisible(false);

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
		lblSegundoIcono.setVisible(true);

		// F O C U S A B L E

		lblSegundoIcono.setFocusable(true);
		mostrartablaordenes();

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent e) {
				lblSegundoIcono.requestFocus();
			}
		});
	}
	
	// M E T O D O S
	
	private void mostrartablaordenes() {
		String[] nombreColumnas = { "ID Cliente", "Nombre Cliente", "Fecha de Registro", "Matrícula Asociada",
				"Estado de la Orden" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(nombreColumnas);
		tabla2 = new JTable(model);
		scrollPane2 = new JScrollPane(tabla2);
		scrollPane2.setBounds(191, 196, 804, 332);
		contentPane.add(scrollPane2);
		// Conexión a la base de datos y ejecución de la consulta
		try {
			stm = cn.createStatement();
			String selectOrdenes = "SELECT c.dni AS 'ID Cliente', c.nombre AS 'Nombre Cliente', c.fecha_registro AS 'Fecha de Registro', "
					+ "v.matricula AS 'Matrícula Asociada', o.estado_orden AS 'Estado de la Orden'"
					+ " FROM derrapdb.cliente c" + " JOIN derrapdb.vehiculo v ON c.dni = v.cliente_dni"
					+ " JOIN derrapdb.orden_reparacion o ON v.matricula = o.vehiculo_matricula;";
			resultado = stm.executeQuery(selectOrdenes);
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
