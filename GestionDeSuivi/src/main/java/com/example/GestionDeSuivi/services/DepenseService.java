package com.example.GestionDeSuivi.services;

import java.util.List;

import com.example.GestionDeSuivi.dto.DepenseDto;

public interface DepenseService {
     DepenseDto save(DepenseDto depenseDto);
    DepenseDto findById(Integer id);
    List<DepenseDto> findAll();
    void delete(Integer id);
}
