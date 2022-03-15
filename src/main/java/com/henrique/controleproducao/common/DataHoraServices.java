package com.henrique.controleproducao.common;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DataHoraServices {

    public void definirModelHoraData(Model model){
        var date = new Date();

        var formatHora = new SimpleDateFormat("HH");
        var formatMinuto = new SimpleDateFormat("mm");
        var formatData = new SimpleDateFormat("EEEE, dd MMMM");

        model.addAttribute("hora", formatHora.format(date));
        model.addAttribute("minuto", formatMinuto.format(date));
        model.addAttribute("data", formatData.format(date));
    }

}
