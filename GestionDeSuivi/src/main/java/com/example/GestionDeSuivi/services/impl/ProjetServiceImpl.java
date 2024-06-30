package com.example.GestionDeSuivi.services.impl;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.GestionDeSuivi.dto.IncidentDto;
import com.example.GestionDeSuivi.dto.PhaseDto;
import com.example.GestionDeSuivi.dto.ProjetDto;
import com.example.GestionDeSuivi.model.Depense;
import com.example.GestionDeSuivi.model.Incident;
import com.example.GestionDeSuivi.model.Phase;
import com.example.GestionDeSuivi.model.Projet;
import com.example.GestionDeSuivi.repository.DepenseRepository;
import com.example.GestionDeSuivi.repository.IncidentRepository;
import com.example.GestionDeSuivi.repository.PhaseRepository;
import com.example.GestionDeSuivi.repository.ProjetRepository;
import com.example.GestionDeSuivi.services.ProjetService;


@Service
public class ProjetServiceImpl implements ProjetService {
    
    @Autowired
    private ProjetRepository projetRepository;

    @Autowired
    private DepenseRepository depenseRepository;

    @Autowired
    private IncidentRepository incidentRepository;

    @Autowired
    private PhaseRepository phaseRepository;

@Override
public ProjetDto save(ProjetDto projetDto) {
    Projet projet = ProjetDto.toEntity(projetDto);
    Projet projetEnregistre = projetRepository.save(projet);

    //sauvegardons les depenses
    if (projetDto.getDepense() != null) {
        projetDto.getDepense().forEach(DepenseDto -> {
            Depense depense = DepenseDto.toEntity(DepenseDto);
            depense.setProjet(projetEnregistre);
            depenseRepository.save(depense);
        });
    }

     // Sauvegarde des incidents
    if (projetDto.getIncident() != null) {
        projetDto.getIncident().forEach(incidentDto -> {
            Incident incident = IncidentDto.toEntity(incidentDto);
            incident.setProjet(projetEnregistre);
            incidentRepository.save(incident);
        });
    }

     // Sauvegarde des phases
    if (projetDto.getPhases() != null) {
        projetDto.getPhases().forEach(phaseDto -> {
            Phase phase = PhaseDto.toEntity(phaseDto);
            phase.setProjet(projetEnregistre);
            phaseRepository.save(phase);
        });
    }

    return ProjetDto.fromEntity(projet);
}
  
  @Override
public ProjetDto findById(Integer id) {
    Optional<Projet> optionalProjet = projetRepository.findById(id);
    if (optionalProjet.isPresent()) {
        Projet projet = optionalProjet.get();
        return ProjetDto.fromEntity(projet);
    } else {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Projet introuvable");
    }
}


    @Override
    public List<ProjetDto> findAll() {
      return projetRepository.findAll().stream()
                .map(ProjetDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
      projetRepository.deleteById(id);
    }
}
