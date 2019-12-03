package com.wieik.ssitvseries.dao;

import com.wieik.ssitvseries.entity.TvSeriesEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;


@Repository
public class TvSeriesDaoImpl implements TvSeriesDao {

    private SessionFactory sessionFactory;

    @Autowired
    public TvSeriesDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<TvSeriesEntity> getAll() {
        return sessionFactory.getCurrentSession().createQuery("From TvSeriesEntity tvs").list();
    }

    @Override
    public void add(TvSeriesEntity tvSeriesEntity){
        sessionFactory.getCurrentSession().save(tvSeriesEntity);
    }

    @Override
    public TvSeriesEntity getSeries(int tvSeriesId) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM TvSeriesEntity where idTvSeries =  :id");
        query.setParameter("id", tvSeriesId);
        TvSeriesEntity tvSeriesEntity= (TvSeriesEntity) query.getSingleResult();
        return tvSeriesEntity;
    }

    @Override
    public void deleteSeries(TvSeriesEntity tvSeriesEntity) {
        sessionFactory.getCurrentSession().delete(tvSeriesEntity);
    }
}
