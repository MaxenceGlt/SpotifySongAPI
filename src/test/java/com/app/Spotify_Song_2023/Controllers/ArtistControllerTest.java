package com.app.Spotify_Song_2023.Controllers;

import com.app.Spotify_Song_2023.Services.ArtistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ArtistControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    ArtistService artistService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void givenArtists_whenGetArtists_thenStatus200() throws Exception {

        List<String> mockArtist = new ArrayList<String>();
        mockArtist.add("Artist1");
        mockArtist.add("Artist2");
        mockArtist.add("Artist3");
        Mockito.when(artistService.getAllArtists()).thenReturn(mockArtist);

        final String expectedResponse = objectMapper.writeValueAsString(mockArtist);

        mvc.perform(MockMvcRequestBuilders.get("/api/artists")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().json(expectedResponse));
        ;
    }
}
