package com.wieik.ssitvseries.Service;

import com.wieik.ssitvseries.dao.UserDao;
import com.wieik.ssitvseries.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<UserEntity> getUsers() {
        return userDao.getAll();
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        userDao.save(userEntity);
    }
}
