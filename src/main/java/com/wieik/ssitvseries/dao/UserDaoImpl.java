package com.wieik.ssitvseries.dao;

import com.wieik.ssitvseries.entity.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<UserEntity> getAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM UserEntity use").list();
    }

    @Override
    public void save(UserEntity userEntity) {
        sessionFactory.getCurrentSession().save(userEntity);
    }
}