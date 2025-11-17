package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt; // Importación de la librería BCrypt para el hash de las contraseñas

import models.Usuario;

public class UsuarioDAO {

    private Connection conexion; //Conexión a la base de datos

    // Constructor

    public UsuarioDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Metodo para registrar a un usuario
    public boolean insertarUsuario (Usuario usuario) {

        // String para la consulta SQL
        String sql = "INSERT INTO Usuario (nombre, email, pass) VALUES (?, ?, ?)";

        // Comprobaciones previas
        if (conexion == null) {
            throw new IllegalStateException("La conexión a la base de datos no está establecida.");
        }
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo.");
        }

        /* Método para insertar un usuario con PreparedStatement para
         * evitar inyecciones SQL del tipo: " '); DROP TABLE Usuario; --  "
         * y así poder evitar posibles ataques imprevistos */

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            
        pstmt.setString(1, usuario.getNombre());
        pstmt.setString(2, usuario.getEmail());

        /* En la siguiente línea de código se va a trabajar el hash de la contraseña
         * con la libreria BCrypt para una mayor seguridad, ya que esta
         * librería almacena la contraseña de forma segura y encriptada,
         * sin posibilidad de revertir el proceso */

        String passHash = BCrypt.hashpw(usuario.getPass(), BCrypt.gensalt());

        // una vez codificada, se inserta en la base de datos
        pstmt.setString(3, passHash);

        int filasAfectadas = pstmt.executeUpdate();
        return filasAfectadas > 0; // Retorna un true si se insertó la información correctamente
        } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al insertar el Usuario: " + e.getMessage());
        return false;
        }
    }
    
    // Método para iniciar sesión

    public Usuario iniciarSesion(String email, String pass) {

        //Consulta SQL

        String sql = "SELECT nombre, pass FROM Usuario WHERE email = ?";

        // Comprobaciones
        if (conexion == null) {
            throw new IllegalStateException("La conexión a la base de datos no está establecida.");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("El email no puede ser nulo o vacío.");
        }
        if (pass == null || pass.isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede ser nula o vacía.");
        }

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, email);

            var rs = pstmt.executeQuery();
            if (rs.next()) {
                String passHash = rs.getString("pass");

                if (BCrypt.checkpw(pass, passHash)) {

                    // En el caso de que la contraseña coincida, se genera y retorna el usuario
                    String nombre = rs.getString("nombre");
                    Usuario usuario = new Usuario(nombre, email, null);
                    return usuario;
                } else {
                    return null; 
                }
            } else {
                // Si no se encuentra el usuario, se retorna null
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al iniciar sesion: " + e.getMessage());
            return null;
        }
    }
}
