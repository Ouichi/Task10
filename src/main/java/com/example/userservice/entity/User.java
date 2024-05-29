package com.example.userservice.entity;

import com.example.userservice.ConfirmFormat;

public class User{

    private Integer id;

    private String name;

    private String phone;

    public User(Integer id,String name,String phone){
        this.id=id;
        this.name=ConfirmFormat.formatName(name);
        this.phone=ConfirmFormat.formatPhone(phone);
    }

    public User(String name,String phone){
        this.name=ConfirmFormat.formatName(name);
        this.phone=ConfirmFormat.formatPhone(phone);
    }

    public Integer getId(){
        return id;
    }
}
