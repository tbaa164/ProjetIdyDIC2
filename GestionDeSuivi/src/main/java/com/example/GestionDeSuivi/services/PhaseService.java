package com.example.GestionDeSuivi.services;

import java.util.List;

import com.example.GestionDeSuivi.dto.PhaseDto;

public interface PhaseService {
     PhaseDto save(PhaseDto phaseDto);
    PhaseDto findById(Integer id);
    List<PhaseDto> findAll();
    List<PhaseDto> findByProjet(Integer idProjet);
    void delete(Integer id);
}
