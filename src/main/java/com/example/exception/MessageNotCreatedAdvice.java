package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Invalid message contents.")
public class MessageNotCreatedAdvice {
    @ExceptionHandler(MessageNotCreatedException.class)
    String messageNotCreatedHandler(MessageNotCreatedException ex) {
      return ex.getMessage();
    } 
}