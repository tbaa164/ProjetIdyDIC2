package com.example.GestionDeSuivi.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.GestionDeSuivi.model.Intitule;
import com.example.GestionDeSuivi.model.Projet;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjetDto {
    
    private Integer id;
    private String nomprojet;
    private String codeprojet;
    private Intitule statut;
    private List<PhaseDto> phases;
    private List<IncidentDto> incident;
    private List<DepenseDto> depense;

    public static ProjetDto fromEntity(Projet projet) {
        if (projet == null) {
            return null;
        }

        return ProjetDto.builder()
                .id(projet.getId())
                .nomprojet(projet.getNomprojet())
                .codeprojet(projet.getCodeprojet())
                .statut(projet.getStatut())
                .phases(
                    projet.getPhases() != null ?
                        projet.getPhases().stream()
                                .map(phase -> PhaseDto.builder().id(phase.getId()).build()) // Mappage minimal
                                .collect(Collectors.toList()) : null
                )
                .incident(
                    projet.getIncident() != null ?
                        projet.getIncident().stream()
                                .map(IncidentDto::fromEntity)
                                .collect(Collectors.toList()) : null
                )
                .depense(
                    projet.getDepense() != null ?
                        projet.getDepense().stream()
                                .map(DepenseDto::fromEntity)
                                .collect(Collectors.toList()) : null
                )
                .build();
    }

    public static Projet toEntity(ProjetDto projetDto) {
        if (projetDto == null) {
            return null;
        }

        Projet projet = new Projet();
        projet.setId(projetDto.getId());
        projet.setNomprojet(projetDto.getNomprojet());
        projet.setCodeprojet(projetDto.getCodeprojet());
        projet.setStatut(projetDto.getStatut());
        // Ajoutez des mappages pour phases, incidents et dépenses si nécessaire
        return projet;
    }
}
