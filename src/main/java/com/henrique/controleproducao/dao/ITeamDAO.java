package com.henrique.controleproducao.dao;

import com.henrique.controleproducao.entity.Team;

import java.util.List;

public interface ITeamDAO {
    public List<Team> findAll();
    public Team findById();
    public Team save();
    public void remove();
}
