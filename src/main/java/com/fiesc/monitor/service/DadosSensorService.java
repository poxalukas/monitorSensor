package com.fiesc.monitor.service;

import com.fiesc.monitor.entity.DadosSensor;
import com.fiesc.monitor.entity.Sensor;
import com.fiesc.monitor.repository.DadosSensorRepository;
import com.fiesc.monitor.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DadosSensorService {

    @Autowired
    private DadosSensorRepository repository;

}
