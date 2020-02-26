package com.example.prycine.models;

public class Pelicula {

    private String id_pelicula;

    private String pe_nombre;

    private String pe_detalle;

    private String pe_imagen;

    private String pe_director;

    private String pe_categoria;


    public Pelicula(String id_pelicula, String pe_nombre, String pe_detalle, String pe_imagen, String pe_director, String pe_categoria) {
        this.id_pelicula = id_pelicula;
        this.pe_nombre = pe_nombre;
        this.pe_detalle = pe_detalle;
        this.pe_imagen = pe_imagen;
        this.pe_director = pe_director;
        this.pe_categoria = pe_categoria;
    }
    public Pelicula(){

    }

    public String getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(String id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getPe_nombre() {
        return pe_nombre;
    }

    public void setPe_nombre(String pe_nombre) {
        this.pe_nombre = pe_nombre;
    }

    public String getPe_detalle() {
        return pe_detalle;
    }

    public void setPe_detalle(String pe_detalle) {
        this.pe_detalle = pe_detalle;
    }

    public String getPe_imagen() {
        return pe_imagen;
    }

    public void setPe_imagen(String pe_imagen) {
        this.pe_imagen = pe_imagen;
    }

    public String getPe_director() {
        return pe_director;
    }

    public void setPe_director(String pe_director) {
        this.pe_director = pe_director;
    }

    public String getPe_categoria() {
        return pe_categoria;
    }

    public void setPe_categoria(String pe_categoria) {
        this.pe_categoria = pe_categoria;
    }
}
