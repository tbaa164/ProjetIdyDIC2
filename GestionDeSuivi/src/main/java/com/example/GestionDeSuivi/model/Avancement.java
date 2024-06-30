package com.example.GestionDeSuivi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "avancement")
@Getter
@Setter
public class Avancement extends AbstractEntity {
    

    
    @Column(name="avancementreel")
    private String avancementReel;

    @Column(name="avancementprevu")
    private String avancementPrevu;

    @Column(name="pourcentageavancement")
    private String pourcentageAvancement;

    @ManyToOne
    @JoinColumn(name="idphase")
    private Phase phase;


}
