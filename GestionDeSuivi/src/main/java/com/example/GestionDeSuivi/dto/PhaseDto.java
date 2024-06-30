package com.example.GestionDeSuivi.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.GestionDeSuivi.model.Etat;
import com.example.GestionDeSuivi.model.Phase;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhaseDto {
    
    private Integer id;
    private String nomPhase;
    private String codePhase;
    private Etat etatPhase;
    // private ProjetDto projet; sokhla woumako pour l'instant
    private List<AvancementDto> avancement;

    public static PhaseDto fromEntity(Phase phase) {
        if (phase == null) {
            return null;
        }

        return PhaseDto.builder()
                .id(phase.getId())
                .nomPhase(phase.getNomPhase())
                .codePhase(phase.getCodePhase())
                .etatPhase(phase.getEtatPhase())
                // .projet(
                //     phase.getProjet() != null ?
                //         ProjetDto.builder().id(phase.getProjet().getId()).build() : null // Mappage minimal
                // )
                .avancement(
                    phase.getAvancement() != null ?
                        phase.getAvancement().stream()
                                .map(AvancementDto::fromEntity)
                                .collect(Collectors.toList()) : null
                )
                .build();
    }

    public static Phase toEntity(PhaseDto phaseDto) {
        if (phaseDto == null) {
            return null;
        }
    
        Phase phase = new Phase();
        phase.setId(phaseDto.getId());
        phase.setNomPhase(phaseDto.getNomPhase());
        phase.setCodePhase(phaseDto.getCodePhase());
        phase.setEtatPhase(phaseDto.getEtatPhase());
        // Ajoutez les avancements à la phase
        if (phaseDto.getAvancement() != null) {
            phase.setAvancement(
                phaseDto.getAvancement().stream()
                    .map(AvancementDto::toEntity)
                    .collect(Collectors.toList())
            );
        }
    
        return phase;
    }
    
    
}
