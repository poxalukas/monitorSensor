package com.fiesc.monitor.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_maquina")
@Getter
@Setter
public class Maquina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "maquina", fetch = FetchType.EAGER)
    private List<Sensor> sensores;

    @Column(name = "status", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "linha_producao_id")
    private LinhaProducao linhaProducao;
}
