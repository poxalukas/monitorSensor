package com.fiesc.monitor.dto;

import com.fiesc.monitor.entity.DadosSensor;
import com.fiesc.monitor.entity.Maquina;
import com.fiesc.monitor.entity.Sensor;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class SensorDTO {
    private Long id;
    private String name;
    private Boolean status;
    private MaquinaDTO maquina;

}
