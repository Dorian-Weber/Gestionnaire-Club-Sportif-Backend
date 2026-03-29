package com.mns.cda.filsrouge.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.view.DisciplineView;
import com.mns.cda.filsrouge.view.EvenementView;
import com.mns.cda.filsrouge.view.SportView;
import com.mns.cda.filsrouge.view.TypeEvenementView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
    @JsonView(EvenementView.class)
    protected Integer idEvenement;

    @NotBlank
    @JsonView({EvenementView.class, TypeEvenementView.class, SportView.class, DisciplineView.class})
    protected String nomEvenement;

    @NotBlank
    @JsonView({EvenementView.class, TypeEvenementView.class, DisciplineView.class})
    protected String descriptionEvenement;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    @JsonView({EvenementView.class, TypeEvenementView.class, SportView.class, DisciplineView.class})
    protected LocalDateTime dateEvenement;

    @ManyToOne
    @JoinColumn(name = "type_evenement_id")
    @JsonView({EvenementView.class, SportView.class, DisciplineView.class})
    protected TypeEvenement typeEvenement;

    @ManyToOne
    @JoinColumn(name = "sport_id")
    @JsonView({EvenementView.class, TypeEvenementView.class})
    protected Sport sport;
}
