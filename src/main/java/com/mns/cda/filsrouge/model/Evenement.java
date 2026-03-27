package com.mns.cda.filsrouge.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

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
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    protected LocalDateTime dateEvenement;
}
