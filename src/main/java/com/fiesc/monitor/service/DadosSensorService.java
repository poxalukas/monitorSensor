package com.fiesc.monitor.service;

import com.fiesc.monitor.configs.query.GenericSpesification;
import com.fiesc.monitor.configs.query.Request;
import com.fiesc.monitor.dto.SensorDTO;
import com.fiesc.monitor.entity.DadosSensor;
import com.fiesc.monitor.entity.Sensor;
import com.fiesc.monitor.repository.DadosSensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DadosSensorService {

    @Autowired
    private DadosSensorRepository repository;

    @Autowired
    private SensorService service;

    public List<DadosSensor> findById(long id) {
        Long sensor = service.findById(id).getId();
        if(sensor!=null){
            return repository.findFirst100BySensorOrderByTimestampDesc(sensor);
        }
        return null;
    }

}
