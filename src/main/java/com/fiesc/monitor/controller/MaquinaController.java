package com.fiesc.monitor.controller;

import com.fiesc.monitor.entity.Sensor;
import com.fiesc.monitor.repository.SensorRepository;
import com.fiesc.monitor.service.MaquinaService;
import com.fiesc.monitor.service.MonitorService;
import com.fiesc.monitor.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maquina")
public class MaquinaController {

    @Autowired
    private MaquinaService service;

}
