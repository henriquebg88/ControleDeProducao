package com.henrique.controleproducao.controller.api;

import com.henrique.controleproducao.dao.OrganizationsRepository;
import com.henrique.controleproducao.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationApiController {

    OrganizationsRepository organizationsRepository;

    @Autowired
    public OrganizationApiController(OrganizationsRepository organizationsRepository) {
        this.organizationsRepository = organizationsRepository;
    }

    @GetMapping("")
    public List<Organization> findAll(){
        return organizationsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Organization findById(@PathVariable int id){
        return organizationsRepository.findById(id);
    }

    @PostMapping("")
    public void add(@RequestBody Organization organization){
        organization.setId(0);
        organizationsRepository.save(organization);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id ,@RequestBody Organization organization){
        organization.setId(id);
        organizationsRepository.save(organization);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        organizationsRepository.deleteById(id);
    }
}
