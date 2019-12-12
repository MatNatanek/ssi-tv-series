package com.wieik.ssitvseries.dao;


import com.wieik.ssitvseries.entity.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;


@Repository
public class CredentialsDaoImpl implements CredentialsDao {

    private SessionFactory sessionFactory;

    @Autowired
    public CredentialsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<UserEntity> getAll() {
        return sessionFactory.getCurrentSession().createQuery("From UserEntity cre").list();
    }

    @Override
    public UserEntity getUserByMail(String mail) throws NoResultException {
        Query query = sessionFactory.getCurrentSession().createQuery("From UserEntity where login = :mail");
        query.setParameter("mail", mail);
        UserEntity credentialsEntity = (UserEntity) query.getSingleResult();
        return credentialsEntity;
    }
}
