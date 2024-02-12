COPY public.spotify_song (
    track_name, artist_name, artist_count, released_year,
    released_month,released_day, in_spotify_playlists,
    in_spotify_charts, streams, in_apple_playlists, in_apple_charts
    )
FROM '/csv/spotify-2023.csv'
DELIMITER ';' CSV HEADER;