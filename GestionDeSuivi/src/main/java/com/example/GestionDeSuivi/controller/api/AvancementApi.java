package com.example.GestionDeSuivi.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.GestionDeSuivi.dto.AvancementDto;

public interface AvancementApi {
    @PostMapping(value = "/avancements/create", consumes = "application/json", produces = "application/json")
    AvancementDto save(@RequestBody AvancementDto avancementDto);

    @GetMapping(value = "/avancements/{idAvancement}", produces = "application/json")
    AvancementDto findById(@PathVariable("idAvancement") Integer idAvancement);

    @GetMapping(value = "/avancements/all", produces = "application/json")
    List<AvancementDto> findAll();

    @DeleteMapping(value = "/avancements/delete/{idAvancement}")
    void delete(@PathVariable("idAvancement") Integer idAvancement);
}
