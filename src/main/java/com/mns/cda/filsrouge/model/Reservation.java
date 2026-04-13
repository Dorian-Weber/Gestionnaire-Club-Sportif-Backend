package com.mns.cda.filsrouge.model;


import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.view.AppUserView;
import com.mns.cda.filsrouge.view.EventView;
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
    protected Integer idReservation;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "status_presence_id", nullable = false)
    @JsonView({AppUserView.class, EventView.class})
    protected StatusPresence statusPresence;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    @JsonView(AppUserView.class)
    protected Event event;

    @ManyToOne
    @JoinColumn(name = "app_user_id", nullable = false)
    @JsonView(EventView.class)
    protected AppUser user;

    @OneToMany(mappedBy = "reservation")
    @JsonView({AppUserView.class, EventView.class})
    protected List<Seat> seats;

}
