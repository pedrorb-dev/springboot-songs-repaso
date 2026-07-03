package com.project.songs.springbootsongs.models;

import java.util.Objects;

public class Song {
    private Long id_song;
    private String title;
    private String artist;
    private String album;
    private Long year;

    public Song() {
    }

    public Song(Long id_song, String title, String artist, String album, Long year) {
        this.id_song = id_song;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.year = year;
    }

    public Song(Long id_song) {
        this.id_song = id_song;
    }

    public Long getId_song() {
        return id_song;
    }

    public void setId_song(Long id_song) {
        this.id_song = id_song;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(id_song, song.id_song);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_song);
    }
}