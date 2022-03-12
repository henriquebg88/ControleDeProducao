package com.henrique.controleproducao.controller;

import com.henrique.controleproducao.entity.Organization;
import com.henrique.controleproducao.services.OrganizationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;

@Controller
@RequestMapping("/organizations")
public class OrganizationController {

    @Autowired
    private OrganizationServices organizationServices;

    @GetMapping
    public String showOrganizations(Model model) {

        var organizations = organizationServices.findAll();
        model.addAttribute("organizations", organizations);
        model.addAttribute("teste", "aaaaaaaahhh");

        return "organizations/organizations-home";
    }

    @GetMapping("/create")
    public String create(Model model){

        model.addAttribute("organization", new Organization());

        return "organizations/organizations-form";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model){

        var organization = organizationServices.findById(id);
        model.addAttribute("organization", organization);

        return "organizations/organizations-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("organization") Organization organization){

        organizationServices.save(organization);

        return "redirect:/organizations";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id){

        organizationServices.deleteById(id);

        return "redirect:/organizations";
    }

}
