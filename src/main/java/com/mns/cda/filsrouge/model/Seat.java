package com.mns.cda.filsrouge.model;


import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.view.*;
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
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(SeatView.class)
    protected Integer idSeat;

    @NotBlank
    @JsonView({AppUserView.class,
            EventView.class,
            ReservationView.class,
            SeatView.class,
            LevelView.class,
            PlatformView.class})
    protected String seatNumber;

    @ManyToOne
    @JoinColumn(name = "level_id")
    @JsonView({AppUserView.class,
            EventView.class,
            ReservationView.class,
            SeatView.class})
    protected Level level;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    @JsonView({SeatView.class,
            LevelView.class,
            PlatformView.class})
    protected Reservation reservation;

}
