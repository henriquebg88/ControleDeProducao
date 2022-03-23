package com.henrique.controleproducao.controller;

import com.henrique.controleproducao.entity.Activity;
import com.henrique.controleproducao.entity.Phase;
import com.henrique.controleproducao.entity.Project;
import com.henrique.controleproducao.services.ActivityServices;
import com.henrique.controleproducao.services.OrganizationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private OrganizationServices organizationServices;

    @Autowired
    private ActivityServices activityServices;

    @GetMapping("")
    public String showHomePage(Model model){
        model.addAttribute("now", LocalDateTime.now());

        var unfinishedActivity = activityServices.findUnfinished();

        model.addAttribute("unfinishedActivity", unfinishedActivity);

        return "/activities/activity-home";
    }

    @PostMapping("/update")
    public String showUpdateActivityForm(
            @RequestParam("hora") int horaFim,
            @RequestParam("minuto") int minutoFim,
            Model model){


        var organizations = organizationServices.findAll();
        var unfinishedActivity = activityServices.findUnfinished();

        unfinishedActivity.setActivity_end(LocalDateTime.of(LocalDate.now(), LocalTime.of(horaFim, minutoFim)));

        List<Project> projects = null;
        List<Phase> phases = null;

        //Passar os projetos da primeira organização (selecionada como padrão, no momento)
        if(!organizations.isEmpty()){
            projects = organizations.get(0).getProjects();
            //Passar as etapas do primeiro projeto (selecionado como padrão, no momento)
            if(!projects.isEmpty()){
                phases = projects.get(0).getPhases();
            }
        }


        model.addAttribute("now", LocalDateTime.now());
        model.addAttribute("projects", projects);
        model.addAttribute("phases", phases);
        model.addAttribute("activity", unfinishedActivity);
        model.addAttribute("organizations", organizations);

        return "activities/activities-form";
    }

    @PostMapping("/create")
    public String startActivity(@RequestParam("hora") int hora, @RequestParam("minuto") int minuto, Model model){
        model.addAttribute("now", LocalDateTime.now());

        var startDate = LocalDateTime.of(LocalDate.now(), LocalTime.of(hora, minuto));
        var activity = new Activity();
        activity.setActivity_start(startDate);

        activityServices.save(activity);

        return "redirect:/activities";
    };

    @PostMapping("/save")
    public String saveActivity(@ModelAttribute Activity activity){

        activityServices.save(activity);

        return "redirect:/activities";
    }

}
