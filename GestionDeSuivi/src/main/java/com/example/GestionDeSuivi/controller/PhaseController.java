package com.example.GestionDeSuivi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestionDeSuivi.controller.api.PhaseApi;
import com.example.GestionDeSuivi.dto.PhaseDto;
import com.example.GestionDeSuivi.services.PhaseService;
@RestController
public class PhaseController implements PhaseApi {
    
     @Autowired
    private PhaseService phaseService;

    @Override
    public PhaseDto save(PhaseDto phaseDto) {
        return phaseService.save(phaseDto);
    }

    @Override
    public PhaseDto findById(Integer idPhase) {
        return phaseService.findById(idPhase);
    }

    @Override
    public List<PhaseDto> findAll() {
        return phaseService.findAll();
    }

    @Override
    public void delete(Integer idPhase) {
        phaseService.delete(idPhase);
    }

    @Override
    public List<PhaseDto> findByProjet(Integer idProjet) {
        return phaseService.findByProjet(idProjet);
    }
}
