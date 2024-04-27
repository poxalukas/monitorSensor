package com.fiesc.monitor.controller;

import com.fiesc.monitor.entity.LinhaProducao;
import com.fiesc.monitor.entity.Sensor;
import com.fiesc.monitor.repository.LinhaProducaoRepository;
import com.fiesc.monitor.repository.SensorRepository;
import com.fiesc.monitor.service.LinhaProducaoService;
import com.fiesc.monitor.service.MonitorService;
import com.fiesc.monitor.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/linha-producao")
public class LinhaProducaoController {

    @Autowired
    private LinhaProducaoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Sensor> findOne(@PathVariable long id) {
        return ResponseEntity.ok(service.save());
    }

}
