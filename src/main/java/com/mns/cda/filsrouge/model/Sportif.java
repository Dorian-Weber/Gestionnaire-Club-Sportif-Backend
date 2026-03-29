package com.mns.cda.filsrouge.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sportif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idSportif;

    @Column(length = 50, nullable = false, unique = true)
    @NotBlank
    protected String nomSportif;

    @NotBlank
    protected String prenomSportif;

    @NotBlank
    protected Date dateNaissanceSportif;
}
