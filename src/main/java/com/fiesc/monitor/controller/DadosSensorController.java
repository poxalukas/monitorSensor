package com.fiesc.monitor.controller;

import com.fiesc.monitor.entity.Sensor;
import com.fiesc.monitor.service.DadosSensorService;
import com.fiesc.monitor.service.LinhaProducaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dados-sensor")
public class DadosSensorController {

    @Autowired
    private DadosSensorService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Sensor> findOne(@PathVariable long id) {
        return ResponseEntity.ok(service.save());
    }

}
