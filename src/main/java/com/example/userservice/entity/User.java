package com.example.userservice.entity;

public class User{

    private Integer id;

    private String name;

    private String phone;

    public User(Integer id,String name,String phone){
        this.id=id;
        this.name=name;
        this.phone=phone;
    }

    public User(String name,String phone){
        this.name=name;
        this.phone=phone;
    }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }
}
