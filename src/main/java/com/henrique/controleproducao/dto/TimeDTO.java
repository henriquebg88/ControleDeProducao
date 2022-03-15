package com.henrique.controleproducao.dto;

import org.springframework.stereotype.Component;

@Component
public class TimeDTO {

    private int minute;
    private int hour;

    public TimeDTO(){}

    public TimeDTO(int minute, int hour) {
        this.minute = minute;
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
}
