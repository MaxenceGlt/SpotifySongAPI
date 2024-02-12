package com.app.Spotify_Song_2023.Controllers;

import com.app.Spotify_Song_2023.Exception.ArtistsException;
import com.app.Spotify_Song_2023.Services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api")
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @GetMapping("/artists")
    public ResponseEntity<List<String>> getArtists() throws ArtistsException {
        try {
            List<String> allArtists = artistService.getAllArtists();
            if(!allArtists.isEmpty()){
                return ResponseEntity.ok(allArtists);
            }
            else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            }
        }catch (ArtistsException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }

    }

}
