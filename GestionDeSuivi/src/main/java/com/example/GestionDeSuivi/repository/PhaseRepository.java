package com.example.GestionDeSuivi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GestionDeSuivi.model.Phase;

@Repository
public interface PhaseRepository extends JpaRepository<Phase, Integer>{
    List<Phase> findByProjet_id(Integer idProjet);
    
}
