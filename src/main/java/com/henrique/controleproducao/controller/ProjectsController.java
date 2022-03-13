package com.henrique.controleproducao.controller;

import com.henrique.controleproducao.services.ProjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/projects")
public class ProjectsController {

    @Autowired
    private ProjectServices projectServices;

    private void definirHoraData(Model model){
        var date = new Date();
        var formatHora = new SimpleDateFormat("HH:MM");
        var formatData = new SimpleDateFormat("EEEE, dd MMMM");

        model.addAttribute("hora", formatHora.format(date));
        model.addAttribute("data", formatData.format(date));
    }

    @GetMapping("/{id}")
    public String showProject(@PathVariable("id") int id, Model model){
        definirHoraData(model);

        var project = projectServices.findById(id);

        model.addAttribute("project", project);

        return null;
    }

    @GetMapping("/create")
    public String createProject(Model model){
        definirHoraData(model);

        //Passar para o form um objeto Project apenas com organization_id

        return "projects/projects-form";
    }

    @GetMapping("/update")
    public String updateProject(Model model){
        definirHoraData(model);

        //Passar para o form um objeto Project com tudo preenchido.

        return "projects/projects-form";
    }

}
