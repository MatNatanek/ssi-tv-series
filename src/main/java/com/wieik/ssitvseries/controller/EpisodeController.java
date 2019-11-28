package com.wieik.ssitvseries.controller;

import com.wieik.ssitvseries.Service.EpisodeService;
import com.wieik.ssitvseries.entity.EpisodeEntity;
import com.wieik.ssitvseries.json.EpisodeJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/episodes")
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
    public void saveEpisodeEpisode(@RequestBody EpisodeJson episodeJson) {
        episodeService.saveEpisode(episodeJson);
    }

}