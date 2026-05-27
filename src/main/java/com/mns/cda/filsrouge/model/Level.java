package com.mns.cda.filsrouge.model;


import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.view.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class Level {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        protected Integer idLevel;

        @NotBlank
        protected String levelName;

        @OneToMany(mappedBy = "level")
        protected List<Seat> seats;


        @NotNull
        @ManyToOne
        @JoinColumn(name = "platform_id", nullable = false)
        protected Platform platform;


}
