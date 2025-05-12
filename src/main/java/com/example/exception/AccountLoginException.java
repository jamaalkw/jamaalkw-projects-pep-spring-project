package com.example.exception;

public class AccountLoginException extends RuntimeException {
    public AccountLoginException() {
        super("Could not login to account.");
      } 
}