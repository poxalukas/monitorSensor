package com.fiesc.monitor.repository;

import com.fiesc.monitor.entity.LinhaProducao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LinhaProducaoRepository extends JpaRepository<LinhaProducao, Long>, JpaSpecificationExecutor<LinhaProducao> {
}
