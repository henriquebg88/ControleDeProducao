package com.henrique.controleproducao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String redirect(){
        //Redirecionamento temporário
        return "redirect:/activities";
    }

}
