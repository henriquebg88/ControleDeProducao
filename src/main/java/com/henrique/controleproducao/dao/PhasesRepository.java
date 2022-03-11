package com.henrique.controleproducao.dao;

import com.henrique.controleproducao.entity.Phase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "phases")
public interface PhasesRepository extends JpaRepository<Phase, Integer> {
}
