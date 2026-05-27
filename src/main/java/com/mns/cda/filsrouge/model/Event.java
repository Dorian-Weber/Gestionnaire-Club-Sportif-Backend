package com.mns.cda.filsrouge.model;


import com.fasterxml.jackson.annotation.JsonFormat;
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
    protected Integer idEvent;

    @NotBlank
    protected String eventName;

    @NotBlank
    protected String eventDescription;

    @NotNull
    @FutureOrPresent
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    protected LocalDateTime eventDate;

    @ManyToOne
    @JoinColumn(name = "event_type_id")
    protected EventType eventType;

    @ManyToOne
    @JoinColumn(name = "sport_id")
    protected Sport sport;

    @ManyToMany(mappedBy = "events")
    protected List<Team> teams;

    @ManyToMany
    @JoinTable(name = "event_athletes",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "athlete_id"))
    protected List<Athlete> athletes;

    @OneToMany(mappedBy = "event")
    protected List<Vote> votes;

    @OneToMany(mappedBy = "event")
    protected List<Reservation> reservations;


}
