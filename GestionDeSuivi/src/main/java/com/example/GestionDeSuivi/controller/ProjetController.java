package com.example.GestionDeSuivi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestionDeSuivi.controller.api.ProjetApi;
import com.example.GestionDeSuivi.dto.ProjetDto;
import com.example.GestionDeSuivi.services.ProjetService;


@RestController
public class ProjetController implements ProjetApi{

    @Autowired
    private ProjetService projetService;

    public ProjetController(ProjetService projectService) {
        this.projetService = projectService;
    }

    @Override
    public ProjetDto save(ProjetDto dto) {
        return projetService.save(dto);   
    }

    @Override
    public ProjetDto findById(Integer id) {
        return projetService.findById(id);   
    }

    @Override
    public List<ProjetDto> findAll() {
       return projetService.findAll();
    }

    @Override
    public void delete(Integer id) {
        projetService.delete(id);   
    }
    
}
