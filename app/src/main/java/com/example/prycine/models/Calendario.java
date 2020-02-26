package com.example.prycine.models;

import java.sql.Time;

public class Calendario {

    private int id;

    private String pelicula;

    private String hora;

    private String sala;

    private String fecha;

    private int asientos;


    public Calendario() {
    }

    public Calendario(int id, String pelicula, String hora, String sala, String fecha) {
        this.id = id;
        this.pelicula = pelicula;
        this.hora = hora;
        this.sala = sala;
        this.fecha = fecha;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
