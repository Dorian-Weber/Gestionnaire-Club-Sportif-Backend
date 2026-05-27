package com.mns.cda.filsrouge.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idAthlete;

    @Column(length = 50, nullable = false)
    @NotBlank
    protected String athleteName;

    @NotBlank
    protected String athleteFirstName;

    @NotNull
    @Past
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected LocalDate athleteBirthDate;

    @ManyToMany
    @JoinTable(name = "event_athletes",
            joinColumns = @JoinColumn(name = "athlete_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    protected List<Event> events;

    @ManyToMany
    @JoinTable(name = "team_athletes",
            joinColumns = @JoinColumn(name ="athlete_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id"))
    protected List<Team> teams;

    @ManyToMany
    @JoinTable(name = "athlete_disciplines",
            joinColumns = @JoinColumn(name = "athlete_id"),
            inverseJoinColumns = @JoinColumn(name = "discipline_id"))
    protected List<Discipline> disciplines;

    @ManyToOne
    @JoinColumn(name = "country_id")
    protected Country country;

    @OneToMany(mappedBy = "athlete")
    protected List<Vote> votes;

}
