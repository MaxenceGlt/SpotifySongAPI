-- Ce fichier va créer la table qui va recevoir les données en provenance du fichier data.csv
-- Il sera passé en paramètre au service postgresql retrouve dans le fichier docker-compose.yml
SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

ALTER SCHEMA public OWNER TO pg_database_owner;

COMMENT ON SCHEMA public IS 'standard public schema';

CREATE TABLE IF NOT EXISTS public.spotify_song ( id serial PRIMARY KEY ,
 track_name character varying(250) NOT NULL,
 artist_name character varying(250) NOT NULL,
 artist_count integer NOT NULL,
 released_year character varying(250) NOT NULL,
 released_month character varying(250) NOT NULL,
 released_day character varying(250) NOT NULL,
 in_spotify_playlists BIGINT,
 in_spotify_charts BIGINT,
 streams BIGINT,
 in_apple_playlists BIGINT,
 in_apple_charts BIGINT );

ALTER TABLE public.spotify_song OWNER TO postgres_db;