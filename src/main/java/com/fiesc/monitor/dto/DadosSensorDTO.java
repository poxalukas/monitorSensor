package com.fiesc.monitor.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class DadosSensorDTO {

    private Long id;
    private Long data;
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Timestamp timestamp;

    private SensorDTO sensorDTO;
}
