package com.fiesc.monitor.repository;

import com.fiesc.monitor.entity.Maquina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MaquinaRepository extends JpaRepository<Maquina, Long>, JpaSpecificationExecutor<Maquina> {
}
