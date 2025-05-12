package com.example.exception;

public class AccountRegisterGeneralException extends RuntimeException {
    public AccountRegisterGeneralException() {
        super("Could not register account.");
      } 
}