package com.project.songs.springbootsongs.services;

import com.project.songs.springbootsongs.exceptions.NoSongException;
import com.project.songs.springbootsongs.models.Song;
import com.project.songs.springbootsongs.repositories.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    private SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> findAll() {
        return songRepository.getData();
    }

    public Song save(Song song) {

        if (songRepository.save(song)) {
            return song;
        }
        throw new NoSongException("No se pudo guardar esa canción");
    }

    public Song findById(Long id) {
        return songRepository.songById(id);
    }

    public Song updateSongById(Long id, Song song) {
        return songRepository.updateSongById(id, song);
    }

    public void deleteById(Long id) {
        songRepository.deleteById(id);
    }
}
