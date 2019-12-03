package com.wieik.ssitvseries.Service;

import com.wieik.ssitvseries.model.User;
import com.wieik.ssitvseries.model.UserWithUWF;
import com.wieik.ssitvseries.model.UserWithoutFriends;

import java.util.List;
import java.util.Set;

public interface UserService {

    List<UserWithUWF> getUsers();

    void saveUser(User userJson);

    void addFriend(int userId, int friendId);

    void removeFriend(int userId, int friendId);

    Set<UserWithoutFriends> getFriends(int userId);

    void deleteUser(int userId);
}
