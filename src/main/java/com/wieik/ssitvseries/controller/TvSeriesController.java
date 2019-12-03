package com.wieik.ssitvseries.controller;

import com.wieik.ssitvseries.Service.TvSeriesService;
import com.wieik.ssitvseries.entity.TvSeriesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/tvseries")
public class TvSeriesController {

    TvSeriesService tvSeriesService;

    @Autowired
    public TvSeriesController(TvSeriesService tvSeriesService) {
        this.tvSeriesService = tvSeriesService;
    }

    @GetMapping
    public Set<TvSeriesEntity> getTvSeries(){
        return tvSeriesService.getTvSeries();
    }
}
