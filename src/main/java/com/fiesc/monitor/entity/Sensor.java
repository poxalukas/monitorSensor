package com.fiesc.monitor.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_sensor")
@Getter
@Setter
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "status", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "maquina_id")
    private Maquina maquina;

    @OneToMany(mappedBy = "sensor", fetch = FetchType.EAGER)
    private List<DadosSensor> dadosSensor;

}
