package com.fiesc.monitor;

import com.fiesc.monitor.service.MonitorService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Inicializer {

    @Autowired
    private MonitorService service;


    @PostConstruct
    public void postConstruct(){
        service.startMonitoring();
    }
}
