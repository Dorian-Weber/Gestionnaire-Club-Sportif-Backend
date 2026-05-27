package com.mns.cda.filsrouge.model;


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
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idSeat;

    @NotBlank
    protected String seatNumber;

    @ManyToOne
    @JoinColumn(name = "level_id")
    protected Level level;

    @ManyToMany(mappedBy = "seats")
    protected List<Reservation> reservations;

}
