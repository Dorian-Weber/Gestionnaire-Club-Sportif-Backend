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
    @JsonView(DisciplineView.class)
    protected Integer idDiscipline;

    @NotBlank
    @Column(unique = true, nullable = false)
    @JsonView({DisciplineView.class,
            SportView.class,
            AthleteView.class})
    protected String DisciplineName;

    @JsonView(DisciplineView.class)
    protected String eventRecord;

    @JsonView(DisciplineView.class)
    protected String worldRecord;

    @ManyToOne
    @JoinColumn(name = "sport_id")
    @JsonView(DisciplineView.class)
    protected Sport sport;

    @ManyToMany
    @JoinTable(name = "athlete_disciplines",
            joinColumns = @JoinColumn(name = "discipline_id"),
            inverseJoinColumns = @JoinColumn(name = "athlete_id"))
    @JsonView(DisciplineView.class)
    protected List<Athlete> athletes;

}
