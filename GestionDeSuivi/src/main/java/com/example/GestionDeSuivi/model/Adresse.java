package com.example.GestionDeSuivi.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
@Embeddable
@Getter
@Setter
public class Adresse implements Serializable {

    @Column(name= "adresse1")
    private String adresse1;

    @Column(name="adresse2")
    private String adresse2;

    @Column(name="ville")
    private String ville;
}
