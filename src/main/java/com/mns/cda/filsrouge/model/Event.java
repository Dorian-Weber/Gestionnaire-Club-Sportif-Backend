package com.mns.cda.filsrouge.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.view.DisciplineView;
import com.mns.cda.filsrouge.view.EventView;
import com.mns.cda.filsrouge.view.SportView;
import com.mns.cda.filsrouge.view.TypeEvenementView;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(EventView.class)
    protected Integer idEvent;

    @NotBlank
    @JsonView({EventView.class,
            TypeEvenementView.class,
            SportView.class,
            DisciplineView.class})
    protected String eventName;

    @NotBlank
    @JsonView({EventView.class,
            TypeEvenementView.class,
            DisciplineView.class})
    protected String eventDescription;

    @NotNull
    @FutureOrPresent
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    @JsonView({EventView.class,
            TypeEvenementView.class,
            SportView.class,
            DisciplineView.class})
    protected LocalDateTime eventDate;

    @ManyToOne
    @JoinColumn(name = "type_evenement_id")
    @JsonView({EventView.class,
            SportView.class,
            DisciplineView.class})
    protected TypeEvenement typeEvenement;

    @ManyToOne
    @JoinColumn(name = "sport_id")
    @JsonView({EventView.class,
            TypeEvenementView.class})
    protected Sport sport;
}
