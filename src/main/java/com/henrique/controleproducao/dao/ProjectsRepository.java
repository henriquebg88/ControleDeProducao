package com.henrique.controleproducao.dao;

import com.henrique.controleproducao.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "projects")
public interface ProjectsRepository extends JpaRepository<Project, Integer> {
}
