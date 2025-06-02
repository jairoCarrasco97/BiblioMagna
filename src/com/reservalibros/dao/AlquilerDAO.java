package com.reservalibros.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.reservalibros.models.Alquiler;

public class AlquilerDAO {
    private Connection conexion; // Conexión a la base de datos

    // Constructor de la conexión
    public AlquilerDAO(Connection conexion){
        this.conexion = conexion;
    }

    // Método para registrar un alquiler

    public boolean insertarAlquiler(Alquiler alquiler) {
        // Asignación de fecha y hora local
        Date fechaActual = new Date(System.currentTimeMillis());
        LocalDate fechaDevolucionLocal = fechaActual.toLocalDate().plusDays(7);
        Date fechaDevolucion = Date.valueOf(fechaDevolucionLocal); // Asignar fecha de devolución 7 días después del alquiler
            

        String sql = "INSERT INTO Alquiler (precio_alquiler, id_usuario, id_libro, fecha_alquiler, fecha_devolucion) VALUES (?, ?, ?, ?, ?)";
        if (conexion == null) {
            throw new IllegalStateException("La conexión a la base de datos no está establecida.");
        }
        if (alquiler == null) {
            throw new IllegalArgumentException("El alquiler no puede ser nulo.");
        }
        /* Método para insertar un alquier con PreparedStatement para
        * evitar la inyeccion malintencionada de SQL */

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setFloat(1, alquiler.getPrecioAlquiler());
            pstmt.setInt(2, alquiler.getUsuario().getId());
            pstmt.setInt(3, alquiler.getLibro().getId());
            pstmt.setDate(4, fechaActual);
            pstmt.setDate(5, fechaDevolucion);

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0; // Retorna true si se insertó exitosamente
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al insertar el alquiler: " + e.getMessage());
            return false;
        }
    }
    
}
