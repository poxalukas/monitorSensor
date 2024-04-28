package com.fiesc.monitor.controller;

import com.fiesc.monitor.configs.query.Request;
import com.fiesc.monitor.entity.DadosSensor;
import com.fiesc.monitor.service.DadosSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dados-sensor")
public class DadosSensorController {

    @Autowired
    private DadosSensorService service;
    @GetMapping(value = "/{id}")
    public ResponseEntity<List<DadosSensor>> findOne(@PathVariable long id) {
        return ResponseEntity.ok(service.findById(id));
    }

}
