package com.project.songs.springbootsongs.controllers;

import com.project.songs.springbootsongs.models.Song;
import com.project.songs.springbootsongs.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping("/songs")
    public List<Song> findAll() {
        return songService.findAll();
    }

    @GetMapping("/song/{id}")
    public Song findById(@PathVariable Long id) {
        return songService.findById(id);
    }

    @PostMapping("/song/new")
    public Song createSong(@RequestBody Song song) {

        return songService.save(song);
    }

    @PutMapping("/song/update/{id}")
    public Song updateSong(@PathVariable Long id, @RequestBody Song song) {
        return songService.updateSongById(id, song);
    }

    @DeleteMapping("/song/{id}")
    public ResponseEntity<?> deleteSong(@PathVariable Long id) {
        songService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
