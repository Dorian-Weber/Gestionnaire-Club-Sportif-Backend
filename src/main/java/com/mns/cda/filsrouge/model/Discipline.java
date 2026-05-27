package com.mns.cda.filsrouge.model;


import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.view.AthleteView;
import com.mns.cda.filsrouge.view.DisciplineView;
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
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idDiscipline;

    @NotBlank
    @Column(unique = true, nullable = false)
    protected String disciplineName;

    protected String eventRecord;

    protected String worldRecord;

    @ManyToOne
    @JoinColumn(name = "sport_id")
    protected Sport sport;

    @ManyToMany
    @JoinTable(name = "athlete_disciplines",
            joinColumns = @JoinColumn(name = "discipline_id"),
            inverseJoinColumns = @JoinColumn(name = "athlete_id"))
    protected List<Athlete> athletes;

}
