package com.henrique.controleproducao.services;

import com.henrique.controleproducao.dao.PhasesRepository;
import com.henrique.controleproducao.entity.Phase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhaseServices {

    @Autowired
    private PhasesRepository phasesRepository;

    public Phase save(Phase phase){
        var newPhase = phasesRepository.save(phase);

        return newPhase;
    }

    public Phase findById(int id){
        var response = phasesRepository.findById(id);
        if (response.isEmpty()) return null;
        return response.get();
    }

    public Phase deleteById(int id){
        var phase = findById(id);
        if(phase != null){
            phasesRepository.deleteById(id);
            return phase;
        }
        return null;
    }

}
