package com.example.chatapp_be.exception;

public class BadRequest extends RuntimeException{

    public BadRequest(String message) {
        super(message);
    }
}
