package com.project.songs.springbootsongs.controllers;

import com.project.songs.springbootsongs.exceptions.NoSongException;
import com.project.songs.springbootsongs.models.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<?> error404(NoHandlerFoundException e) {
        Error error = new Error(e.getMessage(), HttpStatus.NOT_FOUND.value(), LocalDate.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(NoSongException.class)
    public ResponseEntity<Map<String, Object>> handlerException(NoSongException e) {
        Map<String, Object> error = new HashMap<>();
        error.put("mensaje", e.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.put("date", LocalDate.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> handleNotSuportedException(HttpRequestMethodNotSupportedException e) {
        Error error = new Error(e.getMessage(), HttpStatus.METHOD_NOT_ALLOWED.value(), LocalDate.now());
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(error);
    }
}
