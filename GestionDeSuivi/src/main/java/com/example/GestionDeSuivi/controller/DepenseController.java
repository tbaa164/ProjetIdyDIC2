package com.example.GestionDeSuivi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestionDeSuivi.controller.api.DepenseApi;
import com.example.GestionDeSuivi.dto.DepenseDto;
import com.example.GestionDeSuivi.services.DepenseService;

@RestController
public class DepenseController implements DepenseApi {
    
     @Autowired
    private DepenseService depenseService;

    @Override
    public DepenseDto save(DepenseDto depenseDto) {
        return depenseService.save(depenseDto);
    }

    @Override
    public DepenseDto findById(Integer idDepense) {
        return depenseService.findById(idDepense);
    }

    @Override
    public List<DepenseDto> findAll() {
        return depenseService.findAll();
    }

    @Override
    public void delete(Integer idDepense) {
        depenseService.delete(idDepense);
    }
}
