package derrap;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import derrap.ADMIN.loginadmin;
import derrap.MECANICO.loginmecanico;
import javax.swing.JButton;
import javax.swing.JComponent;

public class eleccionlogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblBienvenidos, lblDerrap, etiquetaImagen, etiquetaCoche;
	private JButton btnSesionAdmin, btnSesionMecanico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					eleccionlogin frame = new eleccionlogin();
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
	public eleccionlogin() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 580);
		contentPane = new JPanel();
		setTitle("Derrap"); // Título de la ventana en cuestión
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

		// B O T O N E S

		// B O T O N I N I C I A R S E S I O N C O M O A D M I N
		btnSesionAdmin = new JButton("Iniciar sesión como Admin");
		btnSesionAdmin.setForeground(new Color(255, 255, 255));
		btnSesionAdmin.setBackground(new Color(255, 0, 0));
		btnSesionAdmin.setBounds(37, 187, 255, 36);
		contentPane.add(btnSesionAdmin);

		// A C T I O N L I S T E N E R I N I C I A R C O M O A D M I N
		btnSesionAdmin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginadmin login = new loginadmin();
				login.setVisible(true);
				contentPane.requestFocusInWindow();
				dispose();
			}
		});

		// B O T O N I N I C I A R S E S I O N C O M O M E C A N I C O
		btnSesionMecanico = new JButton("Iniciar sesión como Mecánico");
		btnSesionMecanico.setForeground(Color.WHITE);
		btnSesionMecanico.setBackground(Color.RED);
		btnSesionMecanico.setBounds(37, 283, 255, 36);
		contentPane.add(btnSesionMecanico);

		// A C T I O N L I S T E N E R I N I C I A R C O M O M E C A N I C O
		btnSesionMecanico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginmecanico loginmecanico = new loginmecanico();
				loginmecanico.setVisible(true);
				contentPane.requestFocusInWindow();
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
		etiquetaImagen.setBounds(80, 354, 171, 118); // Ajusta la posición según sea necesario
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

		this.setFocusable(true);
		contentPane.setFocusable(true);

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent e) {
				etiquetaCoche.requestFocus();
			}
		});

		teclasteclado();

	}
	
	// A T A J O S  T E C L A D O
	
	private void teclasteclado() {
		añadirteclateclado("W", btnSesionAdmin);
		añadirteclateclado("S", btnSesionMecanico);
		añadirteclateclado("ENTER", null);
	}

	private void añadirteclateclado(String key, JButton button) {
		AbstractAction action = new AbstractAction() {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				if (button != null) {
					button.requestFocus();
				} else {
					Component focusOwner = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
					if (focusOwner instanceof JButton) {
						((JButton) focusOwner).doClick();
					}
				}
			}
		};

		contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key), key);
		contentPane.getActionMap().put(key, action);
	}
}
