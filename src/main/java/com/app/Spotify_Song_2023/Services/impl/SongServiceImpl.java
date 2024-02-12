package com.app.Spotify_Song_2023.Services.impl;

import com.app.Spotify_Song_2023.DTO.SpotifySongDTO;
import com.app.Spotify_Song_2023.Models.SpotifySong;
import com.app.Spotify_Song_2023.Repository.SpotifySongRepository;
import com.app.Spotify_Song_2023.Services.SongService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SpotifySongRepository spotifySongRepository;

    public List<SpotifySongDTO> getAllFamousSong() throws DataAccessException {
        List<SpotifySong> listOfAllFamousSong = spotifySongRepository.findAll();
        return transormSpotifySongToDTO(listOfAllFamousSong);
    }

    public Page<SpotifySongDTO> getFamousSongPageable(PageRequest pageRequest){
        Page<SpotifySong> spotifySongPage = spotifySongRepository.findAll(pageRequest);
        return transformSpotifySongPageableToDTO(spotifySongPage);
    }

    public Page<SpotifySongDTO> getFamousSongPageableContainsTrackName(Pageable pageable, String trackName){
        Page<SpotifySong> spotifySongPageContainsTrackName = spotifySongRepository.findByTrackNameContainingIgnoreCase(trackName, pageable);
        return transformSpotifySongPageableToDTO(spotifySongPageContainsTrackName);
    }

    public SpotifySongDTO getFamousSongById(Long songId){
        Optional<SpotifySong> spotifySongRepo = spotifySongRepository.findById(songId);
        SpotifySong spotifySong = spotifySongRepo.orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + songId));
        return transormSpotifySongToDTOSingle(spotifySong);
    }

    private List<SpotifySongDTO> transormSpotifySongToDTO(List<SpotifySong> spotifySongList){
        List<SpotifySongDTO> listOfAllFamousSongDTO = new ArrayList<>();
        for(SpotifySong item : spotifySongList){
            LocalDate dateOfRelease = LocalDate.of(Integer.parseInt(item.getReleased_year()),
                    Integer.parseInt(item.getReleased_month()), Integer.parseInt(item.getReleased_day()));

            List<String> listOfArtist = Arrays.stream(item.getArtist_name().trim().split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
            SpotifySongDTO spotifySongDTO = new SpotifySongDTO();
            spotifySongDTO.setId(item.getId());
            spotifySongDTO.setTrack_name(item.getTrack_name());
            spotifySongDTO.setArtist_name(listOfArtist);
            spotifySongDTO.setReleased(dateOfRelease);
            spotifySongDTO.setArtist_count(item.getArtist_count());
            spotifySongDTO.setStreams(item.getStreams());
            spotifySongDTO.setIn_spotify_charts(item.getIn_spotify_charts());
            spotifySongDTO.setIn_spotify_playlists(item.getIn_spotify_playlists());
            spotifySongDTO.setIn_apple_charts(item.getIn_apple_charts());
            spotifySongDTO.setIn_apple_playlists(item.getIn_apple_playlists());
            listOfAllFamousSongDTO.add(spotifySongDTO);
        }
        return listOfAllFamousSongDTO;
    }

    private SpotifySongDTO transormSpotifySongToDTOSingle(SpotifySong spotifySong){
        SpotifySongDTO spotifySongDTO = new SpotifySongDTO();
        LocalDate dateOfRelease = LocalDate.of(Integer.parseInt(spotifySong.getReleased_year()),
                    Integer.parseInt(spotifySong.getReleased_month()),
                    Integer.parseInt(spotifySong.getReleased_day()));
        List<String> listOfArtist = Arrays.stream(spotifySong.getArtist_name().trim().split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        spotifySongDTO.setId(spotifySong.getId());
        spotifySongDTO.setTrack_name(spotifySong.getTrack_name());
        spotifySongDTO.setArtist_name(listOfArtist);
        spotifySongDTO.setReleased(dateOfRelease);
        spotifySongDTO.setArtist_count(spotifySong.getArtist_count());
        spotifySongDTO.setStreams(spotifySong.getStreams());
        spotifySongDTO.setIn_spotify_charts(spotifySong.getIn_spotify_charts());
        spotifySongDTO.setIn_spotify_playlists(spotifySong.getIn_spotify_playlists());
        spotifySongDTO.setIn_apple_charts(spotifySong.getIn_apple_charts());
        spotifySongDTO.setIn_apple_playlists(spotifySong.getIn_apple_playlists());
        return spotifySongDTO;
    }

    private Page<SpotifySongDTO> transformSpotifySongPageableToDTO(Page<SpotifySong> spotifySongPage) {
        List<SpotifySongDTO> listOfAllFamousSongDTO = spotifySongPage.getContent().stream()
                .map(item -> {
                    LocalDate dateOfRelease = LocalDate.of(Integer.parseInt(item.getReleased_year()),
                            Integer.parseInt(item.getReleased_month()), Integer.parseInt(item.getReleased_day()));

                    List<String> listOfArtist = Arrays.stream(item.getArtist_name().trim().split(","))
                            .map(String::trim)
                            .collect(Collectors.toList());
                    SpotifySongDTO spotifySongDTO = new SpotifySongDTO();
                    spotifySongDTO.setId(item.getId());
                    spotifySongDTO.setTrack_name(item.getTrack_name());
                    spotifySongDTO.setArtist_name(listOfArtist);
                    spotifySongDTO.setReleased(dateOfRelease);
                    spotifySongDTO.setArtist_count(item.getArtist_count());
                    spotifySongDTO.setStreams(item.getStreams());
                    spotifySongDTO.setIn_spotify_charts(item.getIn_spotify_charts());
                    spotifySongDTO.setIn_spotify_playlists(item.getIn_spotify_playlists());
                    spotifySongDTO.setIn_apple_charts(item.getIn_apple_charts());
                    spotifySongDTO.setIn_apple_playlists(item.getIn_apple_playlists());
                    return spotifySongDTO;
                })
                .collect(Collectors.toList());
        return new PageImpl<>(listOfAllFamousSongDTO, spotifySongPage.getPageable(), spotifySongPage.getTotalElements());
    }

}
