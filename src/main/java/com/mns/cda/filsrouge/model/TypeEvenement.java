package com.mns.cda.filsrouge.model;


import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.view.DisciplineView;
import com.mns.cda.filsrouge.view.EvenementView;
import com.mns.cda.filsrouge.view.SportView;
import com.mns.cda.filsrouge.view.TypeEvenementView;
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
public class TypeEvenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(TypeEvenementView.class)
    protected Integer idTypeEvenement;

    @NotBlank
    @Column(unique = true)
    @JsonView({EvenementView.class, TypeEvenementView.class, SportView.class, DisciplineView.class})
    protected String nomTypeEvenement;

    @OneToMany(mappedBy = "typeEvenement")
    @JsonView(TypeEvenementView.class)
    protected List<Evenement> evenements;
}
