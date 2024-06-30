package com.example.GestionDeSuivi.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "phase")
public class Phase extends AbstractEntity {
    
    @Column(name = "codephase")
    private String codePhase;

    @Column(name = "nomphase")
    private String nomPhase;

    @Column(name = "etatphase")
    @Enumerated(EnumType.STRING)
    private Etat etatPhase;

    @ManyToOne
    @JoinColumn(name = "idprojet")
    private Projet projet;

    @OneToMany(mappedBy = "phase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Avancement> avancement;
}
