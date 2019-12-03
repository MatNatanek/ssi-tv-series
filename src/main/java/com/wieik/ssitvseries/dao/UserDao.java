package com.wieik.ssitvseries.dao;

import com.wieik.ssitvseries.entity.UserEntity;

import java.util.List;

public interface UserDao {

    List<UserEntity> getAll();

    void save (UserEntity userEntity);

    void updateUser(UserEntity userEntity);

    UserEntity getUser(int idUser);

    void deleteUser(int idUser);
}
