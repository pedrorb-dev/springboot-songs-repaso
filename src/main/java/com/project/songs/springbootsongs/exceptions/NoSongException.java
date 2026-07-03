package com.project.songs.springbootsongs.exceptions;

public class NoSongException extends RuntimeException {
    private String message;

    public NoSongException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
