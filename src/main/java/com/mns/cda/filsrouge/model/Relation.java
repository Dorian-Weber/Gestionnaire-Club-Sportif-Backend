package com.mns.cda.filsrouge.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

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
        Integer FirstUserId;
        @Column(name = "second_user_id")
        Integer SecondUserId;
    }

    @EmbeddedId
    private Key key;

    @ManyToOne
    @MapsId("FirstUserId")
    @JoinColumn(name = "first_user_id")
    protected AppUser firstUser;

    @ManyToOne
    @MapsId("SecondUserId")
    @JoinColumn(name = "second_user_id")
    protected AppUser secondUser;

    @NotBlank
    protected String statusRelation;

}
