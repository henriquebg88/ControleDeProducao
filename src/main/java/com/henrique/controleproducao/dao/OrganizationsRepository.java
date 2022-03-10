package com.henrique.controleproducao.dao;

import com.henrique.controleproducao.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class OrganizationsRepository {

    private EntityManager entityManager;

    @Autowired
    public OrganizationsRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Transactional
    public List<Organization> findAll(){
        var query = entityManager.createQuery("from Organization", Organization.class);
        var organizations = query.getResultList();
        return organizations;
    }

    @Transactional
    public Organization findById(int id){
        return entityManager.find(Organization.class, id);
    }

    @Transactional
    public void save(Organization organization){
        entityManager.merge(organization);
    }

    @Transactional
    public void deleteById(int id){
        var query = entityManager.createQuery("delete from Organization where id=:id");
        query.setParameter("id",id);
        query.executeUpdate();
    }

}
