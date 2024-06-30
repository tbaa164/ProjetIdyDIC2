package com.example.GestionDeSuivi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GestionDeSuivi.model.Incident;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Integer> {
    
}
