package com.example.GestionDeSuivi.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.GestionDeSuivi.dto.PhaseDto;

public interface PhaseApi {
    @PostMapping(value = "/phases/create", consumes = "application/json", produces = "application/json")
    PhaseDto save(@RequestBody PhaseDto phaseDto);

    @GetMapping(value = "/phases/{idPhase}", produces = "application/json")
    PhaseDto findById(@PathVariable("idPhase") Integer idPhase);

    @GetMapping(value = "/phases/all", produces = "application/json")
    List<PhaseDto> findAll();

    @DeleteMapping(value = "/phases/delete/{idPhase}")
    void delete(@PathVariable("idPhase") Integer idPhase);

    @GetMapping(value = "/phases/projet/{idProjet}", produces = "application/json")
    List<PhaseDto> findByProjet(@PathVariable("idProjet") Integer idProjet);

    
}
