package com.reservalibros.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class TestConexion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/WebBiblioteca/database";
        String usuario = "root";
        String contraseña = "root"; // Cámbialo por la contraseña real de tu MySQL

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("✅ Conexión establecida correctamente.");
            conexion.close();
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar con la base de datos.");
            e.printStackTrace();
        }
    }
}

