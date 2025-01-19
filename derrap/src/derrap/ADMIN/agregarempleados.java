package derrap.ADMIN;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import derrap.conector;
import derrap.eleccionlogin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

public class agregarempleados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelOpcionesMenu_1, panelOpcionesMenu_2, panelOpcionesMenu;
	private JButton btnHome, btnClientes, btnVehiculos, btnOrdenes, btnPrecio, btnStock, btnEmpleados,
			btnAgregarEmpleados, btnCancelar;
	private JLabel lblAdmin, lblIconoCasa, lblIcono, lblLogOut, lblImagenLogOut, lblPoweredDerrap, lblFechaContratacion,
			lblCorreo, lblDireccion, lblTlfono, lblSegundoApellido, lblPrimerApellido, lblNombre, lblDNI,
			lblAgregarUsuarios, lblContraseña;
	private JTextField textFieldDNI, textFieldNombre, textFieldPApellido, textFieldSegundoApellido, textFieldTlfono,
			textFieldContraseña, textFieldDireccion, textFieldCorreo, textFieldFecha;
	conector conexion = new conector();
	Connection cn = null;
	Statement stm = null;
	ResultSet resultado = null;
	private JButton btnEliminarEmpleados;
	private JLabel lblRol;
	private JTextField textFieldRol;
	private JButton btnActualizarEmpleados;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					agregarempleados frame = new agregarempleados();
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
	public agregarempleados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Agregar empleados - ADMIN"); // Título de la ventana en cuestión
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

		// B O T O N H O M E
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

		// B O T O N C L I E N T E S
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

		// B O T O N V E H I C U L O S
		btnVehiculos = new JButton("Vehículos");
		btnVehiculos.setForeground(Color.WHITE);
		btnVehiculos.setBackground(new Color(128, 0, 0));
		btnVehiculos.setBounds(0, 77, 181, 39);
		panelOpcionesMenu.add(btnVehiculos);
		btnVehiculos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		// B O T O N O R D E N E S
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

		// B O T O N P R E C I O
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

		// B O T O N S T O C K
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

		// B O T O N E M P L E A D O S
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

		btnActualizarEmpleados = new JButton("Actualizar");
		btnActualizarEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarEmpleado();
			}
		});

		btnActualizarEmpleados.setForeground(Color.WHITE);
		btnActualizarEmpleados.setBackground(new Color(128, 128, 255));
		btnActualizarEmpleados.setBounds(724, 576, 121, 51);
		contentPane.add(btnActualizarEmpleados);

		btnEliminarEmpleados = new JButton("Eliminar");
		btnEliminarEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarEmpleado();
			}
		});

		btnEliminarEmpleados.setForeground(Color.WHITE);
		btnEliminarEmpleados.setBackground(new Color(255, 0, 0));
		btnEliminarEmpleados.setBounds(593, 576, 121, 51);
		contentPane.add(btnEliminarEmpleados);

		btnAgregarEmpleados = new JButton("Agregar");
		btnAgregarEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarEmpleado();
			}
		});

		btnAgregarEmpleados.setForeground(new Color(255, 255, 255));
		btnAgregarEmpleados.setBackground(new Color(0, 255, 0));
		btnAgregarEmpleados.setBounds(462, 576, 121, 51);
		contentPane.add(btnAgregarEmpleados);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empleadosAdmin frame = new empleadosAdmin();
				frame.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBackground(new Color(128, 0, 0));
		btnCancelar.setBounds(855, 576, 121, 51);
		contentPane.add(btnCancelar);

		// Cambiar el estado del botón actual
		btnEmpleados.setEnabled(false); // Deshabilitar
		btnEmpleados.setBackground(Color.WHITE);

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

		lblRol = new JLabel("Rol:");
		lblRol.setHorizontalAlignment(SwingConstants.CENTER);
		lblRol.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRol.setBounds(676, 452, 85, 40);
		contentPane.add(lblRol);

		lblDNI = new JLabel("DNI:");
		lblDNI.setHorizontalAlignment(SwingConstants.CENTER);
		lblDNI.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDNI.setBounds(208, 193, 121, 40);
		contentPane.add(lblDNI);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombre.setBounds(208, 256, 121, 40);
		contentPane.add(lblNombre);

		lblPrimerApellido = new JLabel("Primer apellido:");
		lblPrimerApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrimerApellido.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPrimerApellido.setBounds(191, 322, 171, 40);
		contentPane.add(lblPrimerApellido);

		lblSegundoApellido = new JLabel("Segundo apellido:");
		lblSegundoApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblSegundoApellido.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSegundoApellido.setBounds(191, 387, 171, 40);
		contentPane.add(lblSegundoApellido);

		lblTlfono = new JLabel("Teléfono:");
		lblTlfono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTlfono.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTlfono.setBounds(191, 452, 171, 40);
		contentPane.add(lblTlfono);

		lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		lblContraseña.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblContraseña.setBounds(621, 193, 142, 40);
		contentPane.add(lblContraseña);

		lblDireccion = new JLabel("Dirección:");
		lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDireccion.setBounds(642, 256, 121, 40);
		contentPane.add(lblDireccion);

		lblCorreo = new JLabel("Correo:");
		lblCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCorreo.setBounds(642, 322, 121, 40);
		contentPane.add(lblCorreo);

		lblFechaContratacion = new JLabel("Fecha contratación:");
		lblFechaContratacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaContratacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFechaContratacion.setBounds(571, 387, 192, 40);
		contentPane.add(lblFechaContratacion);

		lblAgregarUsuarios = new JLabel("AGREGAR USUARIOS");
		lblAgregarUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarUsuarios.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAgregarUsuarios.setBounds(417, 112, 221, 40);
		contentPane.add(lblAgregarUsuarios);

		mostrartablavehiculos();

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

		// J T E X T F I E L D S

		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(326, 193, 235, 40);
		contentPane.add(textFieldDNI);
		textFieldDNI.setColumns(10);

		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(326, 256, 235, 40);
		contentPane.add(textFieldNombre);

		textFieldPApellido = new JTextField();
		textFieldPApellido.setColumns(10);
		textFieldPApellido.setBounds(363, 325, 198, 40);
		contentPane.add(textFieldPApellido);

		textFieldSegundoApellido = new JTextField();
		textFieldSegundoApellido.setColumns(10);
		textFieldSegundoApellido.setBounds(363, 390, 198, 40);
		contentPane.add(textFieldSegundoApellido);

		textFieldTlfono = new JTextField();
		textFieldTlfono.setColumns(10);
		textFieldTlfono.setBounds(363, 455, 198, 40);
		contentPane.add(textFieldTlfono);

		textFieldContraseña = new JTextField();
		textFieldContraseña.setColumns(10);
		textFieldContraseña.setBounds(773, 193, 221, 40);
		contentPane.add(textFieldContraseña);

		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(773, 256, 221, 40);
		contentPane.add(textFieldDireccion);

		textFieldCorreo = new JTextField();
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(773, 322, 221, 40);
		contentPane.add(textFieldCorreo);

		textFieldFecha = new JTextField("YYYY/MM/DD");
		textFieldFecha.setForeground(Color.GRAY);
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(773, 387, 221, 40);
		contentPane.add(textFieldFecha);

		// F O C U S  L I S T E N E R  F E C H A  C O N T R A T A C I O N
		textFieldFecha.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Si tiene un mensaje, cuando se hace clic se elimina.
				if (textFieldFecha.getText().equals("YYYY/MM/DD")) {
					textFieldFecha.setText("");
					textFieldFecha.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Se restaura el mensaje, si no hay nada escrito en el despues de hacer clic.
				if (textFieldFecha.getText().isEmpty()) {
					textFieldFecha.setText("YYYY/MM/DD");
					textFieldFecha.setForeground(Color.GRAY);
				}
			}
		});

		textFieldRol = new JTextField();
		textFieldRol.setColumns(10);
		textFieldRol.setBounds(773, 452, 221, 40);
		contentPane.add(textFieldRol);

	}

	// M É T O D O S

	private void mostrartablavehiculos() {
		// Columnas del JTable
		String[] nombreColumnas = { "Matrícula", "Marca", "Modelo", "Color", "Año de Fabricación", "Tipo de Vehículo",
				"Kilometraje", "Fecha de Registro", "ID Cliente" };

		DefaultTableModel model = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.setColumnIdentifiers(nombreColumnas);

		try {
			stm = cn.createStatement();
			String selectVehiculos = "SELECT v.matricula AS 'Matrícula', v.marca AS 'Marca', v.modelo AS 'Modelo', v.color AS 'Color', "
					+ "v.ano_fabr AS 'Año de Fabricación', v.tipo_vehiculo AS 'Tipo de Vehículo', v.km AS 'Kilometraje', "
					+ "v.fecha_registro AS 'Fecha de Registro', v.cliente_dni AS 'ID Cliente' "
					+ "FROM derrapdb.vehiculo v;";
			resultado = stm.executeQuery(selectVehiculos);
			while (resultado.next()) {
				String matricula = resultado.getString("Matrícula");
				String marca = resultado.getString("Marca");
				String modelo = resultado.getString("Modelo");
				String color = resultado.getString("Color");
				String anoFabr = resultado.getString("Año de Fabricación");
				String tipoVehiculo = resultado.getString("Tipo de Vehículo");
				String km = resultado.getString("Kilometraje");
				String fechaRegistro = resultado.getString("Fecha de Registro");
				String idCliente = resultado.getString("ID Cliente");
				model.addRow(new Object[] { matricula, marca, modelo, color, anoFabr, tipoVehiculo, km, fechaRegistro,
						idCliente });
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

	private void agregarEmpleado() {
		// Obtener los valores de los JTextField
		String dni = textFieldDNI.getText();
		String nombre = textFieldNombre.getText();
		String apellido1 = textFieldPApellido.getText();
		String apellido2 = textFieldSegundoApellido.getText();
		String telefono = textFieldTlfono.getText();
		String password = textFieldContraseña.getText();
		String direccion = textFieldDireccion.getText();
		String email = textFieldCorreo.getText();
		String fechaContratacion = textFieldFecha.getText();
		String rol = textFieldRol.getText();

		// Conexión a la base de datos y ejecución del INSERT
		try {
			stm = cn.createStatement();
			String insertEmpleado = "INSERT INTO usuario (dni, nombre, apellido1, apellido2, telefono, password, direccion, email, fecha_contratacion, rol) VALUES "
					+ "('" + dni + "', '" + nombre + "', '" + apellido1 + "', '" + apellido2 + "', '" + telefono
					+ "', '" + password + "', '" + direccion + "', '" + email + "', '" + fechaContratacion + "', '"
					+ rol + "')";
			stm.executeUpdate(insertEmpleado);
			JOptionPane.showMessageDialog(null, "Empleado agregado correctamente");

			// Limpiar los campos de texto
			textFieldDNI.setText("");
			textFieldNombre.setText("");
			textFieldPApellido.setText("");
			textFieldSegundoApellido.setText("");
			textFieldTlfono.setText("");
			textFieldContraseña.setText("");
			textFieldDireccion.setText("");
			textFieldCorreo.setText("");
			textFieldFecha.setText("");
			textFieldRol.setText("");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (stm != null)
					stm.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	private void eliminarEmpleado() {
		String dniCliente = textFieldDNI.getText();

		try {
			stm = cn.createStatement();
			String deleteEmpleado = "DELETE FROM usuario WHERE dni = '" + dniCliente + "'";
			int rowsAffected = stm.executeUpdate(deleteEmpleado);

			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente");

				// Limpiar los campos de texto
				textFieldDNI.setText("");
				textFieldNombre.setText("");
				textFieldPApellido.setText("");
				textFieldSegundoApellido.setText("");
				textFieldTlfono.setText("");
				textFieldContraseña.setText("");
				textFieldDireccion.setText("");
				textFieldCorreo.setText("");
				textFieldFecha.setText("");
			} else {
				JOptionPane.showMessageDialog(null, "No se encontró ningún empleado con el DNI proporcionado");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (stm != null)
					stm.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	private void actualizarEmpleado() {
		// Obtener los valores de los JTextField
		String dniCliente = textFieldDNI.getText();
		String nombre = textFieldNombre.getText();
		String primerApellido = textFieldPApellido.getText();
		String segundoApellido = textFieldSegundoApellido.getText();
		String telefono = textFieldTlfono.getText();
		String contraseña = textFieldContraseña.getText();
		String direccion = textFieldDireccion.getText();
		String correo = textFieldCorreo.getText();
		String fecha = textFieldFecha.getText();
		String rol = textFieldRol.getText();

		// Conexión a la base de datos y ejecución del UPDATE
		try {
			stm = cn.createStatement();
			String updateEmpleado = "UPDATE empleado SET " + "nombre = '" + nombre + "', " + "apellido1 = '"
					+ primerApellido + "', " + "apellido2 = '" + segundoApellido + "', " + "telefono = '" + telefono
					+ "', " + "password = '" + contraseña + "', " + "direccion = '" + direccion + "', " + "email = '"
					+ correo + "', " + "fecha_contratacion = '" + fecha + "', " + "rol = '" + rol + "' "
					+ "WHERE dni = '" + dniCliente + "'";
			int rowsAffected = stm.executeUpdate(updateEmpleado);

			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Empleado actualizado correctamente");

				// Limpiar los campos de texto
				textFieldDNI.setText("");
				textFieldNombre.setText("");
				textFieldPApellido.setText("");
				textFieldSegundoApellido.setText("");
				textFieldTlfono.setText("");
				textFieldContraseña.setText("");
				textFieldDireccion.setText("");
				textFieldCorreo.setText("");
				textFieldFecha.setText("");
				textFieldRol.setText("");
			} else {
				JOptionPane.showMessageDialog(null, "No se encontró ningún empleado con el DNI proporcionado");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (stm != null)
					stm.close();
			} catch (Exception ex) {
				ex.printStackTrace();
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
