package com.henrique.controleproducao.controller;

import com.henrique.controleproducao.common.DataHoraServices;
import com.henrique.controleproducao.entity.Organization;
import com.henrique.controleproducao.entity.Project;
import com.henrique.controleproducao.services.OrganizationServices;
import com.henrique.controleproducao.services.ProjectServices;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/projects")
public class ProjectsController {

    @Autowired
    private ProjectServices projectServices;
    @Autowired
    private OrganizationServices organizationServices;
    @Autowired
    private DataHoraServices dataHoraServices;

    @GetMapping("/{id}")
    public String showProject(@PathVariable("id") int id, Model model){
        dataHoraServices.definirModelHoraData(model);

        var project = projectServices.findById(id);
//        var organization = organizationServices.findById(project.getOrganization_id());

        model.addAttribute("project", project);
//        model.addAttribute("organization", organization);

        return "projects/projects-profile";
    }

    @GetMapping("/create")
    public String createProject(@RequestParam("organization_id") int organization_id, Model model){
        dataHoraServices.definirModelHoraData(model);

        var organization = new Organization();
        organization.setId(organization_id);
        var project = new Project();

        project.setId(0);
        project.setOrganization(organization);

        model.addAttribute("project", project);

        return "projects/projects-form";
    }

    @GetMapping("/update")
    public String updateProject(@RequestParam("id") int id, Model model){
        dataHoraServices.definirModelHoraData(model);

        var project = projectServices.findById(id);

        model.addAttribute("project", project);

        return "projects/projects-form";
    }

    @PostMapping("/save")
    public String saveProject(@ModelAttribute("project") Project project){

        projectServices.save(project);

        return "redirect:/organizations/" + project.getOrganization().getId();
    }

    @GetMapping("/delete")
    public String deleteProject(@RequestParam("id") int id){
        var projectToBeDeleted = projectServices.findById(id);
        projectServices.delete(projectToBeDeleted);

        return "redirect:/organizations/" + projectToBeDeleted.getOrganization().getId();
    }

}
