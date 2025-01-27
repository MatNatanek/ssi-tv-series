package com.wieik.ssitvseries.controller;

import com.wieik.ssitvseries.Service.TvSeriesService;
import com.wieik.ssitvseries.entity.CommentEntity;
import com.wieik.ssitvseries.entity.EpisodeEntity;
import com.wieik.ssitvseries.entity.TvSeriesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/tvseries")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TvSeriesController {

    TvSeriesService tvSeriesService;

    @Autowired
    public TvSeriesController(TvSeriesService tvSeriesService) {
        this.tvSeriesService = tvSeriesService;
    }

    @GetMapping
    public List<TvSeriesEntity> getAllTvSeries(){
        return tvSeriesService.getAllTvSeries();
    }

    @GetMapping("/{tvSeriesId}/comments")
    public List<CommentEntity> getAllComments(@PathVariable int tvSeriesId){
        return tvSeriesService.getAllComments(tvSeriesId);
    }

    @PostMapping("/{tvSeriesId}/comments/{userId}")
    public void addComment(@PathVariable int tvSeriesId, @PathVariable int userId, @RequestBody CommentEntity commentEntity){
        tvSeriesService.addComment(tvSeriesId, userId,commentEntity);
    }


    @PutMapping
    public void editTvSeries(@RequestBody TvSeriesEntity tvSeriesEntity){
        tvSeriesService.editTvSeries(tvSeriesEntity);
    }

    @GetMapping("/{tvSeriesId}")
    public TvSeriesEntity getTvSeries(@PathVariable int tvSeriesId){
        return tvSeriesService.getTvSeries(tvSeriesId);
    }

    @PostMapping
    public void addTvSeries(@RequestBody TvSeriesEntity tvSeriesEntity){
        tvSeriesService.addTvSeries(tvSeriesEntity);
    }


    @PostMapping("/{tvSeriesId}/episodes/")
    public void addEpisode(@PathVariable int tvSeriesId, @RequestBody EpisodeEntity episodeEntity){
        tvSeriesService.addEpisode(tvSeriesId, episodeEntity);
    }

    @PutMapping("/{tvSeriesId}/episodes/")
    public void editEpisode(@RequestBody EpisodeEntity episodeEntity, @PathVariable int tvSeriesId){
        tvSeriesService.editEpisode(episodeEntity, tvSeriesId);
    }

    @GetMapping("/{tvSeriesId}/episodes/")
    public Set<EpisodeEntity> getEpisodes(@PathVariable int tvSeriesId){
        return tvSeriesService.getEpisodes(tvSeriesId);
    }

    @DeleteMapping("/{tvSeriesId}")
    public void deleteSeries(@PathVariable int tvSeriesId){
        tvSeriesService.deleteSeries(tvSeriesId);
    }
}
