package com.mns.cda.filsrouge.model;


import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.view.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(ReservationView.class)
    protected Integer idReservation;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    @JsonView(ReservationView.class)
    protected LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "status_presence_id", nullable = false)
    @JsonView({AppUserView.class,
            EventView.class,
            ReservationView.class})
    protected StatusPresence statusPresence;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    @JsonView({AppUserView.class,
            ReservationView.class,
            SeatView.class,
            LevelView.class,
            PlatformView.class})
    protected Event event;

    @ManyToOne
    @JoinColumn(name = "app_user_id", nullable = false)
    @JsonView({EventView.class,
            ReservationView.class,
            SeatView.class})
    protected AppUser user;

    @ManyToMany
    @JoinTable(name = "reservation_seat",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "seat_id"))
    @JsonView({AppUserView.class,
            EventView.class,
            ReservationView.class})
    protected List<Seat> seats;

}
