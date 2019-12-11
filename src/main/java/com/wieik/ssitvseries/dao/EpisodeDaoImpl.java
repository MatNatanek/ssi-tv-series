package com.wieik.ssitvseries.dao;

import com.wieik.ssitvseries.entity.EpisodeEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class EpisodeDaoImpl implements  EpisodeDao {

    SessionFactory sessionFactory;

    @Autowired
    public EpisodeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public EpisodeEntity getEpisode(int episodeId) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM EpisodeEntity where idEpisode =  :id");
        query.setParameter("id", episodeId);
        EpisodeEntity episodeEntity = (EpisodeEntity) query.getSingleResult();
        return episodeEntity;
    }
}
