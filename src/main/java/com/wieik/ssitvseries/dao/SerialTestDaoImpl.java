package com.wieik.ssitvseries.dao;

import com.wieik.ssitvseries.entity.SerialTestEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SerialTestDaoImpl implements SerialTestDao {

    private SessionFactory sessionFactory;

    @Autowired
    public SerialTestDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<SerialTestEntity> getAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM SerialTestEntity ste").list();
    }

    @Override
    public void save(SerialTestDao serialTestDao) {

    }
}
