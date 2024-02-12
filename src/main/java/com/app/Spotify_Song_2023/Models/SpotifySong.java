package com.app.Spotify_Song_2023.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "spotify_song")
public class SpotifySong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "track_name")
    private String track_name;

    @Column(name = "artist_name")
    private String artist_name;

    @Column(name = "artist_count")
    private Integer artist_count;

    @Column(name = "released_year")
    private String released_year;

    @Column(name = "released_month")
    private String released_month;

    @Column(name = "released_day")
    private String released_day;

    @Column(name = "in_spotify_playlists")
    private Integer in_spotify_playlists;

    @Column(name = "in_spotify_charts")
    private Integer in_spotify_charts;

    @Column(name = "streams")
    private Long streams;

    @Column(name = "in_apple_playlists")
    private Integer in_apple_playlists;

    @Column(name = "in_apple_charts")
    private Integer in_apple_charts;

    public SpotifySong() {
    }

    public SpotifySong(Long id, String track_name, String artist_name, Integer artist_count, String released_year, String released_month, String released_day, Integer in_spotify_playlists, Integer in_spotify_charts, Long streams, Integer in_apple_playlists, Integer in_apple_charts) {
        this.id = id;
        this.track_name = track_name;
        this.artist_name = artist_name;
        this.artist_count = artist_count;
        this.released_year = released_year;
        this.released_month = released_month;
        this.released_day = released_day;
        this.in_spotify_playlists = in_spotify_playlists;
        this.in_spotify_charts = in_spotify_charts;
        this.streams = streams;
        this.in_apple_playlists = in_apple_playlists;
        this.in_apple_charts = in_apple_charts;
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

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public Integer getArtist_count() {
        return artist_count;
    }

    public void setArtist_count(Integer artist_count) {
        this.artist_count = artist_count;
    }

    public String getReleased_year() {
        return released_year;
    }

    public void setReleased_year(String released_year) {
        this.released_year = released_year;
    }

    public String getReleased_month() {
        return released_month;
    }

    public void setReleased_month(String released_month) {
        this.released_month = released_month;
    }

    public String getReleased_day() {
        return released_day;
    }

    public void setReleased_day(String released_day) {
        this.released_day = released_day;
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



    @Override
    public String toString() {
        return "SpotifySong{" +
                "id=" + id +
                ", track_name='" + track_name + '\'' +
                ", artist_name='" + artist_name + '\'' +
                ", artist_count=" + artist_count +
                ", released_year=" + released_year +
                ", released_month=" + released_month +
                ", released_day=" + released_day +
                ", in_spotify_playlists=" + in_spotify_playlists +
                ", in_spotify_charts=" + in_spotify_charts +
                ", streams=" + streams +
                ", in_apple_playlists=" + in_apple_playlists +
                ", in_apple_charts=" + in_apple_charts +
                '}';
    }
}
