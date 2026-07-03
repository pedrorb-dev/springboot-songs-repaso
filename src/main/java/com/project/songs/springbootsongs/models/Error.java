package com.project.songs.springbootsongs.models;

import java.time.LocalDate;

public class Error {
    private String message;
    private int status;
    private LocalDate date;

    public Error(String message, int status, LocalDate date) {
        this.message = message;
        this.status = status;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
