package com.wieik.ssitvseries.controller;

import com.wieik.ssitvseries.Service.EpisodeService;
import com.wieik.ssitvseries.entity.EpisodeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/exp")
public class EpisodeController {

    EpisodeService episodeService;

    @Autowired
    public EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping
    public List<EpisodeEntity> getEpisodes(){
        return episodeService.getEpisodes();
    }

    @PostMapping
    public void saveEpisode(@RequestBody EpisodeEntity episodeEntity) {
        episodeService.saveEpisode(episodeEntity);
    }

}
