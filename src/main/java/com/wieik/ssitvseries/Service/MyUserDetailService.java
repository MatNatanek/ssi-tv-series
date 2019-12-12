package com.wieik.ssitvseries.Service;


import com.wieik.ssitvseries.dao.CredentialsDao;
import com.wieik.ssitvseries.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.ArrayList;

@Service
public class MyUserDetailService implements UserDetailsService {

    private CredentialsDao credentialsDao;

    @Autowired
    public MyUserDetailService(CredentialsDao credentialsDao) {
        this.credentialsDao = credentialsDao;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        try {
            UserEntity credentialsEntity = credentialsDao.getUserByMail(userName);
            return new User(credentialsEntity.getLogin(), credentialsEntity.getPassword(), new ArrayList<>());
        } catch (NoResultException e) {
            throw new UsernameNotFoundException(userName);
        }

    }
}
