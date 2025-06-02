package com.reservalibros.models;

import java.sql.Date;

public class Libro {
    private int id; 
    private String titulo;
    private Date publicacion;
    private String autor;
    private int cantidadDisponible;
    private float precioAlquiler;
    private float precioCompra;
    private String genero;
    private String urlImagen;
    
    // Constructor para insertar un nuevo libro a la base de datos

    /* Este constructor no contiene el campo "id" al ser la base de datos
     * la que genere el id de forma automática */

    public Libro(String titulo, Date publicacion, String autor, int cantidadDisponible, float precioAlquiler, float precioCompra, String genero, String urlImagen) {

        this.titulo = titulo;
        this.publicacion = publicacion;
        this.autor = autor;
        this.cantidadDisponible = cantidadDisponible;
        this.precioAlquiler = precioAlquiler;
        this.precioCompra = precioCompra;
        this.genero = genero;
        this.urlImagen = urlImagen;
    }

    // Constructor para obtener un libro de la base de datos

    /* A diferencia del constructor anterior, este si que obtiene el "id" generado
     * por la base de datos */

    public Libro(int id, String titulo, Date publicacion, String autor, int cantidadDisponible, float precioAlquiler, float precioCompra, String genero, String urlImagen) {

        this.id = id;
        this.titulo = titulo;
        this.publicacion = publicacion;
        this.autor = autor;
        this.cantidadDisponible = cantidadDisponible;
        this.precioAlquiler = precioAlquiler;
        this.precioCompra = precioCompra;
        this.genero = genero;
        this.urlImagen = urlImagen;
    }

    // Métodos getters
    public int getId(){
        return id;
    }
    public String getTitulo(){
        return titulo;
    }
    public Date getPublicacion(){
        return publicacion;
    }
    public String getAutor(){
        return autor;
    }
    public int getCantidadDisponible(){
        return cantidadDisponible;
    }
    public float getPrecioAlquiler(){
        return precioAlquiler;
    }
    public float getPrecioCompra(){
        return precioCompra;
    }
    public String getGenero(){
        return genero;
    }
    public String getUrlImagen(){
        return urlImagen;
    }

    // Métodos setters
    public void setId(int id) {
        this.id = id;
    }
    public void setCantidadDisponible(int cantidadDisponible){
        this.cantidadDisponible = cantidadDisponible;
    }
    public void setPrecioAlquiler(float precioAlquiler){
        this.precioAlquiler = precioAlquiler;
    }
    public void setPrecioCompra(float precioCompra){
        this.precioCompra = precioCompra;
    }
}