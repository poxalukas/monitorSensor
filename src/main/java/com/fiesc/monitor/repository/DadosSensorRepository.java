package com.fiesc.monitor.repository;

import com.fiesc.monitor.entity.DadosSensor;
import com.fiesc.monitor.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DadosSensorRepository extends JpaRepository<DadosSensor, Long>, JpaSpecificationExecutor<DadosSensor> {

    List<DadosSensor> findFirst100BySensorOrderByTimestampDesc(Long sensorId);
}
