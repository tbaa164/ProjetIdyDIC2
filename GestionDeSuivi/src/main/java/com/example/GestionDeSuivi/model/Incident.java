package com.example.GestionDeSuivi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "incident")
public class Incident extends AbstractEntity{
   
    @Column(name="description")
    private String description;

    @Column(name="impact")
    private String impact;

    @Column(name = "statutincident")
    @Enumerated(EnumType.STRING)
    private Statut statutIncident;

    @ManyToOne
    @JoinColumn(name="idprojet")
    private Projet projet;

}
