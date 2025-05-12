package com.example.exception;

public class AccountRegisterDuplicateException extends RuntimeException {
    public AccountRegisterDuplicateException() {
        super("Could not register account.");
      } 
}