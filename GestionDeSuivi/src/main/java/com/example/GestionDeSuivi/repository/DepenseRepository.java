package com.example.GestionDeSuivi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GestionDeSuivi.model.Depense;

@Repository
public interface DepenseRepository extends JpaRepository<Depense, Integer>{
    
}
