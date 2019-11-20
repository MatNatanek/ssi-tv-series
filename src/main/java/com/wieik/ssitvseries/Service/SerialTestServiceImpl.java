package com.wieik.ssitvseries.Service;

import com.wieik.ssitvseries.dao.SerialTestDao;
import com.wieik.ssitvseries.entity.SerialTestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerialTestServiceImpl implements SerialTestService {

    SerialTestDao serialTestDao;

    @Autowired
    public SerialTestServiceImpl(SerialTestDao serialTestDao) {
        this.serialTestDao = serialTestDao;
    }

    @Override
    public List<SerialTestEntity> getSeries() {
        return serialTestDao.getAll();
    }
}
