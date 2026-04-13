package com.mns.cda.filsrouge.model;


import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.view.*;
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
    @JsonView(PlatformView.class)
    protected Integer idPlatform;

    @NotBlank
    @JsonView({AppUserView.class,
            EventView.class,
            ReservationView.class,
            SeatView.class,
            LevelView.class,
            PlatformView.class})
    protected String platformName;

    @OneToMany(mappedBy = "platform")
    @JsonView(PlatformView.class)
    protected List<Level> levels;
}
