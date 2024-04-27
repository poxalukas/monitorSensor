package com.fiesc.monitor.dto;

import com.fiesc.monitor.entity.Maquina;
import jakarta.persistence.*;

import java.util.List;

public class LinhaProducaoDTO {

    private String name;
    private List<Maquina> maquinas;
    private Boolean status;

}
