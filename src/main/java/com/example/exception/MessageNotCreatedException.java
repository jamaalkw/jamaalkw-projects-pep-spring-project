package com.example.exception;

public class MessageNotCreatedException extends RuntimeException {
    public MessageNotCreatedException() {
      super("Could not create message.");
    }
  }