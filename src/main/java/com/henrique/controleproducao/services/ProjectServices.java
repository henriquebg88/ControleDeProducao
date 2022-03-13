package com.henrique.controleproducao.services;

import com.henrique.controleproducao.dao.ProjectsRepository;
import com.henrique.controleproducao.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServices {

    @Autowired
    private ProjectsRepository projectsRepository;

    public Project findById(int id){
        var response = projectsRepository.findById(id);

        if(response.isEmpty()){
            return null;
        }

        return response.get();
    }

    public Project save(Project project){
        var createdProject = projectsRepository.save(project);
        return createdProject;
    }

    public void delete(int id){
        projectsRepository.deleteById(id);
    }

    public void delete(Project project){
        projectsRepository.delete(project);
    }
}
