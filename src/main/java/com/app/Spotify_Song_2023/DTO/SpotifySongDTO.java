package com.app.Spotify_Song_2023.DTO;

import jakarta.persistence.Column;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class SpotifySongDTO {

    private Long id;
    private String track_name;
    private List<String> artist_name;
    private Integer artist_count;
    private LocalDate released;
    private Integer in_spotify_playlists;
    private Integer in_spotify_charts;
    private Long streams;
    private Integer in_apple_playlists;
    private Integer in_apple_charts;

    public SpotifySongDTO(Long id, String track_name, List<String> artist_name, Integer artist_count, LocalDate released, Integer in_spotify_playlists, Integer in_spotify_charts, Long streams, Integer in_apple_playlists, Integer in_apple_charts) {
        this.id = id;
        this.track_name = track_name;
        this.artist_name = artist_name;
        this.artist_count = artist_count;
        this.released = released;
        this.in_spotify_playlists = in_spotify_playlists;
        this.in_spotify_charts = in_spotify_charts;
        this.streams = streams;
        this.in_apple_playlists = in_apple_playlists;
        this.in_apple_charts = in_apple_charts;
    }

    public SpotifySongDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrack_name() {
        return track_name;
    }

    public void setTrack_name(String track_name) {
        this.track_name = track_name;
    }

    public List<String> getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(List<String> artist_name) {
        this.artist_name = artist_name;
    }

    public Integer getArtist_count() {
        return artist_count;
    }

    public void setArtist_count(Integer artist_count) {
        this.artist_count = artist_count;
    }

    public LocalDate getReleased() {
        return released;
    }

    public void setReleased(LocalDate released) {
        this.released = released;
    }

    public Integer getIn_spotify_playlists() {
        return in_spotify_playlists;
    }

    public void setIn_spotify_playlists(Integer in_spotify_playlists) {
        this.in_spotify_playlists = in_spotify_playlists;
    }

    public Integer getIn_spotify_charts() {
        return in_spotify_charts;
    }

    public void setIn_spotify_charts(Integer in_spotify_charts) {
        this.in_spotify_charts = in_spotify_charts;
    }

    public Long getStreams() {
        return streams;
    }

    public void setStreams(Long streams) {
        this.streams = streams;
    }

    public Integer getIn_apple_playlists() {
        return in_apple_playlists;
    }

    public void setIn_apple_playlists(Integer in_apple_playlists) {
        this.in_apple_playlists = in_apple_playlists;
    }

    public Integer getIn_apple_charts() {
        return in_apple_charts;
    }

    public void setIn_apple_charts(Integer in_apple_charts) {
        this.in_apple_charts = in_apple_charts;
    }
}
