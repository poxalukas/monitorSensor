package com.fiesc.monitor.controller;

import com.fiesc.monitor.configs.query.Request;
import com.fiesc.monitor.dto.LinhaProducaoDTO;
import com.fiesc.monitor.entity.LinhaProducao;
import com.fiesc.monitor.entity.Sensor;
import com.fiesc.monitor.repository.LinhaProducaoRepository;
import com.fiesc.monitor.repository.SensorRepository;
import com.fiesc.monitor.service.LinhaProducaoService;
import com.fiesc.monitor.service.MonitorService;
import com.fiesc.monitor.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/linha-producao")
public class LinhaProducaoController {

    @Autowired
    private LinhaProducaoService service;

    @PostMapping(value = "/add")
    public ResponseEntity<LinhaProducao> save(@RequestBody LinhaProducao linhaProducao) {
            service.save(linhaProducao);
            return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(linhaProducao.getId()).toUri()).body(linhaProducao);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody LinhaProducao linhaProducao) throws Exception {
       try {
           return ResponseEntity.ok(service.update(linhaProducao));
       }catch (Exception e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
       }
    }

    @PostMapping(value = "/find")
    public ResponseEntity<Page<LinhaProducao>> findAll(@RequestBody Request request) {
        return ResponseEntity.ok(service.findAll(request));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LinhaProducao> findOne(@PathVariable long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping(value = "/remove/{id}")
    public ResponseEntity<LinhaProducao> remove(@PathVariable long id) {
        service.remove(id);
        return ResponseEntity.noContent().build();
    }
}
