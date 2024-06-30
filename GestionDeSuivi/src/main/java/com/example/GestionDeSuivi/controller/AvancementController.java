package com.example.GestionDeSuivi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestionDeSuivi.controller.api.AvancementApi;
import com.example.GestionDeSuivi.dto.AvancementDto;
import com.example.GestionDeSuivi.services.AvancementService;
@RestController
public class AvancementController implements AvancementApi {
    
      @Autowired
    private AvancementService avancementService;

    @Override
    public AvancementDto save(AvancementDto avancementDto) {
        return avancementService.save(avancementDto);
    }

    @Override
    public AvancementDto findById(Integer idAvancement) {
        return avancementService.findById(idAvancement);
    }

    @Override
    public List<AvancementDto> findAll() {
        return avancementService.findAll();
    }

    @Override
    public void delete(Integer idAvancement) {
        avancementService.delete(idAvancement);
    }
}
