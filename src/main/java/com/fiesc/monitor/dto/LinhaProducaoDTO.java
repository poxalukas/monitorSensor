package com.fiesc.monitor.dto;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiesc.monitor.entity.LinhaProducao;
import com.fiesc.monitor.entity.Maquina;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
public class LinhaProducaoDTO {

    private Long id;
    private String name;
    private Set<MaquinaDTO> maquinas;
    private Boolean status;


}
