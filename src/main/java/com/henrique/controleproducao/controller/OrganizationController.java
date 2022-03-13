package com.henrique.controleproducao.controller;

import com.henrique.controleproducao.entity.Organization;
import com.henrique.controleproducao.services.OrganizationServices;
import com.henrique.controleproducao.services.ProjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.OffsetTime;
import java.util.Date;

@Controller
@RequestMapping("/organizations")
public class OrganizationController {

    @Autowired
    private OrganizationServices organizationServices;

    private void definirHoraData(Model model){
        var date = new Date();
        var formatHora = new SimpleDateFormat("HH:MM");
        var formatData = new SimpleDateFormat("EEEE, dd MMMM");

        model.addAttribute("hora", formatHora.format(date));
        model.addAttribute("data", formatData.format(date));
    }

    @GetMapping
    public String showOrganizations(Model model) {

        var organizations = organizationServices.findAll();

        model.addAttribute("organizations", organizations);
        definirHoraData(model);

        return "organizations/organizations-home";
    }

    @GetMapping("/{id}")
    public String showOrganization(@PathVariable    ("id") int id, Model model){

        var organization = organizationServices.findById(id);

        model.addAttribute("organization", organization);
        definirHoraData(model);

        return "organizations/organizations-profile";
    }

    @GetMapping("/create")
    public String createOrganization(Model model){

        model.addAttribute("organization", new Organization());
        definirHoraData(model);

        return "organizations/organizations-form";
    }

    @GetMapping("/update")
    public String updateOrganization(@RequestParam("id") int id, Model model){

        var organization = organizationServices.findById(id);
        model.addAttribute("organization", organization);
        definirHoraData(model);

        return "organizations/organizations-form";
    }

    @PostMapping("/save")
    public String saveOrganization(@ModelAttribute("organization") Organization organization, Model model){

        organizationServices.save(organization);
        definirHoraData(model);

        return "redirect:/organizations";
    }

    @GetMapping("/delete")
    public String deleteOrganization(@RequestParam("id") int id, Model model){

        organizationServices.deleteById(id);
        definirHoraData(model);

        return "redirect:/organizations";
    }

}
