package com.fiesc.monitor.dto;

import com.fiesc.monitor.entity.LinhaProducao;
import com.fiesc.monitor.entity.Sensor;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class MaquinaDTO {
    private String name;
    private List<Sensor> sensores;
    private Boolean status;
    private Long linhaProducao;

}
