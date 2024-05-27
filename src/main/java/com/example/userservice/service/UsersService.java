package com.example.userservice.service;

import com.example.userservice.BadRequestException;
import com.example.userservice.controller.response.UserResponse;
import com.example.userservice.entity.User;
import com.example.userservice.UserNotFoundException;
import com.example.userservice.mapper.UsersMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private UsersMapper usersMapper;

    public UsersService(UsersMapper usersMapper){
        this.usersMapper=usersMapper;
    }

    public String body;

    public User user;

    public String phone;

    public HttpStatus status;

    public List<User> findByName(String nameStartsWith, String nameEndsWith){
        if (nameStartsWith != null && nameEndsWith != null) {
            return usersMapper.findByNameStartingAndEnding(nameStartsWith, nameEndsWith);
        }
        else if (nameStartsWith != null) {
            return usersMapper.findByNameStartingWith(nameStartsWith);
        }
        else if (nameEndsWith != null) {
            return usersMapper.findByNameEndingWith(nameEndsWith);
        }
        else {
            return usersMapper.findAll();
        }
    }

    public User findUser(int id){
        return usersMapper.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public User userInsert(String name,String phone) {
        Optional<User> userOptional=usersMapper.findByPhone(phone);

        if ((name == null || name.isEmpty()) && (phone == null  || phone.isEmpty())) {
            throw new  BadRequestException("name and phone cannot be null");
        }
        else if (name == null || name.isEmpty()) {
            throw new  BadRequestException("name cannot be null");
        }
        else if (phone == null || phone.isEmpty()) {
            throw new  BadRequestException("phone cannot be null");
        }
        else if (userOptional.isPresent()) {
            throw new  BadRequestException("The phone is being used");
        }
        else {
            this.user = new User(name, phone);
            usersMapper.insert(user);
            this.body="user created";
            return user;
        }
    }

    public User userPatch(int id,String name,String phone) {
        Optional<User> updateUser = usersMapper.findById(id);

        if (updateUser.isPresent()) {
            if ((name == null || phone == null ) || (name.isEmpty() && phone.isEmpty())) {
                throw new  BadRequestException("name and phone cannot be null");
            }
            else if (name.isEmpty()) {
                this.user = new User(id,name, phone);
                usersMapper.updatePhone(user);
                this.body="user's phone updated";
                return user;
            }
            else if (phone.isEmpty()) {
                this.user = new User(id,name, phone);
                usersMapper.updateName(user);
                this.body="user's name updated";
                return user;
            }
            else{
                this.user = new User(id,name, phone);
                usersMapper.update(user);
                this.body="user updated";
                return user;
            }
        }
        else {
            throw new UserNotFoundException("User not found");
        }
    }

    public User userDelete(int id){
        Optional<User> deleteUser = usersMapper.findById(id);
        if(deleteUser.isPresent()) {
            usersMapper.deleteById(id);
            return user;
        }
        else{
            throw new UserNotFoundException("User not found");
        }
    }

    public String getBody(){
        return body;
    }

    public HttpStatus getStatus(){
        return  status;
    }
}
