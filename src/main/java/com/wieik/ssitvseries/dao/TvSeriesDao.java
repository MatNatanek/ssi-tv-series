package com.wieik.ssitvseries.dao;

import com.wieik.ssitvseries.entity.TvSeriesEntity;

import java.util.List;


public interface TvSeriesDao {
    List<TvSeriesEntity> getAll();

    void add(TvSeriesEntity tvSeriesEntity);

    TvSeriesEntity getSeries(int tvSeriesId);

    void deleteSeries(TvSeriesEntity tvSeriesEntity);
}
