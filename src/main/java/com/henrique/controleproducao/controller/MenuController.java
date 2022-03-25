package com.henrique.controleproducao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @GetMapping
    public String showMenu(Model model){

        model.addAttribute("now", LocalDateTime.now());

        return "menu/menu";
    }

}
