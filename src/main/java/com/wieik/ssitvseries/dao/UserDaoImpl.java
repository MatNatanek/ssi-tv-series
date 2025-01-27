package com.wieik.ssitvseries.dao;

import com.wieik.ssitvseries.entity.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
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

    @Override
    public void deleteUser(int idUser) {

        sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM public.friendship where id_user ="+ idUser + " or id_friend = "+idUser).executeUpdate();
        sessionFactory.getCurrentSession().createSQLQuery("Delete from public.users where id_user = "+ idUser).executeUpdate();
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        sessionFactory.getCurrentSession().update(userEntity);
    }

    @Override
    public UserEntity getUser(int idUser) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM UserEntity where idUser =  :id");
        query.setParameter("id", idUser);
        UserEntity userEntity = (UserEntity) query.getSingleResult();
        return userEntity;
    }

    @Override
    public UserEntity getUserByLogin(String login) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM UserEntity where login =  :login");
        query.setParameter("login", login);
        UserEntity userEntity = (UserEntity) query.getSingleResult();
        return userEntity;
    }
}
