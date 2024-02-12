package com.app.Spotify_Song_2023.Services;

import com.app.Spotify_Song_2023.DTO.SpotifySongDTO;
import com.app.Spotify_Song_2023.Models.SpotifySong;
import com.app.Spotify_Song_2023.Repository.SpotifySongRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SongServiceTest {

    @MockBean
    SpotifySongRepository spotifySongRepository;

    @Autowired
    SongService songService;

    @Test
    void getAllSong() throws DataAccessException {
        //Assert
        SpotifySong item1 = new SpotifySong(1L, "olala", "sardou,Elfenomeno", 2,
                "2020","10","20", 50, 1789,
                678322L, 189, 1389 );

        SpotifySong item2 = new SpotifySong(2L, "le miradore", "artist2, breztel", 2,
                "2022","11","08", 23, 179,
                123342L, 12, 103 );
        List<SpotifySong> getAllFamousSong = new ArrayList<>();
        getAllFamousSong.add(item1);
        getAllFamousSong.add(item2);
        LocalDate date1 = LocalDate.of(2020,10, 20);
        LocalDate date2 = LocalDate.of(2022,11, 8);
        //When
        Mockito.when(spotifySongRepository.findAll()).thenReturn(getAllFamousSong);
        List<SpotifySongDTO> famousSongs = songService.getAllFamousSong();
        //Then
        assertEquals("sardou", famousSongs.get(0).getArtist_name().get(0));
        assertEquals("Elfenomeno", famousSongs.get(0).getArtist_name().get(1));
        assertEquals(date1, famousSongs.get(0).getReleased());

        assertEquals("artist2", famousSongs.get(1).getArtist_name().get(0));
        assertEquals("breztel", famousSongs.get(1).getArtist_name().get(1));
        assertEquals(date2, famousSongs.get(1).getReleased());
    }
}
