package com.wieik.ssitvseries.Service;

import com.wieik.ssitvseries.dao.TvSeriesDao;
import com.wieik.ssitvseries.entity.CommentEntity;
import com.wieik.ssitvseries.entity.EpisodeEntity;
import com.wieik.ssitvseries.entity.TvSeriesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;


@Service
public class TvSeriesServiceImpl implements TvSeriesService {

    TvSeriesDao tvSeriesDao;

    @Autowired
    public TvSeriesServiceImpl(TvSeriesDao tvSeriesDao) {
        this.tvSeriesDao = tvSeriesDao;
    }

    @Override
    public List<TvSeriesEntity> getAllTvSeries() {
        return tvSeriesDao.getAll();
    }

    @Override
    public TvSeriesEntity getTvSeries(int tvSeriesId) {
        return tvSeriesDao.getSeries(tvSeriesId);
    }

    @Override
    @Transactional
    public void editTvSeries(TvSeriesEntity tvSeriesEntity) {
        tvSeriesDao.updateTvSeries(tvSeriesEntity);
    }

    @Override
    @Transactional
    public void addTvSeries(TvSeriesEntity tvSeriesEntity) {
        tvSeriesDao.add(tvSeriesEntity);
    }

    @Override
    @Transactional
    public void addEpisode(int tvSeriesId, EpisodeEntity episodeEntity) {
        TvSeriesEntity tvSeriesEntity = tvSeriesDao.getSeries(tvSeriesId);
        tvSeriesEntity.addEpisode(episodeEntity);

    }

    @Override
    public List<CommentEntity> getAllComments(int tvSeriesId) {
        return tvSeriesDao.getAllComments(tvSeriesId);
    }

    @Override
    public void addComment(int tvSeriesId, int userId, CommentEntity commentEntity) {
        tvSeriesDao.addComment(tvSeriesId, userId ,commentEntity);
    }

    @Override
    @Transactional
    public void editEpisode(EpisodeEntity episodeEntity, int tvSeriesId) {
//        TvSeriesEntity tvSeriesEntity = tvSeriesDao.getSeries(tvSeriesId);
//        Set<EpisodeEntity> setOfEpisodeEntity = tvSeriesEntity.getSetOfEpisodes();
//        setOfEpisodeEntity.remove(episodeEntity);
//        setOfEpisodeEntity.add(episodeEntity);
//        tvSeriesEntity.setSetOfEpisodes(setOfEpisodeEntity);
        tvSeriesDao.updateEpisode(episodeEntity);
    }

    @Override
    public Set<EpisodeEntity> getEpisodes(int tvSeriesId) {
        TvSeriesEntity tvSeriesEntity = tvSeriesDao.getSeries(tvSeriesId);
        return tvSeriesEntity.getSetOfEpisodes();
    }

    @Override
    @Transactional
    public void deleteSeries(int tvSeriesId) {
        TvSeriesEntity tvSeriesEntity = tvSeriesDao.getSeries(tvSeriesId);
        tvSeriesDao.deleteSeries(tvSeriesEntity);
    }
}
