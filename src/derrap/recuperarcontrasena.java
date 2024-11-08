package derrap;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class recuperarcontrasena extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane, panel, panelLetras;
    private JTextField txtFieldCorreo;
    private JLabel lblRecuperarContrasena, lblCorreoElectronico, lblPoweredByDerrap, lblIconoApp, lblImagen2;
    private JButton btnRecuperarContrasena, btnVolver;

    conector conexion = new conector();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    recuperarcontrasena frame = new recuperarcontrasena();
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
    public recuperarcontrasena() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Recupera tu contraseña");
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconoderrap.jpg")).getImage());
        setBounds(100, 100, 862, 684);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel = new JPanel();
        panel.setBounds(143, 114, 522, 434);
        panel.setBackground(Color.LIGHT_GRAY);
        contentPane.add(panel);
        panel.setLayout(null);
        
        panelLetras = new JPanel();
        panelLetras.setBackground(new Color(255, 0, 0));
        panelLetras.setBounds(0, 0, 846, 78);
        contentPane.add(panelLetras);
        panelLetras.setLayout(null);

        // J L A B E L S
        lblRecuperarContrasena = new JLabel("Recupera tu contraseña");
        lblRecuperarContrasena.setBackground(new Color(0, 0, 255));
        lblRecuperarContrasena.setForeground(new Color(0, 0, 255));
        lblRecuperarContrasena.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblRecuperarContrasena.setHorizontalAlignment(SwingConstants.CENTER);
        lblRecuperarContrasena.setBounds(95, 25, 306, 55);
        panel.add(lblRecuperarContrasena);

        lblCorreoElectronico = new JLabel("Correo electrónico");
        lblCorreoElectronico.setForeground(new Color(0, 0, 255));
        lblCorreoElectronico.setHorizontalAlignment(SwingConstants.CENTER);
        lblCorreoElectronico.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblCorreoElectronico.setBackground(new Color(0, 0, 255));
        lblCorreoElectronico.setBounds(57, 91, 107, 27);
        panel.add(lblCorreoElectronico);
        
        lblPoweredByDerrap = new JLabel("Powered by Derrap");
        lblPoweredByDerrap.setForeground(new Color(255, 255, 255));
        lblPoweredByDerrap.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblPoweredByDerrap.setHorizontalAlignment(SwingConstants.CENTER);
        lblPoweredByDerrap.setBounds(21, 23, 187, 33);
        panelLetras.add(lblPoweredByDerrap);

        // I M A G E N E S
        ImageIcon imagen = new ImageIcon(this.getClass().getResource("/imagenes/iconoderrap.jpg")); // Revisa la ruta
        Image imagenoriginal = imagen.getImage();
        Image imagenreescalada = imagenoriginal.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenreescalada);
        lblIconoApp = new JLabel(iconoRedimensionado);
        lblIconoApp.setBounds(182, 285, 113, 94);
        panel.add(lblIconoApp);
        
        ImageIcon imagen2 = new ImageIcon(this.getClass().getResource("/imagenes/iconoderrap.jpg")); // Revisa la ruta
        Image imagenoriginal2 = imagen2.getImage();
        Image imagenreescalada2 = imagenoriginal2.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado2 = new ImageIcon(imagenreescalada2);
        lblImagen2 = new JLabel(iconoRedimensionado2);
        lblImagen2.setBounds(708, 0, 116, 78);  
        panelLetras.add(lblImagen2);
        
		// F O C U S A B L E
        
		lblIconoApp.setFocusable(true);
		
	    this.addWindowListener(new java.awt.event.WindowAdapter() {
	    	public void windowOpened(java.awt.event.WindowEvent e) {
	    		lblIconoApp.requestFocus(); 
	    	}
	    });

        // J T E X T F I E L D
        txtFieldCorreo = new JTextField("medac@alu.medac.es");
        txtFieldCorreo.setForeground(Color.GRAY);
        txtFieldCorreo.setBounds(58, 121, 357, 46);
        panel.add(txtFieldCorreo);
        txtFieldCorreo.setColumns(10);
        
        txtFieldCorreo.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Si tiene un mensaje, cuando se hace clic se elimina.
				if (txtFieldCorreo.getText().equals("medac@alu.medac.es")) {
					txtFieldCorreo.setText("");
					txtFieldCorreo.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Se restaura el mensaje, si no hay nada escrito en el despues de hacer clic.
				if (txtFieldCorreo.getText().isEmpty()) {
					txtFieldCorreo.setText("medac@alu.medac.es");
					txtFieldCorreo.setForeground(Color.GRAY);
				}
			}
		});

        // J B U T T O N
        btnRecuperarContrasena = new JButton("Recuperar contraseña");
        btnRecuperarContrasena.setBackground(new Color(255, 0, 0)); // Color del fondo del botón azul oscuro.
        btnRecuperarContrasena.setForeground(Color.WHITE); // Color de las letras en blanco.
        btnRecuperarContrasena.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnRecuperarContrasena.setBounds(57, 205, 358, 55);
        panel.add(btnRecuperarContrasena);
        
        btnRecuperarContrasena.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String correo = txtFieldCorreo.getText();
                String contrasena = conexion.obtenerContrasena(correo);
                if (contrasena != null) {
                    JOptionPane.showMessageDialog(null, "Tu contraseña es: " + contrasena);
                } else {
                    JOptionPane.showMessageDialog(null, "Correo electrónico erróneo", "Error al introducir el correo", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        btnVolver = new JButton("Volver");
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnVolver.setBackground(new Color(255, 0, 0));
        btnVolver.setBounds(360, 368, 152, 55);
        panel.add(btnVolver);
      
        
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginadmin login = new loginadmin();
                login.setVisible(true);
                
                dispose();
            }
        });

        setLocationRelativeTo(null); // Se centra la ventana en la pantalla
    }
}
