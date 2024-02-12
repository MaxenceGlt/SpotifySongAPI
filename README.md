# SpotifySongAPI

SpotifySongAPI est une application Java Spring Boot qui fournit une API permettant de récupérer les chansons populaires de l'année 2023 depuis Spotify. Cette API permet aux utilisateurs d'interagir avec les données des chansons, y compris leurs titres, artistes et autres métadonnées pertinentes.

## Technologies utilisées

- **Java 17**: Langage de programmation principal utilisé pour le développement de l'application.
- **Spring Boot**: Framework Java pour la création d'applications web et API RESTful.
- **Docker**: Utilisé pour la conteneurisation de l'application, offrant une portabilité et une facilité de déploiement.
- **Spotify API**: Intégration avec l'API de Spotify pour récupérer les données sur les chansons.

## Fonctionnalités

- **Récupération des chansons populaires de 2023**: L'API permet aux utilisateurs de récupérer la liste des chansons les plus populaires de l'année 2023 depuis Spotify.
- **Détails des chansons individuelles**: Les utilisateurs peuvent obtenir des détails sur une chanson spécifique, y compris son titre, ses artistes, son album, etc.

## Utilisation

1. Assurez-vous d'avoir Java 17 installé sur votre système.
2. Clonez ce dépôt Git sur votre machine locale.
3. Accédez au répertoire du projet dans votre terminal.
4. Construisez l'image Docker en exécutant la commande :
```java
docker build -t spotify-song-api .
```
5. Lancez le conteneur Docker en exécutant la commande :
``` java
docker run -p 8080:8080 spotify-song-api
```

6. L'API sera disponible à l'adresse suivante : `http://localhost:8080`

## Endpoints

- **GET /api/songs**: Récupère la liste des chansons populaires de l'année 2023.
- **GET /api/song/{id}**: Récupère les détails d'une chanson spécifique en fonction de son identifiant.

## Exemple d'utilisation

### Récupération des chansons populaires
```java
GET http://localhost:8080/api/songs
```
Réponse :
```json
[
    {
    "id": 1,
    "track_name": "Titre de la chanson",
    "artist_name": "Artiste 1, Artiste 2",
    "artist_count": 2,
    "released": "2023-01-01",
    "in_spotify_playlists": 1338,
    "in_spotify_charts": 1233,
    "streams": 22332,
    "in_apple_playlists": 1483,
    "in_apple_playlists": 832,
},
    {
    "id": 2,
    "track_name": "Titre de la chanson 2",
    "artist_name": "Artiste 1",
    "artist_count": 1,
    "released": "2023-02-01",
    "in_spotify_playlists": 9433,
    "in_spotify_charts": 4833,
    "streams": 22332,
    "in_apple_playlists": 42428,
    "in_apple_playlists": 23822,
}
```
### Récupération des détails d'une chanson spécifique
```java
GET http://localhost:8080/api/songs/1
```
Réponse : 
```json
{
    "id": 1,
    "track_name": "Titre de la chanson",
    "artist_name": "Artiste 1, Artiste 2",
    "artist_count": 2,
    "released": "2023-01-01",
    "in_spotify_playlists": 22332,
    "in_spotify_charts": 12783,
    "streams": 22332,
    "in_apple_playlists": 19349,
    "in_apple_playlists": 12934,
}
```


