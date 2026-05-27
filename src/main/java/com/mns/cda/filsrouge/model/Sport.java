package com.mns.cda.filsrouge.model;


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
    protected Integer idSport;

    @Column(length = 50, nullable = false, unique = true)
    @NotBlank
    protected String sportName;

    @OneToMany(mappedBy = "sport")
    protected List<Discipline> disciplines;

    @OneToMany(mappedBy = "sport")
    protected List<Event> events;
}
