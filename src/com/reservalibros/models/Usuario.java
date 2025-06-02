package com.reservalibros.models;

public class Usuario {
    private String nombre;
    private String email;
    private String pass;

    public Usuario(String nombre, String email, String pass) {
        this.nombre = nombre;
        this.email = email;
        this.pass = pass;
    }

    // Métodos getters
    public String getNombre() {
        return nombre;
    }
    public String getEmail() {
        return email;
    }
    
    // Métodos setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
}
