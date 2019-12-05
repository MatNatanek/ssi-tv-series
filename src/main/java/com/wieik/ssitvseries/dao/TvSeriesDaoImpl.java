package com.wieik.ssitvseries.dao;

import com.wieik.ssitvseries.entity.EpisodeEntity;
import com.wieik.ssitvseries.entity.TvSeriesEntity;
import com.wieik.ssitvseries.model.Episode;
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
    public void updateTvSeries(TvSeriesEntity tvSeriesEntity) {
        sessionFactory.getCurrentSession().update(tvSeriesEntity);
    }

    @Override
    public void updateEpisode(EpisodeEntity episodeEntity) {
        Query query= sessionFactory.getCurrentSession().createSQLQuery("UPDATE public.episode SET title = :title, season =:season, episode_number =:episode_number WHERE id_episode =:id_episode");
        query.setParameter("title", episodeEntity.getTitle());
        query.setParameter("season", episodeEntity.getSeason());
        query.setParameter("episode_number", episodeEntity.getEpisodeNumber());
        query.setParameter("id_episode", episodeEntity.getIdEpisode());
        query.executeUpdate();
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
