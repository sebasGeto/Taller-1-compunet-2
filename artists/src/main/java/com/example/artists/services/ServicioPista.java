package com.example.artists.services;

import com.example.artists.model.Pista;
import com.example.artists.repositories.RepositorioPista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioPista {

    @Autowired
    private RepositorioPista repositorioPista;

    public void setRepositorioPista(RepositorioPista repositorioPista) {
        this.repositorioPista = repositorioPista;
    }


    public void agregarPista(String titulo, String genero, double duracion, String album){
        Pista pista = new Pista();
        pista.setTitulo(titulo);
        pista.setGenero(genero);
        pista.setDuracion(duracion);
        pista.setAlbum(album);

        repositorioPista.guardar(pista);

    }


    public void eliminarPista(long id){
        repositorioPista.eliminar(id);
    }


    public List<Pista> listarTodos() {
        return repositorioPista.listarTodos();
    }
    public Pista buscarPorId(long id){
        return repositorioPista.buscarPorId(id);
    }
}
