package com.henrique.controleproducao.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "phases")
public class Phase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int sort;
    private int project_id;

    @OneToMany(mappedBy = "phase_id")
    private List<Activity> activities;

    public Phase() {
    }

    public Phase(String name, int sort, int project_id, List<Activity> activities) {
        this.name = name;
        this.sort = sort;
        this.project_id = project_id;
        this.activities = activities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phase phase = (Phase) o;
        return getId() == phase.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }
}
