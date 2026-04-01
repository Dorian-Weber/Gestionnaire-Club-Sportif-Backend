package com.mns.cda.filsrouge.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.view.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

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
            EventTypeView.class,
            SportView.class,
            DisciplineView.class,
            Athlete.class,
            TeamView.class})
    protected String eventName;

    @NotBlank
    @JsonView({EventView.class,
            EventTypeView.class,
            DisciplineView.class})
    protected String eventDescription;

    @NotNull
    @FutureOrPresent
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonView({EventView.class,
            EventTypeView.class,
            SportView.class,
            DisciplineView.class,
            Athlete.class,
            TeamView.class})
    protected LocalDateTime eventDate;

    @ManyToOne
    @JoinColumn(name = "event_type_id")
    @JsonView({EventView.class,
            SportView.class,
            DisciplineView.class})
    protected EventType eventType;

    @ManyToOne
    @JoinColumn(name = "sport_id")
    @JsonView({EventView.class,
            EventTypeView.class})
    protected Sport sport;

    @ManyToMany
    @JoinTable(name = "event_teams",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id"))
    @JsonView({EventView.class})
    protected List<Team> teams;

    @ManyToMany
    @JoinTable(name = "event_athletes",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "athlete_id"))
    @JsonView({EventView.class})
    protected List<Athlete> athletes;


}
