package com.mns.cda.filsrouge.model;


import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.view.AppUserView;
import com.mns.cda.filsrouge.view.EventView;
import com.mns.cda.filsrouge.view.ReservationView;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class StatusPresence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idStatusPresence;

    @NotBlank
    @JsonView({AppUserView.class,
            EventView.class,
            ReservationView.class})
    protected String statusPresenceName;


}
