package com.example.userservice.controller.response;

public class UserResponse {

    private String message;

    public UserResponse(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }
}
