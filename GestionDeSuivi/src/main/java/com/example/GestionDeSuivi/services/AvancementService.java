package com.example.GestionDeSuivi.services;

import java.util.List;

import com.example.GestionDeSuivi.dto.AvancementDto;

public interface AvancementService {
    AvancementDto save(AvancementDto avancementDto);
    AvancementDto findById(Integer id);
    List<AvancementDto> findAll();
    void delete(Integer id);
}
