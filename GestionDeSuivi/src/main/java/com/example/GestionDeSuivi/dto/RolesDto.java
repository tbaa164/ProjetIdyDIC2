package com.example.GestionDeSuivi.dto;


import com.example.GestionDeSuivi.model.Roles;
import com.example.GestionDeSuivi.model.Utilisateur;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolesDto {
    
    private Integer id;

    private String roleName;

    @JsonIgnore
    private UtilisateurDto utilisateur;
    public static RolesDto fromEntity(Roles roles) {
        if (roles == null) {
            return null;
        }

        return RolesDto.builder()
                .roleName(roles.getRoleName())
                .build();
    }

    public static Roles toEntity(RolesDto rolesDto) {
        if (rolesDto == null) {
            return null;
        }

        Roles roles = new Roles();
        roles.setRoleName(rolesDto.getRoleName());
        roles.setUtilisateur(UtilisateurDto.toEntity(rolesDto.getUtilisateur()));
        return roles;
    }
}
