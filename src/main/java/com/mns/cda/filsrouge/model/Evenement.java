package com.mns.cda.filsrouge.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idEvenement;

    @NotBlank
    protected String nomEvenement;

    @NotBlank
    protected String descriptionEvenement;

    @NotBlank
    protected String dateEvenement;
}
