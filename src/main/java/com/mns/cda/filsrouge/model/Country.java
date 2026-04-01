package com.mns.cda.filsrouge.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.view.CountryView;
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
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(CountryView.class)
    protected Integer idCountry;

    @NotBlank
    @JsonView({CountryView.class,})
    protected String countryName;
}
