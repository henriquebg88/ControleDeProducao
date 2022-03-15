package com.henrique.controleproducao.controller;

import com.henrique.controleproducao.common.DataHoraServices;
import com.henrique.controleproducao.dto.TimeDTO;
import com.henrique.controleproducao.entity.Activity;
import com.henrique.controleproducao.entity.Phase;
import com.henrique.controleproducao.entity.Project;
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
    private DataHoraServices dataHoraServices;

    @Autowired
    private OrganizationServices organizationServices;

    @GetMapping("")
    public String showHomePage(Model model){
        dataHoraServices.definirModelHoraData(model);

        model.addAttribute("time", new TimeDTO(LocalTime.now().getMinute(), LocalTime.now().getHour()));

        return "/activities/activity-home";
    }

    @PostMapping("/form")
    public String showActivityForm(@RequestParam("hora") int hora, @RequestParam("minuto") int minuto, Model model){
        dataHoraServices.definirModelHoraData(model);

        var startDate = LocalDateTime.of(LocalDate.now(), LocalTime.of(hora, minuto));
        var organizations = organizationServices.findAll();
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

        var activity = new Activity();
        activity.setActivity_start(startDate);

        //Carregar por ajax as etapas do projeto selecionado
        //Passar organização que usuario estiver logado
        model.addAttribute("projects", projects);
        model.addAttribute("phases", phases);
        model.addAttribute("activity", activity);
        model.addAttribute("organizations", organizations);


        return "activities/activities-form";
    }

}
