package com.example.GestionDeSuivi.dto;

import com.example.GestionDeSuivi.model.Depense;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepenseDto {

    private Integer id;

    private double montant;

     private ProjetDto projet;
    public static DepenseDto fromEntity(Depense depense) {
        if (depense == null) {
            return null;
        }

        return DepenseDto.builder()
                .montant(depense.getMontant())
                .projet(ProjetDto.fromEntity(depense.getProjet()))
                .build();
    }

    public static Depense toEntity(DepenseDto depenseDto) {
        if (depenseDto == null) {
            return null;
        }

        Depense depense = new Depense();
        depense.setMontant(depenseDto.getMontant());
        depense.setProjet(ProjetDto.toEntity(depenseDto.getProjet()));
        return depense;
    }
}
