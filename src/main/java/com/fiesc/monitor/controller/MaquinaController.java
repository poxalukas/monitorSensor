package com.fiesc.monitor.controller;

import com.fiesc.monitor.configs.query.Request;
import com.fiesc.monitor.dto.MaquinaDTO;
import com.fiesc.monitor.entity.Maquina;
import com.fiesc.monitor.entity.Sensor;
import com.fiesc.monitor.repository.SensorRepository;
import com.fiesc.monitor.service.MaquinaService;
import com.fiesc.monitor.service.MonitorService;
import com.fiesc.monitor.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/maquina")
public class MaquinaController {

    @Autowired
    private MaquinaService service;

    @PostMapping(value = "/add")
    public ResponseEntity<?> save(@RequestBody Maquina maquina) throws Exception {
        try {
            Maquina maquina1 = service.save(maquina);
            return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(maquina1.getId()).toUri()).body(maquina1);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
        @PutMapping(value = "/update")
        public ResponseEntity<?> update(@RequestBody Maquina maquina) {
            try{
            return ResponseEntity.ok(service.update(maquina));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }
        }

    @PostMapping(value = "/find")
    public ResponseEntity<Page<Maquina>> findAll(@RequestBody Request request) {
        return ResponseEntity.ok(service.findAll(request));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Maquina> findOne(@PathVariable long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping(value = "/remove/{id}")
    public ResponseEntity<Maquina> remove(@PathVariable long id) {
        service.remove(id);
        return ResponseEntity.noContent().build();
    }
}
