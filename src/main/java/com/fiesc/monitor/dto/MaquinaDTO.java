package com.fiesc.monitor.dto;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiesc.monitor.entity.LinhaProducao;
import com.fiesc.monitor.entity.Maquina;
import com.fiesc.monitor.entity.Sensor;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
public class MaquinaDTO {

    private Long id;
    private String name;
    private List<SensorDTO> sensores;
    private Boolean status;
    private LinhaProducaoDTO linhaProducao;


}
