package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Unsuccessful registration.")
public class AccountRegisterGeneralAdvice {
    @ExceptionHandler(AccountRegisterGeneralException.class)
    String accountRegisterHandler(AccountLoginException ex) {
      return ex.getMessage();
    } 
}
