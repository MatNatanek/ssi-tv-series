package com.wieik.ssitvseries.Service;

import com.wieik.ssitvseries.dao.EpisodeDao;
import com.wieik.ssitvseries.entity.EpisodeEntity;
import com.wieik.ssitvseries.json.EpisodeJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EpisodeServiceImpl implements EpisodeService {

    private EpisodeDao episodeDao;

    @Autowired
    public EpisodeServiceImpl(EpisodeDao episodeDao) {
        this.episodeDao = episodeDao;
    }

    @Override
    @Transactional
    public void saveEpisode(EpisodeJson episodeJson) {
        EpisodeEntity episodeEntity = new EpisodeEntity();
        episodeEntity.setTitle(episodeJson.getTitle());

        episodeDao.saveEpisode(episodeEntity);
    }

    @Override
    public List<EpisodeEntity> getEpisodes() {
        return episodeDao.getEpisodes();
    }
}
