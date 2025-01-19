package derrap.MECANICO;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import derrap.conector;
import derrap.eleccionlogin;

public class ordenesMecanico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelOpcionesMenu_1, panelOpcionesMenu_2, panelOpcionesMenu;
	private JButton btnHome, btnClientes, btnVehiculos, btnOrdenes, btnPrecio, btnStock, btnAtras, btnEliminarOrden,
			btnModificarOrden;
	private JLabel lblMecanico, lblIconoCasa, lblIcono, lblLogOut, lblImagenLogOut, lblPoweredDerrap, lblOrdenes,
			lblEliminar, lblIDOrden;
	private JTextField textFieldBuscar, textFieldIDOrden;
	private JLabel lblSegundoIcono;

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
					ordenesMecanico frame = new ordenesMecanico();
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
	public ordenesMecanico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Órdenes - MECÁNICO"); // Título de la ventana en cuestión
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconoderrap.jpg")).getImage());
		setBounds(100, 100, 946, 712);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		conectarBaseDatos();

		// J P A N E L
		panelOpcionesMenu = new JPanel();
		panelOpcionesMenu.setBounds(0, 74, 181, 231);
		contentPane.add(panelOpcionesMenu);
		panelOpcionesMenu.setBackground(new Color(128, 0, 0)); // Color del fondo del botón azul oscuro.
		panelOpcionesMenu.setLayout(null);

		// B O T O N H O M E
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

		// B O T O N C L I E N T E S
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

		// B O T O N V E H I C U L O S
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

		// B O T O N O R D E N E S
		btnOrdenes = new JButton("Ordenes");
		btnOrdenes.setForeground(Color.WHITE);
		btnOrdenes.setBackground(new Color(128, 0, 0));
		btnOrdenes.setBounds(0, 115, 181, 39);
		panelOpcionesMenu.add(btnOrdenes);

		// B O T O N P R E C I O
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

		// B O T O N S T O C K
		btnStock = new JButton("Stock");
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockMecanico frame = new stockMecanico();
				frame.setVisible(true);
				dispose();
			}
		});
		btnStock.setForeground(Color.WHITE);
		btnStock.setBackground(new Color(128, 0, 0));
		btnStock.setBounds(0, 192, 181, 39);
		panelOpcionesMenu.add(btnStock);

		// B O T O N A T R A S
		btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menumecanico frame = new menumecanico();
				frame.setVisible(true);
				dispose();
			}
		});
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAtras.setBackground(new Color(128, 0, 0));
		btnAtras.setBounds(784, 603, 120, 45);
		contentPane.add(btnAtras);

		// B O T O N E L I M I N A R O R D E N
		btnEliminarOrden = new JButton("Eliminar");
		btnEliminarOrden.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEliminarOrden.setForeground(new Color(255, 255, 255));
		btnEliminarOrden.setBackground(new Color(255, 0, 0));
		btnEliminarOrden.setBounds(437, 601, 111, 45);
		contentPane.add(btnEliminarOrden);

		// B O T O N M O D I F I C A R O R D E N
		btnModificarOrden = new JButton("Modificar orden");
		btnModificarOrden.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModificarOrden.setBackground(new Color(128, 255, 0));
		btnModificarOrden.setBounds(588, 603, 145, 45);
		contentPane.add(btnModificarOrden);

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

		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/imagenes/home_imagen.png")); // Revisa la ruta
		Image imagenoriginal = imagen.getImage();
		Image imagenreescalada = imagenoriginal.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado = new ImageIcon(imagenreescalada);
		lblIconoCasa = new JLabel(iconoRedimensionado);
		lblIconoCasa.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoCasa.setBounds(161, 15, 62, 48);
		panelOpcionesMenu_1.add(lblIconoCasa);

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

		lblOrdenes = new JLabel("Órdenes");
		lblOrdenes.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOrdenes.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdenes.setBounds(506, 121, 98, 45);
		contentPane.add(lblOrdenes);

		lblEliminar = new JLabel("Eliminar");
		lblEliminar.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setBounds(231, 540, 145, 45);
		contentPane.add(lblEliminar);

		lblIDOrden = new JLabel("ID Orden:");
		lblIDOrden.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblIDOrden.setHorizontalAlignment(SwingConstants.CENTER);
		lblIDOrden.setBounds(189, 596, 120, 52);
		contentPane.add(lblIDOrden);

		ImageIcon imagen4 = new ImageIcon(this.getClass().getResource("/imagenes/iconoderrap.jpg")); // Revisa la ruta
		Image imagenoriginal4 = imagen4.getImage();
		Image imagenreescalada4 = imagenoriginal4.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado4 = new ImageIcon(imagenreescalada4);
		lblSegundoIcono = new JLabel(iconoRedimensionado4);
		lblSegundoIcono.setHorizontalAlignment(SwingConstants.CENTER);
		lblSegundoIcono.setBounds(200, 85, 145, 100);
		contentPane.add(lblSegundoIcono);

		// J T E X T F I E L D S

		textFieldBuscar = new JTextField();
		textFieldBuscar.setBounds(672, 128, 213, 36);
		contentPane.add(textFieldBuscar);
		textFieldBuscar.setColumns(10);

		textFieldBuscar.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Si tiene un mensaje, cuando se hace clic se elimina.
				if (textFieldBuscar.getText().equals("🔍 Buscar")) {
					textFieldBuscar.setText("");
					textFieldBuscar.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Se restaura el mensaje, si no hay nada escrito en el despues de hacer clic.
				if (textFieldBuscar.getText().isEmpty()) {
					textFieldBuscar.setText("🔍 Buscar");
					textFieldBuscar.setForeground(Color.GRAY);
				}
			}
		});

		if (textFieldBuscar.getText().isEmpty()) {
			textFieldBuscar.setText("🔍 Buscar");
			textFieldBuscar.setForeground(Color.GRAY);
		}

		textFieldIDOrden = new JTextField();
		textFieldIDOrden.setBounds(307, 602, 120, 45);
		contentPane.add(textFieldIDOrden);
		textFieldIDOrden.setColumns(10);

		// F O C U S A B L E

		lblSegundoIcono.setFocusable(true);

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent e) {
				lblSegundoIcono.requestFocus();
			}
		});

		mostrartablaordenes();

		// Cambiar el estado del botón actual
		btnOrdenes.setEnabled(false); // Deshabilitar
		btnOrdenes.setBackground(Color.WHITE); // Cambiar fondo a blanco
		setLocationRelativeTo(null); // Se centra la ventana en la pantalla

	}

	private void mostrartablaordenes() {
		String[] nombreColumnas = { "ID Cliente", "Nombre Cliente", "Fecha de Registro", "Matrícula Asociada",
				"Estado de la Orden" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(nombreColumnas);
		JTable tabla2 = new JTable(model);
		JScrollPane scrollPane2 = new JScrollPane(tabla2);
		scrollPane2.setBounds(191, 196, 729, 332);
		contentPane.add(scrollPane2);

		try {
			stm = cn.createStatement();
			String selectOrdenes = "SELECT c.dni AS 'ID Cliente', c.nombre AS 'Nombre Cliente', c.fecha_registro AS 'Fecha de Registro', "
					+ "v.matricula AS 'Matrícula Asociada', o.estado_repa AS 'Estado de la Orden'"
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
