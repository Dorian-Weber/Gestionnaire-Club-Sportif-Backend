package com.mns.cda.filsrouge.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    protected Integer idReservation;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected LocalDateTime createdAt;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "status_presence_id", nullable = false)
    protected StatusPresence statusPresence;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    protected Event event;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "app_user_id", nullable = false)
    protected AppUser user;

    @ManyToMany
    @JoinTable(name = "reservation_seat",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "seat_id"))
    protected List<Seat> seats;

}
