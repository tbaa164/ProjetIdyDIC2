package com.example.GestionDeSuivi.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.GestionDeSuivi.dto.PhaseDto;
import com.example.GestionDeSuivi.model.Phase;
import com.example.GestionDeSuivi.repository.PhaseRepository;
import com.example.GestionDeSuivi.services.PhaseService;


@Service
public class PhaseServiceImpl implements PhaseService {

    @Autowired
    private PhaseRepository phaseRepository;

    @Override
    public PhaseDto save(PhaseDto phaseDto) {
          Phase phase = PhaseDto.toEntity(phaseDto);
        Phase phaseEnregistrer = phaseRepository.save(phase);
        return PhaseDto.fromEntity(phaseEnregistrer);
    }

    @Override
    public PhaseDto findById(Integer id) {
         Optional<Phase> optionalPhase = phaseRepository.findById(id);
        if (optionalPhase.isPresent()) {
            return PhaseDto.fromEntity(optionalPhase.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Phase introuvable");
        }
    }

    @Override
    public List<PhaseDto> findAll() {
       return phaseRepository.findAll().stream()
                .map(PhaseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override

    public void delete(Integer id) {
        phaseRepository.deleteById(id);
    }

    @Override
public List<PhaseDto> findByProjet(Integer idProjet) {
    return phaseRepository.findByProjet_id(idProjet).stream()
            .map(PhaseDto::fromEntity)
            .collect(Collectors.toList());
}

}
