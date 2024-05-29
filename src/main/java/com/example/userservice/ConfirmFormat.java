package com.example.userservice;

public class ConfirmFormat {
    public static String formatName(String name) {
        if(name != null){
            return name;
        }
        else{
            throw new BadRequestException("Name cannot be null");
        }
    }

    public static String formatPhone(String phone) {
        if(phone != null){
            return phone;
        }
        else{
            throw new BadRequestException("Phone cannot be null");
        }
    }
}
