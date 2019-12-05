package com.wieik.ssitvseries.Service;

import com.wieik.ssitvseries.dao.EpisodeDao;
import com.wieik.ssitvseries.dao.UserDao;
import com.wieik.ssitvseries.entity.EpisodeEntity;
import com.wieik.ssitvseries.entity.UserEntity;
import com.wieik.ssitvseries.model.User;
import com.wieik.ssitvseries.model.UserWithUWF;
import com.wieik.ssitvseries.model.UserWithoutFriends;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private EpisodeDao episodeDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, EpisodeDao episodeDao) {
        this.userDao = userDao;
        this.episodeDao = episodeDao;
    }

    @Override
    public List<UserWithUWF> getUsers() {

        List<UserEntity> listOfUE = userDao.getAll();

        List<UserWithUWF> listOfUWUWF = converListOfUEtoUWUWF(listOfUE);

        return listOfUWUWF;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setLastName(user.getLastName());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLogin(user.getLogin());
        userEntity.setPassword(user.getPassword());
        userEntity.setRole(user.getRole());
        userDao.save(userEntity);
    }

    @Override
    @Transactional
    public void updateUser(UserEntity user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void addFriend(int userId, int friendId) {
        UserEntity user = userDao.getUser(userId);
        UserEntity friend = userDao.getUser(friendId);

        user.addFriend(friend);
        friend.addFriend(user);

    }

    @Override
    @Transactional
    public void deleteUser(int userId) {

        userDao.deleteUser(userId);

    }

    @Override
    @Transactional
    public void removeFriend(int userId, int friendId) {
        UserEntity user = userDao.getUser(userId);
        UserEntity friend = userDao.getUser(friendId);

        user.removeFriend(friend);
        friend.removeFriend(user);

    }

    @Override
    public Set<UserWithoutFriends> getFriends(int userId) {
        UserEntity user = userDao.getUser(userId);
        Set<UserWithoutFriends> setOfUWF = converSetOfUEtoUWF(user.getFriendsSet());
        return setOfUWF;
    }


    private Set<UserWithoutFriends> removeFriendsFromModel(Set<UserEntity> setOfFriends){
        Set<UserWithoutFriends> setOfUsersWithoutFriends = new HashSet<>();
        for(UserEntity userEntity: setOfFriends){
            UserWithoutFriends userWithoutFriends = new UserWithoutFriends();
            userWithoutFriends.setIdUser(userEntity.getIdUser());
            userWithoutFriends.setLastName(userEntity.getLastName());
            userWithoutFriends.setFirstName(userEntity.getFirstName());
            userWithoutFriends.setLogin(userEntity.getLogin());
            userWithoutFriends.setPassword(userEntity.getPassword());
            userWithoutFriends.setRole(userEntity.getRole());
            setOfUsersWithoutFriends.add(userWithoutFriends);
        }
        return setOfUsersWithoutFriends;
    }

    private UserWithUWF convertUserEntityToUserWithUWF(UserEntity userEntity){
        UserWithUWF userWithUWF = new UserWithUWF();
        userWithUWF.setIdUser(userEntity.getIdUser());
        userWithUWF.setLastName(userEntity.getLastName());
        userWithUWF.setFirstName(userEntity.getFirstName());
        userWithUWF.setLogin(userEntity.getLogin());
        userWithUWF.setPassword(userEntity.getPassword());
        userWithUWF.setRole(userEntity.getRole());
        userWithUWF.setFriendsSet(removeFriendsFromModel(userEntity.getFriendsSet()));
        return userWithUWF;
    }

    private UserWithoutFriends convertUserEntityToUWF(UserEntity userEntity){
        UserWithoutFriends userWF = new UserWithoutFriends();
        userWF.setIdUser(userEntity.getIdUser());
        userWF.setLastName(userEntity.getLastName());
        userWF.setFirstName(userEntity.getFirstName());
        userWF.setLogin(userEntity.getLogin());
        userWF.setPassword(userEntity.getPassword());
        userWF.setRole(userEntity.getRole());
        return userWF;
    }

    private List<UserWithUWF> converListOfUEtoUWUWF(List<UserEntity> listOfUE){
        List<UserWithUWF> listOfUWUWF = new ArrayList<>();
        for(UserEntity userEntity: listOfUE){
            UserWithUWF userWithUWF = convertUserEntityToUserWithUWF(userEntity);
            listOfUWUWF.add(userWithUWF);
        }
        return listOfUWUWF;
    }

    private Set<UserWithoutFriends> converSetOfUEtoUWF(Set<UserEntity> listOfUE){
        Set<UserWithoutFriends> listOfUWF = new HashSet<>();
        for(UserEntity userEntity: listOfUE){
            UserWithoutFriends userWithoutFriends = convertUserEntityToUWF(userEntity);
            listOfUWF.add(userWithoutFriends );
        }
        return listOfUWF;
    }

    @Override
    public Set<EpisodeEntity> getWatchedEpisodes(int userId) {
        UserEntity userEntity = userDao.getUser(userId);
        return userEntity.getWatchedEpisodes();
    }

    @Override
    public void addEpisodeToWatched(int userId, int episodeId) {
        UserEntity userEntity = userDao.getUser(userId);
        EpisodeEntity episodeEntity =  episodeDao.getEpisode(episodeId);
        userEntity.getWatchedEpisodes().add(episodeEntity);
    }
}
