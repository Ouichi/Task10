package com.example.userservice;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    private UsersService usersService;

    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @GetMapping("/users")
    public List<User> findByName(@RequestParam(required = false)String nameStartsWith,@RequestParam(required = false)String nameEndsWith){
        return usersService.findByName(nameStartsWith,nameEndsWith);
    }

    @GetMapping("/users/{id}")
    public User findUser(@PathVariable("id")int id){
        return usersService.findUser(id);
    }
}
