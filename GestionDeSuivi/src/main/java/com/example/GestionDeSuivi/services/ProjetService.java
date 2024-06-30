package com.example.GestionDeSuivi.services;



import java.util.List;

import com.example.GestionDeSuivi.dto.ProjetDto;


public interface ProjetService {
    ProjetDto save(ProjetDto projetDto);

    ProjetDto findById(Integer id);

    List<ProjetDto> findAll();

    void delete(Integer id);
    
}
