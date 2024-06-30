package com.example.GestionDeSuivi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "depense")
public class Depense extends AbstractEntity {
    @Column(name = "montant")
    private double montant;
 
     @ManyToOne
    @JoinColumn(name="idprojet")
    private Projet projet;

    


}
