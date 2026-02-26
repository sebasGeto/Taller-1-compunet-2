package com.example.artists.model;

import java.util.ArrayList;
import java.util.List;

public class Artista {
    private long id;
    private String nombre;
    private String nacionalidad;
    private List<Pista> pistas;

    public Artista(){

    }

    public Artista(long id, String nombre, String nacionalidad, List<Pista> pistas) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.pistas = pistas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<Pista> getPistas() {
        if(pistas == null){
            pistas = new ArrayList<>();
        }
        return pistas;
    }

    public void setPistas(List<Pista> pistas) {
        this.pistas = pistas;
    }
}
