package com.example.artists.model;

import java.util.ArrayList;
import java.util.List;

public class Pista {
    private long id;
    private String titulo;
    private String genero;
    private double duracion;
    private String album;
    private transient List<Artista> artistas;

    public Pista(){

    }

    public Pista(long id, String titulo, String genero, double duracion, String album) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.album = album;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public List<Artista> getArtistas() {
        if(artistas == null){
            artistas = new ArrayList<>();
        }
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }
}
