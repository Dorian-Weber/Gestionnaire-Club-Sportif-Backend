package com.mns.cda.filsrouge.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.view.AthleteView;
import com.mns.cda.filsrouge.view.EventView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vote {

    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    public static class VoteKey implements Serializable {
        @Column(name = "user_id")
        Integer userId;
        @Column(name = "event_id")
        Integer eventId;

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            VoteKey voteKey = (VoteKey) o;
            return Objects.equals(userId, voteKey.userId) && Objects.equals(eventId, voteKey.eventId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(userId, eventId);
        }
    }

    @EmbeddedId
    private VoteKey voteKey;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private AppUser user;

    @ManyToOne
    @MapsId("eventId")
    @JoinColumn(name = "event_id")
    @JsonView(AthleteView.class)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "athlete_id")
    @JsonView(EventView.class)
    private Athlete athlete;





}
