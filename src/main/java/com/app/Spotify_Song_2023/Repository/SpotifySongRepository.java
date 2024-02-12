package com.app.Spotify_Song_2023.Repository;

import com.app.Spotify_Song_2023.Models.SpotifySong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpotifySongRepository extends JpaRepository<SpotifySong, Long> {

    @Query("SELECT DISTINCT artist_name  FROM SpotifySong ")
    List<String> findAllArtistsNameDistinct() throws RuntimeException;

    @Query("SELECT s FROM SpotifySong s WHERE LOWER(s.track_name) LIKE LOWER(CONCAT('%', :track_name, '%'))")
    Page<SpotifySong> findByTrackNameContainingIgnoreCase(String track_name, Pageable pageRequest);
}
