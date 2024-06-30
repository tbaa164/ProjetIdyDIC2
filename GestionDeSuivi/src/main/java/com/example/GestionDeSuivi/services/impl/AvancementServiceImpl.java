package com.example.GestionDeSuivi.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.GestionDeSuivi.dto.AvancementDto;
import com.example.GestionDeSuivi.model.Avancement;
import com.example.GestionDeSuivi.repository.AvancementRepository;
import com.example.GestionDeSuivi.services.AvancementService;

@Service
public class AvancementServiceImpl implements AvancementService{

    @Autowired
    private AvancementRepository avancementRepository;
    
    @Override
    public AvancementDto save(AvancementDto avancementDto) {
        Avancement avancement = AvancementDto.toEntity(avancementDto);
        Avancement avancementEnregistre = avancementRepository.save(avancement);
        return AvancementDto.fromEntity(avancementEnregistre);
    }

    @Override
    
    public AvancementDto findById(Integer id) {
       Optional<Avancement> optionalAvancement = avancementRepository.findById(id);
        if (optionalAvancement.isPresent()) {
            return AvancementDto.fromEntity(optionalAvancement.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Avancement introuvable");
        }
    }

    @Override
    public List<AvancementDto> findAll() {
     return avancementRepository.findAll().stream()
                .map(AvancementDto::fromEntity)
                .collect(Collectors.toList());   
    }

    @Override
    public void delete(Integer id) {
        avancementRepository.deleteById(id);  
    }
    
}
