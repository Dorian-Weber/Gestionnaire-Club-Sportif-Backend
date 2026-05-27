package com.mns.cda.filsrouge.model;

import com.mns.cda.filsrouge.enumerate.RelationStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
public class Relation {

    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Key implements Serializable {
        @Column(name = "first_user_id")
        Integer firstUserId;
        @Column(name = "second_user_id")
        Integer secondUserId;

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Objects.equals(firstUserId, key.firstUserId) && Objects.equals(secondUserId, key.secondUserId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstUserId, secondUserId);
        }
    }

    @EmbeddedId
    private Key key;

    @ManyToOne
    @MapsId("firstUserId")
    @JoinColumn(name = "first_user_id")
    protected AppUser firstUser;

    @ManyToOne
    @MapsId("secondUserId")
    @JoinColumn(name = "second_user_id")
    protected AppUser secondUser;

    @NotNull
    @Enumerated(EnumType.STRING)
    protected RelationStatus relationStatus;

}
