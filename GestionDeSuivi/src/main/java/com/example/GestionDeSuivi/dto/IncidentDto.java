package com.example.GestionDeSuivi.dto;

import com.example.GestionDeSuivi.model.Incident;
import com.example.GestionDeSuivi.model.Statut;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IncidentDto {
   
    private Integer id;

    private String description;

    private String impact;

    private Statut statutIncident;

    private ProjetDto projet;
    public static IncidentDto fromEntity(Incident incident) {
        if (incident == null) {
            return null;
        }
        return IncidentDto.builder()
                .description(incident.getDescription())
                .impact(incident.getImpact())
                .statutIncident(incident.getStatutIncident())
                .projet(ProjetDto.fromEntity(incident.getProjet()))
                .build();
    }

    public static Incident toEntity(IncidentDto incidentDto) {
        if (incidentDto == null) {
            return null;
        }
        Incident incident = new Incident();
        incident.setDescription(incidentDto.getDescription());
        incident.setImpact(incidentDto.getImpact());
        incident.setStatutIncident(incidentDto.getStatutIncident());
        incident.setProjet(ProjetDto.toEntity(incidentDto.getProjet()));
        return incident;
    }
}
