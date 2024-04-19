package com.example.userservice;

public class UsersRequest {

    private String name;

    private String phone;

    public UsersRequest(String name,String phone){
        this.name=name;
        this.phone=phone;
    }

    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }
}

