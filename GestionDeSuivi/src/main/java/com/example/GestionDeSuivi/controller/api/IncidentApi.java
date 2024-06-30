package com.example.GestionDeSuivi.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.GestionDeSuivi.dto.IncidentDto;

public interface IncidentApi {
    @PostMapping(value = "/incidents/create", consumes = "application/json", produces = "application/json")
    IncidentDto save(@RequestBody IncidentDto incidentDto);

    @GetMapping(value = "/incidents/{idIncident}", produces = "application/json")
    IncidentDto findById(@PathVariable("idIncident") Integer idIncident);

    @GetMapping(value = "/incidents/all", produces = "application/json")
    List<IncidentDto> findAll();

    @DeleteMapping(value = "/incidents/delete/{idIncident}")
    void delete(@PathVariable("idIncident") Integer idIncident);
}
