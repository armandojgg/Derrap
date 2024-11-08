package derrap;

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
import javax.swing.JTextField;

public class agregarCliente extends JFrame {
	
	conector conexion = new conector();
	Connection cn = null;
	Statement stm = null;
	ResultSet resultado = null;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelOpcionesMenu, panelOpcionesMenu_1, panelOpcionesMenu_2;
	private JButton btnHome, btnClientes, btnVehiculos, btnOrdenes, btnPrecio, btnStock, btnEmpleados;
	private JLabel lblIcono, lblLogOut, lblImagenLogOut, lblAdmin;
	private JLabel lblNombre;
	private JTextField textFieldNombreCliente;
	private JTextField textFieldPrimerApellidoCliente;
	private JTextField textFieldSegundoApellido;
	private JTextField textFieldDNI;
	private JTextField textFieldTelefono;
	private JTextField textFieldFechaAlta;
	private JTextField textFieldDireccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					agregarCliente frame = new agregarCliente();
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
	public agregarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 723);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Agregar clientes");
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconoderrap.jpg")).getImage());
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// P A N E L S
		panelOpcionesMenu = new JPanel();
		panelOpcionesMenu.setBounds(0, 74, 181, 231);
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
		panelOpcionesMenu_2.setBounds(0, 304, 181, 380);
		contentPane.add(panelOpcionesMenu_2);
		
		// B O T O N E S
		
        btnHome = new JButton("Home");
        btnHome.setBackground(new Color(128, 0, 0));
        btnHome.setForeground(Color.WHITE);
        btnHome.setBounds(0, 0, 181, 39);
        panelOpcionesMenu.add(btnHome);
        
        btnClientes = new JButton("Clientes");
        btnClientes.setBackground(new Color(128, 0, 0));
        btnClientes.setForeground(Color.WHITE);
        btnClientes.setBounds(0, 39, 181, 39);
        panelOpcionesMenu.add(btnClientes);
        
        btnVehiculos = new JButton("Vehículos");
        btnVehiculos.setForeground(Color.WHITE);
        btnVehiculos.setBackground(new Color(128, 0, 0));
        btnVehiculos.setBounds(0, 77, 181, 39);
        panelOpcionesMenu.add(btnVehiculos);
        
        btnOrdenes = new JButton("Ordenes");
        btnOrdenes.setForeground(Color.WHITE);
        btnOrdenes.setBackground(new Color(128, 0, 0));
        btnOrdenes.setBounds(0, 115, 181, 39);
        panelOpcionesMenu.add(btnOrdenes);
        
        btnPrecio = new JButton("Precio");
        btnPrecio.setForeground(Color.WHITE);
        btnPrecio.setBackground(new Color(128, 0, 0));
        btnPrecio.setBounds(0, 153, 181, 39);
        panelOpcionesMenu.add(btnPrecio);
        
        btnStock = new JButton("Stock");
        btnStock.setForeground(Color.WHITE);
        btnStock.setBackground(new Color(128, 0, 0));
        btnStock.setBounds(0, 192, 181, 39);
        panelOpcionesMenu.add(btnStock);
        
        btnEmpleados = new JButton("Empleados");
        btnEmpleados.setForeground(Color.WHITE);
        btnEmpleados.setBackground(new Color(128, 0, 0));
        btnEmpleados.setBounds(0, 231, 181, 39);
        panelOpcionesMenu.add(btnEmpleados);
        
        // I M A G E N E S
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
		
		// L A B E L S
		
		lblAdmin = new JLabel("ADMIN");
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setBounds(45, 25, 79, 26);
		panelOpcionesMenu_1.add(lblAdmin);
		
		JLabel lblAgregarClientes = new JLabel("Agregar clientes");
		lblAgregarClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarClientes.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAgregarClientes.setBounds(419, 95, 202, 26);
		contentPane.add(lblAgregarClientes);
		
		JButton btnAgregarCliente = new JButton("Agregar");
		btnAgregarCliente.setForeground(new Color(255, 255, 255));
		btnAgregarCliente.setBackground(new Color(0, 255, 0));
		btnAgregarCliente.setBounds(331, 588, 152, 50);
		contentPane.add(btnAgregarCliente);
		
		JButton btnCancelar = new JButton("Agregar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(Color.GREEN);
		btnCancelar.setBounds(536, 588, 152, 50);
		contentPane.add(btnCancelar);
		
        
	}
}
