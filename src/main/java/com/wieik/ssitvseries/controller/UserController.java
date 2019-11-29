package com.wieik.ssitvseries.controller;

import com.wieik.ssitvseries.Service.UserService;
import com.wieik.ssitvseries.entity.UserEntity;
import com.wieik.ssitvseries.json.UserJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public void saveUser(@RequestBody UserJson userJson){
        userService.saveUser(userJson);
    }

    @PutMapping("/{userId}/friends/{friendId}")
    public void addFriend(@PathVariable int userId, @PathVariable int friendId){
        userService.addFriend(userId, friendId);
    }




}
