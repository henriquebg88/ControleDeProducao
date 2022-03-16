package com.henrique.controleproducao.services;

import com.henrique.controleproducao.dao.ActivitiesRepository;
import com.henrique.controleproducao.dao.ActivityDAO;
import com.henrique.controleproducao.entity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityServices {

    @Autowired
    ActivitiesRepository activitiesRepository;

    @Autowired
    ActivityDAO activityDAO;

    public Activity save(Activity activity){
        return activitiesRepository.save(activity);
    };

    public Activity findUnfinished(){
        return  activityDAO.findUnfinishedActivity();
    }

}
