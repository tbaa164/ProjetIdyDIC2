package com.example.GestionDeSuivi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestionDeSuivi.controller.api.IncidentApi;
import com.example.GestionDeSuivi.dto.IncidentDto;
import com.example.GestionDeSuivi.services.IncidentService;
@RestController
public class IncidentController implements IncidentApi {
    @Autowired
    private IncidentService incidentService;

    @Override
    public IncidentDto save(IncidentDto incidentDto) {
        return incidentService.save(incidentDto);
    }

    @Override
    public IncidentDto findById(Integer idIncident) {
        return incidentService.findById(idIncident);
    }

    @Override
    public List<IncidentDto> findAll() {
        return incidentService.findAll();
    }

    @Override
    public void delete(Integer idIncident) {
        incidentService.delete(idIncident);
    }
}
