package com.example.GestionDeSuivi.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.GestionDeSuivi.dto.DepenseDto;
import com.example.GestionDeSuivi.model.Depense;
import com.example.GestionDeSuivi.repository.DepenseRepository;
import com.example.GestionDeSuivi.services.DepenseService;

@Service
public class DepenseServiceImpl implements DepenseService {

    @Autowired
    private DepenseRepository depenseRepository;

    @Override
    public DepenseDto save(DepenseDto depenseDto) {
       Depense depense = DepenseDto.toEntity(depenseDto);
       Depense depenseEnregistre = depenseRepository.save(depense);
       return DepenseDto.fromEntity(depenseEnregistre);
    }

    @Override
    public DepenseDto findById(Integer id) {
    Optional<Depense> optionalDepense = depenseRepository.findById(id);
    if(optionalDepense.isPresent()) {
        return DepenseDto.fromEntity(optionalDepense.get());   
    }else
    {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Depense introuvable");
    }
}

    @Override
    public List<DepenseDto> findAll() {
     return depenseRepository.findAll().stream()
                .map(DepenseDto::fromEntity)
                .collect(Collectors.toList());    
    }

    @Override
    public void delete(Integer id) {
        depenseRepository.deleteById(id);
    }
    
}
