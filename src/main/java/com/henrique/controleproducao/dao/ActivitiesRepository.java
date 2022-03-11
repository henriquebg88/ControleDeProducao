package com.henrique.controleproducao.dao;

import com.henrique.controleproducao.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "activities")
public interface ActivitiesRepository extends JpaRepository<Activity, Integer> {
}
