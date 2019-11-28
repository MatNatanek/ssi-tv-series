package com.wieik.ssitvseries.dao;

import com.wieik.ssitvseries.entity.EpisodeEntity;

import java.util.List;

public interface EpisodeDao {
    List<EpisodeEntity> getEpisodes();

    void saveEpisode(EpisodeEntity episodeEntity);
}
