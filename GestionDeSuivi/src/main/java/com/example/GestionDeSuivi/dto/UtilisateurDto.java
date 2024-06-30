package com.example.GestionDeSuivi.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.GestionDeSuivi.model.Utilisateur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UtilisateurDto {
  
    private Integer id;

    private String nom;

  
    private String prenom;

   
    private String email;

 
    private String motdepasse;

   
    private String telephone;

   
    private AdresseDto adresse;

   
    private List<RolesDto> roles;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
        if (utilisateur == null) {
            return null;
        }

        return UtilisateurDto.builder()
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .email(utilisateur.getEmail())
                .motdepasse(utilisateur.getMotdepasse())
                .telephone(utilisateur.getTelephone())
                .adresse(AdresseDto.fromEntity(utilisateur.getAdresse()))
                .roles(
                    utilisateur.getRoles() != null ?
                        utilisateur.getRoles().stream()
                                .map(RolesDto::fromEntity)
                                .collect(Collectors.toList()): null
                )
                .build();
    }

    public static Utilisateur fromDto(UtilisateurDto utilisateurDto) {
        if (utilisateurDto == null) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setMotdepasse(utilisateurDto.getMotdepasse());
        utilisateur.setTelephone(utilisateurDto.getTelephone());
        utilisateur.setAdresse(AdresseDto.toEntity(utilisateurDto.getAdresse()));
        return utilisateur;
    }


}
