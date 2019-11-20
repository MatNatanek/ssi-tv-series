package com.wieik.ssitvseries.controller;

import com.wieik.ssitvseries.Service.SerialTestService;
import com.wieik.ssitvseries.entity.SerialTestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/api/test")
public class TestController {

    SerialTestService serialTestService;

    @Autowired
    public TestController(SerialTestService serialTestService) {
        this.serialTestService = serialTestService;
    }

    @GetMapping
    public List<SerialTestEntity> getTvSeriest() {
        return serialTestService.getSeries();
    }

}

