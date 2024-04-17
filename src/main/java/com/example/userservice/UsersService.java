package com.example.userservice;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private UsersMapper usersMapper;

    public UsersService(UsersMapper usersMapper){
        this.usersMapper=usersMapper;
    }

    public List<User> findByName(String nameStartsWith,String nameEndsWith){
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
}
