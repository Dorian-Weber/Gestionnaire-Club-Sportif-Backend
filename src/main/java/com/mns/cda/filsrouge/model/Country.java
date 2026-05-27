package com.mns.cda.filsrouge.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.view.AthleteView;
import com.mns.cda.filsrouge.view.CountryView;
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
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idCountry;

    @NotBlank
    protected String countryName;

    @OneToMany(mappedBy = "country")
    protected List<Athlete> athletes;
}
