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
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idDiscipline;

    @NotBlank
    @Column(unique = true, nullable = false)
    protected String nomDiscipline;

    protected String recordEvenement;

    protected String recordMonde;

    @ManyToOne
    @JoinColumn(name = "sport_id")
    protected Sport sport;

}
