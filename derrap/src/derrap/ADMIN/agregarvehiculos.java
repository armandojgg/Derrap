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

public class agregarvehiculos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelOpcionesMenu_1, panelOpcionesMenu_2, panelOpcionesMenu;
	private JButton btnHome, btnClientes, btnVehiculos, btnOrdenes, btnPrecio, btnStock, btnEmpleados,
			btnAgregarVehiculo, btnEliminar, btnCancelar, btnActualizar;
	private JLabel lblAdmin, lblIconoCasa, lblIcono, lblLogOut, lblImagenLogOut, lblPoweredDerrap, lblClienteDNI,
			lblFechaRegistro, lblKilometros, lblTipVehi, lblanofabr, lblColor, lblModelo, lblMarca, lblMatricula,
			lblAgregarVehiculos;
	private JTextField textFieldMatricula, textFieldMarca, textFieldModelo, textFieldColor, textFieldAnoFabric,
			textFieldTipoVehiculo, textFieldKM, textFieldFechaRegistro, textFieldDNICliente;
	conector conexion = new conector();
	Connection cn = null;
	Statement stm = null;
	ResultSet resultado = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					agregarvehiculos frame = new agregarvehiculos();
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
	public agregarvehiculos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Agregar vehículos - ADMIN"); // Título de la ventana en cuestión
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
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarvehiculos();
			}
		});

		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBackground(new Color(255, 0, 0));
		btnEliminar.setBounds(593, 576, 121, 51);
		contentPane.add(btnEliminar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarvehiculos();
			}
		});
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setBackground(new Color(128, 128, 255));
		btnActualizar.setBounds(727, 576, 121, 51);
		contentPane.add(btnActualizar);
		
		btnAgregarVehiculo = new JButton("Agregar");
		btnAgregarVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarvehiculos();
			}
		});
		
		btnAgregarVehiculo.setForeground(new Color(255, 255, 255));
		btnAgregarVehiculo.setBackground(new Color(0, 255, 0));
		btnAgregarVehiculo.setBounds(462, 576, 121, 51);
		contentPane.add(btnAgregarVehiculo);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vehiculosAdmin frame = new vehiculosAdmin();
				frame.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBackground(new Color(128, 0, 0));
		btnCancelar.setBounds(858, 576, 121, 51);
		contentPane.add(btnCancelar);
		
		// Cambiar el estado del botón actual
		btnVehiculos.setEnabled(false); // Deshabilitar
		btnVehiculos.setBackground(Color.WHITE);

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
		
		lblMatricula = new JLabel("Matricula:");
		lblMatricula.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMatricula.setBounds(208, 193, 121, 40);
		contentPane.add(lblMatricula);

		lblMarca = new JLabel("Marca:");
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMarca.setBounds(208, 256, 121, 40);
		contentPane.add(lblMarca);

		lblModelo = new JLabel("Modelo:");
		lblModelo.setHorizontalAlignment(SwingConstants.CENTER);
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblModelo.setBounds(208, 322, 121, 40);
		contentPane.add(lblModelo);

		lblColor = new JLabel("Color:");
		lblColor.setHorizontalAlignment(SwingConstants.CENTER);
		lblColor.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblColor.setBounds(208, 387, 121, 40);
		contentPane.add(lblColor);

		lblanofabr = new JLabel("Año fabricación:");
		lblanofabr.setHorizontalAlignment(SwingConstants.CENTER);
		lblanofabr.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblanofabr.setBounds(208, 452, 171, 40);
		contentPane.add(lblanofabr);

		lblTipVehi = new JLabel("Tipo vehículo:");
		lblTipVehi.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipVehi.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTipVehi.setBounds(621, 193, 142, 40);
		contentPane.add(lblTipVehi);

		lblKilometros = new JLabel("Kilometros:");
		lblKilometros.setHorizontalAlignment(SwingConstants.CENTER);
		lblKilometros.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKilometros.setBounds(642, 256, 121, 40);
		contentPane.add(lblKilometros);

		lblFechaRegistro = new JLabel("Fecha registro:");
		lblFechaRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaRegistro.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFechaRegistro.setBounds(621, 322, 142, 40);
		contentPane.add(lblFechaRegistro);

		lblClienteDNI = new JLabel("DNI Cliente:");
		lblClienteDNI.setHorizontalAlignment(SwingConstants.CENTER);
		lblClienteDNI.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblClienteDNI.setBounds(642, 387, 121, 40);
		contentPane.add(lblClienteDNI);
		
		lblAgregarVehiculos = new JLabel("AGREGAR VEHICULOS");
		lblAgregarVehiculos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarVehiculos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAgregarVehiculos.setBounds(417, 112, 221, 40);
		contentPane.add(lblAgregarVehiculos);

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
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.setBounds(326, 193, 235, 40);
		contentPane.add(textFieldMatricula);
		textFieldMatricula.setColumns(10);

		textFieldMarca = new JTextField();
		textFieldMarca.setColumns(10);
		textFieldMarca.setBounds(326, 256, 235, 40);
		contentPane.add(textFieldMarca);

		textFieldModelo = new JTextField();
		textFieldModelo.setColumns(10);
		textFieldModelo.setBounds(326, 322, 235, 40);
		contentPane.add(textFieldModelo);

		textFieldColor = new JTextField();
		textFieldColor.setColumns(10);
		textFieldColor.setBounds(326, 387, 235, 40);
		contentPane.add(textFieldColor);

		textFieldAnoFabric = new JTextField();
		textFieldAnoFabric.setColumns(10);
		textFieldAnoFabric.setBounds(378, 452, 235, 40);
		contentPane.add(textFieldAnoFabric);

		textFieldTipoVehiculo = new JTextField();
		textFieldTipoVehiculo.setColumns(10);
		textFieldTipoVehiculo.setBounds(773, 193, 221, 40);
		contentPane.add(textFieldTipoVehiculo);

		textFieldKM = new JTextField();
		textFieldKM.setColumns(10);
		textFieldKM.setBounds(773, 256, 221, 40);
		contentPane.add(textFieldKM);

		textFieldFechaRegistro = new JTextField("YYYY/MM/DD");
		textFieldFechaRegistro.setColumns(10);
		textFieldFechaRegistro.setBounds(773, 322, 221, 40);
		contentPane.add(textFieldFechaRegistro);
		
		// F O C U S  L I S T E N E R  F E C H A  R E G I S T R O
		textFieldFechaRegistro.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Si tiene un mensaje, cuando se hace clic se elimina.
				if (textFieldFechaRegistro.getText().equals("YYYY/MM/DD")) {
					textFieldFechaRegistro.setText("");
					textFieldFechaRegistro.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Se restaura el mensaje, si no hay nada escrito en el despues de hacer clic.
				if (textFieldFechaRegistro.getText().isEmpty()) {
					textFieldFechaRegistro.setText("YYYY/MM/DD");
					textFieldFechaRegistro.setForeground(Color.GRAY);
				}
			}
		});

		textFieldDNICliente = new JTextField();
		textFieldDNICliente.setColumns(10);
		textFieldDNICliente.setBounds(773, 387, 221, 40);
		contentPane.add(textFieldDNICliente);
		
		textFieldDNICliente.setToolTipText("Se debe de ingresar el DNI de un cliente ya registrado.");
		
	}

	// M E T O D O S

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
	
	private void insertarvehiculos() {

		String matricula = textFieldMatricula.getText();
		String marca = textFieldMarca.getText();
		String modelo = textFieldModelo.getText();
		String color = textFieldColor.getText();
		String anoFabric = textFieldAnoFabric.getText();
		String tipoVehiculo = textFieldTipoVehiculo.getText();
		String km = textFieldKM.getText();
		String fechaRegistro = textFieldFechaRegistro.getText();
		String dniCliente = textFieldDNICliente.getText();

		try {
			stm = cn.createStatement();
			String insertVehiculo = "INSERT INTO vehiculo (matricula, marca, modelo, color, ano_fabr, tipo_vehiculo, km, fecha_registro, cliente_dni) VALUES "
					+ "('" + matricula + "', '" + marca + "', '" + modelo + "', '" + color + "', " + anoFabric
					+ ", '" + tipoVehiculo + "', " + km + ", '" + fechaRegistro + "', '" + dniCliente + "')";
			stm.executeUpdate(insertVehiculo);
			JOptionPane.showMessageDialog(null, "Vehículo agregado correctamente");
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
	
	private void eliminarvehiculos() {
		
		String dniCliente = textFieldDNICliente.getText();

		try {
			stm = cn.createStatement();
			String deleteVehiculo = "DELETE FROM vehiculo WHERE cliente_dni = '" + dniCliente + "'";
			int rowsAffected = stm.executeUpdate(deleteVehiculo);

			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Vehículo(s) eliminado(s) correctamente");

				textFieldMatricula.setText("");
				textFieldMarca.setText("");
				textFieldModelo.setText("");
				textFieldColor.setText("");
				textFieldAnoFabric.setText("");
				textFieldTipoVehiculo.setText("");
				textFieldKM.setText("");
				textFieldFechaRegistro.setText("");
				textFieldDNICliente.setText("");
			} else {
				JOptionPane.showMessageDialog(null, "No se encontró ningún vehículo con el DNI proporcionado");
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
	
	private void actualizarvehiculos() {
		
		String dniCliente = textFieldDNICliente.getText();
		String nuevaMatricula = textFieldMatricula.getText();
		String nuevaMarca = textFieldMarca.getText();
		String nuevoModelo = textFieldModelo.getText();
		String nuevoColor = textFieldColor.getText();
		String nuevoAnoFabric = textFieldAnoFabric.getText();
		String nuevoTipoVehiculo = textFieldTipoVehiculo.getText();
		String nuevoKM = textFieldKM.getText();
		String nuevaFechaRegistro = textFieldFechaRegistro.getText();

		try {
			stm = cn.createStatement();
			String updateVehiculo = "UPDATE vehiculo SET " + "matricula = '" + nuevaMatricula + "', "
					+ "marca = '" + nuevaMarca + "', " + "modelo = '" + nuevoModelo + "', " + "color = '"
					+ nuevoColor + "', " + "ano_fabric = '" + nuevoAnoFabric + "', " + "tipo_vehiculo = '"
					+ nuevoTipoVehiculo + "', " + "km = '" + nuevoKM + "', " + "fecha_registro = '"
					+ nuevaFechaRegistro + "' " + "WHERE cliente_dni = '" + dniCliente + "'";
			int rowsAffected = stm.executeUpdate(updateVehiculo);

			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Vehículo(s) actualizado(s) correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "No se encontró ningún vehículo con el DNI proporcionado");
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
