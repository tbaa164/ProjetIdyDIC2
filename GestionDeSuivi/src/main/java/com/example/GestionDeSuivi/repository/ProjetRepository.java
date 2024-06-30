package com.example.GestionDeSuivi.repository;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GestionDeSuivi.model.Projet;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Integer>{
   
}
