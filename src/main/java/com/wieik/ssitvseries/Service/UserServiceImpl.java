package com.wieik.ssitvseries.Service;

import com.wieik.ssitvseries.dao.UserDao;
import com.wieik.ssitvseries.entity.UserEntity;
import com.wieik.ssitvseries.json.UserJson;
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
    public void saveUser(UserJson userJson) {
        UserEntity userEntity = new UserEntity();
        userEntity.setLastName(userJson.getLastName());
        userDao.save(userEntity);
    }

    @Override
    @Transactional
    public void addFriend(int userId, int friendId) {
        UserEntity user = userDao.getUser(userId);
        UserEntity friend = userDao.getUser(friendId);

        user.getUsersSet().add(friend);
        System.out.println(user);
        userDao.updateUser(user);



    }
}
