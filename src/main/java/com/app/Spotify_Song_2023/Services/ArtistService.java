package com.app.Spotify_Song_2023.Services;

import com.app.Spotify_Song_2023.Exception.ArtistsException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArtistService {

    List<String> getAllArtists() throws ArtistsException;
}
