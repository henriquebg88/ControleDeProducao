package com.henrique.controleproducao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String short_description;
    private String details;
    private LocalDateTime activity_start;
    private LocalDateTime activity_end;

    @ManyToOne
    private Phase phase;



    public Activity() {
    }

    public Activity(String short_description, String details, LocalDateTime activity_start, LocalDateTime activity_end, Phase phase) {
        this.short_description = short_description;
        this.details = details;
        this.activity_start = activity_start;
        this.activity_end = activity_end;
        this.phase = phase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return getId() == activity.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    public LocalDateTime getActivity_end() {
        return activity_end;
    }

    public void setActivity_end(LocalDateTime activity_end) {
        this.activity_end = activity_end;
    }

    public LocalDateTime getActivity_start() {
        return activity_start;
    }

    public void setActivity_start(LocalDateTime activity_start) {
        this.activity_start = activity_start;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }
}
