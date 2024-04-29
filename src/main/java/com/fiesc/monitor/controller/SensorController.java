package com.fiesc.monitor.controller;

import com.fiesc.monitor.configs.query.Request;
import com.fiesc.monitor.dto.SensorDTO;
import com.fiesc.monitor.entity.Sensor;
import com.fiesc.monitor.entity.Sensor;
import com.fiesc.monitor.repository.SensorRepository;
import com.fiesc.monitor.service.MonitorService;
import com.fiesc.monitor.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/sensor")
public class SensorController {


    @Autowired
    private SensorService service;



    @PostMapping(value = "/add")
    public ResponseEntity<?> save(@RequestBody Sensor sensor) throws Exception {
        try {
            service.save(sensor);
            return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(sensor.getId()).toUri()).body(sensor);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody Sensor sensor) throws Exception {
       try {
           return ResponseEntity.ok(service.update(sensor));
       }catch (Exception e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
       }
    }

    @PutMapping(value = "/update-csv")
    public ResponseEntity<?> updateEmMassa(@RequestBody Sensor sensor) throws Exception {
        try {
            return ResponseEntity.ok(service.updateCsv(sensor));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping(value = "/find")
    public ResponseEntity<Page<Sensor>> findAll(@RequestBody Request request) {
        return ResponseEntity.ok(service.findAll(request));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Sensor> findOne(@PathVariable long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping(value = "/remove/{id}")
    public ResponseEntity<Sensor> remove(@PathVariable long id) {
        service.remove(id);
        return ResponseEntity.noContent().build();
    }
}
