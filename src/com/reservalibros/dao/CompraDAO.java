package com.reservalibros.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.reservalibros.models.Compra;

public class CompraDAO {
    private Connection conexion; // Conexión a la base de datos

    //Constructor para la conexión

    public CompraDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Método para registrar una compra

    public boolean insertarCompra(Compra compra) {

        // Asignación de la hora local automática
        Date fechaActual = new Date(System.currentTimeMillis());

        String sql = "INSERT INTO Compra (precio_compra, id_usuario, id_libro, fecha_compra) values (?, ?, ?, ?)";

        if (conexion == null) {
            throw new IllegalStateException("La conexión a la base de datos no está establecida.");
        }

        if (compra == null) {
            throw new IllegalArgumentException("La compra no puede ser nula.");
        }

        /* Método para insertar una compra con PreparedStatement para
         * evitar la inyeccion malintencionada de SQL */

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setFloat(1, compra.getPrecioCompra());
            pstmt.setInt(2, compra.getUsuario().getId());
            pstmt.setInt(3, compra.getLibro().getId());
            pstmt.setDate(4, fechaActual);

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0; //Retorna true si se insertó exitosamente
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al insertar la compra: " + e.getMessage());
            return false;
        }
    }
    
}
