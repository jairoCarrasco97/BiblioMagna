package com.reservalibros.dao;

import java.sql.Date;
import com.reservalibros.models.Libro;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class LibroDAO {

    private Connection conexion; // Conexión a la base de datos

    //Constructor para la conexión

    public LibroDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Método para insertar un libro a la base de datos

    public boolean insertarLibro(Libro libro) {
        // String para la orden SQL

        String sql = "INSERT INTO Libro (titulo, publicacion, autor, cantidad_disponible, precio_alquiler, precio_compra, genero, url_imagen) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        /* Método para insertar un libro con PreparedStatement para
         * evitar inyecciones SQL del tipo: " '); DROP TABLE Libro; --  "
         * y así poder evitar posibles ataques imprevistos */

        if (conexion == null) {
            throw new IllegalStateException("La conexión a la base de datos no está establecida.");
        }
        if (libro == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo.");
        }
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setString(1, libro.getTitulo());
            pstmt.setDate(2, libro.getFechaPublicacion());
            pstmt.setString(3, libro.getAutor());
            pstmt.setInt(4, libro.getCantidadDisponible());
            pstmt.setFloat(5, libro.getPrecioAlquiler());
            pstmt.setFloat(6, libro.getPrecioCompra());
            pstmt.setString(7, libro.getGenero());
            pstmt.setString(8, libro.getUrlImagen());
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0; // Retorna un true si se insertó la información correctamente
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al insertar el libro: " + e.getMessage());
            return false;
        }

    }

    // Método para Listar los libros de la base de datos

    public List<Libro> listarLibros() {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM Libro";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            var lib = pstmt.executeQuery();
            while (lib.next()) {
                int id = lib.getInt("id_libro");
                String titulo = lib.getString("titulo");
                Date publicacion = lib.getDate("publicacion");
                String autor = lib.getString ("autor");
                int cantidadDisponible = lib.getInt("cantidad_disponible");
                float precioAlquiler = lib.getFloat("precio_alquiler");
                float precioCompra = lib.getFloat("precio_compra");
                String genero = lib.getString("genero");
                String urlImagen = lib.getString("url_imagen");

                // Asignación de atributos al objeto Libro
                Libro libro = new Libro (id, titulo, publicacion, autor, cantidadDisponible, precioAlquiler, precioCompra, genero, urlImagen);
                libros.add(libro); // Añade el libro a la lista

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al listar los libros: " + e.getMessage());
            return null;
        }
        
        // Retorno de la lista completa
        return libros;
            
        
    }

    // Método para Listar libros según el autor

    public List<Libro> listarLibrosAutor(String autor) {
        List<Libro> libros = new ArrayList<>();

        //Consulta sql con "LIKE" para poder obtener resultados completos de busquedas parciales
        String sql = "SELECT * FROM Libro WHERE autor LIKE ?";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, "%" + autor + "%"); // Uso de % para encontrar coincidencias que contengan el texto introducido

            var lib = pstmt.executeQuery();

            // Bucle para recorrer los libros obtenidos
            while (lib.next()) {
                int id = lib.getInt("id_libro");
                String titulo = lib.getString("titulo");
                Date publicacion = lib.getDate("publicacion");
                String autor = lib.getString ("autor");
                int cantidadDisponible = lib.getInt("cantidad_disponible");
                float precioAlquiler = lib.getFloat("precio_alquiler");
                float precioCompra = lib.getFloat("precio_compra");
                String genero = lib.getString("genero");
                String urlImagen = lib.getString("url_imagen");

                // Asignación de atributos al objeto Libro
                Libro libro = new Libro (id, titulo, publicacion, autor, cantidadDisponible, precioAlquiler, precioCompra, genero, urlImagen);
                libros.add(libro); // Añade el libro a la lista

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al listar los libros: " + e.getMessage());
            return new ArrayList<>(); // Retorna una lista vacía para evitar posibles errores
        }
        
        // Retorno de la lista completa
        return libros;
    }
    
}
