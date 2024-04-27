package com.fiesc.monitor.repository;

import com.fiesc.monitor.entity.DadosSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosSensorRepository extends JpaRepository<DadosSensor, Long>, JpaSpecificationExecutor<DadosSensor> {
}
