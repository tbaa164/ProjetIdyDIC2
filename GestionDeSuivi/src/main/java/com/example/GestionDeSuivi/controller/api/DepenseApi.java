package com.example.GestionDeSuivi.controller.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.GestionDeSuivi.dto.DepenseDto;

public interface DepenseApi {
     @PostMapping(value = "/depenses/create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    DepenseDto save(@RequestBody DepenseDto depenseDto);

    @GetMapping(value = "/depenses/{idDepense}", produces=MediaType.APPLICATION_JSON_VALUE)
    DepenseDto findById(@PathVariable("idDepense") Integer idDepense);

    @GetMapping(value = "/depenses/all", produces=MediaType.APPLICATION_JSON_VALUE)
    List<DepenseDto> findAll();

    @DeleteMapping(value = "/depenses/delete/{idDepense}")
    void delete(@PathVariable("idDepense") Integer idDepense);
}
