package com.example.artists.repositories;

import com.example.artists.model.Pista;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RepositorioPista {
    private List<Pista> pistas = new ArrayList<>();
    private long currentId;

    public void guardar(Pista pista){
        currentId++;
        pista.setId(currentId);
        pistas.add(pista);
    }

    public Pista buscarPorId(long id){
        return pistas.stream().filter(u -> u.getId() == id).findFirst().orElseThrow(() -> new RuntimeException("Pista no encontrada"));
    }

    public List<Pista> listarTodos() {
        return pistas;
    }

    public void eliminar(long id){
        Pista pista = pistas.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
        if (pista != null) {
            pistas.remove(pista);
        }

    }
}
