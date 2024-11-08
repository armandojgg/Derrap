package derrap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class conector {

    private static final String URL = "jdbc:mysql://localhost:3306/derrapdb";
    private static final String USUARIO = "root";
    private static final String CLAVE = "1234";

    private Connection cn = null;

    public Connection conexion_correcta() {
        try {
            if (cn == null || cn.isClosed()) {
                cn = DriverManager.getConnection(URL, USUARIO, CLAVE);
            }
        } catch (SQLException e) {
            System.out.println("Error en la conexión");
            e.printStackTrace();
        }
        return cn;
    }

    public boolean comprobarUsuarioAdmin(String dni, String password) {
        String comprobarusuario = "SELECT * FROM usuario WHERE dni = ? AND password = ? AND rol = 'administrador'";
        try (Connection connection = conexion_correcta(); 
             PreparedStatement preparedStatement = connection.prepareStatement(comprobarusuario)) {
            
            // Establecer los parámetros de la consulta
            preparedStatement.setString(1, dni);
            preparedStatement.setString(2, password);
            
            // Ejecutar la consulta
            ResultSet resultSet = preparedStatement.executeQuery();
            
            // Verificar si se encontró al usuario
            boolean exists = resultSet.next(); // Si existe un resultado, el usuario es correcto.
            return exists;

        } catch (SQLException e) {
            System.out.println("Error al consultar el usuario: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean comprobarUsuarioMecanico(String dni, String password) {
        String comprobarusuario = "SELECT * FROM usuario WHERE dni = ? AND password = ? AND rol = 'mecanico'";
        try (Connection connection = conexion_correcta(); 
             PreparedStatement preparedStatement = connection.prepareStatement(comprobarusuario)) {
            
            // Establecer los parámetros de la consulta
            preparedStatement.setString(1, dni);
            preparedStatement.setString(2, password);
            
            // Ejecutar la consulta
            ResultSet resultSet = preparedStatement.executeQuery();
            
            // Verificar si se encontró al usuario
            boolean exists = resultSet.next(); // Si existe un resultado, el usuario es correcto.
            return exists;

        } catch (SQLException e) {
            System.out.println("Error al consultar el usuario: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public void insertarDatosClientes(String dni, String nombre, String apellido1, String apellido2, String telefono, String direccion, String email, String fecha_registro) {
    	try (Connection connection = conexion_correcta();
    		 PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cliente (dni, nombre, apellido1, apellido2, telefono, direccion, email, fecha_registro) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
    		preparedStatement.setString(1, dni);
    		preparedStatement.setString(2, nombre);
    		preparedStatement.setString(3, apellido1);
    		preparedStatement.setString(4, apellido2);
    		preparedStatement.setString(5, telefono);
    		preparedStatement.setString(6, direccion);
    		preparedStatement.setString(7, email);
    		preparedStatement.setString(8, fecha_registro);
    		preparedStatement.executeUpdate();
    		JOptionPane.showMessageDialog(null, "¡Datos insertados exitosamente!");
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
		

    public void cerrarConexion() {
        if (cn != null) {
            try {
                cn.close();
                System.out.println("Conexión cerrada correctamente");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String obtenerContrasena(String correo) {
        String password = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT password FROM usuario WHERE email = ?";
            pst = conexion_correcta().prepareStatement(sql); // Inicializar la conexión si es nula
            pst.setString(1, correo);
            rs = pst.executeQuery();
            if (rs.next()) {
                password = rs.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return password;
    }
    
    
    
    
}
