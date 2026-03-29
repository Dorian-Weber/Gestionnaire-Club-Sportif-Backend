package com.mns.cda.filsrouge.model;


import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.view.DisciplineView;
import com.mns.cda.filsrouge.view.EvenementView;
import com.mns.cda.filsrouge.view.SportView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(SportView.class)
    protected Integer idSport;

    @Column(length = 50, nullable = false, unique = true)
    @NotBlank
    @JsonView({SportView.class,DisciplineView.class, EvenementView.class})
    protected String nomSport;

    @OneToMany(mappedBy = "sport")
    @JsonView(SportView.class)
    List<Discipline> disciplines;

    @OneToMany(mappedBy = "sport")
    @JsonView(SportView.class)
    List<Evenement> evenements;
}
