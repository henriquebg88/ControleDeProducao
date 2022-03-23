package com.henrique.controleproducao.controller;

import com.henrique.controleproducao.entity.Organization;
import com.henrique.controleproducao.services.OrganizationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/organizations")
public class OrganizationsController {

    @Autowired
    private OrganizationServices organizationServices;


    @GetMapping("")
    public String showOrganizations(Model model) {

        var organizations = organizationServices.findAll();

        model.addAttribute("organizations", organizations);
        model.addAttribute("now", LocalDateTime.now());

        return "organizations/organizations-home";
    }

    @GetMapping("/{id}")
    public String showOrganization(@PathVariable("id") int id, Model model){

        var organization = organizationServices.findById(id);

        model.addAttribute("organization", organization);
        model.addAttribute("now", LocalDateTime.now());

        return "organizations/organizations-profile";
    }

    @GetMapping("/create")
    public String createOrganization(Model model){

        model.addAttribute("organization", new Organization());
        model.addAttribute("now", LocalDateTime.now());

        return "organizations/organizations-form";
    }

    @GetMapping("/update")
    public String updateOrganization(@RequestParam("id") int id, Model model){

        var organization = organizationServices.findById(id);
        model.addAttribute("organization", organization);
        model.addAttribute("now", LocalDateTime.now());

        return "organizations/organizations-form";
    }

    @PostMapping("/save")
    public String saveOrganization(@ModelAttribute("organization") Organization organization, Model model){

        organizationServices.save(organization);

        return "redirect:/organizations";
    }

    @GetMapping("/delete")
    public String deleteOrganization(@RequestParam("id") int id, Model model){

        organizationServices.deleteById(id);

        return "redirect:/organizations";
    }

}
