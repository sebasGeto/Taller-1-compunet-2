package com.example.artists.repositories;

import com.example.artists.model.Artista;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RepositorioArtista {
    private List<Artista> artistas = new ArrayList<>();
    private long currentId;

    public void guardar(Artista artista){
        currentId++;
        artista.setId(currentId);
        artistas.add(artista);
    }

    public Artista buscarPorId(long id){
        return artistas.stream().filter(u -> u.getId() == id).findFirst().get();
    }

    public List<Artista> listarTodos() {
        return artistas;
    }

    public void eliminar(long id){
        Artista artista = artistas.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
        if (artista != null) {
            artistas.remove(artista);
        }

    }


}
