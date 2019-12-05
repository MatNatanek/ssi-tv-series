package com.wieik.ssitvseries.controller;

import com.wieik.ssitvseries.Service.UserService;
import com.wieik.ssitvseries.entity.EpisodeEntity;
import com.wieik.ssitvseries.entity.UserEntity;
import com.wieik.ssitvseries.model.User;
import com.wieik.ssitvseries.model.UserWithUWF;
import com.wieik.ssitvseries.model.UserWithoutFriends;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserWithUWF> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @PutMapping
    public void updateUser(@RequestBody UserEntity userEntity){
        userService.updateUser(userEntity);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable int userId){
        userService.deleteUser(userId);
    }

    @GetMapping("/{userId}/friends")
    public Set<UserWithoutFriends> getFriends(@PathVariable int userId){
        return userService.getFriends(userId);
    }

    @PutMapping("/{userId}/friends/{friendId}")
    public void addFriend(@PathVariable int userId, @PathVariable int friendId){
        userService.addFriend(userId, friendId);
    }

    @DeleteMapping("/{userId}/friends/{friendId}")
    public void removeFriend(@PathVariable int userId, @PathVariable int friendId){
        userService.removeFriend(userId, friendId);
    }

    @GetMapping("/{userId}/episodes/")
    public Set<EpisodeEntity> getWatchedEpisodes(@PathVariable int userId){
        return userService.getWatchedEpisodes(userId);
    }

    @PutMapping("/{userId}/episodes/{episodeId}")
    public void addEpisodeToWatched(@PathVariable int userId, @PathVariable int episodeId ){
        userService.addEpisodeToWatched(userId, episodeId);
    }



}
