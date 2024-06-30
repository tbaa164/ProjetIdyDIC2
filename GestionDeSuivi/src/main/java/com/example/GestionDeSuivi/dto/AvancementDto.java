package com.example.GestionDeSuivi.dto;

import com.example.GestionDeSuivi.model.Avancement;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AvancementDto {

    private Integer id;
    private String avancementReel;
    private String avancementPrevu;
    private String pourcentageAvancement;
    private PhaseDto phase;

    public static AvancementDto fromEntity(Avancement avancement) {
        if (avancement == null) {
            return null;
        }
        return AvancementDto.builder()
                .id(avancement.getId())
                .avancementReel(avancement.getAvancementReel())
                .avancementPrevu(avancement.getAvancementPrevu())
                .pourcentageAvancement(avancement.getPourcentageAvancement())
                .phase(
                    avancement.getPhase() != null ?
                        PhaseDto.builder().id(avancement.getPhase().getId()).build() : null // Mappage minimal
                )
                .build();
    }

    public static Avancement toEntity(AvancementDto avancementDto) {
        if (avancementDto == null) {
            return null;
        }
        Avancement avancement = new Avancement();
        avancement.setId(avancementDto.getId());
        avancement.setAvancementReel(avancementDto.getAvancementReel());
        avancement.setAvancementPrevu(avancementDto.getAvancementPrevu());
        avancement.setPourcentageAvancement(avancementDto.getPourcentageAvancement());
        // Laissez la phase non mappée ici, elle sera mappée dans ProjetServiceImpl
        return avancement;
    }
    
    
}
