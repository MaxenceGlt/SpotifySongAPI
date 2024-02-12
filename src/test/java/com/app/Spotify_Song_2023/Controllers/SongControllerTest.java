package com.app.Spotify_Song_2023.Controllers;

import com.app.Spotify_Song_2023.DTO.SpotifySongDTO;
import com.app.Spotify_Song_2023.Services.SongService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SongControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    SongService songService;
    private List<SpotifySongDTO> spotifySongDTOList;
    private PageRequest pageRequest;
    private PageRequest pageRequestWithSorting;
    private Sort sort;
    private Page<SpotifySongDTO> spotifySongDTOPage;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        LocalDate date1 = LocalDate.of(2020,10, 20);
        LocalDate date2 = LocalDate.of(2022,11, 8);
        List<String> artistList1 = Arrays.asList("sardou", "Elfenomeno");
        List<String> artistList2 = Arrays.asList("artist2");
        SpotifySongDTO item1 = new SpotifySongDTO(1L, "olala", artistList1, 2,
                date1, 50, 1789,
                678322L, 189, 1389 );

        SpotifySongDTO item2 = new SpotifySongDTO(2L, "le miradore", artistList2, 2,
                date2, 23, 179,
                123342L, 12, 103 );
        spotifySongDTOList = Arrays.asList(item1, item2);
        spotifySongDTOPage = new PageImpl<>(spotifySongDTOList);
        //pageRequest = PageRequest.of(0, 1);
        sort = Sort.by(Sort.Direction.DESC, "track_name");
    }

    @Test
    void shouldReturnFamousSongPageable() throws Exception {
        pageRequest = PageRequest.of(0, 2, sort);

        Mockito.doReturn(spotifySongDTOPage)
                .when(songService)
                .getFamousSongPageable(pageRequest);

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/api/songs")
                        .param("page", "0")
                        .param("size", "2")
                        .param("sort", "track_name")
                        .param("direction", "desc"));


        resultActions.andExpect(status().isOk()).andDo(print());

        verify(songService, times(1)).getFamousSongPageable(pageRequest);

    }

    @Test
    void shouldReturnFamousSongPageableContainsTrackName() throws Exception {
        Sort sort = Sort.by("id");
        PageRequest pageRequest = PageRequest.of(0, 1, sort);

        Mockito.doReturn(spotifySongDTOPage)
                .when(songService)
                .getFamousSongPageableContainsTrackName(pageRequest, "olala");

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/api/songs/details")
                .param("page", "0")
                .param("size", "1")
                .param("trackName", "olala")
                .param("sort", "id")
                .param("direction", "asc"));

        resultActions.andExpect(status().isOk()).andDo(print());

        verify(songService, times(1)).getFamousSongPageableContainsTrackName(pageRequest, "olala");

    }

    @Test
    void shouldReturnFamousSongPageableById() throws Exception {
        LocalDate date1 = LocalDate.of(2020,10, 20);
        List<String> artistList1 = Arrays.asList("artist1");
        SpotifySongDTO item1 = new SpotifySongDTO(1L, "olala", artistList1, 2,
                date1, 50, 1789,
                678322L, 189, 1389 );
        Mockito.doReturn(item1)
                .when(songService)
                .getFamousSongById(1L);
        final String expectedResponse = objectMapper.writeValueAsString(item1);
        mvc.perform(MockMvcRequestBuilders.get("/api/song/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().json(expectedResponse));
    }
}
