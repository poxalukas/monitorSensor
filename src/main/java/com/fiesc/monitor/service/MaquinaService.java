package com.fiesc.monitor.service;

import com.fiesc.monitor.configs.query.GenericSpesification;
import com.fiesc.monitor.configs.query.Request;
import com.fiesc.monitor.dto.MaquinaDTO;
import com.fiesc.monitor.entity.LinhaProducao;
import com.fiesc.monitor.entity.Maquina;
import com.fiesc.monitor.entity.Sensor;
import com.fiesc.monitor.repository.LinhaProducaoRepository;
import com.fiesc.monitor.repository.MaquinaRepository;
import com.fiesc.monitor.repository.SensorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MaquinaService {

    @Autowired
    private MaquinaRepository repository;

    @Autowired
    private LinhaProducaoRepository linhaProducaoRepository;

    public Maquina save(Maquina maquina) throws Exception {
        LinhaProducao linhaProducao = linhaProducaoRepository.findById(maquina.getLinhaProducao().getId())
                .orElseThrow(() -> new Exception("Linha de produção não encontrada com o ID: " + maquina.getLinhaProducao().getId()));
        maquina.setLinhaProducao(linhaProducao);
        linhaProducao.getMaquinas().add(maquina);
        return repository.save(maquina);
    }
    public Maquina update(Maquina maquinaDTO) throws Exception {
        if(maquinaDTO.getId() == null)
            return null;

        Maquina maquina = repository.findById(maquinaDTO.getId())
                .orElseThrow(() -> new Exception("Maquina não encontrada com o ID: " + maquinaDTO.getId()));

        maquina.setName(maquinaDTO.getName());
        maquina.setStatus(maquinaDTO.getStatus());
        maquina.setSequencia(maquinaDTO.getSequencia());
        return  repository.save(maquina);
    }

    public Page<Maquina> findAll(Request request) {
        return repository.findAll(new GenericSpesification<>(request.getList()), request.getPageable());
    }

    public Maquina findById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public Maquina remove(Long id) {
        Optional<Maquina> maquinaOptional = repository.findById(id);
        if (maquinaOptional.isPresent()) {
            Maquina maquina = maquinaOptional.get();
            maquina.setStatus(Boolean.FALSE);
            return repository.save(maquina);
        } else {
            throw new EntityNotFoundException("Linha de produção não encontrada com o ID: " + id);
        }
    }
}
