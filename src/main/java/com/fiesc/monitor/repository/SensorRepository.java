package com.fiesc.monitor.repository;

import com.fiesc.monitor.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long>, JpaSpecificationExecutor<Sensor> {
    List<Sensor> findByStatus(boolean status);

    Sensor findByName(String name);

    Boolean existsByName(String name);

}
