package com.project.songs.springbootsongs.repositories;

import com.project.songs.springbootsongs.exceptions.NoSongException;
import com.project.songs.springbootsongs.models.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class SongRepository {
    List<Song> data;
    public SongRepository() {
        data = new ArrayList<>(List.of(
                new Song(1L, "californication", "rhcp", "californication", 2000L),
                new Song(2L, "otherside", "rhcp", "californication", 2000L),
                new Song(3L, "baile inolvidable", "bad bunny", "dtmf", 2024L),
                new Song(4L, "midnight city", "m83", "hurry up, we're dreaming", 2024L)
        ));
    }

    public List<Song> getData() {
        return data;
    }

    public boolean save(Song song) {
        return data.add(song);
    }

    public Song songById(Long id) {
        for(Song song : data) {
            if(song.getId_song().equals(id)) {
                return song;
            }
        }
        throw new NoSongException("No existe una canción con esa id");
    }

    public Song updateSongById(Long id, Song song) {
        Song songToUpdate = songById(id);
        songToUpdate.setTitle(song.getTitle());
        songToUpdate.setAlbum(song.getAlbum());
        songToUpdate.setArtist(song.getArtist());
        songToUpdate.setYear(song.getYear());
        return songToUpdate;
    }

    public void deleteById(Long id) {
        Song songToDelete = songById(id);
        data.remove(songToDelete);
    }
}
