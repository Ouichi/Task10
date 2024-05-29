package com.example.userservice.controller.request;

import com.example.userservice.ConfirmFormat;

public class UsersRequest {

    private String name;

    private String phone;

    public UsersRequest(String name,String phone){
        this.name= ConfirmFormat.formatName(name);
        this.phone=ConfirmFormat.formatPhone(phone);
    }

    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }
}

