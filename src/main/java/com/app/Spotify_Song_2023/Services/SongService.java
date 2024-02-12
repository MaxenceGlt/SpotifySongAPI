package com.app.Spotify_Song_2023.Services;

import com.app.Spotify_Song_2023.DTO.SpotifySongDTO;
import com.app.Spotify_Song_2023.Models.SpotifySong;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SongService {

    public List<SpotifySongDTO> getAllFamousSong() throws DataAccessException;

    public Page<SpotifySongDTO> getFamousSongPageable(PageRequest pageRequest);

    public Page<SpotifySongDTO> getFamousSongPageableContainsTrackName(Pageable pageRequest, String trackName);

    public SpotifySongDTO getFamousSongById(Long songId);
}
