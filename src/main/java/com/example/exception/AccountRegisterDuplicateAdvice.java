package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(value=HttpStatus.CONFLICT, reason="Username already exists.")
public class AccountRegisterDuplicateAdvice {
    @ExceptionHandler(AccountRegisterDuplicateException.class)
    String accountRegisterHandler(AccountRegisterDuplicateException ex) {
      return ex.getMessage();
    } 
}
