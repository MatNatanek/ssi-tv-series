package com.wieik.ssitvseries.Service;

import com.wieik.ssitvseries.entity.EpisodeEntity;
import com.wieik.ssitvseries.json.EpisodeJson;

import java.util.List;

public interface EpisodeService {

    void saveEpisode(EpisodeJson episodeJson);

    List<EpisodeEntity>getEpisodes();
}
