package com.henrique.controleproducao.dao;

import com.henrique.controleproducao.entity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class ActivityDAO{

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Activity findUnfinishedActivity() {
        Activity unfinishedActivity = null;

        try {
            unfinishedActivity = entityManager
                    .createQuery(   "SELECT a FROM Activity a WHERE a.activity_end IS NULL", Activity.class)
                    .getSingleResult();
        }catch (NoResultException e){

        }

        return unfinishedActivity;
    }
}
