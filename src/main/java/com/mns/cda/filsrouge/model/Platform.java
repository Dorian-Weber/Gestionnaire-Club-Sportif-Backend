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
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idPlatform;

    @NotBlank
    protected String platformName;

    @OneToMany(mappedBy = "platform")
    protected List<Level> levels;
}
