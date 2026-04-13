package com.mns.cda.filsrouge.model;


import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.view.AppUserView;
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
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idLevel;

    @NotBlank
    @JsonView(AppUserView.class)
    protected String levelName;

    @ManyToOne
    @JoinColumn(name = "platform_id", nullable = false)
    @JsonView(AppUserView.class)
    protected Platform platform;


}
