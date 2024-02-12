package com.app.Spotify_Song_2023.Services;

import com.app.Spotify_Song_2023.Exception.ArtistsException;
import com.app.Spotify_Song_2023.Repository.SpotifySongRepository;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.app.Spotify_Song_2023.Services.impl.ArtistServicesImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ArtistServiceTest {

    @MockBean
    private SpotifySongRepository spotifySongRepository;

    @Autowired
    private ArtistService artistService;

    @Test
    void getAllArtistName() throws ArtistsException {
        //Asserts
        List<String> newListArtist = new ArrayList<>();
        newListArtist.add("artiste1");
        //When
        Mockito.when(spotifySongRepository.findAllArtistsNameDistinct()).thenReturn(newListArtist);
        List<String> listTest = artistService.getAllArtists();
        //Then
        assertEquals(newListArtist.get(0),listTest.get(0));
    }

    @Test
    void testGetAllArtistsThrowsException() {
        // Configuration du mock pour simuler une exception lors de l'appel à findAllArtistsNameDistinct()
        Mockito.when(spotifySongRepository.findAllArtistsNameDistinct()).thenThrow(new RuntimeException("Une exception simulée"));

        // Vérification que la méthode lance ArtistsException avec le message attendu
        ArtistsException exception = assertThrows(ArtistsException.class, () -> artistService.getAllArtists());
        String expectedMessage = "Il n'y a pas d'artiste";
        String actualMessage = exception.getMessage();
        assertEquals(actualMessage,expectedMessage);
    }
}
