package com.wieik.ssitvseries.Service;

import com.wieik.ssitvseries.entity.EpisodeEntity;

import java.util.List;

public interface EpisodeService {

    void saveEpisode(EpisodeEntity episodeEntity);

    List<EpisodeEntity>getEpisodes();
}
