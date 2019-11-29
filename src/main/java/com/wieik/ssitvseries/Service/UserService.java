package com.wieik.ssitvseries.Service;

import com.wieik.ssitvseries.entity.UserEntity;
import com.wieik.ssitvseries.json.UserJson;

import java.util.List;

public interface UserService {

    List<UserEntity> getUsers();

    void saveUser(UserJson userJson);

    void addFriend(int userId, int friendId);


}
