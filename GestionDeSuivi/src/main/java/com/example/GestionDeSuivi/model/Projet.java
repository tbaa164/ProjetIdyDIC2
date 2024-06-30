package com.example.GestionDeSuivi.model;

import java.util.Date;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "projet")
public class Projet extends AbstractEntity {

    @Column(name = "codeprojet")
    private String codeprojet;

    @Column(name = "nomprojet")
    private String nomprojet;

    @Column(name = "statut")
    @Enumerated(EnumType.STRING)
    private Intitule statut;

    @Column(name = "datedebut")
    private Date datedebut;

    @Column(name = "datefin")
    private Date datefin;

    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phase> phases;

    @OneToMany(mappedBy = "projet")
    private List<Incident> incident;

    @OneToMany(mappedBy = "projet")
    private List<Depense> depense;
}
