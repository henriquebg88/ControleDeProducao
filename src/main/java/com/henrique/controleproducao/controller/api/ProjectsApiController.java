package com.henrique.controleproducao.controller.api;

import com.henrique.controleproducao.entity.Project;
import com.henrique.controleproducao.services.ProjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/projects")
public class ProjectsApiController {

    @Autowired
    private ProjectServices projectServices;

    @GetMapping("/organization/{id}")
    public List<Project> findByOrganizationId(@PathVariable int id){


        var projectsFromOrganization = projectServices.findByOrganizationId(id);


        return projectsFromOrganization;
    }

}
