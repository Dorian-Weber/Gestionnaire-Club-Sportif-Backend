package com.mns.cda.filsrouge.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class StatusPresence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idStatusPresence;

    @NotBlank
    protected String StatusPresenceName;


}
