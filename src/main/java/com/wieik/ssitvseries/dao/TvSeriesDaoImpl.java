package com.wieik.ssitvseries.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TvSeriesDaoImpl implements TvSeriesDao {

    private SessionFactory sessionFactory;

    @Autowired
    public TvSeriesDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
