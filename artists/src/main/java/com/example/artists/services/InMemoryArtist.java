package com.example.artists.services;

import com.example.artists.model.Artista;
import org.springframework.stereotype.Component;

@Component("Validator")
public class InMemoryArtist implements Validator{
    @Override
    public boolean validate(Artista artista) {
        return !artista.getPistas().isEmpty();
    }
}
