package com.wieik.ssitvseries.dao;

import com.wieik.ssitvseries.entity.SerialTestEntity;

import java.util.List;

public interface SerialTestDao {

    List<SerialTestEntity> getAll();

    void save(SerialTestDao serialTestDao);
}
