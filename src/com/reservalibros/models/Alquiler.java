package com.reservalibros.models;

import java.sql.Date;

public class Alquiler {
    private int id;
    private float precioAlquiler;
    private Usuario usuario;
    private Libro libro;
    private Date fechaAlquiler;
    private Date fechaDevolucion;

     // Constructor para insertar un nuevo alquiler a la base de datos

    /* Este constructor no contiene el campo "id" al ser la base de datos
     * la que genere el id de forma automática */

    public Alquiler(float precioAlquiler, Usuario usuario, Libro libro, Date fechaAlquiler, Date fechaDevolucion){
        this.precioAlquiler = precioAlquiler;
        this.usuario = usuario;
        this.libro = libro;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
    }

      // Constructor para obtenet un alquiler de la base de datos

    /* A diferencia del constructor anterior, este si que obtiene el "id" generado
     * por la base de datos */

    public Alquiler(int id, float precioAlquiler, Usuario usuario, Libro libro, Date fechaAlquiler, Date fechaDevolucion){
        this.id = id;
        this.precioAlquiler = precioAlquiler;
        this.usuario = usuario;
        this.libro = libro;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
    }

    // Métodos getters
    public int getId() {
        return id;
    }
    public float getPrecioAlquiler() {
        return precioAlquiler;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public Libro getLibro() {
        return libro;
    }
    public Date getFechaAlquiler() {
        return fechaAlquiler;
    }
    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    // Métodos Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setPrecioAlquiler(float precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

}
