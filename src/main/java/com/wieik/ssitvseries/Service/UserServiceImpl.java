package com.wieik.ssitvseries.Service;

import com.wieik.ssitvseries.dao.UserDao;
import com.wieik.ssitvseries.entity.UserEntity;
import com.wieik.ssitvseries.json.userJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    @Transactional
    public void saveUser(UserEntity userEntity) {

        UserEntity userEntity1 = new UserEntity();
        userEntity1.setLastName("Kowalski");
        userEntity1.setIdUser(1);
        userDao.save(userEntity1);
    }

}
