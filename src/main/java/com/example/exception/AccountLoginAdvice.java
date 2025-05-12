package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(value=HttpStatus.UNAUTHORIZED, reason="Unsuccessful login.")
public class AccountLoginAdvice {
    @ExceptionHandler(AccountLoginException.class)
    String accountLoginHandler(AccountLoginException ex) {
      return ex.getMessage();
    } 
}
