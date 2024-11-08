package derrap;

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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class menumecanico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelOpcionesMenu_1, panelOpcionesMenu_2, paneNumClientes, panelOpcionesMenu, panelCrearPedido;
	private JButton btnHome, btnClientes, btnVehiculos, btnOrdenes, btnPrecio, btnStock, btnActivo, btnAtras,
			btnEliminarOrden, btnModificarOrden, btnConsultarPedidos, btnCrearStock, btnConsultarStock, btnVolver, btnCrearPedido, btnCancelarCrearPedido;
	private JLabel lblMecanico, lblIconoCasa, lblIcono, lblLogOut, lblImagenLogOut, lblBienvenida, lblPoweredDerrap,
			lblNumClientes, lblContadorClientes, lblClientes, lblVehiculos, lblOrdenes, lblEliminar, lblIDOrden,
			lblPrecioServicios;
	private JTextField textFieldBuscar, textFieldIDOrden, textFieldIDPedido, textFieldPieza, textFieldIDProveedor, textFieldFecha, textFieldEstado, textFieldNPiezas, textFieldPrecioTotal;
	private JLabel lblSegundoIcono, lblPedidos, lblMisPedidos, lblNuevoPedido, lblIDPedido, lblPieza, lblIdProveedor, lblFecha, lblEstado, lblNPiezas, lblPrecioTotal,
	lblStock;

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
					menumecanico frame = new menumecanico();
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
	public menumecanico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Menú - MECÁNICO"); // Título de la ventana en cuestión
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

		panelCrearPedido.setVisible(false);

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
					panelCrearPedido.setVisible(false);
					// B O T O N E S
					// ----------------------------
					btnHome.setEnabled(false);
					btnHome.setBackground(Color.WHITE);
					btnAtras.setVisible(false);
					btnEliminarOrden.setVisible(false);
					btnModificarOrden.setVisible(false);
					btnConsultarPedidos.setVisible(false);
					btnCrearStock.setVisible(false);
					btnConsultarStock.setVisible(false);
					btnVolver.setVisible(false);
					btnCrearPedido.setVisible(false);
					btnCancelarCrearPedido.setVisible(false);

					// L A B E L S
					// ---------------------------------------
					lblBienvenida.setVisible(true);
					lblIconoCasa.setVisible(true);
					lblSegundoIcono.setVisible(false);
					lblClientes.setVisible(false);
					lblVehiculos.setVisible(false);
					lblOrdenes.setVisible(false);
					lblEliminar.setVisible(false);
					lblIDOrden.setVisible(false);
					lblPrecioServicios.setVisible(false);
					lblPedidos.setVisible(false);
					lblMisPedidos.setVisible(false);
					lblNuevoPedido.setVisible(false);
					lblIDPedido.setVisible(false);
					lblStock.setVisible(false);

					// T E X T F I E L D S
					// ---------------------------------------
					textFieldBuscar.setVisible(false);
					textFieldIDOrden.setVisible(false);
					textFieldIDPedido.setVisible(false);
					textFieldPieza.setVisible(false);
					textFieldIDProveedor.setVisible(false);
					textFieldFecha.setVisible(false);
					textFieldEstado.setVisible(false);
					textFieldNPiezas.setVisible(false);
					textFieldPrecioTotal.setVisible(false);

					// Restablecer el botón activo si se desactiva Home
					if (btnActivo != null) {
						btnActivo.setEnabled(true); // Habilitar el botón anteriormente activo
						btnActivo.setBackground(new Color(128, 0, 0)); // Color original
					}
					btnActivo = null; // Restablecer el botón activo
				}
			}
		});

		// B O T O N  C L I E N T E S
		btnClientes = new JButton("Clientes");
		btnClientes.setBackground(new Color(128, 0, 0));
		btnClientes.setForeground(Color.WHITE);
		btnClientes.setBounds(0, 39, 181, 39);
		panelOpcionesMenu.add(btnClientes);
		btnClientes.addActionListener(createButtonListener(btnClientes));

		btnClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paneNumClientes.setVisible(false);
				panelCrearPedido.setVisible(false);
				volveralHome();
				// B O T O N E S
				// ------------------------------
				btnAtras.setVisible(true);
				btnEliminarOrden.setVisible(false);
				btnModificarOrden.setVisible(false);
				btnConsultarPedidos.setVisible(false);
				btnCrearStock.setVisible(false);
				btnConsultarStock.setVisible(false);
				btnVolver.setVisible(false);
				btnCrearPedido.setVisible(false);
				btnCancelarCrearPedido.setVisible(false);

				// L A B E L S
				// -------------------------------
				lblBienvenida.setVisible(false);
				lblSegundoIcono.setVisible(true);
				lblClientes.setVisible(true);
				lblVehiculos.setVisible(false);
				lblOrdenes.setVisible(false);
				lblEliminar.setVisible(false);
				lblIDOrden.setVisible(false);
				lblIconoCasa.setVisible(false);
				lblPrecioServicios.setVisible(false);
				lblPedidos.setVisible(false);
				lblMisPedidos.setVisible(false);
				lblNuevoPedido.setVisible(false);
				lblIDPedido.setVisible(false);
				lblStock.setVisible(false);

				// T E X T F I E L D S
				// -----------------------------------------
				textFieldBuscar.setVisible(true);
				textFieldIDOrden.setVisible(false);
				textFieldIDPedido.setVisible(false);
				textFieldPieza.setVisible(false);
				textFieldIDProveedor.setVisible(false);
				textFieldFecha.setVisible(false);
				textFieldEstado.setVisible(false);
				textFieldNPiezas.setVisible(false);
				textFieldPrecioTotal.setVisible(false);
			}
		});

		// B O T O N  V E H I C U L O S
		btnVehiculos = new JButton("Vehículos");
		btnVehiculos.setForeground(Color.WHITE);
		btnVehiculos.setBackground(new Color(128, 0, 0));
		btnVehiculos.setBounds(0, 77, 181, 39);
		panelOpcionesMenu.add(btnVehiculos);
		btnVehiculos.addActionListener(createButtonListener(btnVehiculos));

		btnVehiculos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paneNumClientes.setVisible(false);
				panelCrearPedido.setVisible(false);
				volveralHome();
				// B O T O N E S
				// ------------------------------
				btnAtras.setVisible(true);
				btnEliminarOrden.setVisible(false);
				btnModificarOrden.setVisible(false);
				btnConsultarPedidos.setVisible(false);
				btnCrearStock.setVisible(false);
				btnConsultarStock.setVisible(false);
				btnVolver.setVisible(false);
				btnCrearPedido.setVisible(false);
				btnCancelarCrearPedido.setVisible(false);

				// L A B E L S
				// -------------------------------
				lblBienvenida.setVisible(false);
				lblSegundoIcono.setVisible(true);
				lblClientes.setVisible(false);
				lblVehiculos.setVisible(true);
				lblOrdenes.setVisible(false);
				lblEliminar.setVisible(false);
				lblIDOrden.setVisible(false);
				lblIconoCasa.setVisible(false);
				lblPrecioServicios.setVisible(false);
				lblPedidos.setVisible(false);
				lblMisPedidos.setVisible(false);
				lblNuevoPedido.setVisible(false);
				lblIDPedido.setVisible(false);
				lblStock.setVisible(false);

				// T E X T F I E L D S
				// -----------------------------------------
				textFieldBuscar.setVisible(true);
				textFieldIDOrden.setVisible(false);
				textFieldIDPedido.setVisible(false);
				textFieldPieza.setVisible(false);
				textFieldIDProveedor.setVisible(false);
				textFieldFecha.setVisible(false);
				textFieldEstado.setVisible(false);
				textFieldNPiezas.setVisible(false);
				textFieldPrecioTotal.setVisible(false);
			}
		});

		// B O T O N  O R D E N E S
		btnOrdenes = new JButton("Ordenes");
		btnOrdenes.setForeground(Color.WHITE);
		btnOrdenes.setBackground(new Color(128, 0, 0));
		btnOrdenes.setBounds(0, 115, 181, 39);
		panelOpcionesMenu.add(btnOrdenes);
		btnOrdenes.addActionListener(createButtonListener(btnOrdenes));

		btnOrdenes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paneNumClientes.setVisible(false);
				panelCrearPedido.setVisible(false);
				// B O T O N E S
				// ------------------------------
				btnAtras.setVisible(false);
				btnEliminarOrden.setVisible(true);
				btnModificarOrden.setVisible(true);
				btnConsultarPedidos.setVisible(false);
				btnCrearStock.setVisible(false);
				btnConsultarStock.setVisible(false);
				btnVolver.setVisible(false);
				btnCrearPedido.setVisible(false);
				btnCancelarCrearPedido.setVisible(false);

				// L A B E L S
				// -------------------------------
				lblBienvenida.setVisible(false);
				lblSegundoIcono.setVisible(true);
				lblClientes.setVisible(false);
				lblVehiculos.setVisible(false);
				lblOrdenes.setVisible(true);
				lblEliminar.setVisible(true);
				lblIDOrden.setVisible(true);
				lblIconoCasa.setVisible(false);
				lblPrecioServicios.setVisible(false);
				lblPedidos.setVisible(false);
				lblMisPedidos.setVisible(false);
				lblNuevoPedido.setVisible(false);
				lblIDPedido.setVisible(false);
				lblStock.setVisible(false);

				// T E X T F I E L D S
				// -----------------------------------------
				textFieldBuscar.setVisible(true);
				textFieldIDOrden.setVisible(true);
				textFieldIDPedido.setVisible(false);
				textFieldPieza.setVisible(false);
				textFieldIDProveedor.setVisible(false);
				textFieldFecha.setVisible(false);
				textFieldEstado.setVisible(false);
				textFieldNPiezas.setVisible(false);
				textFieldPrecioTotal.setVisible(false);
			}
		});

		// B O T O N  P R E C I O
		btnPrecio = new JButton("Precio");
		btnPrecio.setForeground(Color.WHITE);
		btnPrecio.setBackground(new Color(128, 0, 0));
		btnPrecio.setBounds(0, 153, 181, 39);
		panelOpcionesMenu.add(btnPrecio);
		btnPrecio.addActionListener(createButtonListener(btnPrecio));

		btnPrecio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paneNumClientes.setVisible(false);
				panelCrearPedido.setVisible(false);
				// B O T O N E S
				// ------------------------------
				btnAtras.setVisible(false);
				btnEliminarOrden.setVisible(false);
				btnModificarOrden.setVisible(false);
				btnConsultarPedidos.setVisible(false);
				btnCrearStock.setVisible(false);
				btnConsultarStock.setVisible(false);
				btnVolver.setVisible(false);
				btnCrearPedido.setVisible(false);
				btnCancelarCrearPedido.setVisible(false);

				// L A B E L S
				// -------------------------------
				lblBienvenida.setVisible(false);
				lblSegundoIcono.setVisible(true);
				lblClientes.setVisible(false);
				lblVehiculos.setVisible(false);
				lblOrdenes.setVisible(false);
				lblEliminar.setVisible(false);
				lblIDOrden.setVisible(false);
				lblIconoCasa.setVisible(false);
				lblPrecioServicios.setVisible(true);
				lblPedidos.setVisible(false);
				lblMisPedidos.setVisible(false);
				lblNuevoPedido.setVisible(false);
				lblIDPedido.setVisible(false);
				lblStock.setVisible(false);

				// T E X T F I E L D S
				// -----------------------------------------
				textFieldBuscar.setVisible(true);
				textFieldIDOrden.setVisible(false);
				textFieldIDPedido.setVisible(false);
				textFieldPieza.setVisible(false);
				textFieldIDProveedor.setVisible(false);
				textFieldFecha.setVisible(false);
				textFieldEstado.setVisible(false);
				textFieldNPiezas.setVisible(false);
				textFieldPrecioTotal.setVisible(false);
			}
		});

		// B O T O N  S T O C K
		btnStock = new JButton("Stock");
		btnStock.setForeground(Color.WHITE);
		btnStock.setBackground(new Color(128, 0, 0));
		btnStock.setBounds(0, 192, 181, 39);
		panelOpcionesMenu.add(btnStock);
		btnStock.addActionListener(createButtonListener(btnStock));

		btnStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paneNumClientes.setVisible(false);
				panelCrearPedido.setVisible(false);
				// B O T O N E S
				// ------------------------------
				btnAtras.setVisible(false);
				btnEliminarOrden.setVisible(false);
				btnModificarOrden.setVisible(false);
				btnConsultarPedidos.setVisible(true);
				// ACTION LISTENER CONSULTARPEDIDOS
				btnConsultarPedidos.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						lblMisPedidos.setVisible(true);
						lblPedidos.setVisible(false);

						// B O T O N E S
						// ------------------------------------------

						btnConsultarPedidos.setVisible(false);
						btnCrearStock.setVisible(false);
						btnConsultarStock.setVisible(false);
						btnVolver.setVisible(true);
					}
				});

				btnCrearStock.setVisible(true);

				// ACTION LISTENER CREAR STOCK

				btnCrearStock.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						panelCrearPedido.setVisible(true);
						lblMisPedidos.setVisible(false);
						lblPedidos.setVisible(false);
						lblNuevoPedido.setVisible(true);
						lblSegundoIcono.setVisible(false);
						lblIDPedido.setVisible(true);

						// B O T O N E S
						// ------------------------------------------

						btnConsultarPedidos.setVisible(false);
						btnCrearStock.setVisible(false);
						btnConsultarStock.setVisible(false);
						btnVolver.setVisible(false);
						btnCrearPedido.setVisible(true);
						btnCancelarCrearPedido.setVisible(true);

						btnCancelarCrearPedido.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								panelCrearPedido.setVisible(false);
								lblMisPedidos.setVisible(false);
								lblPedidos.setVisible(true);
								lblNuevoPedido.setVisible(true);
								lblSegundoIcono.setVisible(false);
								lblIDPedido.setVisible(true);

								// B O T O N E S
								// ------------------------------------------

								btnConsultarPedidos.setVisible(true);
								btnCrearStock.setVisible(true);
								btnConsultarStock.setVisible(true);
								btnVolver.setVisible(false);
								btnCrearPedido.setVisible(false);
								btnCancelarCrearPedido.setVisible(false);

								// T E X T F I E L D
								// --------------------------------------------
								textFieldBuscar.setVisible(true);
							}
						});

						// T E X T F I E L D
						// --------------------------------------------
						textFieldBuscar.setVisible(false);
					}
				});
				btnConsultarStock.setVisible(true);

				btnConsultarStock.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						lblStock.setVisible(true);
						lblPedidos.setVisible(false);

						btnConsultarPedidos.setVisible(false);
						btnCrearStock.setVisible(false);
						btnConsultarStock.setVisible(false);
						btnVolver.setVisible(true);
						
						// A C T I O N  L I S T E N E R  B O T O N  V O L V E R
						btnVolver.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								lblMisPedidos.setVisible(false);
								lblPedidos.setVisible(true);

								// B O T O N E S
								// ------------------------------------------

								btnConsultarPedidos.setVisible(true);
								btnCrearStock.setVisible(true);
								btnConsultarStock.setVisible(true);
								btnVolver.setVisible(false);
								lblStock.setVisible(false);
							}
						});
					}

				});

				btnVolver.setVisible(false);

				// ACTION LISTENER VOLVER

				btnVolver.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						lblMisPedidos.setVisible(false);
						lblPedidos.setVisible(true);

						// B O T O N E S
						// ------------------------------------------

						btnConsultarPedidos.setVisible(true);
						btnCrearStock.setVisible(true);
						btnConsultarStock.setVisible(true);
						btnVolver.setVisible(false);
					}
				});

				// L A B E L S
				// -------------------------------
				lblBienvenida.setVisible(false);
				lblSegundoIcono.setVisible(true);
				lblClientes.setVisible(false);
				lblVehiculos.setVisible(false);
				lblOrdenes.setVisible(false);
				lblEliminar.setVisible(false);
				lblIDOrden.setVisible(false);
				lblIconoCasa.setVisible(false);
				lblPrecioServicios.setVisible(false);
				lblPedidos.setVisible(true);
				lblMisPedidos.setVisible(false);
				lblIDPedido.setVisible(false);

				// T E X T F I E L D S
				// -----------------------------------------
				textFieldBuscar.setVisible(true);
				textFieldIDOrden.setVisible(false);
				textFieldIDPedido.setVisible(true);
				textFieldPieza.setVisible(true);
				textFieldIDProveedor.setVisible(true);
				textFieldFecha.setVisible(true);
				textFieldEstado.setVisible(true);
				textFieldNPiezas.setVisible(true);
				textFieldPrecioTotal.setVisible(true);
			}
		});

		// B O T O N  A T R A S
		btnAtras = new JButton("Atrás");
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAtras.setBackground(new Color(128, 0, 0));
		btnAtras.setBounds(784, 603, 120, 45);
		contentPane.add(btnAtras);

		btnAtras.setVisible(false);

		// B O T O N  E L I M I N A R  O R D E N
		btnEliminarOrden = new JButton("Eliminar");
		btnEliminarOrden.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEliminarOrden.setForeground(new Color(255, 255, 255));
		btnEliminarOrden.setBackground(new Color(255, 0, 0));
		btnEliminarOrden.setBounds(437, 601, 111, 45);
		contentPane.add(btnEliminarOrden);

		btnEliminarOrden.setVisible(false);

		// B O T O N  M O D I F I C A R  O R D E N
		btnModificarOrden = new JButton("Modificar orden");
		btnModificarOrden.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModificarOrden.setBackground(new Color(128, 255, 0));
		btnModificarOrden.setBounds(668, 603, 145, 45);
		contentPane.add(btnModificarOrden);

		btnModificarOrden.setVisible(false);

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

		btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(0, 0, 255));
		btnVolver.setBounds(447, 603, 132, 45);
		contentPane.add(btnVolver);

		btnVolver.setVisible(false);

		btnCrearPedido = new JButton("Crear");
		btnCrearPedido.setForeground(new Color(255, 255, 255));
		btnCrearPedido.setBackground(new Color(0, 255, 0));
		btnCrearPedido.setBounds(116, 362, 169, 40);
		panelCrearPedido.add(btnCrearPedido);

		btnCrearPedido.setVisible(false);

		btnCancelarCrearPedido = new JButton("Cancelar");
		btnCancelarCrearPedido.setForeground(Color.WHITE);
		btnCancelarCrearPedido.setBackground(new Color(128, 0, 0));
		btnCancelarCrearPedido.setBounds(318, 362, 169, 40);
		panelCrearPedido.add(btnCancelarCrearPedido);

		btnCancelarCrearPedido.setVisible(false);

		// Inicialmente, el botón activo es nulo
		btnActivo = null;

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

		paneNumClientes = new JPanel();
		paneNumClientes.setBackground(new Color(64, 0, 128));
		paneNumClientes.setBounds(204, 97, 200, 123);
		contentPane.add(paneNumClientes);
		paneNumClientes.setLayout(null);

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

		lblBienvenida = new JLabel("¡Bienvenido de nuevo!");
		lblBienvenida.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setBounds(426, 74, 234, 36);
		contentPane.add(lblBienvenida);

		lblPoweredDerrap = new JLabel("Powered by DERRAP");
		lblPoweredDerrap.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPoweredDerrap.setForeground(new Color(255, 255, 255));
		lblPoweredDerrap.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoweredDerrap.setBounds(22, 319, 149, 39);
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

		lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setBounds(506, 121, 98, 45);
		contentPane.add(lblClientes);

		lblClientes.setVisible(false);

		lblVehiculos = new JLabel("Vehículos");
		lblVehiculos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblVehiculos.setHorizontalAlignment(SwingConstants.CENTER);
		lblVehiculos.setBounds(506, 121, 98, 45);
		contentPane.add(lblVehiculos);

		lblVehiculos.setVisible(false);

		lblOrdenes = new JLabel("Órdenes");
		lblOrdenes.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOrdenes.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdenes.setBounds(506, 121, 98, 45);
		contentPane.add(lblOrdenes);

		lblOrdenes.setVisible(false);

		lblEliminar = new JLabel("Eliminar");
		lblEliminar.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setBounds(231, 540, 145, 45);
		contentPane.add(lblEliminar);

		lblEliminar.setVisible(false);

		lblIDOrden = new JLabel("ID Orden:");
		lblIDOrden.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblIDOrden.setHorizontalAlignment(SwingConstants.CENTER);
		lblIDOrden.setBounds(189, 596, 120, 52);
		contentPane.add(lblIDOrden);

		lblIDOrden.setVisible(false);

		lblPrecioServicios = new JLabel("Precio de los servicios");
		lblPrecioServicios.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPrecioServicios.setBounds(436, 121, 213, 45);
		contentPane.add(lblPrecioServicios);

		lblPrecioServicios.setVisible(false);

		lblPedidos = new JLabel("Pedidos");
		lblPedidos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPedidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPedidos.setBounds(437, 121, 120, 30);
		contentPane.add(lblPedidos);

		lblPedidos.setVisible(false);

		lblMisPedidos = new JLabel("Mis pedidos");
		lblMisPedidos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMisPedidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMisPedidos.setBounds(458, 121, 146, 30);
		contentPane.add(lblMisPedidos);

		lblMisPedidos.setVisible(false);

		lblNuevoPedido = new JLabel("Nuevo pedido");
		lblNuevoPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoPedido.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNuevoPedido.setBounds(204, 85, 172, 45);
		contentPane.add(lblNuevoPedido);

		lblNuevoPedido.setVisible(false);

		lblIDPedido = new JLabel("ID Pedido");
		lblIDPedido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIDPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblIDPedido.setBounds(39, 35, 110, 40);
		panelCrearPedido.add(lblIDPedido);

		lblIDPedido.setVisible(false);

		ImageIcon imagen4 = new ImageIcon(this.getClass().getResource("/imagenes/iconoderrap.jpg")); // Revisa la ruta
		Image imagenoriginal4 = imagen4.getImage();
		Image imagenreescalada4 = imagenoriginal4.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado4 = new ImageIcon(imagenreescalada4);
		lblSegundoIcono = new JLabel(iconoRedimensionado4);
		lblSegundoIcono.setHorizontalAlignment(SwingConstants.CENTER);
		lblSegundoIcono.setBounds(200, 85, 145, 100);
		contentPane.add(lblSegundoIcono);
		lblSegundoIcono.setVisible(false);

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

		textFieldBuscar.setVisible(false);

		textFieldIDOrden = new JTextField();
		textFieldIDOrden.setBounds(307, 602, 120, 45);
		contentPane.add(textFieldIDOrden);
		textFieldIDOrden.setColumns(10);

		textFieldIDOrden.setVisible(false);

		textFieldIDPedido = new JTextField();
		textFieldIDPedido.setBounds(63, 73, 169, 29);
		panelCrearPedido.add(textFieldIDPedido);
		textFieldIDPedido.setColumns(10);

		textFieldIDPedido.setVisible(false);

		textFieldPieza = new JTextField();
		textFieldPieza.setBounds(63, 151, 169, 29);
		panelCrearPedido.add(textFieldPieza);
		textFieldPieza.setColumns(10);

		textFieldPieza.setVisible(false);

		textFieldIDProveedor = new JTextField();
		textFieldIDProveedor.setColumns(10);
		textFieldIDProveedor.setBounds(63, 228, 169, 29);
		panelCrearPedido.add(textFieldIDProveedor);

		textFieldIDProveedor.setVisible(false);

		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(63, 302, 169, 29);
		panelCrearPedido.add(textFieldFecha);

		textFieldFecha.setVisible(false);

		textFieldEstado = new JTextField();
		textFieldEstado.setColumns(10);
		textFieldEstado.setBounds(305, 73, 169, 29);
		panelCrearPedido.add(textFieldEstado);

		textFieldEstado.setVisible(false);

		textFieldNPiezas = new JTextField();
		textFieldNPiezas.setColumns(10);
		textFieldNPiezas.setBounds(305, 151, 169, 29);
		panelCrearPedido.add(textFieldNPiezas);

		textFieldNPiezas.setVisible(false);

		textFieldPrecioTotal = new JTextField();
		textFieldPrecioTotal.setColumns(10);
		textFieldPrecioTotal.setBounds(305, 228, 169, 29);
		panelCrearPedido.add(textFieldPrecioTotal);

		textFieldPrecioTotal.setVisible(false);

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

		lblStock = new JLabel("STOCK");
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblStock.setBounds(469, 121, 120, 30);
		contentPane.add(lblStock);

		lblStock.setVisible(false);

		// F O C U S A B L E

		lblSegundoIcono.setFocusable(true);

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent e) {
				lblSegundoIcono.requestFocus();
			}
		});

		setLocationRelativeTo(null); // Se centra la ventana en la pantalla

	}

	private ActionListener createButtonListener(JButton button) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Restablecer el botón previamente activo si existe
				if (btnActivo != null) {
					btnActivo.setBackground(new Color(128, 0, 0)); // Color original
					btnActivo.setEnabled(true); // Habilitar
				}

				// Habilitar el botón Home y cambiar su apariencia
				btnHome.setEnabled(true); // Habilitar Home
				btnHome.setForeground(Color.WHITE);
				btnHome.setBackground(new Color(128, 0, 0));

				// Cambiar el estado del botón actual
				button.setEnabled(false); // Deshabilitar
				button.setBackground(Color.WHITE); // Cambiar fondo a blanco
				btnActivo = button; // Actualizar el botón activo
			}
		};
	}

	private void volveralHome() {
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// B O T O N E S
				// ----------------------------
				paneNumClientes.setVisible(true);
				btnHome.setEnabled(false);
				btnHome.setBackground(Color.WHITE);
				btnAtras.setVisible(false);
				btnEliminarOrden.setVisible(false);
				btnModificarOrden.setVisible(false);
				btnConsultarPedidos.setVisible(false);
				btnCrearStock.setVisible(false);
				btnConsultarStock.setVisible(false);

				// L A B E L S
				// ---------------------------------------
				lblBienvenida.setVisible(true);
				lblIconoCasa.setVisible(true);
				lblSegundoIcono.setVisible(false);
				lblClientes.setVisible(false);
				lblVehiculos.setVisible(false);
				lblOrdenes.setVisible(false);
				lblEliminar.setVisible(false);
				lblIDOrden.setVisible(false);
				lblPrecioServicios.setVisible(false);
				lblPedidos.setVisible(false);

				// T E X T F I E L D S
				// ---------------------------------------
				textFieldBuscar.setVisible(false);
				textFieldIDOrden.setVisible(false);

				// Restablecer el botón activo si se desactiva Home
				if (btnActivo != null) {
					btnActivo.setEnabled(true); // Habilitar el botón anteriormente activo
					btnActivo.setBackground(new Color(128, 0, 0)); // Color original
				}
				btnActivo = null; // Restablecer el botón activo
			}
		});

	}
}
