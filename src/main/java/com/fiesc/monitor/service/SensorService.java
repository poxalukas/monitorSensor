package com.fiesc.monitor.service;

import com.fiesc.monitor.configs.query.GenericSpesification;
import com.fiesc.monitor.configs.query.Request;
import com.fiesc.monitor.dto.SensorDTO;
import com.fiesc.monitor.entity.LinhaProducao;
import com.fiesc.monitor.entity.Maquina;
import com.fiesc.monitor.entity.Sensor;
import com.fiesc.monitor.entity.Sensor;
import com.fiesc.monitor.repository.MaquinaRepository;
import com.fiesc.monitor.repository.SensorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SensorService {

    @Autowired
    private SensorRepository repository;

    @Autowired
    private MaquinaRepository maquinaRepository;

    public Sensor save(Sensor sensor) throws Exception {
        Maquina maquina = maquinaRepository.findById(sensor.getMaquina().getId())
                .orElseThrow(() -> new Exception("Maquina não encontrada com o ID: " + sensor.getMaquina().getId()));
        sensor.setMaquina(maquina);
        maquina.getSensores().add(sensor);
        return repository.save(sensor);
    }

    public Sensor update(Sensor sensorDTO) throws Exception {
        if(sensorDTO.getId()== null)
            return null;
        Sensor sensor = repository.findById(sensorDTO.getId())
                .orElseThrow(() -> new Exception("Sensor não encontrada com o ID: " + sensorDTO.getId()));
        sensor.setName(sensorDTO.getName());
        sensor.setStatus(sensorDTO.getStatus());
        return  repository.save(sensor);
    }

    public Page<Sensor> findAll(Request request) {
        return repository.findAll(new GenericSpesification<>(request.getList()), request.getPageable());
    }

    public Sensor findById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public Sensor remove(Long id) {
        Optional<Sensor> sensorOptional = repository.findById(id);
        if (sensorOptional.isPresent()) {
            Sensor sensor = sensorOptional.get();
            sensor.setStatus(Boolean.FALSE);
            return repository.save(sensor);
        } else {
            throw new EntityNotFoundException("Linha de produção não encontrada com o ID: " + id);
        }
    }
}
