package com.wieik.ssitvseries.dao;


import com.wieik.ssitvseries.entity.UserEntity;

import java.util.List;

public interface CredentialsDao {
    List<UserEntity> getAll();

    UserEntity getUserByMail(String mail);
}
