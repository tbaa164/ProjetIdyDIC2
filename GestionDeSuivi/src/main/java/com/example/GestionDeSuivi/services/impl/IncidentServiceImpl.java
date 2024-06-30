package com.example.GestionDeSuivi.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.GestionDeSuivi.dto.IncidentDto;
import com.example.GestionDeSuivi.model.Incident;
import com.example.GestionDeSuivi.repository.IncidentRepository;
import com.example.GestionDeSuivi.services.IncidentService;

@Service
public class IncidentServiceImpl implements IncidentService{

    @Autowired
    private IncidentRepository incidentRepository;

    @Override
    public IncidentDto save(IncidentDto incidentDto) {
     Incident incident = IncidentDto.toEntity(incidentDto);
        Incident incidenEnregistre = incidentRepository.save(incident);
        return IncidentDto.fromEntity(incidenEnregistre);   
    }

    @Override
    public IncidentDto findById(Integer id) {
           Optional<Incident> optionalIncident = incidentRepository.findById(id);
        if (optionalIncident.isPresent()) {
            return IncidentDto.fromEntity(optionalIncident.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Incident introuvable");
        }
    }

    @Override
    public List<IncidentDto> findAll() {
         return incidentRepository.findAll().stream()
                .map(IncidentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        incidentRepository.deleteById(id);
    }
    
}
