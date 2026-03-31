package com.mns.cda.filsrouge.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Participation {
// Table associative entre Athlete et Event, avec une clé composite (athlete_id, event_id)
    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Key implements Serializable {
        @Column(name = "athlete_id")
        Integer Athleteid;
        @Column(name = "event_id")
        Integer Eventid;
    }

    @EmbeddedId
    private Key key;

    @ManyToOne
    @MapsId("Athleteid")
    @JoinColumn(name = "athlete_id")
    protected Athlete athlete;

    @ManyToOne
    @MapsId("Eventid")
    @JoinColumn(name = "event_id")
    protected Event event;
}
