package com.fiesc.monitor.service;

import com.fiesc.monitor.configs.query.GenericSpesification;
import com.fiesc.monitor.configs.query.Request;
import com.fiesc.monitor.dto.LinhaProducaoDTO;
import com.fiesc.monitor.entity.LinhaProducao;
import com.fiesc.monitor.entity.Sensor;
import com.fiesc.monitor.repository.LinhaProducaoRepository;
import com.fiesc.monitor.repository.SensorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LinhaProducaoService {

    @Autowired
    private LinhaProducaoRepository repository;

    public LinhaProducao save(LinhaProducao linhaProducao) {
        return repository.save(linhaProducao);
    }
    public LinhaProducao update(LinhaProducao linhaProducaoDTO)throws Exception{
        if(linhaProducaoDTO.getId()== null)
            return null;
        LinhaProducao linhaProducao = repository.findById(linhaProducaoDTO.getId())
                .orElseThrow(() -> new Exception("Linha de produção não encontrada com o ID: " + linhaProducaoDTO.getId()));
        linhaProducao.setName(linhaProducaoDTO.getName());
        linhaProducao.setStatus(linhaProducaoDTO.getStatus());
        return  repository.save(linhaProducao);

    }

    public Page<LinhaProducao> findAll(Request request) {
        return repository.findAll(new GenericSpesification<>(request.getList()), request.getPageable());
    }

    public LinhaProducao findById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public LinhaProducao remove(Long id) {
        Optional<LinhaProducao> linhaProducaoOptional = repository.findById(id);
        if (linhaProducaoOptional.isPresent()) {
            LinhaProducao linhaProducao = linhaProducaoOptional.get();
            linhaProducao.setStatus(Boolean.FALSE);
            return repository.save(linhaProducao);
        } else {
            throw new EntityNotFoundException("Linha de produção não encontrada com o ID: " + id);
        }
    }
}
