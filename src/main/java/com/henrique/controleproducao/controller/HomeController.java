package com.henrique.controleproducao.controller;

import com.henrique.controleproducao.common.DataHoraServices;
import com.henrique.controleproducao.dto.TimeDTO;
import com.henrique.controleproducao.entity.Activity;
import com.henrique.controleproducao.services.OrganizationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    private DataHoraServices dataHoraServices;

    @Autowired
    private OrganizationServices organizationServices;

    @GetMapping("")
    public String showHomePage(Model model){
        dataHoraServices.definirModelHoraData(model);

        model.addAttribute("time", new TimeDTO(LocalTime.now().getMinute(), LocalTime.now().getHour()));

        return "index";
    }

    @PostMapping("/activities/form")
    public String showActivityForm(@RequestParam("hora") int hora, @RequestParam("minuto") int minuto, Model model){
        dataHoraServices.definirModelHoraData(model);

        var startDate = LocalDateTime.of(LocalDate.now(), LocalTime.of(hora, minuto));
//        var organizations = organizationServices.findAll();


        var activity = new Activity();
        activity.setActivity_start(startDate);

        //!! CORRIGIR
        //Passar todos os projetos
        //Carregar por ajax as etapas do projeto selecionado

//        model.addAttribute("projects", projects);
        model.addAttribute("activity", activity);

        return "activities/activities-form";
    }

}
