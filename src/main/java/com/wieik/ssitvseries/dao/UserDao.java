package com.wieik.ssitvseries.dao;

import com.wieik.ssitvseries.entity.UserEntity;

import java.util.List;

public interface UserDao {

    List<UserEntity> getAll();

    void save (UserEntity userEntity);
}
