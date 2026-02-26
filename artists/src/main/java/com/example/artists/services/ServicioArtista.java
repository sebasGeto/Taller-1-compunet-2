package com.example.artists.services;

import com.example.artists.model.Artista;
import com.example.artists.model.Pista;
import com.example.artists.repositories.RepositorioArtista;
import com.example.artists.repositories.RepositorioPista;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioArtista {

    @Autowired
    private RepositorioArtista repositorioArtista;

    @Autowired
    private RepositorioPista repositorioPista;

    @Autowired
    @Qualifier("Validator")
    private Validator validator;

    public void setRepositorioArtista(RepositorioArtista repositorioArtista) {
        this.repositorioArtista = repositorioArtista;
    }

    @PostConstruct
    public void init(){

        Pista p1 = new Pista(0L, "Pa' las que sea", "Cantinazo", 3.15, "Jimmy Gutierrez");
        Pista p2 = new Pista(1L, "Dime que si", "Cantinazo", 3.45, "Jimmy Gutierrez");

        repositorioPista.guardar(p1);
        repositorioPista.guardar(p2);

        agregarArtista("Jimmy Gutierrez", "Colombia", List.of(1L)); // !!!! como hay current id se le debe sumar 1

    }

    public void agregarArtista(String nombre, String nacionalidad, List<Long> pistaIds){
        Artista artista = new Artista();
        artista.setNombre(nombre);
        artista.setNacionalidad(nacionalidad);

        repositorioArtista.guardar(artista);

        for(Long idP : pistaIds){
            agregarArtistaAPista(idP, artista.getId());
        }

        if(!validator.validate(artista)){
            repositorioArtista.eliminar(artista.getId());
            throw new RuntimeException("Artista no cumple el mínimo total");
        }

    }

    public void agregarArtistaAPista(long idP, long idA){
        Artista artista = repositorioArtista.buscarPorId(idA);
        Pista pista = repositorioPista.buscarPorId(idP);

        pista.getArtistas().add(artista);
        artista.getPistas().add(pista);
    }

    public void actualizarPistasArtista(long idA, List<Long> pistaIds){

        Artista artista = repositorioArtista.buscarPorId(idA);

        for(Long idP : pistaIds){

            Pista pista = repositorioPista.buscarPorId(idP);

            //Solo agregar si NO existe
            if(!artista.getPistas().contains(pista)){
                artista.getPistas().add(pista);
                pista.getArtistas().add(artista);
            }
        }
    }

    public void eliminarArtista(long id){
        repositorioArtista.eliminar(id);
    }


    public List<Artista> listarTodos() {
        return repositorioArtista.listarTodos();
    }


    public Artista buscarPorId(long id){
        return repositorioArtista.buscarPorId(id);
    }}
