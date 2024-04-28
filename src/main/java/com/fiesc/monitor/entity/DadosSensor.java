package com.fiesc.monitor.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.print.attribute.standard.MediaSize;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_dado_sensor")
@Getter
@Setter
public class DadosSensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sensor_id")
    private Long sensor;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "data")
    private Long data;

}
