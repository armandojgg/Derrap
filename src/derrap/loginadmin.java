package derrap;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
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

import javax.swing.JTextField;
import javax.swing.JButton;

public class loginadmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnIniciarSesion, btnAtras;
	private JLabel lblBienvenidos, lblDerrap, lblEmail, lblContrasena, lblOlvidadoContrasena, etiquetaImagen, etiquetaCoche;
	private JTextField txtContrasena, txtFieldIntroducirDNI;
	
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
					loginadmin frame = new loginadmin();
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
	public loginadmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 580);
		contentPane = new JPanel();
		setTitle("Derrap - ADMIN"); // Título de la ventana en cuestión
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconoderrap.jpg")).getImage());

		contentPane.setBackground(Color.BLACK); // Cambiar el color de fondo
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// L A B E L S
		lblBienvenidos = new JLabel("Bienvenido");
		lblBienvenidos.setForeground(new Color(255, 255, 255));
		lblBienvenidos.setFont(new Font("Calibri", Font.PLAIN, 51));
		lblBienvenidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidos.setBounds(26, 70, 266, 60);
		contentPane.add(lblBienvenidos);

		lblDerrap = new JLabel("DERRAP");
		lblDerrap.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDerrap.setBounds(252, 11, 52, 16);
		contentPane.add(lblDerrap);

		lblEmail = new JLabel("DNI");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(35, 163, 52, 23);
		contentPane.add(lblEmail);
		

		lblContrasena = new JLabel("Contraseña");
		lblContrasena.setForeground(new Color(255, 255, 255));
		lblContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasena.setBounds(39, 238, 82, 23);
		contentPane.add(lblContrasena);
		

		lblOlvidadoContrasena = new JLabel("¿Has olvidado tu contraseña?");
		lblOlvidadoContrasena.setForeground(new Color(192, 192, 192));
		lblOlvidadoContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		lblOlvidadoContrasena.setBounds(68, 319, 171, 16);
		contentPane.add(lblOlvidadoContrasena);
		

		// M O U S E L I S T E N E R  O L V I D A D O  C O N T R A S E Ñ A

		lblOlvidadoContrasena.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				recuperarcontrasena recuperarContrasenaFrame = new recuperarcontrasena();
				recuperarContrasenaFrame.setVisible(true);
				dispose(); // Cerrar el JFrame actual si es necesario
			}
		});

		// T E X T F I E L D S

		// T E X T F I E L D  I N T R O D U C I R  D N I
		txtFieldIntroducirDNI = new JTextField("Ingrese su DNI");
		txtFieldIntroducirDNI.setForeground(Color.GRAY);
		txtFieldIntroducirDNI.setBounds(47, 192, 192, 35);
		contentPane.add(txtFieldIntroducirDNI);
		txtFieldIntroducirDNI.setColumns(10);
		
		txtFieldIntroducirDNI.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Si tiene un mensaje, cuando se hace clic se elimina.
				if (txtFieldIntroducirDNI.getText().equals("Ingrese su DNI")) {
					txtFieldIntroducirDNI.setText("");
					txtFieldIntroducirDNI.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Se restaura el mensaje, si no hay nada escrito en el despues de hacer clic.
				if (txtFieldIntroducirDNI.getText().isEmpty()) {
					txtFieldIntroducirDNI.setText("Ingrese su DNI");
					txtFieldIntroducirDNI.setForeground(Color.GRAY);
				}
			}
		});

		// T E X T F I E L D  I N T R O D U C I R  C O N T R A S E Ñ A
		txtContrasena = new JTextField("Ingresa tu contraseña");
		txtContrasena.setForeground(Color.GRAY);
		txtContrasena.setColumns(10);
		txtContrasena.setBounds(47, 272, 192, 35);
		contentPane.add(txtContrasena);
		
		
		// F O C U S  L I S T E N E R
		txtContrasena.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Si tiene un mensaje, cuando se hace clic se elimina.
				if (txtContrasena.getText().equals("Ingresa tu contraseña")) {
					txtContrasena.setText("");
					txtContrasena.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Se restaura el mensaje, si no hay nada escrito en el despues de hacer clic.
				if (txtContrasena.getText().isEmpty()) {
					txtContrasena.setText("Ingresa tu contraseña");
					txtContrasena.setForeground(Color.GRAY);
				}
			}
		});
		

		// B U T T O N S

		btnIniciarSesion = new JButton("Iniciar sesión");
		btnIniciarSesion.setBounds(45, 350, 194, 35);
		btnIniciarSesion.setBackground(new Color(0, 0, 139)); // Color del fondo del botón azul oscuro.
		btnIniciarSesion.setForeground(Color.WHITE); ;// Color de las letras en blanco.
		btnIniciarSesion.setFocusable(false);
		contentPane.add(btnIniciarSesion);
		
		btnAtras = new JButton("Atrás");
		btnAtras.setBackground(new Color(128, 0, 255));
		btnAtras.setForeground(new Color(255, 255, 255));
		btnAtras.setFocusable(false);
		btnAtras.setBounds(85, 492, 121, 38);
		contentPane.add(btnAtras);		
		
		// A C T I O N  L I S T E N E R  H O M E  A D M I N
		
		btnIniciarSesion.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String dni = txtFieldIntroducirDNI.getText().trim();
		        String password = txtContrasena.getText();
		        
		        // Comprobar si el DNI y la contraseña son válidos
		        if (conexion.comprobarUsuarioAdmin(dni, password)) {
		            homeAdmin menuPrincipal = new homeAdmin();
		            menuPrincipal.setVisible(true);
		            dispose(); // Cierra la ventana anterior.
		        } else {
		            // Mensaje de error si el DNI no se encuentra o la contraseña es incorrecta
		            JOptionPane.showMessageDialog(contentPane, "DNI o contraseña incorrectos. Además comprueba que el rol del DNI introducido sea el correcto.", 
		                    "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		    
		});
		
		// A C T I O N  L I S T E N E R  V O L V E R  A  L A  E L E C C I O N
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eleccionlogin eleccionlogin = new eleccionlogin();
				eleccionlogin.setVisible(true);
				dispose();
			}
		});
		
	    setLocationRelativeTo(null); // Se centra la ventana en la pantalla
	    
		// I M A G E N E S

		// I M A G E N L O G O
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/imagenes/iconoderrap.jpg")); // Revisa la ruta
		Image imagenoriginal = imagen.getImage();
		Image imagenreescalada = imagenoriginal.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimensionado = new ImageIcon(imagenreescalada);
		etiquetaImagen = new JLabel(iconoRedimensionado);
		etiquetaImagen.setBounds(102, 396, 91, 85); // Ajusta la posición según sea necesario
		contentPane.add(etiquetaImagen);

		// I M A G E N C O C H E P O R T A D A

		ImageIcon imagencoche = new ImageIcon(this.getClass().getResource("/imagenes/coche_portada.jpg"));
		Image imagenoriginal2 = imagencoche.getImage();
		Image imagenreescaladacoche = imagenoriginal2.getScaledInstance(600, 600, Image.SCALE_SMOOTH);
		ImageIcon cocheRedimensionado = new ImageIcon(imagenreescaladacoche);
		etiquetaCoche = new JLabel(cocheRedimensionado);
		etiquetaCoche.setBounds(341, 0, 394, 541);
		contentPane.add(etiquetaCoche);
	    
		// F O C U S A B L E
		etiquetaCoche.setFocusable(true);
		
	    this.addWindowListener(new java.awt.event.WindowAdapter() {
	    	public void windowOpened(java.awt.event.WindowEvent e) {
	    		etiquetaCoche.requestFocus(); 
	    	}
	    });
	}
	
}
