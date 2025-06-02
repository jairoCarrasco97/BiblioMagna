package com.reservalibros.models;

import java.sql.Date;

public class Compra {
    private int id;
    private float precioCompra;
    private Usuario usuario;
    private Libro libro;
    private Date fechaCompra;

    
     // Constructor para insertar una nueva compra a la base de datos

    /* Este constructor no contiene el campo "id" al ser la base de datos
     * la que genere el id de forma automática */

    public Compra(float precioCompra, Usuario usuario, Libro libro, Date fechaCompra){
        this.precioCompra = precioCompra;
        this.usuario = usuario;
        this.libro = libro;
        this.fechaCompra = fechaCompra;
    }

    // Constructor para obtener una compra de la base de datos

    /* A diferencia del constructor anterior, este si que obtiene el "id" generado
     * por la base de datos */

    public Compra(int id, float precioCompra, Usuario usuario, Libro libro, Date fechaCompra) {
        this.id = id;
        this.precioCompra = precioCompra;
        this.usuario = usuario;
        this.libro = libro;
        this.fechaCompra = fechaCompra;
    }

     // Métodos Getters
    
    public int getId() {
        return id;
    }
    public float getPrecioCompra() {
        return precioCompra;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public Libro getLibro() {
        return libro;
    }
    public Date getFechaCompra() {
        return fechaCompra;
    }

    // Métodos Setters

    public void setId(int id) {
        this.id = id;
    }
    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void setLibro(Libro libro) {
        this.libro = libro;
    }
}
