package com.wieik.ssitvseries.Service;

import com.wieik.ssitvseries.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> getUsers();

    void saveUser(UserEntity userEntity);
}
