package com.henrique.controleproducao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;

@Controller
@RequestMapping("/teste")
public class OrganizationController {

    @GetMapping
    public String showOrganizations() {
        return "organizations-home";
    }

}
