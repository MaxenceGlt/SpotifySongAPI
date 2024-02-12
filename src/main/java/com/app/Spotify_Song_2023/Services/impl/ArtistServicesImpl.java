package com.app.Spotify_Song_2023.Services.impl;

import com.app.Spotify_Song_2023.Exception.ArtistsException;
import com.app.Spotify_Song_2023.Repository.SpotifySongRepository;
import com.app.Spotify_Song_2023.Services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServicesImpl implements ArtistService {

    @Autowired
    SpotifySongRepository spotifySongRepository;

    public List<String> getAllArtists() throws ArtistsException {
        try {
            return spotifySongRepository.findAllArtistsNameDistinct();
        }catch (Exception e){
            throw  new ArtistsException("Il n'y a pas d'artiste", e);
        }
    }
}
