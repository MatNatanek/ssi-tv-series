package com.wieik.ssitvseries.dao;

import com.wieik.ssitvseries.entity.EpisodeEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EpisodeDaoImpl implements EpisodeDao {

    private SessionFactory sessionFactory;

    @Autowired
    public EpisodeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<EpisodeEntity> getEpisodes(){
        return sessionFactory.getCurrentSession().createQuery("FROM EpisodeEntity ep").list();
    }

    @Override
    public void saveEpisode(EpisodeEntity episodeEntity){
        sessionFactory.getCurrentSession().save(episodeEntity);
    }

}
