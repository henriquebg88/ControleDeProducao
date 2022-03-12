package com.henrique.controleproducao.services;

import com.henrique.controleproducao.dao.OrganizationsRepository;
import com.henrique.controleproducao.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class OrganizationServices {

    @Autowired
    private OrganizationsRepository organizationsRepo;

    public List<Organization> findAll(){
        return organizationsRepo.findAll();
    }
    public void save(Organization organization){ organizationsRepo.save(organization);}
    public Organization findById(int id){ return organizationsRepo.findById(id); }
    public boolean deleteById(int id){ return organizationsRepo.deleteById(id); }

}
