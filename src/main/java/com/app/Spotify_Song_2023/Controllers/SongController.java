package com.app.Spotify_Song_2023.Controllers;

import com.app.Spotify_Song_2023.Exception.ArtistsException;
import com.app.Spotify_Song_2023.Services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api")
public class SongController {

    @Autowired
    SongService songService;

    @GetMapping("/songs")
    public ResponseEntity<?> getSongPageable(
            @RequestParam(value = "page", defaultValue = "0", required = true) int pageNumber,
            @RequestParam(value = "size", defaultValue = "10", required = true) int pageSize,
            @RequestParam(value = "sort", defaultValue = "id", required = false) String sortField,
            @RequestParam(value = "direction", defaultValue = "asc", required = false) String sortDirection
    ) throws ArtistsException {
        Sort sort = Sort.by(sortDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortField);
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, sort);
        return ResponseEntity.ok(songService.getFamousSongPageable(pageRequest));
    }

    @GetMapping("/songs/details")
    public ResponseEntity<?> getSongPageableContainingTrackName(
            @RequestParam(value = "page", defaultValue = "0", required = true) int pageNumber,
            @RequestParam(value = "size", defaultValue = "10", required = true) int pageSize,
            @RequestParam(value = "sort", defaultValue = "id", required = false) String sortField,
            @RequestParam(value = "direction", defaultValue = "asc", required = false) String sortDirection,
            @RequestParam(value = "trackName", required = true) String trackName
    ) throws ArtistsException {
        Sort sort = Sort.by(sortDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortField);
        Pageable pageRequest = PageRequest.of(pageNumber, pageSize, sort);
        return ResponseEntity.ok(songService.getFamousSongPageableContainsTrackName(pageRequest, trackName));
    }

    @GetMapping("/song/{id}")
    public ResponseEntity<?> getSongById(@PathVariable("id") Long songId) throws ArtistsException {
        return ResponseEntity.ok(songService.getFamousSongById(songId));
    }
}
