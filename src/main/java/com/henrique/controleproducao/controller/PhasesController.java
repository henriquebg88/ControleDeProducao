package com.henrique.controleproducao.controller;

import com.henrique.controleproducao.entity.Phase;
import com.henrique.controleproducao.entity.Project;
import com.henrique.controleproducao.services.PhaseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/phases")
public class PhasesController {

    @Autowired
    private PhaseServices phaseServices;


    @GetMapping("/create")
    public String createPhase(@RequestParam("project_id") int project_id, Model model){
        model.addAttribute("now", LocalDateTime.now());

        //Passar o ID do projeto
        var project = new Project();
        project.setId(project_id);

        var phase = new Phase();
        phase.setProject(project);

        model.addAttribute("phase", phase);

        return "phases/phases-form";
    }

    @GetMapping("/update")
    public String updatePhase(@RequestParam("id") int id, Model model){
        model.addAttribute("now", LocalDateTime.now());

        //Passar o objeto completo
        var phase = phaseServices.findById(id);

        model.addAttribute("phase", phase);

        return "phases/phases-form";
    }

    @PostMapping("/save")
    public String savePhase(@ModelAttribute("phase") Phase phase){

        var createdPhase = phaseServices.save(phase);

        return "redirect:/projects/" + createdPhase.getProject().getId();
    }

    @GetMapping("/delete")
    public String deletePhase(@RequestParam("id") int id){

        var deletedPhase = phaseServices.deleteById(id);

        return "redirect:/projects/" + deletedPhase.getProject().getId();
    }

}
