package controllers;

import dao.LibroDAO;
import models.Libro;
import java.util.List;
import java.sql.Connection;

public class LibroController {
    private LibroDAO libroDAO;

    public LibroController(Connection conexion) {
        this.libroDAO = new LibroDAO(conexion);
    }

    public List<Libro> obtenerTodosLosLibros() {
        return libroDAO.listarLibros();
    }

    public List<Libro> buscarLibrosPorTitulo(String titulo) {
        return libroDAO.listarLibrosTitulo(titulo);
    }
    public List <Libro> buscarLibrosPorAutor(String autor) {
        return libroDAO.listarLibrosAutor(autor);
    }
}
