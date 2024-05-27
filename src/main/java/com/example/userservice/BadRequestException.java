package com.example.userservice;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
