package com.wieik.ssitvseries.Service;

import com.wieik.ssitvseries.entity.CommentEntity;
import com.wieik.ssitvseries.entity.EpisodeEntity;
import com.wieik.ssitvseries.entity.TvSeriesEntity;

import java.util.List;
import java.util.Set;


public interface TvSeriesService {
    List<TvSeriesEntity> getAllTvSeries();

    void addTvSeries(TvSeriesEntity tvSeriesEntity);

    void addEpisode(int tvSeriesId, EpisodeEntity episodeEntity);

    TvSeriesEntity getTvSeries(int tvSeriesId);

    Set<EpisodeEntity> getEpisodes(int tvSeriesId);

    void deleteSeries(int tvSeriesId);

    void editTvSeries(TvSeriesEntity tvSeriesEntity);

    void editEpisode(EpisodeEntity episodeEntity, int tvSeriesId);

    List<CommentEntity> getAllComments(int tvSeriesId);

    void addComment(int tvSeriesId, CommentEntity commentEntity);
}
