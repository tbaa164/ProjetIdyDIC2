package com.example.GestionDeSuivi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GestionDeSuivi.model.Avancement;

@Repository
public interface AvancementRepository extends JpaRepository<Avancement, Integer>{
  
    List<Avancement> findAllByPhase(Integer idPhase);
    
}