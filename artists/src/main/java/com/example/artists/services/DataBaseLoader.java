package com.example.artists.services;

import com.example.artists.model.Artista;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DataBaseLoader implements Validator{

    @Value("${pista.minimum.total}")
    private int cantidad;

    @Override
    public boolean validate(Artista artista) {
        Artista a = new Artista();
        return a.getPistas().size() < cantidad;
    }
}
