package com.example.userservice.controller;

import com.example.userservice.UserNotFoundException;
import com.example.userservice.entity.User;
import com.example.userservice.controller.response.UserResponse;
import com.example.userservice.controller.request.UsersRequest;
import com.example.userservice.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UsersController {

    private UsersService usersService;

    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @GetMapping("/users")
    public List<User> findByName(@RequestParam(required = false)String nameStartsWith, @RequestParam(required = false)String nameEndsWith){
        return usersService.findByName(nameStartsWith,nameEndsWith);
    }

    @GetMapping("/users/{id}")
    public User findUser(@PathVariable("id")int id){
        return usersService.findUser(id);
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponse> insert(@RequestBody UsersRequest userRequest, UriComponentsBuilder uriBuilder) {
        User user = usersService.userInsert(userRequest.getName(), userRequest.getPhone());
        UserResponse body = new UserResponse(usersService.getBody());
            if(user == null){
                 return ResponseEntity.status(usersService.getStatus()).body(body);
            }
            else{
                URI location = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
                return ResponseEntity.created(location).body(body);
            }
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<UserResponse> patchUser(@PathVariable("id")int id,@RequestBody UsersRequest userRequest){
        User user = usersService.userPatch(id,userRequest.getName(), userRequest.getPhone());
        UserResponse body = new UserResponse(usersService.getBody());
        if(user == null){
            return ResponseEntity.status(usersService.getStatus()).body(body);
        }
        else{
            return ResponseEntity.ok().body(body);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<UserResponse> delete(@PathVariable("id")int id){
        User user = usersService.userDelete(id);
        UserResponse body = new UserResponse(usersService.getBody());
        if(user == null){
            return ResponseEntity.status(usersService.getStatus()).body(body);
        }
        else{
            return ResponseEntity.status(usersService.getStatus()).body(body);
        }
    }
}
