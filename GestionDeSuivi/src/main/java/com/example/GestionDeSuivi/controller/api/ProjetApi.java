package com.example.GestionDeSuivi.controller.api;


import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.GestionDeSuivi.dto.ProjetDto;

public interface ProjetApi {
    
    @PostMapping(value = "/projets/create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    ProjetDto save(@RequestBody ProjetDto projetDto);

    @GetMapping(value = "/projets/{idProjet}", produces=MediaType.APPLICATION_JSON_VALUE)
   ProjetDto findById(@PathVariable("idProjet") Integer idProjet);

    @GetMapping(value = "/projets/all", produces=MediaType.APPLICATION_JSON_VALUE)
    List<ProjetDto> findAll();

     @DeleteMapping(value = "/projets/delete/{idProjet}")
    void delete(@PathVariable("idProjet") Integer idProjet);
}
