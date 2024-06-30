package com.example.GestionDeSuivi.services;

import java.util.List;

import com.example.GestionDeSuivi.dto.IncidentDto;

public interface IncidentService {
     IncidentDto save(IncidentDto incidentDto);
    IncidentDto findById(Integer id);
    List<IncidentDto> findAll();
    void delete(Integer id);
}
